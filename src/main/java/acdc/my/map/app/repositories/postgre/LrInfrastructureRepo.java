package acdc.my.map.app.repositories.postgre;

import acdc.my.map.app.entities.postgre.LrCrimes;
import acdc.my.map.app.entities.postgre.LrInfrastructure;
import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;



/**
 *
 * @author acdc
 */
public interface LrInfrastructureRepo extends CrudRepository<LrInfrastructure, Long>{
   
}