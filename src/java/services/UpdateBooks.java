/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Model.DBClass;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author c0648991
 */
@Path("updatebooks")
public class UpdateBooks{
    @PUT
    public void doPut(String str) {
        JsonObject json = Json.createReader(new StringReader(str)).readObject();
        String id = json.getString("bookid");
        String title = json.getString("booktitle");
        System.out.println("Book Name:"+ title);
        String author = json.getString("author");
        String cat = json.getString("category");
        String des = json.getString("description");
        int quantity = Integer.parseInt(json.getString("quantity"));
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
