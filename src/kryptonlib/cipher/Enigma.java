package kryptonlib.cipher;

import java.util.StringTokenizer;

/**
 * Created by lophtpicker on 09.05.2017.
 */

public class Enigma {

}

abstract class Rotor {
    private static final int AlphabetLength = 27;

    protected char [] rotor = new char[AlphabetLength];

    protected int turns = 0;

    public int indexOf(char c) {
        for(int i = 0; i < AlphabetLength; i++){
            if(rotor[i] == c)
                return i;
        }

        return -1;
    }

    public int turns()
    {return turns;}

    public void turn() {
        char c = rotor[0];
        for(int i = 1; i < AlphabetLength;i++){
            rotor[i-1] = rotor[i];
        }

        rotor[AlphabetLength-1] = c;

        turns++;
    }

    public char charAt(int i)
    {
        return rotor[i];
    }

    public Rotor(){
        turns = 0;
        setAlphabet();
    }

    public abstract void setAlphabet();
}

class LargeRotor extends Rotor{
    @Override
    public void setAlphabet()
    {
        int  i = 0;

        rotor[i] = ' ';
        i++;

        rotor[i] = 'B';
        i++;

        rotor[i] = 'D';
        i++;

        rotor[i] = 'F';
        i++;

        rotor[i] = 'H';
        i++;

        rotor[i] = 'J';
        i++;

        rotor[i] = 'L';
        i++;

        rotor[i] = 'N';
        i++;

        rotor[i] = 'P';
        i++;

        rotor[i] = 'R';
        i++;

        rotor[i] = 'T';
        i++;

        rotor[i] = 'V';
        i++;

        rotor[i] = 'X';
        i++;

        rotor[i] = 'Z';
        i++;

        rotor[i] = 'A';
        i++;

        rotor[i] = 'C';
        i++;

        rotor[i] = 'E';
        i++;

        rotor[i] = 'G';
        i++;

        rotor[i] = 'I';
        i++;

        rotor[i] = 'K';
        i++;

        rotor[i] = 'M';
        i++;

        rotor[i] = 'O';
        i++;

        rotor[i] = 'Q';
        i++;

        rotor[i] = 'S';
        i++;

        rotor[i] = 'U';
        i++;

        rotor[i] = 'W';
        i++;

        rotor[i] = 'Y';

        System.out.println("Finished Initialising Large Rotor  i="+i);
    }
}

class MedRotor extends Rotor {
    @Override
    public void setAlphabet()
    {
        int i = 0;

        rotor[i] = ' ';
        i++;

        rotor[i] = 'E';
        i++;

        rotor[i] = 'J';
        i++;

        rotor[i] = 'O';
        i++;

        rotor[i] = 'T';
        i++;

        rotor[i] = 'Y';
        i++;

        rotor[i] = 'C';
        i++;

        rotor[i] = 'H';
        i++;

        rotor[i] = 'M';
        i++;

        rotor[i] = 'R';
        i++;

        rotor[i] = 'W';
        i++;

        rotor[i] = 'A';
        i++;

        rotor[i] = 'F';
        i++;

        rotor[i] = 'K';
        i++;

        rotor[i] = 'P';
        i++;

        rotor[i] = 'U';
        i++;

        rotor[i] = 'Z';
        i++;

        rotor[i] = 'D';
        i++;

        rotor[i] = 'I';
        i++;

        rotor[i] = 'N';
        i++;

        rotor[i] = 'S';
        i++;

        rotor[i] = 'X';
        i++;

        rotor[i] = 'B';
        i++;

        rotor[i] = 'G';
        i++;

        rotor[i] = 'L';
        i++;

        rotor[i] = 'Q';
        i++;

        rotor[i] = 'V';

        System.out.println("Finished Initialising Med Rotor  i="+i);
    }
}

class SmallRotor extends Rotor {
    @Override
    public void setAlphabet()
    {
        int i = 0;

        rotor[i] = ' ';
        i++;

        rotor[i] = 'E';
        i++;

        rotor[i] = 'J';
        i++;

        rotor[i] = 'O';
        i++;

        rotor[i] = 'T';
        i++;

        rotor[i] = 'Y';
        i++;

        rotor[i] = 'C';
        i++;

        rotor[i] = 'H';
        i++;

        rotor[i] = 'M';
        i++;

        rotor[i] = 'R';
        i++;

        rotor[i] = 'W';
        i++;

        rotor[i] = 'A';
        i++;

        rotor[i] = 'F';
        i++;

        rotor[i] = 'K';
        i++;

        rotor[i] = 'P';
        i++;

        rotor[i] = 'U';
        i++;

        rotor[i] = 'Z';
        i++;

        rotor[i] = 'D';
        i++;

        rotor[i] = 'I';
        i++;

        rotor[i] = 'N';
        i++;

        rotor[i] = 'S';
        i++;

        rotor[i] = 'X';
        i++;

        rotor[i] = 'B';
        i++;

        rotor[i] = 'G';
        i++;

        rotor[i] = 'L';
        i++;

        rotor[i] = 'Q';
        i++;

        rotor[i] = 'V';

        System.out.println("Finished Initialising Med Rotor  i="+i);
    }

}