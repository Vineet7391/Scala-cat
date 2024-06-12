package scalaCats

import cats.Monad
import cats.syntax.monad
import cats.instances.option._
import cats.syntax.flatMap._
import cats.syntax.applicative._
import cats.syntax.functor._ // for map
import cats.Id


object MonadsExample extends App {

  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption

  def divide(a: Int, b: Int): Option[Int] =
    if (b == 0) None else Some(a / b)

  val int = None: Option[Int]

  def stringDivideBy(aStr: String, bStr: String): Option[Int] =
    for {
      int1 <- int
      aNum <- parseInt(aStr)
      bNum <- parseInt(bStr)
      ans <- divide(aNum, bNum)
    } yield ans


  println(stringDivideBy("1", "1"))

  val opt = Monad[Option].pure(1)
  val opt1 = Monad[Option].flatMap(opt)(s => Some(s + 3))
  val opt2 = Monad[Option].flatMap(opt1)(s => Some(s + 1))
  val addOne: Int => Option[Int] = (x: Int) => (x + 1).pure
  opt2 match {
    case Some(value) => println(value)
    case None => println(None)
  }

  val opt3 = opt flatMap addOne

  val opt4 = 3.pure[Option] flatMap addOne
  println(opt3)

  def sumSquare[F[_]:Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield x * x + y * y

  println(sumSquare(2: Id[Int], 3 :Id[Int]))

}
