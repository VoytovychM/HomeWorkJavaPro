package homework20240510;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MainBook {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Path path = Paths.get("Books.dat");

        Book book1 = new Book("1984", "George Orwell", 10.2,2);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 15.7, 3);
        Book book3 = new Book ("The Little Prince", "Antoine de Saint-Exupery", 9.6, 1);

        List<Book> bookList = List.of(book1, book2, book3);
        saveBooks(bookList, path);
        List<Book> readBooks = readBooks (path);
        System.out.println(Arrays.toString(readBooks.toArray()));
    }



    public static void saveBooks(List<Book> book, Path path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {
            oos.writeObject(book);
        }
    }
    public static List<Book> readBooks(Path path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            List<Book> read = (List<Book>) ois.readObject();
            System.out.printf("Read book: %s", read);
            return read;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
