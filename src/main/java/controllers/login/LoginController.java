package controllers.login;

public class LoginController {

    public boolean checkUsernameAndpassword(String name, String password) {
        if(name.equals("inham") && password.equals("1234")){
            return true;
        }
        return false;
    }
}
