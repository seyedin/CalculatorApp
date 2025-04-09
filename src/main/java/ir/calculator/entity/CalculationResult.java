package ir.calculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CalculationResult {

    @Id
    private Long id;

    private double num1;
    private Double num2;
    private String operation;
    private double result;

    public CalculationResult(double num1, Double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }
}
