package com.tracy.api.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;


@Data
public class UserBean implements Serializable{
	
	private long userId;
	
	private String userName;
	
	private long userPhone;
	
	//这里展示了jackson封装好的以及自定义的对时间格式的转换方式
	//后续对于一些复杂的转换可以自定义转换方式
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	
	private int score;

}
