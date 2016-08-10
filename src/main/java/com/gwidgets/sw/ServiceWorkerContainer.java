package com.gwidgets.sw;

import com.vaadin.polymer.elemental.Promise;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative=true, name="serviceWorker")
public class ServiceWorkerContainer {
	
	@JsMethod
	public native String toString();
	
	@JsMethod
	public native Promise register(String scriptName);

}
