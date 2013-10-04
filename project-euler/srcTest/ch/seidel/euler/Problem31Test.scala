package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem31._

@RunWith(classOf[JUnitRunner])
class Problem31Test extends FunSuite {
  test("simple test countChangeRecursive") {
    assert(countChangeRecursive(4,List(1,2)) === 3)
  }
  test("simple test2 countChangeBottomUp") {
    assert(countChangeBottomUp(4,List(1,2)) === 3)
  }
  test("How many different ways can £2 be made using any number of coins?") {
    println("The solution of problem31 = " + solve(200))
  }
  test("How many different ways can £100 be made using any number of coins?") {
    assert(1133873304647601l === solve(10000))
  }
}
