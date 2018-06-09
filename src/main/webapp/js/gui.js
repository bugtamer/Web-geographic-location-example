function updateGUI(coords) {
	console.log('coords', coords);
	
	document.getElementById("latitude").innerText  = coords.latitude;
	document.getElementById("longitude").innerText = coords.longitude;
	document.getElementById("accuracy").innerText  = coords.accuracy;
	document.getElementById("timestamp").innerText = coords.timestamp;
	
	document.getElementById("serverResponse").innerText = JSON.stringify(coords);
}


function logError(err) {
	document.getElementById("browserResponse").innerText = `ERROR(${err.code}): ${err.message}`;
	console.warn(`ERROR(${err.code}): ${err.message}`);
	console.warn('ERROR', err);
}



(function (){
	getCurrentGeoCoords(updateGUI, logError);
})();