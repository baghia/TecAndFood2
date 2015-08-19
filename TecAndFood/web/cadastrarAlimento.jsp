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
                <div id="content" class="center card " style="position: absolute; padding: 50px;" >

                    <div class="row  grey lighten-5  black-text card">
                        <h5 class="col s4 offset-s4 ">Novo Ingrediente</h5>
                    </div>
                    <div class="row ">
                        <div class="row">
                            <div class="input-field col s4 offset-s4">
                                <input placeholder="Nome do Ingrediente" id="first_name" type="text" class="validate">
                                <label for="first_name">Nome</label>
                            </div>

                        </div>
                        <div class="row">
                            <div class="input-field col s2 offset-s4">
                                <input placeholder="Informe a quantidade" id="first_name" type="text" class="validate">
                                <label for="first_name">Quantidade</label>
                            </div>
                            <div class="input-field col s2">
                                <select>
                                    <option value="" disabled selected>Unidade de Medida</option>
                                    <option value="1">Kg</option>
                                    <option value="3">g</option>
                                    <option value="2">Litros</option>
                                </select>
                                <label>Unidade de Medida</label>
                            </div>
                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar
                        </button>
                    </div>

                </div>
            </div>
        </main>

    </body>
</html>

