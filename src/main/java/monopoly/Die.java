package monopoly;

import java.util.Random;

public class Die {
    private int faceValue;
    private static final int MAX_VALUE = 6;
    private Random random = new Random();

    public void roll(){
        faceValue =  Math.abs(random.nextInt()) % MAX_VALUE + 1;
    }
    public int getFaceValue(){
        return faceValue;
    }
}
