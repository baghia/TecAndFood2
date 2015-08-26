<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<%

    Usuario usuario = new Usuario();
    usuario.setNome("");
    int e = -1;
    Enumeration<String> atributosR = request.getParameterNames();
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
        <title>Tec And Food</title>
        <!--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
        <link rel="stylesheet" href="css/materialize.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/bin/materialize.min.js"></script>
        <script src="js/script.js"></script>
        <script>
            $(document).ready(function() {
            <%
                if(e > -1){
                    switch(e){
                        case 0:
                            out.println("Materialize.toast('Você saiu do sistema.', 2500,'' );");
                            break;
                    }
                }
            %>
            });
        </script>
    </head>
    <body onload="setContent();" onresize="setContent();">

        <%@include file="navbar.jsp" %>
    <main>
        <div class="container center">
            <div id="content" class="center card" style="position: absolute; padding: 50px;" >

                <div class="row">
                    <div class="row">
                        <h6><b>Você precisa estar autenticado para continuar</b></h6>
                    </div>
                    <form class="col s12" method="post" action="Login">
                        <div class="row">
                            <div class="input-field col s4 offset-s4">
                                <input placeholder="Usuário" id="username" type="text" name="username">
                                <label for="username">Usuário</label>
                            </div>
                        </div>
                        <div class="row">

                            <div class="input-field col s4 offset-s4">
                                <input id="password" placeholder="Senha" type="password" name="senha">
                                <label for="password">Senha</label>
                            </div>
                        </div>
                        <div class="row">
                            <button class="btn waves-effect waves-light" type="submit" name="action">Entrar
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </main>

</body>
</html>

