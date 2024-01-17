import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StartUtiClass  implements IStatistics {
    boolean fullState = false ;
    boolean minState = false ;
    boolean addingFile = false;
    String saveFilePath = "";
    String outNameFile = "";
    List <String> fileInPath  = new ArrayList<>();
    public  void startUtil(String [] args)//Метод для запуска утилиты
    {
       parseArgs(args);
        if (saveFilePath==null&&saveFilePath.isEmpty()) //Проверка пустой ли путь для сох файла
            saveFilePath = System.getProperty("user.dir") + File.separator ; //получение директории где находится фали jar

       creatFileByType(outNameFile,saveFilePath);

    }

    //Метод для создание файлом по типам данных

    private  void creatFileByType(String outNameFile , String saveFilePath) {
         FileReaderWriter reader = new FileReaderWriter();
         ModelTypeAFile model = reader.getAllStrFromFileIn(fileInPath);
         if (model.getTypeFloat().size()!=0){
             String puth = saveFilePath+outNameFile+"float.txt";
             creatFile(puth);
             reader.writeFileByType(model.getTypeFloat(), puth,addingFile);
             getStatistics(model.getTypeFloat(),"float",minState,fullState);
         }
         if (model.getTypeInteger().size()!=0) {
             String puth = saveFilePath+outNameFile+"integer.txt";
             creatFile(puth);
             reader.writeFileByType(model.getTypeInteger(), puth,addingFile);
             getStatistics(model.getTypeInteger(),"integer",minState,fullState);
         }
         if (model.getTypeString().size()!=0){
             String puth = saveFilePath+outNameFile+"string.txt";
             creatFile(puth);
             reader.writeFileByType(model.getTypeString(), puth,addingFile);
             getStatistics(model.getTypeString(),"string",minState,fullState);

         }
    }

    //Обший метод создание файла сделал один метод и передаю его по условиям
    private  void creatFile(String path){
       try{
           Path file = Paths.get(path);
       } catch (Exception e) {
           System.out.println("Ошибка создание файла"+e.getMessage());
       }
    }
    //Парсинг аргументов
    private  void  parseArgs (String [] args){
        for (int i = 0 ; i<args.length; i++){
            switch (args[i]) {
                case "-o":
                    saveFilePath = args[i + 1];
                    i++;
                    break;
                case "-s":
                    minState = true;
                    break;
                case "-f":
                    fullState = true;
                    break;
                case "-a":
                    addingFile = true;
                    break;
                case "-p":
                    outNameFile = args[i + 1];
                    i++;
                    break;
                default:
                    fileInPath.add(args[i]);
                    break;

            }
        }
    }

    @Override
    // Override Метод хотел сделать обший метод для всех типов
    // то есть что бы метод подстраивался под входные данные как видете что то не получилось
    //
    public  void   getStatistics(List str, String statisticsName, boolean minState, boolean fulState) {
        if (minState){
            System.out.println("Краткая статистика"+"\n"+"Элементов записанно в файл "+statisticsName+ ": "
                    +str.size());
        }

        if (fullState) {

            if (statisticsName.contains("string")){
                List <String> newStr =new ArrayList<>();
                newStr = str;
                String max = Collections.max(newStr, Comparator.comparing(s->s.length()));
                String min = Collections.min(newStr,Comparator.comparing(s->s.length()));
                System.out.println("Полная статис\n Максимальная длинна и минимальная длинна строки : " +
                        "Max = " + max.length() + " , Min = " + min.length() + "\n Количество элементов в файле " + statisticsName +
                        ": " + str.size());
            }
            else if (statisticsName.contains("float"))
            {
                List<Float> num = new ArrayList<>();
                num =str;
                double result= 0 ;
                double arithmeticResult = 0 ;
                for (float a : num){
                    result +=a;
                }
                arithmeticResult = result / num.size();
                System.out.println("Полная статис\n Максимальная длинна и минимальная длинна строки : " +
                        "Max = " + Collections.max(num) + " , Min = " + Collections.min(num) + "\n Количество элементов в файле " + statisticsName +
                        ": " + str.size() + "\n Среднее арифметическое : "+ arithmeticResult);
            }
            else if (statisticsName.contains("integer"))
            {
                List<Integer> num = new ArrayList<>();
                num = str;
                int result= 0 ;
                double arithmeticResult = 0 ;
                for (int a : num){
                    result +=a;
                }
                arithmeticResult = result / num.size();
                System.out.println("Полная статис\n Максимальная длинна и минимальная длинна строки : " +
                        "Max = " + Collections.max(num) + " , Min = " + Collections.min(num) + "\n Количество элементов в файле " + statisticsName +
                        ": " + str.size() + "\n Среднее арифметическое : "+ arithmeticResult);
            }

        }

    }


}
