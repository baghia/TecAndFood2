/*$=jQuery;*/
var key_codes = [8, 9, 13, 16, 17, 18, 19, 20, 33, 34, 35, 36, 37, 38, 39, 40, 44, 45, 46, 92, 93, 113, 115, 118, 119, 120, 121, 122, 123, 144, 145];
$(document).ready(function() {
    $("sidebar li a").click(function() {
        $(this).parent("li").children("ul").slideToggle(100);
    });
    $("#light").click(function() {
        $("#novo").fadeIn(100);
    });
    $("fechar").click(function() {
        $(this).parent("form").parent("lightbox").fadeOut(100);
    });

});
$(window).resize(function() {
    $("sidebar").css("min-width", "206px");
    if ($(window).height() <= 656) {
        //alert("menor");
        $("#footer").css("display", "none");
    } else {
        $("#footer").css("display", "block");
    }
    if ($(window).height() <= 603) {
        $("#logo").fadeOut('fast');
    } else {
        $("#logo").fadeIn('fast');
    }
});
$(window).load(function() {
    $("body").append("" +
            "<style>" +
            "h1{color:" + c_n + "}" +
            "sidebar a, table:not(.ui-datepicker-calendar) th{color:#fff}" +
            "button, table:not(.ui-datepicker-calendar) th, .button{background: " + c_n + "; border-color: " + c_n + ";box-shadow: none}" +
            "button:hover,.button:hover {background: " + c_h + "; border-color: " + c_h + "; text-decoration: none}" +
            "a.button:hover{color: #fff }" +
            "button:active, button:focus{background: " + c_a + "}" +
            "table:not(.ui-datepicker-calendar), table:not(.ui-datepicker-calendar) th, table:not(.ui-datepicker-calendar) td, table:not(.ui-datepicker-calendar) tr{border-color:" + c_n + "}" +
            "/*[scope=col] { background: #fff}*/" +
            "tabela {border: 1px solid " + c_n + "}" +
            "textarea:hover, select:hover,input:hover{border-color: " + c_h + "}" +
            "textarea:active, textarea:focus, select:active, input:active, select:focus,input:focus{border-color: " + c_a + "}" +
            "table:not(.ui-datepicker-calendar) tr:nth-child(even){background:" + even + " }" +
            "table:not(.ui-datepicker-calendar) tr:hover {background:" + hover + " }" +
            ".pagination>.active>a {background-color: " + c_h + "; border-color: " + c_n + "}" +
            ".pagination>.active>a:hover {background-color: " + hoverB + "; border-color: " + hoverB + "}" +
            ".pagination>li>a, .pagination>li>a:hover {color: " + c_n + "}" +
            "</style>" +
            "");
    $("sidebar").css("min-width", "206px");
    if ($(window).height() <= 656) {
        //alert("menor");
        $("#footer").css("display", "none");
    } else {
        $("#footer").css("display", "block");
    }
    if ($(window).height() <= 603) {
        $("#logo").css("display", "none");
    } else {
        $("#logo").css("display", "block");
    }
});