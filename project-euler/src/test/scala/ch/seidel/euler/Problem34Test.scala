package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem34._

@RunWith(classOf[JUnitRunner])
class Problem34Test extends FunSuite {
  test("simple isCurious test 145") {
    assert(true === isCurious(145))
  }
  test("The sum of all numbers which are equal to the sum of the factorial of their digits.") {
    println("The solution of problem34 = " + solve)
  }
}
