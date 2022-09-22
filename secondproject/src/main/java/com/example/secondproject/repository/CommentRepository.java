package com.example.secondproject.repository;

import com.example.secondproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "Select * from comment where article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(@Param("articleId") Long articleId);

    //Resources->META-INF->orm.xml에서 Query 작성
    List<Comment> findByNickname(@Param("nickname") String nickname);
}
