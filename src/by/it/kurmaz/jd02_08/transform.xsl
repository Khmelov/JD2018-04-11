<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Clients">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Clients</title>
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
                            Address
                        </td>
                        <td>
                            Carma
                        </td>
                        <td>
                            Cost
                        </td>
                        <td>
                            Order
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Clients/Client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Clients/Client/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Carma">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Address">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Order/Cost">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Order/Content">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>