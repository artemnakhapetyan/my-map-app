package acdc.my.map.app.repositories.postgre;

import acdc.my.map.app.entities.postgre.LrCrimes;
import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import acdc.my.map.app.entities.postgre.QmAdmRaionipolygon;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;



/**
 *
 * @author acdc
 */
public interface AnalysisRepo extends CrudRepository<QmAdmRaionipolygon, Long>{
   
    @Query(value = "SELECT t.gid, "+
            "t.saxeli, "+
            "t.geom, "+
            "(select count(1) from lr_crimes lc where ST_Contains(t.geom, lc.geometry)) as crimes_count"+
            " FROM qm_adm_raionipolygon t", nativeQuery = true)
    List<QmAdmRaionipolygon> findCrimesByRegions();
    
    @Modifying
    @Query("update QmAdmRaionipolygon t set t.crimesCount = ?1 where t.gid = ?2")
    void updateCrimesCount(int crimesCount, long gid);
    
}