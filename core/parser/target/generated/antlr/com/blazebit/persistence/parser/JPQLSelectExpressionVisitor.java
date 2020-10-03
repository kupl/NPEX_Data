// Generated from com/blazebit/persistence/parser/JPQLSelectExpression.g4 by ANTLR 4.6
package com.blazebit.persistence.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPQLSelectExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPQLSelectExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseOrderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseOrderByClause(JPQLSelectExpressionParser.ParseOrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parsePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsePath(JPQLSelectExpressionParser.ParsePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseJoinPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseJoinPath(JPQLSelectExpressionParser.ParseJoinPathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleJoinPathExpression(JPQLSelectExpressionParser.SimpleJoinPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtendedJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendedJoinPathExpression(JPQLSelectExpressionParser.ExtendedJoinPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleJoinElementExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleJoinElementExpression(JPQLSelectExpressionParser.SingleJoinElementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TreatJoinPathExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_association_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatJoinPathExpression(JPQLSelectExpressionParser.TreatJoinPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimplePath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePath(JPQLSelectExpressionParser.SimplePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TreatedRootPath}
	 * labeled alternative in {@link JPQLSelectExpressionParser#join_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreatedRootPath(JPQLSelectExpressionParser.TreatedRootPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#subtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtype(JPQLSelectExpressionParser.SubtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseSimpleExpression(JPQLSelectExpressionParser.ParseSimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseSimpleSubqueryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseSimpleSubqueryExpression(JPQLSelectExpressionParser.ParseSimpleSubqueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseScalarExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseScalarExpression(JPQLSelectExpressionParser.ParseScalarExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseArithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseArithmeticExpression(JPQLSelectExpressionParser.ParseArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseStringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseStringExpression(JPQLSelectExpressionParser.ParseStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseCaseOperandExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseCaseOperandExpression(JPQLSelectExpressionParser.ParseCaseOperandExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseInItemExpression(JPQLSelectExpressionParser.ParseInItemExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parseInItemOrPathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseInItemOrPathExpression(JPQLSelectExpressionParser.ParseInItemOrPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#parsePredicateExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsePredicateExpression(JPQLSelectExpressionParser.ParsePredicateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression(JPQLSelectExpressionParser.Simple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#key_value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey_value_expression(JPQLSelectExpressionParser.Key_value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#treated_key_value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreated_key_value_expression(JPQLSelectExpressionParser.Treated_key_value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EntryFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntryFunction(JPQLSelectExpressionParser.EntryFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeyValueExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#qualified_identification_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValueExpression(JPQLSelectExpressionParser.KeyValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_valued_path_expression(JPQLSelectExpressionParser.Single_valued_path_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#general_path_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_path_start(JPQLSelectExpressionParser.General_path_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_path_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_path_element(JPQLSelectExpressionParser.Simple_path_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#general_path_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_path_element(JPQLSelectExpressionParser.General_path_elementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpressionParameterIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionParameterIndex(JPQLSelectExpressionParser.ArrayExpressionParameterIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpressionPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionPathIndex(JPQLSelectExpressionParser.ArrayExpressionPathIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpressionSingleElementPathIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionSingleElementPathIndex(JPQLSelectExpressionParser.ArrayExpressionSingleElementPathIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpressionIntegerLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionIntegerLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionIntegerLiteralIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpressionStringLiteralIndex}
	 * labeled alternative in {@link JPQLSelectExpressionParser#array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionStringLiteralIndex(JPQLSelectExpressionParser.ArrayExpressionStringLiteralIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#general_subpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_subpath(JPQLSelectExpressionParser.General_subpathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_subpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_subpath(JPQLSelectExpressionParser.Simple_subpathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#treated_subpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTreated_subpath(JPQLSelectExpressionParser.Treated_subpathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#state_field_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_field_path_expression(JPQLSelectExpressionParser.State_field_path_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#single_valued_object_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_valued_object_path_expression(JPQLSelectExpressionParser.Single_valued_object_path_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(JPQLSelectExpressionParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#collection_valued_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection_valued_path_expression(JPQLSelectExpressionParser.Collection_valued_path_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#single_element_path_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_element_path_expression(JPQLSelectExpressionParser.Single_element_path_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AggregateExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateExpression(JPQLSelectExpressionParser.AggregateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CountStar}
	 * labeled alternative in {@link JPQLSelectExpressionParser#aggregate_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountStar(JPQLSelectExpressionParser.CountStarContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#aggregate_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregate_argument(JPQLSelectExpressionParser.Aggregate_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#scalar_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalar_expression(JPQLSelectExpressionParser.Scalar_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#outer_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuter_expression(JPQLSelectExpressionParser.Outer_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#macro_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_expression(JPQLSelectExpressionParser.Macro_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionTerm(JPQLSelectExpressionParser.ArithmeticExpressionTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionPlusMinus}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionPlusMinus(JPQLSelectExpressionParser.ArithmeticExpressionPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticTermFactor}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticTermFactor(JPQLSelectExpressionParser.ArithmeticTermFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticMultDiv}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticMultDiv(JPQLSelectExpressionParser.ArithmeticMultDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#arithmetic_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_factor(JPQLSelectExpressionParser.Arithmetic_factorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticPrimary(JPQLSelectExpressionParser.ArithmeticPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticPrimaryParanthesis}
	 * labeled alternative in {@link JPQLSelectExpressionParser#arithmetic_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticPrimaryParanthesis(JPQLSelectExpressionParser.ArithmeticPrimaryParanthesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#string_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_expression(JPQLSelectExpressionParser.String_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#datetime_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetime_expression(JPQLSelectExpressionParser.Datetime_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(JPQLSelectExpressionParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#enum_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_expression(JPQLSelectExpressionParser.Enum_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#entity_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_expression(JPQLSelectExpressionParser.Entity_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_entity_expression(JPQLSelectExpressionParser.Simple_entity_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_type_expression(JPQLSelectExpressionParser.Entity_type_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#entity_type_or_literal_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_type_or_literal_expression(JPQLSelectExpressionParser.Entity_type_or_literal_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_discriminator(JPQLSelectExpressionParser.Type_discriminatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#type_discriminator_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_discriminator_arg(JPQLSelectExpressionParser.Type_discriminator_argContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Functions_returning_numerics_default}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions_returning_numerics_default(JPQLSelectExpressionParser.Functions_returning_numerics_defaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Functions_returning_numerics_size}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions_returning_numerics_size(JPQLSelectExpressionParser.Functions_returning_numerics_sizeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_numerics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexFunction(JPQLSelectExpressionParser.IndexFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#functions_returning_datetime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions_returning_datetime(JPQLSelectExpressionParser.Functions_returning_datetimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFunction(JPQLSelectExpressionParser.StringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrimFunction}
	 * labeled alternative in {@link JPQLSelectExpressionParser#functions_returning_strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(JPQLSelectExpressionParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#trim_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrim_specification(JPQLSelectExpressionParser.Trim_specificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#function_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_invocation(JPQLSelectExpressionParser.Function_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#function_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_arg(JPQLSelectExpressionParser.Function_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#case_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_expression(JPQLSelectExpressionParser.Case_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#coalesce_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoalesce_expression(JPQLSelectExpressionParser.Coalesce_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#nullif_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullif_expression(JPQLSelectExpressionParser.Nullif_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#null_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_literal(JPQLSelectExpressionParser.Null_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JPQLSelectExpressionParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_literal(JPQLSelectExpressionParser.Simple_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_literal(JPQLSelectExpressionParser.Numeric_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(JPQLSelectExpressionParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(JPQLSelectExpressionParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DateLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateLiteral(JPQLSelectExpressionParser.DateLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TimeLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeLiteral(JPQLSelectExpressionParser.TimeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TimestampLiteral}
	 * labeled alternative in {@link JPQLSelectExpressionParser#temporal_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampLiteral(JPQLSelectExpressionParser.TimestampLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#trim_character}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrim_character(JPQLSelectExpressionParser.Trim_characterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(JPQLSelectExpressionParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression_or}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_or(JPQLSelectExpressionParser.ConditionalExpression_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalTerm}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalTerm(JPQLSelectExpressionParser.ConditionalTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalTerm_and}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalTerm_and(JPQLSelectExpressionParser.ConditionalTerm_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#conditional_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_factor(JPQLSelectExpressionParser.Conditional_factorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalPrimary_simple}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalPrimary_simple(JPQLSelectExpressionParser.ConditionalPrimary_simpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalPrimary}
	 * labeled alternative in {@link JPQLSelectExpressionParser#conditional_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalPrimary(JPQLSelectExpressionParser.ConditionalPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_cond_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_cond_expression(JPQLSelectExpressionParser.Simple_cond_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BetweenArithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenArithmetic(JPQLSelectExpressionParser.BetweenArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BetweenString}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenString(JPQLSelectExpressionParser.BetweenStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BetweenDatetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#between_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenDatetime(JPQLSelectExpressionParser.BetweenDatetimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_expression(JPQLSelectExpressionParser.In_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#in_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_item(JPQLSelectExpressionParser.In_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_in_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_in_item(JPQLSelectExpressionParser.Simple_in_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#like_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLike_expression(JPQLSelectExpressionParser.Like_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#pattern_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern_value(JPQLSelectExpressionParser.Pattern_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#escape_character}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscape_character(JPQLSelectExpressionParser.Escape_characterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_comparison_expression(JPQLSelectExpressionParser.Null_comparison_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#null_comparison_expression_extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_comparison_expression_extension(JPQLSelectExpressionParser.Null_comparison_expression_extensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#empty_collection_comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_collection_comparison_expression(JPQLSelectExpressionParser.Empty_collection_comparison_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#collection_member_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection_member_expression(JPQLSelectExpressionParser.Collection_member_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#exists_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExists_expression(JPQLSelectExpressionParser.Exists_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#entity_or_value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_or_value_expression(JPQLSelectExpressionParser.Entity_or_value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_entity_or_value_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_entity_or_value_expression(JPQLSelectExpressionParser.Simple_entity_or_value_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_string(JPQLSelectExpressionParser.ComparisonExpression_stringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_string}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_string(JPQLSelectExpressionParser.QuantifiedComparisonExpression_stringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_boolean(JPQLSelectExpressionParser.ComparisonExpression_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_boolean}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_boolean(JPQLSelectExpressionParser.QuantifiedComparisonExpression_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_enum}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_enum(JPQLSelectExpressionParser.ComparisonExpression_enumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_datetime(JPQLSelectExpressionParser.QuantifiedComparisonExpression_datetimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_datetime}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_datetime(JPQLSelectExpressionParser.ComparisonExpression_datetimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_entity(JPQLSelectExpressionParser.ComparisonExpression_entityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_entity}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_entity(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_arithmetic(JPQLSelectExpressionParser.ComparisonExpression_arithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_arithmetic}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_arithmetic(JPQLSelectExpressionParser.QuantifiedComparisonExpression_arithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_entitytype(JPQLSelectExpressionParser.ComparisonExpression_entitytypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuantifiedComparisonExpression_entitytype}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonExpression_entitytype(JPQLSelectExpressionParser.QuantifiedComparisonExpression_entitytypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_path_type}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_path_type(JPQLSelectExpressionParser.ComparisonExpression_path_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression_type_path}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression_type_path(JPQLSelectExpressionParser.ComparisonExpression_type_pathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqPredicate(JPQLSelectExpressionParser.EqPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#equality_comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqPredicate(JPQLSelectExpressionParser.NeqPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqOrNeqPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOrNeqPredicate(JPQLSelectExpressionParser.EqOrNeqPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtPredicate(JPQLSelectExpressionParser.GtPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGePredicate(JPQLSelectExpressionParser.GePredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LtPredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtPredicate(JPQLSelectExpressionParser.LtPredicateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LePredicate}
	 * labeled alternative in {@link JPQLSelectExpressionParser#comparison_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLePredicate(JPQLSelectExpressionParser.LePredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#general_case_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneral_case_expression(JPQLSelectExpressionParser.General_case_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#when_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen_clause(JPQLSelectExpressionParser.When_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_case_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_case_expression(JPQLSelectExpressionParser.Simple_case_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#simple_when_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_when_clause(JPQLSelectExpressionParser.Simple_when_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#case_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_operand(JPQLSelectExpressionParser.Case_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(JPQLSelectExpressionParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPQLSelectExpressionParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JPQLSelectExpressionParser.IdentifierContext ctx);
}