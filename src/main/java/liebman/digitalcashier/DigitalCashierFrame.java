package liebman.digitalcashier;

import liebman.projectile.ProjectileFrame;

import javax.swing.*;
import java.awt.*;

public class DigitalCashierFrame extends JFrame{

    JPanel container;

    /*
    Panel 1
     */
    private JLabel pennyLabel;
    private JLabel nickelLabel;
    private JLabel dimeLabel;
    private JLabel quarterLabel;
    private JLabel dollarLabel;
    private JLabel fiveDollarsLabel;
    private JLabel tenDollarsLabel;
    private JLabel twentyDollarsLabel;
    private JTextField penny;
    private JTextField nickel;
    private JTextField dime;
    private JTextField quarter;
    private JTextField dollar;
    private JTextField fiveDollars;
    private JTextField tenDollars;
    private JTextField twentyDollars;

    /*
    Panel 2
     */
    private JLabel totalCashierLabel;
    private JLabel totalCashierAnswerLabel;
    private JButton setCashierButton;
    private JButton clearCashierButton;

    /*
    Panel 3
     */
    private JLabel priceLabel;
    private JTextField price;

    /*
    Panel 4
     */
    private JLabel pennyLabel2;
    private JLabel nickelLabel2;
    private JLabel dimeLabel2;
    private JLabel quarterLabel2;
    private JLabel dollarLabel2;
    private JLabel fiveDollarsLabel2;
    private JLabel tenDollarsLabel2;
    private JLabel twentyDollarsLabel2;
    private JTextField pennyPaid;
    private JTextField nickelPaid;
    private JTextField dimePaid;
    private JTextField quarterPaid;
    private JTextField dollarPaid;
    private JTextField fiveDollarsPaid;
    private JTextField tenDollarsPaid;
    private JTextField twentyDollarsPaid;

    /*
    Panel 5
     */
    private JLabel totalPaidLabel;
    private JLabel totalPaidAnswerLabel;
    private JButton calculateButton;
    private JButton clearButton;

    /*
    Panel 6
     */
    private JLabel changeLabel;

    /*
    Panel 7
     */
    private JLabel pennyLabel3;
    private JLabel nickelLabel3;
    private JLabel dimeLabel3;
    private JLabel quarterLabel3;
    private JLabel dollarLabel3;
    private JLabel fiveDollarsLabel3;
    private JLabel tenDollarsLabel3;
    private JLabel twentyDollarsLabel3;
    private JLabel changePennyLabel;
    private JLabel changeNickelLabel;
    private JLabel changeDimeLabel;
    private JLabel changeQuarterLabel;
    private JLabel changeDollarLabel;
    private JLabel changeFiveDollarsLabel;
    private JLabel changeTenDollarsLabel;
    private JLabel changeTwentyDollarsLabel;

    /*
    Panel 8
     */
    private JLabel totalChangeLabel;
    private JLabel totalChangeAnswerLabel;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;

    private Cash resetCash = new Cash();
    private Cashier cashier = new Cashier(resetCash);


    public DigitalCashierFrame() {

        setSize(700, 500);
        setTitle("Digital Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        setContentPane(container);

        /*
        Set up panel1
         */
        pennyLabel = new JLabel("penny: ");
        nickelLabel = new JLabel("nickel: ");
        dimeLabel = new JLabel("dime: ");
        quarterLabel = new JLabel("quarter: ");
        dollarLabel = new JLabel("$1: ");
        fiveDollarsLabel = new JLabel("$5: ");
        tenDollarsLabel = new JLabel("$10: ");
        twentyDollarsLabel = new JLabel("$20: ");
        penny = new JTextField();
        nickel = new JTextField();
        dime = new JTextField();
        quarter = new JTextField();
        dollar = new JTextField();
        fiveDollars = new JTextField();
        tenDollars = new JTextField();
        twentyDollars = new JTextField();
        penny.setText("0");
        nickel.setText("0");
        dime.setText("0");
        quarter.setText("0");
        dollar.setText("0");
        fiveDollars.setText("0");
        tenDollars.setText("0");
        twentyDollars.setText("0");

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 8));
        panel1.add(pennyLabel);
        panel1.add(nickelLabel);
        panel1.add(dimeLabel);
        panel1.add(quarterLabel);
        panel1.add(dollarLabel);
        panel1.add(fiveDollarsLabel);
        panel1.add(tenDollarsLabel);
        panel1.add(twentyDollarsLabel);
        panel1.add(penny);
        panel1.add(nickel);
        panel1.add(dime);
        panel1.add(quarter);
        panel1.add(dollar);
        panel1.add(fiveDollars);
        panel1.add(tenDollars);
        panel1.add(twentyDollars);

