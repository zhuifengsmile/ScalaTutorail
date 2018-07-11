package abstractmember

/**
  * Created by zhuifeng on 2017/5/20.
  */

//类参数在被传递给类构造器之前计算，对于抽象val的实现，在超类完成了初始化之后执行
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer +"/"+ denom
}

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer +"/"+ denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}


object RationalTraits{
  def main(args: Array[String]): Unit = {
    new RationalTrait {
      val numerArg = 1 + 2
      val denomArg = 2 + 3
    }

    new {
      val numerArg = 1 + 2
      val denomArg = 2 + 3//预初始化，在超类构造器之前执行
    } with RationalTrait

    object twoThirds extends {
      val numerArg = 2
      val denomArg = 3
    } with RationalTrait
  }
}

