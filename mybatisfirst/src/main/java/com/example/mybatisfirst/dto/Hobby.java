package com.example.mybatisfirst.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Getter
public class Hobby {
    private int id;
    private String kind;
    private String remark;
    private int uid;
}
