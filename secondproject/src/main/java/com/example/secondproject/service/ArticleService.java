package com.example.secondproject.service;

import com.example.secondproject.dto.ArticleDto;
import com.example.secondproject.entity.Article;
import com.example.secondproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public Article show(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        return article;
    }

    public Article create(ArticleDto dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleDto dto) {
        Article article = dto.toEntity();

        Article target = articleRepository.findById(id).orElse(null);

        if (target == null || id != article.getId()) {
            return null;
        }
        target.patch(article);
        return articleRepository.save(target);
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    public List<Article> createArticles(List<ArticleDto> dtos) {
        List<Article> articleList = dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());

        articleList.stream().forEach(article -> articleRepository.save(article));
//        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("Payment Error"));

        return articleList;
    }
}
