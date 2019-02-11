package com.tracy.service.api.userSearch.service.impl;

import com.tracy.api.search.service.userSearch.UserSearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
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

//    @Autowired
//    private SolrTemplate solrTemplate;

    @Autowired
    private SolrClient solrClient;

    public Boolean importAllItems() {
        return null;
    }

    public String searchItems(String queryString, Integer page, Integer rows) throws Exception {
//        SimpleQuery simpleQuery = new SimpleQuery("*:*");
//        Map<String, Object> solrItems = solrTemplate.query("store_v1", simpleQuery, Map.class);

        SolrQuery query = new SolrQuery();
        query.set("q", "*:*");
        QueryResponse response = solrClient.query("store_v1", query);
        SolrDocumentList list = response.getResults();

        for (SolrDocument solrDocument : list) {
            System.out.println(solrDocument.get("belongName"));
        }

        return null;
    }

}
