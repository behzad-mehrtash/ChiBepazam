package com.example.chibepazam;

import java.util.ArrayList;
import java.util.List;

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
	List<Food> selected_foods;
	List<Food> all_foods;
	
//	String searchableIngredients;
//	String[] ingred_array;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Bundle bundle = this.getArguments();
//		if (bundle != null) {
//			searchableIngredients = bundle.getString("ingredients");
//			ingred_array = searchableIngredients.split(",");
//			for (int i = 0; i < ingred_array.length; i++) {
//				ingred_array[i] = ingred_array[i].trim();
//			}
//		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
//		Toast.makeText(getActivity(), searchableIngredients, Toast.LENGTH_SHORT)
//				.show();
		setUpInnerViewElements();

		return v;
	}

	private void setUpInnerViewElements() {
		
		MainActivity ma = (MainActivity)getActivity();///??????????????
		all_foods = ma.fDB.getAllFoods();
		//indexes of foods, which was found, in DB
		final int[] indexes = getArguments().getIntArray("selected_foods");
		
		for (int i=0;i<indexes.length;i++)
			selected_foods.add(all_foods.get(indexes[i]));
		//a list of selected foods
		aa=new ArrayAdaptor(getActivity().getApplicationContext(),selected_foods);
		
		final Bundle bundle = new Bundle();

		ListView lv = (ListView) v.findViewById(R.id.lv_second_page);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {

				bundle.putInt("selected_food", indexes[position]);
				ThirdPage tp = new ThirdPage();
				tp.setArguments(bundle);

				FragmentManager fm = getFragmentManager();
				fm.beginTransaction()
						.replace(R.id.lv_second_page, (Fragment) tp).commit();

			}

		});

	}
}
