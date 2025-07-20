package service;

/**
 * 认证服务
 * 处理用户登录验证
 */
public class AuthService {
    // 简单模拟用户存储（实际项目中应从数据库或配置文件读取）
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123456";

    /**
     * 验证用户登录
     * @param username 用户名
     * @param password 密码
     * @return 是否验证成功
     */
    public boolean authenticate(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}
