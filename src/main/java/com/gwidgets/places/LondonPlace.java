package com.gwidgets.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LondonPlace extends Place{
	

	private String name;

	public LondonPlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("�")
	 public static class Tokenizer implements PlaceTokenizer<LondonPlace> {
	        @Override
	        public String getToken(LondonPlace place) {
	            return place.getName();
	        }

	        @Override
	        public LondonPlace getPlace(String token) {
	            return new LondonPlace(token);
	        }
	    }

}
