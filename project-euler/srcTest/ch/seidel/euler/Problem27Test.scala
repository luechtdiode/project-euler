package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem27._

@RunWith(classOf[JUnitRunner])
class Problem27Test extends FunSuite {
  test("Eulers quadratic Formula") {
    assert(14 === quadraticFormula(2, 3, 4))
    assert(14 === quadraticFormula(2, 3, 4))
  }
  test("simple test") {
    assert(-41 === solve(42))
  }
  test("Product of Coefficients a and b, for the quadratic expr. that produces the max number of primes") {
    /*
     *  n² + an + b, where |a| < 1000 and |b| < 1000
     *  Find the product of the coefficients, a and b, for the quadratic expression 
     *  that produces the maximum number of primes for consecutive values 
     *  of n, starting with n = 0
     */
    println("The solution of problem27 = " + solve(999))
  }
}
