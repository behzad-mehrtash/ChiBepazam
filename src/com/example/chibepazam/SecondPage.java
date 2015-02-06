package com.example.chibepazam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.chibepazam.models.Food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SecondPage extends Fragment {
	View v;
	ArrayList<String> ingredients;
	ArrayAdaptor aa;
	List<Food> selected_foods=new List<Food>() {
		
		@Override
		public <T> T[] toArray(T[] array) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Food> subList(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Food set(int location, Food object) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean remove(Object object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Food remove(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<Food> listIterator(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<Food> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int lastIndexOf(Object object) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Iterator<Food> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int indexOf(Object object) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Food get(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Object object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(int arg0, Collection<? extends Food> arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean addAll(Collection<? extends Food> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void add(int location, Food object) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(Food object) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	List<Food> all_foods;
	
//	String searchableIngredients;
//	String[] ingred_array;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Bundle bundle = this.getArguments();
//		if (bundle != null) {
//			searchableIngredients = bundle.getString("ingredients");
//			ingred_array = searchableIngredients.split(",");
//			for (int i = 0; i < ingred_array.length; i++) {
//				ingred_array[i] = ingred_array[i].trim();
//			}
//		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
//		Toast.makeText(getActivity(), searchableIngredients, Toast.LENGTH_SHORT)
//				.show();
		setUpInnerViewElements();

		return v;
	}

	private void setUpInnerViewElements() {
		
		MainActivity ma = (MainActivity)getActivity();///??????????????
		all_foods = ma.fDB.getAllFoods();
		
		//indexes of foods, which was found, in DB
		final int[] indexes = getArguments().getIntArray("selected_foods");
//		System.out.println("size of results should be:"+indexes.length);

		for (int i=0;i<indexes.length;i++){
//			System.out.println(all_foods.get(indexes[i]));
			selected_foods.add(all_foods.get(indexes[i]));
		}
		//a list of selected foods
		aa=new ArrayAdaptor(getActivity().getApplicationContext(),selected_foods);
		
		final Bundle bundle = new Bundle();

		ListView lv = (ListView) v.findViewById(R.id.lv_second_page);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {

				bundle.putInt("selected_food", indexes[position]);
				ThirdPage tp = new ThirdPage();
				tp.setArguments(bundle);

				FragmentManager fm = getFragmentManager();
				fm.beginTransaction()
						.replace(R.id.lv_second_page, (Fragment) tp).commit();

			}

		});

	}
}
