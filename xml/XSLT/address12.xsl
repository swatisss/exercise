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
               <tr><th>氏名</th><th>メアド</th><th>関係</th></tr>
                  <xsl:for-each select="addressList/person">
                     <xsl:sort select="name/@group" order="descending" data-type="text"/>
                     <tr>
                     <xsl:choose>
                        <xsl:when test="name/@group=&apos;S&apos;">
                           <td><xsl:value-of select="name"/></td>
                           <td><xsl:value-of select="email"/></td>
                           <td>学校関係</td>
                        </xsl:when>
                        <xsl:when test="name/@group=&apos;F&apos;">
                           <td><xsl:value-of select="name"/></td>
                           <td><xsl:value-of select="email"/></td>
                           <td>友達</td>
                        </xsl:when>
                        <xsl:when test="name/@group=&apos;E&apos;">
                           <td><xsl:value-of select="name"/></td>
                           <td><xsl:value-of select="email"/></td>
                           <td>その他</td>
                        </xsl:when>
                        <xsl:when test="name/@group=&apos;B&apos;">
                           <td><xsl:value-of select="name"/></td>
                           <td><xsl:value-of select="email"/></td>
                           <td>アルバイト関係</td>
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
