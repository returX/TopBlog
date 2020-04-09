package com.topblog.myblog.model.dto;

import com.topblog.myblog.constant.PageConstant;

import java.util.Optional;
import java.util.StringJoiner;

/**
 * @Author: RETURN
 * @Date: 2020/4/4 23:44
 */
public class PageDTO {
    private Integer pageNo;
    private Integer sum;
    private String direction;
    private String property;
    private Integer tag;
    // todo 为了添加tag修改pageDTO

    public PageDTO() {
    }

    public PageDTO(Integer pageNo, Integer sum, String direction, String property,Integer tag) {
        this.pageNo = Optional.ofNullable(pageNo).orElse(0);
        this.sum = Optional.ofNullable(sum).orElse(PageConstant.PAGE_NUMS);
        this.direction = Optional.ofNullable(direction).orElse(PageConstant.DERECTION);
        this.property = Optional.ofNullable(property).orElse(PageConstant.PROPERTY);
        this.tag = Optional.ofNullable(tag).orElse(PageConstant.TAG);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageDTO.class.getSimpleName() + "[", "]")
                .add("pageNo=" + pageNo)
                .add("sum=" + sum)
                .add("direction='" + direction + "'")
                .add("property='" + property + "'")
                .add("tag=" + tag)
                .toString();
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}
