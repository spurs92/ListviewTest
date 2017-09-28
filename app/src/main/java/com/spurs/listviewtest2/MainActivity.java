package com.spurs.listviewtest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;

    ArrayList<String> datas=new ArrayList<>();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");

        listView=(ListView)findViewById(R.id.listview);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        editText=(EditText)findViewById(R.id.edit);

        //리스트뷰에 롱클릭 리스너 추가하기
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //선택된 항목(item)제거
                datas.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void clickAdd(View v){
        //EditText에 써있는 글씨 얻어오기
        String s=editText.getText().toString();
        //얻어온 글씨를 대량의 데이터(datas)에 추가하기..
        datas.add(s);

        //아답터객체에게 데이터가 바뀌었다는 것을 통지(Notify)
        adapter.notifyDataSetChanged();

        //리스트뷰의 커서 위치 조정
        listView.setSelection(datas.size()-1);

        editText.setText("");

    }
}
