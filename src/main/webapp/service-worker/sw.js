var cacheName = 'GWT-PWA';  
var filesToCache = [  
                     '/pwademo.html',  
                     '/pwademo.css',  
                     '/styles/app-theme.html',  
                     '/styles/shared-styles.html', 
                     '/dev-imports.html',
                     '/manifest.json', 
                     '/pwademo/bower_components/paper-drawer-panel/paper-drawer-panel.html',
                     '/pwademo/bower_components/iron-icons/iron-icons.html',
                     '/pwademo/bower_components/iron-icons/maps-icons.html',
                     '/pwademo/bower_components/iron-pages/iron-pages.html',
                     '/pwademo/bower_components/iron-selector/iron-selector.html',
                     '/pwademo/bower_components/paper-button/paper-button.html',
                     '/pwademo/bower_components/paper-icon-button/paper-icon-button.html',
                     '/pwademo/bower_components/paper-item/paper-item.html',
                     '/pwademo/bower_components/paper-material/paper-material.html',
                     '/pwademo/bower_components/paper-menu/paper-menu.html',
                     '/pwademo/bower_components/paper-scroll-header-panel/paper-scroll-header-panel.html',
                     '/pwademo/bower_components/paper-styles/typography.html',
                     '/pwademo/bower_components/paper-toast/paper-toast.html',
                     '/pwademo/bower_components/paper-toolbar/paper-toolbar.html',
                     '/pwademo/bower_components/paper-card/paper-card.html',
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

self.addEventListener('fetch', function(e) {  
	  console.log('[ServiceWorker] Fetch', e.request.url);  
	  e.respondWith(  
	    caches.match(e.request).then(function(response) {  
	      return response || fetch(e.request);  
	    })  
	  );  
	});