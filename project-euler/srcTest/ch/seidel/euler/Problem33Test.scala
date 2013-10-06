package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem33._

@RunWith(classOf[JUnitRunner])
class Problem33Test extends FunSuite {
  test("simple isCurious test 49/98") {
    assert(true === Rational(49,98).isCurious)
  }
  test("simple isCurious and trivial test 30/50") {
    assert(false === Rational(30,50).isCurious)
  }
  test("simple isCurious test 12/24") {
    assert(false === Rational(12,24).isCurious)
  }
  test("compare old/new algo") {
    assert(solve() === solve2)
  }
  test("performace solve") {
    solve()
  }
  test("performance solve2") {
    solve2
  }
  test("Denominator of the product of all curious fractions, having two digits nom/denom") {
    println("The solution of problem33 = " + solve())
  }
  test("Denominator of the product of all curious fractions, having three digits nom/denom") {
    assert(40106457883453l === solve(3).numer)
  }
}
