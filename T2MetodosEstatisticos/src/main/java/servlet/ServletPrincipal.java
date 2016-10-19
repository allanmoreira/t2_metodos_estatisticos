package servlet;

import com.google.gson.Gson;
import logica.Dados;
import logica.Amostra;
import logica.Frequencia;
import logica.IntervConfianca;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.Estatistica;
import util.Ordenacao;
import util.arquivo.LeituraPlanilha;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by allanmoreira on 15/10/16.
 */

@Controller
public class ServletPrincipal {
//    private static Logger logger = Logger.getLogger(ServletPrincipal.class);
    private ArrayList<Dados> listaDados;
    private Map<String, Object> map;
    private ArrayList<Integer> listaIdadeCandA;
    private ArrayList<Integer> listaIdadeCandC;
    private ArrayList<Frequencia> tabelaFreqA;
    private ArrayList<Frequencia> tabelaFreqC;
    private double mediaA;
    private double qtdeVotosA;
    private double proporcaoVotosA;
    private double varianciaA;
    private double desvioPadraoA;
    private double mediaC;
    private double qtdeVotosC;
    private double proporcaoVotosC;
    private double varianciaC;
    private double desvioPadraoC;

    private void parametrosPopulacionais() throws UnsupportedEncodingException {
        listaDados = new LeituraPlanilha().lerPlanilha();

        Estatistica estatistica = new Estatistica();

        listaIdadeCandA = new ArrayList<Integer>();
        listaIdadeCandC = new ArrayList<Integer>();

        for (Dados d : listaDados)
            if (d.getCandidato().equals("A"))
                listaIdadeCandA.add(d.getIdade());
            else if (d.getCandidato().equals("C"))
                listaIdadeCandC.add(d.getIdade());

        mediaA = estatistica.media(listaIdadeCandA);
        qtdeVotosA = listaIdadeCandA.size();
        proporcaoVotosA = 100 * (qtdeVotosA/listaDados.size());
        proporcaoVotosA = Estatistica.arredonda(proporcaoVotosA, 4);
        tabelaFreqA = estatistica.tabelaFrequencia(listaIdadeCandA);
        Ordenacao.bubbleSortOtimizado(tabelaFreqA);
        varianciaA = estatistica.variancia(tabelaFreqA, mediaA, listaDados.size());
        desvioPadraoA = estatistica.desvioPadrao(varianciaA);
        // ----------------------------------------------------------------
        mediaC = estatistica.media(listaIdadeCandC);
        qtdeVotosC = listaIdadeCandC.size();
        proporcaoVotosC = 100 * (qtdeVotosC/listaDados.size());
        proporcaoVotosC = Estatistica.arredonda(proporcaoVotosC, 4);
        tabelaFreqC = estatistica.tabelaFrequencia(listaIdadeCandC);
        Ordenacao.bubbleSortOtimizado(tabelaFreqC);
        varianciaC = estatistica.variancia(tabelaFreqC, mediaC, listaDados.size());
        desvioPadraoC = estatistica.desvioPadrao(varianciaC);
    }

    @RequestMapping("home")
    public ModelAndView paginaPrincipal() throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();

        parametrosPopulacionais();

        mv.setViewName("home");
        mv.addObject("listaDados", listaDados);
        return mv;
    }

    @RequestMapping("param_populacionais")
    public void parametrosPopulacionais(HttpServletResponse response) throws IOException {
        map = new HashMap<String, Object>();
        boolean isValid = true;
        String msgErro = null;

        map.put("isValid", isValid);
        map.put("msgErro", msgErro);
        // ------------------------------------
        map.put("mediaA", mediaA);
        map.put("qtdeVotosA", qtdeVotosA);
        map.put("propVotosA", proporcaoVotosA + "%");
        map.put("tabelaFreqA", tabelaFreqA);
        map.put("varianciaA", varianciaA + "²");
        map.put("desvioPadraoA", desvioPadraoA);
        // ------------------------------------
        map.put("mediaC", mediaC);
        map.put("qtdeVotosC", qtdeVotosC);
        map.put("propVotosC", proporcaoVotosC + "%");
        map.put("tabelaFreqC", tabelaFreqC);
        map.put("varianciaC", varianciaC + "²");
        map.put("desvioPadraoC", desvioPadraoC);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }

    @RequestMapping("comport_estimadores")
    public void comportamentoEstimadores(HttpServletResponse response) throws IOException {
        map = new HashMap<>();
        boolean isValid = true;
        String msgErro = null;
        Estatistica estatistica = new Estatistica();

        List<Set<Frequencia>> subConjutos = estatistica.subConjutos(tabelaFreqA, 15, 500);

        ArrayList<Amostra> listaAmostras = estatistica.comportamentoEstimadores(subConjutos, 500, estatistica.media(listaIdadeCandA));

        double mediaTeorema = estatistica.mediaTeorema(listaAmostras);
        double pChapeuTeorema = estatistica.pChapeuTeorema(mediaTeorema, 500, listaAmostras);
        double pChapeuXNormal = estatistica.pChapeuXNormal(desvioPadraoA, 15, tabelaFreqA.size());

        for (Amostra amostra : listaAmostras) {
            IntervConfianca intervConfianca = estatistica.intervaloDeConfianca(amostra.getMedia(), desvioPadraoA, 5000, 15);
            amostra.setIntervConfianca(intervConfianca);
        }

        map.put("isValid", isValid);
        map.put("msgErro", msgErro);
        map.put("mediaA", mediaA);
        map.put("pChapeuXNormal", pChapeuXNormal);
        map.put("pChapeuTeorema", pChapeuTeorema);
        map.put("mediaTeorema", mediaTeorema);
        map.put("listaAmostras", listaAmostras);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }

}
