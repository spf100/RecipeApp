package Controller;
import View.LoginForm;
import View.RegisterForm;
import _Services.CSV;
import Model.User;
import java.io.IOException;

public class LoginController {
    private LoginForm loginForm;
    private RegisterForm registerForm;


        public static boolean submitUserData(String username, String password) throws IOException {
            boolean checkUser = CSV.findUser(username);
            if(checkUser){
                checkUser = CSV.CheckPassword(username, password);
                return checkUser;
            }
            return false;
        }

}
