package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import ch.seidel.euler.Problem14._

@RunWith(classOf[JUnitRunner])
class Problem14Test extends FunSuite {
  test("collatz") {
    assert(List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1) === collatz(13))
  }  

  test("collatzChain") {
    assert(10 === collatzChain(13))
  } 
  
  test("Find the solution") {
    println("The solution of problem14 = " + solve)
  }
}
