package com.example.secondproject.ioc;

import org.springframework.stereotype.Component;

@Component //IOC에 등록 - Autowired로 호출 됨
public class IngredientFactory {

    public Ingredient get(String menu){
        switch (menu){
            case "돈가스" :
                return new Pork("한돈 등심");
            case "스테이크" :
                return new Beef("안심");
            default:
                return null;
        }
    }
}
