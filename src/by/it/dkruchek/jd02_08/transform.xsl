<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/Company">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Company</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>
                            Lastname
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Middlename
                        </td>
                        <td>
                            Title
                        </td>
                        <td>
                            Email
                        </td>
                        <td>
                            Password
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee | /Company/Departments/Department/Manager | /Company/Departments/Department/Units/Unit/Manager">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Lastname | /Company/Departments/Department/Manager/Lastname | /Company/Departments/Department/Units/Unit/Manager/Lastname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Name | /Company/Departments/Department/Manager/Name | /Company/Departments/Department/Units/Unit/Manager/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Middlename | /Company/Departments/Department/Manager/Middlename | /Company/Departments/Department/Units//Unit/Manager/Middlename">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Title | /Company/Departments/Department/Manager/Title | /Company/Departments/Department/Units/Unit/Manager/Title">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Email | /Company/Departments/Department/Manager/Email | /Company/Departments/Department/Units/Unit/Manager/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Company/Departments/Department/Units/Unit/Employees/Employee/Password  | /Company/Departments/Department/Manager/Password | /Company/Departments/Department/Units/Unit/Manager/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>