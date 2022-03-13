package com.example.sitm.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("_Welcome \n Sagar Insitute of \n Technology and Management");
    }

    public LiveData<String> getText() {
        return mText;
    }
}