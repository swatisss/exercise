<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" encoding="utf-8"/>
<xsl:template match="/">
   <html>
      <head>
         <title>練習23</title>
      </head>
   <body>
      <h1>ポケモンデータベース</h1>
         <xsl:apply-templates select="zukann/pokemon"/>
   </body>
   </html>
</xsl:template>
<xsl:template match="pokemon">
   <table border="1">
      <tr><th>画像</th><th>ポケモン</th><th>分類</th><th>たまごグループ</th></tr>
      <tr>
         <td>
            <xsl:element name="img">
                  <xsl:attribute name="src">
                     <xsl:value-of select="./image"/>
                  </xsl:attribute>
            </xsl:element>
         </td>
         <td>図鑑No:<xsl:value-of select="./no"/><p><xsl:value-of select="./name"/></p></td>
         <td><xsl:value-of select="./group"/></td>
         <td><xsl:for-each select="./egggroup"><p><xsl:value-of select="node()"/></p></xsl:for-each></td>
      </tr>
   </table>
</xsl:template>
</xsl:stylesheet>
