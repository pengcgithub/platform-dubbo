package com.tracy.api.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * @author pengc
 * @see com.tracy.api.user.entity
 * @since 2018/6/11
 */
@Data
public class UserBean implements Serializable {
	
	private String id;
	
	private String userName;
	
	private long userPhone;
	
	//这里展示了jackson封装好的以及自定义的对时间格式的转换方式
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifyTime;
	
	private int score;

}
