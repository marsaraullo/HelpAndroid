package com.uhack.help.Core.View;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uhack.help.Core.Control.Listener.SelectListener;
import com.uhack.help.Core.Model.Job;
import com.uhack.help.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Mars on 12/3/2017.
 */

public class HelpJobAdapter extends RecyclerView.Adapter<HelpJobViewHolder>
{

    ArrayList<Job> jobs;
    SelectListener listener;
    public HelpJobAdapter(ArrayList<Job> jobs,SelectListener listener)
    {
        this.jobs = new ArrayList<>();
        this.jobs.addAll(jobs);
        this.listener = listener;
    }

    @Override
    public HelpJobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.help_job_item,parent,false);
        return new HelpJobViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HelpJobViewHolder holder, int position) {

        holder.getTv_tittle().setText(jobs.get(position).getTitle());
        holder.getTv_description().setText(jobs.get(position).getDescription());
        try
        {
            holder.getTv_date().setText(new SimpleDateFormat("MMM-dd-yyyy", Locale.US).format(jobs.get(position).getDatetime()));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("Php ###,###,##0.00");
        holder.getTv_cost().setText(df.format(jobs.get(position).getMin_cost())+" to\n"+df.format(jobs.get(position).getMax_cost()));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}
