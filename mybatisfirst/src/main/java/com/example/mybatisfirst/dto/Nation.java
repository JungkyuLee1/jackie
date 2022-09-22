package com.example.mybatisfirst.dto;

import lombok.*;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Getter
@Setter
public class Nation {
    private int id;
    private String nation;
    private String city;
//    private String car;
}