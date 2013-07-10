package ch.seidel.euler

/**
 * Lattice paths.<br>
 * 
 * Starting in the top left corner of a 2×2 grid, and only being able to 
 * move to the right and down, there are exactly 6 routes to the bottom 
 * right corner.
 * 
 * 1x1 = (1+1)*(1+1) =  4 nodes; 1*(1+1)*2 =  4 lines;  2 paths
 * 2x2 = (2+1)*(2+1) =  9 nodes; 2*(2+1)*2 = 12 lines;  6 paths
 * 3x3 = (3+1)*(3+1) = 16 nodes; 3*(3+1)*2 = 24 lines; 20 paths
 * 4x4 = (4+1)*(4+1) = 25 nodes; 4*(4+1)*2 = 40 lines; 70 paths
 * => nodes = (n+1)^2
 * => lines = 2n(n+1)
 * => moves = value of pascal's triangle at column = n, row = 2n:
 * 
 *         0                   1
 *                           1   1
 *         1               1  [2]  1
 *                       1   3   3   1
 *         2           1   4  [6]  4   1
 *                   1   5  10   10   5  1
 *         3       1   6  15 [20]  15  6   1
 *       ......................................
 *        20                 [???]
 *                
 * How many such routes are there through a 20×20 grid?
 * 
 */
object Problem15 {
  
  def pascal(c: Int, r: Int): Long = {
    if(c < 0 || r < 0) 0
    else {
      def pr(column: Int, row: Int, colIdx: Int): Long = 
        if(colIdx < 0) 1
        else (pr(column, row, colIdx - 1) * (row - colIdx)) / (colIdx + 1)
     
      pr(c, r, c-1)
    }
  } 
  
  def solve(size: Int): Long = pascal(size, size * 2)
  
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    val size = 10
    for (row <- 0 to size) {
      print( (0 to size - row).map(_ => "    ").mkString)
      for (col <- 0 to row) {
        val p = pascal(col, row)
        print(f"[$p%4d  ]")
      }
      println()
    }
  }
  
  //// beyond - the search-paths algo: (but not efficient enought)
  
  type Direction = Int
  val Right: Direction = 1
  val Down:  Direction = 2
  case class Node(x: Int, y: Int, parent: Option[Node]) {
    def move(m: Move): Node = m match {
      case Move(Right) => Node(x + 1, y, Some(this))
      case Move(Down)  => Node(x, y + 1, Some(this))
    }
    def isTarget(size: Int) = {
      size == x && size == y
    }
  }

  case class Move(direction: Direction) {
    override def toString = "Move" + (direction match {
      case Right => " right"
      case Down  => " down"
    })
  }
  type Path = List[Move]
  
  def nextMoves(gridsize: Int, node: Node): List[Move] = {
    List(Move(Right), Move(Down)).filter(m => m match {
      case Move(Right) => node.x < gridsize
      case Move(Down)  => node.y < gridsize
      case _ => false
    })
  }

  def findPaths(size: Int, node: Node): Long = {
    if(node.isTarget(size)) 1
    else {
      nextMoves(size, node).foldLeft(0l)((cnt, m) => cnt + findPaths(size, node.move(m)))
    }
  }
  
  def solveBySearching(size: Int): Long = findPaths(size, Node(0,0, None))
  
  //// and another way, using collection permutation feature:
  
  def permutations(n: Int): Long = {
    val rights = (1 to n) map (_ => Move(Right)) toList
    val downs = (1 to n) map (_ => Move(Down)) toList
    val path = rights ::: downs
    path.permutations.size
  }
  
  def solveByCollPerms(size: Int) = permutations(size)
  
}