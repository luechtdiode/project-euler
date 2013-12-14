package ch.seidel.euler

/**
 * Number letter counts.<br>
 * 
 * If the numbers 1 to 5 are written out in words: 
 *   one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters 
 *   used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used? 
 * 
 * NOTE: Do not count spaces or hyphens. 
 *       For example, 342 (three hundred and forty-two) contains 23 letters 
 *       and 115 (one hundred and fifteen) contains 20 letters. The use of 
 *       "and" when writing out numbers is in compliance with British usage.
 * 
 */
object Problem17 {
  val tre = Map(
        0 -> "zero",
        1 -> "one",
        2 -> "two",
        3 -> "three",
        4 -> "four",
        5 -> "five",
        6 -> "six",
        7 -> "seven",
        8 -> "eight",
        9 -> "nine",
        10 -> "ten",
        11 -> "eleven",
        12 -> "twelve",
        13 -> "thirteen",
        14 -> "fourteen",
        15 -> "fifteen",
        16 -> "sixteen",
        17 -> "seventeen",
        18 -> "eighteen",
        19 -> "nineteen",
        20 -> "twenty",
        30 -> "thirty",
        40 -> "forty",
        50 -> "fifty",
        60 -> "sixty",
        70 -> "seventy",
        80 -> "eighty",
        90 -> "ninety"
      )
      
  /**
   * Translates the number to an List of Digits
   * @param n number to transform
   * @return List of digits from the given number
   */
  def digitsOf(n: Long): List[Int] = {
    if(n > 9) {
      digitsOf(n / 10) :+ (n % 10).toInt
    }
    else List(n.toInt)
  }
  
  def inEnglishWords(number: Long):String = {

    def toWords(digits: List[Int], combine: String): String = {
      if(digits.isEmpty || digits.forall(_ == 0)) ""
      else digits size match {
        case s if(s > 9) =>
          val group = s - 9
          toWords(digits take group, "").trim + " billion " + toWords(digits drop group, "")
        case s if(s > 6) =>
          val group = s - 6
          toWords(digits take group, "").trim + " million " + toWords(digits drop group, "")
        case s if(s > 3) => 
          val group = s - 3
          toWords(digits take group, "").trim + " thousand " + toWords(digits drop group, "")
        case 3 => 
          tre.getOrElse(digits.head, "") + " hundred " + toWords(digits.tail, "and ")
        case 2 if(digits.head == 1) =>
          val d = digits.head * 10 + digits.tail.head
          if(d > 0)
            combine + tre.getOrElse(digits.head * 10 + digits.tail.head, "") + toWords(digits.tail.tail, "")
          else
            toWords(digits.tail.tail, "")
        case 2 => 
          if(digits.head != 0)
            combine + tre.getOrElse(digits.head * 10, "") + toWords(digits.tail, "-")
          else
            toWords(digits.tail, combine)
        case _  => 
          val d = digits.head
          if(d > 0)
            combine + tre.getOrElse(digits.head, "")
          else
            ""
      }
    }
    toWords(digitsOf(number), "").trim
  }
    
  def countLetters(numWords: String): Int = {
    def countingLetters(l: Char) = ('a' to 'z').contains(l)
    numWords filter countingLetters size
  }
  
  def solve(numbers: Seq[Int]): Int = numbers.map(n => countLetters(inEnglishWords(n))).sum
  
}