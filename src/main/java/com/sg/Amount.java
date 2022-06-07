package com.sg;

import java.math.BigDecimal;

/** Represents an amount
 * @author Yvan Tchatat
 */
public class Amount {
    public BigDecimal amount;

    public Amount() {
        amount = BigDecimal.ZERO;
    }
    public Amount(BigDecimal amount) {
        this.amount = amount;
    }
    public void add(BigDecimal amount) {
         this.amount = this.amount.add(amount);
    }

    public void subtract(BigDecimal amount) {
         this.amount = this.amount.subtract(amount);
    }

    public BigDecimal  getCurrentAmount() {
        return this.amount;
    }

}
