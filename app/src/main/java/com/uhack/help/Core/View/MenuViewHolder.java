package com.uhack.help.Core.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.uhack.help.R;

/**
 * Created by Mars on 12/2/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder
{

    TextView tv_name;

    public MenuViewHolder(View itemView) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);

    }

    public TextView getTv_name() {
        return tv_name;
    }
}
