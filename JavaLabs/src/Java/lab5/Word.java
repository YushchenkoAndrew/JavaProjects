package Java.lab5;

public class Word {
    private Char[] aChar = new Char[12];


    void add(Char[] get_chars){
        for (int i = 0; i < get_chars.length; i++)
            aChar[i] = get_chars[i];
    }

    public Char[] get_Char() {
        return aChar;
    }
}
