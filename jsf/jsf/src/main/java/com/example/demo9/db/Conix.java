package com.example.demo9.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conix {

    private static final String URL = "jdbc:mysql://mysql-1f009bce-abdrahimmolaqui-980c.a.aivencloud.com:23684/defaultdb";
    private static final String UTILISATEUR = "avnadmin";
    private static final String MOT_DE_PASSE = "AVNS_MH2bf6rB7iUg-R4qyRx";
    private static Connection connexion = null;
    public static Connection getConnection() {

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);

            System.out.println("Connexion à la base de données réussie !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        return connexion;
    }
}
