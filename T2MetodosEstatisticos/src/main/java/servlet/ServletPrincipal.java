package servlet;

import com.google.gson.Gson;
import logica.Dados;
import logica.Estimador;
import logica.Frequencia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.Calculo;
import util.Estatistica;
import util.Ordenacao;
import util.arquivo.LeituraPlanilha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

    private void parametrosPopulacionais() throws UnsupportedEncodingException {
        listaDados = new LeituraPlanilha().lerPlanilha();
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
        Estatistica estatistica = new Estatistica();

        listaIdadeCandA = new ArrayList<Integer>();
        listaIdadeCandC = new ArrayList<Integer>();

        for (Dados d : listaDados)
            if (d.getCandidato().equals("A"))
                listaIdadeCandA.add(d.getIdade());
            else if (d.getCandidato().equals("C"))
                listaIdadeCandC.add(d.getIdade());

        double mediaA = estatistica.media(listaIdadeCandA);
        int qtdeVotosA = listaIdadeCandA.size();
        double proporcaoVotosA = 100 * (qtdeVotosA/listaIdadeCandA.size());
        tabelaFreqA = estatistica.tabelaFrequencia(listaIdadeCandA);
        Ordenacao.bubbleSortOtimizado(tabelaFreqA);
        double varianciaA = estatistica.variancia(tabelaFreqA, mediaA, listaDados.size());
        double desvioPadraoA = estatistica.desvioPadrao(varianciaA);
        // ----------------------------------------------------------------
        double mediaC = estatistica.media(listaIdadeCandC);
        int qtdeVotosC = listaIdadeCandC.size();
        double proporcaoVotosC = 100 * (qtdeVotosC/listaIdadeCandC.size());
        tabelaFreqC = estatistica.tabelaFrequencia(listaIdadeCandC);
        Ordenacao.bubbleSortOtimizado(tabelaFreqC);
        double varianciaC = estatistica.variancia(tabelaFreqC, mediaC, listaDados.size());
        double desvioPadraoC = estatistica.desvioPadrao(varianciaC);

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
        map = new HashMap<String, Object>();
        boolean isValid = true;
        String msgErro = null;
        Estatistica estatistica = new Estatistica();

//        ArrayList<Frequencia> amostra1 = estatistica.extraiAmostrasAleatorias(tabelaFreqA);
//        ArrayList<Integer> listaAmostras = new ArrayList<Integer>(amostra1.size());

//        for (Frequencia f : amostra1)
//            listaAmostras.add(f.getXi());

//        double media = estatistica.media(listaAmostras);

        List<Set<Frequencia>> subConjutos = estatistica.subConjutos(tabelaFreqA, 15, 500);

        ArrayList<Estimador> listaEstimadores;
        listaEstimadores = estatistica.comportamentoEstimadores(subConjutos, 500, estatistica.media(listaIdadeCandA));

        map.put("isValid", isValid);
        map.put("msgErro", msgErro);
        map.put("listaEstimadores", listaEstimadores);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }

}
