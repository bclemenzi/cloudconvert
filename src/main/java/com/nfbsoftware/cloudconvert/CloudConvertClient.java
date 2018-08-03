package com.nfbsoftware.cloudconvert;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goebl.david.Webb;
import com.goebl.david.WebbException;
import com.nfbsoftware.cloudconvert.model.ConversionStatus;
import com.nfbsoftware.cloudconvert.model.ConvertProcess;
import com.nfbsoftware.cloudconvert.model.StartConversion;

/**
 * This is a Java utility class that is used to communicate with the CloudConvert RESTful API.
 * 
 * @author brendanclemenzi
 */
public class CloudConvertClient
{
    private static final Log logger = LogFactory.getLog(CloudConvertClient.class);

    private static final String CC_BASE_URL = "https://api.cloudconvert.com/";
    
    private String m_apiKey;
    
    /**
     * 
     * @param apiKey - CloudConvert API Key
     */
    public CloudConvertClient(String apiKey)
    {
        m_apiKey = apiKey;
    }
    
    /**
     * 
     * @param inputFormat
     * @param outputFormat
     * @param mode
     * @return
     * @throws Exception
     */
    public ConvertProcess getProcess(String inputFormat, String outputFormat) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append(CC_BASE_URL);
        fullApiUrl.append("process");
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("inputformat", inputFormat);
        parameters.put("outputformat", outputFormat);
                
        JSONObject responseJSON = post(fullApiUrl.toString(), this.m_apiKey, parameters);
        
        ObjectMapper mapper = new ObjectMapper();
        ConvertProcess objectValue = mapper.readValue(responseJSON.toString(),  ConvertProcess.class);
        
        // Return our object
        return objectValue;
    }
    
    /**
     * 
     * @param convertProcess
     * @param input
     * @param fileUrl
     * @param outputFormat
     * @param mode
     * @return
     * @throws Exception
     */
    public StartConversion startConversion(ConvertProcess convertProcess, String inputFormat, String outputFormat, String input, String fileUrl) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append("https:");
        fullApiUrl.append(convertProcess.getUrl());
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("inputformat", inputFormat);
        parameters.put("outputformat", outputFormat);
        parameters.put("input", input);
        parameters.put("file", fileUrl);
                
        JSONObject responseJSON = post(fullApiUrl.toString(), this.m_apiKey, parameters);
        System.out.println(responseJSON);
        
        ObjectMapper mapper = new ObjectMapper();
        StartConversion objectValue = mapper.readValue(responseJSON.toString(),  StartConversion.class);
        
        // Return our object
        return objectValue;
    }
    
    /**
     * 
     * @param convertProcess
     * @return
     * @throws Exception
     */
    public ConversionStatus getConversionStatus(StartConversion startConversion, boolean wait) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append("https:");
        fullApiUrl.append(startConversion.getUrl());
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if(wait)
        {
            parameters.put("wait", wait);
        }
                
        JSONObject responseJSON = get(fullApiUrl.toString(), this.m_apiKey, parameters);
        System.out.println(responseJSON);
        
        ObjectMapper mapper = new ObjectMapper();
        ConversionStatus objectValue = mapper.readValue(responseJSON.toString(),  ConversionStatus.class);
        
        // Return our object
        return objectValue;
    }
    
    /**
     * 
     * @param apiUrl
     * @param oAuthToken
     * @param parameters
     * @return
     */
    private JSONObject post(String apiUrl, String oAuthToken, Map<String, Object> parameters)
    {
        Webb webb = Webb.create();
        webb.setDefaultHeader(Webb.HDR_AUTHORIZATION, "Bearer " + oAuthToken);
        
        JSONObject jsonObject = null;
        
        try 
        {
            jsonObject = webb.post(apiUrl)
                .params(parameters)
                .ensureSuccess()
                .asJsonObject()
                .getBody();
        }
        catch (WebbException we)
        {
            logger.error("Error executing apiUrl: " + apiUrl + "  Error: " + we.getMessage());
            jsonObject = new JSONObject();
        }
        
        return jsonObject;
    }
    
    /**
     * 
     * @param apiUrl
     * @param oAuthToken
     * @param parameters
     * @return
     */
    private JSONObject get(String apiUrl, String oAuthToken, Map<String, Object> parameters)
    {
        Webb webb = Webb.create();
        webb.setDefaultHeader(Webb.HDR_AUTHORIZATION, "Bearer " + oAuthToken);
        
        JSONObject jsonObject = null;
        
        try 
        {
            jsonObject = webb.get(apiUrl)
                .params(parameters)
                .ensureSuccess()
                .asJsonObject()
                .getBody();
        }
        catch (WebbException we)
        {
            logger.error("Error executing apiUrl: " + apiUrl + "  Error: " + we.getMessage());
            jsonObject = new JSONObject();
        }
        
        return jsonObject;
    }
}