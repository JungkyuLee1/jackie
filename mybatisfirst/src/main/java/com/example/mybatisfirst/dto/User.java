package com.example.mybatisfirst.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Getter
public class User {
    private int id;
    private String name;
    private String email;
}
