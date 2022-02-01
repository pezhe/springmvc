package ru.gb.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private long id;
    private String title;
    private double cost;

}
