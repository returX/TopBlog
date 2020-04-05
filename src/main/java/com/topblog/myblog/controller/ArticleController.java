package com.topblog.myblog.controller;

import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: RETURN
 * @Date: 2020/3/31 22:41
 */
@Controller
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;

    /**
     * 获取文章列表
     * @return
     */
    @GetMapping({"/articles","/"})
    public String listArticles(Model model, Integer pageNo,Integer sum,String direction,String property){
        List list = new ArrayList();
        PageDTO pageDTO = new PageDTO(pageNo,sum,direction,property);
        Page<Article> articles = articleService.getPage(pageDTO);
        model.addAttribute("articles",articles);
        return "index";
    }

}
