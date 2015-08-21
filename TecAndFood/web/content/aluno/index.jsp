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

    int e = -1, id = -1;
    String chave = "", tipo = "", filtro = "";
    Integer paginasSession = 0;
    boolean pesquisa = false;
    double paginasI = 0;

    Enumeration<String> atributosR = request.getParameterNames();
    /*Enumeration<String> atributosS = session.getAttributeNames();
     
     ArrayList<ArrayList<Cliente>> lista = new ArrayList<ArrayList<Cliente>>();
     ArrayList<Cliente> clientes;
     ArrayList<Parametro> parametros = null;*/
    EnderecoDao enderecoDao = new EnderecoDao(conexao, logger);
    AlunoDao alunoDao = new AlunoDao(conexao, logger);
    //UsuarioDao usuarioDao = new UsuarioDao(conexao, logger);
    ResponsavelDao responsavelDao = new ResponsavelDao(conexao, logger);
    //AtividadeDao atividadeDao = new AtividadeDao(conexao, logger);

    int paginas = (int) alunoDao.calcularPaginacaoAtivos();
    ArrayList<Aluno> alunos = null;

    while (atributosR.hasMoreElements()) {
        String name = (String) atributosR.nextElement();
        if (name.equals("e")) {
            e = Integer.parseInt(request.getParameter("e"));
        }
    }
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
        <script src="../../js/jquery.masquedinput.js" type="text/javascript"></script>
        <script src="../../js/script.js"></script>
        <script>
            $(document).ready(function() {
                $("[name=cpf").mask("999.999.999-99");
                $("[name=rg]").mask("9.999.999");
                $("[name=data]").mask("99/99/9999");

                $(".pagination li a").click(function() {
                    $("#carregando").fadeIn('fast');
                    $(".pagination li.active").removeClass("active");
                    $(this).parent("li").addClass("active");
                    var offset = $(this).attr("page");
                    $("table").children("tbody").addClass("bodyInativo");
                    $("#p" + offset).removeClass("bodyInativo");
                    $("#carregando").fadeOut('fast');
                });

            <%
                if (e > -1) {
                    switch (e) {
                        case 0:
                            out.println("Materialize.toast('Aluno cadastrado com sucesso!', 5000,'' );");
                    }
                }
            %>
            });
        </script>
    </head>
    <body onload="setContent()" onresize="setContent()">
        <div id="carregando">
            <div class="loading"></div>
        </div>
        <%@include file="../navbar.jsp" %>
    <main>
        <div class="container">
            <div id="content" class="center card ">
                <div class="row  grey lighten-5  black-text card">
                    <h5 class="col s4 offset-s4">Alunos Cadastrados</h5>
                    <a class="col s3 waves-effect waves-light btn modal-trigger" href="#novo">Cadastrar aluno</a>                    
                    <div id="novo" class="modal">
                        <form method="post" action="../../control/NovoAluno">
                            <div class="modal-content">
                                <h5>Cadastrar aluno</h5>
                                <p>Preencha todos os campos e clique em Salvar, ou clique em Cancelar.</p>
                                <div class="input-field col s12">
                                    <input type="text" name="nome" placeholder="Nome Completo" id="nome" required />
                                    <label for="nome">Nome Completo</label>
                                </div>
                                <div class="input-field col s5">
                                    <input type="text" name="rg" placeholder="RG" id="rg" required />
                                    <label for="rg">RG</label>
                                </div>
                                <div class="input-field col s5 offset-s1">
                                    <input type="text" name="cpf" placeholder="CPF" id="cpf" required />
                                    <label for="cpf">CPF</label>
                                </div>
                                <div class="input-field col s5">
                                    <input type="text" name="matricula" placeholder="Matricula" id="matricula" required />
                                    <label for="matricula">Matricula</label>
                                </div>
                                <div class="input-field col s5 offset-s1">
                                    <input type="text" name="data" placeholder="dd/mm/aaaa" id="data" required />
                                    <label for="data">Data de nascimento</label>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class=" modal-action waves-effect waves-green btn-flat">Salvar</button>
                                <button type="button" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancelar</button>
                                <!--a href="control/FecharIntervalo" class=" modal-action modal-close waves-effect waves-green btn-flat">Sim</a>
                                <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Não</a-->
                            </div>
                        </form>
                    </div>
                </div>
                <% int i = 0;
                    if (paginas > 0) { %>
                <div class="row s10 offset-s1">
                    <table class='bordered hoverable striped responsive-table'>
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th data-field='nome'>Nome</th>
                                <th data-field='matricula'>Matrícula</th>
                                <th data-field='nascimento'>Data de Nascimento</th>
                                <th data-field='status'>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id='p0'>
                            <%
                                while (i < paginas) {
                                    alunos = alunoDao.listarAtivos(i * 10);
                                    for (Aluno aluno : alunos) {%>
                            <tr>
                                <td></td>
                                <td class='icon edit'><a></a></td>
                                <td class='icon del'><a></a></td>
                                <td><%= aluno.getNome()%></td>
                                <td><%= aluno.getMatricula()%></td>
                                <td><%= aluno.dataNascimento()%></td>
                                <% if (aluno.getStatus()) { %><td>Ativo</td>
                                <% } else { %> <td>Inativo</td> <% } %>
                                <td></td>
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
                    <ul class="pagination">
                        <% for (i = 0; i < paginas; i++) {%>
                        <li class="waves-effect"><a page="<%= i%>"><%= i + 1%></a></li>
                            <% } %>
                    </ul>
                    <% }
                        } else {
                            out.println("<h5>Nao ha alunos cadastrados</h5>");
                        }%>
                </div>
            </div>
        </div>
    </main>

</body>
</html>

