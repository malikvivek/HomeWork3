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

public class HTMLTests {

	/*
	 * Testing sample test case given in assignment
	 */
	@Test
	public void testTextualRepresentation1 () {
		Map<String, String> divAtts = new HashMap<String, String>();
		divAtts.put( "id", "second" );
		divAtts.put( "class", "bar" );
		Div div = new Div ( divAtts, "b" );
		Map<String, String> noAttributes = new HashMap<String, String>();
		B b = new B( noAttributes, div );
		assertEquals(b.textualRepresentation(), "<b><div id=second class=bar>b</div></b>");
	}
	
	
	/*
	 * Testing with body tag
	 */
	@Test
	public void testSampleHTMLBody () {
		Map <String, String> divAtts = new HashMap<String, String>();
		divAtts.put("name", "value");
		divAtts.put("id", "testId");
		Div divObj = new Div( divAtts, "b");
		Map<String, String> emptyAtt = new HashMap<String, String>();
		B bObj = new B (emptyAtt, divObj);
		
		Map<String, String> bodyAtts = new HashMap<String, String>();
		bodyAtts.put("bodyId", "hello");
		Body bodyObj = new Body(bodyAtts, divObj, bObj);
	    assertEquals(bodyObj.textualRepresentation(), "<body bodyId=hello>"
	    											+ "<div name=value id=testId>b</div>"
	    											+ "<b>"
	    											+ "<div name=value id=testId>b</div>"
	    											+ "</b>"
	    											+ "</body>");
	}
	
	
	@Test
	public void testSampleHTML () {
		Map <String, String> divAtts = new HashMap<String, String>();
		divAtts.put("name", "value");
		divAtts.put("id", "testId");
		Div divObj = new Div( divAtts, "b");
		Map<String, String> emptyAtt = new HashMap<String, String>();
		B bObj = new B (emptyAtt, divObj);
		
		Map<String, String> bodyAtts = new HashMap<String, String>();
		bodyAtts.put("bodyId", "hello");
		Body bodyObj = new Body(bodyAtts, divObj, bObj);
		
		Map<String, String> emptyAtts = new HashMap<String, String>();
		Title titleObj = new Title(emptyAtts,"TestTitle");
		Head headObj = new Head(emptyAtts, titleObj);
		
		Html htmlObj = new Html(emptyAtts, headObj, bodyObj);
		assertEquals(htmlObj.textualRepresentation(), "<html>" +
													"<head><title>TestTitle</title></head>"
													+ "<body bodyId=hello>"
													+ "<div name=value id=testId>b</div>"
													+ "<b>"
													+ "<div name=value id=testId>b</div>"
													+ "</b>"
													+ "</body>"
													+ "</html>");
	}

}
