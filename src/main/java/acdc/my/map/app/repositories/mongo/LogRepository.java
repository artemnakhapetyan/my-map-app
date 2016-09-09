
package acdc.my.map.app.repositories.mongo;

import acdc.my.map.app.utils.logging.AppLog;
import org.springframework.data.repository.Repository;

/**
 *
 * @author acdc
 */
public class LogRepository /*implements Repository<AppLog, Long>*/{
        public static AppLog save(AppLog log){
            System.out.println(log.getClassName()+" "+log.getMethodName()+" "+log.getLogData());
            return null;
        }
}
