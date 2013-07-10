package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import ch.seidel.euler.Problem15._
import java.text.Format
import scala.runtime.StringFormat

@RunWith(classOf[JUnitRunner])
class Problem15Test extends FunSuite {
  test("solve 2 == 6") {
    assert(solve(2) === 6)
  }
  test("solve 3 == 20") {
    assert(solve(3) === 20)
  }
  test("solve 4 == 70") {
    assert(solve(4) === 70)
  }
  test("solve 16 == 601080390") {
    assert(solve(16) === 601080390)
  }
  test("solveBySearchAlgo 2 == 6") {
    assert(solveBySearching(2) === 6)
  }
  test("solveBySearchAlgo 3 == 20") {
    assert(solveBySearching(3) === 20)
  }
  test("solveBySearchAlgo 4 == 70") {
    assert(solveBySearching(4) === 70)
  }
  test("solveBySearchAlgo 10 == 184756") {
    assert(solveBySearching(10) === 184756)
  }
  test("solveByCollPerms 2 == 6") {
    assert(solveByCollPerms(2) === 6)
  }
  test("solveByCollPerms 3 == 20") {
    assert(solveByCollPerms(3) === 20)
  }
  test("solveByCollPerms 4 == 70") {
    assert(solveByCollPerms(4) === 70)
  }
  test("solveByCollPerms 10 == 184756") {
    assert(solveByCollPerms(10) === 184756)
  }
  
  
  test("Final Solution") {
    println("The solution of problem15 = " + solve(20))  
  }
}
