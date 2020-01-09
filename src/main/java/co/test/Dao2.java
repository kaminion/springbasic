package co.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao2 {
    private static Logger logger = LoggerFactory.getLogger(FastCampus.class);
    private Connection con;

    public Dao2(Connection con)
    {
        this.con = con;
    }

    public void run()
    {
        // 자바 1.7부터 autoCloserable interface 상속하는것은 리소스반환 (try-with resource) multi-catch Exception도 기재할 것
        try{
            Statement statement = con.createStatement();
            con.setAutoCommit(false);
            try {
                statement.executeUpdate("INSERT INTO springbasic.member(username, password) VALUES('ahn', '1234')");
                con.commit();
            }catch(SQLException e){
                con.rollback();
            }
            ResultSet rs  = statement.executeQuery("SELECT id, username, password FROM springbasic.member");

            while(rs.next())
            {
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
                MemberVO member = new MemberVO(rs);

                logger.info(member.toString());
            }

        } catch (SQLException clE ) {
            clE.printStackTrace();
        }
        logger.info("Hello World!!");

    }

}
