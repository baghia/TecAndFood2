<header>
    <!--div class="navbar-fixed" style="position: absolute"-->
    <ul id="drop-aluno" class="dropdown-content">
        <li><a href="../aluno/">Consultar</a></li>
    </ul>
    <ul id="drop-ingrediente" class="dropdown-content">
        <li><a href="../ingrediente/">Consultar</a></li>
    </ul>
    <ul id="drop-cardapio" class="dropdown-content">
        <li><a href="../cardapio/">Consultar</a></li>
    </ul>
    <ul id="drop-relatorio" class="dropdown-content">
        <li><a href="#!">X</a></li>
        <li><a href="#!">Y</a></li>
        <li><a href="#!">Z</a></li>
    </ul>
    <nav>
        <div class="nav-wrapper">
            <a data-activates="nav-mobile" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
            <a href="../../index.jsp" class="brand-logo hide-on-med-and-up"><h5>Tec And Food</h5></a>
            <a href="../../index.jsp" class="brand-logo hide-on-med-and-down"><h5>Tec And Food - Bem-Vindo(a), <%= usuario.getNome()%></h5></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="../../index.jsp">Página Inicial</a></li>
                <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-aluno">Alunos<div class="icons right">&#x25bc;</div></a></li>
                <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-ingrediente">Ingredientes<div class="icons right">&#x25bc;</div></a></li>
                <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-cardapio">Cardápios<div class="icons right">&#x25bc;</div></a></li>
                <li><a class="dropdown-button" data-beloworigin="true" href="#!" data-activates="drop-relatorio">Relatórios<div class="icons right">&#x25bc;</div></a></li>
                <li><a href="../../Logout" >Sair</a></li>
            </ul>
        </div>
    </nav>

    <ul id="nav-mobile" class="side-nav fixed hide-on-med-and-up" style="width: 240px;">
        <li class="logo"><a id="logo-container" href="../../index.jsp" class="brand-logo"><h5>Tec And Food</h5></a></li>
        <li class="no-padding">
            <ul class="collapsible collapsible-accordion">
                <li class="bold"><a class="collapsible-header waves-effect waves-teal">Alunos</a>
                    <div class="collapsible-body" style="">
                        <ul>
                            <li><a href="../aluno/">Consultar</a></li>
                        </ul>
                    </div>
                </li>
                <li class="bold active"><a class="collapsible-header active waves-effect waves-teal">Ingredientes</a>
                    <div class="collapsible-body" style="">
                        <ul>
                            <li><a href="../ingrediente/">Consultar</a></li>
                        </ul>
                    </div>
                </li>
                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Cardápios</a>
                    <div class="collapsible-body" style="">
                        <ul>
                            <li><a href="../aluno/">Consultar</a></li>
                        </ul>
                    </div>
                </li>
                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Relatórios</a>
                    <div class="collapsible-body" style="">
                        <ul>
                            <li><a href="../relatorio/">Consultar</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </li>
        <li class="bold"><a href="../../Logout" class="waves-effect waves-teal">Sair</a></li>
    </ul>
    <!--/div-->
</header>

