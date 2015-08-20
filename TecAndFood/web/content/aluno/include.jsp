<%@page import="model.Usuario" %>
<%@page import="model.util.Sistema" %>
<%@page import="model.util.LoggerTec" %>
<%@page import="model.util.Tipo" %>
<%@page import="model.aluno.Aluno" %>
<%@page import="model.aluno.Contato" %>
<%@page import="model.aluno.Endereco" %>
<%@page import="model.aluno.Estado" %>
<%@page import="model.aluno.Responsavel" %>

<%@page import="dao.util.Conexao" %>
<%@page import="dao.util.TipoDao" %>
<%@page import="dao.aluno.ResponsavelDao" %>
<%@page import="dao.aluno.AlunoDao" %>
<%@page import="dao.aluno.ContatoDao" %>
<%@page import="dao.aluno.EnderecoDao" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>