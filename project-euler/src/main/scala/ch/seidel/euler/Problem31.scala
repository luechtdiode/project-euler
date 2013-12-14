package ch.seidel.euler

/**
 * Coin sums
 * Problem 31
 * 
 * In England the currency is made up of pound, £, and pence, p, and 
 * there are eight coins in general circulation:
 * 
 *     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * It is possible to make £2 in the following way:
 * 
 *     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number of coins?
 */
object Problem31 {

  /**
   * solves with bottom-up approach 
   * (starts solving the smallest subproblem, and then it solves larger
   * and larger subproblems)
   */
  def countChangeBottomUp(money: Int, coins: List[Int]) = {
    coins.foldLeft(List(1l)){(ways, coin) =>
      (coin to money).foldLeft(ways) {(w, a) => 
        // tradeoff: tricky operation with immutable lists, we have to instantiate new lists.
        (w.take(a) :+ w.applyOrElse[Int, Long](a, x => 0) + w(a - coin)) ::: w.drop(a + 1)
      }
    }.last
  }
  
  /**
   * simple recursive approach
   */
  def countChangeRecursive(money: Int, coins: List[Int]): Long = {
    // initial check
    if(money < 1 || coins.isEmpty) { 
      0l
    }    
    else {
      def count(money: Int, coins: List[Int]): Long = {
          if(money == 0) 
            1l
          else if(money < 0 || coins.isEmpty)
            0l
          else
            count(money, coins.tail) + count(money - coins.head, coins)
      }
      count(money, coins)
    }
  }
  
  def solve(money: Int) = {
    val coins = List(1, 2, 5, 10, 20, 50, 100, 200)
    
    //countChangeRecursive(money, coins)
    
    // this one is much faster
    countChangeBottomUp(money, coins)
  }
}