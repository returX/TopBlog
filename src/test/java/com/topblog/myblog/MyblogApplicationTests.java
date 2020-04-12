package com.topblog.myblog;

import com.topblog.myblog.dao.ArticleRepository;
import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.model.vo.ResponseMsg;
import com.topblog.myblog.service.ArticleService;
import com.topblog.myblog.service.TagService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
class MyblogApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MyblogApplicationTests.class);

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;

    @Test
    void contextLoads() {
        PageDTO pageDTO = new PageDTO(0,3,"DESC","articleId",-1);
        Page<Article> articles = articleService.getPage(pageDTO);
        log.info("{}",articles.isFirst());
    }

    @Test
    void getByTagWithPage(){
        PageDTO pageDTO = new PageDTO(0,3,"DESC","articleId",1);
        Page<Article> articles = articleService.getPage(pageDTO);
        log.info("{}",articles.getContent());
    }

    @Test
    @Transactional
    void getArticleTest(){
        Article one = articleRepository.getOne(1);
        log.info("{}",one);
    }

    /**
     *获取所有tag的测试
     */
    @Test
    void tagTest(){
        tagService.listTag();
    }

    @Test
    void articleCreateTest(){
        Article article = new Article(null,"dsfsdfsdf","<p>sdfsdfsdf</p>","sdfsdfsdf","",LocalDateTime.now(),0,0,0,4);
        ResponseMsg msg = articleService.addArticle(article);
        log.info("添加信息{}",msg);
    }

}
