package statefulobject

import scala.collection.immutable.Queue

/**
  * Created by zhuifeng on 2017/5/17.
  */
class Time {
  var h = 24
  def hour = h % 12
  def hour_= (hours: Int) {
    h = (hours + 24)
  }
}


object Time{
  def main(args: Array[String]): Unit = {
    val time = new Time
    println(s"h is ${time.h}")
    println(s"hour is ${time.hour}")
    time.h = 25
    println(s"h is ${time.h}")
    println(s"hour is ${time.hour}")
    time.hour_=(3)
    println(s"h is ${time.h}")
    println(s"hour is ${time.hour}")
    val a = List(1,2,3,4)
    a.head
    a.tail
    a.init
    a.last
  }
}
