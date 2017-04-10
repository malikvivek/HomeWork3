package html;

import java.util.*;

public class Title extends Node {

	public Title(Map<String, String> attributes, String data) {
		super(attributes, data);
		// TODO Auto-generated constructor stub
	}
	
	public Title(Map<String, String> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String textualRepresentation() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder("<title");
		addAttr(str);
		str.append(">");
		createNodeData(str);
		str.append("</title>");
		return str.toString();
	}
	
}