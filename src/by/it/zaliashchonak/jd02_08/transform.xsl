<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/Clients">
        <table border="1"><xsl:apply-templates/></table>
    </xsl:template>
    <xsl:template match="/Clients/Client/Nickname">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Clients/Client/Password">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Clients/Client/Email">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Clients/Client/Ads/Ad">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Ads/Ad/Product">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Ads/Ad/Price">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Ads/Ad/Description">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
</xsl:stylesheet>