<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : search.xsl
    Created on : July 12, 2020, 4:23 PM
    Author     : Duy Phu
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="searchValue"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <xsl:decimal-format name="money" grouping-separator="."/>
        <xsl:for-each select="products/cpu">
            <xsl:variable name="name" select="name"/>
            <xsl:if test="contains($name,$searchValue)">
                
                <div class="products">
                    <div class="product">
                        <img src="{image}" style="width:100%"/>
                        <xsl:choose>
                            <xsl:when test="price &gt; 0">
                                <h3 style="color:red">
                                    <xsl:value-of select='format-number(price, "#.###","money")'/> VNĐ
                                </h3>
                            </xsl:when>
                            <xsl:otherwise>
                                <h3 style="color:red">
                                    Liên hệ
                                </h3>
                            </xsl:otherwise>
                        </xsl:choose>      
                        <p style="color:black">
                            <xsl:value-of select="name"/>
                        </p>                
                        <form action="ProcessServlet">                    
                            <input type="submit" name="btAction" value="Chi tiết" style="width: 40%;border-radius: 12px;bottom : 15px; left: 10px;position: absolute; "/>
                            <input type="hidden" name="idValue" value="$id" />
                        </form>
                        <form action="ProcessServlet">
                            <input type="submit" name="btAction" value="So sánh" style="width: 40%;border-radius: 12px;bottom : 15px; right: 10px;position: absolute; "/>
                            <input type="hidden" name="idValue" value="$id" />
                        </form>
                    </div>
                
                </div>
            </xsl:if>
           
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
