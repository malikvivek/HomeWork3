package html_factory;

import java.util.*;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Node;
import html.Title;

public abstract class AbstractHTMLNodeFactory {
	
	public abstract Html makeHtml ( Map<String, String> attributes, Head headObj, Body bodyObj );
	
	public abstract Head makeHead ( Map<String, String> attributes, Title titleObj );
	
	public abstract Title makeTitle ( Map<String, String> attributes, String data );
	
	public abstract Body makeBody ( Map<String, String> attributes, Node... nodes );
	
	public abstract Div makeDiv ( Map<String, String> attributes, String data );
	
	public abstract B makeB ( Map<String, String> attributes, Div divObj );
	
}