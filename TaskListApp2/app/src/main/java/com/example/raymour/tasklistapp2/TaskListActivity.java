package com.example.raymour.tasklistapp2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TaskListActivity extends AppCompatActivity {
    private ItemListAdapter mItemListAdapter;
    private TaskListSingleton mTaskListSingleton;
    private int mListIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_new_listItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showItemListDialog();
            }
        });

        mTaskListSingleton = TaskListSingleton.getInstance();
        mListIndex = getIntent().getIntExtra("index", -1);

        toolbar.setTitle(mTaskListSingleton.getTaskLists().get(mListIndex).getTitle());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mItemListAdapter = new ItemListAdapter(this,mTaskListSingleton.getTaskLists().get(mListIndex).getTaskListitems());
        ListView listView = (ListView) findViewById(R.id.listviewItems);
        listView.setAdapter(mItemListAdapter);


    }
    public void showItemListDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.item_list_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText titleEditText = (EditText) dialogView.findViewById(R.id.itemTitleEditText);
        final EditText descriptionEditText = (EditText) dialogView.findViewById(R.id.itemDescriptionEditText);


        dialogBuilder.setTitle("To-Do Item");
        dialogBuilder.setMessage("Enter item title and description below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(titleEditText.getText().toString().length() == 0) {
                    Toast.makeText(TaskListActivity.this, "Please enter an item title", Toast.LENGTH_LONG).show();
                } else {
                    mTaskListSingleton.getTaskLists().get(mListIndex).getTaskListitems().add(new TaskListItem(titleEditText.getText().toString(),descriptionEditText.getText().toString()));
                    mItemListAdapter.notifyDataSetChanged();
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


}
