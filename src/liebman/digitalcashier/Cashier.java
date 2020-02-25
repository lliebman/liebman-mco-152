package liebman.digitalcashier;

public class Cashier {

    private Cash cashRgister;

    public Cashier(Cash myCash) {
        this.cashRgister = myCash;
    }
    
    public Cash pay(double price, Cash payment) throws NotEnoughChangeException {
        if (cashRgister.calcTotal() == 0){
            throw new NotEnoughChangeException();
        }

        //place money from payment into myCash
        cashRgister.addPenny(payment.getPenny());
        cashRgister.addNickel(payment.getNickel());
        cashRgister.addDime(payment.getDime());
        cashRgister.addQuarter(payment.getQuarter());
        cashRgister.addOneDollar(payment.getOneDollar());
        cashRgister.addFiveDollars(payment.getFiveDollars());
        cashRgister.addTenDollars(payment.getTenDollars());
        cashRgister.addTwentyDollars(payment.getTwentyDollars());

        //calculate change to be given
        Cash change = new Cash(0,0,0,0,0,0,0,0);
        double changeNeeded = Math.round((payment.calcTotal() * 100) - (price * 100));
        if(changeNeeded >= 2000 && cashRgister.getTwentyDollars() != 0){
            do{
                change.addTwentyDollars(1);
                cashRgister.minusTwentyDollars(1);
                changeNeeded -= 2000;
            }while(changeNeeded >= 2000 && cashRgister.getTwentyDollars() != 0);
        }
        if (changeNeeded >= 1000 && cashRgister.getTenDollars() != 0){
            do{
                change.addTenDollars(1);
                cashRgister.minusTenDollars(1);
                changeNeeded -= 1000;
            }while(changeNeeded >= 1000 && cashRgister.getTenDollars() != 0);
        }
        if (changeNeeded >= 500 && cashRgister.getFiveDollars() != 0){
            do{
                change.addFiveDollars(1);
                cashRgister.minusFiveDollars(1);
                changeNeeded -= 500;
            }while(changeNeeded >= 500 && cashRgister.getFiveDollars() != 0);
        }
        if (changeNeeded >= 100 && cashRgister.getOneDollar() != 0){
            do{
                change.addOneDollar(1);
                cashRgister.minusOneDollar(1);
                changeNeeded -= 100;
            }while(changeNeeded >= 100 && cashRgister.getOneDollar() != 0);
        }
        if (changeNeeded >= 25 && cashRgister.getQuarter() != 0){
            do{
                change.addQuarter(1);
                cashRgister.minusQuarter(1);
                changeNeeded -= 25;
            }while(changeNeeded >= 25 && cashRgister.getQuarter() != 0);
        }
        if (changeNeeded >= 10 && cashRgister.getDime() != 0){
            do{
                change.addDime(1);
                cashRgister.minusDime(1);
                changeNeeded -= 10;
            }while(changeNeeded >= 10 && cashRgister.getDime() != 0);
        }
        if (changeNeeded >= 5 && cashRgister.getNickel() != 0){
            do{
                change.addNickel(1);
                cashRgister.minusNickel(1);
                changeNeeded -= 5;
            }while(changeNeeded >= 5 && cashRgister.getNickel() != 0);
        }
        if (changeNeeded >= 1 && cashRgister.getPenny() != 0){
            do{
                change.addPenny(1);
                cashRgister.minusPenny(1);
                changeNeeded -= 1;
            }while(changeNeeded >= 1 && cashRgister.getPenny() != 0);
        }

        // check if there is remaining change needed
        // if yes, then register did not have enough change. Rebalance register and throw exception
        if (changeNeeded > 0){
            balanceRegister(payment, change);
            throw new NotEnoughChangeException();
        }
        return change;
    }

    private void balanceRegister(Cash paymentMoney, Cash changeMoney) {
        cashRgister.minusPenny(paymentMoney.getPenny());
        cashRgister.minusNickel(paymentMoney.getNickel());
        cashRgister.minusDime(paymentMoney.getDime());
        cashRgister.minusQuarter(paymentMoney.getQuarter());
        cashRgister.minusOneDollar(paymentMoney.getOneDollar());
        cashRgister.minusFiveDollars(paymentMoney.getFiveDollars());
        cashRgister.minusTenDollars(paymentMoney.getTenDollars());
        cashRgister.minusTwentyDollars(paymentMoney.getTwentyDollars());
        cashRgister.addPenny(changeMoney.getPenny());
        cashRgister.addNickel(changeMoney.getNickel());
        cashRgister.addDime(changeMoney.getDime());
        cashRgister.addQuarter(changeMoney.getQuarter());
        cashRgister.addOneDollar(changeMoney.getOneDollar());
        cashRgister.addFiveDollars(changeMoney.getFiveDollars());
        cashRgister.addTenDollars(changeMoney.getTenDollars());
        cashRgister.addTwentyDollars(changeMoney.getTwentyDollars());
    }
}
