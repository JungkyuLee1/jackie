package com.example.secondproject.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //IOC에 등록 - Autowired로 호출 됨
public class Chef {
    @Autowired
    private IngredientFactory ingredientFactory;

    public Chef(IngredientFactory ingredientFactory){
        this.ingredientFactory=ingredientFactory;
    }

    public String cook(String menu){

        Ingredient ingredient = ingredientFactory.get(menu);

        return ingredient.getName()+"으로 만든 " + menu;
    }
}
