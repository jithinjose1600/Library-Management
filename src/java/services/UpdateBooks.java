/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Model.DBClass;
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
 * @author c0648991
 */
@WebServlet("/updatebooks")
public class UpdateBooks extends HttpServlet{
    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("b_id");
        String title = req.getParameter("b_name");
        String author = req.getParameter("b_author");
        String cat = req.getParameter("b_category");
        String des = req.getParameter("b_description");
        int quantity = Integer.parseInt(req.getParameter("b_quantity"));
        String query="UPDATE books SET booktitle=?, author=?, category=?, description=?, quantity=?, availableno=? WHERE bookid=?";
        try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, cat);
            pstmt.setString(4, des);
            pstmt.setInt(5, quantity);
            pstmt.setInt(6, quantity);
            pstmt.setString(7, id);
            pstmt.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(UpdateBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
