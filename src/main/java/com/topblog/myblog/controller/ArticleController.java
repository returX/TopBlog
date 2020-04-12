package com.topblog.myblog.controller;

import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import com.topblog.myblog.model.entity.Tags;
import com.topblog.myblog.model.vo.ResponseMsg;
import com.topblog.myblog.service.ArticleService;
import com.topblog.myblog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    TagService tagService;

    /**
     * 获取文章列表
     * @return
     */
    @GetMapping({"/articles","/"})
    public String listArticles(Model model, Integer pageNo, Integer sum, String direction, String property, Integer tagId){
        PageDTO pageDTO = new PageDTO(pageNo,sum,direction,property,tagId);
        Page<Article> articles = articleService.getPage(pageDTO);
        List<Tags> tags = tagService.listTag();
        model.addAttribute("articles",articles);
        model.addAttribute("tid", tagId);
        model.addAttribute("tags",tags);
        return "index";
    }

    @RequestMapping("md")
    public String md(Model model){
        List<Tags> tags = tagService.listTag();
        model.addAttribute("tags",tags);
        return "create";
    }


    @PostMapping("create")
    public String create(Article article){
        log.info("{}",article);
        ResponseMsg msg = articleService.addArticle(article);
        log.info("添加信息{}",msg);
        return "redirect:/";
    }

}
