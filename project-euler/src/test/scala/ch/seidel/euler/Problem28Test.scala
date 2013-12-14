package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem28._

@RunWith(classOf[JUnitRunner])
class Problem28Test extends FunSuite {
  test("simple test") {
    assert(101 === solve(5))
  }
  test("Sum of the numbers on the diagonals in a 1001 by 1001 spiral") {
    println("The solution of problem28 = " + solve(1001))
  }
}
