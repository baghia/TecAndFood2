<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tec And Food</title>
        <!--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
        <link rel="stylesheet" href="css/materialize.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
                        <form class="col s12" method="post" action="">
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

