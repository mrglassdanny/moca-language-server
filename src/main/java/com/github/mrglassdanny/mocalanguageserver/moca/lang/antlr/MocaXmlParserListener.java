// Generated from MocaXmlParser.g4 by ANTLR 4.5.3

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MocaXmlParser}.
 */
public interface MocaXmlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(MocaXmlParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(MocaXmlParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(MocaXmlParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(MocaXmlParser.PrologContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(MocaXmlParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(MocaXmlParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(MocaXmlParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(MocaXmlParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(MocaXmlParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(MocaXmlParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(MocaXmlParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(MocaXmlParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterChardata(MocaXmlParser.ChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitChardata(MocaXmlParser.ChardataContext ctx);
	/**
	 * Enter a parse tree produced by {@link MocaXmlParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(MocaXmlParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link MocaXmlParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(MocaXmlParser.MiscContext ctx);
}