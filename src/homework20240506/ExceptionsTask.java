package homework20240506;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ExceptionsTask {
    public static boolean passAuthentication (String login, String password, String confirmPassword) {
       try{
        if(!isLatinCharacters(login) || !(login.length() <= 20)){
          throw new WrongLoginException("Login should contain only latin letters and be less than 20 characters");
      }

        if(!isValidPassword(password, confirmPassword)){
            throw new WrongPasswordException("Password should contain only digits. Password length must be less than 20 characters");
        }
       return true;
    } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error:" + e.getMessage());
            return false;
       }
    }

    private static boolean isValidPassword(String password, String confirmPassword) {
        return password.matches("\\d+") && password.length() < 20 && password.equals(confirmPassword);
    }


        private static boolean isLatinCharacters(String str) {
            for (char c : str.toCharArray()) {
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) { // !login.matches ("[a-zA-Z]+"))
                    return false;
                }
            }
            return true;
    }

    public static void main(String[] args) {
        String login;
        String password;
        String confirmPassword;
        while (true) {
            System.out.println("Enter login and password, after confirm password: ");
            Scanner scanner = new Scanner(System.in);
            login = scanner.nextLine();
            password = scanner.nextLine();
            confirmPassword = scanner.nextLine();
            System.out.println(passAuthentication(login, password, confirmPassword));

        }
    }

}

