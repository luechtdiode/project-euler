package ch.seidel.euler

import scala.collection.IndexedSeq
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

/**
 * Counting Sundays
 * Problem 19
 * 
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * 
 */
object Problem19 {
  val cal = new GregorianCalendar()
  val SUNDAY = 7
  
  // Mike Keith's Day-of-Week Congruence
  // see http://www.merlyn.demon.co.uk/zel-like.htm#Keith
  // shortest ((m<3?y--:y-2)+23*m/9+4+d+y/4+y/100*25/4)%7
  def dowKeith(d: Int, m: Int, y: Int): Int = {
    val y1 = if(m < 3) y -1 else y -2
    val y2 = if(m < 3) y -1 else y
    val wd = (y1 + 23*m/9 + 4 + d + y2/4 + y2/100*25/4) % 7
    // shift sunday at idx 7
    if(wd == 0) 7 else wd
  }                                               

  // Christian Zeller's Day-of-Week Congruence
  // see http://www.merlyn.demon.co.uk/zel-like.htm#GDW
  def dowZeller(d: Int, m: Int, y: Int): Int = {
    val mm = if(m < 3) m + 12 else m
    val wd = (2 + d + (((13*mm-2)/5)|0) + y + ((y/4)|0) - ((y/100)|0) + ((y/400)|0) ) % 7
    // shift sunday at idx 7
    if(wd < 1) wd + 7 else wd
  }               
 
  // JDK's Calendar (Gregorian Calendar)
  def dowCalendar(d: Int, m: Int, y: Int) = {
    cal.set(y, m-1, d)
    val wd = cal.get(Calendar.DAY_OF_WEEK)
    // shift sunday at idx 7
    if(wd > 1) wd - 1 else wd + 6
  }

  // alias
  def weekday(d: Int, m: Int, y: Int) = dowZeller(d, m, y)
  
  def solve(startyear: Int, endyear: Int) = {  
    var faults = 0
    val sundays = for {
      y <- startyear to endyear
      m <- 1 to 12
      d <- 1 to 1 // go higher for testing
      wdg = dowCalendar(d,m,y)
      wdk = dowKeith(d,m,y)
      wdz = dowZeller(d,m,y)
      
      // wdg and wdz ar OK. If we take wdk, then it counts one sunday too much
      if(wdg == SUNDAY)
    } yield {
      // compare to Keith's and Zeller's value
//      if(wdg != wdk || wdg != wdz) {
//        faults += 1
//        println(faults + ". Diff: " + (d,m,y) + " Cal=" + wdg + " " + cal.getTime() + " Keith=" + wdk + " Zeller=" + wdz)
//      }
      (d,m,y)
    }
    sundays.size
  }
}