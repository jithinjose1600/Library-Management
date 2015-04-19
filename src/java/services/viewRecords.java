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
 * @author JITHZZ
 */
@WebServlet("/records")
public class viewRecords extends HttpServlet {
        @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResultSet result;
        ArrayList<String> rec=new ArrayList();
        String query="SELECT * FROM records";
        String qry="SELECT * FROM records WHERE userid=?";
            HttpSession ses=req.getSession();
            String uid=(String)ses.getAttribute("id");
        try(Connection con=DBClass.getConnection()) {
            if(uid!=null) {
                PreparedStatement pstmt = con.prepareStatement(qry);
                pstmt.setString(1, uid);
            result=pstmt.executeQuery();
            while(result.next()) {
                rec.add(result.getString("bookid"));
                rec.add(result.getString("booktitle"));
                rec.add(result.getString("issuedate"));
                rec.add(result.getString("returndate"));
                req.setAttribute("record", rec);
                
            }
            RequestDispatcher disp=req.getRequestDispatcher("./viewRecords.jsp");
                disp.forward(req, res);
            }
            else {
            PreparedStatement pst = con.prepareStatement(query); 
            result=pst.executeQuery();
            while(result.next()) {
                rec.add(result.getString("userid"));
                rec.add(result.getString("firstname"));
                rec.add(result.getString("lastname"));
                rec.add(result.getString("bookid"));
                rec.add(result.getString("booktitle"));
                rec.add(result.getString("issuedate"));
                rec.add(result.getString("returndate"));
                req.setAttribute("record", rec);
                
            }
            RequestDispatcher disp=req.getRequestDispatcher("./Admin/viewRecords.jsp");
                disp.forward(req, res);
            }
    }   catch (SQLException ex) {
            Logger.getLogger(returnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
