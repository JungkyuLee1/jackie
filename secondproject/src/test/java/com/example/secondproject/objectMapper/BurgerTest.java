package com.example.secondproject.objectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurgerTest {

    @Test
    public void dtoToJson() throws JsonProcessingException {
        //준비
        ObjectMapper objectMapper = new ObjectMapper();

        //실행
        List<String> ingredients = Arrays.asList("통새우 패티","순쇠고기 패티","토마토", "스파이시 어니언");
        Burger burger = new Burger("맥도날드", 5000, ingredients);

        String json=objectMapper.writeValueAsString(burger);
        //예상
        String expected ="{\"name\":\"맥도날드\",\"price\":5000,\"ingredients\":[\"통새우 패티\",\"순쇠고기 패티\",\"토마토\",\"스파이시 어니언\"]}";
        //검증
        assertEquals(json, expected);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    public void jsonToDto() throws JsonProcessingException {
        //준비
        ObjectMapper objectMapper = new ObjectMapper();
        //실행
//        String json="{\"name\":\"맥도날드\",\"price\":5000,\"ingredients\":[\"통새우 패티\",\"순쇠고기 패티\",\"토마토\",\"스파이시 어니언\"]}";

        //<Json 생성>
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "맥도날드");
        objectNode.put("price", 5000);

        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("통새우 패티");
        arrayNode.add("순쇠고기 패티");
        arrayNode.add("토마토");
        arrayNode.add("스파이시 어니언");
        objectNode.set("ingredients", arrayNode);

        String json=objectNode.toString();

        Burger burger = objectMapper.readValue(json, Burger.class);
        //예상
        List<String> ingredients = Arrays.asList("통새우 패티","순쇠고기 패티","토마토", "스파이시 어니언");
        Burger expected = new Burger("맥도날드", 5000, ingredients);

        //검증
        assertEquals(burger.toString(), expected.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());

        System.out.println(burger);
    }

}