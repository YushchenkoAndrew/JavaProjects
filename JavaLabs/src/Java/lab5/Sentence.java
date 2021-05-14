package Java.lab5;

public class Sentence {
    private Word[] words;
    private Comma[] commas;
    private int i;

    public Sentence(int size) {
        commas = new Comma[size];
        words = new Word[size];

        this.i = 0;
    }

    void add_word(Word word){
        words[this.i] = word;
    }
    void add_comma(Comma comma){
        commas[this.i] = comma;
        this.i++;
    }

    public int getSize() {
        return words.length;
    }

    public Word[] get_word() {
        return words;
    }
    public Comma[] get_comma() {
        return commas;
    }

}
