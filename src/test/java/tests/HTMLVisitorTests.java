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
import visitor.AttributeSerachVisitor;
import visitor.NodeCountVisitor;

public class HTMLVisitorTests {

	/*
	 * Count html, div and body
	 */
	@Test
	public void test() {
		Map<String, String> divAttributes = new HashMap<String, String>();
		divAttributes.put("id", "hello");
		divAttributes.put("class", "TestClass");
		Div divObj = new Div (divAttributes, "Test");
		Body bodyObject = new Body (null, divObj);
		Html htmlObj = new Html (null, bodyObject);
		
		NodeCountVisitor obj = new NodeCountVisitor();
		obj.visitHTML(htmlObj);	
		assertEquals ( 1, obj.getNumberHtml() );

		NodeCountVisitor obj2 = new NodeCountVisitor();
		obj2.visitBody(bodyObject);
		assertEquals ( 1, obj2.getNumberBody());
		
		NodeCountVisitor obj3 = new NodeCountVisitor();
		obj3.visitDiv(divObj);
		assertEquals ( 1, obj3.getNumberDiv());
		
	}
	
	
	/*
	 * Count all tags i.e html, head, title, body, div and b
	 */
	@Test
	public void testNodeCountVisitorWithSampleHTML () {
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
		
		NodeCountVisitor obj = new NodeCountVisitor();
		obj.visitHTML(htmlObj);	
		assertEquals ( 1, obj.getNumberHtml() );

		NodeCountVisitor obj2 = new NodeCountVisitor();
		obj2.visitBody(bodyObj);
		assertEquals ( 1, obj2.getNumberBody());
		
		NodeCountVisitor obj3 = new NodeCountVisitor();
		obj3.visitDiv(divObj);
		assertEquals ( 1, obj3.getNumberDiv());
		
		NodeCountVisitor obj4 = new NodeCountVisitor();
		obj4.visitHead(headObj);
		assertEquals ( 1, obj4.getNumberHead());
		
		NodeCountVisitor obj5 = new NodeCountVisitor();
		obj5.visitTitle(titleObj);;
		assertEquals ( 1, obj5.getNumberTitle());
		
		NodeCountVisitor obj6 = new NodeCountVisitor();
		obj6.visitB(bObj);;
		assertEquals ( 1, obj6.getNumberB());
		
	}
	
	/*
	 * Testing AttributeSearchVisitor
	 */
	@Test
	public void testAttributeSearchVisitor(){
		Map<String, String> divAttributes = new HashMap<String, String>();
		divAttributes.put("id", "hello");
		divAttributes.put("class", "TestClass");
		Div divObj = new Div (divAttributes, "Test");
		Body bodyObject = new Body (null, divObj);
		Html htmlObj = new Html (null, bodyObject);
		
		AttributeSerachVisitor testObj = new AttributeSerachVisitor("id","hello");

		testObj.visitHTML(htmlObj);
		assertEquals(1, testObj.getMatch().size());
		
		AttributeSerachVisitor testObj2 = new AttributeSerachVisitor("id","hello");
		testObj2.visitDiv(divObj);
		assertEquals(1, testObj2.getMatch().size());
		
		AttributeSerachVisitor testObj3 = new AttributeSerachVisitor("abc","hello");
		testObj3.visitDiv(divObj);
		assertEquals(0, testObj3.getMatch().size());		
	}
	
	
	/*
	 * Test AttributeSearchVisitor using simple html page for all tags
	 */
	@Test
	public void testAttributeSearchVisitorWithSampleHTML() {
		
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
		
		AttributeSerachVisitor testObj = new AttributeSerachVisitor("name","value");

		testObj.visitHTML(htmlObj);
		assertEquals(2, testObj.getMatch().size());
		
		AttributeSerachVisitor testObj2 = new AttributeSerachVisitor("id","TestId");
		testObj2.visitDiv(divObj);
		assertEquals(1, testObj2.getMatch().size());
		
		AttributeSerachVisitor testObj3 = new AttributeSerachVisitor("abc","hello");
		testObj3.visitDiv(divObj);
		assertEquals(0, testObj3.getMatch().size());
		
		AttributeSerachVisitor testObj4 = new AttributeSerachVisitor("bodyId","hello");
		testObj4.visitBody(bodyObj);
		assertEquals(1, testObj4.getMatch().size());
		
		AttributeSerachVisitor testObj5 = new AttributeSerachVisitor("blah","blah");
		testObj5.visitBody(bodyObj);
		assertEquals(0, testObj5.getMatch().size());
		
		AttributeSerachVisitor testObj6 = new AttributeSerachVisitor("bodyId","hello");
		testObj6.visitB(bObj);
		assertEquals(0, testObj6.getMatch().size());
		
		AttributeSerachVisitor testObj7 = new AttributeSerachVisitor("bodyId","hello");
		testObj7.visitHead(headObj);
		assertEquals(0, testObj7.getMatch().size());
		
		AttributeSerachVisitor testObj8 = new AttributeSerachVisitor("bodyId","hello");
		testObj8.visitTitle(titleObj);;
		assertEquals(0, testObj8.getMatch().size());
		
	}
	
}
