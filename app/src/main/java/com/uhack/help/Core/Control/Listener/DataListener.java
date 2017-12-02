package com.uhack.help.Core.Control.Listener;

import java.util.ArrayList;

/**
 * Created by Mars on 12/2/2017.
 */

public interface DataListener
{
    public abstract void dataRetrievedFromLocal(ArrayList<Object> results);
    public abstract void noDataFromLocal(Class c);
}
