<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:template match="/">
FieldName, Level, Position, Storage-Length, redefines, redefined, occurs
<xsl:for-each select="//item">
<xsl:value-of select="concat(@name, ',', @level, ',', @position, ',', @storage-length, ',', @redefines, ',', @redefined, ',', @occurs, '&#xA;')"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>