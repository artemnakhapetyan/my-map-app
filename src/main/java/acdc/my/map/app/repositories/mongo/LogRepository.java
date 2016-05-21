
package acdc.my.map.app.repositories.mongo;

import acdc.my.map.app.utils.logging.AppLog;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author acdc
 */
public interface LogRepository extends MongoRepository<AppLog, Long>{
   
}
