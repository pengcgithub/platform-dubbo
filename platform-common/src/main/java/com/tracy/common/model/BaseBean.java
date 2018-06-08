package com.tracy.common.model;

import lombok.Data;

/**
 * 基础bean对象<br/>
 *
 * @author pengc
 * @see com.tracy.common.model
 * @since 2018/6/8
 */
@Data
public class BaseBean {

    private String id;

    private int page;

    private int rows;

}
