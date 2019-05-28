<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />
<xsl:template match="/">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>YOUR TITLE HERE!</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="header">
  <div class="header_interior"><img src="images/logo.gif" alt="Logo" width="44" height="44" style="float:left; margin-right:10px;" /> 
  <h1 class="title">IandD.com</h1></div>
</div>
<div class="content_body">
  <div class="content_interior"><div class="left_column"><div class="navigation">
 <ul class="markermenu">
<li class="markermenu"><a href="/index.html" >Home</a></li>
<li class="markermenu"><a href="/index.html" >About</a></li>
<li class="markermenu"><a href="/index.html">Link 1</a></li>
<li class="markermenu"><a href="/index.html">Link 2</a></li>
<li class="markermenu"><a href="/index.html" style="border-bottom-width: 0">Link 3</a></li>		
</ul> </div>

<div class="navigationbtm"></div>
 <br />
 <img src="images/DavidHasselhoff.jpg" alt="sample 2"  width="180" height="180" style="float:left; margin-right:10px;"  />
 </div>
    <div class="right_column">
      <h1>SideEffects with long duration</h1>
      <p><b><xsl:value-of select="//name" /></b></p>
   <p><b>Seguridad_Social: </b><xsl:value-of select="//seguridadSocial" /></p>
   <p><b>last longing Side Effects:</b></p>
   <table border="1">
      <th>name</th>
      <th>duration</th>
      <th>area</th>
      <xsl:for-each select="Medicines/SideEffects/SideEffect">
      <xsl:sort select="@name" />
         <xsl:if test="duration &gt; 7">
            <tr>
            <td><i><xsl:value-of select="@name" /></i></td>
            <td><xsl:value-of select="@duration" /></td>
            <td><xsl:value-of select="area" /></td>
            </tr>
         </xsl:if>
      </xsl:for-each>
   </table>
		<div class="hr"></div>
		<h2> 
        </h2>
		    <h1>SideEffects with short duration</h1>
      <p><b><xsl:value-of select="//name" /></b></p>
   <p><b>Seguridad_Social: </b><xsl:value-of select="//seguridadSocial" /></p>
   <p><b>last longing Side Effects:</b></p>
   <table border="1">
      <th>name</th>
      <th>duration</th>
      <th>area</th>
      <xsl:for-each select="Medicines/SideEffects/SideEffect">
      <xsl:sort select="@name" />
         <xsl:if test="duration &lt; 7">
            <tr>
            <td><i><xsl:value-of select="@name" /></i></td>
            <td><xsl:value-of select="@duration" /></td>
            <td><xsl:value-of select="area" /></td>
            </tr>
         </xsl:if>
      </xsl:for-each>
   </table>
		<div class="hr"></div>
		
	</div>
  </div>
<br clear="all" /></div>
<div class="footer"><div class="footer-inner"><div class="footer-div"><h4>Link Area</h4>
<ul>
<li><a href="/index.html">Link 1</a></li>
<li><a href="/index.html">Link 2
</a></li>
<li><a href="/index.html">Link 3
</a></li>
</ul>
</div>

    <div class="footer-div">
      <h4>Link Area</h4>
      <ul>
        <li><a href="/index.html">Link 1</a> </li>
        <li><a href="/index.html">Link 2 </a> </li>
        <li><a href="/index.html">Link 3 </a> </li>
      </ul>
    </div>
    <div class="footer-div">
      <h4>Link Area</h4>
      <ul>
        <li><a href="/index.html">Link 1</a> </li>
        <li><a href="/index.html">Link 2 </a> </li>
        <li><a href="/index.html">Link 3 </a> </li>
      </ul>
    </div>
    <div class="footer-div">
      <h4>Link Area</h4>
      <ul>
        <li><a href="/index.html">Link 1</a> </li>
        <li><a href="/index.html">Link 2 </a> </li>
        <li><a href="/index.html">Link 3 </a> </li>
      </ul>
    </div>
    <br clear="all" />
<hr width="100%"  noshade="noshade" style="border-top:1px solid #FFFFFF; border-bottom: none; margin-bottom:5px;" />
<div style="text-align:center;">Copyright © 2006 YourName | <!-- Please don't remove -->Designed by: <a href="http://www.allfinancedirectory.com/">Finance Directory</a><!-- Thanks Again --> </div>
</div><br clear="all" /></div>
</body>
</html>
</xsl:template>

</xsl:stylesheet>
