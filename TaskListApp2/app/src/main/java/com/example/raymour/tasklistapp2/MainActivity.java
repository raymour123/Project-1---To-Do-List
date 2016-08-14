package com.example.raymour.tasklistapp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TaskListSingleton mTaskListSingleton;
    private TaskListAdapter mTaskListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_new_taskList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTaskListDialog();
            }
        });
        mTaskListSingleton = TaskListSingleton.getInstance();
        mTaskListAdapter = new TaskListAdapter(this,mTaskListSingleton.getTaskLists());

        ListView listView = (ListView) findViewById(R.id.listviewMain);
        TextView eTextView = (TextView) findViewById(R.id.itemTitleEditText);
        listView.setAdapter(mTaskListAdapter);
        listView.setEmptyView(eTextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });
    }

    public void showTaskListDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.task_list_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editText = (EditText) dialogView.findViewById(R.id.taskListTitleEditText);

        dialogBuilder.setTitle("List Title");
        dialogBuilder.setMessage("Enter title below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(editText.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please enter a list title", Toast.LENGTH_LONG).show();
                } else {
                    mTaskListSingleton.addTaskList(new TaskList(editText.getText().toString()));
                    mTaskListAdapter.notifyDataSetChanged();
                    Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
                    intent.putExtra("index", mTaskListSingleton.getTaskLists().size() - 1);
                    startActivity(intent);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
