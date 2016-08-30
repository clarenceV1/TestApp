package com.example.clarence.myapp.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.clarence.myapp.BR;

public class User extends BaseObservable {
    private String firstName;
    private String lastName;
    private String age;

    public User(String firstName, String lastName, String age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getAge() {
        return age;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

}
