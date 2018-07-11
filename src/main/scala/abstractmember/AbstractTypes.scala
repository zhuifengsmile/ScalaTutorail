package abstractmember

/**
  * Created by zhuifeng on 2017/5/20.
  */
class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) {println("++++++++++")}
}

object AnimalEatFood{
  def main(args: Array[String]): Unit = {
    class Fish extends Food
    val bessy1 = new Cow
    val bessy2 = new Cow
    bessy2 eat (new bessy1.SuitableFood)
    bessy1 eat (new bessy1.SuitableFood)
    val animal: Animal = bessy1
//    println(new animal.SuitableFood)
//    animal eat (new animal.SuitableFood)
  }
}
class A{
  class B
  private val b1 = new B
}
class c extends A{
  private val b1 = new B
}
