package com.lu.usermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.lu.usermanager.common.utils.PageUtils;
import com.lu.usermanager.entity.CommentEntity;

import java.util.Map;

/**
 * 
 *
 * @author lu
 * @email 1157076680@qq.com
 * @date 2020-06-25 08:12:53
 */
public interface CommentService extends IService<CommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

