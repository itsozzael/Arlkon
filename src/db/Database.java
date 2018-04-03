package db;

import java.sql.*;

public class Database {
    private Connection con = null;

    public Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arlkon","root","");

            System.out.println("Database Successfully Connected");
        } catch (Exception ex) {
            System.out.print("Error : " + ex);
        }
    }

    public void createTables(){
        try {
            Statement stmt = con.createStatement();

            String sqlCreate = "CREATE TABLE IF NOT EXISTS `arlkon`.`users` (" +
                    "  `user_id` INT NOT NULL," +
                    "  `username` VARCHAR(45) NULL," +
                    "  `user_password` VARCHAR(45) NULL," +
                    "  `user_email` VARCHAR(45) NULL," +
                    "  `user_type` VARCHAR(45) NULL," +
                    "  `user_balance` DOUBLE NULL," +
                    "  `join_datetime` DATETIME NULL," +
                    "  PRIMARY KEY (`user_id`)," +
                    "  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC)," +
                    "  UNIQUE INDEX `user_name_UNIQUE` (`username` ASC));";
            stmt.execute(sqlCreate);

            sqlCreate = "CREATE TABLE IF NOT EXISTS `arlkon`.`binary_transactions` (" +
                    "  `transaction_id` INT NOT NULL," +
                    "  `user_id` INT NOT NULL," +
                    "  `transaction_type` VARCHAR(45) NULL," +
                    "  `transaction_amount` DOUBLE NULL," +
                    "  `transaction_result` DOUBLE NULL," +
                    "  `transaction_timeframe` DATETIME NULL," +
                    "  `transaction_datetime` DATETIME NULL," +
                    "  PRIMARY KEY (`transaction_id`));";
            stmt.execute(sqlCreate);

            sqlCreate = "CREATE TABLE IF NOT EXISTS `arlkon`.`investment_transactions` (" +
                    "  `transaction_id` INT NOT NULL," +
                    "  `user_id` VARCHAR(45) NOT NULL," +
                    "  `transaction_type` VARCHAR(45) NULL," +
                    "  `transaction_amount` DOUBLE NULL," +
                    "  `transaction_result` DOUBLE NULL," +
                    "  `transaction_datetime` DATETIME NULL," +
                    "  PRIMARY KEY (`transaction_id`)," +
                    "  UNIQUE INDEX `transaction_id_UNIQUE` (`transaction_id` ASC));";
            stmt.execute(sqlCreate);

            sqlCreate = "CREATE TABLE IF NOT EXISTS `arlkon`.`preferences` (" +
                    "  `prefs_id` INT NOT NULL," +
                    "  `users_id` INT NULL," +
                    "  `prefs_currency` DOUBLE NULL," +
                    "  `prefs_theme` VARCHAR(45) NULL," +
                    "  `prefs_notif` VARCHAR(45) NULL," +
                    "  `last_updated` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`prefs_id`)," +
                    "  UNIQUE INDEX `prefs_id_UNIQUE` (`prefs_id` ASC));";
            stmt.execute(sqlCreate);

            System.out.println("Successfully Created Tables");
        } catch (Exception ex){
            System.out.print("Error : " + ex);
        }
    }
}
