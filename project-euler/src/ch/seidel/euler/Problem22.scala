package ch.seidel.euler

import java.util.Scanner

import scala.collection.immutable.Stream.consWrapper

/**
 * Names Score
 * Problem 22
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this 
 * value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
 * is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 * 
 */
object Problem22 {
  val charOrder: Map[Char,Int] = 
    ('A' to 'Z').foldLeft(Map[Char,Int]()) { 
      (m, c) => m + (c -> (c.asDigit-9))
    }
  
  def calculate(acc: (Int, Int), name: String) = acc match {
    case (score, idx) => (score + (name map charOrder sum) * idx, idx + 1)
  }

  def parseNames(filename: String): Stream[String] = {
    val f = getClass().getResourceAsStream(filename)
    val s = new Scanner(f)
    s.useDelimiter(",")
	
    def streamed(in: Stream[String]): Stream[String] = {
	  if(s.hasNext()) {
	    val text = s.next
	    val name = text.drop(1).take(text.length()-2)
	    name #:: streamed(in)
	  } 
	  else in
    }
    
    streamed(Stream[String]())
  }

  def solve(filename: String) = {
    val names = parseNames(filename).toList.sorted
    val initial = (0, 1)
    val (product, cnt) = names.foldLeft(initial)(calculate)
    product
  }
}