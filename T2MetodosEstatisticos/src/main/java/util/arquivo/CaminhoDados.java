package util.arquivo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by allanmoreira on 15/10/16.
 */
public class CaminhoDados {
    public String caminhoPlanilhaDados() {
//            throws UnsupportedEncodingException {
        /*
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        fullPath = pathArr[0];

        String reponsePath = "";
        // to read a file from webcontent
        reponsePath = new File(fullPath).getPath() +
                File.separatorChar +
                "dados" +
                File.separatorChar +
                "Trabalho_T2.xls";
        */
        return "/home/servidor_publico/glassfish4/glassfish/domains/domain1/applications/T2MetodosEstatisticos/dados/Trabalho_T2.xls";
    }
}
