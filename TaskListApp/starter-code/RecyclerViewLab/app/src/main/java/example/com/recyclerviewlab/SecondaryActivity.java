package example.com.recyclerviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SecondaryActivity extends AppCompatActivity {

    RecyclerView mRecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        mRecyclerView2= (RecyclerView) findViewById(R.id.recycler_view2);

        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView2.setLayoutManager(mLayoutManager2);

        ArrayList<CustomObject1> list = Singleton.getInstance().mArrayList;
        Intent intent = getIntent();
        int position = intent.getIntExtra("Some Name", -1);
        // sdlkghalg
        //default value -1 because it is an invalid index... would fail
        CustomObject1 obj = list.get(position);

        ArrayList<CustomObject2> customObjects2 = obj.items;
        customObjects2.add(new CustomObject2("Title 1","FF0000"));
        customObjects2.add(new CustomObject2("Title 2","F0F000"));
        customObjects2.add(new CustomObject2("Title 3","F00FF0"));
        customObjects2.add(new CustomObject2("Title 4","FF00F0"));
        customObjects2.add(new CustomObject2("Title 5","FF000F"));
        customObjects2.add(new CustomObject2("Title 6","FF0F0F"));
        customObjects2.add(new CustomObject2("Title 7","FF0000"));


        CustomRecyclerViewAdapter2 adapter2 = new CustomRecyclerViewAdapter2(customObjects2);

        mRecyclerView2.setAdapter(adapter2);


    }
}
