package Controller;

import _Services.CSV;

import java.io.IOException;

public class RegisterController {
    private LoginForm loginForm;
    private RegisterForm registerForm;


    public static boolean submitUserData(String username, String password, String firstName, String lastName) throws IOException {
        boolean checkUser = CSV.findUser(username);
        if(!checkUser){
            return(CSV.AddUser(username, password, firstName, lastName));
        }
        return false;
    }




    public boolean checkCredentials(String username) throws IOException {
        return CSV.findUser(username);
    }
    public boolean AddUser(String username, String password, String firstname, String lastname) throws IOException {
        return CSV.AddUser(username, password, firstname, lastname);
    }

}
