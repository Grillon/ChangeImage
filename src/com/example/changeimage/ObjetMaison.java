package com.example.changeimage;

class ObjetMaison {
	 float x, y, largeur, hauteur;
	 static final float totalHeight = 1177;
	 static final float totalWidth = 800;
	 String monMessage;
	 int monSon;

	ObjetMaison(float debutX, float finX, float debutY, float finY, String monMessageTmp, int monSonTmp) {
	  /*debutX/=totalWidth;
	  finX/=totalWidth;
	  debutY/=totalHeight;
	  finY/=totalHeight;*/
	  largeur = finX - debutX;
	  hauteur = finY - debutY;
	  x = largeur/2;
	  x+=debutX;
	  y = hauteur/2;
	  y+=debutY;
	  monMessage = monMessageTmp;
	  monSon=monSonTmp;
	 // println("x,y,hx,hy:"+x+","+y+","+largeur+","+hauteur);
	}

	public String getMessage() {
	 return monMessage; 
	}

	public int getSon() {
		 return monSon; 
		}

	public boolean touche(float x, float y) {
	  if (Math.abs(x - this.x) < largeur/2 && Math.abs(y - this.y) < hauteur/2)
	    return true;
	  else return false;
	}
	}