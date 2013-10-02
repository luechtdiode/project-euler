package ch.seidel.euler

import scala.annotation.tailrec
/**
 * Quadratic primes
 * Problem 27
 * 
 * Euler discovered the remarkable quadratic formula:
 * 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the 
 * consecutive values n = 0 to 39. However, 
 * when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, 
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 * 
 * The incredible formula  n² − 79n + 1601 was discovered, which 
 * produces 80 primes for the consecutive values n = 0 to 79. 
 * The product of the coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 *     n² + an + b, where |a| < 1000 and |b| < 1000
 * 
 *     where |n| is the modulus/absolute value of n
 *     e.g. |11| = 11 and |−4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic 
 * expression that produces the maximum number of primes for consecutive 
 * values of n, starting with n = 0.
 * 
 */
object Problem27 {

  def isPrime(n: Long) = {
    if(n < 2) false
    else if(n == 2) true
    else if(n % 2 == 0) false
    else (3 to math.sqrt(n.toDouble).toInt by 2) forall(n % _ != 0)
  }

  def quadraticFormula(n: Int, a: Int, b: Int) = n*n + a*n + b
  
  def countPrimes(a: Int, b: Int): Int = {
    @tailrec
    def count(n: Int): Int = if(isPrime(quadraticFormula(n, a, b))) count(n+1) else n
    count(0)
  }
  
  def solve(upperbound: Int) = {
    val coefficients = for {
      a <- (-1 * upperbound to upperbound)
      b <- (-1 * upperbound to upperbound)
    }
    yield {
      (a, b, countPrimes(a, b))
    }
    
    val (a, b, _) = coefficients maxBy{case (_, _, quadratic) => quadratic}
    a * b
  }
}