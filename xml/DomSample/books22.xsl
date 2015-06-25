<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="utf-8"/>
<xsl:template match="/">
   <html>
      <head>
         <title>練習22</title>
      </head>
   <body>
      <h1>書籍一覧</h1>
         <xsl:apply-templates select="product/book"/>
   </body>
   </html>
</xsl:template>

<xsl:template match="book">
         <xsl:value-of select="./title"/>
         <xsl:element name="img">
            <xsl:attribute name="src">
               <xsl:value-of select="./img"/>
            </xsl:attribute>
            <xsl:attribute name="alt">
               <xsl:value-of select="./title"/>
            </xsl:attribute>
            <xsl:attribute name="width">
               15%
            </xsl:attribute>
         </xsl:element>
</xsl:template>

</xsl:stylesheet>
