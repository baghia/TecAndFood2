<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tec And Food</title>
        <link href="../images/favicon.png" type="image/png" rel="icon">
        <link href="../images/favicon.png" type="image/png" rel="shortcut icon">
        <script src="../js/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="../css/style.css"/>
        <script>
            function abrirLightbox(id) {
                $(id).fadeIn('fast');
            }
            function fecharLightbox() {
                $("lightbox").fadeOut('fast');
            }
            $(document).keydown(function(e) {
                if ((e.which == 74) && (e.ctrlKey || e.metaKey)) {
                    alert("ctrl j");
                    e.preventDefault();
                }
                
            });
            $(document).ready(function(){
               $("[name=matricula]").keydown(function(e){
                   if(e.keyCode == 13){
                       alert("enter");
                   }
               });
               $("[name=formulario]").submit(function(e){
                   alert("submit");
                   e.preventDefault();
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
        <menu>
            <ul>
                <li><a href="index.jsp" class="login selected">Index</a></li>
            </ul>            
        </menu>
    </sidebar>
    <div id="footer">
    </div> <!-- END of footer -->
    <content>
        <div class="col-lg-8 col-sm-8">
            <h1>Turno Matutino - Cardápio</h1>
            <div class="cleaner h30"></div>
            <p>Leite, biscoito salgado integral, mel e uma maçã.</p>
            <div class="cleaner h30"></div>
            <p>Leia a matrícula do aluno: </p>
            <form method="post" action="Login" name="formulario">
                <input type="text" name="matricula" placeholder="Matrícula" required autocomplete="off" autofocus >
                <button class="tick button" type="submit">Ver</button>
            </form>
            <p>Quantidade: </p>
            <div class="cleaner h30"></div>
            <form method="post" action="Login" name="formulario">
                <button class="tick button" type="submit">Terminar intervalo</button>
            </form>
        </div>
    </content>
</body>
</html>

