package com.niming;

import com.niming.zfacedetect.R;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Intent intent = null;
	public Vibrator vibrator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button staticBtn = (Button) findViewById(R.id.btnStatic);
		/*…Ë÷√◊÷ÃÂ*/
		Typeface typeFace =Typeface.createFromAsset(getAssets(),"fonts/ADOBEKAITISTD-REGULAR.OTF");
		staticBtn.setTypeface(typeFace);
		
		Button dynamicBtn = (Button) findViewById(R.id.btnDynamic);
		vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE);
		
		staticBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vibrator.vibrate(new long[]{0,100}, -1);
				intent = new Intent(MainActivity.this, StaticDetect.class);
				startActivity(intent);
			}
		});
		
		dynamicBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				vibrator.vibrate(60);
				intent = new Intent(MainActivity.this, DynamicDetect.class);
				startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
