package com.gwidgets.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class ParisPlace extends Place {
	
	private String name;

	public ParisPlace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Prefix("!")
	 public static class Tokenizer implements PlaceTokenizer<ParisPlace> {
	        @Override
	        public String getToken(ParisPlace place) {
	            return place.getName();
	        }

	        @Override
	        public ParisPlace getPlace(String token) {
	            return new ParisPlace(token);
	        }
	    }
	
	

}
