package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem29._

@RunWith(classOf[JUnitRunner])
class Problem29Test extends FunSuite {
  test("simple test") {
    assert(15 === solve(5))
  }
  test("How many distinct terms are in the swquence generated by a^b") {
    println("The solution of problem29 = " + solve(100))
  }
}