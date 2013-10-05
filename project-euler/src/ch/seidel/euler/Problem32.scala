package ch.seidel.euler

import scala.annotation.tailrec

/**
 * Pandigital products
 * Problem 32
 * 
 * We shall say that an n-digit number is pandigital if it makes use of 
 * all the digits 1 to n exactly once; for example, the 5-digit number, 
 * 15234, is 1 through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, 
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product 
 * identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure 
 *       to only include it once in your sum.
 */
object Problem32 {
  
  def digitsOf(n: Int): List[Int] = {
    if(n > 9) 
      digitsOf(n / 10) :+ (n % 10).toInt
    else 
      List(n.toInt)
  }

  def valueOfDigits(d: List[Int]): Int = d.foldLeft(0)((product, n) => product * 10 + n)
    
  @tailrec
  def isPandigital(m1: List[Int], m2: List[Int], rest: List[Int]): Int = {
    if(rest.isEmpty)
      0
    else {
      val r = valueOfDigits(rest)
      val p = valueOfDigits(m1) * valueOfDigits(m2)
      if(p == r) { 
        //println("Found: " + m1.mkString("[",",","]") + " * " + m2.mkString("[",",","] = " + p))
        p
      }
      else {
        if(rest.size > 1) {
          isPandigital(m1, m2 :+ rest.head, rest.tail) 
        }
        else {
          val newrest = m2.tail ::: rest
          isPandigital(m1 :+ m2.head, newrest.take(1), newrest.drop(1)) 
        }
      }
    }
  }
  
  def solve(digits: Set[Int]) = 
    if(digits.size > 2)
      digits.toList.permutations.map(l => 
        isPandigital(l.take(1), l.drop(1).take(1), l.drop(2))
      ).toSet sum
    else
      0
}