package ch.seidel.euler

/**
 * Power digit sum.<br>
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 */
object Problem16 {
  
  /**
   * Translates the number to an List of Digits
   * @param n number to transform
   * @return List of digits from the given number
   */
  def digitsOf(n: BigInt): List[Int] = {
    if(n > 9) 
      digitsOf(n / 10) :+ (n % 10).toInt
    else 
      List(n.toInt)
  }
  
  def solve(potenz: Int): Long = digitsOf(BigInt(2).pow(potenz)).sum
  
}