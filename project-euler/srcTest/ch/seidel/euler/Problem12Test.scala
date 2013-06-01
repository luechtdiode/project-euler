package ch.seidel.euler


import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import ch.seidel.euler.Problem12._

@RunWith(classOf[JUnitRunner])
class Problem12Test extends FunSuite {
  
  test("Triangle.valueOf") {
    assert( 1 === Triangle.valueOf(1))
    assert( 3 === Triangle.valueOf(2))
    assert( 6 === Triangle.valueOf(3))
    assert(10 === Triangle.valueOf(4))
    assert(15 === Triangle.valueOf(5))
    assert(21 === Triangle.valueOf(6))
    assert(28 === Triangle.valueOf(7))
    assert(36 === Triangle.valueOf(8))
    assert(45 === Triangle.valueOf(9))
    assert(55 === Triangle.valueOf(10))
  }
  
  test("Triangle divisors") {
    assert(1 === divisors(1))
    assert(6 === divisors(28))
  }
  
  test("first triangleWithDivisors") {
    assert( 1 === firstTriangleWithDivisors(1))
    assert( 3 === firstTriangleWithDivisors(2))
    assert( 0 === firstTriangleWithDivisors(3))
    assert( 6 === firstTriangleWithDivisors(4))
    assert( 0 === firstTriangleWithDivisors(5))
    assert(28 === firstTriangleWithDivisors(6))
    assert( 0 === firstTriangleWithDivisors(7))
  }
  
  test("What is the value of the first triangle number to have over five divisors?") {
    assert(28 === findTriangle(5))
  }

  test("What is the value of the first triangle number to have over five hundred divisors?") {
    assert(76576500 === findTriangle(500))
  }
}
