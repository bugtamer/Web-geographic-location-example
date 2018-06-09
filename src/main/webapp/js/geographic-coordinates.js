function getCurrentGeoCoords(successCallback, errorCallback) {
    let success = (function (geoCoords) {
        let connData = {
            url: `http://${window.location.host}/gis/store-geolocation`,
            type: 'POST',
            data: {
                latitude:  geoCoords.coords.latitude,  // decimal
                longitude: geoCoords.coords.longitude, // decimal
                accuracy:  geoCoords.coords.accuracy,  // meters
                timestamp: + new Date()                // miliseconds
            }
        };
        
        $.ajax( connData ).done( successCallback ).fail( errorCallback );
    });
    

    let options = {
        enableHighAccuracy: true,
        timeout:            5000,
        maximumAge:            0
    };
    
    
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(success, errorCallback, options);
    } else {
    	let errorMsg = {code: 0, message: "Your browser do not support geolocation"};
    	errorCallback( errorMsg );
    }
}