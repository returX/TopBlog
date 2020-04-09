package com.topblog.myblog.service.impl;

import com.topblog.myblog.dao.ArticleTagsRepository;
import com.topblog.myblog.dao.TagRepository;
import com.topblog.myblog.model.entity.Tags;
import com.topblog.myblog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: RETURN
 * @Date: 2020/4/7 21:04
 */
@Service
public class TagServiceImpl implements TagService {

    private static final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);


    @Autowired
    TagRepository tagRepository;
    @Autowired
    ArticleTagsRepository articleTagsRepository;

    @Override
    public List<Tags> listTag() {
        List<Tags> tags = tagRepository.findAll();
        log.info("分类数：{}种",tags.size());
        return tags;
    }
}
