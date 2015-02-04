package com.example.chibepazam;

import java.util.List;

import com.example.chibepazam.DAO.FoodDAO;
import com.example.chibepazam.models.Food;

public class Search {
	private FoodDAO fooddao;

	public Search() {
		fooddao = new FoodDAO(App.getContext());
		fooddao.open();

		List<Food> values = fooddao.getAllFoods();
	}

}
