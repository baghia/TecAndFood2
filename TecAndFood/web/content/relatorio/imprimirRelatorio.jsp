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
//    int quantidade = Integer.parseInt(request.getParameter("quantidade"));

    RefeicaoDao refeicaoDao = new RefeicaoDao(conexao, new LoggerTec());
    refeicaoDao.setCon(con);

    IntervaloDao intervaloDao = new IntervaloDao(conexao, new LoggerTec());
    intervaloDao.setCon(con);
//    Intervalo intervalo = intervaloDao.buscarUltimo();
//
//    int quantidadeTotal = refeicaoDao.quantidadeTotalPorIntervalo(intervalo);

    Intervalo intervalo = null;
    if (request.getParameter("intervalo") != null) {
        intervalo = intervaloDao.buscarPorId(Integer.parseInt(request.getParameter("intervalo")));
    } else {
        intervalo = intervaloDao.buscarUltimo();
    }
    int quantidadeEsperada = intervalo.getQtdEsperada();
    int quantidadeTotal = refeicaoDao.quantidadeTotalPorIntervalo(intervalo);
    DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
    Date data = intervalo.getDataHora();
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tec And Food</title>
        <link rel="stylesheet" href="../../css/materialize.css"/>
        <link rel="stylesheet" href="../../style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <style>
            .titulo{
                display: block;
                padding: 10px;
                width: 100%;
                background-color: #4f81bd;
                color: #fff;
                font-weight:bold;
                text-align: center;
                margin-top: 15px;
            }
            .titulo h5{font-weight: bold;}
            .header{margin: 0px !important}
            tr:last-child{border-bottom: 1px solid grey}
            @media print{
                .titulo{margin-top: 0px}
                .titulo h5{font-size: 20px !important; font-weight: bold;}
                * {border: none; outline: none;}
                body{margin:0px;  background: #fff}
                tr td{font-size: 12px  !important; padding: 5px !important}
                p{ font-size: 12px !important}
                thead tr{border-top: 1px solid grey; border-bottom: 1px solid grey;}
                tr{line-height: 1em !important}
                th{font-weight: bold !important; font-size: 12px !important; padding: 5px !important}
                @page{
                    margin-top: 0cm !important;
                    margin-left: 1cm !important;
                    margin-right: 1cm !important;
                    margin-bottom:  1cm !important;
                    background-color: transparent !important;
                    line-height: 1.5em !important
                }
            }
        </style>
    </head>
    <body onload="setContent()" onresize="setContent()">
        <main>
            <div class="container">
                <div class="row">
                    <div class="titulo">
                        <h5 class="header">Tec&Food - <%=dfmt.format(data)%> - Lanche da Manhã</h5>
                    </div>
                    <div class="col s12">
                        <p class="card-title black-text">Cardápio: Leite, biscoito salgado integral, mel e uma maçã.</p>
                    </div>
                    <div class="col s5">
                        <p>Total de alunos esperado: <%=quantidadeEsperada%></p>
                    </div>
                    <div class="col s5 offset-s1">
                        <p>Total de alunos servidos: <%=quantidadeTotal%></p>
                    </div>
                </div>
                <div class="row ">
                    <table class="col s12 centered striped">
                        <thead>
                            <tr>
                                <th data-field="id">Ingrediente</th>
                                <th data-field="name">Quantidade total</th>
                                <th>Quantidade por prato</th>
                                <th>Sobras</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (IngredientePrato ingredientePrato : ingredientesPrato) {
                                    int quantidadeIngrediente = refeicaoDao.quantidadeIngredientePorIntervalo(ingredientePrato.getIngrediente(), intervalo);
                            %>
                            <tr>
                                <td><%=ingredientePrato.getIngrediente().getNome()%></td>
                                <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeEsperada)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                                <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeIngrediente)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                                <td class="red-text"><%=String.format("%.2f", (ingredientePrato.getQuantidade() * quantidadeEsperada) - (ingredientePrato.getQuantidade() * quantidadeIngrediente))%><%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
    <script>
        window.print();
    </script>
</html>

