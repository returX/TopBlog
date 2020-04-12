package com.topblog.myblog.service.impl;

import com.topblog.myblog.dao.ArticleRepository;
import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.model.vo.ResponseMsg;
import com.topblog.myblog.service.ArticleService;
import com.topblog.myblog.service.TagService;
import com.topblog.myblog.util.InfoUtil;
import com.topblog.myblog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: RETURN
 * @Date: 2020/4/3 23:41
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
    
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    TagService tagService;

    @Override
    public Page<Article> getPage(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPageNo(),pageDTO.getSum(),Sort.Direction.fromString(pageDTO.getDirection()),pageDTO.getProperty());
        Page<Article> articles = null;
        //tag默认为-1，是查找全部类别
        if (pageDTO.getTag() != -1){
            //根据tagId查找类别
            articles = articleRepository.findInfoByTagId(pageable,pageDTO.getTag());
        }else {
            //查找全部类别
            articles = articleRepository.findInfo(pageable);
        }
        log.info("获取第{}页文章,共{}篇",articles.getNumber()+1,articles.getContent().size());
        log.info("{}",articles.getContent().get(0));
        return articles;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMsg addArticle(Article article){
        article.setArticleContentInfo(InfoUtil.htmlToText(article.getArticleContentHtml()));
        articleRepository.save(article);
        tagService.tagIncrement(article.getArticleTagId());
        return ResultUtil.success("文章添加成功");
    }
}
