package com.example.chibepazam.DAO;

import java.util.ArrayList;
import java.util.List;

import com.example.chibepazam.db.MySQLHelper;
import com.example.chibepazam.models.Food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FoodDAO {
	private SQLiteDatabase fooddb;
	private MySQLHelper dbHelper;
	private String[] allColumns = { MySQLHelper.COLUMN_NAME_ENTRY_ID,
			MySQLHelper.COLUMN_NAME_FOOD_NAME,
			MySQLHelper.COLUMN_NAME_COOK_TIME,
			MySQLHelper.COLUMN_NAME_COOK_PEOPLE,
			MySQLHelper.COLUMN_NAME_INGREDIENT, MySQLHelper.COLUMN_NAME_RECIPE,
			MySQLHelper.COLUMN_NAME_IMAGE };

	public FoodDAO(Context context) {
		dbHelper = new MySQLHelper(context);
	}

	public void open() throws SQLException {
		fooddb = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public void createFood(String name, String time, String people,
			String ingredient, String recipe, String image) {
		ContentValues values = new ContentValues();
		values.put(MySQLHelper.COLUMN_NAME_FOOD_NAME, name);
		values.put(MySQLHelper.COLUMN_NAME_COOK_TIME, time);
		values.put(MySQLHelper.COLUMN_NAME_COOK_PEOPLE, people);
		values.put(MySQLHelper.COLUMN_NAME_INGREDIENT, ingredient);
		values.put(MySQLHelper.COLUMN_NAME_RECIPE, recipe);
		values.put(MySQLHelper.COLUMN_NAME_IMAGE, image);
		long insertId = fooddb.insert(MySQLHelper.TABLE_NAME, null, values);
	}

	public void deleteFood(Food food) {
		long id = food.getId();
		System.out.println("food deleted with id: " + id);
		fooddb.delete(MySQLHelper.TABLE_NAME, MySQLHelper.COLUMN_NAME_ENTRY_ID
				+ " = " + id, null);
	}

	public List<Food> getAllFoods() {
		List<Food> foods = new ArrayList<Food>();

		Cursor cursor = fooddb.query(MySQLHelper.TABLE_NAME, allColumns, null,
				null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Food food = cursorToFood(cursor);
			foods.add(food);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return foods;
	}

	private Food cursorToFood(Cursor cursor) {
		Food food = new Food();
		food.setId(cursor.getLong(0));
		food.setName(cursor.getString(1));
		food.setTime(cursor.getString(2));
		food.setPeople(cursor.getString(3));
		food.setIngredient(cursor.getString(4));
		food.setRecipe(cursor.getString(5));
		food.setImage(cursor.getString(6));
		return food;
	}
}
