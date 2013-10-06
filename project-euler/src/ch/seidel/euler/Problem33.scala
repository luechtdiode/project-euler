package ch.seidel.euler

import scala.annotation.tailrec

/**
 * Digit canceling fractions
 * Problem 33
 * 
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
 * which is correct, is obtained by canceling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, 
 * less than one in value, and containing two digits in the numerator and denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms, 
 * find the value of the denominator.
 * 
 */
object Problem33 {
  // helpers
  def digitsOfValue(n: BigInt): List[Int] = if(n > 9) digitsOfValue(n / 10) :+ (n % 10).toInt else List(n.toInt)
  def valueOfDigits(d: List[Int]): BigInt = d.foldLeft(0)((product, n) => product * 10 + n)
  def gcd(a: BigInt, b: BigInt): BigInt = if(b == 0) a else gcd(b, a % b)

  case class Rational(n: BigInt, d: BigInt) {
    require(d != 0, "Invalid visualisation: " + n + "/" + d + ", The denominator must be greater than zero.")
    val g = gcd(n, d)
    val numer = n / g
    val denom = d / g
     
    def ==(that: Rational): Boolean = numer == that.numer && denom == that.denom
    def *(r: Rational) = Rational(numer * r.numer, denom * r.denom)

    override def toString = {
      f"[${n}/${d}] => [${numer}/${denom}], curious=${isCurious}"
    }

    // Problem 33 stuff
    /** digits of the original nominator (n) */
    lazy val nd = digitsOfValue(n)
    
    /** digits of the original denominator (d) */
    lazy val dd = digitsOfValue(d)
    
    /** common digits of the original nominator and denominator */
    lazy val cd = nd.intersect(dd)
    
    /** fractions like 30/50 = 3/5, are trivial */
    lazy val isTrivial = g % 10 == 0
    
    lazy val isCurious =
      if(n > 9 && d > 9 && g > 1 && !cd.isEmpty && !isTrivial) {
        val testd = valueOfDigits(dd.diff(cd))
        val testn = valueOfDigits(nd.diff(cd))
        if(testd > 0 && testn > 0) this == Rational(testn, testd)
        else false
      } 
      else false
  }
  
  /**
   * a more generic solution
   */
  def solve(digits: Int = 2) = {
    val lowerbound = (1 to digits-1).foldLeft(1)((product, _) => product * 10)
    val upperbound = (1 to digits).foldLeft(1)((product, _) => product * 10) -1
    
    val magics = (lowerbound to upperbound-1).flatMap(n => 
      (n+1 to upperbound).map(d => 
          Rational(n, d))).filter(_.isCurious)
    //println(magics.mkString("\n"))  
    magics.foldLeft(Rational(1,1))((acc, r) => acc * r)
  }
  
  /**
   * nom/denom:   0 < n < d < 10
   * cancel-var:  0   < i   < 10 
   * 
   * Combinations:
   * -----1-----   -----2-----   -----3-----   -----4-----
   * 10i + n   n | 10n + i   n | 10i + n   n | 10n + i   n |
   * ------- = - | ------- = - | ------- = - | ------- = - |
   * 10i + d   d | 10d + i   d | 10d + i   d | 10i + d   d |
   * 
   */
  def solve2 = (1 to 9).flatMap(i => 
    (1 to 9).flatMap(n => 
      (n + 1 to 9).map(d => { 
        val ref = Rational(n,d)
        val possibilities = List(
          //  Rational(10 * i + n, 10 * i + d) // not needed
          //, Rational(10 * n + i, 10 * d + i) // not needed
          //, Rational(10 * i + n, 10 * d + i) // not needed
            Rational(10 * n + i, 10 * i + d)
          )
        possibilities.find(_ == ref)
      }
     ))).foldLeft(Rational(1,1))((acc, r) => r match {
       case Some(rational) => {
         //println(r)
         acc * rational
       }
       case _ => acc
     }
    )
}