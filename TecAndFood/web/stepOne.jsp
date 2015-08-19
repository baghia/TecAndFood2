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
        <link rel="stylesheet" href="css/materialize.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body onload="setContent()" onresize="setContent()">
        <%@include file="navbar.jsp" %>

        <main>
            <div class="container ">
                <div id="content" class="center card" style="position: absolute; padding: 10px;" >

<!--                    <div class="row  grey lighten-5 card black-text">
                        <h5 class="col s4 offset-s4 ">Informar Quantidade</h5>
                    </div>-->
                    <div class="row ">
                        <form class="col s12" action="stepTwo.jsp">
                            <div class="row">
                                <div class="input-field col l2 s2 m2 offset-l5 offset-s5 offset-m5">
                                    <input id="email" type="number" value="100" min="1" step="1" class="center tooltipped" data-tooltip="Informe a quantidade de pratos que serão preparados para essa refeição." data-position="bottom" data-delay="50">
                                    <label for="email">Quantidade de Pratos</label>
                                </div>
                            </div>
                            
                                <div class="row">

                                    <h6 class="center"><b>Sugestão baseada em dados anteriores: 300 pratos.</b></h6>
                                </div>
                            <button class="btn waves-effect waves-light"  type="submit" name="action">Continuar</button>
                        </form>

                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <ul class="tabs">
                            <li class="tab col s3 disabled"><a href="#"  class="active">Informar Quantidade</a></li>
                            <li class="tab col s3 disabled"><a  href="#">Preparar Refeição</a></li>
                            <li class="tab col s3 disabled"><a href="#">Intervalo</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--            <ul id="dropdown1" class="dropdown-content">
                            <li><a href="#!">Cadastrar</a></li>
                            <li><a href="#!">Atualizar</a></li>
                            <li class="divider"></li>
                        </ul>-->


        </footer>
    </body>
</html>

