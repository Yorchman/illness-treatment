<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
   <html>
   <p><b><xsl:value-of select="//name" /></b></p>
   <p><b>Seguridad_Social: </b><xsl:value-of select="//seguridadSocial" /></p>
   <p><b>last longing Side Effects:</b></p>
   <table border="1">
      <th>name</th>
      <th>duration</th>
      <th>area</th>
      <xsl:for-each select="Medicines/SideEffects/SideEffect">
      <xsl:sort select="@name" />
         <xsl:if test="salary &gt; 5">
            <tr>
            <td><i><xsl:value-of select="@name" /></i></td>
            <td><xsl:value-of select="@duration" /></td>
            <td><xsl:value-of select="area" /></td>
            </tr>
         </xsl:if>
      </xsl:for-each>
   </table>
   </html>
</xsl:template>

</xsl:stylesheet>