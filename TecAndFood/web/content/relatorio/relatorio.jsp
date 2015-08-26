<%@page import="model.Usuario"%>
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
    Usuario usuario = new Usuario();
    usuario.setNome("Demonstracao");
    Conexao conexao = new Conexao();
    Connection con = conexao.conectar();
    IngredientePratoDao ingredientePratoDao = new IngredientePratoDao(conexao, new LoggerTec());
    ingredientePratoDao.setCon(con);
    Prato prato = new Prato();
    prato.setId(1);
    ArrayList<IngredientePrato> ingredientesPrato = ingredientePratoDao.buscarPorPrato(prato);

    RefeicaoDao refeicaoDao = new RefeicaoDao(conexao, new LoggerTec());
    refeicaoDao.setCon(con);

    IntervaloDao intervaloDao = new IntervaloDao(conexao, new LoggerTec());
    intervaloDao.setCon(con);
    Intervalo intervalo = null;
    if (request.getParameter("intervalo") != null) {
        intervalo = intervaloDao.buscarPorId(Integer.parseInt(request.getParameter("intervalo")));
    } else {
        intervalo = intervaloDao.buscarUltimo();
    }
    int quantidadeEsperada = intervalo.getQtdEsperada();
    int quantidadeTotal = refeicaoDao.quantidadeTotalPorIntervalo(intervalo);
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tec And Food</title>
        <link rel="stylesheet" href="../../css/materialize.css"/>
        <link rel="stylesheet" href="../../css/style.css"/>
        <script type="text/javascript" src="../../js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="../../js/bin/materialize.min.js"></script>
        <script src="../../js/script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script>
            $(document).ready(function() {
                $(".nav-wrapper ul li:nth-child(5)").addClass("active");
            });
        </script>
    </head>
    <body onload="setContent()" onresize="setContent()">
        <%@include file="../navbar.jsp" %>
    <main>
        <div class="container">
            <div id="content" class="center card" style="padding: 20px;" >
                <div class="row">
                    <h6><%=intervalo.dataHora()%></h6>
                </div>
                <div class="row">
                    <div class="col s5 center">
                        <h5 >Total de Alunos Esperado: <%=quantidadeEsperada%></h5>
                    </div>
                    <div class="col s5 offset-s2 center">
                        <h5>Total de Alunos Servidos: <%=quantidadeTotal%></h5>
                    </div>
                </div>
                <div class="row hide-on-med-and-down">
                    <table class="col s5 centered striped">
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
                                <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeEsperada)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <table class="col s5 offset-s2 centered striped">
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
                                <td class="red-text"><%=String.format("%.2f", (ingredientePrato.getQuantidade() * quantidadeEsperada) - (ingredientePrato.getQuantidade() * quantidadeIngrediente))%><%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="row hide-on-med-and-up">
                    <table class="col s12 centered striped">
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
                                <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeEsperada)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <div class="row"></div>
                    <table class="col s12 centered striped">
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
                                <td class="red-text"><%=String.format("%.2f", (ingredientePrato.getQuantidade() * quantidadeEsperada) - (ingredientePrato.getQuantidade() * quantidadeIngrediente))%><%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="row center">
                    <a target="_blank" class="waves-effect waves-light btn" href="imprimirRelatorio.jsp?intervalo=<%=intervalo.getId()%>">Imprimir</a>
                    <a class="waves-effect waves-light btn" href="index.jsp">Voltar</a>
                </div>
            </div>

        </div>

    </main>



</body>
</html>

