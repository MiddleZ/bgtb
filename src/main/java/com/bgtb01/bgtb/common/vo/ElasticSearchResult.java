package com.bgtb01.bgtb.common.vo;

import lombok.Data;
import org.elasticsearch.client.RestClient;

@Data
public class ElasticSearchResult {

    private RestClient restClient;
}
