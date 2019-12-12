package com.example.practiceexampleforwipro.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practiceexampleforwipro.R;

public class Helper {
    static boolean commanEnable = true;
    static boolean verbose = commanEnable;
    static boolean info = commanEnable;
    static boolean debug = commanEnable;
    static boolean error = true;

    //Log methods
    public static void v(String tag, String msg){
        if(verbose){
            Log.v(tag,msg);
        }
    }
    public static void d(String tag, String msg){
        if(debug){
            Log.v(tag,msg);
        }
    }
    public static void i(String tag, String msg){
        if(info){
            Log.v(tag,msg);
        }
    }
    public static void e(String tag, String msg){
        if(error){
            Log.v(tag,msg);
        }
    }


    /**
     * Toast with app theme
     * .show() function call not required
     */
    public static void makeText(Context context, String msg, int duration)
    {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast_view,null);

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }


    public static boolean isConnected(Context context) {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = null;
            if (cm != null) {
                info = cm.getActiveNetworkInfo();
            }
            connected = info != null && info.isConnected();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                NetworkCapabilities nc = cm != null ? cm.getNetworkCapabilities(cm.getActiveNetwork()) : null;
                int downSpeed = nc.getLinkDownstreamBandwidthKbps();
                if (downSpeed == 0.0) {
                    connected = false;
                } else {
                    connected = info != null && info.isConnected();
                }
            }
            return connected;
        } catch (Exception e) {
        }
        return connected;
    }

}
