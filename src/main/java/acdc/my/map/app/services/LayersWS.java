
package acdc.my.map.app.services;

import acdc.my.map.app.Config;
import acdc.my.map.app.databeans.ApiRequest;
import acdc.my.map.app.databeans.ApiResponse;
import acdc.my.map.app.entities.postgre.Layers;
import acdc.my.map.app.repositories.mongo.LogRepository;
import acdc.my.map.app.repositories.postgre.LayersRepo;
import acdc.my.map.app.utils.exception.ExceptionUtils;
import acdc.my.map.app.utils.logging.AppLog;
import acdc.my.map.app.utils.logging.LogType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "/api/layersws", description = "manage layers")
@RequestMapping("/api/layersws")
public class LayersWS {
    
    @Autowired
    private LogRepository logRepository;
    
    @Autowired
    private LayersRepo layersRepo;
    
    private static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"moduleId\": \"2\", "
            + "\"remoteAddr\": \"127.0.0.1\", "
            + "\"params\":{";
    private static final String apiSuffix = "}}";
    
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(HttpServletRequest request, Exception exp) {
        AppLog appLog = new AppLog();
        appLog.setClassName(LayersWS.class.getName());
        appLog.setLogType(LogType.ERROR);
        appLog.setProjectName(Config.PROJECT_NAME);
        appLog.setMethodName(request.getRequestURL().toString());
        appLog.setLogData(ExceptionUtils.stackTraceToString(exp));
        logRepository.save(appLog);
        return new ApiResponse(exp);
    }
    
    @ApiImplicitParam(
                name = "apiRequest", 
                value = apiPrefix+apiSuffix)
    @ApiOperation(value = "get base layers", response = ApiResponse.class)
    @RequestMapping(value = "/getBaseLayers",  method = RequestMethod.POST)
    public ApiResponse getBaseLayers(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        List<Layers> layersList = layersRepo.findByIsBaseLrTrue();
        
        return new ApiResponse().setData(layersList);
        
    }
    
    @ApiImplicitParam(
                name = "apiRequest", 
                value = apiPrefix+apiSuffix)
    @ApiOperation(value = "get overlays", response = ApiResponse.class)
    @RequestMapping(value = "/getOverlayLayers",  method = RequestMethod.POST)
    public ApiResponse getOverlayLayers(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        List<Layers> layersList = layersRepo.findByIsBaseLrFalse();
        for(Layers layer: layersList){
            
            if(!layer.isIsBaseLr()){
                
                if(layer.isIsSelected()){
                    layer.setOptions(layer.getOptions().replace("}", ",visibility: true}"));
                }else{
                    layer.setOptions(layer.getOptions().replace("}", ",visibility: false}"));
                }
                
            }
            
        }
        
        return new ApiResponse().setData(layersList);
        
    }
    
    
    
}
