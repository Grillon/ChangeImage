package com.example.changeimage;

import java.util.ArrayList;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MonMenu extends Fragment {
	private ArrayList<ObjetMaison> objetsMaison = new ArrayList<ObjetMaison>();
	String nomLieu;
	public MonMenu() {
		super();
		objetsMaison.add(new ObjetMaison((float)0,(float)0.49060544,(float)0,(float)0.49568772,R.string.title_section1,-1));
		objetsMaison.add(new ObjetMaison((float)0.5,(float)1,(float)0,(float)0.49568772,R.string.title_section3,-1));
		objetsMaison.add(new ObjetMaison((float)0,(float)0.49060544,(float)0.5,(float)1,R.string.title_section2,-1));
		objetsMaison.add(new ObjetMaison((float)0.5,(float)1,(float)0.5,(float)1,R.string.title_section0,-1));
		nomLieu = "Menu";
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.accueil,
				container, false);
		rootView.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int action = event.getAction();
				if (action == MotionEvent.ACTION_UP) {
					final float x = event.getX()/v.getMeasuredWidth();
					final float y = event.getY()/v.getMeasuredHeight();
					Bundle info = touche(x, y);
					if (info.getBoolean("touche")) {
						switch (info.getInt("nom")) {
						case R.string.title_section1:
							MainActivity.mViewPager.setCurrentItem(1);
							break;
						case R.string.title_section2:
							MainActivity.mViewPager.setCurrentItem(2);
							break;
						case R.string.title_section3:
							MainActivity.mViewPager.setCurrentItem(3);
							
						}
					}
				}
				return true;
			}
			
		    
		});
		return rootView;
	}
	
	@Override
	public void setUserVisibleHint(boolean etat) {
		//int position = getArguments().getInt("position");
		if (etat) {
			MainActivity.tts.speak(nomLieu, TextToSpeech.QUEUE_FLUSH, null);
		}
	}
	
	private Bundle touche(float x,float y) {
		int nbrElements = objetsMaison.size();
		for (int curseur=0;curseur<nbrElements;curseur++) {
			ObjetMaison objetCourant = objetsMaison.get(curseur);
			if (objetCourant.touche(x, y)) {
				Bundle info = new Bundle();
				info.putBoolean("touche", true);
				info.putInt("nom", objetCourant.getMessage());
				info.putInt("idSon", -1);
				return info;
			}
			
		}
		Bundle info = new Bundle();
		info.putBoolean("touche", false);
		info.putString("nom", "aucun");
		info.putInt("idSon",-1);
		return info;
	}
}
