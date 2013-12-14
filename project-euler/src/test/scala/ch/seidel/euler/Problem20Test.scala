package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem20._

@RunWith(classOf[JUnitRunner])
class Problem20Test extends FunSuite {
  
  test("Find the sum of the digits in the number 100!") {
    println("The solution of problem20 = " + solve(100)) 
  }
}
