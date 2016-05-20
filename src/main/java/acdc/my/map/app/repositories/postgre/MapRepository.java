package acdc.my.map.app.repositories.postgre;

import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import org.springframework.data.repository.Repository;



/**
 *
 * @author acdc
 */
public interface MapRepository extends Repository<MyMapGeometryObjects, Long>{
   
    MyMapGeometryObjects findOne(Long primaryKey);
    
}