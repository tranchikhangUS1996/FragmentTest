package com.tranchikhang.fragmenttest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Detail_Fragment extends Fragment {

    private int ID = 0;
    public Detail_Fragment() {
        this.ID = 0;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_, container, false);
    }

    public void setId(int id) {
        this.ID = id;
    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view!=null) {
            TextView title = (TextView) view.findViewById(R.id.name);
            TextView description = (TextView) view.findViewById(R.id.description);
            title.setText(Workout.workouts[ID].getName());
            description.setText(Workout.workouts[ID].getDescription());
        }
    }
    @Override
    public void onSaveInstanceState(Bundle saveInstantState){
        saveInstantState.putInt("ID",ID);
    }
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        if(saveInstanceState!=null) {
            this.ID = saveInstanceState.getInt("ID");
        }
        else {
            StopwatchFragment fragment = new StopwatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.add(R.id.conteiner_stopwatch,fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }

}
