package com.topblog.myblog.service;

import com.topblog.myblog.model.dto.PageDTO;
import com.topblog.myblog.model.entity.Article;
import org.springframework.data.domain.Page;

/**
 * @Author: RETURN
 * @Date: 2020/4/3 23:41
 */
public interface ArticleService {
    /**
     *获取某一页的文章文章
     * @param pageDTO 封装好的信息
     */
    Page<Article> getPage(PageDTO pageDTO);

}
