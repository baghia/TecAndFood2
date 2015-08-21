<%@page import="model.estoque.Ingrediente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.estoque.IngredienteDao"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%@include file="include.jsp" %>
<%
    IngredienteDao ingredienteDao = new IngredienteDao(new Conexao(), new LoggerTec());
    ingredienteDao.setCon(new Conexao().conectar());
    ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
%>
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
                <div id="content" class="center card " style="position: absolute; padding: 20px;" >

                    <div class="row  grey lighten-5  black-text card">
                        <h5 class="col s4 offset-s4 ">Montar Prato</h5>
                    </div>
                    <div class="row ">
                        <div class="row">

                            <div class="input-field col  s3 offset-s3">
                                <select id="select-ingredientes">
                                    <option value="" disabled selected>Selecione o ingrediente</option>
                                    <%
                                        ingredientes = ingredienteDao.listar();
                                    %>
                                    <% for (Ingrediente ingrediente : ingredientes) {%>
                                    <option id="<%=ingrediente.getUnidadeMedida().getNome()%>" value="<%=ingrediente.getId()%>"><%=ingrediente.getNome()%></option>
                                    <% }%>
                                </select>
                                <label>Ingrediente</label>
                            </div>
                            <div class="input-field col s2">
                                <input placeholder="Informe a quantidade" id="quantidade_informada"  type="text" class="validate">
                                <label for="quantidade_informada">Quantidade</label>
                            </div>
                            <div class="input-field col s1 left">
                                <b><h5 id="unidadeMedida"></h5></b>
                            </div>
                        </div>
                        <div class="row">


                        </div>
                        <button id="adicionarIngrediente" class="btn waves-effect waves-light" type="button" name="action">Adicionar</button>
                    </div>
                                <form action="control/InserirPrato" method="post">
                        <div id="adicionados">

                        </div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                        </button>
                    </form>
                </div>
            </div>
        </main>

    </body>
</html>

