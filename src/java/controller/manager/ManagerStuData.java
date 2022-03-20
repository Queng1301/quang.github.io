/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.AccountDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentAccount;

/**
 *
 * @author Admin
 */
public class ManagerStuData extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagerStuData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerStuData at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
        AccountDBContext db = new AccountDBContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        StudentAccount account = db.getStudentAccount(username, password);
        request.setAttribute("account", account);
        request.getRequestDispatcher("view/manager/studentData.jsp").forward(request, response);
        //response.getWriter().println(account.getUsername());
        //response.getWriter().print(account.getPassword());
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
            throws ServletException, IOException {
        String raw_sid = request.getParameter("sid");
        
        String raw_name = request.getParameter("name");       
        String raw_gender = request.getParameter("gender");
        String raw_idcard = request.getParameter("idcard");
        String raw_grade = request.getParameter("grade");
        String raw_phone = request.getParameter("phone");
        String raw_email = request.getParameter("email");
        String raw_address = request.getParameter("address");
        
        int sid = Integer.parseInt(raw_sid);
        String name = raw_name;
        boolean gender = Boolean.parseBoolean(raw_gender);
        String idcard = raw_idcard;
        int grade = Integer.parseInt(raw_grade);
        String phone = raw_phone;
        String email = raw_email;
        String address = raw_address;
        
        Student s = new Student();
        s.setSid(sid);
        s.setSname(name);
        s.setGender(gender);
        s.setIdCard(idcard);
        s.setGrade(grade);
        s.setPhoneNumber(phone);
        s.setEmail(email);
        s.setAddress(address);
        
        StudentDBContext db = new StudentDBContext();
        db.UpdateStudent(s);
        response.getWriter().print("Done!");
        request.setAttribute("done", "Done!");
        //request.getRequestDispatcher("view/manager/studentData.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
