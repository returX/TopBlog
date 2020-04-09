package com.topblog.myblog.service.impl;

import com.topblog.myblog.dao.ArticleRepository;
import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: RETURN
 * @Date: 2020/4/3 23:41
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
    
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Page<Article> getPage(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPageNo(),pageDTO.getSum(),Sort.Direction.fromString(pageDTO.getDirection()),pageDTO.getProperty());
        Page<Article> articles = null;
        if (pageDTO.getTag() != -1){
            articles = articleRepository.findInfoByTagId(pageable,pageDTO.getTag());
        }else {
            articles = articleRepository.findInfo(pageable);
        }
        log.info("获取第{}页文章,共{}篇",articles.getNumber()+1,articles.getContent().size());
        return articles;
    }
}
