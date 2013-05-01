package com.example.changeimage;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MonMenu extends ListFragment {
	private ArrayList<ObjetMaison> objetsMaison = new ArrayList<ObjetMaison>();
	String nomLieu;
	String[] titres = {"Cuisine","Zoo","Aquarium"};
	//String[] titres = { getString(R.string.title_section1),getString(R.string.title_section2),getString(R.string.title_section3) };
	Integer[] imageMenu = { R.drawable.cuisine_minid,R.drawable.zoo_minid,R.drawable.aqua_minid };
	public MonMenu() {
		nomLieu = "Menu";
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MonMenuAdapter adapter = new MonMenuAdapter(getActivity(), titres, imageMenu);
		setListAdapter(adapter);
	}
	
	@Override
	public void setUserVisibleHint(boolean etat) {
		//int position = getArguments().getInt("position");
		if (etat) {
			//MainActivity.tts.speak(nomLieu, TextToSpeech.QUEUE_FLUSH, null);
		}
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (position == 3) {
			getActivity().finish();
		}
		else {
			Intent i = new Intent("com.example.changeimage.MainActivity");
			i.putExtra("position", position);
			startActivity(i);
		}
	}
}
