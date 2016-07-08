package example.com.recyclerviewlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLinearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        ArrayList<CustomObject1> customObjects1 = Singleton.getInstance().mArrayList;
        customObjects1.add(new CustomObject1("title 1", "#FF0000"));
        customObjects1.add(new CustomObject1("Title 2", "#F0F00F"));
        customObjects1.add(new CustomObject1("Title 1", "#F0F0FF"));
        customObjects1.add(new CustomObject1("Title 1", "#F0FF00"));
        customObjects1.add(new CustomObject1("Title 1", "#F0F000"));
        customObjects1.add(new CustomObject1("Title 1", "#FFF000"));
        customObjects1.add(new CustomObject1("Title 1", "#FF00F0"));


        CustomRecyclerViewAdapter1 adapter1 = new CustomRecyclerViewAdapter1(customObjects1);

        mRecyclerView.setAdapter(adapter1);

    }
}
