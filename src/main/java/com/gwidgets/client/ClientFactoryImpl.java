package com.gwidgets.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.gwidgets.ui.MainAreaElement;
import com.gwidgets.ui.MenuElement;

public class ClientFactoryImpl implements ClientFactory {
	
	
	EventBus eventBus = new SimpleEventBus();
	PlaceController controller = new PlaceController(eventBus);
	
MainAreaElement mainArea = new MainAreaElement();
	MenuElement menu = new MenuElement(controller, mainArea);
   
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return controller;
	}

	@Override
	public MenuElement getMenuElement() {
		return menu;
	}

	@Override
	public MainAreaElement getMainAreaElement() {
		return this.mainArea;
	}

}
