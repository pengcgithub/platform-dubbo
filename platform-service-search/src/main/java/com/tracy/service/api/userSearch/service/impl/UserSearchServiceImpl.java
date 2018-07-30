package com.tracy.service.api.userSearch.service.impl;

import com.tracy.api.search.service.userSearch.UserSearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.service.api.userSearch.service.impl
 * @since 2018/7/30
 */
@Service(value = "userSearchService")
public class UserSearchServiceImpl implements UserSearchService {

    @Autowired
    private HttpSolrClient client;

    public Boolean importAllItems() {
        return null;
    }

    public String searchItems(String queryString, Integer page, Integer rows) throws Exception {
        SolrQuery solr = new SolrQuery();
        solr.setQuery("productName:苹果");
        QueryResponse queryResponse = client.query(solr);
        queryResponse.getResults();

        return null;
    }

}
