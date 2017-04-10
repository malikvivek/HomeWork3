package visitor;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Node;
import html.Title;

public class NodeCountVisitor implements NodeVisitor {
	
	private int numberHtml;
	private int numberHead;
	private int numberBody;
	private int numberTitle;
	private int numberDiv;
	private int numberB;
	
	public NodeCountVisitor() {
		numberHtml = 0;
		numberHead = 0;
		numberBody = 0;
		numberTitle = 0;
		numberDiv = 0;
		numberB = 0;
	}

	@Override
	public void visitHTML(Html h) {
		// TODO Auto-generated method stub
		numberHtml++;
		nodeVisitor(h);
		
	}

	@Override
	public void visitHead(Head h) {
		// TODO Auto-generated method stub
		numberHead++;
		nodeVisitor(h);
	}

	@Override
	public void visitBody(Body b) {
		// TODO Auto-generated method stub
		numberBody++;
		nodeVisitor(b);
	}

	@Override
	public void visitDiv(Div d) {
		// TODO Auto-generated method stub
		numberDiv++;
		nodeVisitor(d);
	}

	@Override
	public void visitTitle(Title t) {
		// TODO Auto-generated method stub
		numberTitle++;
		nodeVisitor(t);
	}

	@Override
	public void visitB(B b) {
		// TODO Auto-generated method stub
		numberB++;
		nodeVisitor(b);
	}
	
	public void nodeVisitor (Node node) {
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

	public int getNumberHtml() {
		return numberHtml;
	}

	public int getNumberHead() {
		return numberHead;
	}

	public int getNumberBody() {
		return numberBody;
	}

	public int getNumberTitle() {
		return numberTitle;
	}

	public int getNumberDiv() {
		return numberDiv;
	}

	public int getNumberB() {
		return numberB;
	}
}
