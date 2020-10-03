// Generated from com/linkedin/pinot/pql/parsers/PQL2.g4 by ANTLR 4.3
package com.linkedin.pinot.pql.parsers;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PQL2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		AND=17, AS=18, ASC=19, BETWEEN=20, BY=21, DESC=22, FROM=23, GROUP=24, 
		HAVING=25, IN=26, IS=27, NULL=28, LIMIT=29, NOT=30, OR=31, REGEXP_LIKE=32, 
		ORDER=33, SELECT=34, TOP=35, WHERE=36, OPTION=37, WHITESPACE=38, LINE_COMMENT=39, 
		IDENTIFIER=40, STRING_LITERAL=41, INTEGER_LITERAL=42, FLOATING_POINT_LITERAL=43;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "'>='", "';'", "'<'", "'='", "'>'", "'<='", 
		"'<>'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "AND", "AS", 
		"ASC", "BETWEEN", "BY", "DESC", "FROM", "GROUP", "HAVING", "IN", "IS", 
		"NULL", "LIMIT", "NOT", "OR", "REGEXP_LIKE", "ORDER", "SELECT", "TOP", 
		"WHERE", "OPTION", "WHITESPACE", "LINE_COMMENT", "IDENTIFIER", "STRING_LITERAL", 
		"INTEGER_LITERAL", "FLOATING_POINT_LITERAL"
	};
	public static final int
		RULE_root = 0, RULE_statement = 1, RULE_selectStatement = 2, RULE_optionalClause = 3, 
		RULE_outputColumns = 4, RULE_outputColumnProjection = 5, RULE_expression = 6, 
		RULE_expressions = 7, RULE_binaryMathOperator = 8, RULE_function = 9, 
		RULE_tableName = 10, RULE_literal = 11, RULE_whereClause = 12, RULE_predicateList = 13, 
		RULE_predicate = 14, RULE_inClause = 15, RULE_isClause = 16, RULE_comparisonClause = 17, 
		RULE_comparisonOperator = 18, RULE_betweenClause = 19, RULE_regexpLikeClause = 20, 
		RULE_booleanOperator = 21, RULE_groupByClause = 22, RULE_groupByList = 23, 
		RULE_havingClause = 24, RULE_orderByClause = 25, RULE_orderByList = 26, 
		RULE_orderByExpression = 27, RULE_ordering = 28, RULE_topClause = 29, 
		RULE_limitClause = 30, RULE_optionListClause = 31, RULE_option = 32;
	public static final String[] ruleNames = {
		"root", "statement", "selectStatement", "optionalClause", "outputColumns", 
		"outputColumnProjection", "expression", "expressions", "binaryMathOperator", 
		"function", "tableName", "literal", "whereClause", "predicateList", "predicate", 
		"inClause", "isClause", "comparisonClause", "comparisonOperator", "betweenClause", 
		"regexpLikeClause", "booleanOperator", "groupByClause", "groupByList", 
		"havingClause", "orderByClause", "orderByList", "orderByExpression", "ordering", 
		"topClause", "limitClause", "optionListClause", "option"
	};

	@Override
	public String getGrammarFileName() { return "PQL2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PQL2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PQL2Parser.EOF, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); statement();
			setState(68);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(67); match(T__12);
				}
			}

			setState(70); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); selectStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
	 
		public SelectStatementContext() { }
		public void copyFrom(SelectStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectContext extends SelectStatementContext {
		public TopClauseContext topClause() {
			return getRuleContext(TopClauseContext.class,0);
		}
		public OutputColumnsContext outputColumns() {
			return getRuleContext(OutputColumnsContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<OptionalClauseContext> optionalClause() {
			return getRuleContexts(OptionalClauseContext.class);
		}
		public OptionalClauseContext optionalClause(int i) {
			return getRuleContext(OptionalClauseContext.class,i);
		}
		public TerminalNode FROM() { return getToken(PQL2Parser.FROM, 0); }
		public TerminalNode SELECT() { return getToken(PQL2Parser.SELECT, 0); }
		public SelectContext(SelectStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitSelect(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selectStatement);
		int _la;
		try {
			_localctx = new SelectContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(SELECT);
			setState(76);
			_la = _input.LA(1);
			if (_la==TOP) {
				{
				setState(75); topClause();
				}
			}

			setState(78); outputColumns();
			setState(79); match(FROM);
			setState(80); tableName();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GROUP) | (1L << HAVING) | (1L << LIMIT) | (1L << ORDER) | (1L << TOP) | (1L << WHERE) | (1L << OPTION))) != 0)) {
				{
				{
				setState(81); optionalClause();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionalClauseContext extends ParserRuleContext {
		public OptionalClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalClause; }
	 
		public OptionalClauseContext() { }
		public void copyFrom(OptionalClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrderByContext extends OptionalClauseContext {
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public OrderByContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOrderBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOrderBy(this);
		}
	}
	public static class OptionsContext extends OptionalClauseContext {
		public OptionListClauseContext optionListClause() {
			return getRuleContext(OptionListClauseContext.class,0);
		}
		public OptionsContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOptions(this);
		}
	}
	public static class GroupByContext extends OptionalClauseContext {
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public GroupByContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterGroupBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitGroupBy(this);
		}
	}
	public static class TopContext extends OptionalClauseContext {
		public TopClauseContext topClause() {
			return getRuleContext(TopClauseContext.class,0);
		}
		public TopContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitTop(this);
		}
	}
	public static class LimitContext extends OptionalClauseContext {
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public LimitContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitLimit(this);
		}
	}
	public static class WhereContext extends OptionalClauseContext {
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public WhereContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitWhere(this);
		}
	}
	public static class HavingContext extends OptionalClauseContext {
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public HavingContext(OptionalClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterHaving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitHaving(this);
		}
	}

	public final OptionalClauseContext optionalClause() throws RecognitionException {
		OptionalClauseContext _localctx = new OptionalClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_optionalClause);
		try {
			setState(94);
			switch (_input.LA(1)) {
			case WHERE:
				_localctx = new WhereContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87); whereClause();
				}
				break;
			case GROUP:
				_localctx = new GroupByContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88); groupByClause();
				}
				break;
			case HAVING:
				_localctx = new HavingContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89); havingClause();
				}
				break;
			case ORDER:
				_localctx = new OrderByContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(90); orderByClause();
				}
				break;
			case TOP:
				_localctx = new TopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(91); topClause();
				}
				break;
			case LIMIT:
				_localctx = new LimitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(92); limitClause();
				}
				break;
			case OPTION:
				_localctx = new OptionsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(93); optionListClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputColumnsContext extends ParserRuleContext {
		public OutputColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputColumns; }
	 
		public OutputColumnsContext() { }
		public void copyFrom(OutputColumnsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StarColumnListContext extends OutputColumnsContext {
		public StarColumnListContext(OutputColumnsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterStarColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitStarColumnList(this);
		}
	}
	public static class OutputColumnListContext extends OutputColumnsContext {
		public OutputColumnProjectionContext outputColumnProjection(int i) {
			return getRuleContext(OutputColumnProjectionContext.class,i);
		}
		public List<OutputColumnProjectionContext> outputColumnProjection() {
			return getRuleContexts(OutputColumnProjectionContext.class);
		}
		public OutputColumnListContext(OutputColumnsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOutputColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOutputColumnList(this);
		}
	}

	public final OutputColumnsContext outputColumns() throws RecognitionException {
		OutputColumnsContext _localctx = new OutputColumnsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_outputColumns);
		int _la;
		try {
			setState(105);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new StarColumnListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96); match(T__4);
				}
				break;
			case T__6:
			case IDENTIFIER:
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case FLOATING_POINT_LITERAL:
				_localctx = new OutputColumnListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97); outputColumnProjection();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(98); match(T__2);
					setState(99); outputColumnProjection();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputColumnProjectionContext extends ParserRuleContext {
		public OutputColumnProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputColumnProjection; }
	 
		public OutputColumnProjectionContext() { }
		public void copyFrom(OutputColumnProjectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OutputColumnContext extends OutputColumnProjectionContext {
		public TerminalNode STRING_LITERAL() { return getToken(PQL2Parser.STRING_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(PQL2Parser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(PQL2Parser.AS, 0); }
		public OutputColumnContext(OutputColumnProjectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOutputColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOutputColumn(this);
		}
	}

	public final OutputColumnProjectionContext outputColumnProjection() throws RecognitionException {
		OutputColumnProjectionContext _localctx = new OutputColumnProjectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_outputColumnProjection);
		int _la;
		try {
			_localctx = new OutputColumnContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(107); expression(0);
			setState(110);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(108); match(AS);
				setState(109);
				_la = _input.LA(1);
				if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionParenthesisGroupContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionParenthesisGroupContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterExpressionParenthesisGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitExpressionParenthesisGroup(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PQL2Parser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(PQL2Parser.IDENTIFIER); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitIdentifier(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitConstant(this);
		}
	}
	public static class BinaryMathOpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryMathOperatorContext binaryMathOperator() {
			return getRuleContext(BinaryMathOperatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BinaryMathOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterBinaryMathOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitBinaryMathOp(this);
		}
	}
	public static class FunctionCallContext extends ExpressionContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitFunctionCall(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(113); match(IDENTIFIER);
				}
				break;

			case 2:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(IDENTIFIER);
				setState(115); match(T__0);
				setState(116); match(IDENTIFIER);
				}
				break;

			case 3:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); literal();
				}
				break;

			case 4:
				{
				_localctx = new ExpressionParenthesisGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118); match(T__6);
				setState(119); expression(0);
				setState(120); match(T__5);
				}
				break;

			case 5:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122); function();
				setState(123); match(T__6);
				setState(125);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__4) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << INTEGER_LITERAL) | (1L << FLOATING_POINT_LITERAL))) != 0)) {
					{
					setState(124); expressions();
					}
				}

				setState(127); match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryMathOpContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(131);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(132); binaryMathOperator();
					setState(133); expression(2);
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	 
		public ExpressionsContext() { }
		public void copyFrom(ExpressionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StarExpressionContext extends ExpressionsContext {
		public StarExpressionContext(ExpressionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterStarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitStarExpression(this);
		}
	}
	public static class ExpressionListContext extends ExpressionsContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ExpressionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressions);
		int _la;
		try {
			setState(149);
			switch (_input.LA(1)) {
			case T__6:
			case IDENTIFIER:
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case FLOATING_POINT_LITERAL:
				_localctx = new ExpressionListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140); expression(0);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(141); match(T__2);
					setState(142); expression(0);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				_localctx = new StarExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryMathOperatorContext extends ParserRuleContext {
		public BinaryMathOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryMathOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterBinaryMathOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitBinaryMathOperator(this);
		}
	}

	public final BinaryMathOperatorContext binaryMathOperator() throws RecognitionException {
		BinaryMathOperatorContext _localctx = new BinaryMathOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binaryMathOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__4) | (1L << T__3) | (1L << T__1))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PQL2Parser.IDENTIFIER, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(PQL2Parser.IDENTIFIER, i);
		}
		public TerminalNode STRING_LITERAL() { return getToken(PQL2Parser.STRING_LITERAL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(PQL2Parser.IDENTIFIER); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableName);
		try {
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); match(IDENTIFIER);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); match(IDENTIFIER);
				setState(157); match(T__0);
				setState(158); match(IDENTIFIER);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159); match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode STRING_LITERAL() { return getToken(PQL2Parser.STRING_LITERAL, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitStringLiteral(this);
		}
	}
	public static class FloatingPointLiteralContext extends LiteralContext {
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(PQL2Parser.FLOATING_POINT_LITERAL, 0); }
		public FloatingPointLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterFloatingPointLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitFloatingPointLiteral(this);
		}
	}
	public static class IntegerLiteralContext extends LiteralContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(PQL2Parser.INTEGER_LITERAL, 0); }
		public IntegerLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitIntegerLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162); match(STRING_LITERAL);
				}
				break;
			case INTEGER_LITERAL:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(INTEGER_LITERAL);
				}
				break;
			case FLOATING_POINT_LITERAL:
				_localctx = new FloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164); match(FLOATING_POINT_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public PredicateListContext predicateList() {
			return getRuleContext(PredicateListContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(PQL2Parser.WHERE, 0); }
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); match(WHERE);
			setState(168); predicateList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateListContext extends ParserRuleContext {
		public BooleanOperatorContext booleanOperator(int i) {
			return getRuleContext(BooleanOperatorContext.class,i);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<BooleanOperatorContext> booleanOperator() {
			return getRuleContexts(BooleanOperatorContext.class);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterPredicateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitPredicateList(this);
		}
	}

	public final PredicateListContext predicateList() throws RecognitionException {
		PredicateListContext _localctx = new PredicateListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_predicateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); predicate();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(171); booleanOperator();
				setState(172); predicate();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IsPredicateContext extends PredicateContext {
		public IsClauseContext isClause() {
			return getRuleContext(IsClauseContext.class,0);
		}
		public IsPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterIsPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitIsPredicate(this);
		}
	}
	public static class PredicateParenthesisGroupContext extends PredicateContext {
		public PredicateListContext predicateList() {
			return getRuleContext(PredicateListContext.class,0);
		}
		public PredicateParenthesisGroupContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterPredicateParenthesisGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitPredicateParenthesisGroup(this);
		}
	}
	public static class RegexpLikePredicateContext extends PredicateContext {
		public RegexpLikeClauseContext regexpLikeClause() {
			return getRuleContext(RegexpLikeClauseContext.class,0);
		}
		public RegexpLikePredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterRegexpLikePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitRegexpLikePredicate(this);
		}
	}
	public static class BetweenPredicateContext extends PredicateContext {
		public BetweenClauseContext betweenClause() {
			return getRuleContext(BetweenClauseContext.class,0);
		}
		public BetweenPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterBetweenPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitBetweenPredicate(this);
		}
	}
	public static class InPredicateContext extends PredicateContext {
		public InClauseContext inClause() {
			return getRuleContext(InClauseContext.class,0);
		}
		public InPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterInPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitInPredicate(this);
		}
	}
	public static class ComparisonPredicateContext extends PredicateContext {
		public ComparisonClauseContext comparisonClause() {
			return getRuleContext(ComparisonClauseContext.class,0);
		}
		public ComparisonPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterComparisonPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitComparisonPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_predicate);
		try {
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new PredicateParenthesisGroupContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179); match(T__6);
				setState(180); predicateList();
				setState(181); match(T__5);
				}
				break;

			case 2:
				_localctx = new ComparisonPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183); comparisonClause();
				}
				break;

			case 3:
				_localctx = new InPredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184); inClause();
				}
				break;

			case 4:
				_localctx = new BetweenPredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(185); betweenClause();
				}
				break;

			case 5:
				_localctx = new IsPredicateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(186); isClause();
				}
				break;

			case 6:
				_localctx = new RegexpLikePredicateContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(187); regexpLikeClause();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InClauseContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PQL2Parser.NOT, 0); }
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IN() { return getToken(PQL2Parser.IN, 0); }
		public InClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterInClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitInClause(this);
		}
	}

	public final InClauseContext inClause() throws RecognitionException {
		InClauseContext _localctx = new InClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); expression(0);
			setState(192);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(191); match(NOT);
				}
			}

			setState(194); match(IN);
			setState(195); match(T__6);
			setState(196); literal();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(197); match(T__2);
				setState(198); literal();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IsClauseContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PQL2Parser.NOT, 0); }
		public TerminalNode IS() { return getToken(PQL2Parser.IS, 0); }
		public TerminalNode NULL() { return getToken(PQL2Parser.NULL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IsClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterIsClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitIsClause(this);
		}
	}

	public final IsClauseContext isClause() throws RecognitionException {
		IsClauseContext _localctx = new IsClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_isClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); expression(0);
			setState(207); match(IS);
			setState(209);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(208); match(NOT);
				}
			}

			setState(211); match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonClauseContext extends ParserRuleContext {
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ComparisonClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterComparisonClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitComparisonClause(this);
		}
	}

	public final ComparisonClauseContext comparisonClause() throws RecognitionException {
		ComparisonClauseContext _localctx = new ComparisonClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparisonClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); expression(0);
			setState(214); comparisonOperator();
			setState(215); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__13) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BetweenClauseContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(PQL2Parser.BETWEEN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PQL2Parser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BetweenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterBetweenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitBetweenClause(this);
		}
	}

	public final BetweenClauseContext betweenClause() throws RecognitionException {
		BetweenClauseContext _localctx = new BetweenClauseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_betweenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); expression(0);
			setState(220); match(BETWEEN);
			setState(221); expression(0);
			setState(222); match(AND);
			setState(223); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegexpLikeClauseContext extends ParserRuleContext {
		public TerminalNode REGEXP_LIKE() { return getToken(PQL2Parser.REGEXP_LIKE, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RegexpLikeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexpLikeClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterRegexpLikeClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitRegexpLikeClause(this);
		}
	}

	public final RegexpLikeClauseContext regexpLikeClause() throws RecognitionException {
		RegexpLikeClauseContext _localctx = new RegexpLikeClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_regexpLikeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); match(REGEXP_LIKE);
			setState(226); match(T__6);
			setState(227); expression(0);
			setState(228); match(T__2);
			setState(229); literal();
			setState(230); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(PQL2Parser.AND, 0); }
		public TerminalNode OR() { return getToken(PQL2Parser.OR, 0); }
		public BooleanOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterBooleanOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitBooleanOperator(this);
		}
	}

	public final BooleanOperatorContext booleanOperator() throws RecognitionException {
		BooleanOperatorContext _localctx = new BooleanOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_booleanOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(PQL2Parser.GROUP, 0); }
		public TerminalNode BY() { return getToken(PQL2Parser.BY, 0); }
		public GroupByListContext groupByList() {
			return getRuleContext(GroupByListContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitGroupByClause(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(GROUP);
			setState(235); match(BY);
			setState(236); groupByList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GroupByListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterGroupByList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitGroupByList(this);
		}
	}

	public final GroupByListContext groupByList() throws RecognitionException {
		GroupByListContext _localctx = new GroupByListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_groupByList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); expression(0);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(239); match(T__2);
				setState(240); expression(0);
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingClauseContext extends ParserRuleContext {
		public PredicateListContext predicateList() {
			return getRuleContext(PredicateListContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(PQL2Parser.HAVING, 0); }
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(HAVING);
			setState(247); predicateList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByClauseContext extends ParserRuleContext {
		public OrderByListContext orderByList() {
			return getRuleContext(OrderByListContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(PQL2Parser.ORDER, 0); }
		public TerminalNode BY() { return getToken(PQL2Parser.BY, 0); }
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOrderByClause(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_orderByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); match(ORDER);
			setState(250); match(BY);
			setState(251); orderByList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByListContext extends ParserRuleContext {
		public OrderByExpressionContext orderByExpression(int i) {
			return getRuleContext(OrderByExpressionContext.class,i);
		}
		public List<OrderByExpressionContext> orderByExpression() {
			return getRuleContexts(OrderByExpressionContext.class);
		}
		public OrderByListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOrderByList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOrderByList(this);
		}
	}

	public final OrderByListContext orderByList() throws RecognitionException {
		OrderByListContext _localctx = new OrderByListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_orderByList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); orderByExpression();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(254); match(T__2);
				setState(255); orderByExpression();
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByExpressionContext extends ParserRuleContext {
		public OrderingContext ordering() {
			return getRuleContext(OrderingContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OrderByExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOrderByExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOrderByExpression(this);
		}
	}

	public final OrderByExpressionContext orderByExpression() throws RecognitionException {
		OrderByExpressionContext _localctx = new OrderByExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orderByExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); expression(0);
			setState(263);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(262); ordering();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderingContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(PQL2Parser.ASC, 0); }
		public TerminalNode DESC() { return getToken(PQL2Parser.DESC, 0); }
		public OrderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOrdering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOrdering(this);
		}
	}

	public final OrderingContext ordering() throws RecognitionException {
		OrderingContext _localctx = new OrderingContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ordering);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopClauseContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(PQL2Parser.INTEGER_LITERAL, 0); }
		public TerminalNode TOP() { return getToken(PQL2Parser.TOP, 0); }
		public TopClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterTopClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitTopClause(this);
		}
	}

	public final TopClauseContext topClause() throws RecognitionException {
		TopClauseContext _localctx = new TopClauseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_topClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(TOP);
			setState(268); match(INTEGER_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER_LITERAL() { return getTokens(PQL2Parser.INTEGER_LITERAL); }
		public TerminalNode LIMIT() { return getToken(PQL2Parser.LIMIT, 0); }
		public TerminalNode INTEGER_LITERAL(int i) {
			return getToken(PQL2Parser.INTEGER_LITERAL, i);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_limitClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(LIMIT);
			setState(271); match(INTEGER_LITERAL);
			setState(274);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(272); match(T__2);
				setState(273); match(INTEGER_LITERAL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionListClauseContext extends ParserRuleContext {
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public TerminalNode OPTION() { return getToken(PQL2Parser.OPTION, 0); }
		public OptionListClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionListClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOptionListClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOptionListClause(this);
		}
	}

	public final OptionListClauseContext optionListClause() throws RecognitionException {
		OptionListClauseContext _localctx = new OptionListClauseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_optionListClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276); match(OPTION);
			setState(277); match(T__6);
			setState(278); option();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(279); match(T__2);
				setState(280); option();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(286); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PQL2Listener ) ((PQL2Listener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); expression(0);
			setState(291);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(289); match(T__10);
				setState(290); expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\5\2G\n\2\3\2\3\2\3\3\3\3\3\4\3\4\5\4O\n\4\3\4\3\4"+
		"\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5"+
		"\3\6\3\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\5\6l\n\6\3\7\3\7\3\7\5\7q\n\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0080\n\b\3\b"+
		"\3\b\5\b\u0084\n\b\3\b\3\b\3\b\3\b\7\b\u008a\n\b\f\b\16\b\u008d\13\b\3"+
		"\t\3\t\3\t\7\t\u0092\n\t\f\t\16\t\u0095\13\t\3\t\5\t\u0098\n\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f\3\r\3\r\3\r\5\r\u00a8\n\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u00b1\n\17\f\17\16\17\u00b4\13"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bf\n\20\3\21"+
		"\3\21\5\21\u00c3\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ca\n\21\f\21\16"+
		"\21\u00cd\13\21\3\21\3\21\3\22\3\22\3\22\5\22\u00d4\n\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31"+
		"\u00f4\n\31\f\31\16\31\u00f7\13\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\7\34\u0103\n\34\f\34\16\34\u0106\13\34\3\35\3\35\5\35"+
		"\u010a\n\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \5 \u0115\n \3!\3!\3!"+
		"\3!\3!\7!\u011c\n!\f!\16!\u011f\13!\3!\3!\3\"\3\"\3\"\5\"\u0126\n\"\3"+
		"\"\2\3\16#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@B\2\7\3\2*+\5\2\3\3\16\17\21\21\4\2\4\5\7\13\4\2\23\23!!\4\2\25\25"+
		"\30\30\u012d\2D\3\2\2\2\4J\3\2\2\2\6L\3\2\2\2\b`\3\2\2\2\nk\3\2\2\2\f"+
		"m\3\2\2\2\16\u0083\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2\2\2\24\u009b"+
		"\3\2\2\2\26\u00a2\3\2\2\2\30\u00a7\3\2\2\2\32\u00a9\3\2\2\2\34\u00ac\3"+
		"\2\2\2\36\u00be\3\2\2\2 \u00c0\3\2\2\2\"\u00d0\3\2\2\2$\u00d7\3\2\2\2"+
		"&\u00db\3\2\2\2(\u00dd\3\2\2\2*\u00e3\3\2\2\2,\u00ea\3\2\2\2.\u00ec\3"+
		"\2\2\2\60\u00f0\3\2\2\2\62\u00f8\3\2\2\2\64\u00fb\3\2\2\2\66\u00ff\3\2"+
		"\2\28\u0107\3\2\2\2:\u010b\3\2\2\2<\u010d\3\2\2\2>\u0110\3\2\2\2@\u0116"+
		"\3\2\2\2B\u0122\3\2\2\2DF\5\4\3\2EG\7\6\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2"+
		"\2\2HI\7\2\2\3I\3\3\2\2\2JK\5\6\4\2K\5\3\2\2\2LN\7$\2\2MO\5<\37\2NM\3"+
		"\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\5\n\6\2QR\7\31\2\2RV\5\26\f\2SU\5\b\5\2T"+
		"S\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\7\3\2\2\2XV\3\2\2\2Ya\5\32\16"+
		"\2Za\5.\30\2[a\5\62\32\2\\a\5\64\33\2]a\5<\37\2^a\5> \2_a\5@!\2`Y\3\2"+
		"\2\2`Z\3\2\2\2`[\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\t\3"+
		"\2\2\2bl\7\16\2\2ch\5\f\7\2de\7\20\2\2eg\5\f\7\2fd\3\2\2\2gj\3\2\2\2h"+
		"f\3\2\2\2hi\3\2\2\2il\3\2\2\2jh\3\2\2\2kb\3\2\2\2kc\3\2\2\2l\13\3\2\2"+
		"\2mp\5\16\b\2no\7\24\2\2oq\t\2\2\2pn\3\2\2\2pq\3\2\2\2q\r\3\2\2\2rs\b"+
		"\b\1\2s\u0084\7*\2\2tu\7*\2\2uv\7\22\2\2v\u0084\7*\2\2w\u0084\5\30\r\2"+
		"xy\7\f\2\2yz\5\16\b\2z{\7\r\2\2{\u0084\3\2\2\2|}\5\24\13\2}\177\7\f\2"+
		"\2~\u0080\5\20\t\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0082\7\r\2\2\u0082\u0084\3\2\2\2\u0083r\3\2\2\2\u0083t\3\2\2\2"+
		"\u0083w\3\2\2\2\u0083x\3\2\2\2\u0083|\3\2\2\2\u0084\u008b\3\2\2\2\u0085"+
		"\u0086\f\3\2\2\u0086\u0087\5\22\n\2\u0087\u0088\5\16\b\4\u0088\u008a\3"+
		"\2\2\2\u0089\u0085\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\17\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0093\5\16\b"+
		"\2\u008f\u0090\7\20\2\2\u0090\u0092\5\16\b\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0098\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u0098\7\16\2\2\u0097\u008e\3\2\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\21\3\2\2\2\u0099\u009a\t\3\2\2\u009a\23\3\2\2\2\u009b"+
		"\u009c\7*\2\2\u009c\25\3\2\2\2\u009d\u00a3\7*\2\2\u009e\u009f\7*\2\2\u009f"+
		"\u00a0\7\22\2\2\u00a0\u00a3\7*\2\2\u00a1\u00a3\7+\2\2\u00a2\u009d\3\2"+
		"\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\27\3\2\2\2\u00a4\u00a8"+
		"\7+\2\2\u00a5\u00a8\7,\2\2\u00a6\u00a8\7-\2\2\u00a7\u00a4\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\31\3\2\2\2\u00a9\u00aa\7&\2\2"+
		"\u00aa\u00ab\5\34\17\2\u00ab\33\3\2\2\2\u00ac\u00b2\5\36\20\2\u00ad\u00ae"+
		"\5,\27\2\u00ae\u00af\5\36\20\2\u00af\u00b1\3\2\2\2\u00b0\u00ad\3\2\2\2"+
		"\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\35"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\f\2\2\u00b6\u00b7\5\34\17\2"+
		"\u00b7\u00b8\7\r\2\2\u00b8\u00bf\3\2\2\2\u00b9\u00bf\5$\23\2\u00ba\u00bf"+
		"\5 \21\2\u00bb\u00bf\5(\25\2\u00bc\u00bf\5\"\22\2\u00bd\u00bf\5*\26\2"+
		"\u00be\u00b5\3\2\2\2\u00be\u00b9\3\2\2\2\u00be\u00ba\3\2\2\2\u00be\u00bb"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\37\3\2\2\2\u00c0"+
		"\u00c2\5\16\b\2\u00c1\u00c3\7 \2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\34\2\2\u00c5\u00c6\7\f\2\2\u00c6"+
		"\u00cb\5\30\r\2\u00c7\u00c8\7\20\2\2\u00c8\u00ca\5\30\r\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7\r\2\2\u00cf!\3\2\2\2"+
		"\u00d0\u00d1\5\16\b\2\u00d1\u00d3\7\35\2\2\u00d2\u00d4\7 \2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\36\2\2"+
		"\u00d6#\3\2\2\2\u00d7\u00d8\5\16\b\2\u00d8\u00d9\5&\24\2\u00d9\u00da\5"+
		"\16\b\2\u00da%\3\2\2\2\u00db\u00dc\t\4\2\2\u00dc\'\3\2\2\2\u00dd\u00de"+
		"\5\16\b\2\u00de\u00df\7\26\2\2\u00df\u00e0\5\16\b\2\u00e0\u00e1\7\23\2"+
		"\2\u00e1\u00e2\5\16\b\2\u00e2)\3\2\2\2\u00e3\u00e4\7\"\2\2\u00e4\u00e5"+
		"\7\f\2\2\u00e5\u00e6\5\16\b\2\u00e6\u00e7\7\20\2\2\u00e7\u00e8\5\30\r"+
		"\2\u00e8\u00e9\7\r\2\2\u00e9+\3\2\2\2\u00ea\u00eb\t\5\2\2\u00eb-\3\2\2"+
		"\2\u00ec\u00ed\7\32\2\2\u00ed\u00ee\7\27\2\2\u00ee\u00ef\5\60\31\2\u00ef"+
		"/\3\2\2\2\u00f0\u00f5\5\16\b\2\u00f1\u00f2\7\20\2\2\u00f2\u00f4\5\16\b"+
		"\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\61\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\33\2\2\u00f9"+
		"\u00fa\5\34\17\2\u00fa\63\3\2\2\2\u00fb\u00fc\7#\2\2\u00fc\u00fd\7\27"+
		"\2\2\u00fd\u00fe\5\66\34\2\u00fe\65\3\2\2\2\u00ff\u0104\58\35\2\u0100"+
		"\u0101\7\20\2\2\u0101\u0103\58\35\2\u0102\u0100\3\2\2\2\u0103\u0106\3"+
		"\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\67\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0109\5\16\b\2\u0108\u010a\5:\36\2\u0109\u0108\3"+
		"\2\2\2\u0109\u010a\3\2\2\2\u010a9\3\2\2\2\u010b\u010c\t\6\2\2\u010c;\3"+
		"\2\2\2\u010d\u010e\7%\2\2\u010e\u010f\7,\2\2\u010f=\3\2\2\2\u0110\u0111"+
		"\7\37\2\2\u0111\u0114\7,\2\2\u0112\u0113\7\20\2\2\u0113\u0115\7,\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115?\3\2\2\2\u0116\u0117\7\'\2\2"+
		"\u0117\u0118\7\f\2\2\u0118\u011d\5B\"\2\u0119\u011a\7\20\2\2\u011a\u011c"+
		"\5B\"\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7\r"+
		"\2\2\u0121A\3\2\2\2\u0122\u0125\5\16\b\2\u0123\u0124\7\b\2\2\u0124\u0126"+
		"\5\16\b\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126C\3\2\2\2\33FN"+
		"V`hkp\177\u0083\u008b\u0093\u0097\u00a2\u00a7\u00b2\u00be\u00c2\u00cb"+
		"\u00d3\u00f5\u0104\u0109\u0114\u011d\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}