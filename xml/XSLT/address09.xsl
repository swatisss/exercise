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
               <tr><th>氏名</th><th>ふりがな</th></tr>
                  <xsl:for-each select="addressList/person">
                     <tr>
         <xsl:if test="kana[contains(text(),&apos;こ&apos;)] or kana[contains(text(),&apos;ろう&apos;)]">
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="kana"/></td>
               </xsl:if>
                     </tr>
                  </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
