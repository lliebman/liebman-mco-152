package liebman.digitalcashier;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashierTest {

    @Test
    public void pay() {
        //given
        Cashier cashier = new Cashier();
        Cash cash = new Cash(1, 1, 1, 1, 1, 1,1, 1 );
        //when
        Cash change = cashier.pay(72.83, cash);
        //then
        assertEquals(2, change.getPenny());
        assertEquals(1, change.getNickel());
        assertEquals(1, change.getDime());
        assertEquals(1, change.getQuarter());
        assertEquals(1, change.getOneDollar());
        assertEquals(1, change.getFiveDollars());
        assertEquals(1, change.getTenDollars());
        assertEquals(1, change.getTwentyDollars());
    }
}