package com.example.blocnote;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

public class SmileyGetter implements ImageGetter {

	private Context context = null;
	
	public SmileyGetter(Context c){
		this.context = c;
	}
	
	@Override
	public Drawable getDrawable(String source) {
		// TODO Auto-generated method stub
		Drawable retour = null;
		Resources resources = context.getResources();
		
		switch(source){
			case "smiley1" : 
				retour = resources.getDrawable(R.drawable.smiley1);
			break;
				
			case "smiley2" : 
				retour = resources.getDrawable(R.drawable.smiley2);
			break;
			
			case "smiley3" : 
				retour = resources.getDrawable(R.drawable.smiley3);
			break;
		}
		
		retour.setBounds(0,0,retour.getIntrinsicWidth(), retour.getIntrinsicHeight());
		
		return retour;
	}

}
