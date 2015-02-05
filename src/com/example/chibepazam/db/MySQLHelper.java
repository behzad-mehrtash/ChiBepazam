package com.example.chibepazam.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "food";
	public static final String COLUMN_NAME_ENTRY_ID = "food_id";
	public static final String COLUMN_NAME_FOOD_NAME = "food_name";
	public static final String COLUMN_NAME_COOK_TIME = "cook_time";
	public static final String COLUMN_NAME_COOK_PEOPLE = "cook_people";
	public static final String COLUMN_NAME_INGREDIENT = "ingredient";
	public static final String COLUMN_NAME_RECIPE = "recipe";
	public static final String COLUMN_NAME_IMAGE = "image";

	private static final String DATABASE_NAME = "food.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "(" + COLUMN_NAME_ENTRY_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME_FOOD_NAME
			+ " text, " + COLUMN_NAME_COOK_TIME + " text, "
			+ COLUMN_NAME_COOK_PEOPLE + " text, " + COLUMN_NAME_INGREDIENT
			+ " text," + COLUMN_NAME_RECIPE + " text," +COLUMN_NAME_IMAGE + " text);";

	public MySQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}
