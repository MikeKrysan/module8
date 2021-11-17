package EncoderOfTexts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cryptographia {
    String text;
    int shift;

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
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        String formattedDateString = localDate.format(formatter); //todo use in our code
        System.out.println("Внимание, сейчас мы зашифруем текст!");
        System.out.println((decrypt(crypto.text, -1)) + " " +  formattedDateString);
        System.out.println("А теперь мы вернем его обратно, как был: ");
        System.out.println(encrypt(crypto.text, 0));
    }

}
