package com.topblog.myblog.dao;

import com.topblog.myblog.model.entity.ArticleTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: RETURN
 * @Date: 2020/4/8 16:20
 */
@Repository
public interface ArticleTagsRepository extends JpaRepository<ArticleTags, Integer> {
}
