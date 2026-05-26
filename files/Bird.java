import greenfoot.*;

public class Bird extends Actor {

    private double velocity = 0;

    public void act() {
        // Gravity
        velocity += 0.5;
        setLocation(getX(), (int)(getY() + velocity));

        // Jump on space or click
        if (Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            velocity = -8;
        }

        // Hit ground or ceiling
        if (getY() >= getWorld().getHeight() - 10 || getY() <= 0) {
            Greenfoot.stop();
        }

        // Hit a pipe
        if (getOneIntersectingObject(Pipe.class) != null) {
            Greenfoot.stop();
        }
    }
}
