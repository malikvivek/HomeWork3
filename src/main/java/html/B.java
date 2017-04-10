package html;

import java.util.*;

public class B extends Node {

	public B(Map<String, String> attributes, Div divObj ) {
		super( attributes, new Node[]{divObj} );
		// TODO Auto-generated constructor stub
	}

	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<b");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</b>");
		return str.toString();
	}
	
}