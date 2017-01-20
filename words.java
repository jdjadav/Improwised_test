
package reverse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "words", urlPatterns = {"/reverse/words"})
public class words extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/plain;");
         response.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter out = response.getWriter();
        String str=request.getParameter("str");
              String reverse="";
        String[] words=str.split(" ");
        for(int i=0 ;i<words.length;i++)
        {
           String word=words[i];
           String reword="";
           for(int j=word.length()-1 ;j >= 0;j--)
           {
               reword+=word.charAt(j); 
           }
           reverse=reverse+reword+" ";
        }
         reverse= reverse.substring(0,reverse.length()-1);
      out.print(reverse);
    
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
