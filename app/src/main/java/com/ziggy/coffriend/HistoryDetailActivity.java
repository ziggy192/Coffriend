package com.ziggy.coffriend;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean state;

    @BindView(R.id.btnGo)
    Button btnGo;
    @BindView(R.id.arrowDown)
    ImageView arrowDown;
    @BindView(R.id.rvComments)
    RecyclerView rvComments;
    @BindView(R.id.tvComment)
    TextView tvComment;
    @BindView(R.id.view_dummy)
    View viewDummy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        ButterKnife.bind(this);
        mRecyclerView = findViewById(R.id.rvUserList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boolean isGoingButtonVisible = getIntent().getBooleanExtra("isGoingButtonVisible", true);
        if (isGoingButtonVisible) {
            btnGo.setVisibility(View.VISIBLE);
            arrowDown.setVisibility(View.VISIBLE);
        } else {
            btnGo.setVisibility(View.GONE);
            arrowDown.setVisibility(View.GONE);
        }
        //show no comment in history details
        tvComment.setVisibility(View.GONE);
        rvComments.setVisibility(View.GONE);
        viewDummy.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickFollow(View view) {
//        if (state) {
//            ((Button) this.findViewById(R.id.btnFollow)).setText("Follow");
//        } else {
//            ((Button) this.findViewById(R.id.btnFollow)).setText("Followed");
//        }
    }

    public void clickBack(View view) {
        finish();
    }

    public void goToChat(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);

        }
    }

    static class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

        static final int ITEM_COUNT = 6;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder


        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter() {
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_history_detail_user_chat, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }


        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
//            holder.mTextView.setText("Eric Bachman");

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return ITEM_COUNT;
        }
    }
}
