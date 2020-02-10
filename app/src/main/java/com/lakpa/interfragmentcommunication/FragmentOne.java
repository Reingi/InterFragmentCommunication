package com.lakpa.interfragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    SendMessage SM;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnPassData = view.findViewById(R.id.btnPassData);
        final EditText inData = view.findViewById(R.id.inMessage);

        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println(inData.getText().toString());
                SM.sendData(inData.getText().toString().trim());
            }
        });
    }

    interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            SM = (SendMessage) getActivity();
        }catch(ClassCastException e){
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
