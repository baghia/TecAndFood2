<!DOCTYPE html>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bin/materialize.min.js"></script>
<script src="js/script.js"></script>
<header>
    <div class="navbar-fixed" style="position: absolute">
        <ul id="drop-aluno" class="dropdown-content">
            <li><a href="content/aluno/">Consultar</a></li>
            <!--li><a href="content/aluno/index.jsp">Novo</a></li-->
        </ul>
        <ul id="drop-ingrediente" class="dropdown-content">
            <!--li><a href="cadastrarAlimento.jsp">Novo</a></li>
            <li><a href="#!">Atualizar</a></li-->
            <li><a href="content/ingrediente/">Consultar</a></li>
        </ul>
        <ul id="drop-cardapio" class="dropdown-content">
            <!--li><a href="#!">Novo</a></li>
            <li><a href="#!">Atualizar</a></li-->
            <li><a href="content/cardapio/">Consultar</a></li>
        </ul>
        <ul id="drop-relatorio" class="dropdown-content">
            <li><a href="#!">X</a></li>
            <li><a href="#!">Y</a></li>
            <li><a href="#!">Z</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo"><h5>Tec And Food - Bem-Vindo(a), Demonstracao</h5></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <!--<li><a class="dropdown-button" href="#!" data-activates="dropdown1">Alimentos<i class="material-icons right">arrow_drop_down</i></a></li>-->                            
                    <li><a href="index.jsp">Página Inicial</a></li>
                    <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-aluno">Alunos<div class="icons right">&#x25bc;</div></a></li>
                    <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-ingrediente">Ingredientes<div class="icons right">&#x25bc;</div></a></li>
                    <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-cardapio">Cardápios<div class="icons right">&#x25bc;</div></a></li>
                    <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-relatorio">Relatórios<div class="icons right">&#x25bc;</div></a></li>
                    <li><a href="Logout" >Sair</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>

