package com.uhack.help.Core.Control.Listener;

import java.util.ArrayList;

/**
 * Created by Mars on 12/2/2017.
 */

public interface DataListener
{
    public abstract void dataRetrievedFromLocal(ArrayList<Object> results);
    public abstract void dataInsertedToLocal(Class c,ArrayList<Object> results);
    public abstract void noDataFromLocal(Class c);
    public abstract void onClearLocalData(Class c);
    public abstract void onUpdate(Class c);
    public abstract void onUpdateLocalData(Object o);
}
