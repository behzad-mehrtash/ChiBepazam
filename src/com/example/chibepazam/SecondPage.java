package com.example.chibepazam;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SecondPage extends Fragment {
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.second_page, container, false);
		setUpInnerViewElements();
		
		return v;
	}
	
	private void setUpInnerViewElements(){
		ListView lv = (ListView)v.findViewById(R.id.lv_second_page);
		
	
	}
}
