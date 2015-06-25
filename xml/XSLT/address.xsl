<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <html>
         <head>
            <title>住所録</title>
         </head>
         <body>
            <h1>住所録</h1>
            <table border="1">
            <tr><th>氏名</th><th>都道府県</th><th>住所</th><th>電話番号</th></tr>
               <xsl:for-each select="addressList/person">
                  <xsl:sort select="prefCode" data-type="text"/>
                  <xsl:sort select="address" data-type="text"/>
                  <tr>
                     <td><xsl:value-of select="name"/></td>
                     <td><xsl:value-of select="prefCode"/></td>
                     <td><xsl:value-of select="address"/></td>
                     <td><xsl:value-of select="phone"/></td>
                  </tr>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
