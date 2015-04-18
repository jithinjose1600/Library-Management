/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Model.DBClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/issue")
public class IssueBooks extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
            String uid=req.getParameter("u_id");
            String fname=req.getParameter("u_name");
            String lname=req.getParameter("lname");
            String bid=req.getParameter("b_id");
            String bname=req.getParameter("b_name");
            String isdate=req.getParameter("is_date");
            String query="INSERT INTO records(userid, fname, lname, bookid, booktitle, issuedate, returndate) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, uid);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, bid);
            pstmt.setString(5, bname);
            pstmt.setString(6, isdate);
            pstmt.setString(7, "not returned");
            pstmt.executeUpdate();
            String qu="SELECT * FROM bookings WHERE userid=? AND bookid=?";
            PreparedStatement ppstmt = con.prepareStatement(query); 
            ppstmt.setString(1, uid);
            ppstmt.setString(2, bid);
            ResultSet rs=ppstmt.executeQuery();
            if(rs.next()) {
            String qury="DELETE FROM bookings WHERE userid=? AND bookid=?";
            PreparedStatement ppst = con.prepareStatement(query); 
            ppst.setString(1, uid);
            ppst.setString(2, bid);
            ppst.executeUpdate();
        }
            else {
            String qry="UPDATE books SET availableno=availableno - 1 WHERE bookid=?";
            PreparedStatement pst = con.prepareStatement(qry); 
            pstmt.setString(1, bid);
            pst.executeUpdate();
            }
    }   catch (SQLException ex) {
            Logger.getLogger(IssueBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
