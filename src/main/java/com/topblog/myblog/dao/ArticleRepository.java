package com.topblog.myblog.dao;

import com.topblog.myblog.model.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: RETURN
 * @Date: 2020/4/3 23:09
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    /**
     * 查询文章的部分信息
     * @param pageable 查询参数
     * @param tag 类型参数
     * @return  返回一个分页对象
     */
    @Query(value="select new Article(a.articleId,a.articleTitle,a.articleContentInfo,a.articleDate,a.articleViewsCount,a.articleCommentCount,a.articleLikeCount) from Article as a where  a.articleTagId = :tag")
    Page<Article> findInfoByTagId(Pageable pageable,@Param("tag") Integer tag);

    /**
     * 查询文章的部分信息
     * @param pageable 查询参数
     * @return  返回一个分页对象
     */
    @Query(value="select new Article(a.articleId,a.articleTitle,a.articleContentInfo,a.articleDate,a.articleViewsCount,a.articleCommentCount,a.articleLikeCount) from Article as a")
    Page<Article> findInfo(Pageable pageable);

}
