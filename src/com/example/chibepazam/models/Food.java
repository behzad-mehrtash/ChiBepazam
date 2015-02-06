package com.example.chibepazam.models;
import android.database.sqlite.*;
import android.provider.BaseColumns;

public class Food {
	private long id;
	private String name;
	private String time;
	private String people;
	private String[][] ingredient;
	private String recipe;
	private String image;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String[][] getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		String[] rows=ingredient.split("،");
		this.ingredient=new String[rows.length][2];
		String[] temp;;
		
		for(int i=0;i<rows.length;i++){
//			System.out.println("ingredients: "+rows[i]);
			temp=rows[i].split(":");
			this.ingredient[i][0]=temp[0].trim();
			this.ingredient[i][1]=temp[1].trim();			
		}
		
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
