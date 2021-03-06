
package acdc.my.map.app.services;

import acdc.my.map.app.Config;
import acdc.my.map.app.databeans.ApiRequest;
import acdc.my.map.app.databeans.ApiResponse;
import acdc.my.map.app.entities.postgre.MyMapGeometryObjects;
import acdc.my.map.app.repositories.mongo.LogRepository;
import acdc.my.map.app.repositories.postgre.MapRepository;
import acdc.my.map.app.utils.exception.AppException;
import acdc.my.map.app.utils.exception.AppSessionException;
import acdc.my.map.app.utils.exception.ExceptionUtils;
import acdc.my.map.app.utils.logging.AppLog;
import acdc.my.map.app.utils.logging.LogType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
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
@Api(value = "/api/geometryobjectsmanagerws", description = "manage geometry objects")
@RequestMapping("/api/geometryobjectsmanagerws")
public class GeometryObjectsManagerWS {
    
    @Autowired
    private MapRepository mapRepository;
    
    private static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"moduleId\": \"2\", "
            + "\"remoteAddr\": \"127.0.0.1\", "
            + "\"params\":{";
    private static final String apiSuffix = "}}";
    
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(HttpServletRequest request, Exception exp) {
        AppLog appLog = new AppLog();
        appLog.setClassName(GeometryObjectsManagerWS.class.getName());
        appLog.setLogType(LogType.ERROR);
        appLog.setProjectName(Config.PROJECT_NAME);
        appLog.setMethodName(request.getRequestURL().toString());
        appLog.setLogData(ExceptionUtils.stackTraceToString(exp));
        LogRepository.save(appLog);
        return new ApiResponse(exp);
    }
    
    @ApiImplicitParam(
                name = "apiRequest", 
                value = apiPrefix+apiSuffix)
    @ApiOperation(value = "add geometry object", response = ApiResponse.class)
    @RequestMapping(value = "/addGeometryObject",  method = RequestMethod.POST)
    public ApiResponse addGeometryObject(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        MyMapGeometryObjects findOne = mapRepository.findOne(1L);
        
        System.out.println(findOne);
        
        return new ApiResponse().setData(findOne);
        
    }
    
    
    
    
}
