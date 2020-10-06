/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;


import com.udea.ejb.EnrollFacadeLocal;
import com.udea.ejb.StudentFacadeLocal;
import com.udea.ejb.SubjectsFacadeLocal;
import com.udea.modelo.Enroll;
import com.udea.modelo.Student;
import com.udea.modelo.Subjects;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
public class MainServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    @EJB
    private SubjectsFacadeLocal subjectFacade;
    @EJB
    private EnrollFacadeLocal enrollFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private int idlogeado=0;
  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if("list".equals(action)){
                List<Subjects> findAll = subjectFacade.findAll();
                request.getSession().setAttribute("subjects", findAll);
                url = "listSubjects.jsp";
            }         
            else if("login".equals(action)){
                int u = Integer.valueOf(request.getParameter("id"));
                String p = request.getParameter("password");
                Student a = (Student) studentFacade.getStudent(u);
                idlogeado = u;
                String name = a.getNameStudent();
                boolean checklogin = studentFacade.checkLogin(u, p);
                if(checklogin){  
                    request.getSession().setAttribute("login", u);
                    request.getSession().setAttribute("name", name);
                    url="manager.jsp";
            }else{
            url="login.jsp?error=1";
            
             }}
            else if("enroll".equals(action)){
                int u = Integer.valueOf(request.getParameter("id_subject"));
                Student logActual = (Student) studentFacade.getStudent(idlogeado);
                Subjects a = (Subjects) subjectFacade.getSubject(u);
                
                Enroll b = new Enroll();   
                b.setIdStudent(logActual.getId());
                b.setNameStudent(logActual.getNameStudent());                
                b.setSubject(a.getNameSubject());
                enrollFacade.create(b);
                url= "enroll.jsp";
            
            }
            else if("insert".equals(action)){
            Student a = new Student();
            a.setNameStudent(request.getParameter("nameStudent"));
            a.setUsername(request.getParameter("username"));
            a.setPassword(request.getParameter("password"));
            a.setEmail(request.getParameter("email"));
            studentFacade.create(a);
            url = "login.jsp";
            
            
        }else if("viewInfo".equals(action)){
              
            Student a = (Student) studentFacade.getStudent(idlogeado);           
            request.getSession().setAttribute("a",a);
            url = "updateInfo.jsp";
            
        }else if("update".equals(action)){
            Student b = (Student) studentFacade.getStudent(idlogeado); 
            b.setNameStudent(request.getParameter("nameStudent"));
            b.setUsername(request.getParameter("username"));
            b.setEmail(request.getParameter("email"));
            studentFacade.edit(b);
            url="login.jsp";         
        }
        else if("delete".equals(action)){
                
            int id = Integer.valueOf(request.getSession().getAttribute("login").toString());
            Student a = (Student) studentFacade.getStudent(id); 
            studentFacade.remove(a);
            url= "AccountServlet?action=list";
                }else if("logout".equals(action)){
                    request.getSession().removeAttribute("login");
                    url="login.jsp";
                    }
            response.sendRedirect(url);
        }finally{
            out.close();
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
            throws ServletException, IOException {
        processRequest(request, response);
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
