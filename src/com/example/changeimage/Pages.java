package com.example.changeimage;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;

public class Pages {
	private int idSon;
	private int idImage;
	private String nom;
	private View vue;
	private ArrayList<ObjetMaison> objetsMaison = new ArrayList<ObjetMaison>();
	
	public Pages(String nomTmp, int idImageTmp) {
		nom = nomTmp;
		idImage = idImageTmp;
	}
	
	int getImage() {
		return idImage;
	}
	String getNom() {
		return nom;
	}
	void setSon(int idSonTmp) {
		idSon = idSonTmp;
	}
	int getSon() {
		return idSon;
	}
	void setVue(View vueTmp) {
		vue = vueTmp;
	}
	View getVue() {
		return vue;
	}
	void addObjetMaison(ObjetMaison objetMaisonTmp) {
		objetsMaison.add(objetMaisonTmp);
	}
	ArrayList<ObjetMaison> getObjetMaison() {
		return objetsMaison;
	}
	Bundle touche(float x,float y) {
		int nbrElements = objetsMaison.size();
		for (int curseur=0;curseur<nbrElements;curseur++) {
			ObjetMaison objetCourant = objetsMaison.get(curseur);
			if (objetCourant.touche(x, y)) {
				Bundle info = new Bundle();
				info.putBoolean("touche", true);
				info.putString("nom", objetCourant.getMessage());
				info.putInt("idSon", objetCourant.getSon());
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