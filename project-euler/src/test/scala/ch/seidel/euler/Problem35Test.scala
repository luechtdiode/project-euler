package ch.seidel.euler 

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem35._

@RunWith(classOf[JUnitRunner])
class Problem35Test extends FunSuite {
  test("permutations of 19") {
    assert(Set(19, 91) === digitRotations(19))
  }
  test("permutations of 197") {
    assert(Set(197, 971, 719) === digitRotations(197))
  }
  test("197 is circular prime") {
    assert(true === isCircularPrime(197))
  }
  test("circular primes below 100") {
    assert(13 === solve(100).toList.size)
  }
  test("How many circular primes are there below one million?") {
    println("The solution of problem35 = " + solve(1000000).toList.size)
  }
}
