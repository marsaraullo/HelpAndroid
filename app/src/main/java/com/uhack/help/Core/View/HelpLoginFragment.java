package com.uhack.help.Core.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.uhack.help.Core.Control.Preference.UserPreference;
import com.uhack.help.R;

public class HelpLoginFragment extends Fragment
{
    ImageView iv_logo;
    EditText et_username;
    EditText et_password;
    Button bt_login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.help_login,container,false);

        et_username = (EditText) v.findViewById(R.id.et_username);
        et_username.clearFocus();
        et_password = (EditText) v.findViewById(R.id.et_password);
        et_password.clearFocus();
        iv_logo = (ImageView) v.findViewById(R.id.iv_logo);
        iv_logo.setFocusable(true);
        iv_logo.requestFocus();
        bt_login =  (Button) v.findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                    Intent i = new Intent(getActivity(),HelpHomeActivity.class);
                    startActivity(i);
                    UserPreference.setUsername(et_username.getText().toString());
                    UserPreference.setPassword(et_password.getText().toString());
                    getActivity().finish();



            }
        });
        return v;
    }
}
