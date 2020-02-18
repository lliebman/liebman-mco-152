package liebman.projectile;

import java.util.ArrayList;
import java.util.Random;


public class ProjectileMath {

    public static final int NUM_PROJECTILES = 5;

    public static void main(String[] args) {

        Random rand = new Random();

        ArrayList<Projectile> projectiles = new ArrayList<>();


        for (int i = 0; i < NUM_PROJECTILES; i++){
            projectiles.add(new Projectile(rand.nextDouble() * 180, rand.nextDouble() * 100));
        }

        for (Projectile projectile : projectiles){
            for (int i = 0; i < 11; i++) {
                System.out.println(projectile);
                projectile.increaseTime(1);
            }
        }
    }
}



/*      - Change ProjectileMath to keep track of 5 Projectiles instead of 1.
        - Each Projectile should have a random angle from 0 to 180 and a random velocity from 0 to 100.
*/
