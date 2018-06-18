<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html lang="en">

            <body>
                <head>
                    <meta charset="UTF-8"/>
                    <title>Persons</title>
                </head>
                <table border="1">
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Phone
                        </td>
                        <td>
                            Password
                        </td>
                        <td>
                            Address
                        </td>
                        <td>
                            Legos
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Costumer/Costumer">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Legos">
        <td><xsl:apply-templates/><tr></tr></td>
    </xsl:template>

</xsl:stylesheet>