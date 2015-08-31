<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <html>
         <head>
            <title>復習</title>
         </head>
         <body>
            <table border="1">
               <tr><th>氏名</th><th>都道府県</th><th>住所</th></tr>
               <xsl:apply-templates select="addressList"/>
            </table>
         </body>
      </html>
   </xsl:template>

   <xsl:template match="addressList">
      <xsl:for-each select="person">
         <xsl:sort select="name/@group" data-type="text"/>
            <tr>
               <td><xsl:value-of select="name"/></td>
               <td><xsl:value-of select="name/@group"/></td>
               <td><xsl:value-of select="email"/></td>
            </tr>
      </xsl:for-each>
   </xsl:template>
</xsl:stylesheet>
