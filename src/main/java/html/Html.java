package html;

import java.util.*;

public class Html extends Node {

	public Html(Map<String, String> attributes, Head head, Body body) {
		super(attributes, new Node[]{head, body});
		// TODO Auto-generated constructor stub
	}
	
	public Html(Map<String, String> attributes, Body body) {
		super(attributes, body);
		// TODO Auto-generated constructor stub
	}
	
	public Html(Map<String, String> attributes, Head head) {
		super(attributes, head);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<html");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</html>");
		return str.toString();
	}
	
}