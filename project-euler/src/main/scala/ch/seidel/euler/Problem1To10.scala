package ch.seidel.euler

import scala.annotation.tailrec

object Problem1To10 {
  
  def isPrime(n: Long) = {
    if(n < 2) false
    else if(n == 2) true
    else if(n > 2 && (n % 2 == 0)) false
    else (3 to math.sqrt(n.toDouble).toInt by 2) forall(n % _ != 0)
  }
  lazy val primes = {
    def nextPrime(from: Long) = {
      Iterator.iterate(from + 2)(_ + 2).find(isPrime(_)).get
    }
    2 #:: Stream.iterate(3L)(nextPrime(_))
  }

  def ggt(a: Long, b: Long): Long = {
    if (b == 0) a
    else ggt(b, a % b)
  }
  
  def kgv(a: Long, b: Long): Long = {
    (a * b) / ggt(a, b)
  }
  
  lazy val fibonaccis: Stream[Int] = { 
    def _fib(a: Int, b: Int): Stream[Int] = b #:: _fib(b, a + b)
    _fib(1, 1)
  }

  def digitsOf(n: Long): List[Int] = {
    if(n > 9)
      digitsOf(n / 10) :+ (n % 10).toInt
    else 
      List(n.toInt)
  }

  /**
   * Multiples of 3 and 5
   * If we list all the natural numbers below 10 that are 
   * multiples of 3 or 5, we get 3, 5, 6 and 9. 
   * The sum of these multiples is 23.
   * Find the sum of all the multiples of 3 or 5 below 1000.
   */
  def problem1 = (1 until 1000) filter(n => n % 3 == 0 || n % 5 == 0) sum
  
  /**
   * Even Fibonacci numbers
   * Each new term in the Fibonacci sequence is generated by adding 
   * the previous two terms. By starting with 1 and 2, the first 10 
   * terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
   *
   * By considering the terms in the Fibonacci sequence whose values do 
   * not exceed four million, find the sum of the even-valued terms.
   */
  def problem2 = {
    fibonaccis filter(_ % 2 == 0) takeWhile(_ <= 4000000) sum
  }

  /**
   * Largest prime factor
   * The prime factors of 13195 are 5, 7, 13 and 29.
   * What is the largest prime factor of the number 600851475143 ?
   */
  def problem3 = {
    val bignumber = 600851475143d
    //(1l to math.sqrt(bignumber).toLong) filter(bignumber % _ == 0) filter isPrime max
    (math.sqrt(bignumber).toLong to 1l by -1l).toStream filter(bignumber % _ == 0) find isPrime get
  }
  
  /**
   * Largest palindrome product
   * A palindromic number reads the same both ways. The largest palindrome 
   * made from the product of two 2-digit numbers is 9009 = 91 × 99.
   * Find the largest palindrome made from the product of two 3-digit 
   * numbers.
   */
  def problem4 = {
    def isPalindrome(number: Int) = {
      val digits = digitsOf(number)
      digits == digits.reverse
    }
    val products = for (d1 <- (999 to 100 by -1); d2 <- (d1 to 100 by -1)) yield(d1 * d2)
    products filter isPalindrome max
  }

  /**
   * Smallest multiple
   * 2520 is the smallest number that can be divided by each of the 
   * numbers from 1 to 10 without any remainder.
   * What is the smallest positive number that is evenly divisible 
   * by all of the numbers from 1 to 20?
   */
  def problem5 = (1 to 20).foldLeft(1l)((a, b) => kgv(a, b))

  /**
   * Sum square difference
   * The sum of the squares of the first ten natural numbers is,
   * 1^2 + 2^2 + ... + 10^2 = 385
   * The square of the sum of the first ten natural numbers is,
   * (1 + 2 + ... + 10)^2 = 55^2 = 3025
   * Hence the difference between the sum of the squares of the 
   * first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
   * Find the difference between the sum of the squares of the first one
   * hundred natural numbers and the square of the sum.
   */
  def problem6 = {
    // Sum of the first n natural numbers:
    //     n (n + 1)
    // i = ---------
    //         2
    def squareOfSumOf(n: Int) = math.pow(n * (n + 1) / 2, 2).toInt
    def sumOfSquareOf(n: Int) = n * (n + 1) * (2 * n + 1) / 6
    squareOfSumOf(100) - sumOfSquareOf(100)
    // iterative way:
    // val naturalnumbers = (1 to 100)
    // val sum = naturalnumbers.sum
    // sum * sum - naturalnumbers.map(n => n * n).sum
  }

