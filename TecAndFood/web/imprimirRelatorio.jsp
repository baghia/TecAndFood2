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
        <style>
            .header{margin-top: 10px}
            @media print{
                * {font-family: Arial, Helvetica, sans-serif; border: none; outline: none}
                body{margin:0px}
                sidebar{display: none;}
                content{
                    width: 100% !important; float: none !important; margin: 0px !important; background-color: #dedede !important}
                h1 { 
                    font-size: 14px !important; 
                    text-align: center !important;
                }
                h3, h4 {
                    font-size: 12px  !important;
                    border-bottom: 1px solid #000 !important;
                    margin-left: -35px !important;
                    text-transform: capitalize !important
                }
                table{border: 1px solid #000  !important; width: 100%  !important; padding: 0px; margin: 0px}
                td{border-left: none  !important}
                tr td, th{font-size: 10px  !important}  
                th{font-weight: bold !important}
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
                <h5 class="header">
                    <%
                        DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
                        Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();%>
                    <span><%=dfmt.format(hoje)%> </span>
                </h5>
                <p class="card-title black-text">Lanche da Manhã: Leite, biscoito salgado integral, mel e uma maçã.</p>
                <p>Quantidade de alunos esperada: ${param.quantidade}</p>
                <p>Quantidade de refeições entregues: <%=quantidadeTotal%></p>
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
                            <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidade)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            <td><%=String.format("%.2f", ingredientePrato.getQuantidade() * quantidadeIngrediente)%> <%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                            <td class="red-text"><%=String.format("%.2f", (ingredientePrato.getQuantidade() * quantidade) - (ingredientePrato.getQuantidade() * quantidadeIngrediente))%><%=" " + ingredientePrato.getIngrediente().getUnidadeMedida().getSigla()%></td>
                        </tr>
                        <%}%>
                        <tr>
                            <td colspan="2"><h5>Totais</h5></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</body>
</html>

