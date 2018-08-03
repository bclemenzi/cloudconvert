package com.nfbsoftware.cloudconvert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nfbsoftware.cloudconvert.model.ConversionStatus;
import com.nfbsoftware.cloudconvert.model.ConvertProcess;
import com.nfbsoftware.cloudconvert.model.StartConversion;

/**
 * 
 * @author Brendan Clemenzi
 * @email brendan@clemenzi.com
 */
public class CloudConvertModelTest
{
    private String API_KEY = "MY_API_KEY"; // set your api key

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testConvertProcess() throws Exception
    {
        System.out.println("====> Starting CloudConvertModelTest.testConvertProcess");

        CloudConvertClient cloudConvertClient = new CloudConvertClient(API_KEY);

        ConvertProcess processValue = cloudConvertClient.getProcess("flv", "mp4");
        System.out.println("testProcess Name: " + processValue.getId());

        if (processValue != null)
        {
            assertTrue(true);
        }

        System.out.println("====> Finished CloudConvertModelTest.testConvertProcess");
    }
    
    /**
     * 
     * @throws Exception
     */
    @Test
    public void testDownloadConvert() throws Exception
    {
        System.out.println("====> Starting CloudConvertModelTest.testDownloadConvert");

        CloudConvertClient cloudConvertClient = new CloudConvertClient(API_KEY);

        ConvertProcess processValue = cloudConvertClient.getProcess("pdf", "html");
        
        // Convert the pdf hosted publicly
        String myOriginalFileUrl = "https://raw.githubusercontent.com/bclemenzi/cloudconvert/master/doc_samples/sample.pdf";
        StartConversion startConversionValue = cloudConvertClient.startConversion(processValue, "pdf", "html", "download", myOriginalFileUrl);
        
        try
        {
            // Check the status
            ConversionStatus conversionStatusValue = cloudConvertClient.getConversionStatus(startConversionValue, true);
            
            System.out.println(conversionStatusValue.getId());
            System.out.println(conversionStatusValue.getStep());
            System.out.println(conversionStatusValue.getPercent());

            if (startConversionValue != null)
            {
                assertTrue(true);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("====> Finished CloudConvertModelTest.testDownloadConvert");
    }
}
