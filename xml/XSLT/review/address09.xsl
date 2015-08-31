<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="html" encoding="utf-8"/>
   <xsl:template match="/">
      <html>
         <head><title>復習</title></head>
         <body>
            <table border="1">
               <tr><th>氏名</th><th>メモ</th></tr>
               <xsl:apply-templates select="addressList/person"/>
            </table>
         </body>
      </html>
   </xsl:template>

   <xsl:template match="person">
      <xsl:if test="kana[contains(text(),&apos;こ&apos;)] and not(name[contains(text(),&apos;田&apos;)])">
         <tr>
            <td><xsl:value-of select="name"/></td>
         </tr>
      </xsl:if>
   </xsl:template>
</xsl:stylesheet>
