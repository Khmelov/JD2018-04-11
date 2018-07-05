<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ attribute name="count" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="step" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="urlprefix" required="true" rtexprvalue="true" type="java.lang.String" %>
<%
    out.println("Page:");
    out.println("<nav aria-label='Page navigation example'>");
    out.println("<ul class='pagination'>");

    for (int i = 0; i <= (count - 1) / step; i++) {
        out.println(String.format("&nbsp<li class='page-item'><a class='page-link' href='%s%d'>%d</a></li>", urlprefix, i * step, i+1));
    }

    out.println("</ul>");
    out.println("</nav>");
%>
