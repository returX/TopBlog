package com.topblog.myblog.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

/**
 * @Author: RETURN
 * @Date: 2020/4/8 15:59
 */
@Entity
@Table(name = "bk_articles_tags")
public class ArticleTags {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer ArticleId;
    private Integer TagId;

    public ArticleTags() {
    }

    public ArticleTags(Integer articleId, Integer tagId) {
        ArticleId = articleId;
        TagId = tagId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArticleTags.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ArticleId=" + ArticleId)
                .add("TagId=" + TagId)
                .toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return ArticleId;
    }

    public void setArticleId(Integer articleId) {
        ArticleId = articleId;
    }

    public Integer getTagId() {
        return TagId;
    }

    public void setTagId(Integer tagId) {
        TagId = tagId;
    }
}
