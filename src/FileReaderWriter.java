import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {

    public ModelTypeAFile getAllStrFromFileIn(List<String> filePathList) {
        ModelTypeAFile modelList ;
        String strFromFil = "";
        List<String> allStrFromFile = new ArrayList<>();
        if (filePathList != null) {
            for (String path : filePathList) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

                    while ((strFromFil = reader.readLine()) != null) {
                        allStrFromFile.add(strFromFil);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Фаил  с таким путем не найден" + path);

                } catch (IOException e) {
                    System.out.println("Не получилось прочитать  файл" + path);
                }
            }
        }
        return new ModelTypeAFile(allStrFromFile);
    }

    public void writeFileByType(List<?> str, String filePuth,boolean addingFile) {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePuth,addingFile))) {
            for (Object item : str) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка записи файла: " + ex.getMessage());
        }
    }
}