

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

        private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        	String poidsParam = request.getParameter("poids");
            String tailleParam = request.getParameter("taille");

            if (poidsParam != null && tailleParam != null) {
                try {
                    double poids = Double.parseDouble(poidsParam);
                    double taille = Double.parseDouble(tailleParam);

                    Imc imc = new Imc(taille, poids);
                    double resultat = imc.calcul();

                    response.setContentType("text/html");
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h2>Votre IMC est : " + String.format("%.2f", resultat) + "</h2>");
                    response.getWriter().println("</body></html>");
                } catch (NumberFormatException e) {
                    response.getWriter().println("<html><body><h3>Erreur : Entrez des valeurs numériques valides.</h3></body></html>");
                }
            } else {
                response.getWriter().println("<html><body><h3>Veuillez entrer votre poids et votre taille.</h3></body></html>");
            }
    }

}
