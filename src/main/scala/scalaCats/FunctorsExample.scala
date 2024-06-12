package scalaCats
import cats.Functor
import cats.syntax.functor._
import cats.instances.option._
import exercises.PrintableLibrary.PrintSyntax.PrintOps
import exercises.PrintableLibrary.PrintableInstances._
object FunctorsExample extends App {
val option = Some("Vineet")
  val upperCase = Functor[Option].map(option)(_.toUpperCase)

  upperCase.toPrint
  Array(1,2,3,4,5).toPrint


  val func1: Int => Double =  (x: Int) => x.toDouble
  val func2:Double => Double = (y:Double)=> y*2

  val result = (func1 map func2)(1)
  func2(func1(1))
  result.toPrint

  val f = (x:Int) => x*2
  val f2 = f
  f

  f2(2).toPrint


  final case class Box[A](value:A)
  
  val box = Box[Int](21)

}
