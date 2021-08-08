package model.one_to_many;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;
    @Column(name = "price")
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cart_id")
    private Cart cart;
    @Column(name = "end_date")
    private Date endDate;

    public Item(double price, Cart cart, Date endDate) {
        this.price = price;
        this.cart = cart;
        this.endDate = endDate;
    }
}
