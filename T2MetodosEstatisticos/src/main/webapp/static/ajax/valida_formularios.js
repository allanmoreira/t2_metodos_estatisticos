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

$(function() {
    $('#botao_param_pop').click(function() {
        comport_estimadores();
    });
});

$(function() {
    $('#link_comport_estim').click(function() {
        comport_estimadores();
    });
});

function dadosPopulacionais() {
    // waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 3000);
    $('#div_home').hide(1000);
    $('#div_tabela_param_populacionais').hide(1000);
    $('#div_tabela_comport_estim').hide(1000);
    $('#div_tabela_dados_populacionais').show(1000);
    $('#item_lista_dados_populacionais').addClass("active");
}

function paramPopulacionais() {
    $('#div_home').hide(500);
    $('#div_tabela_dados_populacionais').hide(500);
    $('#div_tabela_comport_estim').hide(1000);
    $('#div_tabela_param_populacionais').show(500);
    $('#item_lista_dados_populacionais').removeClass("active");
    $('#item_lista_comport_estim').removeClass("active");
    $('#item_lista_param_populacionais').addClass("active");
    ajaxParamPopulacionais();
}

function comport_estimadores() {
    $('#div_home').hide(500);
    $('#div_tabela_dados_populacionais').hide(500);
    $('#div_tabela_param_populacionais').hide(500);
    $('#div_tabela_comport_estim').show(1000);
    $('#item_lista_dados_populacionais').removeClass("active");
    $('#item_lista_param_populacionais').removeClass("active");
    $('#item_lista_comport_estim').addClass("active");
    ajaxComportamEstimadores();
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
                        "<td>" + data.varianciaA + "</td>" +
                        "<td>" + data.desvioPadraoA + "</td>" +
                    "</tr>"
                );
                $('#tabela_param_populacionais').append(
                    "<tr>" +
                        "<td>C</td>" +
                        "<td>" + data.qtdeVotosC + "</td>" +
                        "<td>" + data.propVotosC + "</td>" +
                        "<td>" + data.mediaC + "</td>" +
                        "<td>" + data.varianciaC + "</td>" +
                        "<td>" + data.desvioPadraoC + "</td>" +
                    "</tr>"
                );

                var listaFreqA = data.tabelaFreqA;
                var cont = 1;
                $.each(listaFreqA, function (i) {
                    $('#tabela_freq_A').append(
                        "<tr>" +
                        "<td>" + cont + "</td>" +
                        "<td>" + listaFreqA[i].xi + "</td>" +
                        "<td>" + listaFreqA[i].fi + "</td>" +
                        "</tr>"
                    );
                    cont++;
                });

                var listaFreqC = data.tabelaFreqC;
                $.each(listaFreqC, function (i) {
                    $('#tabela_freq_C').append(
                        "<tr>" +
                        "<td>" + i + "</td>" +
                        "<td>" + listaFreqC[i].xi + "</td>" +
                        "<td>" + listaFreqC[i].fi + "</td>" +
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

function ajaxComportamEstimadores(){
    $.ajax({
        url: 'comport_estimadores',
        async: true,
        type: 'POST',
        dataType: 'json',
        data: {'submit': true},
        success: function (data) {
            if(data.isValid){
                var cont = 1;
                var lista = data.listaEstimadores;
                var linha_tabela;
                $.each(lista, function (i) {
                    linha_tabela =
                        "<tr>" +
                            "<td>" + cont + "</td>" +
                            "<td>";
                                var conteudo_amostra = '';
                                var listaAmostra = lista[i].listaFrequencias;
                                $.each(listaAmostra, function (j) {
                                    conteudo_amostra += listaAmostra[j].xi + ", ";
                                });

                            linha_tabela+= conteudo_amostra + "</td>" +
                            "<td>" + lista[i].media + "</td>" +
                            "<td>" + lista[i].pChapeu + "</td>" +
                        "</tr>";
                    $('#tabela_comport_estim').append(linha_tabela);
                    cont++;
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
