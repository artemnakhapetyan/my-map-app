
package acdc.my.map.app.repositories.mongo;

import ge.gov.msda.tbilisimap.utils.logging.AppLog;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author acdc
 */
public interface LogRepository extends MongoRepository<AppLog, Long>{
   
}
