import greenfoot.*;

public class Pipe extends Actor {

    private int speed = 3;

    public Pipe(int height, boolean isTop) {
        GreenfootImage img = new GreenfootImage(50, height);
        img.setColor(new Color(34, 139, 34));
        img.fillRect(0, 0, 50, height);
        img.setColor(new Color(0, 100, 0));
        img.drawRect(0, 0, 49, height - 1);
        setImage(img);
    }

    public void act() {
        setLocation(getX() - speed, getY());

        // Remove when off screen
        if (getX() < -30) {
            getWorld().removeObject(this);
        }
    }
}
