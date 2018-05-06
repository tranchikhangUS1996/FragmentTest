package com.tranchikhang.fragmenttest;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.ListFragment {

    static interface Listener{
        void itemClicked(long id);
    }
    private Listener listener;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }@Override
    public void onListItemClick(ListView listView,View view,int position,long id) {
        if(listener!=null) {
            listener.itemClicked(id);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] names = new String[Workout.workouts.length];
        for(int i=0;i<Workout.workouts.length;i++) {
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,names);
        setListAdapter(arrayAdapter);
        // call super constructor to get default layout
        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
