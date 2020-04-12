package com.topblog.myblog.service;

import com.topblog.myblog.model.entity.Tags;

import java.util.List;

/**
 * @Author: RETURN
 * @Date: 2020/4/7 21:04
 */
public interface TagService {
    /**
     *获取分类
     */
    List<Tags> listTag();

    /**
     *tag自增1
     */
    Integer tagIncrement(Integer tagId);
}
