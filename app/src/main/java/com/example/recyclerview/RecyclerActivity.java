package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerActivity extends AppCompatActivity {
    ArrayList<HashMap<String, Object>> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_result);
        TextView text = findViewById(R.id.text_result_text);
        text.setText("검색결과");
        item = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < 10; i++) {
            item.add(putItem(R.drawable.gntver, "count" + i, "100" + i, "store"));
        }

        RecyclerViewAdapter resultAdapter = new RecyclerViewAdapter(item);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_search_results);
        //spanCount를 조정하여 한 줄에 몇개의 아이템이 들어갈지를 정한다.
        GridLayoutManager layoutManager = new GridLayoutManager(RecyclerActivity.this, 1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        //Decotation 클래스를 이용해 간격을 조절한다.
        RecyclerDecoration spaceDecoration = new RecyclerDecoration(25);
        recyclerView.addItemDecoration(spaceDecoration);
        recyclerView.setAdapter(resultAdapter);
        resultAdapter.notifyDataSetChanged();

        //뷰페이저 처럼 화면전환 가능
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
//값을 전달받을 일반 클릭 이벤트
        resultAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

            }
        });
//값을 전달받을 롱 클릭 이벤트
        resultAdapter.setOnItemLongClickListener(new RecyclerViewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, int pos) {

            }
        });
    }

    private HashMap<String, Object> putItem(int img, String name, String price, String store) {
        HashMap<String, Object> item = new HashMap<String, Object>();
        item.put("img", img);
        item.put("name", name);
        item.put("price", price);
        item.put("store", store);
        return item;
    }
}