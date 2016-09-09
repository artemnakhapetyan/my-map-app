package acdc.my.map.app.services;

import acdc.my.map.app.Config;
import acdc.my.map.app.databeans.ApiRequest;
import acdc.my.map.app.databeans.ApiResponse;
import acdc.my.map.app.entities.postgre.LrCrimes;
import acdc.my.map.app.entities.postgre.LrInfrastructure;
import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import acdc.my.map.app.entities.postgre.ObjectGroup;
import acdc.my.map.app.repositories.mongo.LogRepository;
import acdc.my.map.app.repositories.postgre.LrCrimesRepo;
import acdc.my.map.app.repositories.postgre.LrInfrastructureRepo;
import acdc.my.map.app.repositories.postgre.MapRepository;
import acdc.my.map.app.utils.exception.ExceptionUtils;
import acdc.my.map.app.utils.logging.AppLog;
import acdc.my.map.app.utils.logging.LogType;
import acdc.my.map.app.utils.spatial.GeometryUtil;
import acdc.my.map.app.utils.spatial.RandomUtils;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acdc
 */
@RestController
@Api(value = "/api/glws", description = "application global services")
@RequestMapping("/api/glws")
public class GlWS {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private LrCrimesRepo lrCrimesRepo;

    @Autowired
    private LrInfrastructureRepo lrInfrastructureRepo;
    
    private static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"moduleId\": \"2\", "
            + "\"remoteAddr\": \"127.0.0.1\", "
            + "\"params\":{";
    private static final String apiSuffix = "}}";

    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(HttpServletRequest request, Exception exp) {
        AppLog appLog = new AppLog();
        appLog.setClassName(GlWS.class.getName());
        appLog.setLogType(LogType.ERROR);
        appLog.setProjectName(Config.PROJECT_NAME);
        appLog.setMethodName(request.getRequestURL().toString());
        appLog.setLogData(ExceptionUtils.stackTraceToString(exp));
        LogRepository.save(appLog);
        return new ApiResponse(exp);
    }

    @ApiImplicitParam(
            name = "apiRequest",
            value = apiPrefix + apiSuffix)
    @ApiOperation(value = "load layers", response = ApiResponse.class)
    @RequestMapping(value = "/loadLayers", method = RequestMethod.POST)
    public ApiResponse loadLayers(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
    ) {

        MyMapGeometryObjects findOne = mapRepository.findOne(1L);

        System.out.println(findOne);

        return new ApiResponse().setData(findOne);

    }

    @ApiImplicitParam(
            name = "apiRequest",
            value = apiPrefix + apiSuffix)
    @ApiOperation(value = "generate random crimes", response = ApiResponse.class)
    @RequestMapping(value = "/generateRandomCrimes", method = RequestMethod.POST)
    public ApiResponse generateRandomCrimes(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
    ) throws ParseException {

        int cnt = (int) apiRequest.getParams().get("cnt");
        
        lrCrimesRepo.deleteAll();

        for (int i = 0; i < cnt; i++) {
            
            LrCrimes crime = new LrCrimes();

            Random rn = new Random();
            int crimeType = rn.nextInt(5) + 1;

            crime.setCrimeType(crimeType);
            crime.setCrimeDescription("test");

            StringBuilder coordinates = new StringBuilder();
            coordinates.append(RandomUtils.myRandom(44.61269, 44.98640));
            coordinates.append(" ");
            coordinates.append(RandomUtils.myRandom(41.62964, 41.84205));

            Geometry crimePoint = GeometryUtil.fromWkt("POINT(" + coordinates + ")");
            crimePoint.setSRID(4326);

            crime.setGeometry(crimePoint);

            lrCrimesRepo.save(crime);
            
        }

        return new ApiResponse();

    }
    
    @ApiImplicitParam(
            name = "apiRequest",
            value = apiPrefix + apiSuffix)
    @ApiOperation(value = "generate random infrastructure", response = ApiResponse.class)
    @RequestMapping(value = "/generateRandomInfrastructure", method = RequestMethod.POST)
    public ApiResponse generateRandomInfrastructure(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
    ) throws ParseException {

        int cnt = (int) apiRequest.getParams().get("cnt");
        
        lrInfrastructureRepo.deleteAll();

        for (int i = 0; i < cnt; i++) {
            
            LrInfrastructure infrastructure = new LrInfrastructure();

            Random rn = new Random();
            int infrastructureType = rn.nextInt(5) + 1;

            infrastructure.setObjectType(infrastructureType);
            infrastructure.setObjectDescription("test");

            StringBuilder coordinates = new StringBuilder();
            coordinates.append(RandomUtils.myRandom(44.61269, 44.98640));
            coordinates.append(" ");
            coordinates.append(RandomUtils.myRandom(41.62964, 41.84205));

            Geometry crimePoint = GeometryUtil.fromWkt("POINT(" + coordinates + ")");
            crimePoint.setSRID(4326);

            infrastructure.setGeometry(crimePoint);

            lrInfrastructureRepo.save(infrastructure);
            
        }

        return new ApiResponse();

    }

    /*@ApiImplicitParam(
     name = "apiRequest", 
     value = apiPrefix+apiSuffix)
     @ApiOperation(value = "save object group", response = ApiResponse.class)
     @RequestMapping(value = "/saveObjectGroup",  method = RequestMethod.POST)
     public ApiResponse saveObjectGroup(
     HttpServletRequest httpRequest,
     @RequestBody ObjectGroup objectGroup
     ){

     repository.save(objectGroup);
        
     return new ApiResponse();
        
     }*/
}
