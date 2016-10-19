<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="div_tabela_comport_estim" style="display:none">

    <div class="page-header">
        <h2 class="text-center">
            Comportamento dos Estimadores Para as Idades <br>
            das Pessoas que Votaram no Candidato "A"</h2>
    </div>

    <%--
    <div class="blog-post">
        <h2 class="blog-post-title">Sample blog post</h2>
    <div class="blog-post">
    --%>
    <%--<h2 class="blog-post-title">Another blog post</h2>--%>
    <%--<p class="blog-post-meta">December 23, 2013 by <a href="#">Jacob</a></p>--%>

    <div class="row">
        <div class="col-md-8 blog-main">
            <p>
                Tendo em vista de que não era possível extrair todas as possíveis amostras de tamanho 15 da
                população, mas verificando o comportamento de 500 amostras, percebeu-se que o comportamento
                dos estimadores
            </p>
        </div><!-- /.blog-post -->

        <div class="col-md-4">
            <table class="table table-striped table-bordered" id="tabela_analise">
                <thead>
                <tr>
                    <th>Média</th>
                    <th>Desvio-Padrão</th>
                </tr>
                </thead>
                <tbody>
                    <td id="td_tabela_analise_media"></td>
                    <td id="td_tabela_analise_dp"></td>
                </tbody>
            </table>
        </div>

    </div>

    <div class="row col-md-12">
        <a class="btn btn-primary btn-lg" id="botao_atualizar_comportam" role="button">Novas Amostras</a>
        <br>
        <br>
    </div>

    <div class="page-header">
        <h2>500 amostras aleatórias de tamanho 15</h2>
    </div>

    <div class="row">

    </div>

    <div class="page-header">
        <h3>500 amostras aleatórias de tamanho 15</h3>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-bordered" id="tabela_comport_estim">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Amostra</th>
                    <th>Média</th>
                    <th>Desvio-Padrão</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

</div>

