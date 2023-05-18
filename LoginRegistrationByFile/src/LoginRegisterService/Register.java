package LoginRegisterService;

import LoginRegisterEntity.Users;
import LoginRegisterUtility.LoginRegistrationUtility;

import java.io.*;

public class Register {
    public static final String FILE_PATH = "user.txt";
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void register() {
        outerloop:
        while (true) {

            try {
                System.out.println("Enter UserName: ");
                String username = bf.readLine();
                if (LoginRegistrationUtility.isExist(username)) {
                    System.out.println("User Already Exist");
                    break outerloop;
                }

                System.out.println("Enter Password:");
                String pass = bf.readLine();
                System.out.println("Confirm Password");
                String pass2 = bf.readLine();
                if (!pass.equals(pass2)) {
                    System.out.println("Password Do Not Match");
                    register();
                    break outerloop;
                }
                Users users = new Users();
                users.setUsername(username);
                users.setPassword(pass);

                FileWriter fileWriter = new FileWriter(FILE_PATH, true);

                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(users.getUsername() + "," + users.getPassword());
                printWriter.flush();
                printWriter.close();
                System.out.println("Registration Successful");
                break outerloop;


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

