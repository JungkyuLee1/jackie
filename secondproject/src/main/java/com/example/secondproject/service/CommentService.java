package com.example.secondproject.service;

import com.example.secondproject.dto.CommentDto;
import com.example.secondproject.entity.Article;
import com.example.secondproject.entity.Comment;
import com.example.secondproject.repository.ArticleRepository;
import com.example.secondproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId).stream().map(comment -> CommentDto.createCommentDto(comment)).collect(Collectors.toList());

        //        List<Comment> comments = commentRepository.findByArticleId(articleId);
//
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//
//        for(int i=0;i<comments.size();i++){
//            Comment comment = comments.get(i);
//            CommentDto dto= CommentDto.createCommentDto(comment);
//            dtos.add(dto);
//        }
//        return dtos;
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        //1.게시글 조회 및 예외처리
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다"));

        //2.댓글 엔티티 생성
        Comment comment = Comment.createComment(article, dto);
        //3.DB 저장
        Comment created = commentRepository.save(comment);

        //4.Dto로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long Id, CommentDto dto) {
        Comment target = commentRepository.findById(Id).orElseThrow((() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다")));

        target.patch(dto);
        Comment updated = commentRepository.save(target);
        return CommentDto.createCommentDto(updated);
    }

    public CommentDto delete(Long Id) {
        Comment target = commentRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다."));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
