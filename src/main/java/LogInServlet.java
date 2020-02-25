import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LogInServlet", urlPatterns = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null) {

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("Mari","1234");
            brugerMap.put("admin","1234");

            servletContext.setAttribute("brugerMap", brugerMap);

        }

        if(((Set<String>)servletContext.getAttribute("aktiveBrugere"))== null) {

            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);

        }

        if (!(session.getAttribute("besked") == null) ) {
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request, response );


        }

        if (!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {


            request.setAttribute("besked", "Det brugernavn du tastet ind findes ikke, her kan du opprette dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }

        if (((Map<String, String>)servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            if(navn.equalsIgnoreCase("admin")) {
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);

            }

            if(!((Set<String>)servletContext.getAttribute("aktiveBrugere")).contains(navn)) {

                ((Set<String>)servletContext.getAttribute("aktiveBrugere")).add(navn);

                session.setAttribute("besked", "Du er logget inn med følgende brugernavn: " + navn);
                session.setAttribute("navn",  navn);

                request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request, response);
            }
        }
        //todo gå til login (dvs index-side

        request.setAttribute("besked", "Du har tastet fejl kodeord eller er allerede logget ind et annet sted, venligst prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
