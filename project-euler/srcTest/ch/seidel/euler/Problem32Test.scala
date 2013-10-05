package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem32._

@RunWith(classOf[JUnitRunner])
class Problem32Test extends FunSuite {
  test("valueOfDigits") {
    assert(31 === valueOfDigits(List(3,1)))
    assert(13 === valueOfDigits(List(1,3)))
  }
  test("isPandigital") {
    assert(isPandigital(List(3), List(9), List(1,8,6,7,2,5,4)) === 7254)
  }
  test("simple test") {
    assert(8 === solve(Set(2,4,8)))
  }
  test("simple test 2") {
    assert(12 === solve(Set(1,2,3,4)))
  }
  test("The sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital") {
    println("The solution of problem32 = " + solve(Set(1,2,3,4,5,6,7,8,9)))
  }
}
