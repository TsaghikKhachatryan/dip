package com.frontbackend.thymeleaf.bootstrap.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    @Lob
    private String picture;

    private Double price;

    private Integer RAM;
}
