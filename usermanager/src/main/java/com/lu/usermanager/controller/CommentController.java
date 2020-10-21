package com.lu.usermanager.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lu.usermanager.common.utils.PageUtils;
import com.lu.usermanager.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lu.usermanager.entity.CommentEntity;
import com.lu.usermanager.service.CommentService;




/**
 * 
 *
 * @author lu
 * @email 1157076680@qq.com
 * @date 2020-06-25 08:12:53
 */
@RestController
@RequestMapping("usermanager/comment")
@CrossOrigin( origins="http://localhost:8080")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   /* @RequiresPermissions("usermanager:comment:list")*/
    public R list(){
        List<CommentEntity> list = commentService.list();

        return R.ok().put("page", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
   /* @RequiresPermissions("usermanager:comment:info")*/
    public R info(Integer id){
		CommentEntity comment = commentService.getById(id);

        return R.ok().put("comment", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   /* @RequiresPermissions("usermanager:comment:save")*/
    public R save(CommentEntity comment){
		commentService.save(comment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   /* @RequiresPermissions("usermanager:comment:update")*/
    public R update(CommentEntity comment){
		commentService.updateById(comment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    /*@RequiresPermissions("usermanager:comment:delete")*/
    public R delete(Integer[] ids){
		commentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
