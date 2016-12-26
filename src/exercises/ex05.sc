
/**
  * Exercise 05.01
  * Improve the Counter class in Section 5.1
  * , “Simple Classes and Parameterless Methods,” on page 55
  * , so that it doesn’t turn negative at Int.MaxValue.
 */
class Counter {
  private var value = Int.MaxValue - 2
  def increment {
    if (value < Int.MaxValue) {
      value += 1
    } else {
      println("Error: Operation may exceed Scala's Int.MaxValue.")
    }
  }
  def current = value
}
val myCount = new Counter
myCount.increment
println(myCount.current)
myCount.increment
println(myCount.current)
myCount.increment
println(myCount.current)

/**
  * Exercise 05.02
  * Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
  */
class BackAccount {
  private var privateBalance = 0
  def balance = privateBalance
  def deposit(bank: Int) { privateBalance += bank }
  def withdraw(bank: Int) { deposit( 0 - bank) }
}
val myAccount = new BackAccount
myAccount.deposit(100)
myAccount.balance
myAccount.withdraw(55)
myAccount.balance

/**
  * Exercise 05.03
  * Write a class Time with read-only properties hours and minutes and a method before(other: Time)
  * : Boolean that checks whether this time comes before the other. A Time object should be constructed
  * as new Time(hrs, min), where hrs is in military time format (between 0 and 23).
  */
class TimeCheck(private val hrs: Int, private val mi: Int) {
  if(hrs < 0 || hrs > 23) {
    println("Hours should be in military time format (0 to 23).")
  }
  // private var timenow = new java.util.Date
  def hours = hrs
  def minutes = mi
  def before(other: TimeCheck): Boolean = this.hrs < other.hrs || (this.hrs == other.hrs && this.mi < other.mi)
}
val t = new TimeCheck(22, 30)
t.hours
t.minutes
t.before(new TimeCheck(22, 30))

/**
  * Exercise 05.04
  * Reimplement the Time class from the preceding exercise so that the internal representation is the number of
  * minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public interface.
  * That is, client code should be unaffected by your change.
  */
class TimeCheckv2(private val hrs: Int, private val mi: Int) {
  if(hrs < 0 || hrs > 23) {
    println("Hours should be in military time format (0 to 23).")
  }
  def hours = hrs
  def minutes = mi
  private def minutesSinceMidnight = hrs * 60 + mi
  def before(other: TimeCheckv2): Boolean = this.minutesSinceMidnight < other.minutesSinceMidnight
}