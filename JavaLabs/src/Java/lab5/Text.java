package Java.lab5;

import java.util.Arrays;
import java.util.Comparator;

public class Text {
    private Sentence[] sentence;
    private int i = 0;

    public Text(StringBuilder stringBuilder) {
        stringBuilder.append(" ");
        sentence = new Sentence[size(stringBuilder)];

        int last = 0, num = -1;
        Object[] objects = new Object[2];
        Word[] word = new Word[20];
        Comma[] commas = new Comma[20];
        for (int i = 0; i < stringBuilder.length(); i++) {
            if ((stringBuilder.charAt(i) == ' ')) {
                int comma = 0;
                num++;
                if ((stringBuilder.charAt(i - 1) == ',') || (stringBuilder.charAt(i - 1) == ':') || (stringBuilder.charAt(i - 1) == ';')
                        || (stringBuilder.charAt(i - 1) == '.')) {
                    comma = 1;
                    commas[num] = new Comma(stringBuilder.charAt(i - 1));
                }
                else
                    commas[num] = new Comma('#');
                word[num] = create_word(i, last, comma, stringBuilder);
                if (stringBuilder.charAt(i - 1) == '.') {
                    Sentence sentence = new Sentence(num + 1);
                    for (int j = 0; j <= num; j++) {
                        sentence.add_word(word[j]);
                        sentence.add_comma(commas[j]);
                    }
                    add(sentence);
                    num = -1;
                    word = new Word[20];
                    commas = new Comma[20];
                }
                last = i + 1;
            }
        }

    }

    private Word create_word(int i, int last, int comma, StringBuilder str){
        Word word = new Word();
        Char[] chars = new Char[i - last - comma];
        for (int j = last; j < i - comma; j++)
            chars[j - last] = new Char(str.charAt(j));
        word.add(chars);
        return word;
    }

    private int size(StringBuilder str){
        int num_sentence = 0;
        for (int i = 0 ; i < str.length(); i++)
            if (str.charAt(i) == '.'){
                num_sentence++;
            }
        return num_sentence;
    }

    void add(Sentence sentence){
        this.sentence[this.i] = sentence;
        this.i++;
    }
    void my_task(){
        Arrays.sort(sentence, Comparator.comparing(Sentence::getSize));
    }

    void print(){
        for (int j = 0; j < this.i; j++){
            for (int k = 0; k < sentence[j].getSize(); k++) {
                for (int l = 0; l < sentence[j].get_word()[k].get_Char().length; l++)
                    if (sentence[j].get_word()[k].get_Char()[l] != null)
                        System.out.print(sentence[j].get_word()[k].get_Char()[l].getC());
                if (sentence[j].get_comma()[k].getChars() != '#')
                    System.out.print(sentence[j].get_comma()[k].getChars());
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
