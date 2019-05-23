import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
    Map<String, String> hashMap = new HashMap<>();
    @Override
    public void init() throws ServletException {
        hashMap.put("1", "Edik");
        hashMap.put("2", "Dima");
        hashMap.put("3", "Diana");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        String key = request.getParameter("key");

        printWriter.println("<html>");

        if(key.equals("")){
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

        for(Map.Entry<String, String> item : hashMap.entrySet()){
            if(key.equals(item.getKey())){
                printWriter.println("<h1>" + item.getKey() + " : " + item.getValue() + "</h1>");
            }
        }
        printWriter.println("</html>");
    }
}
