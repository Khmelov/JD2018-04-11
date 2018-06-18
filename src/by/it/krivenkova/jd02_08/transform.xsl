<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Persons">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Users</title>
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
                            Surname
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Patronymic
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Routes
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Users/User">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Users/User/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Routes">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>