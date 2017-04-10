package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Title;
import html_factory.LoggingHTMLNodeFactory;

public class LoggingHTMLFactoryTests {

	/*
	 * Testing sample test case given in assignment
	 */
	@Test
	public void testTextualRepresentationFactory () {
		LoggingHTMLNodeFactory factoryObject = new LoggingHTMLNodeFactory();
		
		Map<String, String> divAtts = new HashMap<String, String>();
		divAtts.put( "id", "second" );
		divAtts.put( "class", "bar" );
		Div div = factoryObject.makeDiv(divAtts, "b");
		Map<String, String> noAttributes = new HashMap<String, String>();
		B bObj = factoryObject.makeB(noAttributes, div);
		assertEquals(bObj.textualRepresentation(), "<b><div id=second class=bar>b</div></b>");
		assertNotNull(div);
		assertNotNull(bObj);
	}
	
	
	/*
	 * Testing with body tag using logging factory
	 */
	@Test
	public void testSampleHTMLBodyFactory () {

		LoggingHTMLNodeFactory factoryObject = new LoggingHTMLNodeFactory();
		
		Map <String, String> divAtts = new HashMap<String, String>();
		divAtts.put("name", "value");
		divAtts.put("id", "testId");
		Div divObj = factoryObject.makeDiv(divAtts, "DivTest");
		Map<String, String> emptyAtt = new HashMap<String, String>();
		B bObj = factoryObject.makeB(emptyAtt, divObj);
		
		Map<String, String> bodyAtts = new HashMap<String, String>();
		bodyAtts.put("bodyId", "hello");
		Body bodyObj = factoryObject.makeBody(bodyAtts, divObj, bObj);
	    assertEquals(bodyObj.textualRepresentation(), "<body bodyId=hello>"
	    											+ "<div name=value id=testId>DivTest</div>"
	    											+ "<b>"
	    											+ "<div name=value id=testId>DivTest</div>"
	    											+ "</b>"
	    											+ "</body>");
		assertNotNull(divObj);
		assertNotNull(bObj);
		assertNotNull(bodyObj);
	    
	}
	
	
	/*
	 * Testing sample html page with logging factory 
	 */
	@Test
	public void testSampleHTML () {
		LoggingHTMLNodeFactory factoryObject = new LoggingHTMLNodeFactory();
		
		Map <String, String> divAtts = new HashMap<String, String>();
		divAtts.put("name", "value");
		divAtts.put("id", "testId");
		Div divObj = factoryObject.makeDiv(divAtts, "DivTest");
		Map<String, String> emptyAtt = new HashMap<String, String>();
		B bObj = factoryObject.makeB(emptyAtt, divObj);
		
		Map<String, String> bodyAtts = new HashMap<String, String>();
		bodyAtts.put("bodyId", "hello");
		Body bodyObj = factoryObject.makeBody(bodyAtts, divObj, bObj);
		
		Map<String, String> emptyAtts = new HashMap<String, String>();
		Title titleObj = factoryObject.makeTitle(emptyAtts, "TestTitle");//new Title(emptyAtts,"TestTitle");
		Head headObj = factoryObject.makeHead(emptyAtts, titleObj);//new Head(emptyAtts, titleObj);
		
		Html htmlObj = factoryObject.makeHtml(emptyAtts, headObj, bodyObj);//new Html(emptyAtts, headObj, bodyObj);
		assertEquals(htmlObj.textualRepresentation(), "<html>" +
													"<head><title>TestTitle</title></head>"
													+ "<body bodyId=hello>"
													+ "<div name=value id=testId>DivTest</div>"
													+ "<b>"
													+ "<div name=value id=testId>DivTest</div>"
													+ "</b>"
													+ "</body>"
													+ "</html>");
		assertNotNull(divObj);
		assertNotNull(bObj);
		assertNotNull(bodyObj);
		assertNotNull(headObj);
		assertNotNull(titleObj);
		assertNotNull(htmlObj);
		
	}

}
