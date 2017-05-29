package dao;

import entities.User;
import remote.UserDaoRemote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(UserDaoRemote.class)
public class UserDao extends GenericDao<User, String> implements UserDaoRemote {
    public UserDao() {
        super(User.class);
    }
}

