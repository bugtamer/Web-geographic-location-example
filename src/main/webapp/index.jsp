<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/map.css">
    <title>GIS</title>
</head>
<body>
    <section class="center">
    	<h1>GIS</h1>
    	
	    <ul>
	    	<li>
	    		<b>Latitude:</b>
	    		<span id="latitude"></span>
	    		<span title="Decimal Degrees">DD</span>
	    	</li>
	    	<li>
	    		<b>Longitude:</b>
	    		<span id="longitude"></span>
	    		<span title="Decimal Degrees">DD</span>
	    	</li>
	    	<li>
	    		<b>Accuracy:</b>
	    		<span id="accuracy"></span>
	    		<span title="meters">m</span>
	    	</li>
	    	<li>
	    		<b>Timestamp:</b>
	    		<span id="timestamp"></span>
	    		<span title="milliseconds">ms</span>
	    	</li>
	    </ul>
	    
	    <div>
	    	<b>Browser response:</b>
	    	<pre id="browserResponse"></pre>
	    </div>
	    
	    <div>
	    	<b>Server response:</b>
	    	<pre id="serverResponse"></pre>
	    </div>
	    
	    <p>
	    	<b>Tip:</b> reload this page to be asked again about location access authorization.
	    </p>
	    
	    <div id="youAreHereWeAreNot"></div>
    </section>
    
    
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/geographic-coordinates.js"></script>
    <script src="./js/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=${googleApiKey}&callback=initMap"></script>
    <script src="./js/gui.js"></script>
</body>
</html>