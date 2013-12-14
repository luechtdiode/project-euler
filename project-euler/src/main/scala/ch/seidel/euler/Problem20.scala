package ch.seidel.euler

import scala.math.BigInt.int2bigInt

/**
 * Factorial digit sum
 * Problem 20
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 */
object Problem20 {
  def digitsOf(n: BigInt): List[Int] = {
    if(n > 9) 
      digitsOf(n / 10) :+ (n % 10).toInt
    else 
      List(n.toInt)
  }
  def factorial(n: Int): BigInt = 
    if(n > 0) n * factorial(n-1) else 1

  def solve(value: Int) = digitsOf(factorial(value)).sum
}