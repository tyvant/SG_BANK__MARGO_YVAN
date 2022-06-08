package com.sg;

import com.sg.exceptions.SGBANKExceptions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sg.OperationType.DEPOSIT;
import static com.sg.OperationType.WITHDRAWAL;

/** Represents a basic Bank Account  .
 * @author Yvan Tchatat
 */
public class Account {

    private Amount balance;
    private List<Statement> statements;

    public Account() {
        balance = new Amount();
        statements = new ArrayList<>();
    }

    public Account(BigDecimal amount) {
        balance = new Amount(amount);
        statements = new ArrayList<>();
    }
    public BigDecimal getBalance() {
        return this.balance.getCurrentAmount();
    }

    public synchronized BigDecimal deposit(BigDecimal amount) throws SGBANKExceptions {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new SGBANKExceptions(ErrorMessages.AMOUNT_OF_DEPOSIT_OR_WITHDRAWAL_IS_NEGATIVE);

        updateStatement(amount, DEPOSIT);

        return this.balance.getCurrentAmount();
    }

    public synchronized BigDecimal withraw(BigDecimal amount) throws SGBANKExceptions {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new SGBANKExceptions(ErrorMessages.AMOUNT_OF_DEPOSIT_OR_WITHDRAWAL_IS_NEGATIVE);

        if(amount.compareTo(balance.getCurrentAmount()) > 0 )
            throw new SGBANKExceptions(ErrorMessages.WITHDRAWAL_AMOUNT_BIGGER_THAN_BALANCE);
        updateStatement(amount, WITHDRAWAL);
        return this.balance.getCurrentAmount();
    }

    private void updateStatement(BigDecimal amount,OperationType type) {
        Statement st = new Statement();
        st.setDate(LocalDate.now());
        st.setAmount(amount);
         switch (type) {
             case WITHDRAWAL:
                 this.balance.subtract(amount);
                 st.setOperation(type);
                 break;
             case DEPOSIT:
                 this.balance.add(amount);
                 st.setOperation(type);
                 break;
         }
        st.setBalance(this.balance.getCurrentAmount());
        statements.add(st);
    }

    // Method permit to get history of operations
    public void showHistory() {
        if (null == statements || statements.isEmpty()) {
            System.out.println("History is empty");
        }
        statements.forEach(System.out::println);
    }
    public List<Statement> getStatements(){
        return statements;
    }

    public String toString() {
         return "Account with " + balance.getCurrentAmount() +" euros ";
    }

}
