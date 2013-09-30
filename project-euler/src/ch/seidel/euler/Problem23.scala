package ch.seidel.euler

/**
 * Non-abundant sums
 * Problem 23
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means 
 * that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called 
 * abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be 
 * written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all 
 * integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper 
 * limit cannot be reduced any further by analysis even though it is known that the greatest number that 
 * cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
object Problem23 {
  def isDeficient(value: Int): Boolean = value > divisors(value).sum
  def isAbundant(value: Int): Boolean = value < divisors(value).sum
  def isPerfect(value: Int): Boolean = value == divisors(value).sum
  
  def divisors(value: Int): Set[Int] = if(value == 1) Set(1) else
    (2 to math.sqrt(value.toDouble).toInt).foldLeft(Set[Int](1))((lst, n) => 
      if(value % n == 0) (lst + n + (value/n)) else lst)

  val upperAbundantNumberLimit = 28123
  lazy val abundantNumbers = (12 to upperAbundantNumberLimit) filter isAbundant 
  lazy val abundantNumberSums = (for {
    n1 <- 0 until abundantNumbers.size
    n2 <- n1 until abundantNumbers.size// filter(_ >= n1)
    val sum = abundantNumbers(n1) + abundantNumbers(n2)
    if(sum <= upperAbundantNumberLimit)
  }
  yield(sum)) toSet
  
  def notSumOfAbundantNumbers(value: Int): Boolean =
    !abundantNumberSums.contains(value)
//    abundantNumbers filter(_ < value) forall(n => !abundantNumbers.contains(value-n))
  
  def solve = (1 to upperAbundantNumberLimit) filter notSumOfAbundantNumbers sum
}