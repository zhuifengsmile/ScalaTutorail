package ControlAbstraction

/**
  * Created by zhuifeng on 2017/5/14.
  */
object ReduceCode {
  val files = Array("Student.scala","Student.java")
  def fileContains(query: String) = {
    for{
      file <- files
      if file.contains(query)
    } yield file
  }
  def fileEndWith(query: String) = {
    for{
      file <- files
      if file.endsWith(query)
    } yield file
  }
  def fileMatch(query: String) = {
    for{
      file <- files
      if file.matches(query)
    } yield file
  }

  def fileFind(query: String, matcher: (String, String) => Boolean) = {
    for{
      file <- files
      if matcher(file, query)
    } yield file
  }

  def fileSearch(matcher: (String) => Boolean) = {
    for{
      file <- files
      if matcher(file)
    } yield file
  }
  def main(args: Array[String]): Unit = {
    println(fileEndWith("scala").mkString(","))
    println(fileFind("scala", _.endsWith(_)).mkString(","))
    println(fileSearch(_.endsWith("scala")).mkString(","))
  }
}
