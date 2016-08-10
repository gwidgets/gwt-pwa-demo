package com.gwidgets.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Document;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.iron.IronPagesElement;

public class MainAreaElement {
	
	IronPagesElement ironPages;
	
	boolean londonMapInitialized = false;
	
	boolean parisMapInitialized = false;
	
	public MainAreaElement(){
		
		ironPages = (IronPagesElement) Polymer.getDocument().getElementById("ironPages");
		
		loadStartupMap();
		
		
		//Maps are not loaded on start up, but only when iron selector selects a new map
		ironPages.addEventListener("iron-select", e -> {
			 
			if(ironPages.getSelected().equals("london") && !londonMapInitialized){
				
				//Some code splitting to reduce initial module size
				GWT.runAsync(new RunAsyncCallback(){
					@Override
					public void onFailure(Throwable reason) {
						Document.get().getElementById("londonMap").setInnerHTML("Could not load this map, please try again later");
					}

					@Override
					public void onSuccess() {
						Maps.initializeLondonMap();
						
					}});
				londonMapInitialized = true;
			}else if(ironPages.getSelected().equals("paris") && !parisMapInitialized){
				//Some code splitting to reduce initial module size
				GWT.runAsync(new RunAsyncCallback(){

					@Override
					public void onFailure(Throwable reason) {
						Document.get().getElementById("parisMap").setInnerHTML("Could not load this map, please try again later");
					}

					@Override
					public void onSuccess() {
						Maps.initializeParisMap();
					}
					
					
				});
				parisMapInitialized = true;
			}
		});
		
		
	}

	public IronPagesElement getIronPages() {
		return this.ironPages;
	}
	
	
	private void loadStartupMap(){
		
		Maps.initializeBerlinMap();
		
		
	}

}
