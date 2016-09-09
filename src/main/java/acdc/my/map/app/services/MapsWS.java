
package acdc.my.map.app.services;

import acdc.my.map.app.Config;
import acdc.my.map.app.databeans.ApiRequest;
import acdc.my.map.app.databeans.ApiResponse;
import acdc.my.map.app.entities.postgre.MyMaps;
import acdc.my.map.app.repositories.mongo.LogRepository;
import acdc.my.map.app.repositories.postgre.MyMapsRepository;
import acdc.my.map.app.utils.exception.ExceptionUtils;
import acdc.my.map.app.utils.logging.AppLog;
import acdc.my.map.app.utils.logging.LogType;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
@Api(value = "/api/mapsws", description = "manage maps")
@RequestMapping("/api/mapsws")
public class MapsWS {
    
    @Autowired
    private MyMapsRepository myMapsRepository;
    
    private static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"moduleId\": \"2\", "
            + "\"remoteAddr\": \"127.0.0.1\", "
            + "\"params\":{";
    private static final String apiSuffix = "}}";
    
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(HttpServletRequest request, Exception exp) {
        AppLog appLog = new AppLog();
        appLog.setClassName(MapsWS.class.getName());
        appLog.setLogType(LogType.ERROR);
        appLog.setProjectName(Config.PROJECT_NAME);
        appLog.setMethodName(request.getRequestURL().toString());
        appLog.setLogData(ExceptionUtils.stackTraceToString(exp));
        LogRepository.save(appLog);
        return new ApiResponse(exp);
    }
    
    
    private final String addMapParamsJson = "{  \n" +
    "      \"description\":\"test map\",\n" +
    "      \"name\":\"TestMap\",\n" +
    "      \"mapUrlName\":\"testmap\",\n" +
    "      \"mapCenterX\":44.789,\n" +
    "      \"mapCenterY\":41.6678\n" +
    "}";
    
    @ApiImplicitParam(
                name = "apiRequest", 
                value = apiPrefix+addMapParamsJson+apiSuffix)
    @ApiOperation(value = "add map", response = ApiResponse.class)
    @RequestMapping(value = "/addMap",  method = RequestMethod.POST)
    public ApiResponse addMap(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MyMaps map = mapper.convertValue(apiRequest.getParams(), MyMaps.class);
        
        myMapsRepository.save(map);
        
        return new ApiResponse().setData(map);
        
    }
    
    
    
    
}
