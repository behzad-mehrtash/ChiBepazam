package com.example.chibepazam;

import java.util.ArrayList;

import com.example.chibepazam.models.Food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SecondPage extends Fragment {
	View v;
	ArrayList<String> ingredients;
	ArrayAdaptor aa;
	String searchableIngredients;
	
	/*public SecondPage(ArrayList<String> ingredients) {
		this.ingredients=ingredients;
//		aa= new ArrayAdaptor(getActivity().getApplicationContext(),foods);
	}*/


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = this.getArguments();
		if (bundle != null) {
		     searchableIngredients = bundle.getString("ingredients");
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
		Toast.makeText(getActivity(), searchableIngredients, Toast.LENGTH_SHORT).show();
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
				fm.beginTransaction().replace(R.id.lv_second_page, (Fragment)tp).commit();
										
			}
			
		
		});
		
	
	}
}
