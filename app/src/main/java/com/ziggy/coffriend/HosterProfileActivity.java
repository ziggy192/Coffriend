package com.ziggy.coffriend;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HosterProfileActivity extends AppCompatActivity {

    @BindView(R.id.btnEdit)
    FloatingActionButton btnEdit;
    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        btnEdit.setVisibility(FloatingActionButton.INVISIBLE);

        circleImageView.setImageResource(R.drawable.profile);
        tvUserName.setText("Eric Bachman");
    }

    public void clickBack(View view) {
        onBackPressed();

    }
}
