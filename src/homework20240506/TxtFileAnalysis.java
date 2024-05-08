package homework20240506;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtFileAnalysis {
    public static void main(String[] args) {
        String s;
        while (true) {
            System.out.println("Enter full path ('quit' to exit): ");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();

            if (s.equals("quit")) break;
            File f = new File(s);
            if (!f.exists()) {
                System.out.println("\nNot found: " + s);
                continue;
            }

            if (!f.isDirectory()) {
                System.out.println("\nNot directory: " + s);
                continue;
            }

            List<String> filesPaths = list(s);
            System.out.println(filesPaths);
            filesPaths.forEach(path -> printFile(path));
        }
    }

    public static void printFile(String path) {
        File f = new File(path);
        System.out.println("file " + path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<String> list(String szDir) {
        List<String> files = new ArrayList<>();
        File f = new File(szDir);
        String[] sDirList = f.list();

        int i;
        for (i = 0; i < sDirList.length; i++) {
            File f1 = new File(szDir + File.separator + sDirList[i]);

            if (f1.isFile()) {
                if (f1.getName().endsWith(".txt")) {
                    files.add(szDir + File.separator + sDirList[i]);
                }
            } else {
                files.addAll(list(szDir + File.separator + sDirList[i]));
            }
        }
    return files;
    }
}
