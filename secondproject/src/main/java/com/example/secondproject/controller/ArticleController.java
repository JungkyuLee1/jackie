package com.example.secondproject.controller;

import com.example.secondproject.dto.ArticleForm;
import com.example.secondproject.dto.CommentDto;
import com.example.secondproject.entity.Article;
import com.example.secondproject.repository.ArticleRepository;
import com.example.secondproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j //Lombok 기능(build.gradle)
public class ArticleController {

    @Autowired  //Injection 주입(Repository 객제 연결)
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        //Dto 확인
        log.info(form.toString());

        //Dto->Entity 변환
        Article article = form.toEntity();
        log.info(article.toString());
        //Entity->DB 저장

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id=" + id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentDtos);
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        //List<Article> articleEntityList= (List<Article>) articleRepository.findAll();
        //articleRepository 에서 method override 처리(iterable -> ArrayList)
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        Article articleEntity = form.toEntity();
        log.info("articleEntity:" + articleEntity);

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        log.info("target:" + target);

        if (target != null) {
            articleRepository.save(articleEntity);
        }

        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rdas) {

        Article target = articleRepository.findById(id).orElse(null);
        if (target != null) {
            articleRepository.delete(target);
            rdas.addFlashAttribute("msg", "Deleted!!!");
        }

        return "redirect:/articles";
    }
}
