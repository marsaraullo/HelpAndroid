package com.uhack.help.Core.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.uhack.help.R;

/**
 * Created by Mars on 12/3/2017.
 */

public class HelpJobViewHolder extends RecyclerView.ViewHolder
{
    TextView tv_tittle;
    TextView tv_description;
    TextView tv_date;
    TextView tv_cost;
    public HelpJobViewHolder(View itemView)
    {
        super(itemView);
        tv_tittle = (TextView) itemView.findViewById(R.id.tv_title);
        tv_description = (TextView) itemView.findViewById(R.id.tv_description);
        tv_date = (TextView) itemView.findViewById(R.id.tv_date);
        tv_cost = (TextView) itemView.findViewById(R.id.tv_cost);
    }

    public TextView getTv_tittle() {
        return tv_tittle;
    }

    public void setTv_tittle(TextView tv_tittle) {
        this.tv_tittle = tv_tittle;
    }

    public TextView getTv_description() {
        return tv_description;
    }

    public void setTv_description(TextView tv_description) {
        this.tv_description = tv_description;
    }

    public TextView getTv_date() {
        return tv_date;
    }

    public void setTv_date(TextView tv_date) {
        this.tv_date = tv_date;
    }

    public TextView getTv_cost() {
        return tv_cost;
    }

    public void setTv_cost(TextView tv_minimum) {
        this.tv_cost = tv_minimum;
    }
}
