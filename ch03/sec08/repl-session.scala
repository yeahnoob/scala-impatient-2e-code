// These are meant to be typed into the REPL. You can also run
// scala -Xnojline < repl-session.scala to run them all at once.

val a = Array("Mary", "a", "had", "lamb", "little")
java.util.Arrays.binarySearch(a, "beef") // Does not work
java.util.Arrays.binarySearch(a.asInstanceOf[Array[Object]], "beef") // Ok

import scala.collection.Searching._
val result = a.search("beef")

import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable.Buffer

val command = Buffer("ls", "-al", "/home/cay")
val pb = new ProcessBuilder(command) // Scala to Java

import scala.collection.JavaConversions.asScalaBuffer

val cmd : Buffer[String] = pb.command() // Java to Scala

cmd == command
