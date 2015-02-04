package com.example.chibepazam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chibepazam.DAO.FoodDAO;
import com.example.chibepazam.models.Food;

public class ThirdPage extends Fragment {
	View v;
	Food food;
	FoodDAO fdb=new FoodDAO(getActivity().getApplicationContext());
	
//	public ThirdPage(Food food){
//		this.food=food;
//	}
	
	public ThirdPage() { //why is it needed??
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.third_page, container, false);
		setUpInnerViewElements();
		
		return v;
	}
	
	private void setUpInnerViewElements(){
		food = fdb.getAllFoods().get((Integer) getArguments().get("selected_food"));
		
		TextView title = (TextView) v.findViewById(R.id.tv_title_thirdPage);
		TextView context = (TextView) v.findViewById(R.id.tv_context_thirdPage);
	    ImageView imageView = (ImageView) v.findViewById(R.id.im_thirdPage);
	    
	    title.setText(context.getResources().getString(R.string.name)+'\n'+
	    		food.getName()+ '\n'+context.getResources().getString(R.string.people)+'\n'+
	    		food.getPeople()+context.getResources().getString(R.string.time)+'\n'+
	    		'\n'+food.getTime());
	    context.setText(context.getResources().getString(R.string.ingredients)+'\n'+
	    		food.getIngredient()+'\n'+
	    		context.getResources().getString(R.string.recipe)+'\n'+
	    		food.getRecipe());
	    }
}

