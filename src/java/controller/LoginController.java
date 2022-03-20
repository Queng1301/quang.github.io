/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDBContext;
import dal.AnnouncementDBContext;
import dal.ReportDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Announcement;
import model.ManagerAccount;
import model.Report;
import model.Student;
import model.StudentAccount;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDBContext db = new AccountDBContext();
        AnnouncementDBContext adb = new AnnouncementDBContext();
        ReportDBContext rdb = new ReportDBContext();

        String whoLogin = (String) request.getSession().getAttribute("whoLogin");
        if (whoLogin.equals("Student")) {
            StudentAccount account = db.getStudentAccount(username, password);
            if (account == null) {
                request.getSession().setAttribute("account", null);
                request.setAttribute("loginFail", "Incorrect Username or Password! Please try again!");
                request.getRequestDispatcher("view/login.jsp").forward(request, response); 
            } else {
                ArrayList<Announcement> anns = adb.getAnns();
                
                request.getSession().setAttribute("account", account);
                request.setAttribute("anns", anns);
                request.getRequestDispatcher("view/student/home.jsp").forward(request, response);
                /*Student s = account.getStudent();
                response.getWriter().println(s.getSid());
                response.getWriter().println(s.getSname());
                response.getWriter().println(s.getGrade());
                response.getWriter().println(s.isGender());
                response.getWriter().println(s.getEmail());
                response.getWriter().println(s.getPhoneNumber());
                response.getWriter().println(s.getIdCard());
                response.getWriter().println(s.getAddress());
                response.getWriter().println(s.getParent());*/
            }
        } else {
            ManagerAccount account = db.getManagerAccount(username, password);

            if (account == null) {
                request.getSession().setAttribute("account", null);
                request.setAttribute("loginFail", "Incorrect Username or Password! Please try again!");
                request.getRequestDispatcher("view/login.jsp").forward(request, response); 
            } else {
                ArrayList<StudentAccount> stu = db.getStudents();
                ArrayList<Announcement> anns = adb.getAnns();
                ArrayList<Report> rps = rdb.getReports();
                
                request.setAttribute("stu", stu);
                request.setAttribute("anns", anns);
                request.setAttribute("rps", rps);
                request.getSession().setAttribute("account", account);
                //response.getWriter().println(stu.size());
                request.getRequestDispatcher("view/manager/home.jsp").forward(request, response); 
                /*response.getWriter().println(account.getId());
                response.getWriter().println(account.getUsername());
                response.getWriter().println(account.getPassword());*/
            }
        }
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
