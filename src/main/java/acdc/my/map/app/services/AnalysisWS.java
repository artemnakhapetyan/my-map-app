
package acdc.my.map.app.services;

import acdc.my.map.app.Config;
import acdc.my.map.app.databeans.ApiRequest;
import acdc.my.map.app.databeans.ApiResponse;
import acdc.my.map.app.entities.postgre.QmAdmRaionipolygon;
import acdc.my.map.app.repositories.mongo.LogRepository;
import acdc.my.map.app.repositories.postgre.AnalysisRepo;
import acdc.my.map.app.utils.exception.ExceptionUtils;
import acdc.my.map.app.utils.logging.AppLog;
import acdc.my.map.app.utils.logging.LogType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Api(value = "/api/analysisws", description = "analize data")
@RequestMapping("/api/analysisws")
public class AnalysisWS {
    
    @Autowired
    private AnalysisRepo analysisRepo;
    
    private static final String apiPrefix = "{"
            + "\"sessionId\": \"12345abcd\", "
            + "\"moduleId\": \"2\", "
            + "\"remoteAddr\": \"127.0.0.1\", "
            + "\"params\":{";
    private static final String apiSuffix = "}}";
    
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(HttpServletRequest request, Exception exp) {
        AppLog appLog = new AppLog();
        appLog.setClassName(AnalysisWS.class.getName());
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
    @ApiOperation(value = "analyze crimes by tbilisi regions", response = ApiResponse.class)
    @RequestMapping(value = "/analyzeCrimesByTbilisiRegions",  method = RequestMethod.POST)
    @Transactional
    public ApiResponse analyzeCrimesByTbilisiRegions(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        List<QmAdmRaionipolygon> records = analysisRepo.findCrimesByRegions();
        for(QmAdmRaionipolygon qmAdmRaioni: records){
            analysisRepo.updateCrimesCount(qmAdmRaioni.getCrimesCount(), qmAdmRaioni.getGid());
        }
        
        return new ApiResponse().setData(records);
        
    }
    
    @ApiImplicitParam(
                name = "apiRequest", 
                value = apiPrefix+apiSuffix)
    @ApiOperation(value = "analyze infrastructure index by tbilisi regions", response = ApiResponse.class)
    @RequestMapping(value = "/analyzeInfrastructureIndexByTbilisiRegions",  method = RequestMethod.POST)
    @Transactional
    public ApiResponse analyzeInfrastructureIndexByTbilisiRegions(
            HttpServletRequest httpRequest,
            @RequestBody ApiRequest apiRequest
            ){

        List<QmAdmRaionipolygon> records = analysisRepo.findInfrastructureIndexByRegions();
        for(QmAdmRaionipolygon qmAdmRaioni: records){
            analysisRepo.updateInfrastructureIndex(qmAdmRaioni.getInfrastructureIndex(), qmAdmRaioni.getGid());
        }
        
        return new ApiResponse().setData(records);
        
    }
    
    
}
