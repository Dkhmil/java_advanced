package model.one_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cart_name")
    private String cartName;
    @Column(name = "total_price")
    private double totalPrice;
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<Item> items;


    public Cart(String cartName) {
        this.cartName = cartName;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
        this.totalPrice = getTotalPrice(items);
    }

    private double getTotalPrice(Set<Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
