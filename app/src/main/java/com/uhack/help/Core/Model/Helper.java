package com.uhack.help.Core.Model;


import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONObject;

public class Helper
{
    public static final String TAG              = "users";
    public static final String TAG_ID           = "id";
    public static final String TAG_FIRSTNAME    = "firstname";
    public static final String TAG_MIDDLENAME   = "middlename";
    public static final String TAG_LASTNAME     = "lastname";
    public static final String TAG_ADDRESS      = "address";
    public static final String TAG_CITY         = "city";
    public static final String TAG_EMAIL        = "email";
    public static final String TAG_CONTACT      = "contact";
    public static final String TAG_ROLE         = "role_id";

    int id;
    String firstname;
    String middlename;
    String lastname;
    String address;
    String city;
    String email;
    String contact;
    int role;


    public Helper(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            id = object.getInt(TAG_ID);
            firstname = object.getString(TAG_FIRSTNAME);
            middlename = object.getString(TAG_MIDDLENAME);
            lastname = object.getString(TAG_LASTNAME);
            address = object.getString(TAG_ADDRESS);
            city = object.getString(TAG_CITY);
            email = object.getString(TAG_EMAIL);
            contact = object.getString(TAG_CONTACT);
            role = object.getInt(TAG_ROLE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Helper(Cursor object)
    {
        try
        {
            id = object.getInt(object.getColumnIndex(TAG_ID));
            firstname = object.getString(object.getColumnIndex(TAG_FIRSTNAME));
            middlename = object.getString(object.getColumnIndex(TAG_MIDDLENAME));
            lastname = object.getString(object.getColumnIndex(TAG_LASTNAME));
            address = object.getString(object.getColumnIndex(TAG_ADDRESS));
            city = object.getString(object.getColumnIndex(TAG_CITY));
            email = object.getString(object.getColumnIndex(TAG_EMAIL));
            contact = object.getString(object.getColumnIndex(TAG_CONTACT));
            role = object.getInt(object.getColumnIndex(TAG_ROLE));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ContentValues getValues()
    {
        ContentValues val = new ContentValues();
        val.put(TAG_ID,id);
        val.put(TAG_FIRSTNAME,firstname);
        val.put(TAG_MIDDLENAME,middlename);
        val.put(TAG_LASTNAME,lastname);
        val.put(TAG_ADDRESS,address);
        val.put(TAG_CITY,city);
        val.put(TAG_EMAIL,email);
        val.put(TAG_CONTACT,contact);
        val.put(TAG_ROLE,role);
        return val;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
