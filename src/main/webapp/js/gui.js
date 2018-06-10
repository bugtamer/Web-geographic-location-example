function updateGUI( geoCoordinates ) {
	updateMap( geoCoordinates );
	setCaptionMap( 'You are here. We are not', geoCoordinates );
	
	document.getElementById( 'latitude'  ).innerText = geoCoordinates.latitude;
	document.getElementById( 'longitude' ).innerText = geoCoordinates.longitude;
	document.getElementById( 'accuracy'  ).innerText = geoCoordinates.accuracy;
	document.getElementById( 'timestamp' ).innerText = geoCoordinates.timestamp;
	
	document.getElementById( 'serverResponse' ).innerText = JSON.stringify( geoCoordinates );
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