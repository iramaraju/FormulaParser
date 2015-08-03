import com.vec.test._
import com.cloudera.sparkts._ 
import breeze.linalg._
import com.cloudera.sparkts.DateTimeIndex._
import com.github.nscala_time.time.Imports._
import org.apache.spark.{SparkContext, SparkConf}
import breeze.linalg._
import org.joda.time._




object ar {
  /* funcrev and up  */ 

  def main(args: Array[String]) {
     
 val conf = new SparkConf()
    .setSparkHome("/home/ram/dev/spark-1.4.0-bin-hadoop2.6/")
    .setMaster("spark://localhost:7077")
    .setAppName("timeseries")
    .set("spark.executor.cores", "1")
    .set("spark.executor.memory", "1g")
    .setJars(Seq("lib/sparktimeseries-0.0.1-jar-with-dependencies.jar","target/scala-2.10/timeseries_2.10-1.0.jar"))

    TimeSeriesKryoRegistrator.registerKryoClasses(conf)

/*** 
      val inarr = Array(1,2,3,4,5,6,7,8)
      var expr = "2 ^ @val + 3"
      inarr.map(d=>funcs.processin(d.toDouble,expr)).foreach(println)
      expr = "@val ^ 2 + ln(@val)"
      inarr.map(d=>funcs.processin(d.toDouble,expr)).foreach(println)
***/


      val vecs = Array(0 until 10, 10 until 20, 20 until 30).
                 map(_.map(x => x.toDouble).toArray).
                 map(new DenseVector(_)).
                 map(x => (x(0).toString, x))
      val sc = new org.apache.spark.SparkContext(conf)
      val vsqlContext = new org.apache.spark.sql.SQLContext(sc)

    val start = new DateTime("2015-4-9")
    val index = uniform(start, 10, 1.days)
    
    val rdd = new TimeSeriesRDD(index, sc.parallelize(vecs))
    val slice = rdd.slice(start + 1.days, start + 6.days)
    val contents = slice.collectAsMap()
    println("Count:"+contents.toArray.length)
    sc.stop()
  }

  def processFunction1(): Unit = {

    spark_Process1
    spark_process2
    ???
  }

  def spark_Process1: Unit = {
    ???
    /*


     */
  }

  def spark_process2: Unit = {

    ???
  }

  def getTSRdd(mydf : org.apache.spark.sql.DataFrame) :TimeSeriesRDD = {

    ???
    /*
      ts(DateTime, DenseVector, LabelArray)

     */
  }

  def udf(x :Double , map :Map, eqn :String ) = {
      /*
      col1 ->  1.111
      col2 ->  2,34
      col3  -> 44,4

       */
    /*
     weqn = "col1 * 2 + col2 /5 + ln(col3)"

     */

  ???

  }

}

