package com.example.changeimage;

import java.util.ArrayList;

import java.util.Locale;

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
	private int numeroPage;
	public static int nombreDePages = 0;
	public boolean modeQuiz;
	public static String objetQuiz;
	public View maVue;
	
	
	public Jeux() {
		nombreDePages++;
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
		numeroPage = getArguments().getInt("position");
		Log.i("Numero de page : ",Integer.toString(numeroPage));
		Log.i("Nombre de pages : ",Integer.toString(nombreDePages));
		setVue(rootView);
		rootView.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				final int action = event.getAction();
				if (action == MotionEvent.ACTION_UP) {
					final float x = event.getX()/v.getMeasuredWidth();
					final float y = event.getY()/v.getMeasuredHeight();
					Log.i("mon Image bottom : ",Float.toString(v.getMeasuredHeight()));
					Log.i("X : ",Float.toString(x));
					Log.i("Y : ",Float.toString(y));
					Bundle info = touche(x, y);
					Log.i("nom : ",info.getString("nom"));
					if (info.getBoolean("touche")) {
						TextView txt = (TextView)v.findViewById(R.id.textView1);
						//if (loaded) soundPool.play(info.getInt("idSon"), 1, 1, 1, 0, 1f);
						if (modeQuiz()) {
							if (compare(info.getString("nom"))) {
								txt.setText("Bravo, tu as trouvé "+info.getString("nom"));
								MainActivity.tts.speak("Bravo, tu as trouvé "+info.getString("nom"), TextToSpeech.QUEUE_FLUSH, null);
								selectWord();
								txt.setText("Trouves "+getWord());
							}
							else {
								MainActivity.tts.speak("Désolé, c'est "+info.getString("nom")+"!", TextToSpeech.QUEUE_FLUSH, null);
							}
						}
						else {
							Log.i("tu as touché : ",info.getString("nom"));
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
					
					Toast.makeText(getActivity().getBaseContext(), "mode Quizz", Toast.LENGTH_SHORT).show();
					txt.setText("mode quizz");
					quizOn();
					txt.setText("Trouves le "+getWord());
					
					
				}
				else {
					Toast.makeText(getActivity().getBaseContext(), "mode Quizz", Toast.LENGTH_SHORT).show();
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
			//if (loaded) soundPool.play(pages.get(position).getSon(), 1, 1, 1, 0, 1f);
			
		}
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
/*
private Bundle touche(float x,float y) {
	int nbrElements = objetsMaison.size();
	for (int curseur=0;curseur<nbrElements;curseur++) {
		ObjetMaison objetCourant = objetsMaison.get(curseur);
		if (objetCourant.touche(x, y)) {
			Bundle info = new Bundle();
			info.putBoolean("touche", true);
			info.putString("nom", objetCourant.getMessage());
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
*/
public int getNumeroPage() {
	return numeroPage;
}
/*
@Override
public void onResume() {
	super.onResume();
	
	ToggleButton btn = (ToggleButton)getActivity().findViewById(R.id.modeQuiz);
	btn.setOnClickListener(btnListener);

	
}

private OnClickListener btnListener = new OnClickListener(){
	public void onClick(View view) {
		ToggleButton btn = (ToggleButton) view;
		TextView txt = (TextView)view.findViewById(R.id.textView1);
		if (btn.isChecked()) {
			
			txt.setText("mode quizz");
			Log.i("Texte a change : ","coucou");
		}
		else txt.setText("fin quizz");
	}
};
*/

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
	modeQuiz = false;
}

public boolean modeQuiz() {
	return modeQuiz;
}

public String selectWord() {
	int max = objetsMaison.size();
	int min = 0;
	int choix = (int)(Math.random()*(max - min)+min);
	objetQuiz = getString(objetsMaison.get(choix).getMessage());
	return objetQuiz;
}

public boolean compare(String reponse) {
	return objetQuiz.equalsIgnoreCase(reponse);
}

public String getWord() {
	return objetQuiz;
}

}
