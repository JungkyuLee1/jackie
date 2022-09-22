package com.example.secondproject.dto;

import com.example.secondproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ArticleDto {

    private Long id;

    private String title;

    private String content;

    public Article toEntity() {
        return new Article(
                id, title, content
        );
    }
}
