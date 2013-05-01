package com.example.changeimage;

import java.util.ArrayList;

import java.util.Locale;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public abstract class Jeux extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	int imageFond;
	protected ArrayList<ObjetMaison> objetsMaison = new ArrayList<ObjetMaison>();
	protected String nomLieu;
	public boolean modeQuiz;
	public String objetQuiz;
	public View maVue;
	
	
	public Jeux() {
		modeQuiz=false;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_main_image,
				container, false);
		ImageView monImage = (ImageView)rootView.findViewById(R.id.imageView1);
		monImage.setImageResource(imageFond);
		setVue(rootView);
		rootView.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int action = event.getAction();
				if (action == MotionEvent.ACTION_UP) {
					final float x = event.getX()/v.getMeasuredWidth();
					final float y = event.getY()/v.getMeasuredHeight();
					//Log.i("mon Image bottom : ",Float.toString(v.getMeasuredHeight()));
					Log.i("X : ",Float.toString(x));
					Log.i("Y : ",Float.toString(y));
					Bundle info = touche(x, y);
					//Log.i("nom : ",info.getString("nom"));
					if (info.getBoolean("touche")) {
						TextView txt = (TextView)v.findViewById(R.id.textView1);
						//if (loaded) soundPool.play(info.getInt("idSon"), 1, 1, 1, 0, 1f);
						if (modeQuiz()) {
							compare(info.getString("nom"));
						}
						else {
							MainActivity.tts.speak(info.getString("nom"), TextToSpeech.QUEUE_FLUSH, null);
							txt.setText(info.getString("nom"));
						}
					}
				}
				return true;
			}
			
		    
		});
		ToggleButton btn = (ToggleButton)rootView.findViewById(R.id.modeQuiz);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				View vue = getVue();
				TextView txt = (TextView)vue.findViewById(R.id.textView1);
				ToggleButton btn = (ToggleButton)v.findViewById(R.id.modeQuiz);
				if (btn.isChecked()) {
					
					MainActivity.tts.speak("Quizz activé.", TextToSpeech.QUEUE_FLUSH, null);
					quizOn();
					
					
				}
				else {
					MainActivity.tts.speak("Fin du Quizz.", TextToSpeech.QUEUE_FLUSH, null);
					quizOff();
				}
				
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
	@Override
	public void onResume() {
		super.onResume();
		quizOff();
	}
	private Bundle touche(float x,float y) {
		int nbrElements = objetsMaison.size();
		for (int curseur=0;curseur<nbrElements;curseur++) {
			ObjetMaison objetCourant = objetsMaison.get(curseur);
			if (objetCourant.touche(x, y)) {
				Bundle info = new Bundle();
				info.putBoolean("touche", true);
				info.putString("nom", getString(objetCourant.getMessage()));
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

public void setVue(View view) {
	maVue = view;
}

public View getVue() {
	return maVue;
}

public void quizOn() {
	modeQuiz = true;
	selectWord();
	
}

public void quizOff() {
	ToggleButton btn = (ToggleButton)getActivity().findViewById(R.id.modeQuiz);
	TextView txt = (TextView)getActivity().findViewById(R.id.textView1);
	txt.setText(" ");
	btn.setChecked(false);
	modeQuiz = false;
	//Log.i("mode quiz :",Boolean.toString(modeQuiz));
}

public boolean modeQuiz() {
	View v = getVue();
	ToggleButton btn = (ToggleButton)v.findViewById(R.id.modeQuiz);
	modeQuiz = btn.isChecked();
	return modeQuiz;
}

public String selectWord() {
	int max = objetsMaison.size();
	int min = 0;
	int choix = (int)(Math.random()*(max - min)+min);
	objetQuiz = getString(objetsMaison.get(choix).getMessage());
	questionQuiz();
	return objetQuiz;
}

private void questionQuiz() {
	View v = getVue();
	TextView txt = (TextView)v.findViewById(R.id.textView1);
	txt.setText("Trouves "+objetQuiz);
	
	MainActivity.tts.speak("Trouves "+objetQuiz, TextToSpeech.QUEUE_ADD, null);
	
}

public boolean compare(String reponse) {
	if (objetQuiz.equalsIgnoreCase(reponse)) {
		bonneReponse(reponse);
		
		selectWord();
	}
	else {
		mauvaiseReponse(reponse);
		questionQuiz();
	}
	return objetQuiz.equalsIgnoreCase(reponse);
}

public String getWord() {
	return objetQuiz;
}

private void bonneReponse(String reponse) {
	String message = "Bravo, tu as trouvé "+reponse;
	int couleur = Color.GREEN;
	Toast toast = Toast.makeText(getActivity().getBaseContext(), message, Toast.LENGTH_SHORT);
	
	
	TextView felicitation = (TextView) toast.getView().findViewById(android.R.id.message);
	felicitation.setTextColor(couleur);
	toast.show();

	MainActivity.tts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
	
	
	
	
}

private void mauvaiseReponse(String reponse) {
	String message = "Désolé, c'est "+reponse;
	int couleur = Color.RED;
	Toast toast = Toast.makeText(getActivity().getBaseContext(), message, Toast.LENGTH_SHORT);
	
	TextView felicitation = (TextView) toast.getView().findViewById(android.R.id.message);
	felicitation.setTextColor(couleur);
	toast.show();
	MainActivity.tts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
}

}
