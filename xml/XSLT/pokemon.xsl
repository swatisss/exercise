<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <xsl:apply-templates select="zukann/pokemon"/>
   </xsl:template>

   <xsl:template match="pokemon">

         <ul>
            <li><xsl:value-of select="no"/></li>
            <li><xsl:value-of select="name"/></li>
            <xsl:apply-templates select="type"/>
         </ul>
   </xsl:template>

   <xsl:template match="type">
      <li><xsl:value-of select="."/></li>
   </xsl:template>
</xsl:stylesheet>
