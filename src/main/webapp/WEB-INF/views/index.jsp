<%@ include file="include.jsp"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title><spring:message code="site.title" /></title>
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
		<div id="header">
			<h1>
				<spring:message code="site.header" />
				<h3>${currentDevice}</h3>
			</h1>
		</div>
		
		<!-- <div id="content">
			<ul class="list">
				<li><img alt="Browse" src="resources/images/browse.png" /><a href="browse.htm">Movie Library</a></li>
				<li><img alt="Add" src="resources/images/cd_add.png" /><a href="filename.htm?path=addmovie">Add Movie</a></li>
				<li><img alt="" src="resources/images/contact.png" /><a href="filename.htm?path=contacts">Contact us</a></li>
				<li><img alt="" src="resources/images/about.png" /><a href="filename.htm?path=about">About us</a></li>
			</ul>
		</div> -->
		
		<div>
			<table>
				<tr>
		    		<td><img alt="Browse" src="resources/images/browse.png" /></td>
		    		<td><a href="browse.htm">Movie Library</a></td>
		    	</tr>
		    	<tr>
		    		<td><img alt="Add" src="resources/images/cd_add.png" /></td>
		    		<td><a href="filename.htm?path=addmovie">Add Movie</a></td>
		    	</tr>
		    	<tr>
		    		<td><img alt="" src="resources/images/contact.png" /></td>
		    		<td><a href="filename.htm?path=contact">Contact Us</a></td>
		    	</tr>
		    	<tr>
		    		<td><img alt="" src="resources/images/about.png" /></td>
		    		<td><a href="filename.htm?path=about">About Us</a></td>
		    	</tr>
	    	</table>
		</div>
		
		<div id="footer" class="ft-large">
			<p>
				<spring:message code="site.copyrights" />
				<a href="http://www.facebook.com/get4gopi"><img border="0" alt="Follow us on facebook" src="resources/images/facebook.png" /></a>
				<a href="https://twitter.com/get4gopi"><img border="0" alt="Follow us on twitter" src="resources/images/twitter.png" /></a>
			</p>
		</div>
	</div>
</body>
</html>