package com.topblog.myblog;

import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class MyblogApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MyblogApplicationTests.class);

    @Autowired
    ArticleService articleService;

    @Test
    void contextLoads() {
        PageDTO pageDTO = new PageDTO(0,3,"DESC","articleId");
        Page<Article> articles = articleService.getPage(pageDTO);
        log.info("{}",articles.isFirst());
    }

}
