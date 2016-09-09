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
            "t.infrastructure_index, "+
            "t.combined_analysis_index, "+
            "(select count(1) from lr_crimes lc where ST_Contains(t.geom, lc.geometry)) as crimes_count"+
            " FROM qm_adm_raionipolygon t", nativeQuery = true)
    List<QmAdmRaionipolygon> findCrimesByRegions();
    
    @Modifying
    @Query("update QmAdmRaionipolygon t set t.crimesCount = ?1 where t.gid = ?2")
    void updateCrimesCount(int crimesCount, long gid);
    
    
    @Query(value = "SELECT t.gid, " +
                "t.saxeli, "+
                "t.geom, "+
                "t.crimes_count, "+
                "t.combined_analysis_index, "+
"	cast( " +
"	(select sum(  " +
"		ST_Distance(ST_TransForm(ST_Centroid(t.geom),32638),  " +
"		ST_TransForm(s.geometry ,32638))  " +
"		) as infrastructure_index  " +
"	 from lr_infrastructure s  " +
"	) as bigint " +
"	) as infrastructure_index " +
" FROM qm_adm_raionipolygon t", nativeQuery = true)
    List<QmAdmRaionipolygon> findInfrastructureIndexByRegions();
    
    @Modifying
    @Query("update QmAdmRaionipolygon t set t.infrastructureIndex = ?1 where t.gid = ?2")
    void updateInfrastructureIndex(int infrastructureIndex, long gid);
    
}