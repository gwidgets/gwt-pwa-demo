package com.gwidgets.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.gwidgets.ui.MainAreaElement;
import com.gwidgets.ui.MenuElement;


public interface ClientFactory {
     EventBus getEventBus();
     PlaceController getPlaceController();
     MenuElement getMenuElement();
     MainAreaElement getMainAreaElement();
}
