<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <html>
         <head>
            <title>住所録</title>
         </head>
         <body>
            <h1>男性のアドレス</h1>
            <table border="1">
               <tr><th>氏名</th><th>メール</th><th>性別</th></tr>
               <xsl:for-each select="addressList/person">
                  <xsl:if test="name/@group= &apos;B&apos;">
                  <tr>
                     <td><xsl:value-of select="name"/></td>
                     <td><xsl:value-of select="email"/></td>
                     <td><xsl:value-of select="name/@group"/></td>
                  </tr>
               </xsl:if>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