  /**
   * 10001st prime
   * By listing the first six prime numbers: 
   *    2, 3, 5, 7, 11, and 13, 
   * we can see that the 6th prime is 13.
   * What is the 10 001st prime number?
   */
  def problem7 = {
    primes drop 10000 head
  }

  /**
   * Largest product in a series
   * Find the greatest product of five consecutive digits in the 1000-digit number.
   *                73167176531330624919225119674426574742355349194934
   *                96983520312774506326239578318016984801869478851843
   *                85861560789112949495459501737958331952853208805511
   *                12540698747158523863050715693290963295227443043557
   *                66896648950445244523161731856403098711121722383113
   *                62229893423380308135336276614282806444486645238749
   *                30358907296290491560440772390713810515859307960866
   *                70172427121883998797908792274921901699720888093776
   *                65727333001053367881220235421809751254540594752243
   *                52584907711670556013604839586446706324415722155397
   *                53697817977846174064955149290862569321978468622482
   *                83972241375657056057490261407972968652414535100474
   *                82166370484403199890008895243450658541227588666881
   *                16427171479924442928230863465674813919123162824586
   *                17866458359124566529476545682848912883142607690042
   *                24219022671055626321111109370544217506941658960408
   *                07198403850962455444362981230987879927244284909188
   *                84580156166097919133875499200524063689912560717606
   *                05886116467109405077541002256983155200055935729725
   *                71636269561882670428252483600823257530420752963450
   */
  def problem8 = {
    val number = "73167176531330624919225119674426574742355349194934" +
                 "96983520312774506326239578318016984801869478851843" +
                 "85861560789112949495459501737958331952853208805511" +
                 "12540698747158523863050715693290963295227443043557" +
                 "66896648950445244523161731856403098711121722383113" +
                 "62229893423380308135336276614282806444486645238749" +
                 "30358907296290491560440772390713810515859307960866" +
                 "70172427121883998797908792274921901699720888093776" +
                 "65727333001053367881220235421809751254540594752243" +
                 "52584907711670556013604839586446706324415722155397" +
                 "53697817977846174064955149290862569321978468622482" +
                 "83972241375657056057490261407972968652414535100474" +
                 "82166370484403199890008895243450658541227588666881" +
                 "16427171479924442928230863465674813919123162824586" +
                 "17866458359124566529476545682848912883142607690042" +
                 "24219022671055626321111109370544217506941658960408" +
                 "07198403850962455444362981230987879927244284909188" +
                 "84580156166097919133875499200524063689912560717606" +
                 "05886116467109405077541002256983155200055935729725" +
                 "71636269561882670428252483600823257530420752963450"

    val range = (0 to number.size - 5)
    range.foldLeft(0)((last, pos) => math.max(last, number.slice(pos, pos + 5).map(_.asDigit).product))
  }

  /**
   * Special Pythagorean triplet
   * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
   * a^2 + b^2 = c^2
   * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   */
  def problem9 = {
    (for {
      c <- 999 to 1 by -1
      b <- c -1 to 1 by -1
      a <- b -1 to 1 by -1
      if(a+b+c == 1000 && a*a + b*b == c*c)
    } yield(a*b*c)) head
  }

  /**
   * Summation of primes
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
   * Find the sum of all the primes below two million.
   */
  def problem10 = primes takeWhile(_ < 2000000L) sum
  
  def main(args: Array[String]) {
    println("Problem1 = " + problem1)
    println("Problem2 = " + problem2)
    println("Problem3 = " + problem3)
    println("Problem4 = " + problem4)
    println("Problem5 = " + problem5)
    println("Problem6 = " + problem6)
    println("Problem7 = " + problem7)
    println("Problem8 = " + problem8)
    println("Problem9 = " + problem9)
    println("Problem10= " + problem10)
 }
}