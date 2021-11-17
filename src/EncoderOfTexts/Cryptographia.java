package EncoderOfTexts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
Шифрователь текстов
Итак, попробуем создать программу, которая будет шифровать тексты.

Выполнять она должна следующую логику:
Мы должны шифровать переданную строку, то есть заменять одни буквы другими.
Мы должны суметь расшифровать её обратно.
Дополнительно*:

Также к сообщению нужно задавать время отправки, и его тоже нужно шифровать и дешифровать.
Для этого вам нужны будут следующие вещи:

Переменная или массивы, которые будут хранить ключ к шифровке/дешифровке.
Метод, который в цикле будет зашифровать строку при помощи метода replace() или без цикла с помощью replaceAll(), вызванного на объекте String.
И такой же метод для дешифровки, работающий в обратную сторону.
Сложность шифровки можете выбрать сами, тут уж как живущий в вас маленький конспиролог повелит…
 */
public class Cryptographia {
   // String text;
   // int shift;
/*
    public Cryptographia(String text, int shift) {
        this.text = text;
        this.shift = shift;
    }

    public Cryptographia() {
    }
*/
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
        //Scanner text = new Scanner(System.in);
        //String line = text.nextLine();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        String formattedDateString = localDate.format(formatter); //todo use in our code
        String text = "adfasdgfsdgsdgdDGF";
        String line = formattedDateString +  " " + text;
        Cryptographia crypto = new Cryptographia();
        System.out.println("Внимание, сейчас мы зашифруем текст!");
        System.out.println(crypto.encrypt(line, -1));
        System.out.println("А теперь мы вернем его обратно, как был: ");
        System.out.println(crypto.decrypt(line, 0));
    }
}

/*
Задание сделано не до конца, когда пробуешь зашифровать дату, то получаешь только увеличенный диапазон смещения букв на цифры.
Посыл следующий - Дата - Время - это не текст, и если нужно строковое представление, то нужно использовать объект форматирования для его создания.
Можно также рассмотреть пример создания проекта, выполненный Романом, я взял с Git , лежижт в папке Cryptography1
*/