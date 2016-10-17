package servlet;

import com.google.gson.Gson;
import logica.Dados;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.Calculo;
import util.Estatistica;
import util.arquivo.LeituraPlanilha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allanmoreira on 15/10/16.
 */

@Controller
public class ServletPrincipal {
//    private static Logger logger = Logger.getLogger(ServletPrincipal.class);
    private ArrayList<Dados> listaDados;
    private Map<String, Object> map;
    @RequestMapping("home")
    public ModelAndView paginaPrincipal() throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("dados_populacionais")
    public void dadosPopulacionais(HttpServletResponse response) throws IOException {
        map = new HashMap<>();
        boolean isValid = false;
        String msgErro = null;
        try {
            listaDados = new LeituraPlanilha().lerPlanilha();
            isValid = true;
        } catch (IOException e) {
            msgErro = e.getMessage();
        }

        map.put("isValid", isValid);
        map.put("msgErro", msgErro);
        map.put("listaDados", listaDados);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }

    @RequestMapping("param_populacionais")
    public void parametrosPopulacionais(HttpServletRequest request, HttpServletResponse response) throws IOException {
        map = new HashMap<>();
        boolean isValid = true;
        String msgErro = null;
        Estatistica estatistica = new Estatistica();
        Calculo calculo = new Calculo();

        ArrayList<Integer> listaIdadeCandA = new ArrayList<>();
        ArrayList<Integer> listaIdadeCandC = new ArrayList<>();

        for (Dados d : listaDados) {
            if(d.getCandidato().equals("A")) {
                listaIdadeCandA.add(d.getIdade());
            }
            else if(d.getCandidato().equals("C")) {
                listaIdadeCandC.add(d.getIdade());
            }
        }

        BigDecimal mediaA = estatistica.media(listaIdadeCandA);
        BigDecimal mediaC = estatistica.media(listaIdadeCandC);

        int qtdeVotosA = listaIdadeCandA.size();
        int qtdeVotosC = listaIdadeCandC.size();

        BigDecimal propVotosA = calculo.multiplica(new BigDecimal(100), calculo.divide(new BigDecimal(qtdeVotosA), new BigDecimal(listaDados.size())));
        BigDecimal propVotosC = calculo.multiplica(new BigDecimal(100), calculo.divide(new BigDecimal(qtdeVotosC), new BigDecimal(listaDados.size())));

        map.put("isValid", isValid);
        map.put("msgErro", msgErro);
        map.put("mediaA", mediaA);
        map.put("mediaC", mediaC);
        map.put("qtdeVotosA", qtdeVotosA);
        map.put("qtdeVotosC", qtdeVotosC);
        map.put("propVotosA", propVotosA.doubleValue() + "%");
        map.put("propVotosC", propVotosC.doubleValue() + "%");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }

}
