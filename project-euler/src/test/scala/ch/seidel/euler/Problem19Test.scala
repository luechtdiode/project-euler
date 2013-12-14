package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem19._

@RunWith(classOf[JUnitRunner])
class Problem19Test extends FunSuite {

  test("weekday") {
    assert(SUNDAY === weekday(1, 9, 1901))
    assert(1 === weekday(2, 9, 1901))
    assert(2 === weekday(3, 9, 1901))
    assert(3 === weekday(4, 9, 1901))
    assert(4 === weekday(5, 9, 1901))
    assert(5 === weekday(6, 9, 1901))
    assert(6 === weekday(7, 9, 1901))
    assert(1 === weekday(1, 5, 2000))
  }
  
  test("How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)") {
    println("The solution of problem19 = " + solve(1901, 2000)) 
  }
}
