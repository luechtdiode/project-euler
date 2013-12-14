package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem25._

@RunWith(classOf[JUnitRunner])
class Problem25Test extends FunSuite {
  test("simple test") {
    assert("F7" === solve(10))
  }
  test("What is the first term in the Fibonacci sequence to contain 1000 digits") {
    println("The solution of problem25 = " + solve(BigInt(10).pow(999)))
  }
}
