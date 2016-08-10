package com.gwidgets.client;



import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.gwidgets.places.*;


@WithTokenizers({ParisPlace.Tokenizer.class, BerlinPlace.Tokenizer.class, LondonPlace.Tokenizer.class})
public interface MyHistoryMapper extends PlaceHistoryMapper  {

}

