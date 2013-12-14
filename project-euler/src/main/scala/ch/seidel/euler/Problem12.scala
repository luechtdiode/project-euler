package ch.seidel.euler

import scala.annotation.tailrec

object Problem12 {
  /**
   * Event enumeration
   */ 
  sealed trait Action
  case class Take(value: Int)         extends Action
  case class Next(triangle: Triangle) extends Action
  case class Cancel(reason: Int)      extends Action
  
  /**
   * Triangle domain
   */
  case class Triangle(index: Int, value: Int) {
    def next = Triangle(index + 1, value + index + 1)
  }
  object Triangle {
    /**
     * Convenience-constructor
     */
    def apply(index: Int): Triangle = 
      Triangle(index, valueOf(index))
    
    /**
     * @param condition Delegate-function for the next Action with a 
     *        given Triangle in the search-process.
     * @return value of the triangle-number that matches the condition
     *        with Action Take.
     */
    def valueBy(condition: Triangle => Action) = {
      @tailrec
      def seekFrom(last: Triangle): Int = condition(last) match {
        case Take(value)    => value
        case Next(triangle) => seekFrom(triangle)
        case Cancel(reason) => reason
      }
        
      seekFrom(Triangle(0, 0)) 
    }
    
    /**
     * @param target Index of the triangle-number.
     * @return value of the triangle-number at the given index.
     */
    def valueOf(target: Int) = target * (target + 1) / 2
  }
  
  /**
   * Computes the amount of divisors of the given value.
   * @param value Any positive number.
   * @return amount of divisors.
   */
  def divisors(value: Int) = if(value == 1) 1 else
    (1 to math.sqrt(value.toDouble).toInt).foldLeft(0)((cnt, n) => 
      if(value % n == 0) cnt + 1 else cnt) * 2

  /**
   * Computes the first triangle's value with the given amount of divisors.
   * @param divcnt Amount of divisors for the asked triangle-value.
   * @return first triangle's value with the given amount of divisors.
   *         If there's no triangle with the given amount of divisors, it returns 0.
   */
  def firstTriangleWithDivisors(divcnt: Int) = 
    Triangle.valueBy(t => divisors(t.value) match {
      case d if d >  divcnt => Cancel(0)
      case d if d == divcnt => Take(t.value)
      case d                => Next(t.next)
    })

  /**
   * Finds the first triangle's value with more than <code>divcnt</code> 
   * amount of divisors.
   * @param divcnt Amount of divisors for the asked triangle-value.
   * @return first triangle's value with more than the given amount of divisors.
   */
  def findTriangle(divcnt: Int): Int =
    Triangle.valueBy(t => divisors(t.value) match {
      case d if d > divcnt => Take(t.value)
      case _               => Next(t.next)
    })
}