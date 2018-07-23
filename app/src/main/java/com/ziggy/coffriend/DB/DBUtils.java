package com.ziggy.coffriend.DB;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Toast;

import com.ziggy.coffriend.holders.HostHolder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    public static void saveKey(Activity activity, String key, String value){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Temp", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static HostHolder loadHost(Activity activity){
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Temp", Context.MODE_PRIVATE);
        List<String> topics = new ArrayList(Arrays.asList(sharedPreferences.getString("interest", "").split(";")));
        String image = sharedPreferences.getString("image", "");
        byte[] imageAsBytes = Base64.decode(image.getBytes(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);

        String nameAddress = sharedPreferences.getString("name_address", "");
        String address = sharedPreferences.getString("address", "");
        Date date = null;
        try {
            date = (new SimpleDateFormat("dd-MM-yyyy")).parse(sharedPreferences.getString("date",""));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String start = sharedPreferences.getString("start", "");
        String end = sharedPreferences.getString("end", "");
        String title = sharedPreferences.getString("title", "");
        String content = sharedPreferences.getString("content", "");

        HostHolder hostHolder = new HostHolder(topics, bitmap, nameAddress, address, date, start, end, title, content);

        return hostHolder;
    }
}
