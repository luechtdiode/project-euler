package ch.seidel.euler

import scala.annotation.tailrec
import scala.collection.Iterator

/**
 * Double-base palindromes
 * Problem 36
 * 
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * 
 */
object Problem36 {
  // helpers
  def digitsOfValue(n: Int): List[Int] = 
    if(n > 9) digitsOfValue(n / 10) :+ (n % 10).toInt else List(n.toInt)
    
  def valueOfDigits(d: List[Int]): Int = 
    d.foldLeft(0)((product, n) => product * 10 + n)

  def convertToBase2(n: Int): List[Char] = {
    n.toBinaryString.to
  }
  
  def isPalindrome(digits: List[Any]): Boolean = digits == digits.reverse
  def isPalindrome(number: Int): Boolean = isPalindrome(digitsOfValue(number))
  
  def isPalindromic(n: Int) =
    isPalindrome(n) && isPalindrome(convertToBase2(n))
  
  def solve(below: Int) = 
    Iterator.range(1, below).filter(isPalindromic).sum

}