package com.topblog.myblog.dao;

import com.topblog.myblog.model.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: RETURN
 * @Date: 2020/4/8 16:05
 */
@Repository
public interface TagRepository extends JpaRepository<Tags,Integer> {
}
