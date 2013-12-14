package ch.seidel.euler

import scala.math.BigInt.int2bigInt

/**
 * Amicable numbers
 * Problem 21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which 
 * divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each 
 * of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 
 *   1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
 * therefore d(220) = 284. The proper divisors of 284 are 
 *   1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 */
object Problem21 {
  
  /**
   * Let d(n) be defined as the sum of proper divisors of n (numbers less 
   * than n which divide evenly into n).
   */
  def d(n: Int) = {
    if(n == 1) 1 
    else      (1 to n/2).foldLeft(0)((sum, d) => if(n % d == 0) sum + d else sum)
  }
  
  /**
   * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and 
   * each of a and b are called amicable numbers.
   */
  def isAmicableNumber(a: Int): Boolean = {
    val b = d(a)
    a != b && d(b) == a
  }
  
  def amicalbleNumbers(scope: Int) = (1 until scope) filter isAmicableNumber
    
  def solve(value: Int) = amicalbleNumbers(value).sum
}