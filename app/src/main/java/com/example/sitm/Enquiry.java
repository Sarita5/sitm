package com.example.sitm;

import android.graphics.Color;
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

public class Enquiry extends Fragment {
    ConnectionManager cm;
    EditText ename,emob,email,emsg;
    Button bten;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enquiry, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

       cm= new ConnectionManager();
        ename=(EditText) getView().findViewById(R.id.tname);
        emob=(EditText) getView().findViewById(R.id.tmob);
        email=(EditText) getView().findViewById(R.id.temail);
        emsg=(EditText) getView().findViewById(R.id.tmessage);
        bten=(Button) getView().findViewById(R.id.buten);

        bten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), ""+cm.getConnection(), Toast.LENGTH_SHORT).show();

                if(ename.getText().toString().equals("")){
                    ename.setHintTextColor(Color.RED);
                    ename.requestFocus();
                    Toast.makeText(getContext(), "plz enter you name", Toast.LENGTH_SHORT).show();
                }
                else if(emob.getText().toString().equals("")){
                    emob.setHintTextColor(Color.RED);
                    emob.requestFocus();
                    Toast.makeText(getContext(), "plz enter you mob", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().equals("")){
                    email.setHintTextColor(Color.RED);
                    email.requestFocus();
                    Toast.makeText(getContext(), "plz enter you mail", Toast.LENGTH_SHORT).show();
                }
                else if(emsg.getText().toString().equals("")){
                    emsg.setHintTextColor(Color.RED);
                    emsg.requestFocus();
                    Toast.makeText(getContext(), "plz enter you review", Toast.LENGTH_SHORT).show();
                }
                else {
                    String command = "insert into e_enquiry values('" + ename.getText() + "','" + emob.getText() + "','" + email.getText() + "','" + emsg.getText() + "')";
                    if (cm.ExecuteNonQuery(command)) {
                        Toast.makeText(getContext(), "Thanks for Enquiry as soon as we contact you", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Your request is not complete", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}
