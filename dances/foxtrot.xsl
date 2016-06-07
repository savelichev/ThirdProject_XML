<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:mt="musicType.ua">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Dance description</h2>
                <table border="2" bgcolor="#8470FF">
                    <th align="left">Name</th>
                    <th align="left">Value</th>

                    <tr>
                        <td>Title</td>
                        <td>
                            <xsl:value-of select="dance/@title"/>
                        </td>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td>
                            <xsl:value-of select="dance/@id"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Dance type</td>
                        <td>
                            <xsl:value-of select="//type"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Scene</td>
                        <td>
                            <xsl:value-of select="//scene"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Dancers amount</td>
                        <td>
                            <xsl:value-of select="//numberOfDancers"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Music type</td>
                        <td>
                            <xsl:value-of select="//mt:music"/>
                        </td>

                    </tr>
                    <xsl:for-each select="//dancer">
                        <tr>
                            <td>Danser</td>
                            <td>
                                <xsl:apply-templates/>
                            </td>
                        </tr>
                    </xsl:for-each>
                    <tr>

                        <td>Number of action</td>
                        <td>
                            <xsl:value-of select="//number"/>
                        </td>
                    </tr>


                </table>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>