package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	private List<String> dictionary;
	
	
	
	public Dictionary() {
		super();
		this.dictionary = new ArrayList<String>();
		
	}

	public void loadDictionary(String language) {
		dictionary.clear();
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				dictionary.add(word);
			}
				br.close();
		} 
		catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	/**
	 * il metodo di usare la contains per creare il costruttore evita di ciclare con if e else 
	 * @param inputTextList la lista che viene presa da textA1
	 * @return un elenco di parole richList che indicano se la parol è corretta o no;
	 */
			public List<RichWord> spellCheckText(List<String> inputTextList){
				List<RichWord> list= new LinkedList<RichWord>();
				
				for(String temp : inputTextList) {
					RichWord rx  = new RichWord(temp,dictionary.contains(temp));   
						list.add(rx);
				}
				return list;
		}

	public List<String> getDictionary() {
		return dictionary;
	}
			
			
	}


	


