package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\" >\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/detail.css\" >\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product Detail</title>\n");
      out.write("    </head>\n");
      out.write("    <body>           \n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <div id=\"header\">Header</div>\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a class=\"active\" href=\"homePage.jsp\">Sản phẩm</a></li>\n");
      out.write("                    <li><a href=\"\">So sánh</a></li>\n");
      out.write("                    <li><a href=\"\">Tìm kiếm</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>       \n");
      out.write("            <div id=\"content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"images\">\n");
      out.write("                        <img src=\"http://mistillas.cl/wp-content/uploads/2018/04/Nike-Epic-React-Flyknit-%E2%80%9CPearl-Pink%E2%80%9D-01.jpg\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"slideshow-buttons\">\n");
      out.write("                        <div class=\"one\"></div>\n");
      out.write("                        <div class=\"two\"></div>\n");
      out.write("                        <div class=\"three\"></div>\n");
      out.write("                        <div class=\"four\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"pick\">choose size</p>\n");
      out.write("                    <div class=\"sizes\">\n");
      out.write("                        <div class=\"size\">5</div>\n");
      out.write("                        <div class=\"size\">6</div>\n");
      out.write("                        <div class=\"size\">7</div>\n");
      out.write("                        <div class=\"size\">8</div>\n");
      out.write("                        <div class=\"size\">9</div>\n");
      out.write("                        <div class=\"size\">10</div>\n");
      out.write("                        <div class=\"size\">11</div>\n");
      out.write("                        <div class=\"size\">12</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"product\">\n");
      out.write("                        <p>Women's Running Shoe</p>\n");
      out.write("                        <h1>Nike Epic React Flyknit</h1>\n");
      out.write("                        <h2>$150</h2>\n");
      out.write("                        <p class=\"desc\">The Nike Epic React Flyknit foam cushioning is responsive yet light-weight, durable yet soft. This creates a sensation that not only enhances the feeling of moving forward, but makes running feel fun, too.</p>\n");
      out.write("                        <div class=\"buttons\">\n");
      out.write("                            <button class=\"add\">Add to Cart</button>\n");
      out.write("                            <button class=\"like\"><span>♥</span></button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <footer>\n");
      out.write("                    <p>made by <a href=\"https://codepen.io/juliepark\"> julie</a> ♡\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
