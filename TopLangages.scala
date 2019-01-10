import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;

System.setProperty("hadoop.home.dir", "/C:/spark/bin/");
// initialise spark context
val conf = new SparkConf().setAppName("PbSpark").setMaster("local[2]").set("spark.executor.memory", "4g");
val sc = new SparkContext(conf);

val sqlContext = new SQLContext(sc);
val EntertainmentTable = sqlContext.jsonFile("C:/tweetsiphone6s.json");
EntertainmentTable.registerTempTable("EntertainmentTable");
//EntertainmentTable.printSchema();
val maxTweets = sqlContext.sql("SELECT text as t FROM EntertainmentTable");
maxTweets.show();
maxTweets.rdd.saveAsTextFile("C:/LangTweets");

