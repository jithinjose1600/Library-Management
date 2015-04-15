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
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public JsonArray doGet() {
        return getResults("SELECT * FROM users");
    
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public JsonArray doGet(@PathParam("id") String id) {
        return getResults("SELECT * FROM users WHERE id=?", id);
    }
    
    @POST
    public void post(String str) {
        System.out.println("Entered jaxrs");
        try {
            JsonObject json = Json.createReader(new StringReader(str)).readObject();
            int min = 1;
            int max = 1000;
            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            int fl = 1000 + i1;
            String id = "M" + fl;
            System.out.println("ID:"+id);
            String fname = json.getString("firstName");
            String lname = json.getString("lastName");
            String address = json.getString("address");
            String phone = json.getString("phone");
            String email = json.getString("email");
            System.out.println("Name"+fname);
            
            Connection conn = DBClass.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (id, fname, lname, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, id);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, email);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return get();
    }
    
    private JsonArray getResults(String query, String... params) {
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
                          .build());
 
            }
   
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.build();
   }
}
