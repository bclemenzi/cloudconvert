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

    private static final String CC_BASE_URL = "//api.cloudconvert.com/";
    
    private String m_apiKey;
    private String m_protocol;
    
    /**
     * 
     * @param apiKey - CloudConvert API Key
     */
    public CloudConvertClient(String apiKey, boolean useSSL)
    {
        m_apiKey = apiKey;
        
        if(useSSL)
        {
            m_protocol = "https:";
        }
        else
        {
            m_protocol = "http:";
        }
    }
    
    /**
     * 
     * @param inputFormat - incoming file format
     * @param outputFormat - outgoing file format
     * @return - Returns our ConvertProcess
     * @throws Exception - thrown if the sh*t has hit the fan
     */
    public ConvertProcess getProcess(String inputFormat, String outputFormat) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append(m_protocol + CC_BASE_URL);
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
     * @param convertProcess - The active converter process
     * @param inputFormat - incoming file format
     * @param outputFormat - outgoing file format
     * @param input - Identifies how the file will be going to the converter
     * @param fileUrl - url of the file being converted
     * @return - Returns our StartConversion
     * @throws Exception - thrown if the sh*t has hit the fan
     */
    public StartConversion startConversion(ConvertProcess convertProcess, String inputFormat, String outputFormat, String input, String fileUrl) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append(m_protocol);
        fullApiUrl.append(convertProcess.getUrl());
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("inputformat", inputFormat);
        parameters.put("outputformat", outputFormat);
        parameters.put("input", input);
        parameters.put("file", fileUrl);
                
        // Send our request to CloudConvert
        JSONObject responseJSON = post(fullApiUrl.toString(), this.m_apiKey, parameters);
        
        // Map our json response to our object models.
        ObjectMapper mapper = new ObjectMapper();
        StartConversion objectValue = mapper.readValue(responseJSON.toString(),  StartConversion.class);
        
        // Return our object
        return objectValue;
    }
    
    /**
     * 
     * @param startConversion - Started conversion
     * @param wait - Wait boolean to tell the converter to wait until it's complete
     * @return - Returns our ConversionStatus
     * @throws Exception - thrown if the sh*t has hit the fan
     */
    public ConversionStatus getConversionStatus(StartConversion startConversion, boolean wait) throws Exception
    {
        return getConversionStatus(startConversion.getUrl(), wait);
    }
    
    /**
     * 
     * @param processUrl - Process url you are checking the status on
     * @param wait - Wait boolean to tell the converter to wait until it's complete
     * @return - Returns our ConversionStatus
     * @throws Exception - thrown if the sh*t has hit the fan
     */
    public ConversionStatus getConversionStatus(String processUrl, boolean wait) throws Exception
    {
        StringBuffer fullApiUrl = new StringBuffer();
        fullApiUrl.append(m_protocol);
        fullApiUrl.append(processUrl);
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if(wait)
        {
            parameters.put("wait", wait);
        }
                
        // Send our request to CloudConvert
        JSONObject responseJSON = get(fullApiUrl.toString(), this.m_apiKey, parameters);
        
        // Map our json response to our object models.
        ObjectMapper mapper = new ObjectMapper();
        ConversionStatus objectValue = mapper.readValue(responseJSON.toString(),  ConversionStatus.class);
        
        // Return our object
        return objectValue;
    }
    
    /**
     * 
     * @param apiUrl - Url of the api
     * @param oAuthToken - Authorization token for the API
     * @param parameters - Parameters for the API call
     * @return - Returns our JSON response
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
     * @param apiUrl - Url of the api
     * @param oAuthToken - Authorization token for the API
     * @param parameters - Parameters for the API call
     * @return - Returns our JSON response
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