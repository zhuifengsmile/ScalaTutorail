package statefulobject

/**
  * Created by zhuifeng on 2017/5/20.
  */
class MergeSort[T] {
  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(orderedMergeSort(ys), orderedMergeSort(zs))
    }
  }
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound(rest)
        if (x > maxRest) x
        else maxRest
    }

  def maxListImpParm[T](elements: List[T])
                       (implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(orderer)
        if (orderer(x) > maxRest) x
        else maxRest
    }
  /*
  def maxList[T](elements: List[T])
                (implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)  // (orderer) is implicit
        if (x > maxRest) x           // orderer(x) is implicit
        else maxRest
    }
    */
  //You can think of “T <% Ordered[T]” as saying, “I can use any T, so long as T can be treated as an Ordered[T].”
  def maxList[T <% Ordered[T]](elements: List[T]): T = elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest)  // (orderer) is implicit
      if (x > maxRest) x           // orderer(x) is implicit
      else maxRest
  }



}
