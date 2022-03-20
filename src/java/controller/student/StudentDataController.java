/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

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
public class StudentDataController extends HttpServlet {

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
        StudentAccount acc = (StudentAccount) request.getSession().getAttribute("account");
        
        if (acc == null){
           request.getRequestDispatcher("view/login.jsp").forward(request, response); 
        } else
        request.getRequestDispatcher("view/student/studentData.jsp").forward(request, response);
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
        StudentAccount acc = (StudentAccount) request.getSession().getAttribute("account");
        
        String raw_name = request.getParameter("name");       
        String raw_gender = request.getParameter("gender");
        String raw_idcard = request.getParameter("idcard");
        String raw_grade = request.getParameter("grade");
        String raw_phone = request.getParameter("phone");
        String raw_email = request.getParameter("email");
        String raw_address = request.getParameter("address");
        
        String name = raw_name;
        boolean gender = Boolean.parseBoolean(raw_gender);
        String idcard = raw_idcard;
        int grade = Integer.parseInt(raw_grade);
        String phone = raw_phone;
        String email = raw_email;
        String address = raw_address;
        
        Student s = acc.getStudent();
        s.setSid(acc.getStudent().getSid());
        s.setSname(name);
        s.setGender(gender);
        s.setIdCard(idcard);
        s.setGrade(grade);
        s.setPhoneNumber(phone);
        s.setEmail(email);
        s.setAddress(address);
        
        StudentDBContext db = new StudentDBContext();
        db.UpdateStudent(s);
        request.setAttribute("done", "Done!");
        request.getRequestDispatcher("view/student/studentData.jsp").forward(request, response);
        /*response.getWriter().println(raw_name);
        response.getWriter().println(raw_gender);
        response.getWriter().println(raw_idcard);
        response.getWriter().println(raw_grade);
        response.getWriter().println(raw_phone);
        response.getWriter().println(raw_email);
        response.getWriter().println(raw_address);
        
        response.getWriter().println(s.getSid());
        response.getWriter().println(s.getSname());
        response.getWriter().println(s.getIdCard());
        response.getWriter().println(s.getGrade());
        response.getWriter().println(s.getPhoneNumber());
        response.getWriter().println(s.getAddress());
        response.getWriter().println(s.getEmail());*/
        
        
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
