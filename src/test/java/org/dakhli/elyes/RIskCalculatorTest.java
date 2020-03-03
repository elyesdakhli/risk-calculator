package org.dakhli.elyes;

import org.dakhli.elyes.model.Contract;
import org.dakhli.elyes.model.CounterParty;
import org.dakhli.elyes.model.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class RIskCalculatorTest {

    @Test
    public void calculateTest() {
        //Given
        CounterParty cp = buildCounterParty();

        //When
        int sum = RiskCalculator.calculate(cp);

        //Then
        Assert.assertEquals("Wrong risk calculation", 197, sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noInputCalculateTest(){
        RiskCalculator.calculate(null);
    }

    private CounterParty buildCounterParty() {
        Contract c1 = new Contract()
                .withRelatedContracts(new Contract().withTransactions(new Transaction(10),
                        new Transaction(15)));
        Contract c2 = new Contract()
                .withRelatedContracts(new Contract().withTransactions(new Transaction(19)))
                .withTransactions(new Transaction(100), new Transaction(50));
        return new CounterParty()
                .withTransactions(new Transaction(1), new Transaction(2))
                .withContracts(c1,c2);
    }
}
