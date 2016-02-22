package com.android.shiz.temperaturemonitor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by OldMan on 23.02.2016.
 */
public class SettingsDialog {
    static public void show(final Activity MainActivity){
        LayoutInflater inflater = LayoutInflater.from(MainActivity);
        View subView = inflater.inflate(R.layout.setting_dialog, null);
        final EditText ip = (EditText)subView.findViewById(R.id.dialogEditText);
        ip.setText(App.getIP());
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (end > start) {
                    String destTxt = dest.toString();
                    String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);
                    if (!resultingTxt.matches ("^\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3})?)?)?)?)?)?")) {
                        return "";
                    } else {
                        String[] splits = resultingTxt.split("\\.");
                        for (int i=0; i<splits.length; i++) {
                            if (Integer.valueOf(splits[i]) > 255) {
                                return "";
                            }
                        }
                    }
                }
                return null;
            }
        };
        ip.setFilters(filters);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity);
//        builder.setTitle("Внимание!");
        builder.setMessage(R.string.enter_ip);
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.getBaseContext());
                App.setIP(ip.getText().toString());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity, "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }
}
