package com.cx.scala

import org.apache.spark.{SparkConf, SparkContext}


object SchoolCount {
  def main(args: Array[String]): Unit = {
    var config = new SparkConf()
        .setAppName("SchoolCount").setMaster("local")

    var sc = new SparkContext(config)

    val rdd1 = sc.textFile("log.txt")

    var rdd2 = rdd1.map(x=>{
      x.split("\t")(1)
    })

    var rdd3 =rdd2.map(x=>{
      (x,1)
    })

    var rdd4 = rdd3.reduceByKey((v1:Int,v2:Int)=>{
      v1+v2
    })

    var rdd5 =rdd4.sortBy((x:(String,Int))=>x._2,false)

    val arr = rdd5.take(1)
    var schoolName = arr(0)._1
    println(schoolName)

    var result = rdd1.filter(x=>{
      !schoolName.equals(x.split("\t")(1))

    })

    result.saveAsTextFile("result")

    sc.stop()
  }
}
