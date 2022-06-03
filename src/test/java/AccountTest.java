import com.sg.Account;
import com.sg.ErrorMessages;
import exceptions.SGBANKExceptions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    Account account;

    @Before
    public void init() {
        account = new Account();
    }


    @Test
    public void should_increase_amount_by_1000_when_deposit_is_1000() {
        BigDecimal expected = BigDecimal.valueOf(1000);
        //given
        account = new Account();
        BigDecimal oldBalance = account.getBalance();
        //when
        account.deposit(BigDecimal.valueOf(1000));
        //then
        assertThat(account.getBalance().subtract(oldBalance)).isEqualTo(expected);
    }

    @Test
    public void balance_should_return_100_after_deposit_100() {
        //given
        account = new Account();
        //when
        account.deposit(BigDecimal.valueOf(100));
        BigDecimal balance = this.account.getBalance();
        //then
        assertThat(balance).isEqualTo(BigDecimal.valueOf(100));
    }

    @Test
    public void should_decrease_amount_by_500_when_withdraw_is_500() {
        //given
        account = new Account();
        //when
        account.deposit(BigDecimal.valueOf(1000));
        BigDecimal oldBalance = account.getBalance();
        account.withraw(BigDecimal.valueOf(500));
        //then
        assertThat(oldBalance.subtract(account.getBalance())).isEqualTo(BigDecimal.valueOf(500));
    }


    @Test
    public void balance_should_be_100_after_deposit_500_and_500_and_withdraw_500_and_400() {
        BigDecimal expectedBalance = BigDecimal.valueOf(100);
        //given
        account = new Account();
        //when
        account.deposit(BigDecimal.valueOf(500));
        account.withraw(BigDecimal.valueOf(500));
        account.deposit(BigDecimal.valueOf(500));
        account.withraw(BigDecimal.valueOf(400));
        BigDecimal balance = account.getBalance();
        //then

        assertThat(expectedBalance).isEqualTo(balance);
    }

    @Test
    public void should_throw_exception_when_deposit_is_negative() {
        assertThrows(SGBANKExceptions.class, () -> account.deposit(BigDecimal.valueOf(-200)), ErrorMessages.AMOUNT_OF_DEPOSIT_OR_WITHDRAWAL_IS_NEGATIVE);

    }

    @Test
    public void should_throw_exception_when_withdraw_is_negative() {
        assertThrows(SGBANKExceptions.class, () -> account.withraw(BigDecimal.valueOf(-200.00)), ErrorMessages.AMOUNT_OF_DEPOSIT_OR_WITHDRAWAL_IS_NEGATIVE);
    }

    @Test
    public void should_throw_exception_when_withdraw_is_big_then_balance() {
        //give
        account = new Account();
        assertThrows(SGBANKExceptions.class, () -> account.withraw(BigDecimal.valueOf(3000.00)), ErrorMessages.WITHDRAWAL_AMOUNT_BIGGER_THAN_BALANCE);
    }


}
