# CloudConvert Java Library

## What is CloudConvert?

[CloudConvert](https://cloudconvert.com/) supports the conversion between more than 200 different audio, video, document, ebook, archive, image, spreadsheet and presentation formats. Check the supported formats for more details.  The CloudConvert API offers the full functionality of CloudConvert and makes it possible to use the conversion services in your own applications.

Features
--------

  * Supports CloudConvert API - [CloudConvert API](https://cloudconvert.com/api)
  * Fully implemented authentication system.  Just enter your CloudConvert credentials and go!
  * Published on Maven Central Repository.

Getting started
---------------
Including the Java library in your project

The easiest way to incorporate the library into your Java project is to use Maven. Simply add a new dependency to your `pom.xml`:

```xml
<dependency>
	<groupId>com.nfbsoftware</groupId>
	<artifactId>cloudconvert</artifactId>
	<version>1.0.0</version>
</dependency>
```

Get some credentials
-----

First you will need some credentials.  Either get some by paying CloudConvert some money, or by [signing up for an account](https://cloudconvert.com/register).

Usage
-----
The easiest way to get started is to just use the CloudConvertClient class, like this:
					
```java	
String myApiKey = "ajhsdflaksjdhfalskjdhfalksdjhfalksdjhfalksdhflaiusehrflkajerbglkajdbf";
CloudConvertClient cloudConvertClient = new CloudConvertClient(myApiKey);
```

In order to start a new conversion you need to create a new Process ID first. Each Process ID is for one-time use only and can only be used for converting one file.

```java					
String myApiKey = "ajhsdflaksjdhfalskjdhfalksdjhfalksdjhfalksdhflaiusehrflkajerbglkajdbf";
CloudConvertClient cloudConvertClient = new CloudConvertClient(API_KEY);

// Request a new process id
ConvertProcess processValue = cloudConvertClient.getProcess("flv", "mp4");

System.out.println("processValue ID: " + processValue.getId());
```	

Get the actual conversion started for a file with a public file url.

```java					
String myApiKey = "ajhsdflaksjdhfalskjdhfalksdjhfalksdjhfalksdhflaiusehrflkajerbglkajdbf";
CloudConvertClient cloudConvertClient = new CloudConvertClient(API_KEY);

// Request a new process id
ConvertProcess processValue = cloudConvertClient.getProcess("pdf", "html");
        
// Convert the pdf hosted publicly
String myOriginalFileUrl = "https://raw.githubusercontent.com/bclemenzi/cloudconvert/master/doc_samples/sample.pdf";
StartConversion startConversionValue = cloudConvertClient.startConversion(processValue, "pdf", "html", "download", myOriginalFileUrl);
```	

Check the status of a previous requested conversion

```java					
String myApiKey = "ajhsdflaksjdhfalskjdhfalksdjhfalksdjhfalksdhflaiusehrflkajerbglkajdbf";
CloudConvertClient cloudConvertClient = new CloudConvertClient(API_KEY);

// Request a new process id
ConvertProcess processValue = cloudConvertClient.getProcess("pdf", "html");
        
// Convert the pdf hosted publicly
String myOriginalFileUrl = "https://raw.githubusercontent.com/bclemenzi/cloudconvert/master/doc_samples/sample.pdf";
StartConversion startConversionValue = cloudConvertClient.startConversion(processValue, "pdf", "html", "download", myOriginalFileUrl);

// Check the status of the started converssion.  The boolean tells the API if we should wait for a FINISHED step.
ConversionStatus conversionStatusValue = cloudConvertClient.getConversionStatus(startConversionValue.getUrl(), true);
            
// Get our download link
System.out.println("Converted Filename:  " + conversionStatusValue.getOutput().getFilename());
System.out.println("Converted File Download Link:  https:" + conversionStatusValue.getOutput().getUrl());
```	

