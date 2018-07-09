package com.ziggy.coffriend;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;


public class SettingsFragment extends Fragment {


    private RecyclerView rvSettings;
    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSettings = view.findViewById(R.id.rvSettings);
        rvSettings.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSettings.setAdapter(new SettingAdapter(getActivity()));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static class SettingVH extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private Switch switchSetting;
        public SettingVH(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            switchSetting = itemView.findViewById(R.id.switchSetting);
        }

        public void bind(SettingModel model) {
            tvTitle.setText(model.getTitle());
            if (model.isSwitchShown()) {
                switchSetting.setVisibility(View.VISIBLE);

            } else {
                switchSetting.setVisibility(View.INVISIBLE);
            }

            switchSetting.setChecked(model.isChecked());
        }



    }

    public static class SettingModel {


        private String title;
        private boolean switchShown;

        private boolean checked;

        public SettingModel(String title, boolean switchShown, boolean checked) {
            this.title = title;
            this.checked = checked;
            this.switchShown = switchShown;
        }


        public SettingModel(String title) {
            this(title, true,false);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public boolean isSwitchShown() {
            return switchShown;
        }

        public void setSwitchShown(boolean switchShown) {
            this.switchShown = switchShown;
        }

    }


    public static class SettingAdapter extends RecyclerView.Adapter<SettingVH> {

        static final SettingModel[] settingList = new SettingModel[]{
                new SettingModel("Allow receiving message", true, true),
                new SettingModel("Share my location", true, true),
                new SettingModel("Turn off notification", true, false),
                new SettingModel("Help & Support", false, false),
                new SettingModel("Logout", false, false)

        };

        Context mContext;

        public SettingAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public SettingVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_setting_list, viewGroup,false);
            return new SettingVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SettingVH settingVH, int i) {
            settingVH.bind(settingList[i]);
        }

        @Override
        public int getItemCount() {
            return settingList.length;
        }
    }


}
