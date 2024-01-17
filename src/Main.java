import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

public class Main {

    /*
     *  -s аргумент отвечает за вывод краткой статистики(кол-в записанных элементов)
     *  -f аргумент отвечате за вывод полной статистики (мин и макс значение
     * для строк мак и мин длинна строки)
     *  -o аргумент отвечает за путь к сохранению вых файлов (-o c:/)
     *  -p аргумент отвечает за имя выходного фала ( -p same-) result (same-integer.txt)
     *  -a агрумент отвечает за добавление данных в текуйщий фаил
     * */
    public static void main(String[] args) {

        StartUtiClass startUtiClass = new StartUtiClass();
        startUtiClass.startUtil(args);

    }
}