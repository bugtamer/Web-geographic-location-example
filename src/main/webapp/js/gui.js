function updateGUI( serverResponse ) {
	const CAPTION_MAP = '<div class="captionMap">You are here.<br>We are not.</div>';
	let geoCoordinates = serverResponse.origin;
	updateMap( geoCoordinates );
	showCaptionMap( CAPTION_MAP, geoCoordinates );
	showMarker( geoCoordinates );
	showMarkerList( serverResponse.nearbyLocations );
	
	document.getElementById( 'latitude'  ).innerText = geoCoordinates.latitude;
	document.getElementById( 'longitude' ).innerText = geoCoordinates.longitude;
	document.getElementById( 'accuracy'  ).innerText = geoCoordinates.accuracy;
	document.getElementById( 'timestamp' ).innerText = geoCoordinates.timestamp;
	
	document.getElementById( 'serverResponse' ).innerText = JSON.stringify( serverResponse );
}



function logError( err ) {
	let msg = `ERROR(${err.code}): ${err.message}`;
	console.warn( msg );
	console.warn( 'ERROR', err );
	document.getElementById( 'browserResponse' ).innerText = msg;
}



(function () {
	getCurrentGeolocation( updateGUI, logError );
})();