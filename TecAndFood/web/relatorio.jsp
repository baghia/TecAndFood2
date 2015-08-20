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
            <div class="container">
                <div id="content" class="center card" style="position: absolute; padding: 50px;" >
                    <div class="row">
                        <h4 class="col s4 offset-s1 center">Esperado</h4>
                        <h4 class="col s4 offset-s2 center">Real</h4>
                    </div>
                    <div class="row ">
                        <!--<h1>${param.intervalo}</h1>-->
                        
                        <table class="col s4 offset-s1 centered striped">
                            <thead>
                                <tr>
                                    <th data-field="id">Name</th>
                                    <th data-field="name">Item Name</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Alvin</td>
                                    <td>Eclair</td>
                                </tr>
                                <tr>
                                    <td>Alan</td>
                                    <td>Jellybean</td>
                                </tr>
                                <tr>
                                    <td>Jonathan</td>
                                    <td>Lollipop</td>
                                </tr>
                            </tbody>
                        </table>
                        <table class="col s4 offset-s2 centered striped">
                            <thead>
                                <tr>
                                    <th data-field="id">Name</th>
                                    <th data-field="name">Item Name</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Alvin</td>
                                    <td>Eclair</td>
                                </tr>
                                <tr>
                                    <td>Alan</td>
                                    <td>Jellybean</td>
                                </tr>
                                <tr>
                                    <td>Jonathan</td>
                                    <td>Lollipop</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </main>

        <div class="row right">
            <a class="waves-effect waves-light btn modal-trigger" href="#confirmacao">Finalizar Intervalo</a>
        </div>
        <!-- Modal Structure -->
        <div id="confirmacao" class="modal">
            <div class="modal-content">
                <h4>Confirmação</h4>
                <p>Tem certeza que deseja finalizar o intervalo?</p>
            </div>
            <div class="modal-footer">
                <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Sim</a>
                <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Não</a>
            </div>
        </div>
        <footer>

            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <ul class="tabs">
                            <li class="tab col s3 disabled"><a href="#">Informar Quantidade</a></li>
                            <li class="tab col s3 disabled"><a  href="#">Preparar Refeição</a></li>
                            <li class="tab col s3 disabled"><a href="#" class="active">Intervalo</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>

