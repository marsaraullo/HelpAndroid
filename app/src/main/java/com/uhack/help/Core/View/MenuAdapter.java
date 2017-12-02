package com.uhack.help.Core.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uhack.help.Core.Control.Listener.MenuListener;
import com.uhack.help.Core.Model.MenuItem;
import com.uhack.help.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    ArrayList<MenuItem> menus = null;
    MenuListener listener;
    RecyclerView rv;
    public MenuAdapter(ArrayList<MenuItem> menus,RecyclerView rv, MenuListener listener)
    {
        this.menus = new ArrayList<>();
        this.menus.addAll(menus);
        this.listener = listener;
        this.rv = rv;
    }
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.menu_item,parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
        holder.getTv_name().setText(menus.get(position).getName()+"");
        holder.getTv_name().setClickable(true);
        holder.getTv_name().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.selected(menus.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
