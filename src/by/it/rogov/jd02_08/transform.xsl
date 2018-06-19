<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/Users">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Persons</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            LastName
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Phone
                        </td>
                        <td>
                            JAXP
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Users/Client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Users/Client/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/Client/LastName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/Client/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Users/Client/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Users/Client/phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Users/Client/JAXP">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>