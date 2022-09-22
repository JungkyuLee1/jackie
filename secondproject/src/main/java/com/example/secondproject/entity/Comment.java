package com.example.secondproject.entity;

import com.example.secondproject.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Slf4j
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(Article article, CommentDto dto) {

        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 Id가 없어야 합니다");
        if (article.getId() != dto.getArticleId()) {
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 Id가 잘못되었습니다");
        }

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public static Comment updateComment(Article article, CommentDto dto) {
        if (dto.getArticleId() == null)
            throw new IllegalArgumentException("댓글 수정 실패! 댓글의 ID가 존재하지 않습니다");
        if (article.getId() != dto.getArticleId())
            throw new IllegalArgumentException("댓슥 수정 실패! Id가 일치하지 않습니다");
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 Id가 입력되었습니다");
        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}
