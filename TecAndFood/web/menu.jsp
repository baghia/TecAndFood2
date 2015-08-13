<menu>  
    <ul>
        <li><span>Cadastros</span>
            <ul>
                <li><a href="content/cliente/" class="outros">Clientes</a></li>
                <li><a href="content/produto/" class="locacoes">Produtos</a></li>
                <% if (usuario.getTipo().getId() != 2) { %>
                <li><a href="content/usuario" class="home">Usu&aacute;rios</a></li>    
                    <% } else { %>
                <li><a href="content/usuario" class="home">Minha conta</a></li>
                    <% }%>
            </ul>
        </li>
        <li><span>Lançamentos</span>
            <ul>
                <li><a href="content/cotacao/" class="demonstrativos">Cotações</a></li>
                <li><a href="content/pedido/" class="demonstrativos">Pedidos</a></li>
            </ul>
        </li>
        <li><span>Relatórios</span>
            <ul> 
                <li><a href="content/relatorio/geral.jsp" class="empresas">Vendas - Geral</a></li>
                <li><a href="content/relatorio/estrutura.jsp" class="empresas">Vendas por estrutura</a></li>
                <li><a href="content/relatorio/clienteProduto.jsp" class="empresas">Cliente/Produto</a></li>
            </ul>
        </li>
        <li><span>Outros</span>
            <ul>
                <li><a href="content/help" class="help">Ajuda</a></li>
                <li><a href="Logout" class="sair">Sair</a></li>
            </ul>
        </li>
    </ul>
</menu>
