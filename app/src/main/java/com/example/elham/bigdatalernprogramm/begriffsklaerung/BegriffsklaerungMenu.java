package com.example.elham.bigdatalernprogramm.begriffsklaerung;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.elham.bigdatalernprogramm.R;

public class BegriffsklaerungMenu extends ListFragment implements AdapterView.OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Begriffsklaerung_Menu, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //replace fragment
        Class fragmentClass;
        Fragment fragment;
        switch(position){
            //V-Modell
            case 0:
                fragmentClass = VModell.class;
                break;
            //Begriffsabgrenzung
            case 1:
                fragmentClass = Begriffsabgrenzung.class;
                break;
            //Test
            case 2:
                fragmentClass = TesteWissen.class;
                break;
            default:
                fragmentClass = BegriffsklaerungMenu.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment).addToBackStack(null).commit();
            // Set action bar title
            String[] titleArray = getResources().getStringArray(R.array.Begriffsklaerung_Menu);
            getActivity().setTitle(titleArray[position]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
