package com.tracy.api.search.service.userSearch;

/**
 * <br/>
 *
 * @author pengc
 * @see com.tracy.api.search.service
 * @since 2018/7/30
 */
public interface UserSearchService {

    Boolean importAllItems();

    String searchItems(String queryString, Integer page, Integer rows) throws Exception;

}
