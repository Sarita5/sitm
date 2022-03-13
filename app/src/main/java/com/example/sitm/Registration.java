package com.example.sitm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Registration extends Fragment {
    EditText e1, e2, e3, e4, e5;
    Button btn;
    RadioGroup rgd;
    RadioButton rbtn;
    ConnectionManager cm;
    String name = "", email = "", mob = "", password = "", gen = "", cpass = "", pass = "";

    //Str
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cm = new ConnectionManager();
        e1 = (EditText) view.findViewById(R.id.rname);
        e2 = (EditText) view.findViewById(R.id.remobile);
        e3 = (EditText) view.findViewById(R.id.reemail);
        e4 = (EditText) view.findViewById(R.id.repassword);
        e5 = (EditText) view.findViewById(R.id.recpassword);
        btn = (Button) view.findViewById(R.id.btreg);
        rgd = (RadioGroup) view.findViewById(R.id.rg);
        rbtn = (RadioButton) view.findViewById(R.id.rmale);
        rgd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rmale: {
                        gen = "Male";
                        break;
                    }
                    case R.id.rfemale: {
                        gen = "female";
                        break;
                    }
                }
            }

        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        name = e1.getText().toString();
        mob = e2.getText().toString();
        email = e3.getText().toString();
        password = e4.getText().toString();
        cpass = e5.getText().toString();
        String command = "insert into e_reg values('" + name + "','" + mob + "','" + email + "','" + pass + "','" + cpass + "')";
        if (name.length() == 0) {
            e1.requestFocus();
            e1.setError("please enter your name");
        } else if (mob.length() == 0) {
            e2.requestFocus();
            e2.setError("please enter your mobile number");
        } else if (email.length() == 0) {
            e3.requestFocus();
            e3.setError("please enter your email");
        } else if (pass.length() == 0) {
            e4.requestFocus();
            e4.setError("please enter your password");
        } else {
            if (pass.equals(cpass)) {
                boolean x = cm.ExecuteNonQuery(command);
                if (x == true) {
                    Toast.makeText(getContext(), "Your Registration done", Toast.LENGTH_SHORT);
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                } else {
                    Toast.makeText(getContext(), "your registration are not completed", Toast.LENGTH_SHORT);
                }
            } else {
                Toast.makeText(getContext(), "please confirm your password", Toast.LENGTH_SHORT).show();
            }
        }
    }
});
        }
        }