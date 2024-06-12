package scalaCats

object HigherKindedTypes extends App {

  trait Wrapper[F] {
    def value: F
  }

  case class OptionWrapper[A](v: Option[A]) extends Wrapper[Option[A]] {
    override def value: Option[A] = v
  }

  // HKT

  trait WrapperH[F[_]] {
    def create[A](value: A): F[A]
  }

  class WrapperHC extends WrapperH[Option] {
    override def create[A](value: A): Option[A] = Option(value)
  }

  val wrapperH: WrapperH[Option] = new WrapperH[Option] {
    override def create[A](value: A): Option[A] = Option(value)
  }

  println(wrapperH.create("hello"))


}
