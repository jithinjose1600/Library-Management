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
import java.util.Random;
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
@WebServlet("/books")
public class Books extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<String> books=new ArrayList();
        String query="SELECT * FROM books";
        try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
             books.add(rs.getString("bookid"));
             books.add(rs.getString("booktitle"));
             books.add(rs.getString("author"));
             books.add(rs.getString("category"));
             books.add(rs.getString("description"));
             books.add(String.valueOf(rs.getInt("quantity")));
             books.add(String.valueOf(rs.getInt("availableno")));
         }
         req.setAttribute("book", books);
             HttpSession ses=req.getSession(true);
               if(ses.getAttribute("mem_name")!=null)
               {
                   RequestDispatcher disp=req.getRequestDispatcher("viewBooks.jsp");
              disp.forward(req, res);
               }
               else
               {
                 RequestDispatcher d=req.getRequestDispatcher("Admin/viewBooks.jsp");
             d.forward(req, res);
               }
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
            int min = 1;
            int max = 1000;
            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            int fl = 1000 + i1;
            String id = "B" + fl;
            String title = req.getParameter("b_name");
            String author = req.getParameter("b_author");
            String cat = req.getParameter("b_category");
            String des = req.getParameter("b_description");
            int quantity = Integer.parseInt(req.getParameter("b_quantity"));
            String query="INSERT INTO books(bookid, booktitle, author, category, description, quantity, availableno) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection con=DBClass.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query); 
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, cat);
            pstmt.setString(5, des);
            pstmt.setInt(6, quantity);
            pstmt.setInt(7, quantity);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
