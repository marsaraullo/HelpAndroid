package com.uhack.help.Core.Control.Database;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Mars on 12/2/2017.
 */

public class DataInterpreter
{
    public synchronized static String getData(InputStream is)
    {
        String result = "";

        InputStreamReader inputreader = new InputStreamReader(is);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try
        {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return text.toString();

    }
}