        /*
        panel2
         */
        totalCashierLabel = new JLabel("Total: ");
        totalCashierAnswerLabel = new JLabel();
        setCashierButton = new JButton("Set Cashier");
        clearCashierButton = new JButton("Clear Cashier");

        panel2 = new JPanel(new GridLayout(2, 2));
        panel2.add(totalCashierLabel);
        panel2.add(totalCashierAnswerLabel);
        panel2.add(setCashierButton);
        panel2.add(clearCashierButton);

        setCashierButton.addActionListener(actionEvent -> setCashier());
        clearCashierButton.addActionListener(actionEvent -> clearCashier());


        /*
        Panel 3
         */
        priceLabel = new JLabel("Total Price: ");
        price = new JTextField();
        price.setText("0");
        price.setPreferredSize(new Dimension(160, 30));

        panel3 = new JPanel(new FlowLayout());
        panel3.add(priceLabel);
        panel3.add(price);

        /*
        Panel 4
         */
        pennyLabel2 = new JLabel("penny: ");
        nickelLabel2 = new JLabel("nickel: ");
        dimeLabel2 = new JLabel("dime: ");
        quarterLabel2 = new JLabel("quarter: ");
        dollarLabel2 = new JLabel("$1: ");
        fiveDollarsLabel2 = new JLabel("$5: ");
        tenDollarsLabel2 = new JLabel("$10: ");
        twentyDollarsLabel2 = new JLabel("$20: ");
        pennyPaid = new JTextField();
        nickelPaid = new JTextField();
        dimePaid = new JTextField();
        quarterPaid = new JTextField();
        dollarPaid = new JTextField();
        fiveDollarsPaid = new JTextField();
        tenDollarsPaid = new JTextField();
        twentyDollarsPaid = new JTextField();
        pennyPaid.setText("0");
        nickelPaid.setText("0");
        dimePaid.setText("0");
        quarterPaid.setText("0");
        dollarPaid.setText("0");
        fiveDollarsPaid.setText("0");
        tenDollarsPaid.setText("0");
        twentyDollarsPaid.setText("0");

        panel4 = new JPanel(new GridLayout(2, 8));
        panel4.add(pennyLabel2);
        panel4.add(nickelLabel2);
        panel4.add(dimeLabel2);
        panel4.add(quarterLabel2);
        panel4.add(dollarLabel2);
        panel4.add(fiveDollarsLabel2);
        panel4.add(tenDollarsLabel2);
        panel4.add(twentyDollarsLabel2);
        panel4.add(pennyPaid);
        panel4.add(nickelPaid);
        panel4.add(dimePaid);
        panel4.add(quarterPaid);
        panel4.add(dollarPaid);
        panel4.add(fiveDollarsPaid);
        panel4.add(tenDollarsPaid);
        panel4.add(twentyDollarsPaid);

        /*
        Panel 5
         */
        totalPaidLabel = new JLabel("Total Paid: ");
        totalPaidAnswerLabel = new JLabel();
        calculateButton = new JButton("Get Change");
        clearButton = new JButton("Clear Payment");

        panel5 = new JPanel(new GridLayout(2, 2));
        panel5.add(totalPaidLabel);
        panel5.add(totalPaidAnswerLabel);
        panel5.add(calculateButton);
        panel5.add(clearButton);

        calculateButton.addActionListener(actionEvent -> {
            try {
                calcChange();
            } catch (NotEnoughChangeException e) {
                e.printStackTrace();
            }
        });
        clearButton.addActionListener(actionEvent -> clearPayment());


        /*
        Panel 6
         */
        changeLabel = new JLabel("Your Change");

        panel6 = new JPanel(new FlowLayout());
        panel6.add(changeLabel);

        /*
        Panel 7
         */
        pennyLabel3 = new JLabel("penny: ");
        nickelLabel3 = new JLabel("nickel: ");
        dimeLabel3 = new JLabel("dime: ");
        quarterLabel3 = new JLabel("quarter: ");
        dollarLabel3 = new JLabel("$1: ");
        fiveDollarsLabel3 = new JLabel("$5: ");
        tenDollarsLabel3 = new JLabel("$10: ");
        twentyDollarsLabel3 = new JLabel("$20: ");
        changePennyLabel = new JLabel();
        changeNickelLabel = new JLabel();
        changeDimeLabel = new JLabel();
        changeQuarterLabel = new JLabel();
        changeDollarLabel = new JLabel();
        changeFiveDollarsLabel = new JLabel();
        changeTenDollarsLabel = new JLabel();
        changeTwentyDollarsLabel = new JLabel();

