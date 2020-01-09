package co.test;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory implements DisposableBean
{
    private String driverClass;
    private String url;
    private String id;
    private String password;
    @Getter private Connection connection;

    public ConnectionFactory(String driverClass, String url, String id, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.id = id;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
        // var라고 써서 앞에 추론 시킬수도 있음
        try{
            Class.forName(this.driverClass);
        }catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();
        }
        return DriverManager.getConnection(this.url, this.id, this.password);
    }

    public void init() throws Exception {
        log.info("INIT");
        this.connection = createConnection();
    }

    @Override
    public void destroy() throws Exception {
        log.info("DESTROY");
        if(this.connection != null) this.connection.close();
    }

}
