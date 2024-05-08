package homework20240506;

import java.io.*;

public class FileTask {
    public static void main(String[] args) {
        File file = new File("homework240506/taskNo1.txt");

        try {
            System.out.println("Size in bytes is: " + file.length());
            double fileSizeKB = (double) file.length() / 1024;
            System.out.println("Size in KB is: " + fileSizeKB);
            double fileSizeMB = (double) file.length() / (1024 * 1024);
            System.out.println("Size in MB is: " + fileSizeMB);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int lineCount = 0;
            while ((bufferedReader.readLine()) != null) {
                lineCount++;
            }
            System.out.println("Number of lines in the file is: " + lineCount);

            bufferedReader.close();
        } catch (IOException exception) {
            System.out.println("Problem with file work: " + exception.getMessage());
        }

        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int charCount = 0;
            while ((bufferedReader2.read()) != -1) {
                charCount++;
            }
            System.out.println("Number of characters in the file is: " + charCount);

            bufferedReader2.close();
        } catch (IOException exception) {
            System.out.println("Problem with file work: " + exception.getMessage());
        }
    }
}



