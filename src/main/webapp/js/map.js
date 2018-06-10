let map;


function initMap() {
	const CITY_ZOOM_LEVEL = 10;
	
    let mapDomElement = document.getElementById('youAreHereWeAreNot');
    
    let mapOtions = {
        center: {
            lat:  40.68928987060899, // default location: Statue of Liberty
            lng: -74.04453232884407
        },
        zoom: CITY_ZOOM_LEVEL
    }
    
    map = new google.maps.Map( mapDomElement, mapOtions );
}



function showMarkerList( geoCoordinatesList ) {
	for (let i=0;   i < geoCoordinatesList.length;   i++) {
		showMarker( geoCoordinatesList[i] );
		console.log(i, geoCoordinatesList[i]);
	}
	
}


function convertToGoogleMapCoordinateFormat( geoCoordinates ) {
	return {
			lat: geoCoordinates.latitude,
			lng: geoCoordinates.longitude 
	};
}



function showCaptionMap( caption, geoCoordinates ) {
	let infoWindow = new google.maps.InfoWindow( {map: map} );
	infoWindow.setPosition( convertToGoogleMapCoordinateFormat( geoCoordinates ) );
	infoWindow.setContent( caption );
}



function showMarker( geoCoordinates ) {
	let marker = new google.maps.Marker({
		position: convertToGoogleMapCoordinateFormat( geoCoordinates ),
		map: map
	});
}



function updateMap( geoCoordinates ) {
	const STREET_ZOOM_LEVEL = 15;
	map.setZoom( STREET_ZOOM_LEVEL )
	map.setCenter( convertToGoogleMapCoordinateFormat( geoCoordinates ) );
}
