package com.sg;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;



/** Represents the statement use in my app.
 * @author Yvan Tchatat
 */
@Getter
@Setter
public class Statement {

    private OperationType operation;
    private LocalDate date;
    private BigDecimal amount;
    private BigDecimal balance;

    public Statement(OperationType operation, LocalDate date, BigDecimal amount, BigDecimal balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Statement() {}


    @Override
    public String toString() {
        return "Statement{" +
                "operation='" + operation + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return amount.equals(statement.amount)
                && balance.equals(statement.balance)
                && operation.equals(statement.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, amount, balance);
    }
}
