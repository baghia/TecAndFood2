<%@page import="model.estoque.Intervalo"%>
<%@page import="dao.estoque.IntervaloDao"%>
<%@page import="dao.estoque.RefeicaoDao"%>
<%@page import="model.cardapio.IngredientePrato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.cardapio.Prato"%>
<%@page import="dao.cardapio.IngredientePratoDao"%>
<%@page import="model.util.LoggerTec"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.util.Conexao"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<%
    Conexao conexao = new Conexao();
    Connection con = conexao.conectar();
    IngredientePratoDao ingredientePratoDao = new IngredientePratoDao(conexao, new LoggerTec());
    ingredientePratoDao.setCon(con);
    Prato prato = new Prato();
    prato.setId(1);
    ArrayList<IngredientePrato> ingredientesPrato = ingredientePratoDao.buscarPorPrato(prato);
    int quantidade = Integer.parseInt(request.getParameter("quantidade"));

    RefeicaoDao refeicaoDao = new RefeicaoDao(conexao, new LoggerTec());
    refeicaoDao.setCon(con);
    
    IntervaloDao intervaloDao = new IntervaloDao(conexao, new LoggerTec());
    intervaloDao.setCon(con);
    Intervalo intervalo = intervaloDao.buscarUltimo();
    
    int quantidadeTotal = refeicaoDao.quantidadeTotalPorIntervalo(intervalo);
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
                <div id="content" class="center card" style="padding: 20px;" >
                    <div class="row">
                        <div class="col s4 offset-s1 center">
                            <h5 >Esperado</h5>
                            <h5 >${param.quantidade}</h5>
                        </div>
                        <div class="col s4 offset-s2 center">
                            <h5>Total</h5>
                            <h5><%=quantidadeTotal%></h5>
                        </div>
                    </div>
                    <div class="row ">
                        <!--<h1></h1>-->

                        <table class="col s4 offset-s1 centered striped">
                            <thead>
                                <tr>
                                    <th data-field="id">Ingrediente</th>
                                    <th data-field="name">Quantidade</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%for (IngredientePrato ingredientePrato : ingredientesPrato) {%>
                                <tr>
                                    <td><%=ingredientePrato.getIngrediente().getNome()%></td>
                                    <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidade)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        <table class="col s4 offset-s2 centered striped">
                            <thead>
                                <tr>
                                    <th data-field="id">Ingrediente</th>
                                    <th data-field="name">Quantidade</th>
                                    <th data-field="name">Parcial</th>
                                    <th data-field="name">Sobras</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%for (IngredientePrato ingredientePrato : ingredientesPrato) {
                                    
                                    int quantidadeIngrediente = refeicaoDao.quantidadeIngredientePorIntervalo(ingredientePrato.getIngrediente(), intervalo);
                                %>
                                <tr>
                                    <td><%=ingredientePrato.getIngrediente().getNome()%></td>
                                    <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeIngrediente)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                                    <td><%=quantidadeIngrediente%></td>
                                    <td class="red-text"><%=String.format("%.2f", (ingredientePrato.getQuantidade() * quantidade)-(ingredientePrato.getQuantidade() * quantidadeIngrediente))%><%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>

                    <div class="row center">
                        <a class="waves-effect waves-light btn" href="index.jsp">Fechar Relat�rio</a>
                    </div>
                </div>

            </div>

        </main>



    </body>
</html>

