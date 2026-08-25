package string;
public class StringFunction {
    public static void main(String[] args) {
        String word = "Debanjan";
        int i = 0;
        while(i < word.length()){
            char ch = word.charAt(i);

            if(word.indexOf(ch) != word.lastIndexOf(ch)){
                System.out.println("The first duplicate" + ch);
                break;
            }

            System.out.println("Next");
            i++;
        }
    }
}
