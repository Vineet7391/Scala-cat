case class Person(name:String, age:String)

val person = Person("hello", "25")

val mapRe = person.productElementNames.flatMap(ele => person.productIterator.map(value => (ele -> value)))

mapRe.foreach(println)
person.productIterator.foreach(println)