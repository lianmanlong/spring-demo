package bean;


public class UserService {

    private String uId;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息" + userDao.queryUserName(uId));
    }
}
