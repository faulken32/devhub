<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>   
<body>

        <h1>
            Home
        </h1>

        <div id="wrapper">

            <div id="codeContends">
                <h2>Lastest Code </h2>


                <c:forEach var="it" items="${code}">                                               

                    <div class="float"> 
                        <div class="line">
                            ${it.languagesid.name} : ${it.sublanguangesid.name}
                        </div>


                        <div class="line">
                            From : ${it.usersidusers.name}  on date : ${it.souscriptiondate}
                        </div>

                    </div>
                    <div class="float">like : ${it.like}</div>
                    <div class="clear"></div>
                    <div id="cotends"><pre>${it.contends}</pre></div>
                   
                   
                

                </c:forEach>    
            </div>


        </div>
    </body>
</html>
