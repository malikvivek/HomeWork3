package html;

import java.util.*;

public class Div extends Node {

	public Div(Map<String, String> attributes, String data) {
		super(attributes, data);
		// TODO Auto-generated constructor stub
	}
	
	public Div(Map<String,String> attributes) {
		super ( attributes );
	}

	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<div");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</div>");
		return str.toString();
	}
	
}