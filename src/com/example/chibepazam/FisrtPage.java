package com.example.chibepazam;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FisrtPage extends Fragment {
	View v;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_main, container, false);
		setUpInnerViewElements();
		
		return v;
	}
	
	private void setUpInnerViewElements(){

		/**Code for the scroll bars in the TextView. */
        final TextView tv = (TextView)v.findViewById(R.id.TV1);
        tv.setMovementMethod(new ScrollingMovementMethod());//for the scroll bars

        /** Code for the scroll bars in the EditText. */
        final EditText wr = (EditText) v.findViewById(R.id.ET1);
        wr.setMovementMethod(new ScrollingMovementMethod());//for the scroll bars

        final Button button = (Button) v.findViewById(R.id.B1);//find the button by id in main.xml
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click


                String wrcontent = wr.getText().toString();//gets the text of the EditText and put it in "wr content" variable. 
                String tvcontent = tv.getText().toString();//gets the text of the textView and put it in "tv content" variable. 


                if (wrcontent.equals(""))//if the EditText is not empty
                {
                    //check if the TextView is empty or not
                    if (tvcontent!= null)//If it is not empty... 
                    {
                        tv.setText(tvcontent + "\n" + wrcontent);//add its current(TextView's text) text, new line and the text of the EditText as the new text of TextView.
                        //tv.setVisibility(0);//makes visible the textView with the cloud1.png background
                        wr.setText("");//set the text of the Edit Text as empty
                        //wrcontent = "";
                    }
                    else//if the TextView is empty...
                    {
                        tv.setText(wrcontent);//add the text of the editText as the new text of the TextView
                        wr.setText("");
                    }
                }
                //finish();
            }
        });
	}
}
