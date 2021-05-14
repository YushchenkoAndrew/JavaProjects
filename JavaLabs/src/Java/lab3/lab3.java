package Java.lab3;

public class lab3 {
    public static void main(String[] args) {
        String str = "Hey there are? It's Java time. Add, some strange sstring!";
        StringBuilder stringBuilder = new StringBuilder(str);

        for (int i = 0; i < stringBuilder.length(); i++){   //correction stringBuild
            if ((stringBuilder.charAt(i) == '!')  || (stringBuilder.charAt(i) == '?'))
                stringBuilder.replace(i, i + 1, ".");
            if ((stringBuilder.charAt(i) == ':')  || (stringBuilder.charAt(i) == ';')
                    || (stringBuilder.charAt(i) == ',') || (stringBuilder.charAt(i) == '"')
                    || (stringBuilder.charAt(i) == '-'))
                stringBuilder.replace(i, i + 1, "");
        }

        int word_len = -1, start_word = 0, start_line = 0;
        boolean next_line = false;

        for (int i = 0; i < stringBuilder.length(); i++){
            if (stringBuilder.charAt(i) == '.') {
                if (!(i - start_word >= word_len))
                    next_line = true;

                if (!next_line)
                    System.out.println(stringBuilder.substring(start_line, i));
                next_line = false;
                start_line = i + 2;
                start_word = start_line;
                word_len = -1;
            } else {
                if (!next_line && stringBuilder.charAt(i) == ' ') {
                    if (i - start_word >= word_len)
                        word_len = i - start_word;
                    else
                        next_line = true;
                    start_word = i + 1;

                }
            }

        }
    }
}
