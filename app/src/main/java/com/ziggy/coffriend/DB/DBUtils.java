package com.ziggy.coffriend.DB;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class DBUtils {

    public static void saveUsername(Activity activity, String username){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Temp", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

    public static String loadUsername(Activity activity){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Temp", Context.MODE_PRIVATE);
        return sharedPreferences.getString("username","");
    }
}
