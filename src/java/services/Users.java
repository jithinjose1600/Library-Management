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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author c0648991
 */
@Path("users")
public class Users {
    
    @GET
    @Produces("application/json")
    public String doGet() {
        return getResults("SELECT * FROM users");
    
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public String doGet(@PathParam("id") String id) {
        return getResults("SELECT * FROM users WHERE id=?", id);
    }
    
    @POST
    public String post(String str) {
        int res=0;
        try {
            JsonObject json = Json.createReader(new StringReader(str)).readObject();
            int min = 1;
            int max = 1000;
            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            int fl = 1000 + i1;
            String id = "M" + fl;
            String fname = json.getString("firstName");
            String lname = json.getString("lastName");
            String address = json.getString("address");
            String phone = json.getString("phone");
            String email = json.getString("email"); 
            String password = json.getString("password"); 
            Connection conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (id, fname, lname, address, phone, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, id);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, email);
            pstmt.setString(7, password);
            res=pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doGet();
    }
    
    @PUT
    @Path("{id}")
    public String put(@PathParam("id") String id, String str) {
        try {
            System.out.println("putti ethi..");
            JsonObject json = Json.createReader(new StringReader(str)).readObject();
            String fname = json.getString("firstName");
            String lname = json.getString("lastName");
            String address = json.getString("address");
            String phone = json.getString("phone");
            String email = json.getString("email");
            String password = json.getString("password");
            Connection conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET fname=?, lname=?, address=?, phone=?, email=?, password=? WHERE id=?");
            
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            pstmt.setString(7, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doGet();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        try {
            Connection conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE id=?");
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String getResults(String query, String... params) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        try (Connection conn = DBClass.getConnection()) {            
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                pstmt.setString(i, params[i - 1]);
            }
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()) {
                   builder.add(Json.createObjectBuilder()
                           .add("userId", rs.getString("id"))
                        .add("firstName", rs.getString("fname"))
                        .add("lastName", rs.getString("lname"))
                        .add("address", rs.getString("address"))
                      .add("phone", rs.getString("phone"))
                      .add("email", rs.getString("email"))
                           .add("password", rs.getString("password"))
                          .build());
 
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.build().toString();
   }
}
