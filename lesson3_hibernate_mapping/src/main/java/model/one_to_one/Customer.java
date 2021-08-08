package model.one_to_one;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private String fullName;
    @Column(name = "customer_email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private FinancialOperation financialOperation;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
