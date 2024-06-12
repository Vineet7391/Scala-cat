package scalaCats

import cats._
import cats.syntax.all._

import java.util.Date

//import cats.instances.int._
import cats.instances.all._

object MeetCats extends App {

  val a = 23.show

  val one = 1
  val anotherOne = 1

  final case class Person(Id: Int, name: String) {
    override def hashCode(): Int = Id.hashCode()
  }


  println(one =!= anotherOne)
  println(one == "1")
  println((Some(1): Option[Int]) === (None: Option[Int]))
  val x = new Date() // now
  val y = new Date() // a bit later than no
  implicit val eqDate: Eq[Date] = { (date1, date2) => date1.getTime === date2.getTime }
  println(x === y)

  val person1 = Person(1, "Ram")
  val person2 = Person(1, "Rama")
  implicit val eqPerson: Eq[Person] = { (p1, p2) => p1.hashCode() === p2.hashCode() }
  println(person1 === person2)

}