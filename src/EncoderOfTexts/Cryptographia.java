package EncoderOfTexts;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Cryptographia {

    int shift;
    Scanner text = new Scanner(System.in);
    String line = text.nextLine();


    public Cryptographia(String text, int shift) {
        this.line = text;
        this.shift = shift;
    }

    public Cryptographia() {};

    public static String encrypt(String text, int shift) {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        char[] encrypted = new char[text.length()];

        while (shift < 0) {
            shift += upper.length();
        }

        for (int i = 0; i < text.length(); i++) {
            if ('A' <= text.charAt(i) && text.charAt(i) <= 'Z') {
                encrypted[i] = upper.charAt((upper.indexOf(text.charAt(i)) + shift) % upper.length());  //как-то мудрено, пока не понял реализацию шифра в деталях. Почему так много вложенных скобок?
            } else if ('a' <= text.charAt(i) && text.charAt(i) <= 'z') {
                encrypted[i] = lower.charAt((lower.indexOf(text.charAt(i)) + shift) % lower.length());
            } else {
                encrypted[i] = text.charAt(i);
            }
        }

        return new String(encrypted);

    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void main(String[] args) {
        Cryptographia crypto = new Cryptographia();
        System.out.println("Внимание, сейчас мы зашифруем текст!");
        System.out.println(decrypt(crypto.line, -1));
        System.out.println("А теперь мы вернем его обратно, как был: ");
        System.out.println(encrypt(crypto.line, 0));

    }

}
