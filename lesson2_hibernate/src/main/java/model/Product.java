package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private int id;
    private String name;
    private double price;
    private Set<Bucket> buckets = new HashSet<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }



}


