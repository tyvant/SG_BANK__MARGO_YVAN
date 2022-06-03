package com.sg.bdd.steps;

import com.sg.Account;
import com.sg.OperationType;
import com.sg.Statement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sg.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserStoriesStepDefs {
     Account account;
     BigDecimal currentAmount;
    @Given("an account with amount  {double} euros")
    public void an_account_with_amount_euros(Double amount) {
        account = new Account(BigDecimal.valueOf(amount));
    }

    @When("he make a deposit of {double} euros on account")
    public void he_make_a_deposit_of_euros_on_account(Double deposit) {
        currentAmount = account.deposit(BigDecimal.valueOf(deposit));
    }

    @Then("the amount account should be {double} euros")
    public void the_amount_account_should_be_euros(Double expectedAmount) {
        assertThat(currentAmount).isEqualTo(BigDecimal.valueOf(expectedAmount));
    }

    @When("he make a withdrawal {double} euros on account")
    public void he_make_a_withdrawal_euros_on_account(Double withdrawal) {
        currentAmount = account.withraw(BigDecimal.valueOf(withdrawal));
    }

    @Then("the final amount account should be {double} euros")
    public void the_final_amount_account_should_be_euros(Double expectedAmount) {
        assertThat(currentAmount).isEqualTo(BigDecimal.valueOf(expectedAmount));
    }

    @When("he executes the following operations :")
    public void he_executes_the_following_operations(List<Map<String,String>> operations) {
        operations.forEach(op -> {
            BigDecimal amount = new BigDecimal(op.get("Amount"));
            String operationType = op.get("Operation Type");
            if (operationType.equals(DEPOSIT.name())){
                account.deposit(amount);
            }
            else {
                account.withraw(amount);
            }
        });
    }

    @Then("the size of statements should be {int}")
    public void the_size_of_history_should_be(int expectedSize) {
         assertThat(account.getStatements().size()).isEqualTo(expectedSize);
    }

    @Then("the show history should be contains the following statement:")
    public void the_history_should_be_contains_the_following_statement(List<Map<String,String>> statements) {
        List<Statement> statementList = new ArrayList<>();
        statements.forEach(op -> {
            BigDecimal amount = new BigDecimal(op.get("Amount"));
            BigDecimal balance = new BigDecimal(op.get("Balance"));
            OperationType operationType = OperationType.valueOf(op.get("Operation Type"));
            statementList.add( new Statement(operationType, LocalDate.now(),amount,balance));
        });
        assertThat(account.getStatements()).containsAll(statementList);
    }


}
