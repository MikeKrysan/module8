package EncoderOfTexts;

import java.util.Scanner;

public class Cryptographia {
    String text;
    int shift;
   // Scanner text = new Scanner(System.in);
   // String line = text.nextLine();
    public Cryptographia(String text, int shift) {
        this.text = text;
        this.shift = shift;
    }

    public Cryptographia() {
    }

    public static String encrypt(String text, int shift) {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        char[] encrypted = new char[text.length()];

        while (shift < 0) {
            shift += upper.length();
        }

        for (int i = 0; i < text.length(); i++) {
            if ('A' <= text.charAt(i) && text.charAt(i) <= 'Z') {
                encrypted[i] = upper.charAt((upper.indexOf(text.charAt(i)) + shift) % upper.length());
            } else if ('a' <= text.charAt(i) && text.charAt(i) <= 'z') {
                encrypted[i] = lower.charAt((lower.indexOf(text.charAt(i)) + shift) % lower.length());
            } else {
                encrypted[i] = text.charAt(i);
            }
        }
        return String.valueOf(encrypted);
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        String line = text.nextLine();
        Cryptographia crypto = new Cryptographia(line, -1);
        System.out.println("Внимание, сейчас мы зашифруем текст!");
        System.out.println(decrypt(crypto.text, -1));
        System.out.println("А теперь мы вернем его обратно, как был: ");
        System.out.println(encrypt(crypto.text, 0));
    }

}
