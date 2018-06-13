<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Readers">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Readers</title>
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
                            Publications
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Readers/Reader">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Readers/Reader/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Readers/Reader/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Readers/Reader/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Readers/Reader/Publications">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>