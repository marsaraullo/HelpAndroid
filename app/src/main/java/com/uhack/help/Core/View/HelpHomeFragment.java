package com.uhack.help.Core.View;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.uhack.help.Core.Control.Database.GetSQLiteData;
import com.uhack.help.Core.Control.Getter.GetSampleDataTask;
import com.uhack.help.Core.Control.Listener.DataListener;
import com.uhack.help.Core.Control.Listener.SelectListener;
import com.uhack.help.Core.Model.Job;
import com.uhack.help.R;

import java.util.ArrayList;

public class HelpHomeFragment extends Fragment implements DataListener, SelectListener
{
    RecyclerView rv_jobs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.help_home_fragment,container,false);
        rv_jobs = (RecyclerView) v.findViewById(R.id.rv_jobs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_jobs.setLayoutManager(layoutManager);
        new GetSQLiteData(Job.class,this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,null);
        return v;
    }

    @Override
    public void dataRetrievedFromLocal(ArrayList<Object> results)
    {
        ArrayList<Job> jobs = new ArrayList<>();
        for(Object o:results)
        {
            jobs.add((Job)o);
        }

        rv_jobs.setAdapter(new HelpJobAdapter(jobs,this));
    }

    @Override
    public void dataInsertedToLocal(Class c, ArrayList<Object> results) {

    }

    @Override
    public void noDataFromLocal(Class c) {

    }

    @Override
    public void onClearLocalData(Class c) {

    }

    @Override
    public void onUpdate(Class c) {

    }

    @Override
    public void onUpdateLocalData(Object o) {

    }

    @Override
    public void onSelected(Object o) {

    }
}
