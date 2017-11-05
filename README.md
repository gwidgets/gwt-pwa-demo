
## Live Demo

[https://gwt-pwa-demo.herokuapp.com/pwademo.html](https://gwt-pwa-demo.herokuapp.com/pwademo.html) 

## Service worker generation

service worker file (sw.js) is automatically generated during the maven build. Because GWT compiled files names are not known in advance, the generation of the service worker need to be done after the GWT compilation. The [frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin) is used to install node and npm ( only inside the build folder, not globally), and execute `serviceWorkerBuilder.js` which goes through all the files inside the build folder and generates a `sw.js` with the resources ending in `.html`, `.js`, `.css`, `.gif`, `.png`, and `.jpeg`.