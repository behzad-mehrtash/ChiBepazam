package com.example.chibepazam;

import java.util.ArrayList;

import com.example.chibepazam.models.Food;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SecondPage extends Fragment {
	View v;
	ArrayList<Food> foods;
	ArrayAdaptor aa;
	
	public SecondPage(ArrayList<Food> foods) {
		this.foods=foods;
//		aa= new ArrayAdaptor(getActivity().getApplicationContext(),foods);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
		setUpInnerViewElements();
		
		return v;
	}
	
	private void setUpInnerViewElements(){
		ListView lv = (ListView)v.findViewById(R.id.lv_second_page);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
			          int position, long id) {
						
				FragmentManager fm = getFragmentManager();
				fm.beginTransaction().add(R.id.lv_second_page,
						new ThirdPage(foods.get(position)));
										
			}
			
		
		});
//		aa.notifyDataSetChanged()??male che karie?
	
	}
}
