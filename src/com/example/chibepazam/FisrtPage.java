package com.example.chibepazam;

import java.util.ArrayList;
import java.util.List;

import com.example.chibepazam.DAO.FoodDAO;
import com.example.chibepazam.models.Food;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chibepazam.R;

public class FisrtPage extends Fragment {
	View v;
	ListView lv_ingredients;
	// EditText et_ingredients;
	ImageButton btn_add_ingredients;
	ImageButton btn_search;
	TextView tv_ingredients_list;
	private Boolean[] checklist;

	String[] allIngredients;
	String[] searchableIngredients;
	List<Food> foods;
	ArrayList<Integer> temp_results=new ArrayList<Integer>();
	int[] results;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_main, container, false);
		setUpInnerViewElements();
		return v;
	}

	private void setUpInnerViewElements() {
		
		allIngredients = getResources().getStringArray(R.array.ingredients_array);
		
		lv_ingredients = (ListView) v.findViewById(R.id.lv_ingredients);
		tv_ingredients_list = (TextView) v
				.findViewById(R.id.tv_ingredients_list);

		btn_search = (ImageButton) v.findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//finds the indexes of the foods which contain the ingredients
				search(tv_ingredients_list.getText().toString());
				System.out.println("search finished");
				Bundle bundle = new Bundle();				
				bundle.putIntArray("selected_foods", results);
				SecondPage secondFragment = new SecondPage();
				secondFragment.setArguments(bundle);
				getFragmentManager().beginTransaction()
						.replace(R.id.container, (Fragment) secondFragment)
						.addToBackStack(FisrtPage.class.getName()).commit();
			}
		});

		IngredinetAdapter myadapter = new IngredinetAdapter(getActivity(),
				allIngredients, v);
		lv_ingredients.setAdapter(myadapter);
		lv_ingredients.setVisibility(View.VISIBLE);
	}

	@Override
	public void onResume() {
		super.onResume();
		
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public class IngredinetAdapter extends ArrayAdapter<String> {
		/** Global declaration of variables. As there scope lies in whole class. */
		private Context context;
		private String[] listOfValues;
		private View mview;
		

		/** Constructor Class */
		public IngredinetAdapter(Context c, String[] values, View v) {
			super(c, android.R.layout.simple_list_item_1, values);
			this.context = c;
			this.listOfValues = values;
			this.mview = v;

			checklist = new Boolean[listOfValues.length];
			for (int i = 0; i < checklist.length; i++) {
				checklist[i] = false;
			}
		}

		@Override
		public String getItem(int position) {
			return super.getItem(position);
		}

		/** Implement getView method for customizing row of list view. */
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.ingredient_list_item,
					parent, false);

			final CheckBox checkButton = (CheckBox) rowView
					.findViewById(R.id.radio_ingredient);
			System.out.println(listOfValues[position]);
			checkButton.setText(listOfValues[position]);
			checkButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (checkButton.isChecked()) {
						checklist[position] = true;
					} else {
						checklist[position] = false;
					}

					String temp = "";
					for (int i = 0; i < listOfValues.length; i++) {
						if (checklist[i] == true) {
							temp += listOfValues[i] + ", ";
						}
					}
					TextView mtextview = (TextView) mview
							.findViewById(R.id.tv_ingredients_list);
					if (temp.equals("")) {
						mtextview.setText(temp);
					} else {
						mtextview.setText(temp.substring(0, temp.length() - 2)
								.toString());
					}
				}
			});

			return rowView;
		}
	}
	
	private void search(String str){
		
		System.out.println("miyaaaaaaaaaaaaaaaaaaaay?");
		
		MainActivity ma = (MainActivity)getActivity();///??????????????
		foods = ma.fDB.getAllFoods();
		for (int i=0;i<foods.get(0).getIngredient().length;i++)
			System.out.println("**"+foods.get(0).getIngredient()[i][0]);
		System.out.println("size:"+foods.size());
		searchableIngredients = str.split(",");
		for (int i = 0; i < searchableIngredients.length; i++){ 
			searchableIngredients[i] = searchableIngredients[i].trim();
//			System.out.println("*****"+searchableIngredients[i]);
			for(int k=0;k<foods.size();k++){
				for(int j=0;j<foods.get(k).getIngredient().length;j++){
					System.out.println("j:"+j+" k:"+k+" i:"+i);
					if(foods.get(k).getIngredient()[j][0].equals(searchableIngredients[i]))
						//the foods which contains this ingredient
						if(!temp_results.contains(k))
							temp_results.add(k); 
				}
			}
		}
		results=new int[temp_results.size()];
		System.out.println("results:"+results.length);
		for (int i=0;i<results.length;i++){
			results[i]=temp_results.get(i);
			System.out.println("**"+results[i]);
		}
	}
}
