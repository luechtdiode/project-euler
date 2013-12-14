package ch.seidel.euler

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.<br>
 * (see Problem13Test.scala)
 */
object Problem13 {
  
  /** 
   * Solves the Problem.
   * @param data List of Strings. Each Item holds one of the one-hundred 50-digit numbers.
   * @return the first ten digits of the sum of all numbers, given by the data-parameter.
   */
  def solve(data: List[String]) = 
    data.foldLeft(math.BigInt(0))((sum, s) => sum + math.BigInt(s.trim())).toString.take(10)
}