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
                <div class="row ">
                    <div class="row">
                        <div class="input-field col l2 s2 m2 offset-l5 offset-s5 offset-m5">
                            <input id="codigo" type="text" placeholder="Informe o código"  name="codigo" autofocus="true">
                            <label for="codigo">Código</label>
                        </div>
                    </div>

                    <div class="row">
                        <h5 id="nomeAluno">Nome</h5>
                    </div>

                    <h6><b>Desmarque os alimentos que não foram escolhidos pelo estudante:</b></h6><br>
                    <div id="bt-group" class="row">
                        <button id="bt1" class="btn waves-effect waves-light btn-large btn-active" type="button" name="action">Leite in Natura</button>
                        <button id="bt2" class="btn waves-effect waves-light btn-large btn-active" type="button" name="action">Biscoito Salgado Integral</button>
                        <button id="bt3" class="btn waves-effect waves-light btn-large btn-active" type="button" name="action">Mel de Abelhas</button>
                        <button id="bt4" class="btn waves-effect waves-light btn-large btn-active" type="button" name="action">Maçã</button>
                    </div>


                    <div class="row">
                        <button id="submit" class="btn waves-effect waves-light" type="button" name="action">Confirmar</button>
                    </div>
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

