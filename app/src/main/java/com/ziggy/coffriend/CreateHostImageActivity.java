package com.ziggy.coffriend;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziggy.coffriend.DB.DBUtils;

import java.io.ByteArrayOutputStream;

public class CreateHostImageActivity extends AppCompatActivity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_host_image);
    }

    public void loadImage(View view) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==3 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                ((ImageView) this.findViewById(R.id.imageChoice)).setImageBitmap(bitmap);
                ((ImageView) this.findViewById(R.id.imageUpload)).setVisibility(View.GONE);
                ((TextView) this.findViewById(R.id.txtUpload)).setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void gotoPlace(View view) {
        if(bitmap != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos); //bm is the bitmap object
            byte[] b = baos.toByteArray();
            String encoded = Base64.encodeToString(b, Base64.DEFAULT);
            DBUtils.saveKey(this, "image", encoded);
        }

        Intent intent = new Intent(CreateHostImageActivity.this, CreateHostActivity.class);
        startActivity(intent);
    }
}
