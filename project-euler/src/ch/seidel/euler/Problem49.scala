package ch.seidel.euler

import scala.annotation.tailrec

object Problem49 {
  
  /**
   * Creates a stream of integers between from and to (ascending and inclusive)
   * @param from first Integer in the Stream
   * @param to last Integer in the Stream
   * @return Stream of Integers in the Range (from..to)
   */
  def between(from: Int, to: Int):Stream[Int] =
    if(from >= to) Stream(from) else from #:: between(from + 1, to)
  
  /**
   * @param n number to validate
   * @return true if n is a prime-number
   */
  def isPrime(n: Int) = {
    if(n < 2) false
    else if(n == 2) true
    else if(n > 2 && (n % 2 == 0)) false
    else (3 to math.sqrt(n.toDouble).toInt by 2) forall(n % _ != 0)
  }

  /**
   * Creates a Stream of prime-numbers
   * @param s Stream of Integers
   * @return Stream of prime-numbers
   */
  def primes(s: Stream[Int]): Stream[Int] = {
    if(s.isEmpty) Stream.empty
    else s.head #:: primes(s.tail filter(isPrime(_)))
  }
  
  /**
   * Translates the number to an List of Digits
   * @param n number to transform
   * @return List of digits from the given number
   */
  def digitsOf(n: Int): List[Int] = {
    if(n > 9) {
      val d = n % 10
      d +: digitsOf(n / 10)
    }
    else List(n)
  }

  /**
   * @param one a number to compare with the other number
   * @param other a number to compare wit the one number
   * @return true, if both numbers do have the same digits (ordering is ignored)
   */
  def equalDigits(one: Int, other: Int) = {
    digitsOf(one).sorted == digitsOf(other).sorted
  }
  
  /**
   * Solves the Problem 49
   */
  def solve: String = {
    /**
     * Searches recursive for three prime numbers with the given distance
     * @param one the first prime number
     * @param distance the distance between the searched prime-numbers
     * @return all concatenated digits of the three prime-numbers or a empty string if not found.
     */
    def findThreePrimes(one: Int, distance: Int): String = { 
      @tailrec
      def _findThreePrimes(one: Int, level: Int, digits: String): String = { 
        val next = one + distance
        if(isPrime(next) && equalDigits(one, next)) {
          val newdigits = digits + next.toString
          if(level < 2) 
            _findThreePrimes(next, level + 1, newdigits)
          else newdigits
        }
        else ""
      }
      _findThreePrimes(one, 1, one.toString)
    }
    
    val distance = 3330
    (primes(between(1000, 9999)) map(findThreePrimes(_, distance)) filter(_.length > 0)).last
  }    
  
}