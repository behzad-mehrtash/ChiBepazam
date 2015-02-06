package com.example.chibepazam;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import com.example.chibepazam.R;
import com.example.chibepazam.DAO.FoodDAO;
import com.example.chibepazam.models.Food;

public class MainActivity extends ActionBarActivity {

	public static FoodDAO fDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// DB

		fDB = new FoodDAO(getApplicationContext());
		fDB.open();// male chie? key bayad gozasht? faghat sare neveshtan? ya
					// unvar ke mikhuim tu firstPage ham bayad bezarim?
//		fDB.createFood(
//		 "خورشت بادمجان",
//		 "۱۲۰ دقیقه",
//		 "۴ نفر",
//		 "بادمجون :نیم کیلو،گوشت   :نیم کیلو،گوجه فرنگی:۳عدد،پیاز ریز شده:یک عدد،زعفران و نمک و روغن:مقداری،رب  :دو قاشق غذاخوری،آب:۴ لیوان،آبغوره:نصف پیمانه",
//		 "یادمجونها رو پوست بگیرید بعد دو ساعت تو آب نمک خیس کنید بعد خشک کرده و سرخ کنید. اگه میخواهید مجلسی تر بشه میتونید به شکل زیر برش زده و سرخ کنید. پیاز رو تفت بدید تا طلائی بشه. بعد گوشت رو بچینید روش. و گوشتها رو هم تفت بدید تا کمی سرخ بشن. آب رو با رب مخلوط کنید و بریزید رو گوشت ، در ظرف رو ببنید همین که جوشید حرارت رو کم کنید تا گوشت پخته بشه حدود یک ونیم ساعت زمان میبره ( اگه گوشت گوساله باشه ) دراواخر پخت نمک رو اضافه کنید. وقتی گوشت پخته شد و حدود یک استکان آب تهش بود ازرو گاز بردارید.بادمجونها رو بچینید ته ماهی تابه ، گوشتها رو بزارید روش ، آب گوشت رو با زعفران و آبغوره مخلوط کنید و بریزید رو خورشت ، گوجه فرنگی ها رو هم نصف کرده و رو خورشت بچینید ، حدو یک ربع روی حرارت متوسط قرار بدید تا آب خورشت کشیده شده و به روغن بیفته. خورشت خوشمزه ما آماده ست ، نوش جونتون! ",
//		 "bademjan.JPG");
//		 fDB.createFood(
//		 "کتلت سیب زمینی",
//		 "۳۰ دقیقه",
//		 "۴ نفر",
//		 "سیب زمینی :600گرم،تخم مرغ:1عدد،نمک  و فلفل و زردچوبه:به میزان لازم،گوشت :150گرم،جعفری خورد شده:چند شاخه،پیاز:۱عدد،رب:۱قاشق غذاخوری،نمک و فلفل و ادویه ی گوشت:به میزان لازم",
//		 "سیب زمینی ها رو بشورید و داخل قابلمه ای آب بریزید و بذارید تا آبپز بشه. پیاز رو خورد کنید و داخل ماهیتابه روغن بریزید و سرخش کنید،زردچوبه رو بهش اضافه کنید و تفتشون بدید. گوشت چرخ کرده رو به پیاز اضافه کنید و تفت بدید،ادویه ی گوشت و فلفل رو بهش اضافه کنید.جعفری خورد شده رو هم بهش اضافه کنید و کمی تفتش بدید. رب رو با مقداری آبجوش رقیق کنید و به مایع گوشت اضافه کنید،صبر کنید تا آب گوشت بخار بشه و بعد یه تفت کوچولوی دیگه بدید. مواد رو بذارید کنار تا خنک بشه و روغن اضافش بره. صبر کنید سیب زمینی ها خنک بشن و بعد اونها رو پوست کنده و رنده کنید،تخم مرغ و نمک و فلفل رو بهش اضافه کنید و با دست ورز بدید.حالت خمیری پیدا میکنه. حالا از سیب زمینی ها بردارید و کف دستتون پهن کنید،مقداری از مخلوط گوشت روش بذارید،دوباره از سیب زمینی ها بردارید و کف دست پهنش کنید و روی مخلوط گوشتتون بذارید. کتلت رو به هر شکلی که دوست دارید توی دستتون شکلش بدید، فشارش بدید تا بهم بچسبه،ولی مواظب باشید مواد میانیش بیرون نزنه ،(حالا اگه دوست دارید میتونید تو پودر سوخاری و یا نون آرد شده بغلتونید، من این کارو نکردم) و بعد توی روغن سرخش کنید. هر بار که سیب زمینی رو توی دستتون پهن میکنید دستتون رو تمیز کنید تا مواد به دستتون نچسبه",
//		 "kotlet.jpg");

		// ************************************Food******

//		List<Food> foods = fDB.getAllFoods();
//		for (int i = 0; i < foods.size(); i++) {
//			fDB.deleteFood(foods.get(i));
//		}

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new FisrtPage()).commit();
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

	// /**
	// * A placeholder fragment containing a simple view.
	// */
	// public static class PlaceholderFragment extends Fragment {
	//
	// public PlaceholderFragment() {
	// }
	//
	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View rootView = inflater.inflate(R.layout.fragment_main, container,
	// false);
	// return rootView;
	// }
	// }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println("activity is going to die!");
		fDB.close();
	}

}
