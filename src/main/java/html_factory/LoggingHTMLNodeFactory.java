//package html_factory;
//
//import java.util.Map;
//
//import html.B;
//import html.Body;
//import html.Div;
//import html.Head;
//import html.Html;
//import html.Node;
//import html.Title;
//
//public class LoggingHTMLNodeFactory extends AbstractHTMLNodeFactory {
//	@Override
//	public Html makeHtml(Map<String, String> attributes, Head head, Body body) {
//		Html html = new Html(attributes, head, body);
//		System.out.println(html.textualRepresentation());
//		return html;
//	}
//
//	@Override
//	public Head makeHead(Map<String, String> attributes, Title title) {
//		Head head = new Head(attributes, title);
//		System.out.println(head.textualRepresentation());
//		return head;
//	}
//
//	@Override
//	public Title makeTitle(Map<String, String> attributes, String data) {
//		Title title = new Title(attributes, data);
//		System.out.println(title.textualRepresentation());
//		return title;
//	}
//
//	@Override
//	public Body makeBody(Map<String, String> attributes, Node... nodes) {
//		Body body = new Body(attributes, nodes);
//		System.out.println(body.textualRepresentation());
//		return body;
//	}
//
//	@Override
//	public Div makeDiv(Map<String, String> attributes, String data) {
//		Div div = new Div(attributes, data);
//		System.out.println(div.textualRepresentation());
//		return div;
//	}
//
//	@Override
//	public B makeB(Map<String, String> attributes, Div div) {
//		B b = new B(attributes, div);
//		System.out.println(b.textualRepresentation());
//		return b;
//	}
//}
package html_factory;

import java.util.*;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Node;
import html.Title;

public class LoggingHTMLNodeFactory extends AbstractHTMLNodeFactory {

	@Override
	public Html makeHtml(Map<String, String> attributes, Head headObj, Body bodyObj) {
		// TODO Auto-generated method stub
		Html htmlObject = new Html ( attributes, headObj, bodyObj);
		System.out.println(htmlObject.textualRepresentation());
		return htmlObject;
	}

	@Override
	public Head makeHead(Map<String, String> attributes, Title titleObj) {
		// TODO Auto-generated method stub
		Head headObject = new Head ( attributes, titleObj );
		System.out.println(headObject.textualRepresentation());
		return headObject;
	}

	@Override
	public Title makeTitle(Map<String, String> attributes, String data) {
		// TODO Auto-generated method stub
		Title titleObject = new Title ( attributes, data );
		System.out.println(titleObject.textualRepresentation());
		return titleObject;
	}

	@Override
	public Body makeBody(Map<String, String> attributes, Node... nodes) {
		// TODO Auto-generated method stub
		Body bodyObject = new Body ( attributes, nodes );
		System.out.println(bodyObject.textualRepresentation());
		return bodyObject;
	}

	@Override
	public Div makeDiv(Map<String, String> attributes, String data) {
		// TODO Auto-generated method stub
		Div divObject = new Div ( attributes, data );
		System.out.println(divObject.textualRepresentation());
		return divObject;
	}

	@Override
	public B makeB(Map<String, String> attributes, Div divObj) {
		// TODO Auto-generated method stub
		B bObject = new B ( attributes, divObj );
		System.out.println(bObject.textualRepresentation());
		return bObject;
	}
	
}