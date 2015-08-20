<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<%

    Usuario usuario = null;
    usuario = (Usuario) request.getAttribute("usuario");

    session.removeAttribute("location");
    session.setAttribute("location", "content/aluno/index.jsp");

    LoggerTec logger = (LoggerTec) request.getAttribute("logger");
    Conexao conexao = (Conexao) request.getAttribute("conexao");

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
    EnderecoDao enderecoDao = new EnderecoDao(conexao, logger);
    AlunoDao alunoDao = new AlunoDao(conexao, logger);
    //UsuarioDao usuarioDao = new UsuarioDao(conexao, logger);
    ResponsavelDao responsavelDao = new ResponsavelDao(conexao, logger);
    //AtividadeDao atividadeDao = new AtividadeDao(conexao, logger);

    int paginas = (int) alunoDao.calcularPaginacaoAtivos();
    ArrayList<Aluno> alunos = alunoDao.listarAtivos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Alunos - Tec And Food v<%= Sistema.versao%></title>
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
            <div id="content" class="center card " style="position: absolute; padding: 10px;" >
                <div class="row  grey lighten-5  black-text card">
                    <h5 class="col s4 offset-s4">Alunos Cadastrados</h5>
                </div>
                <% if (!alunos.isEmpty()) { %>
                <table class='striped responsive-table'>
                    <thead>
                        <tr>
                            <th data-field='nome'>Nome</th>
                            <th data-field='matricula'>Matrícula</th>
                            <th data-field='nascimento'>Data de Nascimento</th>
                        </tr>
                    </thead>
                    <%
                        if (paginas > 1) {
                            for (int i = 0; i < paginas; i++) {

                            }
                        }
                    }
                %>

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

