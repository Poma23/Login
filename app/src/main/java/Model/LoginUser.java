package Model;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

public class LoginUser          // a class for the model(LoginUser)
{
    private String username;    //an email
    private String password;

    public LoginUser(String username, String password) {
        username = username;
        password = password;
    }

    public String get_username() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUsernameValid(String username)
    {
        return !(username ==null || TextUtils.isEmpty(username))
                && android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches();
    }


    public boolean isPasswordLengthGreaterThan6()
    { // returns true if the lenght is greater than 6
        if (getPassword().length() < 6)
        {
            return false;
        }
        return true;
    }
}
