package ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import Model.LoginUser;

public class LoginViewModel extends ViewModel {

    //the variables must be observed and changable
    public MutableLiveData< String > username = new MutableLiveData<>();
    public MutableLiveData< String > password = new MutableLiveData<>();

    private MutableLiveData< LoginUser > userData; // the data must not be able to change when its given to the activity

    public MutableLiveData< LoginUser > getUser() {

        if (userData == null) {
            userData = new MutableLiveData<>();
        }
        return userData;
    }

    public void onClick()
    {
        LoginUser User = new LoginUser(username.getValue(), password.getValue());
        userData.setValue(User);
    }

}





