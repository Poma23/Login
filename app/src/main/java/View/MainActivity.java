                            //link:
                            // https://medium.com/@umang.burman.micro/login-example-with-mvvm-databinding-with-livedata-81319048afb0
package View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import Model.LoginUser;
import ViewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Create the observer which updates the UI.
        viewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser userData)
            { // Called when the data is changed

                if(userData.isUsernameValid(userData.get_username()))
                {
                    Toast.makeText(getApplicationContext(),"The email is not valid",Toast.LENGTH_SHORT);
                }
                else if(userData.isPasswordLengthGreaterThan6())
                {
                    Toast.makeText(getApplicationContext(),"Thee password is not valid",Toast.LENGTH_SHORT);
                }

            }
        });

}
    public void onClickSubmit(View view) {
        viewModel.onClick();
    }
}
