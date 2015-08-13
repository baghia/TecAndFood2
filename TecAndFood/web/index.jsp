<%@include file="include.jsp" %>
<%
    int e = -1;
    String erro = request.getParameter("e");
    if (erro == null) {
    } else {
        e = Integer.parseInt(erro);
    }
    String location="";
    if(request.getParameter("location") != null){
        location = request.getParameter("location");
        System.out.println(location);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sab Representações <%= Sistema.versao %></title>
        <link href="images/favicon.png" type="image/png" rel="icon">
        <link href="images/favicon.png" type="image/png" rel="shortcut icon">
        <script src="js/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style.css"/>
        <script>
            function abrirLightbox(id) {
                $(id).fadeIn('fast');
            }
            function fecharLightbox() {
                $("lightbox").fadeOut('fast');
            }
            $(document).ready(function() {
                $(".alert fechar").click(function() {
                    $(this).parent().fadeOut('fast');
                });
            });
        </script>
        <style>
            button[type=submit]{background-color: #029832}
            .alert.success h3{color: #029832}
            /*.alert{max-width: 30%; min-height: 20px;}*/
        </style>
    </head>
    <body>
    <sidebar>
        <a id="logo" href=""><img src='data:image/png;base64,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'></a>
        <menu>
            <ul>
                <li><a href="index.jsp" class="login selected">Login</a></li>
            </ul>            
        </menu>
    </sidebar>
    <div id="footer">
        <a href="http://atmrepresentacoes.com.br" target="_blank" title="ATM Soluções em Tecnologia"><img src="images/atm.png" /></a>
        <p>Copyright © <script> var d = new Date();
            document.write(d.getFullYear());</script></p>
    </div> <!-- END of footer -->
    <content>
        <div class="col-lg-8 col-sm-8">
            <h1>Entrar no sistema</h1>
            <form method="post" action="Login">
                <input type="text" name="username" placeholder="Nome de usuário" required autocomplete="off" autofocus>
                <div class="cleaner h10"></div>
                <input type="password" name="senha" placeholder="Senha" required autocomplete="off">
                <div class="cleaner h10"></div>
                <button class="tick button" type="submit">Entrar</button>
            </form>
            <div class="cleaner h20"></div>
            <%  if (e > -1) {
                    switch (e) {
                        case 0:
                            out.println("<div class='alert success'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Você saiu do sistema.</h3>"
                                    + "</div>");
                            break;
                        case 1:
                            out.println("<div class='alert nivel-1'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Informe usuário e senha para acessar o sistema!</h3>"
                                    + "</div>");
                            break;
                        case 2:
                            out.println("<div class='alert nivel-1'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Efetue login para acessar o sistema.</h3>"
                                    + "</div>");
                            break;
                        case 3:
                            out.println("<div class='alert nivel-1'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Usuário ou senha incorretos.</h3>"
                                    + "</div>");
                            break;
                        case 4:
                            out.println("<div class='alert nivel-1'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Ocorreu um erro.</h3>"
                                    + "<h3>Por favor contate o suporte e informe o código do erro: UL-i4</h3>"
                                    + "<div class='cleaner'></div>"
                                    + "</div>");
                            break;
                        case 5:
                            out.println("<div class='alert info'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Sua sessão expirou. Faça login novamente.</h3>"
                                    + "</div>");
                            break;
                        case 6:
                            out.println("<div class='alert info'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Este usuário não existe.</h3>"
                                    + "</div>");
                            break;
                        case 7:
                            out.println("<div class='alert info'>"
                                    + "<fechar title='Clique para fechar'></fechar>"
                                    + "<h3>Você não tem permissão para acessar o sistema. </h3>"
                                    + "<h3>Entre em contato com o administrador para resolver o problema.</h3>"
                                    + "<div class='cleaner'></div>"
                                    + "</div>");
                            break;
                    }
                }
            %>
            <div class="cleaner h30"></div>
        </div>
    </content>
</body>
</html>

