<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Persons">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Persons</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>
                            Login
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Ads
                        </td>
                        <td>
                            Description
                        </td>
                        <td>
                            Adress
                        </td>
                        <td>
                            Price
                        </td>
                        <td>
                            Area
                        </td>
                        <td>
                            Floor
                        </td>
                        <td>
                            Floors
                        </td>
                        <td>
                            Rooms
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Persons/Person">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Persons/Person/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Adress">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Area">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Floor">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Floors">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Persons/Person/Ads/Ad/Rooms">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>