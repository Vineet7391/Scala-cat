package scalaCats
import exercises.PrintableLibrary.PrintSyntax.PrintOps
import exercises.PrintableLibrary.PrintableInstances._

object TypeClasses extends App {


  // Type classes
  trait Json

  final case class JsObject(get: Map[String, Json]) extends Json

  final case class JsString(get: String) extends Json

  final case class JsNum(get: Double) extends Json

  case object JsNull extends Json

  trait JsonWriter[A] {
    def write(value: A): Json
  }
  // JsonWriter is our type class in this example, with Json and its subtypes providing supporting code.

  // Type Class Instances

  final case class Person(name: String, age: Double)

  implicit val jsString: JsonWriter[String] = (value: String) => JsString(value)
  implicit val jsPerson: JsonWriter[Person] = (value: Person) => JsObject(Map("name" -> JsString(value.name), "age" -> JsNum(value.age)))
  implicit val jsNum: JsonWriter[Double] = (value: Double) => JsNum(value)

  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = {
    case Some(value) => writer.write(value)
    case None => JsNull
  }

  // End

  //Type Class Interfaces
  // There are two common ways of specifying an interface: Interface Objects and Interface Syntax.

  // Interface object
  object Json {
    def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }

  // Interface syntax
  object JsonSyntax {
    implicit class JsonWriterOps[A](value: A) {
      def toJson(implicit w: JsonWriter[A]): Json =
        w.write(value)
    }
  }

  import JsonSyntax.JsonWriterOps
  // end

  val person = Person("Manoj", 34)

  val jsPerson1 = person.toJson
  val jsPerson2 = Json.toJson(person)(jsPerson)
  val jsPerson3 = new JsonWriterOps[Person](person).toJson(jsPerson)
  val jsOption: Option[Person] = Some(person)
  val jsString1 = "hello world".toJson
  val jsOptionString1 = Option("hello World").toJson
  val noneJS = jsOption.toJson
  val jsNum1 = 55.4.toJson

  jsPerson1.toPrint
  println(jsPerson2)
  println(jsPerson3)
  println(jsString1)
  println(jsNum1)
  println(jsOptionString1)
  println(noneJS)

 "hello world from to print".toPrint
}

