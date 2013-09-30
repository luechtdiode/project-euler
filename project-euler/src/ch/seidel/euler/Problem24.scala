package ch.seidel.euler

import scala.annotation.tailrec

/**
 * Lexicographic permutations
 * Problem 24
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible 
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed 
 * numerically or alphabetically, we call it lexicographic order. 
 * 
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the 
 * digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
object Problem24 {
  val startDigits = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  
  def factorial(n: Int): Int = 
    if(n > 0) n * factorial(n-1) else 1

  @tailrec
  def lexicalPermutations(acc: String, digits: List[Int], reminder: Long): String = {
    println(acc + digits.mkString("[", " ", "]"))
    if(digits.isEmpty) 
      acc
    else {
      val p = digits.size-1
      val f = factorial(p)
      val (index, value, k) = (0 to p).map(i => (i, digits(i), i * f)).filter {case (_,_,k) => k < reminder}.last
      val rest = reminder - k
      println(reminder + " = " + index + "(" + p + "!) + " + rest)
      
      lexicalPermutations(acc + value, digits.take(index) ::: digits.drop(index+1), rest)
    }
  }
  
  def solve(n: Long) = lexicalPermutations("", startDigits, n)
}