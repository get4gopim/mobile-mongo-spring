<%@ include file="include.jsp"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title><spring:message code="site.title" /></title>

<link href="resources/styles/reset.css" rel="stylesheet" type="text/css" />
<link href="resources/styles/baseStyles.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="resources/scripts/templates.js" /></script>
<script type="text/javascript">
	function init() {
		var myStyleTweaks = new StyleTweaker();
		myStyleTweaks
				.add("Series60/5.0", "/resources/styles/tweaks/S605th.css");
		myStyleTweaks.add("Series60/3.2",
				"/resources/styles/tweaks/S603rdFP2.css");
		myStyleTweaks.add("AppleWebKit/420+",
				"/resources/styles/tweaks/S406th.css");
		myStyleTweaks.add("N900", "/resources/styles/tweaks/maemo.css");
		myStyleTweaks.add("Firefox/3.0a1 Tablet browser 0.3.7",
				"/resources/styles/tweaks/maemo.css");
		myStyleTweaks.add("Opera Mini/4",
				"/resources/styles/tweaks/operamini.css");
		myStyleTweaks.tweak();
	}
	addEvent("onload", init);
</script>
</head>
<body>

		<div id="wrap">
			<div id="header"></div>
			<div id="content">
				<h1><spring:message code="site.header" /></h1>
				<h3>Current Device : ${currentDevice}</h3>
				
				<ul class="list">
					<li><a href="browse.htm">Movie Library</a></li>
					<li><a href="filename.htm?path=addmovie">Add Movie</a></li>
					<li><a href="filename.htm?path=imdbsearch">IMDB Search</a></li>
					<li><a href="filename.htm?path=feedback">Feedback</a></li>
					<li><a href="viewfeeds.htm">View All Feeds</a></li>
					<li><a href="filename.htm?path=signin">Sing In</a></li>
					<li><a href="filename.htm?path=contacts">Contact Us</a></li>
					<li><a href="filename.htm?path=about">About Us</a></li>
					<li><a href="jmxInvoke.htm">Jmx Invoke</a></li>
				</ul>
			</div>
			
			<div id="header"></div>

			<div id="footer" class="ft-large">
				<p>
					<spring:message code="site.copyrights" />
					<a href="http://www.facebook.com/get4gopi"><img border="0"
						alt="Follow us on facebook" src="resources/images/facebook.png" /></a>
					<a href="https://twitter.com/get4gopi"><img border="0"
						alt="Follow us on twitter" src="resources/images/twitter.png" /></a>
				</p>
			</div>
			
		</div>
</body>
</html>