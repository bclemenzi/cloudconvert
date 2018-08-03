package com.nfbsoftware.cloudconvert.model;

public class Output
{
    private String m_ext;
    private String m_filename;
    private String m_url;
    
    private int m_size;

    public String getExt()
    {
        return m_ext;
    }
    public void setExt(String ext)
    {
        m_ext = ext;
    }

    public String getFilename()
    {
        return m_filename;
    }
    public void setFilename(String filename)
    {
        m_filename = filename;
    }

    public String getUrl()
    {
        return m_url;
    }
    public void setUrl(String url)
    {
        m_url = url;
    }

    public int getSize()
    {
        return m_size;
    }
    public void setSize(int size)
    {
        m_size = size;
    }
}
