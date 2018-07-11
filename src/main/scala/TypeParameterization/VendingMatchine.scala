package TypeParameterization

import scala.collection.immutable.Queue

/**
  * Created by zhuifeng on 2017/5/19.
  */
class VendingMachine[+A](currentItem: Option[A], items: List[A]) {

  def this(items: List[A]) = this(None, items)

  def dispenseNext(): VendingMachine[A] =
    items match {
      case Nil => {
        if (currentItem.isDefined)
          new VendingMachine(None, Nil)
        else
          this
      }
      case t :: ts => {
        new VendingMachine(Some(t), ts)
      }
    }

  def addAll[B >: A](newItems: List[B]): VendingMachine[B] =
    new VendingMachine(items ++ newItems)
}

class GarbageCan[-A] {

  // compiles because of object private scope
  private[this] var items: List[A] = List.empty

  def put(item: A): Unit = this.items :+= item

  def putAll(items: List[A]): Unit = this.items ++= items

  def itemsCount: Int = this.items.size

}

class Publication(val title: String)
class Book(title: String) extends Publication(title)
object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )
  def printBookList(info: Book => AnyRef) {
    for (book <- books) println(info(book))
  }
}
class Student{
  private var name:String = "abc"
  def append(other: Student) = {name + other.name}
}
object Customer{
  def main(args: Array[String]): Unit = {
    def getTitle(p: Publication): String = p.title
    Library.printBookList(getTitle)
    val queue = Queue(1,2,3)
    val student = new Student;
  }
}
