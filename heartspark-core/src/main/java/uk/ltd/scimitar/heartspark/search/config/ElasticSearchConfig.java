package uk.ltd.scimitar.heartspark.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    private String elasticSearchHost;

    @Autowired
    public ElasticSearchConfig(@Value("${elasticsearch.host}") final String elasticSearchHost) {
        this.elasticSearchHost = elasticSearchHost;
    }

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(elasticSearchHost)));
    }

}
