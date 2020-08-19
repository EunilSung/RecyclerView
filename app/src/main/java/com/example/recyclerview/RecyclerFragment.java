package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;


public class RecyclerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;

    ArrayList<HashMap<String, Object>> item;
    ArrayList<String> arrayList_hash_tag;

    public RecyclerFragment() {
    }

    public static RecyclerFragment newInstance(String param1) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //검색어 값 전달
            mParam1 = getArguments().getString(ARG_PARAM1);
            Toast.makeText(getContext(), mParam1, Toast.LENGTH_SHORT).show();


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_result, container, false);
        arrayList_hash_tag = new ArrayList<String>();
        TextView text = rootView.findViewById(R.id.text_result_text);
        text.setText("'"+mParam1+"' 검색결과");
        item = new ArrayList<HashMap<String, Object>>();


                    RecyclerViewAdapter resultAdapter = new RecyclerViewAdapter(item);
                    final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_search_results);
                    GridLayoutManager layoutManager = new GridLayoutManager(rootView.getContext(), 2);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                    RecyclerDecoration spaceDecoration = new RecyclerDecoration(25);
                    recyclerView.addItemDecoration(spaceDecoration);
                    recyclerView.setAdapter(resultAdapter);

                    resultAdapter.notifyDataSetChanged();


        return rootView;
    }

    private HashMap<String, Object> putItem(String img, String name, String price, String store) {
        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("img", img);
        item.put("name", name);
        item.put("price", price);
        item.put("store", store);
        return item;
    }
}

