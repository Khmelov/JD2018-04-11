<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        version="1.0"
>

    <xsl:template match="/Owners">
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
                            email
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Cars
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Owners/Owner">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="Owners/Owner/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="Owners/Owner/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="Owners/Owner/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="Owners/Owner/Cars">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>