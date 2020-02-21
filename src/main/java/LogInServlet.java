import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LogInServlet", urlPatterns = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null) {

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test","test");
            brugerMap.put("admin","1234");

            servletContext.setAttribute("brugerMap", brugerMap);

        }


        if (!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //todo gå til log-ind-siden
            request.setAttribute("besked", "Det brugernavn du tastet ind findes ikke, her kan du opprette dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }

        if (((Map<String, String>)servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            if(navn.equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);

            }

            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request, response);
        }
        //todo gå til log ind (dvs index-side

        request.setAttribute("besked", "Du har tastet fejl kodeord, venligst prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
