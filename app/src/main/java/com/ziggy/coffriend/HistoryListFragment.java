package com.ziggy.coffriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.ziggy.coffriend.adapters.SmallEventsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class HistoryListFragment extends Fragment {

    private static final String TAG = HistoryListFragment.class.toString();

//    FloatingSearchView searchView;
    RecyclerView recyclerView;
    RecyclerView recyclerViewGoing;
    String[] allPossibleSearchResult = new String[]{
            "Eric Bachman",
            "Eric Bachman",
            "Eric Bachman",
            "Eric Bachman",
            "Eric Bachman",
            "Eric Bachman",
            "Eric Bachman"
    };
    private String DUMMY_HOST_HISTORY_SEARCH_QUERY = "Eric Bachman";
    public HistoryListFragment() {
        // Required empty public constructor
    }

    public static HistoryListFragment newInstance() {
        HistoryListFragment fragment = new HistoryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get arguments
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_history_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvHistoryList);
        SmallEventsAdapter adapterHostedList;
        adapterHostedList = new SmallEventsAdapter();
        recyclerView.setAdapter(adapterHostedList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));


        SmallEventsAdapter adapterGoingList;
        adapterGoingList = new SmallEventsAdapter();
        recyclerViewGoing = view.findViewById(R.id.rvGoingList);
        recyclerViewGoing.setAdapter(adapterGoingList);
        recyclerViewGoing.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));

//
//        searchView = view.findViewById(R.id.floating_search_view);
//        searchView.setOnBindSuggestionCallback(new SearchSuggestionsAdapter.OnBindSuggestionCallback() {
//            @Override
//            public void onBindSuggestion(View suggestionView, ImageView leftIcon, TextView textView, SearchSuggestion item, int itemPosition) {
//                leftIcon.setImageResource(R.drawable.ic_clock);
//                leftIcon.invalidate();
//            }
//        });
//
//        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
//            @Override
//            public void onSearchTextChanged(String oldQuery, String newQuery) {
//                //get suggestions based on newQuery
//                List<SearchSuggestion> suggestionList = new ArrayList<>();
//
//                for (int i = 0; i < allPossibleSearchResult.length; i++) {
//                    if (allPossibleSearchResult[i].toLowerCase().contains(newQuery.toLowerCase())) {
//
//                        SearchSuggestion suggestion = new MySearchSuggestion(allPossibleSearchResult[i]);
//                        suggestionList.add(suggestion);
//                    }
//                }
//                //pass them on to the search view
//                searchView.swapSuggestions(suggestionList);
//            }
//        });
//
//        searchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
//            @Override
//            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
//                String query = searchSuggestion.getBody();
//                searchView.setSearchText(query);
//                onSearchAction(query);
//            }
//
//            @Override
//            public void onSearchAction(String currentQuery) {
////                if (DUMMY_HOST_HISTORY_SEARCH_QUERY.toLowerCase().contains(currentQuery.toLowerCase())) {
////                    adapter.setListLength(SmallEventsAdapter.MAX_LIST_LENGTH);
////                    Log.d(TAG, String.format("onSearchAction: Has  %d Results", SmallEventsAdapter.MAX_LIST_LENGTH));
////                } else {
////                    adapter.setListLength(0);
////                    Log.d(TAG, "onSearchAction: Has  0 Results");
////
////                }
//                searchView.clearFocus();
//                Toast.makeText(getActivity(), String.format("search \"%s\"'", currentQuery), Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onSmallEventClicked(SmallEventsAdapter.SmallEventClickedEvent event) {
        Intent intent = new Intent(getActivity(), HistoryDetailActivity.class);
        intent.putExtra("isGoingButtonVisible", false);
        startActivity(intent);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */





    private class CustomMenuHolder {


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


    public static class MySearchSuggestion implements SearchSuggestion {
        String body;

        public MySearchSuggestion(String body) {
            this.body = body;
        }

        private MySearchSuggestion(Parcel in) {
            this.body = in.readString();
        }
        @Override
        public String getBody() {
            return body;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {

        }

        public static final Parcelable.Creator<MySearchSuggestion> CREATOR
                = new Parcelable.Creator<MySearchSuggestion>() {

            // This simply calls our new constructor (typically private) and
            // passes along the unmarshalled `Parcel`, and then returns the new object!
            @Override
            public MySearchSuggestion createFromParcel(Parcel in) {
                return new MySearchSuggestion(in);
            }

            // We just need to copy this and change the type to match our class.
            @Override
            public MySearchSuggestion[] newArray(int size) {
                return new MySearchSuggestion[size];
            }
        };

    }
}
