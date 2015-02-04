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
import android.widget.Button;
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

		final String temp_ingredients = "these are ingredients";
		btn_search = (ImageButton) v.findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();
				
				bundle.putString("ingredients", temp_ingredients);
				SecondPage secondFragment = new SecondPage();
				secondFragment.setArguments(bundle);
				getFragmentManager().beginTransaction()
						.replace(R.id.container, (Fragment) secondFragment)
						.addToBackStack(FisrtPage.class.getName()).commit();
			}
		});

		tv_ingredients_list = (TextView) v
				.findViewById(R.id.tv_ingredients_list);

		Context context = App.getContext();
		IngredinetAdapter myadapter = new IngredinetAdapter(getActivity(),
				ingredients, v);
		lv_ingredients.setAdapter(myadapter);
		lv_ingredients.setVisibility(View.VISIBLE);

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
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return super.getItem(position);
		}

		/** Implement getView method for customizing row of list view. */
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
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
					TextView mtextview = (TextView) mview
							.findViewById(R.id.tv_ingredients_list);
					String temp = mtextview.getText().toString();
					if (temp == null) {
						mtextview.setText(listOfValues[position]);
					} else {
						mtextview.setText(temp + ", " + listOfValues[position]);
					}

				}
			});

			return rowView;
		}
	}
}
// =======
// import android.app.Fragment;
// import android.os.Bundle;
// import android.text.method.ScrollingMovementMethod;
// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.widget.Button;
// import android.widget.EditText;
// import android.widget.TextView;
// >>>>>>> aa81ff2cdd72a751a1c8bd9ba45646d0aba97734
//
//
// public class FisrtPage extends Fragment {
// View v;
//
// @Override
// public View onCreateView(LayoutInflater inflater, ViewGroup container,
// Bundle savedInstanceState) {
// v = inflater.inflate(R.layout.fragment_main, container, false);
// setUpInnerViewElements();
//
// return v;
// }
//
// private void setUpInnerViewElements(){
//
// /**Code for the scroll bars in the TextView. */
// final TextView tv = (TextView)v.findViewById(R.id.TV1);
// tv.setMovementMethod(new ScrollingMovementMethod());//for the scroll bars
//
// /** Code for the scroll bars in the EditText. */
// final EditText wr = (EditText) v.findViewById(R.id.ET1);
// wr.setMovementMethod(new ScrollingMovementMethod());//for the scroll bars
//
// final Button button = (Button) v.findViewById(R.id.B1);//find the button by
// id in main.xml
// button.setOnClickListener(new View.OnClickListener() {
// public void onClick(View v) {
// // Perform action on click
//
//
// String wrcontent = wr.getText().toString();//gets the text of the EditText
// and put it in "wr content" variable.
// String tvcontent = tv.getText().toString();//gets the text of the textView
// and put it in "tv content" variable.
//
//
// if (wrcontent.equals(""))//if the EditText is not empty
// {
// //check if the TextView is empty or not
// if (tvcontent!= null)//If it is not empty...
// {
// tv.setText(tvcontent + "\n" + wrcontent);//add its current(TextView's text)
// text, new line and the text of the EditText as the new text of TextView.
// //tv.setVisibility(0);//makes visible the textView with the cloud1.png
// background
// wr.setText("");//set the text of the Edit Text as empty
// //wrcontent = "";
// }
// else//if the TextView is empty...
// {
// tv.setText(wrcontent);//add the text of the editText as the new text of the
// TextView
// wr.setText("");
// }
// }
// //finish();
// }
// });
// }
// }
