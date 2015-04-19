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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JITHZZ
 */@WebServlet("/booking")
public class Booking extends HttpServlet {
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
          String bid=req.getParameter("id");
            String bname=req.getParameter("name");
            HttpSession ses=req.getSession(true);
            String uid=(String)ses.getAttribute("id");
            String name=(String)ses.getAttribute("name");
            String query="INSERT INTO bookings(userid, name, bookid, booktitle) VALUES(?, ?, ?, ?)";
            String qry="UPDATE books SET availableno=availableno - 1 WHERE bookid=?";
        try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, uid);
            pstmt.setString(2, name);
            pstmt.setString(3, bid);
            pstmt.setString(4, bname);
            pstmt.executeUpdate();
            PreparedStatement pst = con.prepareStatement(qry); 
            pst.setString(1, bid);
            pst.executeUpdate();
            res.sendRedirect("books");
     }   catch (SQLException ex) {
             Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
