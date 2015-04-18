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
@WebServlet("/return")
public class returnBooks extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String uid=request.getParameter("u_id");
            String bid=request.getParameter("b_id");
            String ret=request.getParameter("re_date");
            String query="UPDATE records SET returndate=? WHERE userid=? AND bookid=?";
            //String qry="UPDATE books SET availableno=availableno + 1 WHERE bookid=?";
            try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, ret);
            pstmt.setString(2, uid);
            pstmt.setString(3, bid);
            pstmt.executeUpdate();
//            PreparedStatement pst = con.prepareStatement(qry);
//            pst.setString(1, bid);
//            pst.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(returnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
            response.sendRedirect("./Admin/adminHome.html");
    }
}
