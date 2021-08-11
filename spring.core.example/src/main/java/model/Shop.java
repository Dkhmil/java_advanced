package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shop {

    private int id;

    private String name;

    private double square;

    private int maxPeople;
}
