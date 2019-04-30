package com.nfbsoftware.cloudconvert.model;

public class Options
{
    private String m_audio_codec;
    private String m_page_range;
    private String m_bg_format;
    private String m_input_password;
    private String m_templating;
    private String m_space_as_offset;
    
    private boolean m_split_pages;
    private boolean m_simple_html;
    private boolean m_embed_font;
    private boolean m_outline;
    private boolean m_embed_css;
    private boolean m_embed_image;
    private boolean m_hidden_slides;
    private boolean m_embed_javascript;
    
    private double m_zoom;
    
    private int m_page_width;
    private int m_page_height;
    
    public String getAudio_codec()
    {
        return m_audio_codec;
    }
    public void setAudio_codec(String audio_codec)
    {
        m_audio_codec = audio_codec;
    }
    
    public String getTemplating()
    {
        return m_templating;
    }
    public void setTemplating(String templating)
    {
        m_templating = templating;
    }
    
    public boolean isHidden_slides()
    {
        return m_hidden_slides;
    }
    public void setHidden_slides(boolean hidden_slides)
    {
        m_hidden_slides = hidden_slides;
    }
    
    public String getInput_password()
    {
        return m_input_password;
    }
    public void setInput_password(String input_password)
    {
        m_input_password = input_password;
    }
    
    public String getPage_range()
    {
        return m_page_range;
    }
    public void setPage_range(String page_range)
    {
        m_page_range = page_range;
    }
    
    public String getBg_format()
    {
        return m_bg_format;
    }
    public void setBg_format(String bg_format)
    {
        m_bg_format = bg_format;
    }
    
    public boolean isSplit_pages()
    {
        return m_split_pages;
    }
    public void setSplit_pages(boolean split_pages)
    {
        m_split_pages = split_pages;
    }
    
    public boolean isSimple_html()
    {
        return m_simple_html;
    }
    public void setSimple_html(boolean simple_html)
    {
        m_simple_html = simple_html;
    }
    
    public boolean isEmbed_font()
    {
        return m_embed_font;
    }
    public void setEmbed_font(boolean embed_font)
    {
        m_embed_font = embed_font;
    }
    
    public boolean isOutline()
    {
        return m_outline;
    }
    public void setOutline(boolean outline)
    {
        m_outline = outline;
    }
    
    public boolean isEmbed_css()
    {
        return m_embed_css;
    }
    public void setEmbed_css(boolean embed_css)
    {
        m_embed_css = embed_css;
    }
    
    public boolean isEmbed_image()
    {
        return m_embed_image;
    }
    public void setEmbed_image(boolean embed_image)
    {
        m_embed_image = embed_image;
    }
    
    public boolean isEmbed_javascript()
    {
        return m_embed_javascript;
    }
    public void setEmbed_javascript(boolean embed_javascript)
    {
        m_embed_javascript = embed_javascript;
    }
    
    public double getZoom()
    {
        return m_zoom;
    }
    public void setZoom(double zoom)
    {
        m_zoom = zoom;
    }
    
    public int getPage_width()
    {
        return m_page_width;
    }
    public void setPage_width(int page_width)
    {
        m_page_width = page_width;
    }
    
    public int getPage_height()
    {
        return m_page_height;
    }
    public void setPage_height(int page_height)
    {
        m_page_height = page_height;
    }
    
    public String getSpace_as_offset()
    {
        return m_space_as_offset;
    }
    public void setSpace_as_offset(String space_as_offset)
    {
        m_space_as_offset = space_as_offset;
    }
}
