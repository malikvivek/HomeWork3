package visitor;

import html.B;
import html.Body;
import html.Div;
import html.Head;
import html.Html;
import html.Title;

public interface NodeVisitor {
	
	void visitHTML (Html h);
	void visitHead (Head h);
	void visitBody (Body b);
	void visitDiv (Div d);
	void visitTitle (Title t);
	void visitB (B b);

}
