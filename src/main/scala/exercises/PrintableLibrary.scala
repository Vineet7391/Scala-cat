package exercises

object PrintableLibrary {

  trait Printable[A] {
    def format(value: A): Unit
  }



  object PrintableInstances {
    implicit def printAny[A]: Printable[A] = (value: A) => println(value)
  }

  object PrintSyntax {
    implicit class PrintOps[A](value: A) {
      def toPrint(implicit w: Printable[A]): Unit =
        w.format(value)
    }
  }


}