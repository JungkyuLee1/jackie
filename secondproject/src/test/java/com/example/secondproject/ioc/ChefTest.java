package com.example.secondproject.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChefTest {
//    @Autowired
//    IngredientFactory ingredientFactory;

    @Autowired
    Chef chef;

    @Test
    void cookDonKatsu() {
        String menu = "돈가스";

        //실행
        String food = chef.cook(menu);

        //예상
        String expected = "한돈 등심으로 만든 돈가스";

        //검증
        assertEquals(food, expected);
        System.out.println(food);
    }

    @Test
    void cookBeef(){
        String menu="스테이크";

        //실행
        String food=chef.cook(menu);
        //예상
        String expected="안심으로 만든 스테이크";
        //검증
        assertEquals(food, expected);
        System.out.println(food);

    }
}