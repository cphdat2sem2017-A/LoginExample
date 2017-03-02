/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tobias
 */
@WebServlet(urlPatterns =
{
    "/Main"
})
public class Main extends HttpServlet
{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        LoginService loginService = new DummyLoginService();
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("login".equals(action))
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = loginService.login(email, password);
            if(user == null)
            {
                //Login failed
                sendLoginForm(request, response);
                return;
            }
            request.getSession().setAttribute("user", user);
            sendIndex(request, response);
            return;
        }
        
        User user = (User) request.getSession().getAttribute("user");
        if(user == null)
        {
            sendLoginForm(request, response);
            return;
        }
        if(action == null)
        {
            sendIndex(request, response);
        }
        else if("cake".equals(action))
        {
            sendCake(request, response);
        }
        else if("cup".equals(action))
        {
            sendCup(request, response);
        }
        else
        {
            sendNotFound(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    private void sendLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form action=\"Main\" method=\"post\">");
            out.println("Email: <input type=\"text\" name=\"email\" />");
            out.println("Pasword: <input type=\"password\" name=\"password\" />");
            out.println("<input type=\"submit\" value=\"Login\">");
            out.println("<input type=\"hidden\" name=\"action\" value=\"login\">");
            out.println("</form>");    
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Index</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendCake(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cake</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Let them have cake!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendCup(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Here is a cup of tea!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendNotFound(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>NotFound</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Action not found</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
