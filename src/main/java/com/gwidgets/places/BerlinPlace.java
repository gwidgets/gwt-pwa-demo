package com.gwidgets.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BerlinPlace extends Place{
	
	private String name;

	public BerlinPlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("")
	 public static class Tokenizer implements PlaceTokenizer<BerlinPlace> {
	        @Override
	        public String getToken(BerlinPlace place) {
	            return place.getName();
	        }

	        @Override
	        public BerlinPlace getPlace(String token) {
	            return new BerlinPlace(token);
	        }
	    }

}
