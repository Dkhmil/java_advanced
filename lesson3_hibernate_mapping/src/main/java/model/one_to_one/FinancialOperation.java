package model.one_to_one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "financial_operation")
public class FinancialOperation {

    @Id
    @Column(name = "operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "total")
    private double total;
    @OneToOne(mappedBy = "financialOperation")
    private Customer customer;

    public FinancialOperation(Date date, double total) {
        this.date = date;
        this.total = total;
    }
}
