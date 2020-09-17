// Generated from MocaXmlParser.g4 by ANTLR 4.5.3

package com.github.mrglassdanny.mocalanguageserver.moca.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MocaXmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MocaXmlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(MocaXmlParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#prolog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProlog(MocaXmlParser.PrologContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(MocaXmlParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(MocaXmlParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(MocaXmlParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(MocaXmlParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#chardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChardata(MocaXmlParser.ChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link MocaXmlParser#misc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMisc(MocaXmlParser.MiscContext ctx);
}