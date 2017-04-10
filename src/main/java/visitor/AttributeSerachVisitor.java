package visitor;

import java.util.Map;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Node;
import html.Title;
import stringset.StringSet;

public class AttributeSerachVisitor implements NodeVisitor {
	
	private String name;
	private String value;
	private StringSet match;
	
	public AttributeSerachVisitor(String name, String value) {
		// TODO Auto-generated constructor stub
		match = new StringSet();
		this.name = name;
		this.value = value;
	}

	@Override
	public void visitHTML(Html h) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = h.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
			match.add("HTML");
		}
		getSameAttr(h);
		
	}

	@Override
	public void visitHead(Head h) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = h.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
			match.add("Head");
		}
		getSameAttr(h);
		
	}

	@Override
	public void visitBody(Body b) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = b.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
			match.add("Body");
		}
		getSameAttr(b);
		
	}

	@Override
	public void visitDiv(Div d) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = d.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
//			System.out.println(name);
//			System.out.println(value);
			match.add("Div");
		}
		getSameAttr(d);
		
	}

	@Override
	public void visitTitle(Title t) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = t.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
			match.add("Title");
		}
		getSameAttr(t);
		
	}

	@Override
	public void visitB(B b) {
		// TODO Auto-generated method stub
		Map<String, String> attributesFetched = b.getAttributes();
		
		if (attributesFetched.containsKey(name) && value.equalsIgnoreCase(attributesFetched.get(name))) {
			match.add("B Tag");
		}
		getSameAttr(b);
		
	}
	
	private void getSameAttr ( Node node ) {
		
		Node[] nodes = node.getNodes();
		if ( nodes == null )
			return;
		
		for ( Node localNode : nodes ) {
			if ( localNode instanceof Html )
				visitHTML((Html)localNode);
			else if (localNode instanceof Head)
				visitHead((Head)localNode);
			else if (localNode instanceof Body)
				visitBody((Body)localNode);
			else if (localNode instanceof Div)
				visitDiv((Div)localNode);
			else if (localNode instanceof Title)
				visitTitle((Title)localNode);
			else if (localNode instanceof B)
				visitB((B)localNode);
		}
	}
	
	public StringSet getMatch (){
		return match;
	}

}
