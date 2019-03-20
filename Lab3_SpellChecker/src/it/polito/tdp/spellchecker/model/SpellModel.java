package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;


public class SpellModel {
	private Dictionary d;
	private int wrong;
	private List<String> ww ;
	
	
	public SpellModel() {
		super();
		this.d = new Dictionary();
		this.wrong = 0;
		this.ww = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @return il linguaggio ottenuto dal menu a tendina del controller
	 */


	public int getWrong() {
		return wrong;
	}


	public void setWrong() {
		this.wrong = ww.size();
	}


	public List<String> getWw() {
		return ww;
	}



	public void setWw(List<String> text1) {
		ww.clear();
	for(RichWord temp : d.spellCheckText(text1)) {
		if(temp.getCorrect()==false)
			ww.add(temp.getWord());
		}
	}
	
	public void selectLanguage(String language) {
		d.loadDictionary(language);
	}
	
	public Dictionary getD() {
	 return d;
	}

}
