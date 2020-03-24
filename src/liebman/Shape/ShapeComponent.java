package liebman.Shape;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    private String shape;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        g.translate(centerX, centerY);

        if (shape.equals("house")) {
            drawHouse(g, centerX, centerY);
        }
        else if(shape.equals("shoe")){
            drawShoe(g);
        }
        else if(shape.equals("fish")){
            drawFish(g);
        }
        else if(shape.equals("flamingo")){
            drawFlamingo(g);
        }
    }



    private void drawHouse(Graphics g, int x, int y) {
        //chimney
        g.setColor(Color.RED);
        g.fillRect(-14, -40, 8, 20);

        //house
        g.setColor(Color.YELLOW);
        g.fillRect( -20, -20, 40, 40);

        //door
        g.setColor(Color.GREEN);
        g.fillRect(-14, +0, 8, 20);

        //roof triangle
        g.setColor(Color.BLUE);
        int x1[] = {-25, 0, +25};
        int y1[] = {-20, -40, -20};
        g.fillPolygon(x1, y1, 3);
    }

    private void drawFish(Graphics g) {
        //body
        g.setColor(Color.RED);
        int x1[] = {-100, +0, +100};
        int y1[] = {+0, -100, +0};
        g.fillPolygon(x1, y1, 3);
        int x2[] = {-100, 0, +100};
        int y2[] = {-0, +100, -0};
        g.fillPolygon(x2, y2, 3);

        //fins
        g.setColor(Color.ORANGE);
        int x3[] = {0, +40, +20};
        int y3[] = {-100, -140, -80};
        g.fillPolygon(x3, y3, 3);
        int x4[] = {0, +40, +20};
        int y4[] = {+100, +140, +80};
        g.fillPolygon(x4, y4, 3);
        int x5[] = {-20, +0, -20};
        int y5[] = {-0, +0, +20};
        g.fillPolygon(x5, y5, 3);

        //tail
        int x6[] = {+80, +130, +110, +130, +80, +100};
        int y6[] = {-20, -70, +0, +70, +20, +0};
        g.fillPolygon(x6, y6, 6);

        //eye
        g.setColor(Color.BLACK);
        g.fillOval(-50, -30, 5, 5);
    }

    private void drawShoe(Graphics g) {
        //center shoe
        g.setColor(Color.WHITE);
        int x1[] = {-20, -10, +30, +30, -20};
        int y1[] = {-10, -20, +0, +14, +10};
        g.fillPolygon(x1, y1, 5);

        //back shoe
        g.setColor(Color.BLACK);
        g.fillRect(-40, -10, 20, 20);

        //heel
        int x2[] = {-40, -20, -20, -36};
        int y2[] = {+10, +10, +16, +16};
        g.fillPolygon(x2, y2, 4);

        //toe
        int x3[] = {+30, +50, +50, +30};
        int y3[] = {+0, -3, +7, +14};
        g.fillPolygon(x3, y3, 4);

        //soul
        int x4[] = {-20, +30, +30, -20};
        int y4[] = {+10, +14, +16, +12};
        g.fillPolygon(x4, y4, 4);
    }

    private void drawFlamingo(Graphics g){
        //tail
        g.setColor(Color.PINK);
        int x1[] = {+40, +90, +50};
        int y1[] = {-10, +20, +20};
        g.fillPolygon(x1, y1, 3);

        //neck
        int x2[] = {-60, -50, -30, -40};
        int y2[] = {-20, -40, -20, -0};
        g.fillPolygon(x2, y2, 4);
        int x3[] = {-60, -50, -50, -60};
        int y3[] = {-95, -105, -45, -35};
        g.fillPolygon(x3, y3, 4);

        //head
        g.fillOval(-75, -115, 30, 20);

        //beak
        g.setColor(Color.WHITE);
        int x4[] = {-75, -75, -90};
        int y4[] = {-110, -100, -100};
        g.fillPolygon(x4, y4, 3);
        g.setColor(Color.BLACK);
        int x5[] = {-90, -75, -90};
        int y5[] = {-100, -100, -80};
        g.fillPolygon(x5, y5, 3);

        //leg1
        int x6[] = {+10, +15, +15, +10};
        int y6[] = {+25, +25, +100, +100};
        g.fillPolygon(x6, y6, 4);

        //leg2
        int x7[] = {+10, +15, +40, -10, -10, +30};
        int y7[] = {+25, +25, +55, +55, +50, +50};
        g.fillPolygon(x7, y7, 6);

        //body
        g.setColor(Color.PINK);
        g.fillOval(-40, -20, 90, 50);
    }

    public void setShapeHouse() {
        shape = "house";
        repaint();
    }

    public void setShapeShoe() {
        shape = "shoe";
        repaint();
    }

    public void setShapeFish() {
        shape = "fish";
        repaint();
    }

    public void setShapeFlamingo() {
        shape = "flamingo";
        repaint();
    }

}
