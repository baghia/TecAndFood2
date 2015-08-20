package control.filtros;

import dao.UsuarioDao;
import dao.util.Conexao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.util.LoggerTec;

@WebFilter(filterName = "FiltroSessao", urlPatterns = {"/Logout", "/content/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class FiltroSessao implements Filter {
    
    private static final boolean debug = true;
    
    private FilterConfig filterConfig = null;
    
    public FiltroSessao() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroSessao:DoBeforeProcessing");
        }
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroSessao:DoAfterProcessing");
        }
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("FiltroSessao:doFilter()");
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        doBeforeProcessing(request, response);
        try {
            System.out.println("FiltroSessao: doFilter.");
            if (httpRequest.getSession(false).isNew()) {
                System.out.println("FiltroSessao: sessao nao iniciada.");
                httpResponse.sendRedirect("../../index.jsp?e=2");
            } else {
                System.out.println("FiltroSessao: recuperando parametros de sessao.");
                Usuario usuario = (Usuario) httpRequest.getSession(false).getAttribute("usuario");
                Conexao conexao = (Conexao) httpRequest.getAttribute("conexao");
                LoggerTec logger = (LoggerTec) httpRequest.getAttribute("logger");
                
                UsuarioDao userDao = new UsuarioDao(conexao, logger);

                String location = "index.jsp";
                String target = "";
                Enumeration<String> atributosS = httpRequest.getSession(false).getAttributeNames();
                while (atributosS.hasMoreElements()) {
                    String name = (String) atributosS.nextElement();
                    if (name.equals("target")) {
                        target = (String) httpRequest.getSession(false).getAttribute("target");
                    }
                }
                httpRequest.setCharacterEncoding("utf-8");
                //System.out.println("Usuario no filtro: " + usuario);
                String url = httpRequest.getRequestURL().toString();
                String[] urls = url.split("/");
                //System.out.println("URL: " + url + ". Tamanho: " + urls.length);
                //System.out.println("URL[0]: " + urls[0] + ". URL[1]: " + urls[1] + ". URL[2]: " + urls[2] + ". URL[3]: " + urls[3] + ". URL[4]: " + urls[4] + ". URL[5]: " + urls[5]);
                if (httpRequest.getSession(false).getAttribute("location") != null) {
                    location = (String) httpRequest.getSession(false).getAttribute("location");
                    String[] split = location.split("/");
                    if (target.isEmpty()) {
                        target = split[1];
                    }
                    //System.out.println("Split no session: " + split.length);
                    if (!split[1].equals(urls[5]) || (!target.equals(split[1])) ) {
                        //ystem.out.println("Indo para modulo diferente.");
                        switch (split[1]) {
                            case "aluno":
                                //System.out.println("Case cliente.");
                                if (httpRequest.getSession(false).getAttribute("alunos") != null) {
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                    httpRequest.getSession(false).removeAttribute("count");
                                    httpRequest.getSession(false).removeAttribute("chave");
                                    httpRequest.getSession(false).removeAttribute("alunos");
                                }
                                break;/*
                            case "produto":
                                //System.out.println("Case produto.");
                                if (httpRequest.getSession(false).getAttribute("produtos") != null) {
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                    httpRequest.getSession(false).removeAttribute("count");
                                    httpRequest.getSession(false).removeAttribute("chave");
                                    httpRequest.getSession(false).removeAttribute("produtos");
                                    httpRequest.getSession(false).removeAttribute("parametros");
                                }
                                break;
                            case "pedido":
                                //System.out.println("Case pedido.");
                                if (httpRequest.getSession(false).getAttribute("pedidos") != null) {
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                    httpRequest.getSession(false).removeAttribute("count");
                                    httpRequest.getSession(false).removeAttribute("chave");
                                    httpRequest.getSession(false).removeAttribute("pedidos");
                                    httpRequest.getSession(false).removeAttribute("parametros");
                                }
                                break;
                            case "estrutura":
                                if (httpRequest.getSession(false).getAttribute("relatorioEstrutura") != null) {
                                    httpRequest.getSession(false).removeAttribute("relatorioEstrutura");
                                    httpRequest.getSession(false).removeAttribute("nome");
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                }
                                break;
                            case "geral":
                                if (httpRequest.getSession(false).getAttribute("relatorioGeral") != null) {
                                    httpRequest.getSession(false).removeAttribute("relatorioGeral");
                                    httpRequest.getSession(false).removeAttribute("nome");
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                }
                                break;
                            case "clienteProduto":
                                if (httpRequest.getSession(false).getAttribute("relatorioCliente") != null) {
                                    httpRequest.getSession(false).removeAttribute("relatorioCliente");
                                    httpRequest.getSession(false).removeAttribute("nome");
                                    httpRequest.getSession(false).removeAttribute("filtro");
                                    httpRequest.getSession(false).removeAttribute("graficoCliente");
                                    httpRequest.getSession(false).removeAttribute("graficoProduto");
                                }
                                break;*/
                        }
                    }
                }
                Throwable problem = null;
                if (usuario != null) {
                    Usuario user = userDao.consultar(usuario.getId());
                    if (user.getAtivo()) {
                        httpRequest.setAttribute("usuario", usuario);
                        try {
                            System.out.println("FiltroSessao: chain.doFilter");
                            chain.doFilter(httpRequest, httpResponse);
                        } catch (Throwable t) {
                            problem = t;
                            t.printStackTrace();
                        }
                    } else {
                        System.out.println("Usuario " + user.getUsername() + " inativo. Fechando sessao.");
                        httpRequest.getSession(false).invalidate();
                        httpResponse.sendRedirect("../../index.jsp?e=7");
                    }
                } else {
                    httpRequest.setAttribute("location", location);
                    httpResponse.sendRedirect("../../index.jsp?e=5");
                }
                System.out.println("FiltroSessao: doAfterProcessing");
                System.out.println("*****************************");
                doAfterProcessing(httpRequest, httpResponse);

                if (problem != null) {
                    if (problem instanceof ServletException) {
                        throw (ServletException) problem;
                    }
                    if (problem instanceof IOException) {
                        throw (IOException) problem;
                    }
                    sendProcessingError(problem, response);
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("FiltroSessao: nullPointerException. Message: " + ex.getMessage());
            httpResponse.sendRedirect("../../index.jsp");
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("FiltroSessao:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("FiltroSessao()");
        }
        StringBuffer sb = new StringBuffer("FiltroSessao(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
