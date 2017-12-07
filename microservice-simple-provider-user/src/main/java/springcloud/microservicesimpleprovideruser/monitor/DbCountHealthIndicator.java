package springcloud.microservicesimpleprovideruser.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Super.Sun on 2017/12/7.
 * 自定义信息
 */
public class DbCountHealthIndicator implements HealthIndicator {

    private CrudRepository crudRepository;
    public DbCountHealthIndicator(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }
    @Override
    public Health health() {
        System.out.println("123");
        return null;
    }
}
