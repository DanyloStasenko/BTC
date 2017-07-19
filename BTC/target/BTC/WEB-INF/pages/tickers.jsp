<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>

<html>
    <head>
        <title>Tickers</title>

        <link rel="stylesheet" href="../../css/bootstrap-theme.min.css" type="text/css" />
        <link rel="stylesheet" href="../../css/bootstrap.min.css" />

        <%-- Ajax auto update every 10 seconds --%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript">
            window.setInterval(function() {
                $('#updating').load('/tickers #updating');
            }, 1000 * 10);   // 10 seconds
        </script>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <div id = updating>
                        <h1>Current values:</h1>
                        <p>(updating every 10 seconds)</p>
                        <table class="table">
                            <thead>
                                <th>mid</th>
                                <th>bid</th>
                                <th>ask</th>
                                <th>last_price</th>
                                <th>low</th>
                                <th>high</th>
                                <th>volume</th>
                                <th>timestamp</th>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>${ticker.mid}</td>
                                    <td>${ticker.bid}</td>
                                    <td>${ticker.ask}</td>
                                    <td>${ticker.last_price}</td>
                                    <td>${ticker.low}</td>
                                    <td>${ticker.high}</td>
                                    <td>${ticker.volume}</td>
                                    <td>${ticker.timestamp}</td>
                                </tr>
                            </tbody>
                        </table>

                        <c:url var="addAction" value="/save"/>
                        <form:form cssClass="form-horizontal" role="form" action="${addAction}" commandName="ticker">

                            <div class="form-group">
                                <form:input path="mid" type = "hidden"/>
                                <form:input path="bid" type = "hidden"/>
                                <form:input path="ask" type = "hidden"/>
                                <form:input path="last_price" type = "hidden"/>
                                <form:input path="low" type = "hidden"/>
                                <form:input path="high" type = "hidden"/>
                                <form:input path="volume" type = "hidden"/>
                                <form:input path="timestamp" type = "hidden"/>
                            </div>

                            <div class="btn-group">
                                <div class="col-sm-offset-0 col-sm-0">
                                    <button type="submit" class="btn btn-default" value="">
                                        Save Values
                                    </button>
                                </div>
                            </div>

                        </form:form>

                        <c:if test="${!empty tickers}">
                            <br>
                            <h1>Tickers List:</h1>
                            <br>
                            <table class="table">
                                <thead>
                                    <th>id</th>
                                    <th>mid</th>
                                    <th>bid</th>
                                    <th>ask</th>
                                    <th>last_price</th>
                                    <th>low</th>
                                    <th>high</th>
                                    <th>volume</th>
                                    <th>timestamp</th>
                                </thead>

                                <tbody>
                                    <c:forEach items="${tickers}" var="ticker">
                                        <tr>
                                            <td>${ticker.id}</td>
                                            <td>${ticker.mid}</td>
                                            <td>${ticker.bid}</td>
                                            <td>${ticker.ask}</td>
                                            <td>${ticker.last_price}</td>
                                            <td>${ticker.low}</td>
                                            <td>${ticker.high}</td>
                                            <td>${ticker.volume}</td>
                                            <td>${ticker.timestamp}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    </div>

                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>

    </body>
</html>