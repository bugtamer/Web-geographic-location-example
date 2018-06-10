function getCurrentGeolocation( onServerResponseCallback, errorCallback ) {
    
    let onSuccessToServer = (function ( geoCoords ) {
        let connData = {
            url: `http://${window.location.host}/gis/store-geolocation`,
            type: 'POST',
            data: {
                latitude:  geoCoords.coords.latitude,  // decimal degrees
                longitude: geoCoords.coords.longitude, // decimal degrees
                accuracy:  geoCoords.coords.accuracy,  // meters
                timestamp: + new Date()                // milliseconds
            }
        };
        
        $.ajax( connData ).done( onServerResponseCallback ).fail( errorCallback );
    });
    
    
    let options = {
        enableHighAccuracy: true,
        timeout:            5000,
        maximumAge:            0
    };
    
	
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(onSuccessToServer, errorCallback, options);
    } else {
    	let errorMsg = {code: 0, message: "Your browser do not support geolocation"};
    	errorCallback( errorMsg );
    }
    
}