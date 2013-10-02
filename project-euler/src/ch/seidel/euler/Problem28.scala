package ch.seidel.euler

import scala.annotation.tailrec
/**
 * Number spiral diagonals
 * Problem 28
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction 
 * a 5 by 5 spiral is formed as follows:
 * 
 *[21]22 23 24[25]
 * 20 [7] 8 [9]10
 * 19  6 [1] 2 11
 * 18 [5] 4 [3]12
 *[17]16 15 14[13]
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral 
 * formed in the same way?
 */
object Problem28 {
  trait Edge {
    val value: Int
    def next: Edge
  }

  case class Start extends Edge {
    val value = 1
    def next = BottomRight(2, 3, 4)
  }
  
  case class TopRight(step: Int, value: Int, sum: Int) extends Edge {
    val nextstep = step + 2
    def next = BottomRight(nextstep, value + nextstep, sum + value + nextstep)
  }

  case class BottomRight(step: Int, value: Int, sum: Int) extends Edge {
    def next = BottomLeft(step, value + step, value + step + sum)
  }

  case class BottomLeft(step: Int, value: Int, sum: Int) extends Edge {
    def next = TopLeft(step, value + step, value + step + sum)
  }
  
  case class TopLeft(step: Int, value: Int, sum: Int) extends Edge {
    def next = TopRight(step, value + step, value + step + sum)
  }
  
  @tailrec
  def solve(targetsize: Int, edge: Edge = Start()): Int = edge match {
    case TopRight(step, _, sum) if(step + 1 == targetsize) => sum
    case edge => solve(targetsize, edge.next)
  }
}