/**
 * Created by allanmoreira on 16/10/16.
 */
$(function() {
    $('#botao_comecar').click(function() {
        dadosPopulacionais();
    });
});

$(function() {
    $('#link_dados_populacionais').click(function() {
        dadosPopulacionais();
    });
});

$(function() {
    $('#botao_dados_pop').click(function() {
        paramPopulacionais();
    });
});

$(function() {
    $('#link_param_populacionais').click(function() {
        paramPopulacionais();
    });
});

function dadosPopulacionais() {
    // waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 3000);
    $('#div_home').hide(500);
    $('#div_tabela_param_populacionais').hide(500);
    $('#div_tabela_dados_populacionais').show(500);
    $('#item_lista_dados_populacionais').addClass("active");
    ajaxDadosPopulacionais();
}

function paramPopulacionais() {
    $('#div_home').hide(500);
    $('#div_tabela_dados_populacionais').hide(500);
    $('#div_tabela_param_populacionais').show(500);
    $('#item_lista_dados_populacionais').removeClass("active");
    $('#item_lista_param_populacionais').addClass("active");
    ajaxParamPopulacionais();
}

function ajaxDadosPopulacionais(){

    $.ajax({
        url: 'dados_populacionais',
        async: true,
        type: 'POST',
        dataType: 'json',
        data: {'submit': true},
        success: function (data) {
            if(data.isValid){
                var lista = data.listaDados;
                $('#tabela_dados_populacionais tbody').remove();
                $.each(lista, function (i) {
                    $('#tabela_dados_populacionais').append(
                        "<tr>" +
                            "<td>" + lista[i].id + "</td>" +
                            "<td>" + lista[i].idade + "</td>" +
                            "<td>" + lista[i].candidato + "</td>" +
                        "</tr>"
                    );
                });
            }
            else {
                $.bootstrapGrowl(data.msgErro, {
                    type:'danger',
                    align:'center',
                    width: 'auto',
                    allow_dismiss: false
                });
            }
        }
    });
    return false;
}

function ajaxParamPopulacionais(){
    $.ajax({
        url: 'param_populacionais',
        async: true,
        type: 'POST',
        dataType: 'json',
        data: {'submit': true},
        success: function (data) {
            if(data.isValid){
                var lista = data.listaDados;
                $('#tabela_param_populacionais tbody').remove();
                $('#tabela_param_populacionais').append(
                    "<tr>" +
                        "<td>A</td>" +
                        "<td>" + data.qtdeVotosA + "</td>" +
                        "<td>" + data.propVotosA + "</td>" +
                        "<td>" + data.mediaA + "</td>" +
                    "</tr>"
                );
                $('#tabela_param_populacionais').append(
                    "<tr>" +
                        "<td>C</td>" +
                        "<td>" + data.qtdeVotosC + "</td>" +
                        "<td>" + data.propVotosC + "</td>" +
                        "<td>" + data.mediaC + "</td>" +
                    "</tr>"
                );

            }
            else {
                $.bootstrapGrowl(data.msgErro, {
                    type:'danger',
                    align:'center',
                    width: 'auto',
                    allow_dismiss: false
                });
            }
        }
    });
    return false;
}
