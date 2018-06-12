<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Students">
        <html lang="en">
            <head>
                <title>Students</title>
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
                            FirstName
                        </td>
                        <td>
                            LastName
                        </td>
                        <td>
                            Courses
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>


    <xsl:template match="/Students/Student">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Students/Student/Person/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Person/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Person/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Person/FirstName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Person/SecondName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/CoursesStudent">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>