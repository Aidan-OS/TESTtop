package testtop;
/*
 *  TESTtop. Making a better TTS for a happier experience.
 */


/**
 * @version 0.1
 * @author Leone Shamoth
 */
public class Roll {
    
    public static int rollDie (int count, int dieType)
    {
        int toReturn = 0;
        
        for (int i = 0; i < count; i++)
        {
            toReturn += (int) (Math.random() * dieType + 1);
        }
        
        return (toReturn);
    }
}
