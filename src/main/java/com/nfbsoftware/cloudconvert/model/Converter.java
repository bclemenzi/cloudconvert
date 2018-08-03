package com.nfbsoftware.cloudconvert.model;

public class Converter
{
    private String m_format;
    private String m_type;
    private String m_mode;
    
    private Options m_options;
    
    public String getFormat()
    {
        return m_format;
    }
    public void setFormat(String format)
    {
        m_format = format;
    }
    
    public String getType()
    {
        return m_type;
    }
    public void setType(String type)
    {
        m_type = type;
    }
    
    public String getMode()
    {
        return m_mode;
    }
    public void setMode(String mode)
    {
        m_mode = mode;
    }
    
    public Options getOptions()
    {
        return m_options;
    }
    public void setOptions(Options options)
    {
        m_options = options;
    }
}
