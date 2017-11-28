package com.cx.scala

import org.apache.spark.{SparkConf, SparkContext}

object CacheTest {
  def main(args: Array[String]): Unit = {

    //创建Spark运行时的配置对象，在配置对象里面可以设置APP name，集群URL以及运行时各种资源需求
    val sparkConf = new SparkConf()
      .setAppName("CacheTest")
      .setMaster("local")
    //      .setMaster("local")

    //创建SparkContext上下文环境，通过传入配置对象实例化一个SparkContext
    val sc = new SparkContext(sparkConf)
    
    
    /**
     * cache算子使用的注意事项：
     * 	1、cache算子是一个懒执行算子，需要有action类算子触发执行
     * 	2、对某一个算子执行cache算子后，需要将返回结果赋值给一个变量，在接下来的job直接使用这个变量那么就能够读取到缓存的数据    
     * 	3、如果想释放掉缓存到内存中的数据，使用unpersist方法，unpersist方法是以立即执行的算子
     */
    var rdd1 = sc.textFile("hs_err_pid5848.log")
    val startTime = System.currentTimeMillis()
    rdd1 = rdd1.cache()
    
    val count = rdd1.count()
    
    val endTime = System.currentTimeMillis()
    println("job0 durations:" + (endTime - startTime) + "\tresult:" + count)
    
    val startTime1 = System.currentTimeMillis()
    val count1 = rdd1.count()
    val endTime1 = System.currentTimeMillis()
    println("job1 durations:" + (endTime1 - startTime1) + "\tresult:" + count1)
    
    sc.stop()
  }
}