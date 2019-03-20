package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.SpellModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {
	SpellModel model = new SpellModel();
	
	public void setModel(SpellModel model) {
		this.model = model;
	}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton btnMenu;

    @FXML
    private TextArea textA1;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea textA2;

    @FXML
    private Text errText;

    @FXML
    private Button btnClear;

    @FXML
    private Text timeText;

    @FXML
    void doClearText(ActionEvent event) {
    	textA1.clear();
    	textA2.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
		String[] inserita = textA1.getText().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"?]", "").toLowerCase().split(" ");
    	List<String> scannate = new ArrayList<String>();
    	textA1.clear();
    	for(int i = 0; i<inserita.length; i++) {
    		scannate.add(inserita[i]);
    	}
    
    	model.setWw(scannate);
    	for(String temp : model.getWw()) {
    		textA2.appendText(temp+"\n");
    	}
    	model.setWrong();
    	int err = model.getWrong();
    	errText.setText("Riscontarte "+err+" parole errate");
    	timeText.setText(System.nanoTime()+"ns");
    	btnMenu.setDisable(false);
    	

    }

    @FXML
    void isEnglish(ActionEvent event) {
    	model.selectLanguage("English");
    	btnMenu.setText("English");
    	btnMenu.setDisable(true);
    }

    @FXML
    void isItalian(ActionEvent event) {
    	model.selectLanguage("Italian");
    	btnMenu.setText("Italian");
    	btnMenu.setDisable(true);
    }

    @FXML
    void initialize() {
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert textA1 != null : "fx:id=\"textA1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert textA2 != null : "fx:id=\"textA2\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert errText != null : "fx:id=\"errText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert timeText != null : "fx:id=\"timeText\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}

	   
	










