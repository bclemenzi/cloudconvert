package com.nfbsoftware.cloudconvert.model;

/**
 * 
 * @author brendanclemenzi
 */
public class StartConversion 
{
    private String m_id;
	private String m_url;
	private String m_step;
	private String m_expire;
	private String m_message;
	private String m_error;
	    
	private int m_code;
	private int m_percent;
	private int m_starttime;
	
	private Input m_input;
	private Output m_output;
	
    public String getId()
    {
        return m_id;
    }
    public void setId(String id)
    {
        m_id = id;
    }
    public String getUrl()
    {
        return m_url;
    }
    public void setUrl(String url)
    {
        m_url = url;
    }
    public String getStep()
    {
        return m_step;
    }
    public void setStep(String step)
    {
        m_step = step;
    }
    public String getExpire()
    {
        return m_expire;
    }
    public void setExpire(String expire)
    {
        m_expire = expire;
    }
    public String getMessage()
    {
        return m_message;
    }
    public void setMessage(String message)
    {
        m_message = message;
    }
    public int getPercent()
    {
        return m_percent;
    }
    public void setPercent(int percent)
    {
        m_percent = percent;
    }
    public int getStarttime()
    {
        return m_starttime;
    }
    public void setStarttime(int starttime)
    {
        m_starttime = starttime;
    }
    public Input getInput()
    {
        return m_input;
    }
    public void setInput(Input input)
    {
        m_input = input;
    }
    public Output getOutput()
    {
        return m_output;
    }
    public void setOutput(Output output)
    {
        m_output = output;
    }
    
    public String getError()
    {
        return m_error;
    }
    public void setError(String error)
    {
        m_error = error;
    }
    
    public int getCode()
    {
        return m_code;
    }
    public void setCode(int code)
    {
        m_code = code;
    }
}