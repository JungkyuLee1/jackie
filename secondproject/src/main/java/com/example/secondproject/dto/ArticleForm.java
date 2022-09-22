package com.example.secondproject.dto;

import com.example.secondproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //Lombok-생성자 (build.gradle)
@NoArgsConstructor
@Data
@ToString //Lombok-toString()
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    //Dto -> Entity 로 변환
    public Article toEntity() {
        return new Article(id, title, content);
    }

}
