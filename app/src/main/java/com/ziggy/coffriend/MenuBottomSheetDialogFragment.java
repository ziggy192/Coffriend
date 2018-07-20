package com.ziggy.coffriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     MenuBottomSheetDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 * <p>You activity (or fragment) needs to implement {@link Listener}.</p>
 */
public class MenuBottomSheetDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private Listener mListener;
    private int selectedPosition = 0;
    private RecyclerView mRecyclerView;

    public static CustomMenuHolder[] menuItemHolders = new CustomMenuHolder[]{
            new CustomMenuHolder("Home", R.drawable.ic_coffee, R.id.nav_events,true)
            ,new CustomMenuHolder("Favorite",R.drawable.ic_heart_solid,R.id.nav_followings)
            ,new CustomMenuHolder("History",R.drawable.ic_history,R.id.nav_history)
            ,new CustomMenuHolder("Settings",R.drawable.ic_wrench,R.id.nav_settings)
    };

//    private NavigationView.OnNavigationItemSelectedListener mListener;
//    private NavigationView navigationView;

    // TODO: Customize parameters
    public static MenuBottomSheetDialogFragment newInstance(int itemCount) {
        final MenuBottomSheetDialogFragment fragment = new MenuBottomSheetDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        View viewUserProfile = view.findViewById(R.id.viewUserProfile);
        viewUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUserProfile(view);
                dismiss();
            }
        });

        mRecyclerView =  view.findViewById(R.id.listMenu);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new BottomSheetMenuItemAdapter());

        //        navigationView = view.findViewById(R.id.navigationView);
//        if (mListener != null) {

//            navigationView.setNavigationItemSelectedListener(mListener);
//        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final Fragment parent = getParentFragment();
        if (parent != null && parent instanceof Listener) {
            mListener = (Listener) parent;
        } else if (context instanceof Listener) {
            mListener = (Listener) context;
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }


    public void goToUserProfile(View view){
        Intent intent = new Intent(this.getActivity(),UserProfileActivity.class);
        startActivity(intent);
    }
    public interface Listener {
        void onBottomSheetMenuItemClicked(int position);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvItemTitle;
        final ImageView imvItemIcon;
        final View viewSelector;
         int position;
        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_bottomsheetmenuitem_list_dialog_item, parent, false));
            tvItemTitle = itemView.findViewById(R.id.tvIemTitle);
            imvItemIcon = itemView.findViewById(R.id.imItemIcon);
            viewSelector = itemView.findViewById(R.id.viewSelector);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    //for all existing list
                    for (int i = 0; i < menuItemHolders.length; i++) {
                        CustomMenuHolder menuHolder = menuItemHolders[i];
                        if (i == position) {
                            menuHolder.setSelected(true);

                        }else{
                            menuHolder.setSelected(false);
                        }
                    }
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                    if (mListener != null) {
                        mListener.onBottomSheetMenuItemClicked(position);
                        dismiss();
                    }
                }
            });

        }

        public void changePosition(int oldPosition, int newPosition) {

        }

        public void select() {
            viewSelector.setVisibility(View.VISIBLE);
        }

        public void unSelect() {
            viewSelector.setVisibility(View.INVISIBLE);
        }
        public void onBind(CustomMenuHolder itemMenuHolder) {
            if (itemMenuHolder.isSelected) {
               select();
            } else {
                unSelect();
            }
            tvItemTitle.setText(itemMenuHolder.getTitle());
            imvItemIcon.setImageResource(itemMenuHolder.getIconResource());

        }

    }

    private class BottomSheetMenuItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.onBind(menuItemHolders[position]);
        }

        @Override
        public int getItemCount() {
            return menuItemHolders.length;
        }

    }

    private static class CustomMenuHolder {


        private String title;
        private int iconResource;
        private int itemId;
        private boolean isSelected;


        public CustomMenuHolder(String title, int iconResource, int itemId, boolean isSelected) {
            this.title = title;
            this.iconResource = iconResource;
            this.itemId = itemId;
            this.isSelected = isSelected;
        }

        public CustomMenuHolder(String title, int iconResource, int itemId) {
            this(title, iconResource, itemId, false);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIconResource() {
            return iconResource;
        }

        public void setIconResource(int iconResource) {
            this.iconResource = iconResource;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }



}
