package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentIngridients extends Fragment {
    private Context mContext;
    ArrayList<Ingridients> ingrid;
    ArrayList<Ingridients> AllIngrid;

    public FragmentIngridients() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ingridients, null);

        ingrid = ((MainActivity) getActivity()).getIngridList();
        AllIngrid = ((MainActivity) getActivity()).getAllIngridList();

        ListView ingridList = (ListView) v.findViewById(R.id.ingridList);
        IngridAdapter adapter = new IngridAdapter(mContext, R.layout.ingridient_item, ingrid, AllIngrid);
        ingridList.setAdapter(adapter);

        ImageButton PlusBtn = (ImageButton) v.findViewById(R.id.addToFridge);
        PlusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddIngridFragment addIngridFrag = new AddIngridFragment();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.frgmCont, addIngridFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Inflate the layout for this fragment
        return v;

    }

}