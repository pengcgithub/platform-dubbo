package com.tracy.api.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * @author pengc
 * @see com.tracy.api.user.entity
 * @since 2018/6/11
 */
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
