package acdc.my.map.app.repositories.postgre;

import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import acdc.my.map.app.entities.postgre.MyMaps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;



/**
 *
 * @author acdc
 */
public interface MyMapsRepository extends CrudRepository<MyMaps, Long>{
   
    
    
}