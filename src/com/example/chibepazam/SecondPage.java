package com.example.chibepazam;

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
	ArrayAdaptor aa;
	ThirdPage tp;
	
	
	public SecondPage() { //why is it needed??
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
		setUpInnerViewElements();
		
		return v;
	}
	
	private void setUpInnerViewElements(){
		final Bundle bundle = new Bundle();
		final int[] foods = getArguments().getIntArray("selected_foods");
		
		ListView lv = (ListView)v.findViewById(R.id.lv_second_page);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
			          int position, long id) {
		        
				bundle.putInt("selected_food", foods[position]);		
				ThirdPage tp=new ThirdPage();
				tp.setArguments(bundle);
				
				FragmentManager fm = getFragmentManager();
				fm.beginTransaction().add(R.id.lv_second_page,tp).commit();
										
			}
			
		
		});
//		aa.notifyDataSetChanged()??male che karie?
	
	}
}
