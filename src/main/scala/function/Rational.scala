package function

/**
  * Created by zhuifeng on 2017/5/12.
  */
//n
//val 定义同名的类参数和字段
//private[this] val,就不能使用other.d
class Rational(n: Int, private val d: Int) {
  require(d != 0)//既不是字段又不是方法定义的代码放入主构造器中
  private val g = gcd(n.abs, d.abs)
  val number = n / g
  val demon = d / g
  def this(n: Int) = this(n, 1)//辅助构造器
  override def toString: String = n + "/" + d
  def add(other: Rational) = {
//    new Rational(number * other.demon + demon * other.number,demon * other.demon)
    new Rational(number * other.d / g + d / g * other.number,d * other.d / g / g)
  }
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  def + (other: Rational) = new Rational(number * other.demon + demon * other.number,demon * other.demon)
  def + (other: Int) = new Rational(number + demon * other,demon)//重载
  def * (other: Rational) = new Rational(number * other.number,demon * other.demon)
  def * (other: Int) = new Rational(number * other,demon)
}
object Rational{
  implicit def intToRational(x: Int) = new Rational(x)
  def main(args: Array[String]): Unit = {
    val a = new Rational(1)
    val b = new Rational(2)
    val c = new Rational(3)
    println(a + b * c)
    println(1 + b * c)
  }
}