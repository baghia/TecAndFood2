<%--<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>--%>
<%@include file="include.jsp" %>
<%
    /*
     Usuario usuario = null;
     usuario = (Usuario) request.getAttribute("usuario");

     session.removeAttribute("location");
     session.setAttribute("location", "content/aluno/index.jsp");
     */
    Usuario usuario = new Usuario();
    usuario.setNome("Demonstracao");
    LoggerTec logger = new LoggerTec(usuario);
    //Conexao conexao = (Conexao) request.getAttribute("conexao");
    Conexao conexao = new Conexao();
    conexao.setConexao(conexao.conectar());
    /*
     int e = -1, id = -1;
     String chave = "", tipo = "", filtro = "";
     Integer paginasSession = 0;
     boolean pesquisa = false;
     double paginasI = 0;

     /*Enumeration<String> atributosS = session.getAttributeNames();
     Enumeration<String> atributosR = request.getParameterNames();
     ArrayList<ArrayList<Cliente>> lista = new ArrayList<ArrayList<Cliente>>();
     ArrayList<Cliente> clientes;
     ArrayList<Parametro> parametros = null;*/
    IntervaloDao intervaloDao = new IntervaloDao(conexao, logger);

    int paginas = (int) intervaloDao.calcularPaginacao();
    ArrayList<Intervalo> intervalos = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Relatório - Tec And Food v<%= Sistema.versao%></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="../../css/materialize.css"/>
        <link rel="stylesheet" href="../../css/style.css"/>
        <script type="text/javascript" src="../../js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="../../js/bin/materialize.min.js"></script>
        <script src="../../js/script.js"></script>
    </head>
    <body onload="setContent()" onresize="setContent()">
        <%@include file="../navbar.jsp" %>
        <main>
            <div class="container">
                <div id="content" class="center card">
                    <div class="row  grey lighten-5  black-text card">
                        <h5 class="col s4 offset-s4">Intervalos</h5>
                    </div>
                    <% int i = 0;
                    if (paginas > 0) { %>

                    <div class="row s6 offset-s3">
                        <table class='  bordered hoverable striped centered responsive-table'>
                            <thead>
                                <tr>
                                    <th data-field='data'>Data</th>
                                </tr>
                            </thead>
                            <tbody id='p0'>
                                <%
                                    while (i < paginas) {
                                        intervalos = intervaloDao.listar(i * 10);
                                for (Intervalo intervalo : intervalos) {%>
                                <tr>
                                    <td><a href="../../relatorio.jsp?intervalo=<%= intervalo.getId()%>"><%= intervalo.dataHora()%></a></td>
                                </tr>
                                <% }
                            i++;%>
                            </tbody>                        
                            <tbody id='p<%= i%>' class='bodyInativo'>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                    <%
                    if (paginas > 1) { %>
                    <ul class="pagination hide-on-med-and-down col offset-s2">
                        <% for (i = 0; i < paginas; i++) {%>
                        <li class="waves-effect <% if (i == 0) {
                                out.println(" active ");
                            }%>">
                            <a page="<%= i%>"><%= i + 1%></a>
                        </li>
                        <% } %>
                    </ul>
                    <% }
                        } else {
                            out.println("<h5>Nao há intervalos registrados.</h5>");
                        }%>
                </div>
            </div>
        </main>

    </body>
</html>

