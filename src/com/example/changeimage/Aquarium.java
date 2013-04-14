package com.example.changeimage;

public class Aquarium extends Jeux {

	public Aquarium() {
		super();
		/*
		objetsMaison.add(new ObjetMaison((float)0.56875,(float)0.73375,(float)0.34239593,(float)0.5369584,"Pieuvre",soundPool.load(this, R.raw.pieuvre, 1)));
		objetsMaison.add(new ObjetMaison((float)0.15866394,(float)0.6388311,(float)0.044460963,(float)0.16980174,"Dauphin",soundPool.load(this, R.raw.dauphin, 1)));
		objetsMaison.add(new ObjetMaison((float)0.691023,(float)1,(float)0.11229244,(float)0.348228,"Poisson lune",soundPool.load(this, R.raw.poissonlune, 1)));
		objetsMaison.add(new ObjetMaison((float)0.3215032,(float)0.49478072,(float)0.39099136,(float)0.4514498,"Poisson globe",soundPool.load(this, R.raw.poissonglobe, 1)));
		objetsMaison.add(new ObjetMaison((float)0.052192178,(float)0.13987477,(float)0.37329614,(float)0.5384511,"Hippocampe",soundPool.load(this, R.raw.hippocampe, 1)));
		objetsMaison.add(new ObjetMaison((float)0.05845515,(float)0.30271402,(float)0.58858734,(float)0.67706317,"Etoile de mer",soundPool.load(this, R.raw.etoiledemer, 1)));
		objetsMaison.add(new ObjetMaison((float)0.16701457,(float)0.44050115,(float)0.46472117,(float)0.55024785,"Limande",soundPool.load(this, R.raw.limande, 1)));
		objetsMaison.add(new ObjetMaison((float)0.3382047,(float)0.5845512,(float)0.5561462,(float)0.63577443,"Sole",soundPool.load(this, R.raw.sole, 1)));
		objetsMaison.add(new ObjetMaison((float)0.64509404,(float)0.73695195,(float)0.58563817,(float)0.65494424,"Oursin",soundPool.load(this, R.raw.oursin, 1)));
		objetsMaison.add(new ObjetMaison((float)0.77244264,(float)0.8517746,(float)0.4204833,(float)0.575316,"Algues",soundPool.load(this, R.raw.algue, 1)));
		objetsMaison.add(new ObjetMaison((float)0.06471812,(float)0.6743215,(float)0.24058238,(float)0.32905823,"Orque",soundPool.load(this, R.raw.orque, 1)));
		objetsMaison.add(new ObjetMaison((float)0.083507285,(float)0.4133611,(float)0.84664196,(float)0.96903354,"Loutre de mer",soundPool.load(this, R.raw.loutremarine, 1)));
		*/
		objetsMaison.add(new ObjetMaison((float)0.56875,(float)0.73375,(float)0.34239593,(float)0.5369584,R.string.pieuvre,-1));
		objetsMaison.add(new ObjetMaison((float)0.15866394,(float)0.6388311,(float)0.044460963,(float)0.16980174,R.string.dauphin,-1));
		objetsMaison.add(new ObjetMaison((float)0.691023,(float)1,(float)0.11229244,(float)0.348228,R.string.poissonLune,-1));
		objetsMaison.add(new ObjetMaison((float)0.3215032,(float)0.49478072,(float)0.39099136,(float)0.4514498,R.string.poissonGlobe,-1));
		objetsMaison.add(new ObjetMaison((float)0.052192178,(float)0.13987477,(float)0.37329614,(float)0.5384511,R.string.hippocampe,-1));
		objetsMaison.add(new ObjetMaison((float)0.05845515,(float)0.30271402,(float)0.58858734,(float)0.67706317,R.string.etoileDeMer,-1));
		objetsMaison.add(new ObjetMaison((float)0.16701457,(float)0.44050115,(float)0.46472117,(float)0.55024785,R.string.limande,-1));
		objetsMaison.add(new ObjetMaison((float)0.3382047,(float)0.5845512,(float)0.5561462,(float)0.63577443,R.string.sole,-1));
		objetsMaison.add(new ObjetMaison((float)0.64509404,(float)0.73695195,(float)0.58563817,(float)0.65494424,R.string.oursin,-1));
		objetsMaison.add(new ObjetMaison((float)0.77244264,(float)0.8517746,(float)0.4204833,(float)0.575316,R.string.algues,-1));
		objetsMaison.add(new ObjetMaison((float)0.06471812,(float)0.6743215,(float)0.24058238,(float)0.32905823,R.string.orque,-1));
		objetsMaison.add(new ObjetMaison((float)0.083507285,(float)0.4133611,(float)0.84664196,(float)0.96903354,R.string.loutreMarine,-1));
		imageFond = R.drawable.aqua;
		nomLieu = "Aquarium";

	}
}
