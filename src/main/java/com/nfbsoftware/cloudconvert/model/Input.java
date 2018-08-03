package com.nfbsoftware.cloudconvert.model;

public class Input
{
    private String m_type;
    private String m_filename;
    private String m_size;
    private String m_name;
    private String m_ext;
    
    public String getType()
    {
        return m_type;
    }
    public void setType(String type)
    {
        m_type = type;
    }
    
    public String getFilename()
    {
        return m_filename;
    }
    public void setFilename(String filename)
    {
        m_filename = filename;
    }
    
    public String getSize()
    {
        return m_size;
    }
    public void setSize(String size)
    {
        m_size = size;
    }
    
    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }
    
    public String getExt()
    {
        return m_ext;
    }
    public void setExt(String ext)
    {
        m_ext = ext;
    }
}
