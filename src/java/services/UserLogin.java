/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Model.DBClass;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c0648991
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String email= req.getParameter("email");
       String password=req.getParameter("password"); 
       String query="SELECT id, fname, lname FROM users WHERE email=? AND password=?";
       try(Connection con=DBClass.getConnection()) {
         PreparedStatement pstmt = con.prepareStatement(query); 
         pstmt.setString(1, email);
         pstmt.setString(2, password);
         ResultSet rs = pstmt.executeQuery();
         ArrayList<String> ar=new ArrayList();
            while(rs.next())
            {
                /*String id=rs.getString("m_id");
                ar.add(id);
                String name= rs.getString("m_name");
                ar.add(name);
                ar.add(rs.getString("m_address"));
                ar.add(rs.getString("m_phone"));
                ar.add(rs.getString("m_email"));
                ar.add(rs.getString("m_type"));
                ar.add(rs.getString("m_uname"));
                ar.add(rs.getString("m_password"));
                HttpSession ses=req.getSession();
                ses.setAttribute("mem_name", name);
               ses.setAttribute("mem_id", id);
                req.setAttribute("lst", ar);*/
                RequestDispatcher disp=req.getRequestDispatcher("books");
                disp.forward(req, res);
            }
            res.sendRedirect("index.html");
       } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
