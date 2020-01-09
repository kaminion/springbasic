package co.test;

import java.sql.Connection;

public class DaoFactory {

    public Dao createDao(Connection con)
    {
        return new Dao(con);
    }

    public Dao2 createDao2(Connection con)
    {
        return new Dao2(con);
    }
}
