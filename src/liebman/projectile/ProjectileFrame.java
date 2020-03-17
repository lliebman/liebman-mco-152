package liebman.projectile;

import javax.swing.*;
import java.awt.*;

import static java.lang.Double.parseDouble;

public class ProjectileFrame extends JFrame {

    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;

    private JPanel leftPanel;

    private Projectile projectile;

    public ProjectileFrame() {

        setSize(400, 500);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        projectileCoordinates = new JTextArea();
        projectileCoordinates.setEditable(false);
        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        velocityLabel = new JLabel("Velocity");
        angleLabel = new JLabel("Angle (degrees)");

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);

        add(leftPanel, BorderLayout.WEST);

        calculateButton.addActionListener(actionEvent -> calcVelocity());
        add(projectileCoordinates, BorderLayout.CENTER);
    }

        private void calcVelocity(){
            projectile = new Projectile(Double.valueOf(angle.getText()), Double.valueOf(velocity.getText()));
            for (int i = 0; i<30; i++) {
                projectile.increaseTime(1);
                projectileCoordinates.append(String.valueOf(projectile.toString()) + "\n");
            }
    }

    public static void main(String[] args) {
        new ProjectileFrame().setVisible(true);
    }

}
