package ch.seidel.euler

import scala.annotation.tailrec
import scala.collection.Iterator

/**
 * Digit factorials
 * Problem 34
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
object Problem34 {
  // helpers
  def factorial(d: Int): Int = if(d < 1) 1 else d * factorial(d-1)
  val digitFactorials = (0 to 9) map factorial
  val sumOfFacts = digitFactorials.sum
  
  def sumOfDigitFacts(n: Int): Long = 
    if(n > 9) sumOfDigitFacts(n / 10) + digitFactorials(n % 10) 
    else      digitFactorials(n)
  
  def isCurious(n: Int) = n == sumOfDigitFacts(n)
  
  //https://en.wikipedia.org/wiki/Factorion (upper bound = 1,854,721)
  //https://oeis.org/A014080
  def solve = {
    (10 to sumOfFacts).filter(isCurious).sum   
  }

}