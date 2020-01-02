package com.dindac.flexibelfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FirstFragment extends Fragment implements View.OnClickListener{


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStated) {
        super.onViewCreated(view, savedInstanceStated);

        Button btnSecond = view.findViewById(R.id.firstButton);
        btnSecond.setOnClickListener(this);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Fragment Pertama");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("first_fragment.xml");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.firstButton){
            SecondFragment secondFragment= new SecondFragment();
            FragmentManager fragmentManaget = getFragmentManager();
            if(fragmentManaget !=null){
                fragmentManaget
                        .beginTransaction()
                        .replace(R.id.frame_content, secondFragment,SecondFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}