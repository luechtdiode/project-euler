package ch.seidel.euler

import scala.annotation.tailrec

object Problem26 {

  case class Fraction(numerator: Long, denominator: Long, visual: String, recurringCycle: String)
  
  /**
   * general poor & simple high-school-approach:
   * 1 / 7         = 0.        | n * 10
   * 10 / 7        = 0.1       | 1 * 7 = 7, 10 - 7 = 3   => write 1, keep rest 3
   *  3 / 7        = 0.1       | n * 10
   *  30 / 7       = 0.14      | 4 * 7 = 28, 30 - 28 = 2 => write 4, keep rest 2
   *   2 / 7       = 0.14      | n * 10
   *   20 / 7      = 0.142     | 2 * 7 = 14, 20 - 14 = 6 => write 2, keep rest 6
   *    6 / 7      = 0.142     | n * 10
   *    60 / 7     = 0.1428    | 8 * 7 = 56, 60 - 56 = 4 => write 8, keep rest 4
   *     4 / 7     = 0.1428    | n * 10
   *     40 / 7    = 0.14285   | 5 * 7 = 35, 40 - 35 = 5 => write 5, keep rest 5
   *      5 / 7    = 0.14285   | n * 10
   *      50 / 7   = 0.142857  | 7 * 7 = 49, 50 - 49 = 1 => write 7, keep rest 1
   *       1 / 7   = ........  | recognize, there is a repetition
   */
  def wrap(numerator: Long, denominator: Long): Fraction = {
    @tailrec
    def div(n: Long, d: Long, result: String, fracts: List[Long]): Fraction = {
      if(n < d) {
        if(fracts.isEmpty && result.isEmpty()) 
          div(n * 10, d, "0.", fracts)
        else
          div(n * 10, d, result + "0", fracts)
      }
      else if(fracts.contains(n)) {
        val idx = result.length() - (fracts.length - fracts.indexOf(n))
        val period = result.drop(idx)
        Fraction(numerator, denominator, result.take(idx) + "(" + period + ")*", period)
      }
      else { 
        val rest = n % d
        val digit = (n / d).toString
        if(rest == 0) 
          Fraction(numerator, denominator, result + digit, "")
        else if(result.isEmpty && fracts.isEmpty) 
          div(rest * 10, d, digit + ".", fracts :+ n)
        else 
          div(rest * 10, d, result + digit, fracts :+ n)
      }
    }
    
    div(numerator, denominator, "", List.empty)
  }

  def findWithLongestRecurringCycle(upperbound: Int): Fraction = {
    val list = for(i <- 2 to upperbound) yield wrap(1, i)
    list.sortBy(_.recurringCycle.length()).last
  }
  
  def main(args: Array[String]) {
    println(findWithLongestRecurringCycle(1000))
  }
}