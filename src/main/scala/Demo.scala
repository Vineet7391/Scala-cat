
import exercises.PrintableLibrary.PrintSyntax.PrintOps
import exercises.PrintableLibrary.PrintableInstances.printAny


object Demo extends App {

  final case class Employee(name: String, salary: Double)

  implicit val employeeOrdering: Ordering[Employee] = (x: Employee, y: Employee) => y.salary.compare(x.salary)


  def topNPercent[A](list: List[A], n: Double)(implicit o: Ordering[A]): List[A] = {
    val count = math.ceil(list.size * n).toInt
    list.sorted.take(count)
  }

  val listEmp = List(Employee("ram", 1000), Employee("Mohan", 20000), Employee("Vijay", 30000), Employee("Vijay", 40000), Employee("Vijay", 50000), Employee("Vijay", 60000), Employee("Modi", 60000), Employee("Yogi", 60000), Employee("Rajnath", 60000), Employee("Rahul", 60000))
  val employees = List(
    Employee("Alice", 50000),
    Employee("Bob", 60000),
    Employee("Charlie", 70000),
    Employee("Diana", 80000),
    Employee("Eve", 90000)
  )

  employees.sorted.toPrint

  val data = (listEmp.size * 0.26).toInt
  val afterDotData = (listEmp.size * 0.25) - data.toDouble
  (1.4 - 1).toPrint

  case class User(name: String, salary: Double) extends Ordered[User] {
    override def compare(that: User): Int = that.name.compare(this.name)
  }

  val u1 = User("ram", 100)
  val u2 = User("rama", 100)


}

