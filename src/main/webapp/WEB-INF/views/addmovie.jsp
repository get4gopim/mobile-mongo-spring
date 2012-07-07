<%@ include file="include.jsp"%>

<!DOCTYPE html>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
<form action="addmovie.htm" method="post" id="addMovieForm">
	<div id="wrap">
		<div id="header"></div>
		
		<h3>Add Movie Request</h3>
		<table>
	  		<caption>
	    		Enter all the movie information
	  		</caption>
	 		
	 		<tr>
	    		<td>Movie Name</td>
	    		<td><input name="title" id="title" type="text" value="<c:if test="${movie != null}">${movie.title}</c:if>" /></td>
	    	</tr>	
	  		<tr>
	    		<td>Actor Name</td>
	    		<td><input name="actor" id="actor" type="text" value="<c:if test="${movie != null}">${movie.actorName}</c:if>" /></td>
	    	</tr>
	    	<tr>
	    		<td>Actress Name</td>
	    		<td><input name="actress" id="actress" type="text" value="<c:if test="${movie != null}">${movie.actressName}</c:if>" /></td>
	    	</tr>
	    	<tr>
	    		<td>Directed By</td>
	    		<td><input name="director" id="director" type="text" value="<c:if test="${movie != null}">${movie.flimDirector}</c:if>" /></td>
	    	</tr>
	    	<tr>
	    		<td>Music By</td>
	    		<td><input name="music" id="music" type="text" value="<c:if test="${movie != null}">${movie.musicDirector}</c:if>" /></td>
	    	</tr>
	    	<tr>
	    		<c:if test="${movie == null}">
	    			<td colspan="2"><input name="btnAddMovie" id="btnAddMovie" value="Add Movie" type="submit" /></td>
	    		</c:if>
	    		<c:if test="${movie != null}">
	    			<td colspan="2">
	    				<input name="btnAddMovie" id="btnAddMovie" value="Update Movie" type="submit" />
	    				<input name="id" id="id" value="${movie.id}" type="hidden" />
	    			</td>
	    		</c:if>
	    	</tr>		  		
		</table>
		
		<div>
			<table>
				<tr >
		    		<td><a href="index.htm"><img border="0" alt="Home" src="resources/images/home.png" /></a></td>
		    		<td>&nbsp;</td>
		    		<td>&nbsp;</td>
		    		<td><a href="browse.htm"><img border="0" alt="Browse" src="resources/images/browse.png" /></td>
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
</form>	
</body>
</html>