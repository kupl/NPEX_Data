// Generated from com/linkedin/pinot/pql/parsers/PQL2.g4 by ANTLR 4.3
package com.linkedin.pinot.pql.parsers;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PQL2Parser}.
 */
public interface PQL2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PQL2Parser#groupByList}.
	 * @param ctx the parse tree
	 */
	void enterGroupByList(@NotNull PQL2Parser.GroupByListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#groupByList}.
	 * @param ctx the parse tree
	 */
	void exitGroupByList(@NotNull PQL2Parser.GroupByListContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull PQL2Parser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull PQL2Parser.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PredicateParenthesisGroup}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicateParenthesisGroup(@NotNull PQL2Parser.PredicateParenthesisGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PredicateParenthesisGroup}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicateParenthesisGroup(@NotNull PQL2Parser.PredicateParenthesisGroupContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#isClause}.
	 * @param ctx the parse tree
	 */
	void enterIsClause(@NotNull PQL2Parser.IsClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#isClause}.
	 * @param ctx the parse tree
	 */
	void exitIsClause(@NotNull PQL2Parser.IsClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperator(@NotNull PQL2Parser.BooleanOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperator(@NotNull PQL2Parser.BooleanOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#comparisonClause}.
	 * @param ctx the parse tree
	 */
	void enterComparisonClause(@NotNull PQL2Parser.ComparisonClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#comparisonClause}.
	 * @param ctx the parse tree
	 */
	void exitComparisonClause(@NotNull PQL2Parser.ComparisonClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(@NotNull PQL2Parser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(@NotNull PQL2Parser.TableNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#optionListClause}.
	 * @param ctx the parse tree
	 */
	void enterOptionListClause(@NotNull PQL2Parser.OptionListClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#optionListClause}.
	 * @param ctx the parse tree
	 */
	void exitOptionListClause(@NotNull PQL2Parser.OptionListClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExpressionParenthesisGroup}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParenthesisGroup(@NotNull PQL2Parser.ExpressionParenthesisGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionParenthesisGroup}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParenthesisGroup(@NotNull PQL2Parser.ExpressionParenthesisGroupContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull PQL2Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull PQL2Parser.IdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#predicateList}.
	 * @param ctx the parse tree
	 */
	void enterPredicateList(@NotNull PQL2Parser.PredicateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#predicateList}.
	 * @param ctx the parse tree
	 */
	void exitPredicateList(@NotNull PQL2Parser.PredicateListContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StarExpression}
	 * labeled alternative in {@link PQL2Parser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterStarExpression(@NotNull PQL2Parser.StarExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StarExpression}
	 * labeled alternative in {@link PQL2Parser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitStarExpression(@NotNull PQL2Parser.StarExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull PQL2Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull PQL2Parser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(@NotNull PQL2Parser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(@NotNull PQL2Parser.GroupByClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StarColumnList}
	 * labeled alternative in {@link PQL2Parser#outputColumns}.
	 * @param ctx the parse tree
	 */
	void enterStarColumnList(@NotNull PQL2Parser.StarColumnListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StarColumnList}
	 * labeled alternative in {@link PQL2Parser#outputColumns}.
	 * @param ctx the parse tree
	 */
	void exitStarColumnList(@NotNull PQL2Parser.StarColumnListContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(@NotNull PQL2Parser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(@NotNull PQL2Parser.OrderByClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(@NotNull PQL2Parser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(@NotNull PQL2Parser.IntegerLiteralContext ctx);

	/**
	 * Enter a parse tree produced by the {@code GroupBy}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupBy(@NotNull PQL2Parser.GroupByContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupBy}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupBy(@NotNull PQL2Parser.GroupByContext ctx);

	/**
	 * Enter a parse tree produced by the {@code BetweenPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBetweenPredicate(@NotNull PQL2Parser.BetweenPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BetweenPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBetweenPredicate(@NotNull PQL2Parser.BetweenPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(@NotNull PQL2Parser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(@NotNull PQL2Parser.ComparisonOperatorContext ctx);

	/**
	 * Enter a parse tree produced by the {@code BinaryMathOp}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryMathOp(@NotNull PQL2Parser.BinaryMathOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryMathOp}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryMathOp(@NotNull PQL2Parser.BinaryMathOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code OutputColumnList}
	 * labeled alternative in {@link PQL2Parser#outputColumns}.
	 * @param ctx the parse tree
	 */
	void enterOutputColumnList(@NotNull PQL2Parser.OutputColumnListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OutputColumnList}
	 * labeled alternative in {@link PQL2Parser#outputColumns}.
	 * @param ctx the parse tree
	 */
	void exitOutputColumnList(@NotNull PQL2Parser.OutputColumnListContext ctx);

	/**
	 * Enter a parse tree produced by the {@code InPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterInPredicate(@NotNull PQL2Parser.InPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitInPredicate(@NotNull PQL2Parser.InPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#betweenClause}.
	 * @param ctx the parse tree
	 */
	void enterBetweenClause(@NotNull PQL2Parser.BetweenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#betweenClause}.
	 * @param ctx the parse tree
	 */
	void exitBetweenClause(@NotNull PQL2Parser.BetweenClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Having}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterHaving(@NotNull PQL2Parser.HavingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Having}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitHaving(@NotNull PQL2Parser.HavingContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Top}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterTop(@NotNull PQL2Parser.TopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Top}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitTop(@NotNull PQL2Parser.TopContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(@NotNull PQL2Parser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(@NotNull PQL2Parser.StringLiteralContext ctx);

	/**
	 * Enter a parse tree produced by the {@code OutputColumn}
	 * labeled alternative in {@link PQL2Parser#outputColumnProjection}.
	 * @param ctx the parse tree
	 */
	void enterOutputColumn(@NotNull PQL2Parser.OutputColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OutputColumn}
	 * labeled alternative in {@link PQL2Parser#outputColumnProjection}.
	 * @param ctx the parse tree
	 */
	void exitOutputColumn(@NotNull PQL2Parser.OutputColumnContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Where}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterWhere(@NotNull PQL2Parser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Where}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitWhere(@NotNull PQL2Parser.WhereContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(@NotNull PQL2Parser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(@NotNull PQL2Parser.OptionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IsPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterIsPredicate(@NotNull PQL2Parser.IsPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitIsPredicate(@NotNull PQL2Parser.IsPredicateContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Options}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterOptions(@NotNull PQL2Parser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Options}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitOptions(@NotNull PQL2Parser.OptionsContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#regexpLikeClause}.
	 * @param ctx the parse tree
	 */
	void enterRegexpLikeClause(@NotNull PQL2Parser.RegexpLikeClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#regexpLikeClause}.
	 * @param ctx the parse tree
	 */
	void exitRegexpLikeClause(@NotNull PQL2Parser.RegexpLikeClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull PQL2Parser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull PQL2Parser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#ordering}.
	 * @param ctx the parse tree
	 */
	void enterOrdering(@NotNull PQL2Parser.OrderingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#ordering}.
	 * @param ctx the parse tree
	 */
	void exitOrdering(@NotNull PQL2Parser.OrderingContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#inClause}.
	 * @param ctx the parse tree
	 */
	void enterInClause(@NotNull PQL2Parser.InClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#inClause}.
	 * @param ctx the parse tree
	 */
	void exitInClause(@NotNull PQL2Parser.InClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ComparisonPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterComparisonPredicate(@NotNull PQL2Parser.ComparisonPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonPredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitComparisonPredicate(@NotNull PQL2Parser.ComparisonPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull PQL2Parser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull PQL2Parser.RootContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull PQL2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull PQL2Parser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull PQL2Parser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link PQL2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull PQL2Parser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#binaryMathOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryMathOperator(@NotNull PQL2Parser.BinaryMathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#binaryMathOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryMathOperator(@NotNull PQL2Parser.BinaryMathOperatorContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExpressionList}
	 * labeled alternative in {@link PQL2Parser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull PQL2Parser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionList}
	 * labeled alternative in {@link PQL2Parser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull PQL2Parser.ExpressionListContext ctx);

	/**
	 * Enter a parse tree produced by the {@code OrderBy}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderBy(@NotNull PQL2Parser.OrderByContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrderBy}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderBy(@NotNull PQL2Parser.OrderByContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#orderByList}.
	 * @param ctx the parse tree
	 */
	void enterOrderByList(@NotNull PQL2Parser.OrderByListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#orderByList}.
	 * @param ctx the parse tree
	 */
	void exitOrderByList(@NotNull PQL2Parser.OrderByListContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpression(@NotNull PQL2Parser.OrderByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#orderByExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpression(@NotNull PQL2Parser.OrderByExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(@NotNull PQL2Parser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(@NotNull PQL2Parser.HavingClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RegexpLikePredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterRegexpLikePredicate(@NotNull PQL2Parser.RegexpLikePredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RegexpLikePredicate}
	 * labeled alternative in {@link PQL2Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitRegexpLikePredicate(@NotNull PQL2Parser.RegexpLikePredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(@NotNull PQL2Parser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(@NotNull PQL2Parser.LimitClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointLiteral(@NotNull PQL2Parser.FloatingPointLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link PQL2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointLiteral(@NotNull PQL2Parser.FloatingPointLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link PQL2Parser#topClause}.
	 * @param ctx the parse tree
	 */
	void enterTopClause(@NotNull PQL2Parser.TopClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PQL2Parser#topClause}.
	 * @param ctx the parse tree
	 */
	void exitTopClause(@NotNull PQL2Parser.TopClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Select}
	 * labeled alternative in {@link PQL2Parser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelect(@NotNull PQL2Parser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Select}
	 * labeled alternative in {@link PQL2Parser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelect(@NotNull PQL2Parser.SelectContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Limit}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void enterLimit(@NotNull PQL2Parser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Limit}
	 * labeled alternative in {@link PQL2Parser#optionalClause}.
	 * @param ctx the parse tree
	 */
	void exitLimit(@NotNull PQL2Parser.LimitContext ctx);
}