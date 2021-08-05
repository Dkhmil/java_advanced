package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bucket {
    private int id;
    private String name;
    Set<Product> products = new HashSet<>();

    public Bucket(String name) {
        this.name = name;
    }
}
