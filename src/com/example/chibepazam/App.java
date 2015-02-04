package com.example.chibepazam;

import android.app.Application;
import android.content.Context;

public class App extends Application {

	/**
	 * Keeps a reference of the application context
	 */
	private static Context mAppContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mAppContext = getApplicationContext();
	}

	/**
	 * Returns the application context
	 * 
	 * @return application context
	 */
	public static Context getContext() {
		return mAppContext;
	}
}
