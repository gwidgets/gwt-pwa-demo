package com.gwidgets.sw;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import static jsinterop.annotations.JsPackage.GLOBAL;

@JsType(isNative=true, namespace= GLOBAL, name="navigator")
public class Navigator {
	
	@JsProperty
	public static ServiceWorkerContainer serviceWorker;
	
	

}
