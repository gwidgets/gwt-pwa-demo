var cacheName = 'GWT-PWA';  
var filesToCache = [  
                     '/pwademo.html',  
                     '/pwademo.css',  
                     '/styles/app-theme.html',  
                     '/styles/shared-styles.html',  
                     '/leaflet/leaflet.js',  
                     '/leaflet/leaflet.css',
                     '/image/mapicon.png',
                      '/pwademo/pwademo.nocache.js'];

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