package example.com.recyclerviewlab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by raymour on 7/6/16.
 */
public class CustomViewHolder2 extends RecyclerView.ViewHolder {

    TextView mTextView3;
    RelativeLayout mRelativeLayout2;


    public CustomViewHolder2(View itemView) {
        super(itemView);

        mTextView3 = (TextView) itemView.findViewById(R.id.taskItemTitleTV);
        mRelativeLayout2 = (RelativeLayout) itemView.findViewById(R.id.ItemLayout);


    }
}
