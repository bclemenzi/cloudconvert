package com.nfbsoftware.cloudconvert.model;

/**
 * 
 * @author brendanclemenzi
 */
public class ConvertProcess 
{
    private String m_id;
	private String m_url;
	private String m_host;
	private String m_expires;
	
	private int m_maxtime;
	private int m_minutes;
	
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
    
    public String getHost()
    {
        return m_host;
    }
    public void setHost(String host)
    {
        m_host = host;
    }
    
    public String getExpires()
    {
        return m_expires;
    }
    public void setExpires(String expires)
    {
        m_expires = expires;
    }
    
    public int getMaxtime()
    {
        return m_maxtime;
    }
    public void setMaxtime(int maxtime)
    {
        m_maxtime = maxtime;
    }
    
    public int getMinutes()
    {
        return m_minutes;
    }
    public void setMinutes(int minutes)
    {
        m_minutes = minutes;
    }
}