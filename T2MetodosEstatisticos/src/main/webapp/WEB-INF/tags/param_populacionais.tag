<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="div_tabela_param_populacionais" style="display:none">
    <a class="btn btn-primary btn-lg" id="botao_param_pop" role="button">Verificar o Comportamento dos Estimadores »</a>

    <div class="page-header">
        <h2>Parâmetros Populacionais</h2>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-bordered" id="tabela_param_populacionais">
                <thead>
                <tr>
                    <th>Candidato</th>
                    <th>Qtde Votos</th>
                    <th>% Votos</th>
                    <th>Idade Média</th>
                    <th>Variância</th>
                    <th>Desvio-Padrão da Idade</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <div class="page-header">
        <h2>Tabelas de Frequência</h2>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="page-header">
                <h4>Candidato A</h4>
            </div>
            <table class="table table-striped table-bordered" id="tabela_freq_A">
                <thead>
                <tr>
                    <th>i</th>
                    <th>Xi</th>
                    <th>fi</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>

        <div class="col-md-6">
            <div class="page-header">
                <h4>Candidato C</h4>
            </div>
            <table class="table table-striped table-bordered" id="tabela_freq_C">
                <thead>
                <tr>
                    <th>i</th>
                    <th>Xi</th>
                    <th>fi</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

</div>

