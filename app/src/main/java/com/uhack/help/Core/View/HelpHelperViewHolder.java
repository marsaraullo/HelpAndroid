package com.uhack.help.Core.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.uhack.help.R;

/**
 * Created by Mars on 12/3/2017.
 */

public class HelpHelperViewHolder extends RecyclerView.ViewHolder
{

    TextView  tv_fullname;
    TextView  tv_city;

    public HelpHelperViewHolder(View itemView) {
        super(itemView);
        tv_fullname=(TextView)itemView.findViewById(R.id.tv_fullname);
        tv_city=(TextView)itemView.findViewById(R.id.tv_city);
    }


    public TextView getTv_fullname() {
        return tv_fullname;
    }

    public void setTv_fullname(TextView tv_fullname) {
        this.tv_fullname = tv_fullname;
    }

    public TextView getTv_city() {
        return tv_city;
    }

    public void setTv_city(TextView tv_city) {
        this.tv_city = tv_city;
    }

}
