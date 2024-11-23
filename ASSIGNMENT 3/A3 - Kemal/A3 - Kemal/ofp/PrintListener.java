package ofp;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrintListener extends generated.ParserBaseListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { 
		printCurrent(ctx);
	}

	public void printCurrent(ParserRuleContext ctx) {
		System.out.println("  ".repeat(ctx.depth()) + ctx.getClass().getSimpleName());
	}

}
