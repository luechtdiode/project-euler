package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem23._

@RunWith(classOf[JUnitRunner])
class Problem23Test extends FunSuite {
  test("divisors 28") {
    assert(divisors(28) === Set(1,2,4,7,14))
  }
  test("perfect 28") {
    assert(isPerfect(28) === true)
  }
  test("abundant 12") {
    assert(isAbundant(12) === true)
  }
  test("notSumOfAbundantNumbers") {
    assert(notSumOfAbundantNumbers(23) === true)
    assert(notSumOfAbundantNumbers(24) === false)
  }
  test("sum of all the positive integers which cannot be written as the sum of two abundant numbers") {
    println("The solution of problem23 = " + solve)
  }
}
