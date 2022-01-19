/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;







public class ConectaBanco {
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/EstoqueBanco";
    private static final String User = "root";
    private static final String Senha = "";
    public Connection conn;

    public void Conexao(){
        System.setProperty("jdbc.Driver", Driver);
       
    }
    
}



