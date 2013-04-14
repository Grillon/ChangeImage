package com.example.changeimage;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Zoo extends Jeux {

	public Zoo() {
		super();
		/*
		objetsMaison.add(new ObjetMaison((float)0.36625,(float)0.55625,(float)0.69073915,(float)0.77230245,"Herisson",soundPool.load(this, R.raw.herisson, 1)));
		objetsMaison.add(new ObjetMaison((float)0.375,(float)0.785,(float)0.021240441,(float)0.26083264,"Rhinoceros",soundPool.load(this, R.raw.rhinoceros, 1)));
		objetsMaison.add(new ObjetMaison((float)0.01125,(float)0.32875,(float)0.021240441,(float)0.23874256,"Pelican",soundPool.load(this, R.raw.pelican, 1)));
		*/
		objetsMaison.add(new ObjetMaison((float)0.36625,(float)0.55625,(float)0.69073915,(float)0.77230245,R.string.herisson,-1));
		objetsMaison.add(new ObjetMaison((float)0.375,(float)0.785,(float)0.021240441,(float)0.26083264,R.string.rhinoceros,-1));
		objetsMaison.add(new ObjetMaison((float)0.01125,(float)0.32875,(float)0.021240441,(float)0.23874256,R.string.pelican,-1));
		imageFond = R.drawable.zoo;
		nomLieu = "Zoo";

	}

}
