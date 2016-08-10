package com.gwidgets.ui;

import com.google.gwt.core.client.GWT;
import com.gwidgets.api.leaflet.L;
import com.gwidgets.api.leaflet.Map;

public class Maps {

	public static final String MAP_URL = "https://api.mapbox.com/styles/v1/g-widgets/ciqy0cpax0012cfm8vx7ptrz9/tiles/256/{z}/{x}/{y}"
			+ "?access_token=pk.eyJ1IjoiZy13aWRnZXRzIiwiYSI6ImNpcXV5YzdyajAwNmRoeG0zbm80c3d4Y3IifQ.eyVA2x_DJG_bzDObhnjaTA";

	public static void initializeBerlinMap() {

		Map berlin = L.map("berlinMap", null);
	
		L.tileLayer(MAP_URL, null).addTo(berlin);
		berlin.setView(L.latLng(52.51, 13.40), 12, null);

	}

	public static void initializeParisMap() {

		Map paris = L.map("parisMap", null);
		
		L.tileLayer(MAP_URL, null).addTo(paris);
		paris.setView(L.latLng(48.876905, 2.376050), 12, null);


	}

	public static void initializeLondonMap() {

		Map london = L.map("londonMap", null);
		
		L.tileLayer(MAP_URL, null).addTo(london);
		london.setView(L.latLng(51.518112, -0.070906), 12, null);
		

	}


}
