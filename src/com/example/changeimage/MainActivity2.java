package com.example.changeimage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends FragmentActivity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_articles);
        
        MonMenu firstFragment = new MonMenu();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container2, firstFragment).commit();
	}
	public void byeBye(View view) {
		finish();
	}
}
