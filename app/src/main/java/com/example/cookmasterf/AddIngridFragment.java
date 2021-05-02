package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class AddIngridFragment extends Fragment {
    private Context mContext;
    ArrayList<Ingridients> ingrid;

    public AddIngridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_ingrid, null);
        ingrid = ((MainActivity) getActivity()).getIngridList();
        ListView ingridList = (ListView) v.findViewById(R.id.AllingridList);
        IngridAdapter adapter = new IngridAdapter(mContext, R.layout.ingridient_item, ingrid);
        ingridList.setAdapter(adapter);


        return v;
    }
}