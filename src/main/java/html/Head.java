package html;

import java.util.*;

public class Head extends Node {

	public Head(Map<String, String> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}
	
	public Head(Map<String, String> attributes, Title title) {
		super ( attributes, title );
	}

	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<head");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</head>");
		return str.toString();
	}
	
}