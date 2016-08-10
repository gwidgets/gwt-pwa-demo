package com.gwidgets.ui;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.History;
import com.gwidgets.client.ClientFactory;
import com.gwidgets.places.ParisPlace;
import com.gwidgets.places.BerlinPlace;
import com.gwidgets.places.LondonPlace;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperMenuElement;

public class MenuElement {
	
	PaperMenuElement paperMenu;
	
	AnchorElement paris;
	
	AnchorElement berlin;
	
	AnchorElement london;	
	
	PlaceController controller;
	
	MainAreaElement main;
	
	public MenuElement(PlaceController controller, MainAreaElement main){
		
		this.main = main;
		
		this.controller = controller;
		
		paperMenu = (PaperMenuElement) Polymer.getDocument().getElementById("paperMenu");
		
		paris = (AnchorElement) Document.get().getElementById("parisLink");
		
		berlin = (AnchorElement) Document.get().getElementById("berlinLink");
		
		london = (AnchorElement) Document.get().getElementById("londonLink");
		
		initializeEvents();
	}
	
	
	public void initializeEvents(){
		
		
		Event.sinkEvents(paris, Event.ONCLICK);
		 Event.sinkEvents(berlin, Event.ONCLICK);
		 Event.sinkEvents(london, Event.ONCLICK);
		 
		 Event.setEventListener(paris, e -> {
	            if(Event.ONCLICK == e.getTypeInt()) {
	            	main.getIronPages().select("paris");
	           	 paperMenu.select("paris");
	           	controller.goTo(new ParisPlace("paris"));

	            }  
	        });
		 
		 Event.setEventListener(berlin, e -> {
	            if(Event.ONCLICK == e.getTypeInt()) {
	            	main.getIronPages().select("berlin");
	            	paperMenu.select("berlin");
	            	controller.goTo(new BerlinPlace("berlin"));
	            }  
	        });
		 
		 Event.setEventListener(london, e -> {
           if(Event.ONCLICK == e.getTypeInt()) {
        	  main.getIronPages().select("london");
          	 paperMenu.select("london");
          	controller.goTo(new LondonPlace("london"));
          	    
           }  
  });
		
	}


	public PaperMenuElement getPaperMenu() {
		return this.paperMenu;
	}
	
	
	

}
