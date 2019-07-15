package uk.ltd.scimitar.heartspark.search.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

@Component
public class Indexer implements Serializable {

    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Autowired
    public Indexer(RestHighLevelClient client,
                   ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public String index(String id, Object object) {
        final Map documentMapper = objectMapper.convertValue(object, Map.class);
        final IndexRequest indexRequest = new IndexRequest("heartspark", "profile", id)
                .source(documentMapper);
        return index(indexRequest);
    }

    private String index(final IndexRequest request) {
        try {
            return client.index(request, RequestOptions.DEFAULT).getResult().name();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
