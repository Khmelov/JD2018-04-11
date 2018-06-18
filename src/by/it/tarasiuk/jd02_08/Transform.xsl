<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Sellers">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Sellers</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            Login
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Ads
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Sellers/Seller">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Sellers/Seller/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Sellers/Seller/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Sellers/Seller/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Sellers/Seller/Ads">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>