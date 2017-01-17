package pl.edu.agh.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Value("${spark.master.endpoint}")
    private String sparkMasterEndpoint;

    @Value("${cassandra.contact.endpoints}")
    private String cassandraContactPoints;

    @Bean
    public JavaSparkContext javaSparkContext() {
        SparkConf conf = new SparkConf();
        conf.setAppName("ADT Analysis");
        conf.setMaster("spark://" + sparkMasterEndpoint);
        conf.set("spark.cassandra.connection.host", cassandraContactPoints);
        return new JavaSparkContext(conf);
    }
}
