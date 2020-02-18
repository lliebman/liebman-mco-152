package liebman.digitalcashier;

public class Cashier {

    Cash myCash = new Cash(100, 100, 100, 100, 100, 100, 100, 100);

    public Cash pay(double price, Cash payment){
        //place money from payment into myCash
        myCash.addPenny(payment.getPenny());
        myCash.addNickel(payment.getNickel());
        myCash.addDime(payment.getDime());
        myCash.addQuarter(payment.getQuarter());
        myCash.addOneDollar(payment.getOneDollar());
        myCash.addFiveDollars(payment.getFiveDollars());
        myCash.addTenDollars(payment.getTenDollars());
        myCash.addTwentyDollars(payment.getTwentyDollars());

        //calculate change to be given
        Cash change = new Cash(0,0,0,0,0,0,0,0);
        double changeNeeded = Math.round((price * 100) - (payment.calcTotal() * 100));
        if(changeNeeded >= 2000){
            do{
                change.addTwentyDollars(1);
                myCash.minusTwentyDollars(1);
                changeNeeded -= 2000;
            }while(changeNeeded >= 2000);
        }
        if (changeNeeded >= 1000){
            do{
                change.addTenDollars(1);
                myCash.minusTenDollars(1);
                changeNeeded -= 1000;
            }while(changeNeeded >= 1000);
        }
        if (changeNeeded >= 500){
            do{
                change.addFiveDollars(1);
                myCash.minusFiveDollars(1);
                changeNeeded -= 500;
            }while(changeNeeded >= 500);
        }
        if (changeNeeded >= 100){
            do{
                change.addOneDollar(1);
                myCash.minusOneDollar(1);
                changeNeeded -= 100;
            }while(changeNeeded >= 100);
        }
        if (changeNeeded >= 25){
            do{
                change.addQuarter(1);
                myCash.minusQuarter(1);
                changeNeeded -= 25;
            }while(changeNeeded >= 25);
        }
        if (changeNeeded >= 10){
            do{
                change.addDime(1);
                myCash.minusDime(1);
                changeNeeded -= 10;
            }while(changeNeeded >= 10);
        }
        if (changeNeeded >= 5){
            do{
                change.addNickel(1);
                myCash.minusNickel(1);
                changeNeeded -= 5;
            }while(changeNeeded >= 5);
        }
        if (changeNeeded >= 1){
            do{
                change.addPenny(1);
                myCash.minusPenny(1);
                changeNeeded -= 1;
            }while(changeNeeded >= 1);
        }
        return change;
    }
}
