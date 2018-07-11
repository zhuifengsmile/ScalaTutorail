package TypeParameterization

/**
  * Created by zhuifeng on 2017/5/18.
  */
class Cell[+T](val init: T) {
  private[this] var current = init
  def get = current
  def set[U>: T](x: U) = x
}

object Cell{
  def main(args: Array[String]): Unit = {
    val cell: Cell[AnyVal] = new Cell[Int](3)
    cell.set(cell)
  }
}
