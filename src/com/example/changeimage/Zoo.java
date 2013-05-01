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
		objetsMaison.add(new ObjetMaison((float)0.8,(float)0.95,(float)0.056953643,(float)0.19602649,R.string.peroquet,-1));
		objetsMaison.add(new ObjetMaison((float)0.014583333,(float)0.27708334,(float)0.25165564,(float)0.5059603,R.string.dromadaire,-1));
		objetsMaison.add(new ObjetMaison((float)0.32708332,(float)0.541667,(float)0.2807947,(float)0.38410595,R.string.tapir,-1));
		objetsMaison.add(new ObjetMaison((float)0.14166667,(float)0.24166666,(float)0.62119204,(float)0.7324503,R.string.flamant,-1));
		objetsMaison.add(new ObjetMaison((float)0.0,(float)0.23333333,(float)0.7218543,(float)0.789404,R.string.flamant,-1));
		objetsMaison.add(new ObjetMaison((float)0.61041665,(float)0.8375,(float)0.618543,(float)0.7059603,R.string.raton,-1));
		objetsMaison.add(new ObjetMaison((float)0.29791668,(float)0.775,(float)0.83178806,(float)0.9231788,R.string.hippopotame,-1));
		objetsMaison.add(new ObjetMaison((float)0.91041666,(float)0.99583334,(float)0.77218544,(float)0.90331125,R.string.crocodile,-1));
		objetsMaison.add(new ObjetMaison((float)0.91875,(float)0.99583334,(float)0.5960265,(float)0.6344371,R.string.crocodile,-1));
		imageFond = R.drawable.zoo;
		nomLieu = "Zoo";

	}

}
