import java.io.File;

/*
Определите размер каталога с файлами с помощью выше изученных методов. На вход подаётся ссылка на папку. На выходе вы должны получить информацию
о размере папки в мегабайтах.
 */
public class Solution8_3_1 {
    public static void main(String[] args) {
        File folder = new File("D:\\Video");
        long size = getFolderSize(folder);
        System.out.println(size/1024/1021 +" Mb");
    }

    private static long getFolderSize(File folder) {
        File[]files = folder.listFiles();           //возвращает абсолютные пути ко всем файлам и каталогам в каталоге и возвращает массив файлов
        long len = 0;
        int count = files.length;
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                len += files[i].length();
            }
            else {
                len += getFolderSize(files[i]);
            }
        }
        return len;
    }
}
/*
Фича в том, что нужно указать каталог, в котором будет несколько файлов, а метод их переберет в массив, и выдаст размер в сумме этих всех файлов.
Если же без метода и без массива пытатся узнать размер каталога - консоль выведет 0

Метод list () возвращает имена файлов всех файлов и каталогов в определенном каталоге и возвращает массив String.

Метод listFiles () возвращает абсолютные пути ко всем файлам и каталогам в каталоге и возвращает массив файлов
*/