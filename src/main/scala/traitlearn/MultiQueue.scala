package traitlearn

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zhuifeng on 2017/5/15.
  */
abstract class IntQueue {
  def put(x:Int)
  def get:Int
}

class BasicIntQueue extends IntQueue{
  val buffer = new ArrayBuffer[Int]()
  override def put(x: Int): Unit = buffer.append(x)

  override def get: Int = buffer.remove(0)
}

trait Doubling extends IntQueue{
  abstract override def put(x: Int): Unit =  super.put(2 * x)
}

trait Incrementing extends IntQueue{
  abstract override def put(x: Int): Unit =  super.put(x + 1)
}

trait Filtering extends IntQueue{
  abstract override def put(x: Int): Unit =  if(x >= 0) super.put(x)
}
class MultiQueue extends BasicIntQueue with Incrementing with Doubling with Filtering

object MultiQueue{
  def main(args: Array[String]): Unit = {
    val queue = new MultiQueue
    queue.put(-1)
    queue.put(2)
    queue.put(5)
    println(s"first element:${queue.get}")
    println(s"second element:${queue.get}")
  }
}
