<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
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
      <ul>
         <li><xsl:value-of select="text()"/></li>
      </ul>
   </xsl:template>
</xsl:stylesheet>
