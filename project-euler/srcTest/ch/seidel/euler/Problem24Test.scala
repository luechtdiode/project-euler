package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem24._

@RunWith(classOf[JUnitRunner])
class Problem24Test extends FunSuite {
  test("two iterations") {
    assert("0123456798" === solve(2))
  }
  test("What is the millionth lexicographic permutation of the digits 0 to 9") {
    println("The solution of problem24 = " + solve(1000000))
  }
}
