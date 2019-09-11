package z.f.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserDaoTest
 * @time :2019.08.11,13:04
 * @file :z.f.test.UserDaoTest.jave
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserDaoTest {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Test
    public void getUserAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User");
        List list = query.list();
        System.out.println(list);
    }
}
