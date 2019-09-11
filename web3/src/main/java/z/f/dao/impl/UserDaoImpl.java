package z.f.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import z.f.bean.User;
import z.f.dao.UserDao;

import java.util.List;

/**
 * codening:utf-8
 *
 * @author :UserDaoImpl
 * @time :2019.08.11,1:55
 * @file :z.f.dao.impl.UserDaoImpl.jave
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    /**
     * 查询所有用户
     */
    @Override
    public List<User> getUserAll() {
        return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
            @Override
            public List<User> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from user");
                return query.list();
            }
        });
    }
}
