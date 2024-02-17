package edu.qc.seclass.fim;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.qc.seclass.fim.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    FirebaseAuth auth;
    Button button;
    FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        button = view.findViewById(R.id.logout);

        if (user == null){
            Intent intent = new Intent(getContext(), Login.class);
            startActivity(intent);
            getActivity().finish();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
