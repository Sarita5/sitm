package com.example.sitm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogIn extends Fragment {
    EditText ed1,ed2;
    Button btn;
    ConnectionManager cm;
    String userId="",password="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        ed1=(EditText) view.findViewById(R.id.lemail);
        ed2=(EditText) view.findViewById(R.id.lpassword);
        btn=(Button) view.findViewById(R.id.btnreview);
        cm=new ConnectionManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId=ed1.getText().toString();
                password=ed2.getText().toString();
                if(userId.length()==0)
                {
                    ed1.requestFocus();
                    ed1.setError("Please Enter userId");
                }
                else if(password.length()==0)
                {
                    ed2.requestFocus();
                    ed2.setError("please Enter Your password");
                }
                else
                {
                    String command="select * from loggin where email='"+userId+"' and epass='"+password+"'";
                    ResultSet rs=cm.selectData(command);
                    try {
                        if (rs.next()) {
                            Intent intent = new Intent(getActivity(), dashboard.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "invalid user id and password", Toast.LENGTH_SHORT).show();

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
