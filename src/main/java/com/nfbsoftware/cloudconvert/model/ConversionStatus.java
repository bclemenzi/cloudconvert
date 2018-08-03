package com.nfbsoftware.cloudconvert.model;

public class ConversionStatus
{
    private String m_id;
    private String m_url;
    private String m_message;
    private String m_step;
    private String m_group;
    
    private int m_minutes;
    private int m_endtime;
    private int m_starttime;
    private int m_expire;
    
    private double m_percent;
    
    private Converter m_converter;
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

    public String getMessage()
    {
        return m_message;
    }
    public void setMessage(String message)
    {
        m_message = message;
    }

    public String getStep()
    {
        return m_step;
    }
    public void setStep(String step)
    {
        m_step = step;
    }

    public int getStarttime()
    {
        return m_starttime;
    }
    public void setStarttime(int starttime)
    {
        m_starttime = starttime;
    }

    public int getExpire()
    {
        return m_expire;
    }
    public void setExpire(int expire)
    {
        m_expire = expire;
    }

    public double getPercent()
    {
        return m_percent;
    }
    public void setPercent(double percent)
    {
        m_percent = percent;
    }

    public String getGroup()
    {
        return m_group;
    }
    public void setGroup(String group)
    {
        m_group = group;
    }
    
    public int getMinutes()
    {
        return m_minutes;
    }
    public void setMinutes(int minutes)
    {
        m_minutes = minutes;
    }
    
    public int getEndtime()
    {
        return m_endtime;
    }
    public void setEndtime(int endtime)
    {
        m_endtime = endtime;
    }
    
    public Converter getConverter()
    {
        return m_converter;
    }
    public void setConverter(Converter converter)
    {
        m_converter = converter;
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
}
