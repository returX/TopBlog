package com.topblog.myblog.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @Author: RETURN
 * @Date: 2020/4/1 19:24
 */
@Entity
@Table(name = "bk_articles")
public class Article {
    /**
     * 文章id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容html格式
     */
    private String articleContentHtml;
    /**
     * 文章内容md格式
     */
    private String articleContentMd;
    /**
     * 文章简介
     */
    private String articleContentInfo;
    /**
     * 文章创建时间
     */
    private LocalDateTime articleDate;
    /**
     * 阅读数
     */
    private Integer articleViewsCount;
    /**
     * 评论数
     */
    private Integer articleCommentCount;
    /**
     * 点赞数
     */
    private Integer articleLikeCount;
    /**
     *所属分类id
     */
    private Integer articleTagId;

    public Article() {
    }

    public Article(Integer articleId, String articleTitle, String articleContentHtml, String articleContentMd, String articleContentInfo, LocalDateTime articleDate, Integer articleViewsCount, Integer articleCommentCount, Integer articleLikeCount,Integer articleTagId) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContentHtml = articleContentHtml;
        this.articleContentMd = articleContentMd;
        this.articleContentInfo = articleContentInfo;
        this.articleDate = articleDate;
        this.articleViewsCount = articleViewsCount;
        this.articleCommentCount = articleCommentCount;
        this.articleLikeCount = articleLikeCount;
        this.articleTagId = articleTagId;
    }

    public Article(Integer articleId, String articleTitle, String articleContentInfo, LocalDateTime articleDate, Integer articleViewsCount, Integer articleCommentCount, Integer articleLikeCount) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContentInfo = articleContentInfo;
        this.articleDate = articleDate;
        this.articleViewsCount = articleViewsCount;
        this.articleCommentCount = articleCommentCount;
        this.articleLikeCount = articleLikeCount;
    }

    public Integer getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(Integer articleTagId) {
        this.articleTagId = articleTagId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleContentInfo() {
        return articleContentInfo;
    }

    public void setArticleContentInfo(String articleContentInfo) {
        this.articleContentInfo = articleContentInfo;
    }

    public LocalDateTime getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(LocalDateTime articleDate) {
        this.articleDate = articleDate;
    }

    public Integer getArticleViewsCount() {
        return articleViewsCount;
    }

    public void setArticleViewsCount(Integer articleViewsCount) {
        this.articleViewsCount = articleViewsCount;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Article.class.getSimpleName() + "[", "]")
                .add("articleId=" + articleId)
                .add("articleTitle='" + articleTitle + "'")
                .add("articleContentHtml='" + articleContentHtml + "'")
                .add("articleContentMd='" + articleContentMd + "'")
                .add("articleContentInfo='" + articleContentInfo + "'")
                .add("articleDate=" + articleDate)
                .add("articleViewsCount=" + articleViewsCount)
                .add("articleCommentCount=" + articleCommentCount)
                .add("articleLikeCount=" + articleLikeCount)
                .add("articleTagId=" + articleTagId)
                .toString();
    }
}
