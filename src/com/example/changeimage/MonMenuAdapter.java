package com.example.changeimage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonMenuAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] titre;
	private final Integer[] imageMenu;
	public MonMenuAdapter (Activity context,String[] titre, Integer[] imageMenu) {
		
		super(context,R.layout.menu_articles,titre);
		this.context=context;
		this.titre=titre;
		this.imageMenu=imageMenu;
		
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.accueil, null, true);
		TextView titreElementMenu = (TextView) rowView.findViewById(R.id.titreElementMenu);
		ImageView imageElementMenu = (ImageView) rowView.findViewById(R.id.imageElementMenu);
		
		titreElementMenu.setText(titre[position]);
		imageElementMenu.setImageResource(imageMenu[position]);
		
		return rowView;
	}
	
}
