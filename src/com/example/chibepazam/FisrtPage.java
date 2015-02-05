package com.example.chibepazam;

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

	String[] ingredients;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_main, container, false);
		setUpInnerViewElements();
		return v;
	}

	private void setUpInnerViewElements() {
		ingredients = getResources().getStringArray(R.array.ingredients_array);
		lv_ingredients = (ListView) v.findViewById(R.id.lv_ingredients);
		tv_ingredients_list = (TextView) v
				.findViewById(R.id.tv_ingredients_list);

		btn_search = (ImageButton) v.findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();

				bundle.putString("ingredients", tv_ingredients_list.getText()
						.toString());
				SecondPage secondFragment = new SecondPage();
				secondFragment.setArguments(bundle);
				getFragmentManager().beginTransaction()
						.replace(R.id.container, (Fragment) secondFragment)
						.addToBackStack(FisrtPage.class.getName()).commit();
			}
		});

		IngredinetAdapter myadapter = new IngredinetAdapter(getActivity(),
				ingredients, v);
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
}
