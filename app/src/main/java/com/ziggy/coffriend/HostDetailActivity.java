package com.ziggy.coffriend;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HostDetailActivity extends AppCompatActivity {

    private boolean state = false;
    private boolean goState = false;

    @BindView(R.id.rvComments)
    RecyclerView rvComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_detail);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ScrollView sv = findViewById(R.id.svMain);
        ArrayList<CommentModel> commentModels = new ArrayList<>();
        commentModels.add(new CommentModel(R.drawable.user, "phong nguyen", "22/2/2018", 4, "Mình mong một event như này lâu lắm rồi. Làm tốt lắm !"));
        commentModels.add(new CommentModel(R.drawable.user, "phong nguyen", "22/2/2018", 4, "Mình mong một event như này lâu lắm rồi. Làm tốt lắm !"));
        commentModels.add(new CommentModel(R.drawable.user, "phong nguyen", "22/2/2018", 4, "Mình mong một event như này lâu lắm rồi. Làm tốt lắm !"));
        commentModels.add(new CommentModel(R.drawable.user, "phong nguyen", "22/2/2018", 4, "Mình mong một event như này lâu lắm rồi. Làm tốt lắm !"));

        rvComments.setAdapter(new CommentAdatper(commentModels));
        rvComments.setLayoutManager(new LinearLayoutManager(this));
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            sv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//                    View last = sv.getChildAt(sv.getChildCount() - 1);
//                    int diff = (last.getBottom() - (sv.getHeight() + sv.getScrollY())) -  last.getPaddingBottom();
//
//                    if (diff <= 0) {
//                        findViewById(R.id.arrowDown).setVisibility(View.INVISIBLE);
//                    } else {
//                        findViewById(R.id.arrowDown).setVisibility(View.VISIBLE);
//                    }
//                }
//            });
//        }
    }

    public void clickBack(View view) {
        onBackPressed();
    }

    public void goToChat(View view) {
        Intent intent = new Intent(HostDetailActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.host_detail_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.btnShare:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra("Temp","Temp");
                startActivity(Intent.createChooser(shareIntent, "Share to"));
                break;
            case R.id.btnFavorite:
                if(!state){
                    item.setIcon(R.drawable.ic_menu_favorite);
                } else {
                    item.setIcon(R.drawable.ic_menu_unfavorite);
                }
                state = !state;
                break;
            case R.id.btnReport:
                Intent intent = new Intent(HostDetailActivity.this, ReportActivity.class);
                startActivity(intent);
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickGoing(View view) {
        Button btnGo = ((Button) findViewById(R.id.btnGo));
        if(!goState){
            btnGo.setText("Cancel");
            btnGo.setBackgroundResource(R.drawable.button_cancle_going_background);
        } else {
            btnGo.setText("going");
            btnGo.setBackgroundResource(R.drawable.button_going_background);
        }

        goState = !goState;
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(HostDetailActivity.this, HosterProfileActivity.class);
        startActivity(intent);
    }

    public static class CommentModel {
        private int imageResource;
        private String username;
        private String date;
        private int start;
        private String content;

        public CommentModel(int imageResource, String username, String date, int start, String content) {
            this.imageResource = imageResource;
            this.username = username;
            this.date = date;
            this.start = start;
            this.content = content;
        }

        public int getImageResource() {
            return imageResource;
        }

        public void setImageResource(int imageResource) {
            this.imageResource = imageResource;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
    public static class CommentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUsername)
        TextView tvUsername;
        @BindView(R.id.rbRating)
        RatingBar rbRating;
        @BindView(R.id.tvComment)
        TextView tvComment;
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.imvIconPeople)
        ImageView imvPeople;


        public CommentViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(CommentModel model) {
            Picasso.get().load(model.getImageResource())
                    .into(imvPeople);
            tvUsername.setText(model.getUsername());
            tvDate.setText(model.getDate());
            tvComment.setText(model.getContent());
            rbRating.setRating(model.getStart());
        }
    }

    public static class CommentAdatper extends RecyclerView.Adapter<CommentViewHolder> {
        List<CommentModel> commentModelList;

        public CommentAdatper(List<CommentModel> commentModelList) {
            this.commentModelList = commentModelList;
        }

        @NonNull
        @Override
        public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.item_comment, viewGroup, false
            );
            return new CommentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CommentViewHolder commentViewHolder, int i) {
            commentViewHolder.bind(commentModelList.get(i));
        }

        @Override
        public int getItemCount() {
            return commentModelList.size();
        }
    }

}
