package com.topblog.myblog.dao;

import com.topblog.myblog.model.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: RETURN
 * @Date: 2020/4/8 16:05
 */
@Repository
public interface TagRepository extends JpaRepository<Tags,Integer> {

    @Modifying
    @Query("update Tags t set t.tagNum = t.tagNum+1 where t.tagId = :tagId")
    Integer tagIncrement(@Param("tagId") Integer tagId);
}
