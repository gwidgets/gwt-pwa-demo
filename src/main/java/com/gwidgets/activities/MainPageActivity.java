package com.gwidgets.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwidgets.client.ClientFactory;
import com.gwidgets.places.ParisPlace;
import com.gwidgets.places.BerlinPlace;
import com.gwidgets.places.LondonPlace;
import com.gwidgets.ui.MainAreaElement;
import com.gwidgets.ui.MenuElement;

public class MainPageActivity extends AbstractActivity{
	
	MainAreaElement mainArea;
	MenuElement menu;
	PlaceController controller;
	
	public MainPageActivity(ClientFactory factory, Place place) {
		this.mainArea = factory.getMainAreaElement();
		this.menu = factory.getMenuElement();
		this.controller = factory.getPlaceController();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus bus) {

		
	}
	
	public void refreshPlace(Place place){
		
		if(place instanceof BerlinPlace){
			placeChangeWithoutClickEvent("berlin");
		}else if(place instanceof ParisPlace){
			placeChangeWithoutClickEvent("paris");
		}else if(place instanceof LondonPlace){
			placeChangeWithoutClickEvent("london");
		}
		
	}

	public void placeChangeWithoutClickEvent(String placeName) {
		menu.getPaperMenu().select("contact");
		mainArea.getIronPages().select(placeName);	
	}



}
