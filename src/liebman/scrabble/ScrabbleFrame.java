package liebman.scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame {

    private final JTextField wordField;
    private final JLabel answerLabel;

    public ScrabbleFrame() throws FileNotFoundException {
        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension(160, 30));
        JButton checkButton = new JButton("Check");
        
        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        add(wordField);
        add(checkButton);
        add(answerLabel);
    }

    public void checkWord(){
        try{
            Dictionary dictionary = new Dictionary("src/liebman/scrabble/dictionary.txt");
            boolean isInDictionary = dictionary.validateWord(wordField.getText());
            answerLabel.setText(String.valueOf(isInDictionary));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
