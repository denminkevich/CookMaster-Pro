package com.example.cookmasterf;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class AddIngridFragment extends Fragment {
    private Context mContext;
    ArrayList<Ingridients> ingrid;
    ArrayList<Ingridients> AllIngrid;
    ArrayList<Ingridients> ShopIngrid;

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
        AllIngrid = ((MainActivity) getActivity()).getAllIngridList();
        ShopIngrid = ((MainActivity) getActivity()).getShopIngridList();
        ListView ingridList = (ListView) v.findViewById(R.id.AllingridList);
        IndridAddAdapter adapter = new IndridAddAdapter(mContext, R.layout.ingridient_item, ingrid, AllIngrid, ShopIngrid);
        ingridList.setAdapter(adapter);
        ImageButton BackBtn = (ImageButton) v.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        }));

        return v;
    }
}