package LoginRegisterUtility;

import LoginRegisterEntity.Users;
import LoginRegisterService.Register;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginRegistrationUtility {
    public static boolean authenticateUser(Users users) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Register.FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userinfo = line.split(",");
                String username = userinfo[0];
                String password = userinfo[1];

                if (username.equals(users.getUsername()) && password.equals(users.getPassword())) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean isExist(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Register.FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");
                String uname = userInfo[0];
                if (uname.equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    public static void showUsers() {
        FileReader fileReader;
        try {
            fileReader = new FileReader(Register.FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String data = String.valueOf(scanner.nextLine());
            System.out.println(data.toUpperCase());
        }

    }
}
