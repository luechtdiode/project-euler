package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem30._

@RunWith(classOf[JUnitRunner])
class Problem30Test extends FunSuite {
  test("simple test") {
    assert(19316 === solve(4))
  }
  test("Sum of all the numbers that can be written as the sum of fifth powers of their digits") {
    println("The solution of problem30 = " + solve(5))
  }
}
