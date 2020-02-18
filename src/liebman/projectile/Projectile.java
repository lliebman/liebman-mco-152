package liebman.projectile;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class Projectile {

    public static final double EARTH_GRAVITY = 9.8;
    private final double angle;
    private final double velocity;
    private double time;


    public Projectile(double angleInDegrees, double velocity) {
        this.angle = Math.toRadians(angleInDegrees);
        this.velocity = velocity;
        this.time = time;
    }

    public double getX() {
        return velocity * cos(angle) * time;
    }

    public double getY() {
        return velocity * sin(angle) * time + (EARTH_GRAVITY * (time * time));
    }

    public double getTime(){
        return time;
    }

    public void increaseTime(double delta){

        time += delta;
    }

    @Override
    public String toString() {
        return  time + " : " +
                "(" + getX() + ", " + getY() + ")";
    }
}

/*
        - Add a time variable to Projectile
        - Add an increaseTime(double) method to Projectile to change the time.
        - Change calculateX(double) to getX() which uses the time variable in Projectile.
        - Change calculateY(double) to getY() which uses the time variable in Projectile.
        - Add a toString() method in Projectile that returns "time : (x, y)"
 */