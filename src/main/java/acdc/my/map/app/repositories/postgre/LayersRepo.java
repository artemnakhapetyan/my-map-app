package acdc.my.map.app.repositories.postgre;

import acdc.my.map.app.entities.postgre.Layers;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author acdc
 */
public interface LayersRepo extends CrudRepository<Layers, Long>{
   
    List<Layers> findByIsBaseLrTrue();
    
    List<Layers> findByIsBaseLrFalse();
    
}