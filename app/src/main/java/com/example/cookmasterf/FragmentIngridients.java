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

        ListView ingridList = (ListView) v.findViewById(R.id.ingridList);
        IngridAdapter adapter = new IngridAdapter(mContext, R.layout.ingridient_item, ingrid);
        ingridList.setAdapter(adapter);

        ImageButton PlusBtn = (ImageButton) v.findViewById(R.id.addToFridge);
        PlusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FullRecipe fullRecFrag = new FullRecipe();
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.frgmCont, fullRecFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Inflate the layout for this fragment
        return v;

    }

}