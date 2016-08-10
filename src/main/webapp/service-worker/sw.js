var cacheName = 'GWT-PWA';  
var filesToCache = [  
                     '/gwt-pwa/pwademo.html',  
                     '/gwt-pwa/pwademo.css',  
                     '/gwt-pwa/styles/app-theme.html',  
                     '/gwt-pwa/styles/shared-styles.html',  
                     '/gwt-pwa/leaflet/leaflet.js',  
                     '/gwt-pwa/leaflet/leaflet.css',
                     '/gwt-pwa/image/mapicon.png',
                      '/gwt-pwa/pwademo/pwademo.nocache.js'];

self.addEventListener('install', function(e) {  
  console.log('[ServiceWorker] Install');  
  e.waitUntil(  
    caches.open(cacheName).then(function(cache) {  
      console.log('[ServiceWorker] Caching app shell');  
      return cache.addAll(filesToCache);  
    })  
  );  
});


self.addEventListener('activate', function(e) {  
	  console.log('[ServiceWorker] Activate');  
	  e.waitUntil(  
	    caches.keys().then(function(keyList) {  
	      return Promise.all(keyList.map(function(key) {  
	        console.log('[ServiceWorker] Removing old cache', key);  
	        if (key !== cacheName) {  
	          return caches.delete(key);  
	        }  
	      }));  
	    })  
	  );  
	});