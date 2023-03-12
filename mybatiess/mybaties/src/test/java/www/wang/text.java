package www.wang;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import www.wang.Dao.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class text {
    SqlSession session;
    @Before
    public void openSession() throws IOException {
//       创建文件流,读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建sqlsession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//        开启session
        session=factory.openSession();
    }
    @Test
    public void test(){
        List<User> list = session.selectList("wang.getAll");
        for (User user :
                list) {
            System.out.println(user);
        }
    }
    @After
    public void closeSession(){
        session.close();
    }

}
