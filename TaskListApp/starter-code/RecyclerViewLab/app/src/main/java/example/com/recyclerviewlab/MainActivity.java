package example.com.recyclerviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Button mTaskInButton;
    EditText mTaskInputET;
    Singleton mSingleton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLinearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mSingleton = Singleton.getInstance();

        ArrayList<CustomObject1> customObjects1 = Singleton.getInstance().mArrayList;
         customObjects1.add(new CustomObject1("Android Course", "#FF0000"));
         customObjects1.add(new CustomObject1("Grocery List", "#FFF00F"));
         customObjects1.add(new CustomObject1("Labs to Finish", "#0d98ba"));
         customObjects1.add(new CustomObject1("Title 4", "#8a2be2"));
         customObjects1.add(new CustomObject1("Title 5", "#F0F000"));
         customObjects1.add(new CustomObject1("Title 6", "#FFF000"));
         customObjects1.add(new CustomObject1("Title 7", "#FF00F0"));


        CustomRecyclerViewAdapter1 adapter1 = new CustomRecyclerViewAdapter1(customObjects1);

        mRecyclerView.setAdapter(adapter1);

        mTaskInButton = (Button) findViewById(R.id.addListButton);
        mTaskInputET = (EditText) findViewById(R.id.TitleInputET);

        mTaskInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new CustomObject1(mTaskInputET.getText().toString(), "FF0000");
                ArrayList a = mSingleton.mArrayList;
                CustomObject1 object = new CustomObject1(mTaskInputET.getText().toString(),"FF0000");
                a.add(object);

            }
        });

    }
}