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

/**
 *
 * @author JITHZZ
 */
@WebServlet("/deletebooks")
public class DeleteBooks extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
      String bid=req.getParameter("id");
      String query="DELETE FROM books WHERE bookid=?";
      try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, bid);
            pstmt.executeUpdate();
            res.sendRedirect("./Admin/adminHome");
    }   catch (SQLException ex) {
            Logger.getLogger(DeleteBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
