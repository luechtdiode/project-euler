package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import Problem16._

@RunWith(classOf[JUnitRunner])
class Problem16Test extends FunSuite {
  
  test("example reconstructed") {
    assert(solve(15) === 26)
  }
  test("Final Solution") {
    println("The solution of problem16 = " + solve(1000)) 
  }
}
