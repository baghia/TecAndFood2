<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tec And Food</title>
        <!--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
        <link rel="stylesheet" href="css/materialize.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body onload="UpdateTime();
            setContent();" onresize="setContent();">

        <%@include file="navbar.jsp" %>
        <main>
            <div class="container center">
                <div id="content" class="center " style="position: absolute; padding: 50px;" >
                    <div class="row">
                        <h5 class="header">
                            <%
                                DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
                                Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();%>
                            <%=dfmt.format(hoje)%> </span>
                        </h5>

                    </div>

                    <div class="row">
                        <div class="col s12 m6">
                            <a href="stepOne.jsp">
                                <div class="card grey lighten-5 hoverable">
                                    <div class="card-content black-text">
                                        <span class="card-title black-text">Lanche da Manhã</span>
                                        <p>Leite, biscoito salgado integral, mel e uma maçã.</p></p>
                                    </div>
                                    <div class="card-action">
                                        <a href="stepOne.jsp">Preparar</a>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col s12 m6">
                            <a href="stepOne.jsp">
                                <div class="card white hoverable">
                                    <div class="card-content black-text">
                                        <span class="card-title black-text">Almoço</span>

                                        <p>Arroz integral, feijão, omelete de couve, abóbora refogada, salada de tomate.</p></p>
                                    </div>
                                    <div class="card-action">

                                        <a href="stepOne.jsp">Preparar</a>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col s12 m6">
                            <a href="stepOne.jsp">
                                <div class="card white hoverable">
                                    <div class="card-content black-text">
                                        <span class="card-title black-text">Lanche da Tarde</span>
                                        <p>Suco de uva integral, torta de legumes (cenoura, milho, ervilha, tomate) e uma maçã.</p></p>
                                    </div>
                                    <div class="card-action">

                                        <a href="stepOne.jsp">Preparar</a>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col s12 m6">
                            <a href="stepOne.jsp">
                                <div class="card grey lighten-5 hoverable">
                                    <div class="card-content black-text">
                                        <span class="card-title black-text">Lanche da Noite</span>

                                        <p>Leite, biscoito salgado integral, mel e uma maçã.</p></p>
                                    </div>
                                    <div class="card-action">

                                        <a href="stepOne.jsp">Preparar</a>
                                    </div>
                                </div>
                            </a>
                        </div>

                    </div>

                    <div class="row">
                        <h5><p id="time"></p></h5>
                    </div>
                </div>
            </div>
        </main>

    </body>
</html>

