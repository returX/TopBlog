package com.topblog.myblog.dao;

import com.topblog.myblog.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: RETURN
 * @Date: 2020/4/3 23:09
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
