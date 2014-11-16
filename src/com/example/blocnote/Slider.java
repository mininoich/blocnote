package com.example.blocnote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Slider extends LinearLayout {

	private boolean isOpen = true;
	private RelativeLayout toHide = null;
	final static int SPEED = 300;
	
	public Slider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Slider(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}



	public boolean toggle(){
		TranslateAnimation animation = null;
		
		isOpen = !isOpen;
		if(isOpen){
			animation = new TranslateAnimation(0.0f, 0.0f, -toHide.getHeight(), 0.0f);
			animation.setAnimationListener(openListener);
		} else {
			animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -toHide.getHeight());
			animation.setAnimationListener(closeListener);
		}
		
		animation.setDuration(SPEED);
		animation.setInterpolator(new AccelerateInterpolator());
		startAnimation(animation);
		
		return isOpen;
	}
	
	public void setToHide(RelativeLayout layout){
		this.toHide = layout;
	}

	Animation.AnimationListener openListener = new Animation.AnimationListener(){

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			toHide.setVisibility(View.VISIBLE);
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	Animation.AnimationListener closeListener = new Animation.AnimationListener(){

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			toHide.setVisibility(View.GONE);
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
	};
}
