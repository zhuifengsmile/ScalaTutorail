package casematch

/**
  * Created by zhuifeng on 2017/5/15.
  */
class MatchType {

}

object MatchType{
  def main(args: Array[String]): Unit = {
    val a = 3
    val b = "name"
    b match {
        //变量可以匹配任何输入
      case a => println(s"b is:${b}, a is:${a}")
    }
    val c = "names"
    val d = (c: @unchecked) match {
      case "names" => c
    }
    println(s"d is:${d}")
  }
}
