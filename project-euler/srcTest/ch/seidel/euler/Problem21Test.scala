package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem21._

@RunWith(classOf[JUnitRunner])
class Problem21Test extends FunSuite {
  test("the sum of proper divisors of n, smaller than n") {
    assert(d(8) === 7)
  }
  test("Evaluate the sum of all the amicable numbers under 10000") {
    println("The solution of problem21 = " + solve(10000)) 
  }
}
