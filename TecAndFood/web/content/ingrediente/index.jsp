<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    IngredienteDao ingredienteDao = new IngredienteDao(conexao, logger);
    UnidadeMedidaDao unidadeMedidaDao = new UnidadeMedidaDao(conexao, logger);

    int paginas = (int) ingredienteDao.calcularPaginacao();
    ArrayList<Ingrediente> ingredientes = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Ingredientes - Tec And Food v<%= Sistema.versao%></title>
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
            <div id="content" class="center card ">
                <div class="row  grey lighten-5  black-text card">
                    <h5 class="col s4 offset-s4">Ingredientes Cadastrados</h5>
                </div>
                <% int i = 0;
            if (paginas > 0) { %>
                <table class='bordered hoverable striped responsive-table'>
                    <thead>
                        <tr>
                            <!--th></th>
                            <th></th-->
                            <th data-field='nome'>Nome</th>
                            <th data-field='matricula'>Unidade de Medida</th>
                        </tr>
                    </thead>
                    <tbody id='p0'>
                        <%
                                while (i < paginas) {
                                    ingredientes = ingredienteDao.listar(i * 10);
                                    for (Ingrediente ingrediente : ingredientes) {%>
                        <tr>
                            <!--td class='icon edit'><a></a></td>
                            <td class='icon del'><a></a></td-->
                            <td><%= ingrediente.getNome()%></td>
                            <td><%= ingrediente.getUnidadeMedida().getSigla() %></td>
                        </tr>
                        <% }
                            i++;%>
                    </tbody>                        
                    <tbody id='p<%= i%>' class='bodyInativo'>
                        <% }%>
                    </tbody>
                </table>
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
                        out.println("<h5>Nao há ingredientes cadastrados</h5>");
                    }%>
                <!--
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
                -->
            </div>
        </div>
    </main>

</body>
</html>

