<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="div_tabela_dados_populacionais" style="display:none">
    <a class="btn btn-primary btn-lg" id="botao_dados_pop" role="button">Encontrar os parâmetros populacionais »</a>

    <div class="page-header">
        <h2>Dados Populacionais</h2>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-bordered" id="tabela_dados_populacionais">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Idade Eleitor</th>
                    <th>Candidato</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="listaDados" items="${listaDados}">
                        <tr>
                            <td>${listaDados.id}</td>
                            <td>${listaDados.idade}</td>
                            <td>${listaDados.candidato}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>