package com.lu.usermanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author lu
 * @email 1157076680@qq.com
 * @date 2020-06-25 08:12:53
 */
@Data
@TableName("m_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private Integer stars;
	/**
	 * 
	 */
	private String times;
	/**
	 * 
	 */
	private String comments;

}
