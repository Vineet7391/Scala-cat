package scalaCats

import cats._
import cats.syntax.monoid._

import java.util.Date
//import cats.syntax.semigroup._
import cats.instances.int._ // for Monoid
import cats.instances.option._ // for Monoid

object MonoidsAndSemigroup extends App {

  trait Semigroup[T] {
    def combine(a: T, b: T): T
  }

  val combineInt: Semigroup[Int] = (a: Int, b: Int) => a + b
  val combineString = (a: String, b: String) => a + b


  val combine = Monoid[Int].combine(1, 2)
  //  println(combine)
  //  println(2 |+| 1 |+| Monoid[Int].empty)

  val combineOption = Monoid.combine(Option(1), Option(2))
  //  println(combineOption)

  def add[A](list: List[A])(implicit monoid: Monoid[A]): A = {
    list.foldLeft(monoid.empty)(_ |+| _)
  }

  val list: List[Int] = (0 to 1000000).toList
  val q = ((new Date).getTime)
  println(add(list))
  val p = ((new Date).getTime)
  println(p-q)

}
