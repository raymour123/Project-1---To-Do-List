package example.com.recyclerviewlab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by raymour on 7/6/16.
 */
public class CustomViewHolder1 extends RecyclerView.ViewHolder{

    TextView mTextView1;
    View mView;
    RelativeLayout mRelativeLayout1;


    public CustomViewHolder1(View itemView) {
        super(itemView);

        mTextView1 = (TextView) itemView.findViewById(R.id.taskListTitleTV);
        mView = itemView.findViewById(R.id.colorSquareTask);
        mRelativeLayout1 = (RelativeLayout) itemView.findViewById(R.id.TaskLayout);

    }
}
