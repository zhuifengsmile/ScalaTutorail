package listuse

/**
  * Created by zhuifeng on 2017/5/16.
  */
object SortList {
  def insert(x:Int, xs: List[Int]): List[Int] = {
    xs match {
      case Nil => List(x)
      case y :: ys => if(x < y) x::xs else y::insert(x,ys)
    }
  }
  def sort(x : List[Int]) = {
    x match {
      case Nil => Nil
      case x :: xs => insert(x, xs)
    }
  }
  def mSort[T](less: (T,T) => Boolean) (list:List[T]): List[T] = {
    def merge(left:List[T], right:List[T]): List[T] = {
      (left,right) match {
        case (Nil,_) => right
        case (_,Nil) => left
        case (x :: xs, y :: ys) =>
          if(less(x,y)) x :: merge(xs, right)
          else y :: merge(left, ys)
      }
    }
    val halfLength = list.length / 2
    if(halfLength == 0) list
    else {
      val (first, second) = list splitAt halfLength
      merge(mSort(less)(first), mSort(less) (second))
    }
  }
  def append[T](left:List[T], right: List[T]): List[T] = {
    left match {
      case Nil => right
      case x :: xs => x :: append(xs, right)
    }
  }

  def main(args: Array[String]): Unit = {
    val intSort = mSort((x : Int,y : Int) => x < y) _
    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    println(intSort(mixedInts))
    println(append(List(1,2,3), List(4,5,6)))
    val a = List(List(1,2),List(3,4))
    a flatMap( x => x.map(_ + 1))
  }
}