        panel7 = new JPanel(new GridLayout(2, 8));
        panel7.add(pennyLabel3);
        panel7.add(nickelLabel3);
        panel7.add(dimeLabel3);
        panel7.add(quarterLabel3);
        panel7.add(dollarLabel3);
        panel7.add(fiveDollarsLabel3);
        panel7.add(tenDollarsLabel3);
        panel7.add(twentyDollarsLabel3);
        panel7.add(changePennyLabel);
        panel7.add(changeNickelLabel);
        panel7.add(changeDimeLabel);
        panel7.add(changeQuarterLabel);
        panel7.add(changeDollarLabel);
        panel7.add(changeFiveDollarsLabel);
        panel7.add(changeTenDollarsLabel);
        panel7.add(changeTwentyDollarsLabel);

        /*
        Panel 8
         */
        totalChangeLabel = new JLabel("Total Change: ");
        totalChangeAnswerLabel = new JLabel();

        panel8 = new JPanel(new FlowLayout());
        panel8.add(totalChangeLabel);
        panel8.add(totalChangeAnswerLabel);

        //add panels to JFrame
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
        add(panel7);
        add(panel8);

    }

    /*
    Sets the cashier register based on user input
    Assign total Register Label
     */
    private void setCashier(){
        Cash cashierCash = new Cash(Integer.valueOf(penny.getText()), +
                Integer.valueOf(nickel.getText()), +
                Integer.valueOf(dime.getText()), +
                Integer.valueOf(quarter.getText()), +
                Integer.valueOf(dollar.getText()), +
                Integer.valueOf(fiveDollars.getText()), +
                Integer.valueOf(tenDollars.getText()), +
                Integer.valueOf(twentyDollars.getText()));
        cashier = new Cashier(cashierCash);
        totalCashierAnswerLabel.setText(String.valueOf(cashier.getRegister().calcTotal()));
    }

    /*
    Clears the boxes and sets the cashier's register to null
     */
    private void clearCashier(){
        cashier = new Cashier(resetCash);
        totalCashierAnswerLabel.setText(String.valueOf(cashier.getRegister().calcTotal()));
        penny.setText("0");
        nickel.setText("0");
        dime.setText("0");
        quarter.setText("0");
        dollar.setText("0");
        fiveDollars.setText("0");
        tenDollars.setText("0");
        twentyDollars.setText("0");
    }

    /*
     Enters the user input into a Cash object and calls the cashier's pay method
     Assigns the change given labels
     */
    private void calcChange() throws NotEnoughChangeException {
        try {
            Cash payment = new Cash(Integer.valueOf(pennyPaid.getText()), +
                    Integer.valueOf(nickelPaid.getText()), +
                    Integer.valueOf(dimePaid.getText()), +
                    Integer.valueOf(quarterPaid.getText()), +
                    Integer.valueOf(dollarPaid.getText()), +
                    Integer.valueOf(fiveDollarsPaid.getText()), +
                    Integer.valueOf(tenDollarsPaid.getText()), +
                    Integer.valueOf(twentyDollarsPaid.getText()));
            Cash change = cashier.pay(Double.valueOf(price.getText()), payment);
            changePennyLabel.setText(String.valueOf(change.getPenny()));
            changeNickelLabel.setText(String.valueOf(change.getNickel()));
            changeDimeLabel.setText(String.valueOf(change.getDime()));
            changeQuarterLabel.setText(String.valueOf(change.getQuarter()));
            changeDollarLabel.setText(String.valueOf(change.getOneDollar()));
            changeFiveDollarsLabel.setText(String.valueOf(change.getFiveDollars()));
            changeTenDollarsLabel.setText(String.valueOf(change.getTenDollars()));
            changeTwentyDollarsLabel.setText(String.valueOf(change.getTwentyDollars()));
            totalPaidAnswerLabel.setText(String.valueOf(payment.calcTotal()));
            totalChangeAnswerLabel.setForeground(null);
            totalChangeAnswerLabel.setText(String.valueOf(change.calcTotal()));
        }
        catch(NotEnoughChangeException e){
            totalChangeAnswerLabel.setForeground(Color.RED);
            totalChangeAnswerLabel.setText(String.valueOf(e));
        }
    }

    /*
    Clears the boxes for the payment
     */
    private void clearPayment(){
        pennyPaid.setText("0");
        nickelPaid.setText("0");
        dimePaid.setText("0");
        quarterPaid.setText("0");
        dollarPaid.setText("0");
        fiveDollarsPaid.setText("0");
        tenDollarsPaid.setText("0");
        twentyDollarsPaid.setText("0");
        price.setText("0");
        totalPaidAnswerLabel.setText("");
    }


    public static void main(String[] args) throws NotEnoughChangeException {
        new DigitalCashierFrame().setVisible(true);
    }
}
