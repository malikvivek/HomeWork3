package html_factory;

import java.util.*;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Node;
import html.Title;

public class StandardHTMLNodeFactory extends AbstractHTMLNodeFactory {

	@Override
	public Html makeHtml(Map<String, String> attributes, Head headObj, Body bodyObj) {
		// TODO Auto-generated method stub
		return new Html( attributes, headObj, bodyObj );
	}

	@Override
	public Head makeHead(Map<String, String> attributes, Title titleObj) {
		// TODO Auto-generated method stub
		return new Head( attributes, titleObj );
	}

	@Override
	public Title makeTitle(Map<String, String> attributes, String data) {
		// TODO Auto-generated method stub
		return new Title( attributes, data );
	}

	@Override
	public Body makeBody(Map<String, String> attributes, Node... nodes) {
		// TODO Auto-generated method stub
		return new Body( attributes, nodes );
	}

	@Override
	public Div makeDiv(Map<String, String> attributes, String data) {
		// TODO Auto-generated method stub
		return new Div( attributes, data );
	}

	@Override
	public B makeB(Map<String, String> attributes, Div divObj) {
		// TODO Auto-generated method stub
		return new B( attributes, divObj );
	}
	
}