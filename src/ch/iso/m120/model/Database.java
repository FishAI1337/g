package ch.iso.m120.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.GregorianCalendar;

public class Database {
    private static String connectionString ="jdbc:mysql://localhost/lsdforreal?useSSL=false";
    private static String connectionUser = "root";
    private static String connectionPassword = "1337";
    private static Database INSTANCE = new Database();

    private Database() {


    }

    public static Database getINSTANCE() {
        return INSTANCE;
    }

    public void loadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,connectionUser,connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select highScoreScore, highScoreName, highScoreDate from Highscore ORDER BY"+
                    " highScoreScore DESC;");
            HighscoreObservableList.getData().clear();
            while (rs.next()){
                String scoreScore = rs.getString("highScoreScore");
                String scoreName = rs.getString("highScoreName");
                String scoreDate = rs.getString("highScoreDate");
                HighscoreObservableList.getData().add(new Highscore(scoreName,scoreScore,scoreDate));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            Connection conn = DriverManager.getConnection(connectionString,connectionUser,connectionPassword);
            Statement stmt = conn.createStatement();
            stmt.execute("delete from highscore;");
            stmt.execute("truncate table highscore;");
            for (Highscore hs: HighscoreObservableList.getData()) {
                if (hs.getDate() == null) {
                    stmt.execute("insert into highscore(highScoreName, highScoreScore) " +
                            "VALUES ('"+hs.getName()+"',"+hs.getScore()+");");
                } else {
                    stmt.execute("insert into highscore(highScoreName, highScoreScore, highScoreDate) " +
                            "VALUES ('"+hs.getName()+"',"+hs.getScore()+",'"+hs.getDate()+"');");
                }

            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
