import javax.sound.midi.{Patch, Soundbank}

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
  def deposite(bank: Int) { privateBalance += bank }
  def withdraw(bank: Int) { deposite( 0 - bank) }
}

val myAccount = new BackAccount
myAccount.deposite(100)
myAccount.balance
myAccount.withdraw(55)
myAccount.balance

