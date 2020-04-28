package liebman.digitalcashier;

public class Cash {

    private int penny;
    private int nickel;
    private int dime;
    private int quarter;
    private int oneDollar;
    private int fiveDollars;
    private int tenDollars;
    private int twentyDollars;

    public Cash() {
    }

    public Cash(int penny, int nickle, int dime, int quarter, int oneDollar,
                int fiveDollars, int tenDollars, int twentyDollars) {
        this.penny = penny;
        this.nickel = nickle;
        this.dime = dime;
        this.quarter = quarter;
        this.oneDollar = oneDollar;
        this.fiveDollars = fiveDollars;
        this.tenDollars = tenDollars;
        this.twentyDollars = twentyDollars;
    }

    public int getPenny() {
        return penny;
    }

    public int getNickel() {
        return nickel;
    }

    public int getDime() {
        return dime;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getOneDollar() {
        return oneDollar;
    }

    public int getFiveDollars() {
        return fiveDollars;
    }

    public int getTenDollars() {
        return tenDollars;
    }

    public int getTwentyDollars() {
        return twentyDollars;
    }

    public void addPenny(int delta){
        penny += delta;
    }

    public void addNickel(int delta){
        nickel += delta;
    }

    public void addDime(int delta){
        dime += delta;
    }

    public void addQuarter(int delta){
        quarter += delta;
    }

    public void addOneDollar(int delta){
        oneDollar += delta;
    }

    public void addFiveDollars(int delta){
        fiveDollars += delta;
    }

    public void addTenDollars(int delta){
        tenDollars += delta;
    }

    public void addTwentyDollars(int delta){
        twentyDollars += delta;
    }

    public void minusPenny(int delta){
        penny -= delta;
    }

    public void minusNickel(int delta){
        nickel -= delta;
    }

    public void minusDime(int delta){
        dime -= delta;
    }

    public void minusQuarter(int delta){
        quarter -= delta;
    }

    public void minusOneDollar(int delta){
        oneDollar -= delta;
    }

    public void minusFiveDollars(int delta){
        fiveDollars -= delta;
    }

    public void minusTenDollars(int delta){
        tenDollars -= delta;
    }

    public void minusTwentyDollars(int delta){
        twentyDollars -= delta;
    }

    public double calcTotal(){
        return (penny * 0.01) + (nickel * 0.05) + (dime * 0.10) + (quarter * 0.25) +
                (oneDollar * 1.0) + (fiveDollars * 5.0) + (tenDollars * 10.0) + (twentyDollars * 20.0);
    }
}
