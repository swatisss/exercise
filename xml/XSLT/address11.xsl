<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <html>
         <head>
            <title>住所録</title>
         </head>
         <body>
            <h1>好きなもの</h1>
            <table border="1">
               <tr><th>氏名</th><th colspan="2">メモ</th></tr>
                  <xsl:for-each select="addressList/person">
                     <tr>
                        <td><xsl:value-of select="name"/></td>
                     <xsl:choose>
                        <xsl:when test="memo/hobby">
                           <td><xsl:value-of select="memo/text()"/></td>
                           <td><strong><xsl:value-of select="memo/hobby"/></strong></td>
                        </xsl:when>
                        <xsl:when test="memo/favorite">
                           <td><xsl:value-of select="memo/text()"/></td>
                           <td><cite><xsl:value-of select="memo/favorite"/></cite></td>
                        </xsl:when>
                        <xsl:otherwise>
                           <td colspan="2"><div align="center">なし</div></td>
                        </xsl:otherwise>
                     </xsl:choose>
                     </tr>
                  </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
