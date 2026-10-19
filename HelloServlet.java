import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
            "<h2>Жас есептегіш</h2>" +
            "<form method='post'>" +
            "Туған жылыңызды енгізіңіз: " +
            "<input type='number' name='year' required>" +
            "<button type='submit'>Есептеу</button>" +
            "</form>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        int year = Integer.parseInt(request.getParameter("year"));
        int currentYear = Calendar.getInstance()
                                  .get(Calendar.YEAR);
        int age = currentYear - year;

        if (year <= 0 || year > currentYear) {
            response.getWriter().println(
                "Туған жылын дұрыс енгізіңіз!"
            );
        } else if (age < 18) {
            response.getWriter().println(
                "Жасыңыз: " + age +
                ". Кәмелетке толмаған."
            );
        } else {
            response.getWriter().println(
                "Жасыңыз: " + age +
                ". Кәмелетке толған."
            );
        }
    }
}
