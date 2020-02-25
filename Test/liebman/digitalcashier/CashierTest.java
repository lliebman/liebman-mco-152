package liebman.digitalcashier;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashierTest {

    @Test
    public void pay() throws NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier(new Cash(100, 100, 100, 100, 100, 100, 100, 100));
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

    @Test(expected = NotEnoughChangeException.class)
    public void brokeCashier() throws NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier(new Cash());

        //when
        cashier.pay(3.00, new Cash());

        //then

    }

    @Test(expected = NotEnoughChangeException.class)
    public void noExactChange() throws NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier(new Cash(1, 1, 1, 1, 1, 1, 1, 1));
        Cash cash = new Cash(0, 0, 0, 0, 0, 1, 0, 0);

        //when
        cashier.pay(3.00, cash);

        //then
    }
}
