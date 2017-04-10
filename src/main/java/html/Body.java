package html;

import java.util.*;

public class Body extends Node {

	public Body(Map<String, String> attributes, Node[] nodes) {
		super(attributes, nodes);
		// TODO Auto-generated constructor stub
	}
	

	public Body(Map<String, String> attributes, Div divObj) {
		super(attributes, divObj);
		// TODO Auto-generated constructor stub
	}

	public Body(Map<String, String> attributes, Div divObj, B bObj) {
		// TODO Auto-generated constructor stub
		super ( attributes, divObj, bObj );
	}


	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<body");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</body>");
		return str.toString();
	}
	
}
