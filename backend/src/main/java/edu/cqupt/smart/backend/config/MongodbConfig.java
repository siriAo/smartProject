package edu.cqupt.smart.backend.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import edu.cqupt.smart.backend.util.MongoUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;


/**
 * @Package_Name: edu.cqupt.smart.backend.config
 * @Description: TODO
 * @Date: 2024/2/19 16:51
 * @Created: SiriAo
 */
@Configuration
public class MongodbConfig {
    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Value("${spring.data.mongodb.database}")
    private String dataBase;

    public @Bean MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    public @Bean MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, dataBase);
    }

    public @Bean MongoUtil mongoInfo(MongoOperations mongoOp) {
        return new MongoUtil(mongoOp.estimatedCount(dataBase));
    }
}
