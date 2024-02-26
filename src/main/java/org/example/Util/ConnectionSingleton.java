//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.tools.RunScript;

public class ConnectionSingleton {
    private static String url = "jdbc:h2:./h2/db";
    private static String username = "sa";
    private static String password = "sa";
    private static Connection connection = null;

    public ConnectionSingleton() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                resetTestDatabase();
            } catch (SQLException var1) {
                var1.printStackTrace();
            }
        }

        return connection;
    }

    public static void resetTestDatabase() {
        if (connection == null) {
            getConnection();
        } else {
            try {
                FileReader sqlReader = new FileReader("src/main/resources/Tables.sql");
                RunScript.execute(connection, sqlReader);
            } catch (FileNotFoundException | SQLException var1) {
                var1.printStackTrace();
            }
        }

    }
}

