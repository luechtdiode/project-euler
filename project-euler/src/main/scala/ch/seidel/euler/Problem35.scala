package ch.seidel.euler

import scala.annotation.tailrec
import scala.collection.Iterator

/**
 * Circular primes
 * Problem 35
 * 
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 */
object Problem35 {
  // helpers
  def digitsOfValue(n: BigInt): List[Int] = 
    if(n > 9) digitsOfValue(n / 10) :+ (n % 10).toInt else List(n.toInt)
    
  def valueOfDigits(d: List[Int]): Int = 
    d.foldLeft(0)((product, n) => product * 10 + n)

  def digitRotations(n: Int) = {
    val digits = digitsOfValue(n)
    
    def rotate(start: Int) = 
      (start to start + digits.size-1).toList map (d => digits(d % digits.size))
    
    (1 to digits.size).map(start => valueOfDigits(rotate(start))).toSet
  }
  
  def isPrime(n: Int) =
    if(n < 2) false
    else if(n == 2) true
    else if(n > 2 && (n % 2 == 0)) false
    else (3 to math.sqrt(n.toDouble).toInt by 2) forall(n % _ != 0)
  
  def isCircularPrime(n: Int) = 
    digitRotations(n).forall(isPrime)
  
  def solve(below: Int) = 
    Iterator.range(2, below) filter isCircularPrime

}