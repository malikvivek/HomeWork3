package html;

import java.util.*;

public abstract class Node {
	
	protected Map<String, String> attributes;
	protected Node[] nodes;
	protected String data;
	
	
	/*
	 * Initializing the Node based upon the type of value it receives during declaration
	 */
	
	public Node ( Map <String, String> attributes, Node...nodes ) {
		this.attributes = attributes;
		this.nodes = nodes;
	}
	
	public Node ( Map <String, String> attributes, String data ) {
		this.attributes = attributes;
		this.data = data;
	}
	
	public Node ( Map <String, String> attributes ) {
		this.attributes = attributes;
	}
	
	/*
	 * textualRepresenTation
	 * - Method to display html in textual string
	 */
	public abstract String textualRepresentation();
	
	/*
	 * addAttr
	 * - This method is used to add attributes to the parameter ( output )
	 * @param output
	 */
	protected void addAttr ( StringBuilder output ) {
		
		if ( attributes == null )
			return;
		for ( String identifier : attributes.keySet() ) {
			output.append(" ");
			output.append(identifier);
			output.append("=");
			output.append(attributes.get(identifier));
		}
		
	}
	
	/*
	 * createNodeData
	 * - This method adds node data
	 * @param str | Type StringBuilder
	 */
	protected void createNodeData ( StringBuilder str ) {
		
		if ( nodes != null ) {
			for ( Node node : nodes ) {
				str.append(node.textualRepresentation());
			}
		}
		
		else if ( data != null ) {
			str.append(data);
		}
	}

	public Map<String, String> getAttributes () {
		if ( attributes == null )
			attributes = new HashMap<String, String>();
		return attributes;
	}
	
	public Node[] getNodes() {
		return nodes;
	}
}