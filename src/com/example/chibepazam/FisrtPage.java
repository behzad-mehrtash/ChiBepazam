package com.example.chibepazam;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class FisrtPage extends Fragment {
	View v;
	ListView lv_ingredients;
	// EditText et_ingredients;
	ImageButton btn_add_ingredients;
	ImageButton btn_search;
	TextView tv_ingredients_list;

	String[] ingredients = { "a", "b", "c", "d", "e", "f" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_main, container, false);
		setUpInnerViewElements();
		return v;
	}

	private void setUpInnerViewElements() {
		// et_ingredients = (EditText)v.findViewById(R.id.et_ingredients);
		lv_ingredients = (ListView) v.findViewById(R.id.lv_ingredients);
		// btn_add_ingredients =
		// (ImageButton)v.findViewById(R.id.btn_add_ingredient);
		btn_search = (ImageButton) v.findViewById(R.id.btn_search);
		tv_ingredients_list = (TextView) v
				.findViewById(R.id.tv_ingredients_list);

		Context context = App.getContext();
		IngredinetAdapter myadapter = new IngredinetAdapter(context,
				ingredients);
		lv_ingredients.setAdapter(myadapter);
		lv_ingredients.setVisibility(View.VISIBLE);

	}

	public class IngredinetAdapter extends ArrayAdapter<String> {
		/** Global declaration of variables. As there scope lies in whole class. */
		private Context context;
		private String[] listOfValues;

		/** Constructor Class */
		public IngredinetAdapter(Context c, String[] values) {
			super(c, android.R.layout.simple_list_item_1, values);
			this.context = c;
			this.listOfValues = values;
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return super.getItem(position);
		}

		/** Implement getView method for customizing row of list view. */
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) App.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.ingredient_list_item,
					parent, false);

			RadioButton radioButton = (RadioButton) rowView
					.findViewById(R.id.radio_ingredient);
			System.out.println(listOfValues[position]);
			radioButton.setText(listOfValues[position]);
			radioButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});

			return rowView;
		}
	}

}
