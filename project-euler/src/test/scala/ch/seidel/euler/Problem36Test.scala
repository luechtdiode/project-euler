package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem36._

@RunWith(classOf[JUnitRunner])
class Problem36Test extends FunSuite {
  test("Base10 to Base2") {
    assert(List('1', '0', '0', '1', '0', '0', '1', '0', '0', '1') === convertToBase2(585))
  }
  test("isPalindromic") {
    assert(true === isPalindromic(585))
  }
  test("The sum of all numbers, less than one million, which are palindromic in base 10 and base 2") {
    println("The solution of problem36 = " + solve(1000000))
  }
}
