package ch.seidel.euler.problem11

object Problem11 {
  
  type Coord = (Int, Int)
  type Candidate = List[(Coord, Int)]
  type Matrix = List[List[Int]]
  
  def parse(grid: String) = 
    grid.split("\n").toList.map(l => l.split(" ").toList.map(n => n.trim.toInt))
  
  private def findRowDown(matrix: Matrix, r: Int, c: Int) = 
    if(r < matrix.size -3) 
      Set((for(x <- r to r + 3) yield ((x, c), matrix(x)(c))).toList)
    else Set()
  
  private def findRowRight(matrix: Matrix, r: Int, c: Int) = 
    if(c < matrix(0).size -3) 
      Set((for(x <- c to c + 3) yield ((r, x), matrix(r)(x))).toList)
    else Set()
  
  private def findRowLeftDown(matrix: Matrix, r: Int, c: Int) = 
    if(r < matrix.size -3 && c > 3) 
      Set((for(x <- 0 to 3) yield ((r + x, c - x), matrix(r + x)(c - x))).toList)
    else Set()
  
  private def findRowRightDown(matrix: Matrix, r: Int, c: Int) = 
    if(r < matrix.size -3 && c < matrix(0).size -3) 
      Set((for(x <- 0 to 3) yield ((r + x, c + x), matrix(r + x)(c + x))).toList)
    else 
      Set()
  
  private def product(intcells: Candidate) = 
    intcells.foldLeft(1)((pr, tupel) => pr * tupel._2)
 
  private def biggerOf(one: Candidate, other: Candidate) = 
    if(product(one) > product(other)) one else other
  
  val startlist: Candidate = List.empty
    
  private def biggestAt(matrix: Matrix, i: Int) = {
    val r = i / matrix.size
    val c = i % matrix.size
    val rows = findRowDown(matrix, r, c) ++
               findRowRight(matrix, r, c) ++
               findRowLeftDown(matrix, r, c) ++
               findRowRightDown(matrix, r, c)
    
    rows.foldLeft(startlist)((one, other) => biggerOf(one, other))
  }
  
  def solve(grid: String) = {
    val matrix = parse(grid)
    val range = (0 until matrix.size * matrix(0).size)
    val biggest = range.foldLeft(startlist)((biggest, x) => 
      biggerOf(biggest, biggestAt(matrix, x)))

    (product(biggest), biggest)
  }
}