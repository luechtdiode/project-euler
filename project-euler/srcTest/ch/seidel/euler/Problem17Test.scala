package ch.seidel.euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import Problem17._

@RunWith(classOf[JUnitRunner])
class Problem17Test extends FunSuite {
  test("digitsOf") {
    assert(digitsOf(1000) === List(1,0,0,0))
  }
  test("countLetters - example1 reconstructed") {
    assert(countLetters("three hundred and forty-two") === 23)
  }
  test("countLetters - example2 reconstructed") {
    assert(countLetters("one hundred and fifteen") === 20)
  }
  test("ten to hundred") {
    assert(inEnglishWords(10) === "ten")
    assert(inEnglishWords(22) === "twenty-two")
    assert(inEnglishWords(45) === "forty-five")
    assert(inEnglishWords(99) === "ninety-nine")
  }
  test("hundreds") {
    assert(inEnglishWords(100) === "one hundred")
    assert(inEnglishWords(342) === "three hundred and forty-two")
    assert(inEnglishWords(210) === "two hundred and ten")
    assert(inEnglishWords(302) === "three hundred and two")
  }
  test("thousands") {
    assert(inEnglishWords(100000) === "one hundred thousand")
    assert(inEnglishWords(210000) === "two hundred and ten thousand")
    assert(inEnglishWords(302000) === "three hundred and two thousand")
    assert(inEnglishWords(400300) === "four hundred thousand three hundred")
    // not sure if it has to be mentioned "zero hundred"?
    assert(inEnglishWords(500040) === "five hundred thousand zero hundred and forty")
    assert(inEnglishWords(600005) === "six hundred thousand zero hundred and five")
  }
  test("987654321") {
    assert(inEnglishWords(987654321) === "nine hundred and eighty-seven million six hundred and fifty-four thousand three hundred and twenty-one")
  }
  test("800987654321") {
    assert(inEnglishWords(800987654321L) === "eight hundred billion nine hundred and eighty-seven million six hundred and fifty-four thousand three hundred and twenty-one")
  }
  test("solve range 1 to 5") {
    assert(solve((1 to 5)) === 19)
  }
  test("Final Solution") {
    println("The solution of problem17 = " + solve((1 to 1000))) 
  }
}
