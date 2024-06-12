package scalaCats

object Generics extends App {

  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  val circles: List[Circle] = List(Circle(3.4))
  val shapes: List[Shape] = circles
}
