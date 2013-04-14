package com.example.changeimage;

import java.util.ArrayList;
import java.util.Locale;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.*;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends FragmentActivity  implements TextToSpeech.OnInitListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	public static TextToSpeech tts;
	private static SoundPool soundPool;
	static boolean loaded = false;
	static ArrayList<Pages> pages = new ArrayList<Pages>();
	static final float totalHeight = 1177;
	static final float totalWidth = 800;
	// ImageView iv=null;
	Context monContext=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
		      @Override
		      public void onLoadComplete(SoundPool soundPool, int sampleId,
		          int status) {
		        loaded = true;
		      }
		    });
		//Definition Pages
		/*
		pages.add(new Pages("Cuisine",R.drawable.cuisine));
		pages.add(new Pages("Zoo",R.drawable.zoo));
		pages.add(new Pages("Aquarium",R.drawable.aqua));
		
		pages.get(0).setSon(soundPool.load(this, R.raw.cuisine, 1));
		pages.get(1).setSon(soundPool.load(this, R.raw.zoo, 1));
		pages.get(2).setSon(soundPool.load(this, R.raw.aqua, 1));
	    */
		//Definition des objetsMaison
		/*
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.73875,(float)1,(float)0.09855565,(float)0.24808836,"Micro Onde",soundPool.load(this, R.raw.micro_onde, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.72125,(float)1,(float)0.25233644,(float)0.61172473,"Refregirateur",soundPool.load(this, R.raw.refregirateur, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.41,(float)0.715,(float)0.27527612,(float)0.3789295,"Evier",soundPool.load(this, R.raw.evier, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.60125,(float)0.66625,(float)0.104502976,(float)0.23704334,"Louche",soundPool.load(this, R.raw.louche, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.16125,(float)0.385,(float)0.22175021,(float)0.31605777,"Marmitte",soundPool.load(this, R.raw.marmitte, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.05,(float)0.11,(float)0.71028036,(float)0.7782498,"Spatule",soundPool.load(this, R.raw.spatule, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.0175,(float)0.11625,(float)0.80628717,(float)0.8759558,"The",soundPool.load(this, R.raw.the, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.15875,(float)0.335,(float)0.837723,(float)0.9005947,"Theiere",soundPool.load(this, R.raw.theiere, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.12875,(float)0.255,(float)0.7247239,(float)0.82752764,"Bol",soundPool.load(this, R.raw.bol, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.2975,(float)0.74,(float)0.5386576,(float)0.7604078,"Aspirateur",soundPool.load(this, R.raw.aspirateur, 1)));
		pages.get(0).addObjetMaison(new ObjetMaison((float)0.035,(float)0.215,(float)0.49617672,(float)0.6992353,"Cuiseuse",soundPool.load(this, R.raw.cuiseuse, 1)));
		
		pages.get(1).addObjetMaison(new ObjetMaison((float)0.36625,(float)0.55625,(float)0.69073915,(float)0.77230245,"Herisson",soundPool.load(this, R.raw.herisson, 1)));
		pages.get(1).addObjetMaison(new ObjetMaison((float)0.375,(float)0.785,(float)0.021240441,(float)0.26083264,"Rhinoceros",soundPool.load(this, R.raw.rhinoceros, 1)));
		pages.get(1).addObjetMaison(new ObjetMaison((float)0.01125,(float)0.32875,(float)0.021240441,(float)0.23874256,"Pelican",soundPool.load(this, R.raw.pelican, 1)));
		
		pages.get(2).addObjetMaison(new ObjetMaison((float)0.56875,(float)0.73375,(float)0.34239593,(float)0.5369584,"Pieuvre",soundPool.load(this, R.raw.pieuvre, 1)));
		*/
		tts = new TextToSpeech(this, this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			/*
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			args.putInt("position", position);
			//Log.i("position :",Integer.toString(position));
			fragment.setArguments(args);
			*/
			Bundle args = new Bundle();
			args.putInt("position", position);
			switch (position) {
			case 0:
				Fragment cuisine = new Cuisine();
				cuisine.setArguments(args);
				return cuisine;
			case 1:
				Fragment zoo = new Zoo();
				zoo.setArguments(args);
				return zoo;
			case 2:
			Fragment aquarium = new Aquarium();
			aquarium.setArguments(args);
				return aquarium;
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}
	
	

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";
		int choix;
		static DisplayMetrics metrics = new DisplayMetrics();
		
		

		public DummySectionFragment() {

		}
		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			super.onCreateView(inflater, container, savedInstanceState);
			View rootView = inflater.inflate(R.layout.fragment_main_image,
					container, false);
			choix = getArguments().getInt("position");
			ImageView monImage = (ImageView)rootView.findViewById(R.id.imageView1);
			monImage.setImageResource(pages.get(choix).getImage());
			pages.get(choix).setVue(monImage);
			monImage.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					final int action = event.getAction();
					if (action == MotionEvent.ACTION_UP) {
						final float x = event.getX()/v.getMeasuredWidth();
						final float y = event.getY()/v.getMeasuredHeight();
						Log.i("mon Image bottom : ",Float.toString(v.getMeasuredHeight()));
						Log.i("X : ",Float.toString(x));
						Log.i("Y : ",Float.toString(y));
						Bundle info = pages.get(choix).touche(x, y);
						Log.i("nom : ",info.getString("nom"));
						if (info.getBoolean("touche")) {
							if (loaded) soundPool.play(info.getInt("idSon"), 1, 1, 1, 0, 1f);
						}
					}
					return true;
				}
			    
			});
			return rootView;
		}
		@Override
		public void setUserVisibleHint(boolean etat) {
			int position = getArguments().getInt("position");
			if (etat) {
				if (loaded) soundPool.play(pages.get(position).getSon(), 1, 1, 1, 0, 1f);
				
			}
		}
		
	}
	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			 
            int result = tts.setLanguage(Locale.FRANCE);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //speakOut();
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
 
		
	}
	
	@Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }	
/*	
	public void ToggleQuizz(View view) {
		ToggleButton btn = (ToggleButton) view;
		if (btn.isChecked()) {
			Toast.makeText(this, Integer.toString(mViewPager.getCurrentItem()), Toast.LENGTH_SHORT).show();
		}
			
			
		else Toast.makeText(this, "mode Quizz OFF", Toast.LENGTH_SHORT).show();
	}
*/
}
