import greenfoot.*;

public class FlappyWorld extends World {

    private int timer = 0;
    private static final int GAP = 150; // space between top and bottom pipe

    public FlappyWorld() {
        super(600, 500, 1);
        setBackground(makeBackground());
        addObject(new Bird(), 150, 250);
    }

    public void act() {
        timer++;
        // Spawn a new pipe pair every 80 acts
        if (timer % 80 == 0) {
            spawnPipes();
        }
    }

    private void spawnPipes() {
        int gapCenter = 100 + Greenfoot.getRandomNumber(getHeight() - 200);

        int topHeight = gapCenter - GAP / 2;
        int bottomHeight = getHeight() - (gapCenter + GAP / 2);

        Pipe top = new Pipe(topHeight, true);
        addObject(top, getWidth() + 25, topHeight / 2);

        Pipe bottom = new Pipe(bottomHeight, false);
        addObject(bottom, getWidth() + 25, getHeight() - bottomHeight / 2);
    }

    private GreenfootImage makeBackground() {
        GreenfootImage img = new GreenfootImage(getWidth(), getHeight());

        // Sky
        img.setColor(new Color(113, 197, 255));
        img.fillRect(0, 0, getWidth(), getHeight() - 60);

        // Ground
        img.setColor(new Color(222, 184, 135));
        img.fillRect(0, getHeight() - 60, getWidth(), 60);

        // Grass
        img.setColor(new Color(34, 139, 34));
        img.fillRect(0, getHeight() - 60, getWidth(), 15);

        return img;
    }
}
