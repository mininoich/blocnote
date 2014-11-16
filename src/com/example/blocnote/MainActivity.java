package com.example.blocnote;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private EditText editTextSaisie = null;
	private TextView textViewPrevisualisation = null;
	private RadioGroup radioGroupCouleur = null;
	private String currentColor = "#000000";
	private RelativeLayout toHide = null;
	private Button buttonMasquer = null;
	private Slider slider = null;
	
	private Button buttonGras = null;
	private Button buttonItalique = null;
	private Button buttonSouligne = null;
	
	private ImageButton smiley1 = null;
	private ImageButton smiley2 = null;
	private ImageButton smiley3 = null;
	private SmileyGetter getter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getter = new SmileyGetter(this);
		editTextSaisie = (EditText)findViewById(R.id.editTextSaisie);
		textViewPrevisualisation = (TextView)findViewById(R.id.textViewPrevisualisation);
		radioGroupCouleur = (RadioGroup)findViewById(R.id.radioGroupCouleur);
		buttonGras = (Button)findViewById(R.id.buttonGras);
		buttonItalique = (Button)findViewById(R.id.buttonItalique);
		buttonSouligne = (Button)findViewById(R.id.buttonSouligne);
		smiley1 = (ImageButton)findViewById(R.id.smiley1);
		smiley2 = (ImageButton)findViewById(R.id.smiley2);
		smiley3 = (ImageButton)findViewById(R.id.smiley3);
		toHide = (RelativeLayout)findViewById(R.id.toHide);
		buttonMasquer = (Button)findViewById(R.id.buttonMasquer);
		slider = (Slider)findViewById(R.id.slider);
		
		slider.setToHide(toHide);
		
		buttonMasquer.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(slider.toggle()){
					buttonMasquer.setText("Masquer");
				} else {
					buttonMasquer.setText("Afficher");
				}
			}
			
		});
		
		
		editTextSaisie.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				int cursorIndex = editTextSaisie.getSelectionStart();
				if(cursorIndex > 0 && s.subSequence(cursorIndex-1, cursorIndex).toString().equalsIgnoreCase("\n")){
					
					editTextSaisie.getText().insert(cursorIndex, "<br />");
				}
				textViewPrevisualisation.setText(Html.fromHtml("<font color=\""+ currentColor +"\">" + editTextSaisie.getText().toString() + "</font>", getter, null));
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		radioGroupCouleur.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId){
					case R.id.radioButtonNoir : 
						currentColor = "#000000";
					break;
					
					case R.id.radioButtonBleu : 
						currentColor = "#0022FF";
					break;
						
					case R.id.radioButtonRouge : 
						currentColor = "#FF0000";
					break;
				}
				editTextSaisie.setText(editTextSaisie.getText().toString());
			}
		});
		
		buttonGras.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorStart = editTextSaisie.getSelectionStart();
				int cursorEnd = editTextSaisie.getSelectionEnd();
				
				if(cursorStart == cursorEnd){
					// on insère juste les balises vides
					editTextSaisie.getText().insert(cursorStart, "<b></b>");
				} else {
					// On entoure le texte avec les balises
					editTextSaisie.getText().insert(cursorStart, "<b>");
					editTextSaisie.getText().insert(cursorEnd+3, "</b>");
				}
			}
			
		});
		
		buttonItalique.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorStart = editTextSaisie.getSelectionStart();
				int cursorEnd = editTextSaisie.getSelectionEnd();
				
				if(cursorStart == cursorEnd){
					// on insère juste les balises vides
					editTextSaisie.getText().insert(cursorStart, "<em></em>");
				} else {
					// On entoure le texte avec les balises
					editTextSaisie.getText().insert(cursorStart, "<em>");
					editTextSaisie.getText().insert(cursorEnd+4, "</em>");
				}
			}
			
		});
		
		buttonSouligne.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorStart = editTextSaisie.getSelectionStart();
				int cursorEnd = editTextSaisie.getSelectionEnd();
				
				if(cursorStart == cursorEnd){
					// on insère juste les balises vides
					editTextSaisie.getText().insert(cursorStart, "<u></u>");
				} else {
					// On entoure le texte avec les balises
					editTextSaisie.getText().insert(cursorStart, "<u>");
					editTextSaisie.getText().insert(cursorEnd+3, "</u>");
				}
			}
			
		});
		
		smiley1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorIndex = editTextSaisie.getSelectionStart();
				editTextSaisie.getText().insert(cursorIndex, "<img src=\"smiley1\">");
			}
			
		});
		
		smiley2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorIndex = editTextSaisie.getSelectionStart();
				editTextSaisie.getText().insert(cursorIndex, "<img src=\"smiley2\">");
			}
			
		});
		
		smiley3.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int cursorIndex = editTextSaisie.getSelectionStart();
				editTextSaisie.getText().insert(cursorIndex, "<img src=\"smiley3\">");
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
