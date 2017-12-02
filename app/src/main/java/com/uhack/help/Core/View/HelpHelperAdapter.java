package com.uhack.help.Core.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uhack.help.Core.Control.Listener.SelectListener;
import com.uhack.help.Core.Model.Helper;
import com.uhack.help.R;

import java.util.ArrayList;

/**
 * Created by Mars on 12/3/2017.
 */

public class HelpHelperAdapter extends RecyclerView.Adapter<HelpHelperViewHolder>
{

    ArrayList<Helper> helpers;
    SelectListener listener;

    public HelpHelperAdapter(ArrayList<Helper> helpers, SelectListener listener)
    {
        this.helpers=new ArrayList<>();
        this.helpers.addAll(helpers);
        this.listener=listener;
    }
    @Override
    public HelpHelperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.help_helper_item,parent,false);
        return new HelpHelperViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HelpHelperViewHolder holder, int position) {
       holder.getTv_fullname().setText(helpers.get(position).getFirstname()+" "+helpers.get(position).getLastname());
       holder.getTv_city().setText(helpers.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return helpers.size();
    }
}
