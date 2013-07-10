package ch.seidel.euler


import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import ch.seidel.euler.Problem49._

@RunWith(classOf[JUnitRunner])
class Problem49Test extends FunSuite {
  
  /**
   * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
   *    (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
   * Thereare no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there 
   *    is one other 4-digit increasing sequence.
   * What 12-digit number do you form by concatenating the three terms in this sequence?
   */
  test("between") {
    assert(List(5,6,7) === between(5,7).toList)
  }
  
  test("isPrime") {
    assert(false === isPrime(1), "1")
    assert(true === isPrime(2), "2")
    assert(true === isPrime(3), "3")
    assert(true === isPrime(5), "5")
    assert(true === isPrime(7), "7")
    assert(List(1,2,3,5,7,11,13,17,19) === primes(between(1, 20)).toList)
  }
  
  test("DigitsOf") {
    assert(List(1,2,3,4) === digitsOf(1234).sorted)
    assert(List(1,2,3,4) === digitsOf(4321).sorted)
    assert(List(1,2,3,4) === digitsOf(2413).sorted)
  }

  test("EqualDigits") {
    assert(true === equalDigits(1234, 4321))
  }
  
  test("Three4-digitPrimeTerms with 3330 distance") {
    val solution = solve 
    assert(12 === solution.length())
    assert("148748178147" != solution) // we search the other three primes
    val p1 = solution take 4 toInt
    val p2 = solution drop 4 take 4 toInt
    val p3 = solution drop 8 take 4 toInt
    
    assert(true === (isPrime(p1) && p1 + 3330 == p2))
    assert(true === (isPrime(p2) && p2 + 3330 == p3))
    assert(true === isPrime(p3))
    println("The solution of problem49 = " + solution)
  }
}
