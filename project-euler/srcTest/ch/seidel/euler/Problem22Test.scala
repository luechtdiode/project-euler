package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import scala.io.Source
import Problem22._
import java.util.Scanner

@RunWith(classOf[JUnitRunner])
class Problem22Test extends FunSuite {
  test("test Index") {
    assert(charOrder('A') === 1)
    assert(charOrder('Z') === 26)
  }
  test("COLIN") {
    assert(calculate((0, 1), "COLIN") === (53, 2))
  }
  test("parse") {
    assert(parseNames("names.txt").head === "MARY")
  }
  test("What is the total of all the name scores in the file?") {
    println("The solution of problem22 = " + solve("names.txt"))
  }
}
