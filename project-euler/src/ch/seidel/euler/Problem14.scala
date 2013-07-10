package ch.seidel.euler

import scala.annotation.tailrec

/**
 * Longest Collatz sequence.<br>
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting 
 * numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */
object Problem14 {
  def evencollatz(n: Long):Long = n / 2
  def oddcollatz(n: Long):Long  = 3 * n + 1
  
  def collatz(n: Long): List[Long] = {
    if     (n < 2)      List(n)
    else if(n % 2 == 0) n :: collatz(evencollatz(n))
    else                n :: collatz(oddcollatz(n))
  }
  
  def collatzChain(n: Long): Int = {
    if     (n < 2)      1
    else if(n % 2 == 0) 1 + collatzChain(evencollatz(n))
    else                1 + collatzChain(oddcollatz(n))
  }
  
  /** 
   * Solves the Problem.
   * @return starting number which produces the longest Collatz sequence.
   */
  def solve = {
    val (lastStart, lastMaxChain) = (2 until 1000000).foldLeft((0,0))((max, start) => {
      val chain = collatzChain(start)
      val (lastStart, lastMaxChain) = max
      if(lastMaxChain < chain) 
        (start, chain)
      else
        max
    })
    lastStart
  }
}