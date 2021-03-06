val movies_rdd=sc.textFile("hdfs://127.0.0.1:9000/user/spark/movies.txt")
val genres=movies_rdd.map(lines=>lines.split("::")(2))
val testing=genres.flatMap(line=>line.split('|'))
val genres_distinct_sorted=testing.distinct().sortBy(_(0))
genres_distinct_sorted.saveAsTextFile("result")
System.exit(0)
