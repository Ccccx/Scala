package com.cx.scala

/**
  *
  * @auther CX
  * @create 2017/11/28
  */
class Person (xname:String,xage:Int) {
  var name = Test.name
  val age = 18
  var gender = "男"
  def this(xname:String,xage:Int,xgender:String){
    this(xname,xage)
    this.gender = xgender
  }
  def say(): Unit ={
    "name:" + name + " age:" + age
  }
}
object Test{
  val name = "lisi"
  def main(args: Array[String]): Unit = {
    var person = new Person("fanbingbing",20,"女")
    println(person.name)
    println(person.age)
    println("***********************************")
    println( 1 to 10)
    println( 1 until 10 )
    println(1 to (10,3))
    println(1 until (10,3))
    println("***********************************")
    for ( i <- 1 to 10){
        print(i + "\t")
    }
    println()
    for ( i <- 1 until  10){
      print(i + "\t")
    }
    println()
    println("***********************************")
    for ( i <- 1 to 10; if i%2 ==0){
      print(i + "\t")
    }
    println()
    println("***********************************")
    for ( i <- 1 to 10; if i%2 ==0 ; if i == 4){
      print(i + "\t")
    }
    println()
    println("***********************************")
    def fun1 (a:Int,b:Int):Unit = {
      println (a+b)
    }
    fun1(1,2)
    def fun2 (a:Int,b:Int) = a + b
    println(fun2(3,4))
    println("***********************************")

    var fun3 = (a:Int)=>println(a+12)
    fun3(6666)
  }


}
