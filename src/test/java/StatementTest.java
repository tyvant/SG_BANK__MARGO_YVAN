import com.sg.Statement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sg.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {
    List<Statement> statements;

    @Before
    public void init() {
        statements = new ArrayList<>();
    }

    @Test
    public void when_adding_new_statement_then_statements_should_contains_the_statement_line() {
        //given when
        Statement statement = new Statement(DEPOSIT, LocalDate.now(), BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        statements.add(statement);
        //then

        assertThat(statements).containsExactly(statement);
    }
}
