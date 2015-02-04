package com.example.chibepazam;

import com.example.chibepazam.MainActivity.PlaceholderFragment;
import com.example.chibepazam.models.Food;
import java.util.ArrayList;


import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ArrayAdaptor extends ArrayAdapter<Food> {
  private final Context context;
  private final ArrayList<Food> foods;

  public ArrayAdaptor(Context context, ArrayList<Food> foods) {
    super(context, R.layout.row_of_list, foods);
    this.context = context;
    this.foods = foods;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.row_of_list, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.line);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
    textView.setText(context.getResources().getString(R.string.name)+'\n'+
    		foods.get(position).getName()+'\n'+context.getResources().getString(R.string.ingredients)+'\n'
    		+foods.get(position).getIngredient());
//    LinearLayout list_row=(LinearLayout) rowView.findViewById(R.id.list_row);
//    list_row.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View arg0) {
//			FragmentManager fm = getM
//			fm.beginTransaction().add(R.id., arg1)
//
//		}
//	});
    		
    	
  	


    imageView.setImageResource(R.drawable.ic_launcher);
    return rowView;
  }
} 
