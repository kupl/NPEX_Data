// Generated from com/blazebit/persistence/parser/JPQLSelectExpression.g4 by ANTLR 4.6
package com.blazebit.persistence.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JPQLSelectExpressionParser}.
 */
public interface JPQLSelectExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseOrderByClause}.
	 * @param ctx the parse tree
	 */
	void enterParseOrderByClause(JPQLSelectExpressionParser.ParseOrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseOrderByClause}.
	 * @param ctx the parse tree
	 */
	void exitParseOrderByClause(JPQLSelectExpressionParser.ParseOrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parsePath}.
	 * @param ctx the parse tree
	 */
	void enterParsePath(JPQLSelectExpressionParser.ParsePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parsePath}.
	 * @param ctx the parse tree
	 */
	void exitParsePath(JPQLSelectExpressionParser.ParsePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseJoinPath}.
	 * @param ctx the parse tree
	 */
	void enterParseJoinPath(JPQLSelectExpressionParser.ParseJoinPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseJoinPath}.
	 * @param ctx the parse tree
	 */
	void exitParseJoinPath(JPQLSelectExpressionParser.ParseJoinPathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleJoinPathExpression(JPQLSelectExpressionParser.SimpleJoinPathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleJoinPathExpression(JPQLSelectExpressionParser.SimpleJoinPathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExtendedJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterExtendedJoinPathExpression(JPQLSelectExpressionParser.ExtendedJoinPathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExtendedJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitExtendedJoinPathExpression(JPQLSelectExpressionParser.ExtendedJoinPathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleJoinElementExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleJoinElementExpression(JPQLSelectExpressionParser.SingleJoinElementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleJoinElementExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleJoinElementExpression(JPQLSelectExpressionParser.SingleJoinElementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TreatJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterTreatJoinPathExpression(JPQLSelectExpressionParser.TreatJoinPathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TreatJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitTreatJoinPathExpression(JPQLSelectExpressionParser.TreatJoinPathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimplePath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimplePath(JPQLSelectExpressionParser.SimplePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimplePath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimplePath(JPQLSelectExpressionParser.SimplePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TreatedRootPath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterTreatedRootPath(JPQLSelectExpressionParser.TreatedRootPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TreatedRootPath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitTreatedRootPath(JPQLSelectExpressionParser.TreatedRootPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#subtype}.
	 * @param ctx the parse tree
	 */
	void enterSubtype(JPQLSelectExpressionParser.SubtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#subtype}.
	 * @param ctx the parse tree
	 */
	void exitSubtype(JPQLSelectExpressionParser.SubtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseSimpleExpression(JPQLSelectExpressionParser.ParseSimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseSimpleExpression(JPQLSelectExpressionParser.ParseSimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleSubqueryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseSimpleSubqueryExpression(JPQLSelectExpressionParser.ParseSimpleSubqueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleSubqueryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseSimpleSubqueryExpression(JPQLSelectExpressionParser.ParseSimpleSubqueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseScalarExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseScalarExpression(JPQLSelectExpressionParser.ParseScalarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseScalarExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseScalarExpression(JPQLSelectExpressionParser.ParseScalarExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseArithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseArithmeticExpression(JPQLSelectExpressionParser.ParseArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseArithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseArithmeticExpression(JPQLSelectExpressionParser.ParseArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseStringExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseStringExpression(JPQLSelectExpressionParser.ParseStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseStringExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseStringExpression(JPQLSelectExpressionParser.ParseStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseCaseOperandExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseCaseOperandExpression(JPQLSelectExpressionParser.ParseCaseOperandExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseCaseOperandExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseCaseOperandExpression(JPQLSelectExpressionParser.ParseCaseOperandExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseInItemExpression(JPQLSelectExpressionParser.ParseInItemExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseInItemExpression(JPQLSelectExpressionParser.ParseInItemExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemOrPathExpression}.
	 * @param ctx the parse tree
	 */
	void enterParseInItemOrPathExpression(JPQLSelectExpressionParser.ParseInItemOrPathExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemOrPathExpression}.
	 * @param ctx the parse tree
	 */
	void exitParseInItemOrPathExpression(JPQLSelectExpressionParser.ParseInItemOrPathExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#parsePredicateExpression}.
	 * @param ctx the parse tree
	 */
	void enterParsePredicateExpression(JPQLSelectExpressionParser.ParsePredicateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#parsePredicateExpression}.
	 * @param ctx the parse tree
	 */
	void exitParsePredicateExpression(JPQLSelectExpressionParser.ParsePredicateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(JPQLSelectExpressionParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(JPQLSelectExpressionParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#key_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterKey_value_expression(JPQLSelectExpressionParser.Key_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#key_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitKey_value_expression(JPQLSelectExpressionParser.Key_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#treated_key_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterTreated_key_value_expression(JPQLSelectExpressionParser.Treated_key_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#treated_key_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitTreated_key_value_expression(JPQLSelectExpressionParser.Treated_key_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntryFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 */
	void enterEntryFunction(JPQLSelectExpressionParser.EntryFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntryFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 */
	void exitEntryFunction(JPQLSelectExpressionParser.EntryFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeyValueExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 */
	void enterKeyValueExpression(JPQLSelectExpressionParser.KeyValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeyValueExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 */
	void exitKeyValueExpression(JPQLSelectExpressionParser.KeyValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSingle_valued_path_expression(JPQLSelectExpressionParser.Single_valued_path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSingle_valued_path_expression(JPQLSelectExpressionParser.Single_valued_path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#general_path_start}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_path_start(JPQLSelectExpressionParser.General_path_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#general_path_start}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_path_start(JPQLSelectExpressionParser.General_path_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_path_element}.
	 * @param ctx the parse tree
	 */
	void enterSimple_path_element(JPQLSelectExpressionParser.Simple_path_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_path_element}.
	 * @param ctx the parse tree
	 */
	void exitSimple_path_element(JPQLSelectExpressionParser.Simple_path_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#general_path_element}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_path_element(JPQLSelectExpressionParser.General_path_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#general_path_element}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_path_element(JPQLSelectExpressionParser.General_path_elementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpressionParameterIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionParameterIndex(JPQLSelectExpressionParser.ArrayExpressionParameterIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpressionParameterIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionParameterIndex(JPQLSelectExpressionParser.ArrayExpressionParameterIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpressionPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionPathIndex(JPQLSelectExpressionParser.ArrayExpressionPathIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpressionPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionPathIndex(JPQLSelectExpressionParser.ArrayExpressionPathIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpressionSingleElementPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionSingleElementPathIndex(JPQLSelectExpressionParser.ArrayExpressionSingleElementPathIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpressionSingleElementPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionSingleElementPathIndex(JPQLSelectExpressionParser.ArrayExpressionSingleElementPathIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpressionIntegerLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionIntegerLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionIntegerLiteralIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpressionIntegerLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionIntegerLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionIntegerLiteralIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpressionStringLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionStringLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionStringLiteralIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpressionStringLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionStringLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionStringLiteralIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#general_subpath}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_subpath(JPQLSelectExpressionParser.General_subpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#general_subpath}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_subpath(JPQLSelectExpressionParser.General_subpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_subpath}.
	 * @param ctx the parse tree
	 */
	void enterSimple_subpath(JPQLSelectExpressionParser.Simple_subpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_subpath}.
	 * @param ctx the parse tree
	 */
	void exitSimple_subpath(JPQLSelectExpressionParser.Simple_subpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#treated_subpath}.
	 * @param ctx the parse tree
	 */
	void enterTreated_subpath(JPQLSelectExpressionParser.Treated_subpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#treated_subpath}.
	 * @param ctx the parse tree
	 */
	void exitTreated_subpath(JPQLSelectExpressionParser.Treated_subpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#state_field_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterState_field_path_expression(JPQLSelectExpressionParser.State_field_path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#state_field_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitState_field_path_expression(JPQLSelectExpressionParser.State_field_path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_object_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSingle_valued_object_path_expression(JPQLSelectExpressionParser.Single_valued_object_path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_object_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSingle_valued_object_path_expression(JPQLSelectExpressionParser.Single_valued_object_path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(JPQLSelectExpressionParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(JPQLSelectExpressionParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#collection_valued_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterCollection_valued_path_expression(JPQLSelectExpressionParser.Collection_valued_path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#collection_valued_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitCollection_valued_path_expression(JPQLSelectExpressionParser.Collection_valued_path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#single_element_path_expression}.
	 * @param ctx the parse tree
	 */
	void enterSingle_element_path_expression(JPQLSelectExpressionParser.Single_element_path_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#single_element_path_expression}.
	 * @param ctx the parse tree
	 */
	void exitSingle_element_path_expression(JPQLSelectExpressionParser.Single_element_path_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AggregateExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 */
	void enterAggregateExpression(JPQLSelectExpressionParser.AggregateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AggregateExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 */
	void exitAggregateExpression(JPQLSelectExpressionParser.AggregateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountStar}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 */
	void enterCountStar(JPQLSelectExpressionParser.CountStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountStar}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 */
	void exitCountStar(JPQLSelectExpressionParser.CountStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#aggregate_argument}.
	 * @param ctx the parse tree
	 */
	void enterAggregate_argument(JPQLSelectExpressionParser.Aggregate_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#aggregate_argument}.
	 * @param ctx the parse tree
	 */
	void exitAggregate_argument(JPQLSelectExpressionParser.Aggregate_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#scalar_expression}.
	 * @param ctx the parse tree
	 */
	void enterScalar_expression(JPQLSelectExpressionParser.Scalar_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#scalar_expression}.
	 * @param ctx the parse tree
	 */
	void exitScalar_expression(JPQLSelectExpressionParser.Scalar_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#outer_expression}.
	 * @param ctx the parse tree
	 */
	void enterOuter_expression(JPQLSelectExpressionParser.Outer_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#outer_expression}.
	 * @param ctx the parse tree
	 */
	void exitOuter_expression(JPQLSelectExpressionParser.Outer_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#macro_expression}.
	 * @param ctx the parse tree
	 */
	void enterMacro_expression(JPQLSelectExpressionParser.Macro_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#macro_expression}.
	 * @param ctx the parse tree
	 */
	void exitMacro_expression(JPQLSelectExpressionParser.Macro_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionTerm(JPQLSelectExpressionParser.ArithmeticExpressionTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionTerm(JPQLSelectExpressionParser.ArithmeticExpressionTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionPlusMinus}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionPlusMinus(JPQLSelectExpressionParser.ArithmeticExpressionPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionPlusMinus}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionPlusMinus(JPQLSelectExpressionParser.ArithmeticExpressionPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticTermFactor}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticTermFactor(JPQLSelectExpressionParser.ArithmeticTermFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticTermFactor}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticTermFactor(JPQLSelectExpressionParser.ArithmeticTermFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticMultDiv}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticMultDiv(JPQLSelectExpressionParser.ArithmeticMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticMultDiv}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticMultDiv(JPQLSelectExpressionParser.ArithmeticMultDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#arithmetic_factor}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_factor(JPQLSelectExpressionParser.Arithmetic_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#arithmetic_factor}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_factor(JPQLSelectExpressionParser.Arithmetic_factorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticPrimary(JPQLSelectExpressionParser.ArithmeticPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticPrimary(JPQLSelectExpressionParser.ArithmeticPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticPrimaryParanthesis}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticPrimaryParanthesis(JPQLSelectExpressionParser.ArithmeticPrimaryParanthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticPrimaryParanthesis}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticPrimaryParanthesis(JPQLSelectExpressionParser.ArithmeticPrimaryParanthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void enterString_expression(JPQLSelectExpressionParser.String_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void exitString_expression(JPQLSelectExpressionParser.String_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#datetime_expression}.
	 * @param ctx the parse tree
	 */
	void enterDatetime_expression(JPQLSelectExpressionParser.Datetime_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#datetime_expression}.
	 * @param ctx the parse tree
	 */
	void exitDatetime_expression(JPQLSelectExpressionParser.Datetime_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(JPQLSelectExpressionParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(JPQLSelectExpressionParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#enum_expression}.
	 * @param ctx the parse tree
	 */
	void enterEnum_expression(JPQLSelectExpressionParser.Enum_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#enum_expression}.
	 * @param ctx the parse tree
	 */
	void exitEnum_expression(JPQLSelectExpressionParser.Enum_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#entity_expression}.
	 * @param ctx the parse tree
	 */
	void enterEntity_expression(JPQLSelectExpressionParser.Entity_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#entity_expression}.
	 * @param ctx the parse tree
	 */
	void exitEntity_expression(JPQLSelectExpressionParser.Entity_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_entity_expression(JPQLSelectExpressionParser.Simple_entity_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_entity_expression(JPQLSelectExpressionParser.Simple_entity_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_expression}.
	 * @param ctx the parse tree
	 */
	void enterEntity_type_expression(JPQLSelectExpressionParser.Entity_type_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_expression}.
	 * @param ctx the parse tree
	 */
	void exitEntity_type_expression(JPQLSelectExpressionParser.Entity_type_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_or_literal_expression}.
	 * @param ctx the parse tree
	 */
	void enterEntity_type_or_literal_expression(JPQLSelectExpressionParser.Entity_type_or_literal_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_or_literal_expression}.
	 * @param ctx the parse tree
	 */
	void exitEntity_type_or_literal_expression(JPQLSelectExpressionParser.Entity_type_or_literal_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator}.
	 * @param ctx the parse tree
	 */
	void enterType_discriminator(JPQLSelectExpressionParser.Type_discriminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator}.
	 * @param ctx the parse tree
	 */
	void exitType_discriminator(JPQLSelectExpressionParser.Type_discriminatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator_arg}.
	 * @param ctx the parse tree
	 */
	void enterType_discriminator_arg(JPQLSelectExpressionParser.Type_discriminator_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator_arg}.
	 * @param ctx the parse tree
	 */
	void exitType_discriminator_arg(JPQLSelectExpressionParser.Type_discriminator_argContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Functions_returning_numerics_default}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_numerics_default(JPQLSelectExpressionParser.Functions_returning_numerics_defaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Functions_returning_numerics_default}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_numerics_default(JPQLSelectExpressionParser.Functions_returning_numerics_defaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Functions_returning_numerics_size}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_numerics_size(JPQLSelectExpressionParser.Functions_returning_numerics_sizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Functions_returning_numerics_size}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_numerics_size(JPQLSelectExpressionParser.Functions_returning_numerics_sizeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void enterIndexFunction(JPQLSelectExpressionParser.IndexFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 */
	void exitIndexFunction(JPQLSelectExpressionParser.IndexFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#functions_returning_datetime}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_returning_datetime(JPQLSelectExpressionParser.Functions_returning_datetimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#functions_returning_datetime}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_returning_datetime(JPQLSelectExpressionParser.Functions_returning_datetimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void enterStringFunction(JPQLSelectExpressionParser.StringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void exitStringFunction(JPQLSelectExpressionParser.StringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrimFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void enterTrimFunction(JPQLSelectExpressionParser.TrimFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrimFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 */
	void exitTrimFunction(JPQLSelectExpressionParser.TrimFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#trim_specification}.
	 * @param ctx the parse tree
	 */
	void enterTrim_specification(JPQLSelectExpressionParser.Trim_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#trim_specification}.
	 * @param ctx the parse tree
	 */
	void exitTrim_specification(JPQLSelectExpressionParser.Trim_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunction_invocation(JPQLSelectExpressionParser.Function_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#function_invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunction_invocation(JPQLSelectExpressionParser.Function_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#function_arg}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arg(JPQLSelectExpressionParser.Function_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#function_arg}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arg(JPQLSelectExpressionParser.Function_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void enterCase_expression(JPQLSelectExpressionParser.Case_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#case_expression}.
	 * @param ctx the parse tree
	 */
	void exitCase_expression(JPQLSelectExpressionParser.Case_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#coalesce_expression}.
	 * @param ctx the parse tree
	 */
	void enterCoalesce_expression(JPQLSelectExpressionParser.Coalesce_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#coalesce_expression}.
	 * @param ctx the parse tree
	 */
	void exitCoalesce_expression(JPQLSelectExpressionParser.Coalesce_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#nullif_expression}.
	 * @param ctx the parse tree
	 */
	void enterNullif_expression(JPQLSelectExpressionParser.Nullif_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#nullif_expression}.
	 * @param ctx the parse tree
	 */
	void exitNullif_expression(JPQLSelectExpressionParser.Nullif_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#null_literal}.
	 * @param ctx the parse tree
	 */
	void enterNull_literal(JPQLSelectExpressionParser.Null_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#null_literal}.
	 * @param ctx the parse tree
	 */
	void exitNull_literal(JPQLSelectExpressionParser.Null_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JPQLSelectExpressionParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JPQLSelectExpressionParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_literal}.
	 * @param ctx the parse tree
	 */
	void enterSimple_literal(JPQLSelectExpressionParser.Simple_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_literal}.
	 * @param ctx the parse tree
	 */
	void exitSimple_literal(JPQLSelectExpressionParser.Simple_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(JPQLSelectExpressionParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(JPQLSelectExpressionParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(JPQLSelectExpressionParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(JPQLSelectExpressionParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(JPQLSelectExpressionParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(JPQLSelectExpressionParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DateLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void enterDateLiteral(JPQLSelectExpressionParser.DateLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DateLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void exitDateLiteral(JPQLSelectExpressionParser.DateLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TimeLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimeLiteral(JPQLSelectExpressionParser.TimeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TimeLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimeLiteral(JPQLSelectExpressionParser.TimeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TimestampLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void enterTimestampLiteral(JPQLSelectExpressionParser.TimestampLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TimestampLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 */
	void exitTimestampLiteral(JPQLSelectExpressionParser.TimestampLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#trim_character}.
	 * @param ctx the parse tree
	 */
	void enterTrim_character(JPQLSelectExpressionParser.Trim_characterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#trim_character}.
	 * @param ctx the parse tree
	 */
	void exitTrim_character(JPQLSelectExpressionParser.Trim_characterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(JPQLSelectExpressionParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(JPQLSelectExpressionParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression_or}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_or(JPQLSelectExpressionParser.ConditionalExpression_orContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression_or}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_or(JPQLSelectExpressionParser.ConditionalExpression_orContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 */
	void enterConditionalTerm(JPQLSelectExpressionParser.ConditionalTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 */
	void exitConditionalTerm(JPQLSelectExpressionParser.ConditionalTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalTerm_and}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 */
	void enterConditionalTerm_and(JPQLSelectExpressionParser.ConditionalTerm_andContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalTerm_and}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 */
	void exitConditionalTerm_and(JPQLSelectExpressionParser.ConditionalTerm_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#conditional_factor}.
	 * @param ctx the parse tree
	 */
	void enterConditional_factor(JPQLSelectExpressionParser.Conditional_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#conditional_factor}.
	 * @param ctx the parse tree
	 */
	void exitConditional_factor(JPQLSelectExpressionParser.Conditional_factorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalPrimary_simple}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 */
	void enterConditionalPrimary_simple(JPQLSelectExpressionParser.ConditionalPrimary_simpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalPrimary_simple}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 */
	void exitConditionalPrimary_simple(JPQLSelectExpressionParser.ConditionalPrimary_simpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 */
	void enterConditionalPrimary(JPQLSelectExpressionParser.ConditionalPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 */
	void exitConditionalPrimary(JPQLSelectExpressionParser.ConditionalPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_cond_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_cond_expression(JPQLSelectExpressionParser.Simple_cond_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_cond_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_cond_expression(JPQLSelectExpressionParser.Simple_cond_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BetweenArithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void enterBetweenArithmetic(JPQLSelectExpressionParser.BetweenArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BetweenArithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void exitBetweenArithmetic(JPQLSelectExpressionParser.BetweenArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BetweenString}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void enterBetweenString(JPQLSelectExpressionParser.BetweenStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BetweenString}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void exitBetweenString(JPQLSelectExpressionParser.BetweenStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BetweenDatetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void enterBetweenDatetime(JPQLSelectExpressionParser.BetweenDatetimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BetweenDatetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 */
	void exitBetweenDatetime(JPQLSelectExpressionParser.BetweenDatetimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterIn_expression(JPQLSelectExpressionParser.In_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitIn_expression(JPQLSelectExpressionParser.In_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#in_item}.
	 * @param ctx the parse tree
	 */
	void enterIn_item(JPQLSelectExpressionParser.In_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#in_item}.
	 * @param ctx the parse tree
	 */
	void exitIn_item(JPQLSelectExpressionParser.In_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_in_item}.
	 * @param ctx the parse tree
	 */
	void enterSimple_in_item(JPQLSelectExpressionParser.Simple_in_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_in_item}.
	 * @param ctx the parse tree
	 */
	void exitSimple_in_item(JPQLSelectExpressionParser.Simple_in_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#like_expression}.
	 * @param ctx the parse tree
	 */
	void enterLike_expression(JPQLSelectExpressionParser.Like_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#like_expression}.
	 * @param ctx the parse tree
	 */
	void exitLike_expression(JPQLSelectExpressionParser.Like_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#pattern_value}.
	 * @param ctx the parse tree
	 */
	void enterPattern_value(JPQLSelectExpressionParser.Pattern_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#pattern_value}.
	 * @param ctx the parse tree
	 */
	void exitPattern_value(JPQLSelectExpressionParser.Pattern_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#escape_character}.
	 * @param ctx the parse tree
	 */
	void enterEscape_character(JPQLSelectExpressionParser.Escape_characterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#escape_character}.
	 * @param ctx the parse tree
	 */
	void exitEscape_character(JPQLSelectExpressionParser.Escape_characterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterNull_comparison_expression(JPQLSelectExpressionParser.Null_comparison_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitNull_comparison_expression(JPQLSelectExpressionParser.Null_comparison_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression_extension}.
	 * @param ctx the parse tree
	 */
	void enterNull_comparison_expression_extension(JPQLSelectExpressionParser.Null_comparison_expression_extensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression_extension}.
	 * @param ctx the parse tree
	 */
	void exitNull_comparison_expression_extension(JPQLSelectExpressionParser.Null_comparison_expression_extensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#empty_collection_comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_collection_comparison_expression(JPQLSelectExpressionParser.Empty_collection_comparison_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#empty_collection_comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_collection_comparison_expression(JPQLSelectExpressionParser.Empty_collection_comparison_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#collection_member_expression}.
	 * @param ctx the parse tree
	 */
	void enterCollection_member_expression(JPQLSelectExpressionParser.Collection_member_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#collection_member_expression}.
	 * @param ctx the parse tree
	 */
	void exitCollection_member_expression(JPQLSelectExpressionParser.Collection_member_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#exists_expression}.
	 * @param ctx the parse tree
	 */
	void enterExists_expression(JPQLSelectExpressionParser.Exists_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#exists_expression}.
	 * @param ctx the parse tree
	 */
	void exitExists_expression(JPQLSelectExpressionParser.Exists_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#entity_or_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterEntity_or_value_expression(JPQLSelectExpressionParser.Entity_or_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#entity_or_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitEntity_or_value_expression(JPQLSelectExpressionParser.Entity_or_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_or_value_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_entity_or_value_expression(JPQLSelectExpressionParser.Simple_entity_or_value_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_or_value_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_entity_or_value_expression(JPQLSelectExpressionParser.Simple_entity_or_value_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_string(JPQLSelectExpressionParser.ComparisonExpression_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_string(JPQLSelectExpressionParser.ComparisonExpression_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_string(JPQLSelectExpressionParser.QuantifiedComparisonExpression_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_string(JPQLSelectExpressionParser.QuantifiedComparisonExpression_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_boolean(JPQLSelectExpressionParser.ComparisonExpression_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_boolean(JPQLSelectExpressionParser.ComparisonExpression_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_boolean(JPQLSelectExpressionParser.QuantifiedComparisonExpression_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_boolean(JPQLSelectExpressionParser.QuantifiedComparisonExpression_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_enum}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_enum(JPQLSelectExpressionParser.ComparisonExpression_enumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_enum}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_enum(JPQLSelectExpressionParser.ComparisonExpression_enumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_datetime(JPQLSelectExpressionParser.QuantifiedComparisonExpression_datetimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_datetime(JPQLSelectExpressionParser.QuantifiedComparisonExpression_datetimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_datetime(JPQLSelectExpressionParser.ComparisonExpression_datetimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_datetime(JPQLSelectExpressionParser.ComparisonExpression_datetimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_entity(JPQLSelectExpressionParser.ComparisonExpression_entityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_entity(JPQLSelectExpressionParser.ComparisonExpression_entityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_entity(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_entity(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_arithmetic(JPQLSelectExpressionParser.ComparisonExpression_arithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_arithmetic(JPQLSelectExpressionParser.ComparisonExpression_arithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_arithmetic(JPQLSelectExpressionParser.QuantifiedComparisonExpression_arithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_arithmetic(JPQLSelectExpressionParser.QuantifiedComparisonExpression_arithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_entitytype(JPQLSelectExpressionParser.ComparisonExpression_entitytypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_entitytype(JPQLSelectExpressionParser.ComparisonExpression_entitytypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code QuantifiedComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedComparisonExpression_entitytype(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entitytypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code QuantifiedComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedComparisonExpression_entitytype(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entitytypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_path_type}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_path_type(JPQLSelectExpressionParser.ComparisonExpression_path_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_path_type}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_path_type(JPQLSelectExpressionParser.ComparisonExpression_path_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression_type_path}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression_type_path(JPQLSelectExpressionParser.ComparisonExpression_type_pathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression_type_path}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression_type_path(JPQLSelectExpressionParser.ComparisonExpression_type_pathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterEqPredicate(JPQLSelectExpressionParser.EqPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitEqPredicate(JPQLSelectExpressionParser.EqPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterNeqPredicate(JPQLSelectExpressionParser.NeqPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitNeqPredicate(JPQLSelectExpressionParser.NeqPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqOrNeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterEqOrNeqPredicate(JPQLSelectExpressionParser.EqOrNeqPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqOrNeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitEqOrNeqPredicate(JPQLSelectExpressionParser.EqOrNeqPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterGtPredicate(JPQLSelectExpressionParser.GtPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitGtPredicate(JPQLSelectExpressionParser.GtPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterGePredicate(JPQLSelectExpressionParser.GePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitGePredicate(JPQLSelectExpressionParser.GePredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterLtPredicate(JPQLSelectExpressionParser.LtPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitLtPredicate(JPQLSelectExpressionParser.LtPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void enterLePredicate(JPQLSelectExpressionParser.LePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 */
	void exitLePredicate(JPQLSelectExpressionParser.LePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#general_case_expression}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_case_expression(JPQLSelectExpressionParser.General_case_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#general_case_expression}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_case_expression(JPQLSelectExpressionParser.General_case_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#when_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhen_clause(JPQLSelectExpressionParser.When_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#when_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhen_clause(JPQLSelectExpressionParser.When_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_case_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_case_expression(JPQLSelectExpressionParser.Simple_case_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_case_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_case_expression(JPQLSelectExpressionParser.Simple_case_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#simple_when_clause}.
	 * @param ctx the parse tree
	 */
	void enterSimple_when_clause(JPQLSelectExpressionParser.Simple_when_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#simple_when_clause}.
	 * @param ctx the parse tree
	 */
	void exitSimple_when_clause(JPQLSelectExpressionParser.Simple_when_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#case_operand}.
	 * @param ctx the parse tree
	 */
	void enterCase_operand(JPQLSelectExpressionParser.Case_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#case_operand}.
	 * @param ctx the parse tree
	 */
	void exitCase_operand(JPQLSelectExpressionParser.Case_operandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(JPQLSelectExpressionParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(JPQLSelectExpressionParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JPQLSelectExpressionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JPQLSelectExpressionParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JPQLSelectExpressionParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JPQLSelectExpressionParser.IdentifierContext ctx);
}