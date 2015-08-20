/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
//    $(".dropdown-button").dropdown({
//        inDuration: 300,
//        outDuration: 225,
//        constrain_width: true, // Does not change width of dropdown to that of the activator
//        hover: true, // Activate on hover
//        gutter: 0, // Spacing from edge
//        belowOrigin: true// Displays dropdown below the button
//    });

    $("#matricula").keydown(function (e) {
        if (e.keyCode == 13) {
            var matricula = $("#matricula").val();
            var request = $.ajax({
                type: "POST",
                url: "control/BuscarAluno",
                data: {matricula: matricula},
                success: function (retorno) {
                    var parsedJson = $.parseJSON(retorno);
                    if (parsedJson.error) {
                        $("#matricula").val("");
                        $("#nomeAluno").text(decodeURIComponent(escape("Não encontrado")));
                        $("#nomeAluno").addClass("red-text");
                        $("#nomeAluno").removeClass("green-text");
                    } else {

                        $("#nomeAluno").show();
                        $(".codigo-hide").hide(500);
                        $(".hidden").show(500);
                        
                        $("#submit").focus();
                        $("#nomeAluno").text(parsedJson.nome);
                        $("#nomeAluno").removeClass("red-text");
                        $("#nomeAluno").removeClass("green-text");
                    }

                }
            });
        }
    }
    );

    $("#nomeAluno").text("Aguardando Leitura").addClass("green-text");
    $(".hidden").hide();
    ;
    $(".codigo-hide").show();
    $('.modal-trigger').leanModal();
    $('.tooltipped').tooltip({delay: 50});
    $('select').material_select();
    $('.btn-active').on("click", function () {
        if ($(this).hasClass("disabled")) {
            $(this).removeClass("disabled");
        } else {
            $(this).addClass("disabled");
        }
    });
    $("#submit").click(function () {
        submit();
    });

    function submit() {
        $("#nomeAluno").text("Aguardando Leitura").addClass("green-text");
        $(".codigo-hide").show(500);
        $("#matricula").focus();
        $(".hidden").hide(500);
        var codigo = $("#codigo").val();
        var alimentos_selecionados = [];
        $(".btn-active").each(function () {
            if (!$(this).hasClass("disabled")) {
                alimentos_selecionados.push($(this).attr("id"));
            }
        });
        var request = $.ajax({
            method: "POST",
            url: "control/VerificaAlimentos",
            data: {codigo: codigo, alimentos_selecionados: alimentos_selecionados.toString()}
        });
        request.done(function (msg) {
//            alert("Data Saved: " + msg);
        });
        request.fail(function (jqXHR, textStatus) {
//            alert("Request failed: " + textStatus);
        });
        $(".btn-active").each(function () {
            if ($(this).hasClass("disabled")) {
                $(this).removeClass("disabled");
            }
        });
        $("#matricula").val("").focus();
    }

});
function UpdateTime() {
    var today = new Date();
    var hour = today.getHours();
    var mins = today.getMinutes();
    var secs = today.getSeconds();
    if (hour <= 9) {
        hour = "0" + hour;
    }
    if (mins <= 9) {
        mins = "0" + mins;
    }
    if (secs <= 9) {
        secs = "0" + secs;
    }

    var TotalTime = hour + ":" + mins + ":" + secs;
    document.getElementById("time").innerHTML = TotalTime;
    setTimeout("UpdateTime()", 1000);
}

function abrirLightbox(id) {
    $(id).fadeIn('fast');
}
function fecharLightbox() {
    $("lightbox").fadeOut('fast');
}
$(document).keydown(function (e) {
    if ((e.which == 74) && (e.ctrlKey || e.metaKey)) {
        alert("ctrl j");
        e.preventDefault();
    }

});
function getWindowHeight() {
    var windowHeight = 0;
    if (typeof (document.innerHeight) == 'number') {
        windowHeight = document.innerHeight;
    }
    else {
        if (document.documentElement && document.documentElement.clientHeight) {
            windowHeight = document.documentElement.clientHeight;
        }
        else {
            if (document.body && document.body.clientHeight) {
                windowHeight = document.body.clientHeight;
            }
        }
    }
    return windowHeight;
}
function setContent() {
    if (document.getElementById) {
        var windowHeight = getWindowHeight();
        if (windowHeight > 0) {
            var contentElement = document.getElementById('content');
            var contentHeight = contentElement.offsetHeight;
            if (windowHeight - contentHeight > 0) {
                contentElement.style.position = 'relative';
                contentElement.style.top = ((windowHeight / 2) - (contentHeight / 2)) + 'px';
            }
            else {
                contentElement.style.position = 'static';
            }
        }
    }
}
