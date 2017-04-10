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
import html_factory.StandardHTMLNodeFactory;

public class HTMLFactoryTests {
	
	/*
	 * Testing sample test case given in assignment
	 */
	@Test
	public void testTextualRepresentationFactory () {
		StandardHTMLNodeFactory factoryObject = new StandardHTMLNodeFactory();
		
		Map<String, String> divAtts = new HashMap<String, String>();
		divAtts.put( "id", "second" );
		divAtts.put( "class", "bar" );
		Div div = factoryObject.makeDiv(divAtts, "b");
		Map<String, String> noAttributes = new HashMap<String, String>();
		B bObj = factoryObject.makeB(noAttributes, div);
		assertEquals(bObj.textualRepresentation(), "<b><div id=second class=bar>b</div></b>");
	}
	
	
	/*
	 * Testing with body tag using factory
	 */
	@Test
	public void testSampleHTMLBodyFactory () {

		StandardHTMLNodeFactory factoryObject = new StandardHTMLNodeFactory();
		
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
	    
	}
	
	
	/*
	 * Testing sample html page with factory 
	 */
	@Test
	public void testSampleHTML () {
		StandardHTMLNodeFactory factoryObject = new StandardHTMLNodeFactory();
		
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
		
	}
	
}