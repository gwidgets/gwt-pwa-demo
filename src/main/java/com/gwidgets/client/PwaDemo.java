package com.gwidgets.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.gwidgets.places.BerlinPlace;
import com.gwidgets.sw.Navigator;
import com.vaadin.polymer.elemental.Function;

public class PwaDemo implements EntryPoint {
	private BerlinPlace homePlace = new BerlinPlace("berlin");
	private SimplePanel appWidget = new SimplePanel();

	@Override
	public void onModuleLoad() {

		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		PlaceController controller = clientFactory.getPlaceController();

		EventBus bus = clientFactory.getEventBus();
		ActivityMapper activityMapper = new MyActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, bus);
		activityManager.setDisplay(appWidget);

		MyHistoryMapper historyMapper = GWT.create(MyHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(controller, bus, homePlace);

		historyHandler.handleCurrentHistory();

		if (Navigator.serviceWorker != null) {
			Navigator.serviceWorker.register("sw.js")
					.then(new Function<JavaScriptObject, JavaScriptObject>() {
						@Override
						public JavaScriptObject call(JavaScriptObject arg) {
							GWT.log("registred service worker successfully");
							return null;
						}
					});
		} else {
			GWT.log("service worker unavailable in this browser");
		}

	}

}
