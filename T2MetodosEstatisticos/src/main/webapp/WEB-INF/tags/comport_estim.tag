<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="div_tabela_comport_estim" style="display:none">

    <div class="page-header">
        <h2 class="text-center">
            Comportamento dos Estimadores Para as Idades <br>
            das Pessoas que Votaram no <strong>Candidato "A"</strong></h2>
    </div>

    <div class="col-md-4">
        <div class="row blog-main">
            <p>
                Tendo em vista de que não era possível extrair todas as possíveis amostras de tamanho 15 da
                população, pois o número de combinações possíveis é muito grande, verificou-se o
                comportamento de 500 amostras do mesmo tamanho, chegando aos seguintes valores:
            </p>
        </div>

        <div class="row">
            <div class="page-header">
                <h4>Distribuição Amostral Para 500 Amostras n=15</h4>
            </div>
            <table class="table table-striped table-bordered" id="tabela_amostras">
                <thead>
                <tr>
                    <th></th>
                    <th>Média</th>
                    <th>Desvio-Padrão</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><strong>População</strong></td>
                    <td id="td_tabela_media_xnormal"></td>
                    <td id="td_tabela__dp_xnormal"></td>
                </tr>
                <tr>
                    <td><strong>Amostra</strong></td>
                    <td id="td_tabela_analise_media"></td>
                    <td id="td_tabela_analise_dp"></td>
                </tr>


                </tbody>
            </table>
        </div>

        <div class="row blog-main">
            <p>
                Ao atualizar as amostras, percebemos que, seguindo o teorema do limite central, o comportamento dos
                estimadores permaneceu com os valores em torno dos valores da população. Sendo assim, se assemelham à teoria.
            </p>

            <p>
                Há um botão para se atualizar as amostras, e assim verificar o comportamento com outros valores.
            </p>
        </div>
    </div>

    <div class="col-md-8">
        <a class="btn btn-primary btn-lg" id="botao_atualizar_comportam" role="button">Novas Amostras</a>

        <div class="page-header">
            <h3>500 amostras aleatórias de tamanho 15</h3>
        </div>

        <table class="table table-striped table-bordered" id="tabela_comport_estim">
            <thead>
            <tr>
                <th>#</th>
                <th>Amostra</th>
                <th>Média</th>
                <th>Interv Confiança (95%)</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        </div>

</div>

