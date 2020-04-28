package liebman.Shape;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapeComponent;
    private JPanel leftPanel;

    private JButton houseButton;
    private JButton shoeButton;
    private JButton fishButton;
    private JButton flamingoButton;

    public ShapesFrame() {
        setSize(450, 350);
        setTitle("Shapes Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        shapeComponent = new ShapeComponent();

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 1));

        houseButton = new JButton("House");
        shoeButton = new JButton("Shoe");
        fishButton = new JButton("Fish");
        flamingoButton = new JButton("Flamingo");

      //  ImageIcon thisbutton = new ImageIcon("this.jpg");

        leftPanel.add(houseButton);
        leftPanel.add(shoeButton);
        leftPanel.add(fishButton);
        leftPanel.add(flamingoButton);

        houseButton.addActionListener(actionListener -> shapeComponent.setShapeHouse());
        shoeButton.addActionListener(actionListener -> shapeComponent.setShapeShoe());
        fishButton.addActionListener(actionListener -> shapeComponent.setShapeFish());
        flamingoButton.addActionListener(actionListener -> shapeComponent.setShapeFlamingo());

        add(leftPanel, BorderLayout.WEST);

        add(shapeComponent, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new ShapesFrame().setVisible(true);
    }
}
