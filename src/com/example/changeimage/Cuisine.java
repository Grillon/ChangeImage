package com.example.changeimage;

import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Cuisine extends Jeux {
	/*
	int imageFond;
	private ArrayList<ObjetMaison> objetsMaison = new ArrayList<ObjetMaison>();
	private String nomLieux;
	private int numeroPage;
	public static int nombreDePages = 0;
	private static String objetQuiz;
	private TextToSpeech tts;
	*/
public Cuisine() {
	super();
	/*
	objetsMaison.add(new ObjetMaison((float)0.73875,(float)1,(float)0.09855565,(float)0.24808836,"Micro Onde",soundPool.load(this, R.raw.micro_onde, 1)));
	objetsMaison.add(new ObjetMaison((float)0.72125,(float)1,(float)0.25233644,(float)0.61172473,"Refregirateur",soundPool.load(this, R.raw.refregirateur, 1)));
	objetsMaison.add(new ObjetMaison((float)0.41,(float)0.715,(float)0.27527612,(float)0.3789295,"Evier",soundPool.load(this, R.raw.evier, 1)));
	objetsMaison.add(new ObjetMaison((float)0.60125,(float)0.66625,(float)0.104502976,(float)0.23704334,"Louche",soundPool.load(this, R.raw.louche, 1)));
	objetsMaison.add(new ObjetMaison((float)0.16125,(float)0.385,(float)0.22175021,(float)0.31605777,"Marmitte",soundPool.load(this, R.raw.marmitte, 1)));
	objetsMaison.add(new ObjetMaison((float)0.05,(float)0.11,(float)0.71028036,(float)0.7782498,"Spatule",soundPool.load(this, R.raw.spatule, 1)));
	objetsMaison.add(new ObjetMaison((float)0.0175,(float)0.11625,(float)0.80628717,(float)0.8759558,"The",soundPool.load(this, R.raw.the, 1)));
	objetsMaison.add(new ObjetMaison((float)0.15875,(float)0.335,(float)0.837723,(float)0.9005947,"Theiere",soundPool.load(this, R.raw.theiere, 1)));
	objetsMaison.add(new ObjetMaison((float)0.12875,(float)0.255,(float)0.7247239,(float)0.82752764,"Bol",soundPool.load(this, R.raw.bol, 1)));
	objetsMaison.add(new ObjetMaison((float)0.2975,(float)0.74,(float)0.5386576,(float)0.7604078,"Aspirateur",soundPool.load(this, R.raw.aspirateur, 1)));
	objetsMaison.add(new ObjetMaison((float)0.035,(float)0.215,(float)0.49617672,(float)0.6992353,"Cuiseuse",soundPool.load(this, R.raw.cuiseuse, 1)));
	*/
	objetsMaison.add(new ObjetMaison((float)0.73875,(float)1,(float)0.09855565,(float)0.24808836,R.string.microOnde,-1));
	objetsMaison.add(new ObjetMaison((float)0.72125,(float)1,(float)0.25233644,(float)0.61172473,R.string.refregirateur,-1));
	objetsMaison.add(new ObjetMaison((float)0.41,(float)0.715,(float)0.27527612,(float)0.3789295,R.string.evier,-1));
	objetsMaison.add(new ObjetMaison((float)0.60125,(float)0.66625,(float)0.104502976,(float)0.23704334,R.string.louche,-1));
	objetsMaison.add(new ObjetMaison((float)0.16125,(float)0.385,(float)0.22175021,(float)0.31605777,R.string.marmitte,-1));
	objetsMaison.add(new ObjetMaison((float)0.05,(float)0.11,(float)0.71028036,(float)0.7782498,R.string.spatule,-1));
	objetsMaison.add(new ObjetMaison((float)0.0175,(float)0.11625,(float)0.80628717,(float)0.8759558,R.string.the,-1));
	objetsMaison.add(new ObjetMaison((float)0.15875,(float)0.335,(float)0.837723,(float)0.9005947,R.string.theiere,-1));
	objetsMaison.add(new ObjetMaison((float)0.12875,(float)0.255,(float)0.7247239,(float)0.82752764,R.string.bols,-1));
	objetsMaison.add(new ObjetMaison((float)0.2975,(float)0.74,(float)0.5386576,(float)0.7604078,R.string.aspirateur,-1));
	objetsMaison.add(new ObjetMaison((float)0.035,(float)0.215,(float)0.49617672,(float)0.6992353,R.string.cuiseuse,-1));
	imageFond = R.drawable.cuisine;
	nomLieu = "Cuisine";
	//getString(R.string.aspirateur);
}

}
