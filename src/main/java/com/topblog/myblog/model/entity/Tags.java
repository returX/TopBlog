package com.topblog.myblog.model.entity;

import javax.persistence.*;
import java.util.StringJoiner;

/**
 * @Author: RETURN
 * @Date: 2020/4/7 21:07
 */
@Entity
@Table(name = "bk_tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    private String tagName;
    private Integer tagNum;

    public Tags() {
    }


    public Tags(String tagName, Integer tagNum) {
        this.tagName = tagName;
        this.tagNum = tagNum;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagNum() {
        return tagNum;
    }

    public void setTagNum(Integer tagNum) {
        this.tagNum = tagNum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tags.class.getSimpleName() + "[", "]")
                .add("tagId=" + tagId)
                .add("tagName=" + tagName)
                .add("tagNum=" + tagNum)
                .toString();
    }
}
