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
                <div id="content" class="center card" style="position: absolute; padding: 50px;" >
                    
                    <div class="row  grey lighten-5 card black-text">
                        <h5 class="col s4 offset-s4 ">Lista de Ingredientes</h5>
                    </div>
                    <div class="row">
                        <table class="centered striped responsive-table">
                            <thead>
                                <tr>
                                    <th data-field="id">Alimento</th>
                                    <th data-field="name">Quantidade</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Leite in Natura</td>
                                    <td>25 Litros</td>
                                </tr>
                                <tr>
                                    <td>Biscoito Salgado Integral</td>
                                    <td>5,95 Kg</td>
                                </tr>
                                <tr>
                                    <td>Mel de Abelhas</td>
                                    <td>1,5 Kg</td>

                                </tr>
                                <tr>
                                    <td>Maçã</td>
                                    <td>10 Kg</td>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row ">
                        <a class="waves-effect waves-light btn" href="stepThree.jsp">Iniciar Intervalo</a>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <ul class="tabs">
                            <li class="tab col s3 disabled"><a href="#">Informar Quantidade</a></li>
                            <li class="tab col s3 disabled"><a  href="#" class="active">Preparar Refeição</a></li>
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

