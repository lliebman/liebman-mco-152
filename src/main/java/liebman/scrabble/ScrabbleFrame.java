package liebman.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame {

    private final JTextField wordField;
    private final JLabel answerLabel;
    private Dictionary dictionary;

    public ScrabbleFrame() throws FileNotFoundException {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());//box layout y-axis

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 30));
        JButton checkButton = new JButton("Check");
        
        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setOpaque(true);
        answerLabel.setPreferredSize(new Dimension(100, 40));
        add(wordField);
        add(checkButton);
        add(answerLabel);

        try {
            System.out.println(System.currentTimeMillis());
            dictionary = new Dictionary("src/liebman/scrabble/dictionary.txt");
            System.out.println(System.currentTimeMillis());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void checkWord(){
        boolean isInDictionary = dictionary.validateWord(wordField.getText());
        answerLabel.setBackground(isInDictionary ? Color.GREEN : Color.RED);
        answerLabel.setText(String.valueOf(isInDictionary));
    }

    public static void main(String[] args) throws FileNotFoundException {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
