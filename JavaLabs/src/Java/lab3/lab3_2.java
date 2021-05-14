package Java.lab3;

public class lab3_2 {
    public static void main(String[] args) {
        String str = "Add, some strange sstring! It is Java time. Hey there are?";
        StringBuilder stringBuilder = new StringBuilder(str);

        for (int i = 0; i < stringBuilder.length(); i++){   //correction stringBuild
            if ((stringBuilder.charAt(i) == '!')  || (stringBuilder.charAt(i) == '?'))
                stringBuilder.replace(i, i + 1, ".");
            if ((stringBuilder.charAt(i) == ':')  || (stringBuilder.charAt(i) == ';')
                    || (stringBuilder.charAt(i) == ',') || (stringBuilder.charAt(i) == '"')
                    || (stringBuilder.charAt(i) == '-'))
                stringBuilder.replace(i, i + 1, "");
        }
        stringBuilder.insert(0, " ");

        int[] str_index = new int[stringBuilder.length() / 5];
        str_index[0] = 0;
        int count = -1, j = 0, num, correction = 0, i = 0;

        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) == ' ')
                count++;
            if (stringBuilder.charAt(i) == '.') {
                count++;
                stringBuilder.insert(str_index[j], Integer.toString(count));
                j++;
                correction = (Integer.toString(count)).length();
                i += correction;
                str_index[j] = i + 1;
                if (j > 1) {
                    int times = 1;
                    do {
                        int k = str_index[j - times];
                        num = 0;
                        while (stringBuilder.charAt(k) != ' ') {
                            num = num * 10 + (stringBuilder.charAt(k) - 48);
                            k++;
                        }
                        times++;
                    } while ((count > num) || (j - times >= 0));
                    StringBuilder sub_str = new StringBuilder(stringBuilder.substring(str_index[j - 1], i + 1));
                    stringBuilder.insert(str_index[j - times + 1]  , sub_str);
                    stringBuilder.replace(str_index[j - 1] + sub_str.length(), i + sub_str.length() + 1,"");
                }
                count = -1;
            }
            i++;
        }
        System.out.println(stringBuilder);
    }
}
