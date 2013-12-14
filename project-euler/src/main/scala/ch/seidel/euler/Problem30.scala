package ch.seidel.euler

/**
 * Digit fifth powers
 * Problem 30
 * 
 * Surprisingly there are only three numbers that can be written as the 
 * sum of fourth powers of their digits:
 * 
 *     1634 = 14 + 64 + 34 + 44
 *     8208 = 84 + 24 + 04 + 84
 *     9474 = 94 + 44 + 74 + 44
 * 
 * As 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the 
 * sum of fifth powers of their digits.
 * 
 */
object Problem30 {
  
  def digitsOf(n: BigInt): List[Int] = 
    if(n > 9) 
      digitsOf(n / 10) :+ (n % 10).toInt
    else 
      List(n.toInt)
  
  def sumOfPowers(n: Int, e: IndexedSeq[Int]): Int = 
    if(n == digitsOf(n).map(x => e(x)).sum) 
      n
    else 
      0
  
  def pow(n: Int, e: Int): Int = (1 to e).foldLeft(1)((product, _) => product * n)
  
  def upperBound(n: Int) = (n+1) * pow(9, n)
  
  def solve(e: Int) = {
    val powers = (0 to 9) map(n => pow(n, e))
    (2 to upperBound(e)).foldLeft(0)((sum, n) => sum + sumOfPowers(n, powers))
  }
}