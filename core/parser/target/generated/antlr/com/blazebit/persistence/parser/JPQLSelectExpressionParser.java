// Generated from com/blazebit/persistence/parser/JPQLSelectExpression.g4 by ANTLR 4.6
package com.blazebit.persistence.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JPQLSelectExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, KEY=12, VALUE=13, ENTRY=14, AVG=15, SUM=16, MAX=17, 
		MIN=18, COUNT=19, DISTINCT=20, ENUM=21, ENTITY=22, TYPE=23, LENGTH=24, 
		LOCATE=25, ABS=26, SQRT=27, MOD=28, INDEX=29, CURRENT_DATE=30, CURRENT_TIME=31, 
		CURRENT_TIMESTAMP=32, CONCAT=33, SUBSTRING=34, TRIM=35, LOWER=36, UPPER=37, 
		FROM=38, LEADING=39, TRAILING=40, BOTH=41, FUNCTION=42, COALESCE=43, NULLIF=44, 
		NOT=45, OR=46, AND=47, BETWEEN=48, IN=49, LIKE=50, ESCAPE=51, IS=52, NULL=53, 
		CASE=54, ELSE=55, END=56, WHEN=57, THEN=58, SIZE=59, ALL=60, ANY=61, SOME=62, 
		EXISTS=63, EMPTY=64, MEMBER=65, OF=66, TREAT=67, AS=68, Outer_function=69, 
		Star_operator=70, Character_literal=71, String_literal=72, Input_parameter=73, 
		Date_literal=74, Time_literal=75, Timestamp_literal=76, Boolean_literal=77, 
		Not_equal_operator=78, Signum=79, BigInteger_literal=80, Long_literal=81, 
		Float_literal=82, Double_literal=83, BigDecimal_literal=84, Integer_literal=85, 
		Path_separator=86, WS=87, Identifier=88, MACRO=89;
	public static final int
		RULE_parseOrderByClause = 0, RULE_parsePath = 1, RULE_parseJoinPath = 2, 
		RULE_join_association_path_expression = 3, RULE_join_path_expression = 4, 
		RULE_subtype = 5, RULE_parseSimpleExpression = 6, RULE_parseSimpleSubqueryExpression = 7, 
		RULE_parseScalarExpression = 8, RULE_parseArithmeticExpression = 9, RULE_parseStringExpression = 10, 
		RULE_parseCaseOperandExpression = 11, RULE_parseInItemExpression = 12, 
		RULE_parseInItemOrPathExpression = 13, RULE_parsePredicateExpression = 14, 
		RULE_simple_expression = 15, RULE_key_value_expression = 16, RULE_treated_key_value_expression = 17, 
		RULE_qualified_identification_variable = 18, RULE_single_valued_path_expression = 19, 
		RULE_general_path_start = 20, RULE_simple_path_element = 21, RULE_general_path_element = 22, 
		RULE_array_expression = 23, RULE_general_subpath = 24, RULE_simple_subpath = 25, 
		RULE_treated_subpath = 26, RULE_state_field_path_expression = 27, RULE_single_valued_object_path_expression = 28, 
		RULE_path = 29, RULE_collection_valued_path_expression = 30, RULE_single_element_path_expression = 31, 
		RULE_aggregate_expression = 32, RULE_aggregate_argument = 33, RULE_scalar_expression = 34, 
		RULE_outer_expression = 35, RULE_macro_expression = 36, RULE_arithmetic_expression = 37, 
		RULE_arithmetic_term = 38, RULE_arithmetic_factor = 39, RULE_arithmetic_primary = 40, 
		RULE_string_expression = 41, RULE_datetime_expression = 42, RULE_boolean_expression = 43, 
		RULE_enum_expression = 44, RULE_entity_expression = 45, RULE_simple_entity_expression = 46, 
		RULE_entity_type_expression = 47, RULE_entity_type_or_literal_expression = 48, 
		RULE_type_discriminator = 49, RULE_type_discriminator_arg = 50, RULE_functions_returning_numerics = 51, 
		RULE_functions_returning_datetime = 52, RULE_functions_returning_strings = 53, 
		RULE_trim_specification = 54, RULE_function_invocation = 55, RULE_function_arg = 56, 
		RULE_case_expression = 57, RULE_coalesce_expression = 58, RULE_nullif_expression = 59, 
		RULE_null_literal = 60, RULE_literal = 61, RULE_simple_literal = 62, RULE_numeric_literal = 63, 
		RULE_string_literal = 64, RULE_boolean_literal = 65, RULE_temporal_literal = 66, 
		RULE_trim_character = 67, RULE_conditional_expression = 68, RULE_conditional_term = 69, 
		RULE_conditional_factor = 70, RULE_conditional_primary = 71, RULE_simple_cond_expression = 72, 
		RULE_between_expression = 73, RULE_in_expression = 74, RULE_in_item = 75, 
		RULE_simple_in_item = 76, RULE_like_expression = 77, RULE_pattern_value = 78, 
		RULE_escape_character = 79, RULE_null_comparison_expression = 80, RULE_null_comparison_expression_extension = 81, 
		RULE_empty_collection_comparison_expression = 82, RULE_collection_member_expression = 83, 
		RULE_exists_expression = 84, RULE_entity_or_value_expression = 85, RULE_simple_entity_or_value_expression = 86, 
		RULE_comparison_expression = 87, RULE_equality_comparison_operator = 88, 
		RULE_comparison_operator = 89, RULE_general_case_expression = 90, RULE_when_clause = 91, 
		RULE_simple_case_expression = 92, RULE_simple_when_clause = 93, RULE_case_operand = 94, 
		RULE_keyword = 95, RULE_identifier = 96;
	public static final String[] ruleNames = {
		"parseOrderByClause", "parsePath", "parseJoinPath", "join_association_path_expression", 
		"join_path_expression", "subtype", "parseSimpleExpression", "parseSimpleSubqueryExpression", 
		"parseScalarExpression", "parseArithmeticExpression", "parseStringExpression", 
		"parseCaseOperandExpression", "parseInItemExpression", "parseInItemOrPathExpression", 
		"parsePredicateExpression", "simple_expression", "key_value_expression", 
		"treated_key_value_expression", "qualified_identification_variable", "single_valued_path_expression", 
		"general_path_start", "simple_path_element", "general_path_element", "array_expression", 
		"general_subpath", "simple_subpath", "treated_subpath", "state_field_path_expression", 
		"single_valued_object_path_expression", "path", "collection_valued_path_expression", 
		"single_element_path_expression", "aggregate_expression", "aggregate_argument", 
		"scalar_expression", "outer_expression", "macro_expression", "arithmetic_expression", 
		"arithmetic_term", "arithmetic_factor", "arithmetic_primary", "string_expression", 
		"datetime_expression", "boolean_expression", "enum_expression", "entity_expression", 
		"simple_entity_expression", "entity_type_expression", "entity_type_or_literal_expression", 
		"type_discriminator", "type_discriminator_arg", "functions_returning_numerics", 
		"functions_returning_datetime", "functions_returning_strings", "trim_specification", 
		"function_invocation", "function_arg", "case_expression", "coalesce_expression", 
		"nullif_expression", "null_literal", "literal", "simple_literal", "numeric_literal", 
		"string_literal", "boolean_literal", "temporal_literal", "trim_character", 
		"conditional_expression", "conditional_term", "conditional_factor", "conditional_primary", 
		"simple_cond_expression", "between_expression", "in_expression", "in_item", 
		"simple_in_item", "like_expression", "pattern_value", "escape_character", 
		"null_comparison_expression", "null_comparison_expression_extension", 
		"empty_collection_comparison_expression", "collection_member_expression", 
		"exists_expression", "entity_or_value_expression", "simple_entity_or_value_expression", 
		"comparison_expression", "equality_comparison_operator", "comparison_operator", 
		"general_case_expression", "when_clause", "simple_case_expression", "simple_when_clause", 
		"case_operand", "keyword", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'['", "']'", "','", "'/'", "'='", "'>'", "'>='", 
		"'<'", "'<='", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'*'", null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"KEY", "VALUE", "ENTRY", "AVG", "SUM", "MAX", "MIN", "COUNT", "DISTINCT", 
		"ENUM", "ENTITY", "TYPE", "LENGTH", "LOCATE", "ABS", "SQRT", "MOD", "INDEX", 
		"CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CONCAT", "SUBSTRING", 
		"TRIM", "LOWER", "UPPER", "FROM", "LEADING", "TRAILING", "BOTH", "FUNCTION", 
		"COALESCE", "NULLIF", "NOT", "OR", "AND", "BETWEEN", "IN", "LIKE", "ESCAPE", 
		"IS", "NULL", "CASE", "ELSE", "END", "WHEN", "THEN", "SIZE", "ALL", "ANY", 
		"SOME", "EXISTS", "EMPTY", "MEMBER", "OF", "TREAT", "AS", "Outer_function", 
		"Star_operator", "Character_literal", "String_literal", "Input_parameter", 
		"Date_literal", "Time_literal", "Timestamp_literal", "Boolean_literal", 
		"Not_equal_operator", "Signum", "BigInteger_literal", "Long_literal", 
		"Float_literal", "Double_literal", "BigDecimal_literal", "Integer_literal", 
		"Path_separator", "WS", "Identifier", "MACRO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JPQLSelectExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private boolean allowOuter = false;
	private boolean allowCaseWhen = false;
	private boolean allowQuantifiedPredicates = false;
	private boolean allowTreatJoinExtension = false;
	public JPQLSelectExpressionParser(TokenStream input, boolean allowCaseWhen, boolean allowQuantifiedPredicates, boolean allowTreatJoinExtension){
	       this(input);
	       this.allowCaseWhen = allowCaseWhen;
	       this.allowQuantifiedPredicates = allowQuantifiedPredicates;
	       this.allowTreatJoinExtension = allowTreatJoinExtension;
	}


	public JPQLSelectExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseOrderByClauseContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JPQLSelectExpressionParser.EOF, 0); }
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Key_value_expressionContext key_value_expression() {
			return getRuleContext(Key_value_expressionContext.class,0);
		}
		public ParseOrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseOrderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseOrderByClauseContext parseOrderByClause() throws RecognitionException {
		ParseOrderByClauseContext _localctx = new ParseOrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parseOrderByClause);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				state_field_path_expression();
				setState(195);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				single_element_path_expression();
				setState(198);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				key_value_expression();
				setState(201);
				match(EOF);
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

	public static class ParsePathContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JPQLSelectExpressionParser.EOF, 0); }
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public ParsePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParsePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParsePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParsePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsePathContext parsePath() throws RecognitionException {
		ParsePathContext _localctx = new ParsePathContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parsePath);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				state_field_path_expression();
				setState(206);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				single_element_path_expression();
				setState(209);
				match(EOF);
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

	public static class ParseJoinPathContext extends ParserRuleContext {
		public Join_association_path_expressionContext join_association_path_expression() {
			return getRuleContext(Join_association_path_expressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JPQLSelectExpressionParser.EOF, 0); }
		public ParseJoinPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseJoinPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseJoinPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseJoinPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseJoinPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseJoinPathContext parseJoinPath() throws RecognitionException {
		ParseJoinPathContext _localctx = new ParseJoinPathContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parseJoinPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			join_association_path_expression();
			setState(214);
			match(EOF);
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

	public static class Join_association_path_expressionContext extends ParserRuleContext {
		public Join_association_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_association_path_expression; }
	 
		public Join_association_path_expressionContext() { }
		public void copyFrom(Join_association_path_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleJoinPathExpressionContext extends Join_association_path_expressionContext {
		public Simple_subpathContext simple_subpath() {
			return getRuleContext(Simple_subpathContext.class,0);
		}
		public General_path_elementContext general_path_element() {
			return getRuleContext(General_path_elementContext.class,0);
		}
		public SimpleJoinPathExpressionContext(Join_association_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimpleJoinPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimpleJoinPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimpleJoinPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtendedJoinPathExpressionContext extends Join_association_path_expressionContext {
		public Treated_subpathContext treated_subpath() {
			return getRuleContext(Treated_subpathContext.class,0);
		}
		public General_path_elementContext general_path_element() {
			return getRuleContext(General_path_elementContext.class,0);
		}
		public ExtendedJoinPathExpressionContext(Join_association_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterExtendedJoinPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitExtendedJoinPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitExtendedJoinPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleJoinElementExpressionContext extends Join_association_path_expressionContext {
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public SingleJoinElementExpressionContext(Join_association_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSingleJoinElementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSingleJoinElementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSingleJoinElementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TreatJoinPathExpressionContext extends Join_association_path_expressionContext {
		public TerminalNode TREAT() { return getToken(JPQLSelectExpressionParser.TREAT, 0); }
		public Join_path_expressionContext join_path_expression() {
			return getRuleContext(Join_path_expressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(JPQLSelectExpressionParser.AS, 0); }
		public SubtypeContext subtype() {
			return getRuleContext(SubtypeContext.class,0);
		}
		public TreatJoinPathExpressionContext(Join_association_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTreatJoinPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTreatJoinPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTreatJoinPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_association_path_expressionContext join_association_path_expression() throws RecognitionException {
		Join_association_path_expressionContext _localctx = new Join_association_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_join_association_path_expression);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SimpleJoinPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				simple_subpath();
				setState(217);
				match(Path_separator);
				setState(218);
				general_path_element();
				}
				break;
			case 2:
				_localctx = new ExtendedJoinPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				if (!(allowTreatJoinExtension == true)) throw new FailedPredicateException(this, "allowTreatJoinExtension == true");
				setState(221);
				treated_subpath();
				setState(222);
				match(Path_separator);
				setState(223);
				general_path_element();
				}
				break;
			case 3:
				_localctx = new SingleJoinElementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				single_element_path_expression();
				}
				break;
			case 4:
				_localctx = new TreatJoinPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(TREAT);
				setState(227);
				match(T__0);
				setState(228);
				join_path_expression();
				setState(229);
				match(AS);
				setState(230);
				subtype();
				setState(231);
				match(T__1);
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

	public static class Join_path_expressionContext extends ParserRuleContext {
		public Join_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_path_expression; }
	 
		public Join_path_expressionContext() { }
		public void copyFrom(Join_path_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TreatedRootPathContext extends Join_path_expressionContext {
		public TerminalNode TREAT() { return getToken(JPQLSelectExpressionParser.TREAT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(JPQLSelectExpressionParser.AS, 0); }
		public SubtypeContext subtype() {
			return getRuleContext(SubtypeContext.class,0);
		}
		public Simple_subpathContext simple_subpath() {
			return getRuleContext(Simple_subpathContext.class,0);
		}
		public TreatedRootPathContext(Join_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTreatedRootPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTreatedRootPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTreatedRootPath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimplePathContext extends Join_path_expressionContext {
		public Simple_subpathContext simple_subpath() {
			return getRuleContext(Simple_subpathContext.class,0);
		}
		public General_path_elementContext general_path_element() {
			return getRuleContext(General_path_elementContext.class,0);
		}
		public SimplePathContext(Join_path_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimplePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimplePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimplePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_path_expressionContext join_path_expression() throws RecognitionException {
		Join_path_expressionContext _localctx = new Join_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_join_path_expression);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new SimplePathContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				simple_subpath();
				setState(236);
				match(Path_separator);
				setState(237);
				general_path_element();
				}
				break;
			case 2:
				_localctx = new TreatedRootPathContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				if (!(allowTreatJoinExtension == true)) throw new FailedPredicateException(this, "allowTreatJoinExtension == true");
				setState(240);
				match(TREAT);
				setState(241);
				match(T__0);
				setState(242);
				identifier();
				setState(243);
				match(AS);
				setState(244);
				subtype();
				setState(245);
				match(T__1);
				setState(246);
				match(Path_separator);
				setState(247);
				simple_subpath();
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

	public static class SubtypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SubtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSubtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSubtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSubtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtypeContext subtype() throws RecognitionException {
		SubtypeContext _localctx = new SubtypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			identifier();
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

	public static class ParseSimpleExpressionContext extends ParserRuleContext {
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JPQLSelectExpressionParser.EOF, 0); }
		public ParseSimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseSimpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseSimpleExpressionContext parseSimpleExpression() throws RecognitionException {
		ParseSimpleExpressionContext _localctx = new ParseSimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parseSimpleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			simple_expression();
			setState(254);
			match(EOF);
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

	public static class ParseSimpleSubqueryExpressionContext extends ParserRuleContext {
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JPQLSelectExpressionParser.EOF, 0); }
		public ParseSimpleSubqueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseSimpleSubqueryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseSimpleSubqueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseSimpleSubqueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseSimpleSubqueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseSimpleSubqueryExpressionContext parseSimpleSubqueryExpression() throws RecognitionException {
		ParseSimpleSubqueryExpressionContext _localctx = new ParseSimpleSubqueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parseSimpleSubqueryExpression);

		      allowOuter = true;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			simple_expression();
			setState(257);
			match(EOF);
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

	public static class ParseScalarExpressionContext extends ParserRuleContext {
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public ParseScalarExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseScalarExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseScalarExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseScalarExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseScalarExpressionContext parseScalarExpression() throws RecognitionException {
		ParseScalarExpressionContext _localctx = new ParseScalarExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parseScalarExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			scalar_expression();
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

	public static class ParseArithmeticExpressionContext extends ParserRuleContext {
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public ParseArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseArithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseArithmeticExpressionContext parseArithmeticExpression() throws RecognitionException {
		ParseArithmeticExpressionContext _localctx = new ParseArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parseArithmeticExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			arithmetic_expression(0);
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

	public static class ParseStringExpressionContext extends ParserRuleContext {
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public ParseStringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseStringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseStringExpressionContext parseStringExpression() throws RecognitionException {
		ParseStringExpressionContext _localctx = new ParseStringExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parseStringExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			string_expression();
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

	public static class ParseCaseOperandExpressionContext extends ParserRuleContext {
		public Case_operandContext case_operand() {
			return getRuleContext(Case_operandContext.class,0);
		}
		public ParseCaseOperandExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseCaseOperandExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseCaseOperandExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseCaseOperandExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseCaseOperandExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseCaseOperandExpressionContext parseCaseOperandExpression() throws RecognitionException {
		ParseCaseOperandExpressionContext _localctx = new ParseCaseOperandExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parseCaseOperandExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			case_operand();
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

	public static class ParseInItemExpressionContext extends ParserRuleContext {
		public In_itemContext in_item() {
			return getRuleContext(In_itemContext.class,0);
		}
		public ParseInItemExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseInItemExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseInItemExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseInItemExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseInItemExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseInItemExpressionContext parseInItemExpression() throws RecognitionException {
		ParseInItemExpressionContext _localctx = new ParseInItemExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parseInItemExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			in_item();
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

	public static class ParseInItemOrPathExpressionContext extends ParserRuleContext {
		public Simple_in_itemContext simple_in_item() {
			return getRuleContext(Simple_in_itemContext.class,0);
		}
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public ParseInItemOrPathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseInItemOrPathExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParseInItemOrPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParseInItemOrPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParseInItemOrPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseInItemOrPathExpressionContext parseInItemOrPathExpression() throws RecognitionException {
		ParseInItemOrPathExpressionContext _localctx = new ParseInItemOrPathExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parseInItemOrPathExpression);
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				simple_in_item();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				state_field_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				single_element_path_expression();
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

	public static class ParsePredicateExpressionContext extends ParserRuleContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ParsePredicateExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsePredicateExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterParsePredicateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitParsePredicateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitParsePredicateExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsePredicateExpressionContext parsePredicateExpression() throws RecognitionException {
		ParsePredicateExpressionContext _localctx = new ParsePredicateExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parsePredicateExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			conditional_expression(0);
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

	public static class Simple_expressionContext extends ParserRuleContext {
		public Single_valued_path_expressionContext single_valued_path_expression() {
			return getRuleContext(Single_valued_path_expressionContext.class,0);
		}
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public Aggregate_expressionContext aggregate_expression() {
			return getRuleContext(Aggregate_expressionContext.class,0);
		}
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_simple_expression);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				single_valued_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				scalar_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				aggregate_expression();
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

	public static class Key_value_expressionContext extends ParserRuleContext {
		public Token name;
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public TerminalNode KEY() { return getToken(JPQLSelectExpressionParser.KEY, 0); }
		public TerminalNode VALUE() { return getToken(JPQLSelectExpressionParser.VALUE, 0); }
		public Key_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterKey_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitKey_value_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitKey_value_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Key_value_expressionContext key_value_expression() throws RecognitionException {
		Key_value_expressionContext _localctx = new Key_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_key_value_expression);
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				((Key_value_expressionContext)_localctx).name = match(KEY);
				setState(282);
				match(T__0);
				setState(283);
				collection_valued_path_expression();
				setState(284);
				match(T__1);
				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				((Key_value_expressionContext)_localctx).name = match(VALUE);
				setState(287);
				match(T__0);
				setState(288);
				collection_valued_path_expression();
				setState(289);
				match(T__1);
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

	public static class Treated_key_value_expressionContext extends ParserRuleContext {
		public TerminalNode TREAT() { return getToken(JPQLSelectExpressionParser.TREAT, 0); }
		public Key_value_expressionContext key_value_expression() {
			return getRuleContext(Key_value_expressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(JPQLSelectExpressionParser.AS, 0); }
		public SubtypeContext subtype() {
			return getRuleContext(SubtypeContext.class,0);
		}
		public Treated_key_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_treated_key_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTreated_key_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTreated_key_value_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTreated_key_value_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Treated_key_value_expressionContext treated_key_value_expression() throws RecognitionException {
		Treated_key_value_expressionContext _localctx = new Treated_key_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_treated_key_value_expression);
		try {
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__1:
			case T__4:
			case IS:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TREAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(TREAT);
				setState(295);
				match(T__0);
				setState(296);
				key_value_expression();
				setState(297);
				match(AS);
				setState(298);
				subtype();
				setState(299);
				match(T__1);
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

	public static class Qualified_identification_variableContext extends ParserRuleContext {
		public Qualified_identification_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_identification_variable; }
	 
		public Qualified_identification_variableContext() { }
		public void copyFrom(Qualified_identification_variableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntryFunctionContext extends Qualified_identification_variableContext {
		public Token name;
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public TerminalNode ENTRY() { return getToken(JPQLSelectExpressionParser.ENTRY, 0); }
		public EntryFunctionContext(Qualified_identification_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEntryFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEntryFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEntryFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KeyValueExpressionContext extends Qualified_identification_variableContext {
		public Key_value_expressionContext key_value_expression() {
			return getRuleContext(Key_value_expressionContext.class,0);
		}
		public KeyValueExpressionContext(Qualified_identification_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterKeyValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitKeyValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitKeyValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Qualified_identification_variableContext qualified_identification_variable() throws RecognitionException {
		Qualified_identification_variableContext _localctx = new Qualified_identification_variableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_qualified_identification_variable);
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTRY:
				_localctx = new EntryFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				((EntryFunctionContext)_localctx).name = match(ENTRY);
				setState(304);
				match(T__0);
				setState(305);
				collection_valued_path_expression();
				setState(306);
				match(T__1);
				}
				break;
			case KEY:
			case VALUE:
				_localctx = new KeyValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				key_value_expression();
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

	public static class Single_valued_path_expressionContext extends ParserRuleContext {
		public Qualified_identification_variableContext qualified_identification_variable() {
			return getRuleContext(Qualified_identification_variableContext.class,0);
		}
		public Treated_key_value_expressionContext treated_key_value_expression() {
			return getRuleContext(Treated_key_value_expressionContext.class,0);
		}
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Single_valued_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_valued_path_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSingle_valued_path_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSingle_valued_path_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSingle_valued_path_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_valued_path_expressionContext single_valued_path_expression() throws RecognitionException {
		Single_valued_path_expressionContext _localctx = new Single_valued_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_single_valued_path_expression);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				qualified_identification_variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				treated_key_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				state_field_path_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(314);
				single_element_path_expression();
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

	public static class General_path_startContext extends ParserRuleContext {
		public General_path_elementContext general_path_element() {
			return getRuleContext(General_path_elementContext.class,0);
		}
		public Key_value_expressionContext key_value_expression() {
			return getRuleContext(Key_value_expressionContext.class,0);
		}
		public General_path_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_path_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGeneral_path_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGeneral_path_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGeneral_path_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_path_startContext general_path_start() throws RecognitionException {
		General_path_startContext _localctx = new General_path_startContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_general_path_start);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				general_path_element();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				key_value_expression();
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

	public static class Simple_path_elementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Simple_path_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_path_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_path_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_path_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_path_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_path_elementContext simple_path_element() throws RecognitionException {
		Simple_path_elementContext _localctx = new Simple_path_elementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_path_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			identifier();
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

	public static class General_path_elementContext extends ParserRuleContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public Array_expressionContext array_expression() {
			return getRuleContext(Array_expressionContext.class,0);
		}
		public General_path_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_path_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGeneral_path_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGeneral_path_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGeneral_path_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_path_elementContext general_path_element() throws RecognitionException {
		General_path_elementContext _localctx = new General_path_elementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_general_path_element);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				simple_path_element();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				array_expression();
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

	public static class Array_expressionContext extends ParserRuleContext {
		public Array_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expression; }
	 
		public Array_expressionContext() { }
		public void copyFrom(Array_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayExpressionStringLiteralIndexContext extends Array_expressionContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public ArrayExpressionStringLiteralIndexContext(Array_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArrayExpressionStringLiteralIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArrayExpressionStringLiteralIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArrayExpressionStringLiteralIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpressionParameterIndexContext extends Array_expressionContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public ArrayExpressionParameterIndexContext(Array_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArrayExpressionParameterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArrayExpressionParameterIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArrayExpressionParameterIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpressionIntegerLiteralIndexContext extends Array_expressionContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public TerminalNode Integer_literal() { return getToken(JPQLSelectExpressionParser.Integer_literal, 0); }
		public ArrayExpressionIntegerLiteralIndexContext(Array_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArrayExpressionIntegerLiteralIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArrayExpressionIntegerLiteralIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArrayExpressionIntegerLiteralIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpressionPathIndexContext extends Array_expressionContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public ArrayExpressionPathIndexContext(Array_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArrayExpressionPathIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArrayExpressionPathIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArrayExpressionPathIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExpressionSingleElementPathIndexContext extends Array_expressionContext {
		public Simple_path_elementContext simple_path_element() {
			return getRuleContext(Simple_path_elementContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public ArrayExpressionSingleElementPathIndexContext(Array_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArrayExpressionSingleElementPathIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArrayExpressionSingleElementPathIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArrayExpressionSingleElementPathIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_expressionContext array_expression() throws RecognitionException {
		Array_expressionContext _localctx = new Array_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_array_expression);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ArrayExpressionParameterIndexContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				simple_path_element();
				setState(328);
				match(T__2);
				setState(329);
				match(Input_parameter);
				setState(330);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new ArrayExpressionPathIndexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				simple_path_element();
				setState(333);
				match(T__2);
				setState(334);
				state_field_path_expression();
				setState(335);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new ArrayExpressionSingleElementPathIndexContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(337);
				simple_path_element();
				setState(338);
				match(T__2);
				setState(339);
				single_element_path_expression();
				setState(340);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new ArrayExpressionIntegerLiteralIndexContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				simple_path_element();
				setState(343);
				match(T__2);
				setState(344);
				match(Integer_literal);
				setState(345);
				match(T__3);
				}
				break;
			case 5:
				_localctx = new ArrayExpressionStringLiteralIndexContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(347);
				simple_path_element();
				setState(348);
				match(T__2);
				setState(349);
				string_literal();
				setState(350);
				match(T__3);
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

	public static class General_subpathContext extends ParserRuleContext {
		public Simple_subpathContext simple_subpath() {
			return getRuleContext(Simple_subpathContext.class,0);
		}
		public Treated_subpathContext treated_subpath() {
			return getRuleContext(Treated_subpathContext.class,0);
		}
		public General_subpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_subpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGeneral_subpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGeneral_subpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGeneral_subpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_subpathContext general_subpath() throws RecognitionException {
		General_subpathContext _localctx = new General_subpathContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_general_subpath);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				simple_subpath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				treated_subpath();
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

	public static class Simple_subpathContext extends ParserRuleContext {
		public General_path_startContext general_path_start() {
			return getRuleContext(General_path_startContext.class,0);
		}
		public List<General_path_elementContext> general_path_element() {
			return getRuleContexts(General_path_elementContext.class);
		}
		public General_path_elementContext general_path_element(int i) {
			return getRuleContext(General_path_elementContext.class,i);
		}
		public Simple_subpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_subpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_subpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_subpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_subpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_subpathContext simple_subpath() throws RecognitionException {
		Simple_subpathContext _localctx = new Simple_subpathContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_simple_subpath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			general_path_start();
			setState(363);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(359);
					match(Path_separator);
					setState(360);
					general_path_element();
					}
					} 
				}
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Treated_subpathContext extends ParserRuleContext {
		public TerminalNode TREAT() { return getToken(JPQLSelectExpressionParser.TREAT, 0); }
		public General_subpathContext general_subpath() {
			return getRuleContext(General_subpathContext.class,0);
		}
		public TerminalNode AS() { return getToken(JPQLSelectExpressionParser.AS, 0); }
		public SubtypeContext subtype() {
			return getRuleContext(SubtypeContext.class,0);
		}
		public List<General_path_elementContext> general_path_element() {
			return getRuleContexts(General_path_elementContext.class);
		}
		public General_path_elementContext general_path_element(int i) {
			return getRuleContext(General_path_elementContext.class,i);
		}
		public Treated_subpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_treated_subpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTreated_subpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTreated_subpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTreated_subpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Treated_subpathContext treated_subpath() throws RecognitionException {
		Treated_subpathContext _localctx = new Treated_subpathContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_treated_subpath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(TREAT);
			setState(367);
			match(T__0);
			setState(368);
			general_subpath();
			setState(369);
			match(AS);
			setState(370);
			subtype();
			setState(371);
			match(T__1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(372);
					match(Path_separator);
					setState(373);
					general_path_element();
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class State_field_path_expressionContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Outer_expressionContext outer_expression() {
			return getRuleContext(Outer_expressionContext.class,0);
		}
		public Macro_expressionContext macro_expression() {
			return getRuleContext(Macro_expressionContext.class,0);
		}
		public State_field_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_field_path_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterState_field_path_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitState_field_path_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitState_field_path_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_field_path_expressionContext state_field_path_expression() throws RecognitionException {
		State_field_path_expressionContext _localctx = new State_field_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_state_field_path_expression);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				if (!(allowOuter == true)) throw new FailedPredicateException(this, "allowOuter == true");
				setState(381);
				outer_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(382);
				macro_expression();
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

	public static class Single_valued_object_path_expressionContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Outer_expressionContext outer_expression() {
			return getRuleContext(Outer_expressionContext.class,0);
		}
		public Single_valued_object_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_valued_object_path_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSingle_valued_object_path_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSingle_valued_object_path_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSingle_valued_object_path_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_valued_object_path_expressionContext single_valued_object_path_expression() throws RecognitionException {
		Single_valued_object_path_expressionContext _localctx = new Single_valued_object_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_single_valued_object_path_expression);
		try {
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				if (!(allowOuter == true)) throw new FailedPredicateException(this, "allowOuter == true");
				setState(387);
				outer_expression();
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

	public static class PathContext extends ParserRuleContext {
		public General_subpathContext general_subpath() {
			return getRuleContext(General_subpathContext.class,0);
		}
		public General_path_elementContext general_path_element() {
			return getRuleContext(General_path_elementContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			general_subpath();
			setState(391);
			match(Path_separator);
			setState(392);
			general_path_element();
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

	public static class Collection_valued_path_expressionContext extends ParserRuleContext {
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Collection_valued_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection_valued_path_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCollection_valued_path_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCollection_valued_path_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCollection_valued_path_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Collection_valued_path_expressionContext collection_valued_path_expression() throws RecognitionException {
		Collection_valued_path_expressionContext _localctx = new Collection_valued_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_collection_valued_path_expression);
		try {
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				single_element_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				path();
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

	public static class Single_element_path_expressionContext extends ParserRuleContext {
		public General_path_startContext general_path_start() {
			return getRuleContext(General_path_startContext.class,0);
		}
		public Single_element_path_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_element_path_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSingle_element_path_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSingle_element_path_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSingle_element_path_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_element_path_expressionContext single_element_path_expression() throws RecognitionException {
		Single_element_path_expressionContext _localctx = new Single_element_path_expressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_single_element_path_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			general_path_start();
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

	public static class Aggregate_expressionContext extends ParserRuleContext {
		public Aggregate_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_expression; }
	 
		public Aggregate_expressionContext() { }
		public void copyFrom(Aggregate_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CountStarContext extends Aggregate_expressionContext {
		public Token funcname;
		public TerminalNode Star_operator() { return getToken(JPQLSelectExpressionParser.Star_operator, 0); }
		public TerminalNode COUNT() { return getToken(JPQLSelectExpressionParser.COUNT, 0); }
		public CountStarContext(Aggregate_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCountStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCountStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCountStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggregateExpressionContext extends Aggregate_expressionContext {
		public Token funcname;
		public Token distinct;
		public Aggregate_argumentContext aggregate_argument() {
			return getRuleContext(Aggregate_argumentContext.class,0);
		}
		public TerminalNode AVG() { return getToken(JPQLSelectExpressionParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(JPQLSelectExpressionParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(JPQLSelectExpressionParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(JPQLSelectExpressionParser.SUM, 0); }
		public TerminalNode COUNT() { return getToken(JPQLSelectExpressionParser.COUNT, 0); }
		public TerminalNode DISTINCT() { return getToken(JPQLSelectExpressionParser.DISTINCT, 0); }
		public AggregateExpressionContext(Aggregate_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterAggregateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitAggregateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitAggregateExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aggregate_expressionContext aggregate_expression() throws RecognitionException {
		Aggregate_expressionContext _localctx = new Aggregate_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_aggregate_expression);
		int _la;
		try {
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new AggregateExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				((AggregateExpressionContext)_localctx).funcname = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AVG) | (1L << SUM) | (1L << MAX) | (1L << MIN) | (1L << COUNT))) != 0)) ) {
					((AggregateExpressionContext)_localctx).funcname = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(401);
				match(T__0);
				setState(403);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(402);
					((AggregateExpressionContext)_localctx).distinct = match(DISTINCT);
					}
					break;
				}
				setState(405);
				aggregate_argument();
				setState(406);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new CountStarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				((CountStarContext)_localctx).funcname = match(COUNT);
				setState(409);
				match(T__0);
				setState(410);
				match(Star_operator);
				setState(411);
				match(T__1);
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

	public static class Aggregate_argumentContext extends ParserRuleContext {
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public Aggregate_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterAggregate_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitAggregate_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitAggregate_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aggregate_argumentContext aggregate_argument() throws RecognitionException {
		Aggregate_argumentContext _localctx = new Aggregate_argumentContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_aggregate_argument);
		try {
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				single_element_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				path();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
				scalar_expression();
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

	public static class Scalar_expressionContext extends ParserRuleContext {
		public Null_literalContext null_literal() {
			return getRuleContext(Null_literalContext.class,0);
		}
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public Enum_expressionContext enum_expression() {
			return getRuleContext(Enum_expressionContext.class,0);
		}
		public Datetime_expressionContext datetime_expression() {
			return getRuleContext(Datetime_expressionContext.class,0);
		}
		public Boolean_expressionContext boolean_expression() {
			return getRuleContext(Boolean_expressionContext.class,0);
		}
		public Entity_type_expressionContext entity_type_expression() {
			return getRuleContext(Entity_type_expressionContext.class,0);
		}
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Scalar_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterScalar_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitScalar_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitScalar_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_expressionContext scalar_expression() throws RecognitionException {
		Scalar_expressionContext _localctx = new Scalar_expressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_scalar_expression);
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				null_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				arithmetic_expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(421);
				string_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				enum_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(423);
				datetime_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				boolean_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(425);
				entity_type_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(426);
				case_expression();
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

	public static class Outer_expressionContext extends ParserRuleContext {
		public TerminalNode Outer_function() { return getToken(JPQLSelectExpressionParser.Outer_function, 0); }
		public Single_valued_path_expressionContext single_valued_path_expression() {
			return getRuleContext(Single_valued_path_expressionContext.class,0);
		}
		public Outer_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterOuter_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitOuter_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitOuter_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outer_expressionContext outer_expression() throws RecognitionException {
		Outer_expressionContext _localctx = new Outer_expressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_outer_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(Outer_function);
			setState(430);
			match(T__0);
			setState(431);
			single_valued_path_expression();
			setState(432);
			match(T__1);
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

	public static class Macro_expressionContext extends ParserRuleContext {
		public Token macroName;
		public TerminalNode Identifier() { return getToken(JPQLSelectExpressionParser.Identifier, 0); }
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public Macro_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterMacro_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitMacro_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitMacro_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_expressionContext macro_expression() throws RecognitionException {
		Macro_expressionContext _localctx = new Macro_expressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_macro_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			((Macro_expressionContext)_localctx).macroName = match(Identifier);
			setState(435);
			match(T__0);
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(436);
				simple_expression();
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(437);
					match(T__4);
					setState(438);
					simple_expression();
					}
					}
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(446);
			match(T__1);
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

	public static class Arithmetic_expressionContext extends ParserRuleContext {
		public Arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression; }
	 
		public Arithmetic_expressionContext() { }
		public void copyFrom(Arithmetic_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticExpressionTermContext extends Arithmetic_expressionContext {
		public Arithmetic_termContext arithmetic_term() {
			return getRuleContext(Arithmetic_termContext.class,0);
		}
		public ArithmeticExpressionTermContext(Arithmetic_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticExpressionTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticExpressionTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticExpressionTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionPlusMinusContext extends Arithmetic_expressionContext {
		public Token op;
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public Arithmetic_termContext arithmetic_term() {
			return getRuleContext(Arithmetic_termContext.class,0);
		}
		public TerminalNode Signum() { return getToken(JPQLSelectExpressionParser.Signum, 0); }
		public ArithmeticExpressionPlusMinusContext(Arithmetic_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticExpressionPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticExpressionPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticExpressionPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_expressionContext arithmetic_expression() throws RecognitionException {
		return arithmetic_expression(0);
	}

	private Arithmetic_expressionContext arithmetic_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_expressionContext _localctx = new Arithmetic_expressionContext(_ctx, _parentState);
		Arithmetic_expressionContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_arithmetic_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArithmeticExpressionTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(449);
			arithmetic_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithmeticExpressionPlusMinusContext(new Arithmetic_expressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expression);
					setState(451);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(452);
					((ArithmeticExpressionPlusMinusContext)_localctx).op = match(Signum);
					setState(453);
					arithmetic_term(0);
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class Arithmetic_termContext extends ParserRuleContext {
		public Arithmetic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_term; }
	 
		public Arithmetic_termContext() { }
		public void copyFrom(Arithmetic_termContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticTermFactorContext extends Arithmetic_termContext {
		public Arithmetic_factorContext arithmetic_factor() {
			return getRuleContext(Arithmetic_factorContext.class,0);
		}
		public ArithmeticTermFactorContext(Arithmetic_termContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticTermFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticTermFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticTermFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticMultDivContext extends Arithmetic_termContext {
		public Arithmetic_termContext term;
		public Token op;
		public Arithmetic_factorContext factor;
		public Arithmetic_termContext arithmetic_term() {
			return getRuleContext(Arithmetic_termContext.class,0);
		}
		public Arithmetic_factorContext arithmetic_factor() {
			return getRuleContext(Arithmetic_factorContext.class,0);
		}
		public ArithmeticMultDivContext(Arithmetic_termContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_termContext arithmetic_term() throws RecognitionException {
		return arithmetic_term(0);
	}

	private Arithmetic_termContext arithmetic_term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_termContext _localctx = new Arithmetic_termContext(_ctx, _parentState);
		Arithmetic_termContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_arithmetic_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArithmeticTermFactorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(460);
			arithmetic_factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithmeticMultDivContext(new Arithmetic_termContext(_parentctx, _parentState));
					((ArithmeticMultDivContext)_localctx).term = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_term);
					setState(462);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(463);
					((ArithmeticMultDivContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==Star_operator) ) {
						((ArithmeticMultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(464);
					((ArithmeticMultDivContext)_localctx).factor = arithmetic_factor();
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class Arithmetic_factorContext extends ParserRuleContext {
		public Token signum;
		public Arithmetic_primaryContext arithmetic_primary() {
			return getRuleContext(Arithmetic_primaryContext.class,0);
		}
		public TerminalNode Signum() { return getToken(JPQLSelectExpressionParser.Signum, 0); }
		public Arithmetic_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmetic_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmetic_factor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmetic_factor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_factorContext arithmetic_factor() throws RecognitionException {
		Arithmetic_factorContext _localctx = new Arithmetic_factorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arithmetic_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(470);
				((Arithmetic_factorContext)_localctx).signum = match(Signum);
				}
				break;
			}
			setState(473);
			arithmetic_primary();
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

	public static class Arithmetic_primaryContext extends ParserRuleContext {
		public Arithmetic_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_primary; }
	 
		public Arithmetic_primaryContext() { }
		public void copyFrom(Arithmetic_primaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticPrimaryContext extends Arithmetic_primaryContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Functions_returning_numericsContext functions_returning_numerics() {
			return getRuleContext(Functions_returning_numericsContext.class,0);
		}
		public Aggregate_expressionContext aggregate_expression() {
			return getRuleContext(Aggregate_expressionContext.class,0);
		}
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public ArithmeticPrimaryContext(Arithmetic_primaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticPrimaryParanthesisContext extends Arithmetic_primaryContext {
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public ArithmeticPrimaryParanthesisContext(Arithmetic_primaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterArithmeticPrimaryParanthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitArithmeticPrimaryParanthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitArithmeticPrimaryParanthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_primaryContext arithmetic_primary() throws RecognitionException {
		Arithmetic_primaryContext _localctx = new Arithmetic_primaryContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arithmetic_primary);
		try {
			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				state_field_path_expression();
				}
				break;
			case 2:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				single_element_path_expression();
				}
				break;
			case 3:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				numeric_literal();
				}
				break;
			case 4:
				_localctx = new ArithmeticPrimaryParanthesisContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(478);
				match(T__0);
				setState(479);
				arithmetic_expression(0);
				setState(480);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(482);
				match(Input_parameter);
				}
				break;
			case 6:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(483);
				functions_returning_numerics();
				}
				break;
			case 7:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(484);
				aggregate_expression();
				}
				break;
			case 8:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(485);
				case_expression();
				}
				break;
			case 9:
				_localctx = new ArithmeticPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(486);
				function_invocation();
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

	public static class String_expressionContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Functions_returning_stringsContext functions_returning_strings() {
			return getRuleContext(Functions_returning_stringsContext.class,0);
		}
		public Aggregate_expressionContext aggregate_expression() {
			return getRuleContext(Aggregate_expressionContext.class,0);
		}
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public String_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterString_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitString_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitString_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_expressionContext string_expression() throws RecognitionException {
		String_expressionContext _localctx = new String_expressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_string_expression);
		try {
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				single_element_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(491);
				string_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(492);
				match(Input_parameter);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(493);
				functions_returning_strings();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(494);
				aggregate_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(495);
				case_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(496);
				function_invocation();
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

	public static class Datetime_expressionContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Functions_returning_datetimeContext functions_returning_datetime() {
			return getRuleContext(Functions_returning_datetimeContext.class,0);
		}
		public Aggregate_expressionContext aggregate_expression() {
			return getRuleContext(Aggregate_expressionContext.class,0);
		}
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public Temporal_literalContext temporal_literal() {
			return getRuleContext(Temporal_literalContext.class,0);
		}
		public Datetime_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterDatetime_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitDatetime_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitDatetime_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Datetime_expressionContext datetime_expression() throws RecognitionException {
		Datetime_expressionContext _localctx = new Datetime_expressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_datetime_expression);
		try {
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				single_element_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(Input_parameter);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				functions_returning_datetime();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(503);
				aggregate_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(504);
				case_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(505);
				function_invocation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(506);
				temporal_literal();
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

	public static class Boolean_expressionContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class,0);
		}
		public Boolean_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterBoolean_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitBoolean_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitBoolean_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_expressionContext boolean_expression() throws RecognitionException {
		Boolean_expressionContext _localctx = new Boolean_expressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_boolean_expression);
		try {
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				single_element_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				boolean_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(512);
				match(Input_parameter);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(513);
				case_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(514);
				function_invocation();
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

	public static class Enum_expressionContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Enum_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEnum_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEnum_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEnum_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_expressionContext enum_expression() throws RecognitionException {
		Enum_expressionContext _localctx = new Enum_expressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_enum_expression);
		try {
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				single_element_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				match(Input_parameter);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(520);
				case_expression();
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

	public static class Entity_expressionContext extends ParserRuleContext {
		public Single_valued_object_path_expressionContext single_valued_object_path_expression() {
			return getRuleContext(Single_valued_object_path_expressionContext.class,0);
		}
		public Simple_entity_expressionContext simple_entity_expression() {
			return getRuleContext(Simple_entity_expressionContext.class,0);
		}
		public Entity_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEntity_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEntity_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEntity_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_expressionContext entity_expression() throws RecognitionException {
		Entity_expressionContext _localctx = new Entity_expressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_entity_expression);
		try {
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				single_valued_object_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				simple_entity_expression();
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

	public static class Simple_entity_expressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Simple_entity_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_entity_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_entity_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_entity_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_entity_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_entity_expressionContext simple_entity_expression() throws RecognitionException {
		Simple_entity_expressionContext _localctx = new Simple_entity_expressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_simple_entity_expression);
		try {
			setState(529);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
			case VALUE:
			case ENTRY:
			case AVG:
			case SUM:
			case MAX:
			case MIN:
			case COUNT:
			case DISTINCT:
			case ENUM:
			case ENTITY:
			case TYPE:
			case LENGTH:
			case LOCATE:
			case ABS:
			case SQRT:
			case MOD:
			case INDEX:
			case CONCAT:
			case SUBSTRING:
			case TRIM:
			case LOWER:
			case UPPER:
			case FROM:
			case LEADING:
			case TRAILING:
			case BOTH:
			case FUNCTION:
			case COALESCE:
			case NULLIF:
			case NOT:
			case OR:
			case AND:
			case BETWEEN:
			case IN:
			case LIKE:
			case ESCAPE:
			case IS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case SIZE:
			case ALL:
			case ANY:
			case SOME:
			case EXISTS:
			case EMPTY:
			case MEMBER:
			case OF:
			case TREAT:
			case AS:
			case Outer_function:
			case Identifier:
			case MACRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				identifier();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				match(Input_parameter);
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

	public static class Entity_type_expressionContext extends ParserRuleContext {
		public Type_discriminatorContext type_discriminator() {
			return getRuleContext(Type_discriminatorContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Entity_type_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEntity_type_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEntity_type_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEntity_type_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_type_expressionContext entity_type_expression() throws RecognitionException {
		Entity_type_expressionContext _localctx = new Entity_type_expressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_entity_type_expression);
		try {
			setState(533);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(531);
				type_discriminator();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(532);
				match(Input_parameter);
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

	public static class Entity_type_or_literal_expressionContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> pathElem = new ArrayList<IdentifierContext>();
		public Entity_type_expressionContext entity_type_expression() {
			return getRuleContext(Entity_type_expressionContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Entity_type_or_literal_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type_or_literal_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEntity_type_or_literal_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEntity_type_or_literal_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEntity_type_or_literal_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_type_or_literal_expressionContext entity_type_or_literal_expression() throws RecognitionException {
		Entity_type_or_literal_expressionContext _localctx = new Entity_type_or_literal_expressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_entity_type_or_literal_expression);
		try {
			int _alt;
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				entity_type_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(536);
				((Entity_type_or_literal_expressionContext)_localctx).identifier = identifier();
				((Entity_type_or_literal_expressionContext)_localctx).pathElem.add(((Entity_type_or_literal_expressionContext)_localctx).identifier);
				setState(541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(537);
						match(Path_separator);
						setState(538);
						((Entity_type_or_literal_expressionContext)_localctx).identifier = identifier();
						((Entity_type_or_literal_expressionContext)_localctx).pathElem.add(((Entity_type_or_literal_expressionContext)_localctx).identifier);
						}
						} 
					}
					setState(543);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
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

	public static class Type_discriminatorContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(JPQLSelectExpressionParser.TYPE, 0); }
		public Type_discriminator_argContext type_discriminator_arg() {
			return getRuleContext(Type_discriminator_argContext.class,0);
		}
		public Type_discriminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_discriminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterType_discriminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitType_discriminator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitType_discriminator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_discriminatorContext type_discriminator() throws RecognitionException {
		Type_discriminatorContext _localctx = new Type_discriminatorContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_type_discriminator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(TYPE);
			setState(547);
			match(T__0);
			setState(548);
			type_discriminator_arg();
			setState(549);
			match(T__1);
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

	public static class Type_discriminator_argContext extends ParserRuleContext {
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Single_valued_object_path_expressionContext single_valued_object_path_expression() {
			return getRuleContext(Single_valued_object_path_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Key_value_expressionContext key_value_expression() {
			return getRuleContext(Key_value_expressionContext.class,0);
		}
		public Type_discriminator_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_discriminator_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterType_discriminator_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitType_discriminator_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitType_discriminator_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_discriminator_argContext type_discriminator_arg() throws RecognitionException {
		Type_discriminator_argContext _localctx = new Type_discriminator_argContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_type_discriminator_arg);
		try {
			setState(555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(551);
				match(Input_parameter);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(552);
				single_valued_object_path_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(553);
				single_element_path_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(554);
				key_value_expression();
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

	public static class Functions_returning_numericsContext extends ParserRuleContext {
		public Functions_returning_numericsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_numerics; }
	 
		public Functions_returning_numericsContext() { }
		public void copyFrom(Functions_returning_numericsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IndexFunctionContext extends Functions_returning_numericsContext {
		public TerminalNode INDEX() { return getToken(JPQLSelectExpressionParser.INDEX, 0); }
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public IndexFunctionContext(Functions_returning_numericsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterIndexFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitIndexFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitIndexFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Functions_returning_numerics_sizeContext extends Functions_returning_numericsContext {
		public TerminalNode SIZE() { return getToken(JPQLSelectExpressionParser.SIZE, 0); }
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public Functions_returning_numerics_sizeContext(Functions_returning_numericsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterFunctions_returning_numerics_size(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitFunctions_returning_numerics_size(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitFunctions_returning_numerics_size(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Functions_returning_numerics_defaultContext extends Functions_returning_numericsContext {
		public TerminalNode LENGTH() { return getToken(JPQLSelectExpressionParser.LENGTH, 0); }
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public TerminalNode LOCATE() { return getToken(JPQLSelectExpressionParser.LOCATE, 0); }
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public TerminalNode ABS() { return getToken(JPQLSelectExpressionParser.ABS, 0); }
		public TerminalNode SQRT() { return getToken(JPQLSelectExpressionParser.SQRT, 0); }
		public TerminalNode MOD() { return getToken(JPQLSelectExpressionParser.MOD, 0); }
		public Functions_returning_numerics_defaultContext(Functions_returning_numericsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterFunctions_returning_numerics_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitFunctions_returning_numerics_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitFunctions_returning_numerics_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_returning_numericsContext functions_returning_numerics() throws RecognitionException {
		Functions_returning_numericsContext _localctx = new Functions_returning_numericsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_functions_returning_numerics);
		int _la;
		try {
			setState(600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LENGTH:
				_localctx = new Functions_returning_numerics_defaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(557);
				match(LENGTH);
				setState(558);
				match(T__0);
				setState(559);
				string_expression();
				setState(560);
				match(T__1);
				}
				break;
			case LOCATE:
				_localctx = new Functions_returning_numerics_defaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(562);
				match(LOCATE);
				setState(563);
				match(T__0);
				setState(564);
				string_expression();
				setState(565);
				match(T__4);
				setState(566);
				string_expression();
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(567);
					match(T__4);
					setState(568);
					arithmetic_expression(0);
					}
				}

				setState(571);
				match(T__1);
				}
				break;
			case ABS:
				_localctx = new Functions_returning_numerics_defaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				match(ABS);
				setState(574);
				match(T__0);
				setState(575);
				arithmetic_expression(0);
				setState(576);
				match(T__1);
				}
				break;
			case SQRT:
				_localctx = new Functions_returning_numerics_defaultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(578);
				match(SQRT);
				setState(579);
				match(T__0);
				setState(580);
				arithmetic_expression(0);
				setState(581);
				match(T__1);
				}
				break;
			case MOD:
				_localctx = new Functions_returning_numerics_defaultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(583);
				match(MOD);
				setState(584);
				match(T__0);
				setState(585);
				arithmetic_expression(0);
				setState(586);
				match(T__4);
				setState(587);
				arithmetic_expression(0);
				setState(588);
				match(T__1);
				}
				break;
			case SIZE:
				_localctx = new Functions_returning_numerics_sizeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(590);
				match(SIZE);
				setState(591);
				match(T__0);
				setState(592);
				collection_valued_path_expression();
				setState(593);
				match(T__1);
				}
				break;
			case INDEX:
				_localctx = new IndexFunctionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(595);
				match(INDEX);
				setState(596);
				match(T__0);
				setState(597);
				collection_valued_path_expression();
				setState(598);
				match(T__1);
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

	public static class Functions_returning_datetimeContext extends ParserRuleContext {
		public TerminalNode CURRENT_DATE() { return getToken(JPQLSelectExpressionParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(JPQLSelectExpressionParser.CURRENT_TIME, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(JPQLSelectExpressionParser.CURRENT_TIMESTAMP, 0); }
		public Functions_returning_datetimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_datetime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterFunctions_returning_datetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitFunctions_returning_datetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitFunctions_returning_datetime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_returning_datetimeContext functions_returning_datetime() throws RecognitionException {
		Functions_returning_datetimeContext _localctx = new Functions_returning_datetimeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_functions_returning_datetime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CURRENT_DATE) | (1L << CURRENT_TIME) | (1L << CURRENT_TIMESTAMP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Functions_returning_stringsContext extends ParserRuleContext {
		public Functions_returning_stringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_strings; }
	 
		public Functions_returning_stringsContext() { }
		public void copyFrom(Functions_returning_stringsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TrimFunctionContext extends Functions_returning_stringsContext {
		public TerminalNode TRIM() { return getToken(JPQLSelectExpressionParser.TRIM, 0); }
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public TerminalNode FROM() { return getToken(JPQLSelectExpressionParser.FROM, 0); }
		public Trim_specificationContext trim_specification() {
			return getRuleContext(Trim_specificationContext.class,0);
		}
		public Trim_characterContext trim_character() {
			return getRuleContext(Trim_characterContext.class,0);
		}
		public TrimFunctionContext(Functions_returning_stringsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTrimFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTrimFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTrimFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringFunctionContext extends Functions_returning_stringsContext {
		public TerminalNode CONCAT() { return getToken(JPQLSelectExpressionParser.CONCAT, 0); }
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public TerminalNode SUBSTRING() { return getToken(JPQLSelectExpressionParser.SUBSTRING, 0); }
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public TerminalNode LOWER() { return getToken(JPQLSelectExpressionParser.LOWER, 0); }
		public TerminalNode UPPER() { return getToken(JPQLSelectExpressionParser.UPPER, 0); }
		public StringFunctionContext(Functions_returning_stringsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterStringFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitStringFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitStringFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_returning_stringsContext functions_returning_strings() throws RecognitionException {
		Functions_returning_stringsContext _localctx = new Functions_returning_stringsContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_functions_returning_strings);
		int _la;
		try {
			setState(653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONCAT:
				_localctx = new StringFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(604);
				match(CONCAT);
				setState(605);
				match(T__0);
				setState(606);
				string_expression();
				setState(607);
				match(T__4);
				setState(608);
				string_expression();
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(609);
					match(T__4);
					setState(610);
					string_expression();
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(616);
				match(T__1);
				}
				break;
			case SUBSTRING:
				_localctx = new StringFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(618);
				match(SUBSTRING);
				setState(619);
				match(T__0);
				setState(620);
				string_expression();
				setState(621);
				match(T__4);
				setState(622);
				arithmetic_expression(0);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(623);
					match(T__4);
					setState(624);
					arithmetic_expression(0);
					}
				}

				setState(627);
				match(T__1);
				}
				break;
			case TRIM:
				_localctx = new TrimFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(629);
				match(TRIM);
				setState(630);
				match(T__0);
				setState(638);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEADING) | (1L << TRAILING) | (1L << BOTH))) != 0)) {
						{
						setState(631);
						trim_specification();
						}
					}

					setState(635);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Character_literal - 71)) | (1L << (String_literal - 71)) | (1L << (Input_parameter - 71)))) != 0)) {
						{
						setState(634);
						trim_character();
						}
					}

					setState(637);
					match(FROM);
					}
					break;
				}
				setState(640);
				string_expression();
				setState(641);
				match(T__1);
				}
				break;
			case LOWER:
				_localctx = new StringFunctionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(643);
				match(LOWER);
				setState(644);
				match(T__0);
				setState(645);
				string_expression();
				setState(646);
				match(T__1);
				}
				break;
			case UPPER:
				_localctx = new StringFunctionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(648);
				match(UPPER);
				setState(649);
				match(T__0);
				setState(650);
				string_expression();
				setState(651);
				match(T__1);
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

	public static class Trim_specificationContext extends ParserRuleContext {
		public TerminalNode LEADING() { return getToken(JPQLSelectExpressionParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(JPQLSelectExpressionParser.TRAILING, 0); }
		public TerminalNode BOTH() { return getToken(JPQLSelectExpressionParser.BOTH, 0); }
		public Trim_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTrim_specification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTrim_specification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTrim_specification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trim_specificationContext trim_specification() throws RecognitionException {
		Trim_specificationContext _localctx = new Trim_specificationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEADING) | (1L << TRAILING) | (1L << BOTH))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Function_invocationContext extends ParserRuleContext {
		public Function_argContext function_arg;
		public List<Function_argContext> args = new ArrayList<Function_argContext>();
		public TerminalNode FUNCTION() { return getToken(JPQLSelectExpressionParser.FUNCTION, 0); }
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public List<Function_argContext> function_arg() {
			return getRuleContexts(Function_argContext.class);
		}
		public Function_argContext function_arg(int i) {
			return getRuleContext(Function_argContext.class,i);
		}
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterFunction_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitFunction_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitFunction_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_invocationContext function_invocation() throws RecognitionException {
		Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_function_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(FUNCTION);
			setState(658);
			match(T__0);
			setState(659);
			string_literal();
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(660);
				match(T__4);
				setState(661);
				((Function_invocationContext)_localctx).function_arg = function_arg();
				((Function_invocationContext)_localctx).args.add(((Function_invocationContext)_localctx).function_arg);
				}
				}
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(667);
			match(T__1);
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

	public static class Function_argContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Simple_literalContext simple_literal() {
			return getRuleContext(Simple_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public Function_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterFunction_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitFunction_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitFunction_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_argContext function_arg() throws RecognitionException {
		Function_argContext _localctx = new Function_argContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_function_arg);
		try {
			setState(673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(670);
				simple_literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(671);
				match(Input_parameter);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(672);
				scalar_expression();
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

	public static class Case_expressionContext extends ParserRuleContext {
		public Coalesce_expressionContext coalesce_expression() {
			return getRuleContext(Coalesce_expressionContext.class,0);
		}
		public Nullif_expressionContext nullif_expression() {
			return getRuleContext(Nullif_expressionContext.class,0);
		}
		public General_case_expressionContext general_case_expression() {
			return getRuleContext(General_case_expressionContext.class,0);
		}
		public Simple_case_expressionContext simple_case_expression() {
			return getRuleContext(Simple_case_expressionContext.class,0);
		}
		public Case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCase_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCase_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCase_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_expressionContext case_expression() throws RecognitionException {
		Case_expressionContext _localctx = new Case_expressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_case_expression);
		try {
			setState(681);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				coalesce_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				nullif_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(677);
				if (!(allowCaseWhen == true)) throw new FailedPredicateException(this, "allowCaseWhen == true");
				setState(678);
				general_case_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(679);
				if (!(allowCaseWhen == true)) throw new FailedPredicateException(this, "allowCaseWhen == true");
				setState(680);
				simple_case_expression();
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

	public static class Coalesce_expressionContext extends ParserRuleContext {
		public TerminalNode COALESCE() { return getToken(JPQLSelectExpressionParser.COALESCE, 0); }
		public List<Scalar_expressionContext> scalar_expression() {
			return getRuleContexts(Scalar_expressionContext.class);
		}
		public Scalar_expressionContext scalar_expression(int i) {
			return getRuleContext(Scalar_expressionContext.class,i);
		}
		public Coalesce_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coalesce_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCoalesce_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCoalesce_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCoalesce_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Coalesce_expressionContext coalesce_expression() throws RecognitionException {
		Coalesce_expressionContext _localctx = new Coalesce_expressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_coalesce_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			match(COALESCE);
			setState(684);
			match(T__0);
			setState(685);
			scalar_expression();
			setState(688); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(686);
				match(T__4);
				setState(687);
				scalar_expression();
				}
				}
				setState(690); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(692);
			match(T__1);
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

	public static class Nullif_expressionContext extends ParserRuleContext {
		public TerminalNode NULLIF() { return getToken(JPQLSelectExpressionParser.NULLIF, 0); }
		public List<Scalar_expressionContext> scalar_expression() {
			return getRuleContexts(Scalar_expressionContext.class);
		}
		public Scalar_expressionContext scalar_expression(int i) {
			return getRuleContext(Scalar_expressionContext.class,i);
		}
		public Nullif_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullif_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNullif_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNullif_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNullif_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nullif_expressionContext nullif_expression() throws RecognitionException {
		Nullif_expressionContext _localctx = new Nullif_expressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_nullif_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(NULLIF);
			setState(695);
			match(T__0);
			setState(696);
			scalar_expression();
			setState(697);
			match(T__4);
			setState(698);
			scalar_expression();
			setState(699);
			match(T__1);
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

	public static class Null_literalContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(JPQLSelectExpressionParser.NULL, 0); }
		public Null_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNull_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNull_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNull_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_literalContext null_literal() throws RecognitionException {
		Null_literalContext _localctx = new Null_literalContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_null_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			match(NULL);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> pathElem = new ArrayList<IdentifierContext>();
		public Simple_literalContext simple_literal() {
			return getRuleContext(Simple_literalContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_literal);
		int _la;
		try {
			setState(711);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_literal:
			case String_literal:
			case Date_literal:
			case Time_literal:
			case Timestamp_literal:
			case Boolean_literal:
			case BigInteger_literal:
			case Long_literal:
			case Float_literal:
			case Double_literal:
			case BigDecimal_literal:
			case Integer_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(703);
				simple_literal();
				}
				break;
			case KEY:
			case VALUE:
			case ENTRY:
			case AVG:
			case SUM:
			case MAX:
			case MIN:
			case COUNT:
			case DISTINCT:
			case ENUM:
			case ENTITY:
			case TYPE:
			case LENGTH:
			case LOCATE:
			case ABS:
			case SQRT:
			case MOD:
			case INDEX:
			case CONCAT:
			case SUBSTRING:
			case TRIM:
			case LOWER:
			case UPPER:
			case FROM:
			case LEADING:
			case TRAILING:
			case BOTH:
			case FUNCTION:
			case COALESCE:
			case NULLIF:
			case NOT:
			case OR:
			case AND:
			case BETWEEN:
			case IN:
			case LIKE:
			case ESCAPE:
			case IS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case SIZE:
			case ALL:
			case ANY:
			case SOME:
			case EXISTS:
			case EMPTY:
			case MEMBER:
			case OF:
			case TREAT:
			case AS:
			case Outer_function:
			case Identifier:
			case MACRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
				((LiteralContext)_localctx).identifier = identifier();
				((LiteralContext)_localctx).pathElem.add(((LiteralContext)_localctx).identifier);
				setState(707); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(705);
					match(Path_separator);
					setState(706);
					((LiteralContext)_localctx).identifier = identifier();
					((LiteralContext)_localctx).pathElem.add(((LiteralContext)_localctx).identifier);
					}
					}
					setState(709); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Path_separator );
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

	public static class Simple_literalContext extends ParserRuleContext {
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Temporal_literalContext temporal_literal() {
			return getRuleContext(Temporal_literalContext.class,0);
		}
		public Simple_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_literalContext simple_literal() throws RecognitionException {
		Simple_literalContext _localctx = new Simple_literalContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_simple_literal);
		try {
			setState(717);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Boolean_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(713);
				boolean_literal();
				}
				break;
			case BigInteger_literal:
			case Long_literal:
			case Float_literal:
			case Double_literal:
			case BigDecimal_literal:
			case Integer_literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(714);
				numeric_literal();
				}
				break;
			case Character_literal:
			case String_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(715);
				string_literal();
				}
				break;
			case Date_literal:
			case Time_literal:
			case Timestamp_literal:
				enterOuterAlt(_localctx, 4);
				{
				setState(716);
				temporal_literal();
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

	public static class Numeric_literalContext extends ParserRuleContext {
		public TerminalNode Integer_literal() { return getToken(JPQLSelectExpressionParser.Integer_literal, 0); }
		public TerminalNode Long_literal() { return getToken(JPQLSelectExpressionParser.Long_literal, 0); }
		public TerminalNode BigInteger_literal() { return getToken(JPQLSelectExpressionParser.BigInteger_literal, 0); }
		public TerminalNode Float_literal() { return getToken(JPQLSelectExpressionParser.Float_literal, 0); }
		public TerminalNode Double_literal() { return getToken(JPQLSelectExpressionParser.Double_literal, 0); }
		public TerminalNode BigDecimal_literal() { return getToken(JPQLSelectExpressionParser.BigDecimal_literal, 0); }
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNumeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNumeric_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNumeric_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (BigInteger_literal - 80)) | (1L << (Long_literal - 80)) | (1L << (Float_literal - 80)) | (1L << (Double_literal - 80)) | (1L << (BigDecimal_literal - 80)) | (1L << (Integer_literal - 80)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode String_literal() { return getToken(JPQLSelectExpressionParser.String_literal, 0); }
		public TerminalNode Character_literal() { return getToken(JPQLSelectExpressionParser.Character_literal, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitString_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitString_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_string_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			_la = _input.LA(1);
			if ( !(_la==Character_literal || _la==String_literal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode Boolean_literal() { return getToken(JPQLSelectExpressionParser.Boolean_literal, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitBoolean_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitBoolean_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_boolean_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			match(Boolean_literal);
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

	public static class Temporal_literalContext extends ParserRuleContext {
		public Temporal_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporal_literal; }
	 
		public Temporal_literalContext() { }
		public void copyFrom(Temporal_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DateLiteralContext extends Temporal_literalContext {
		public TerminalNode Date_literal() { return getToken(JPQLSelectExpressionParser.Date_literal, 0); }
		public DateLiteralContext(Temporal_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterDateLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitDateLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitDateLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimestampLiteralContext extends Temporal_literalContext {
		public TerminalNode Timestamp_literal() { return getToken(JPQLSelectExpressionParser.Timestamp_literal, 0); }
		public TimestampLiteralContext(Temporal_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTimestampLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTimestampLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTimestampLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeLiteralContext extends Temporal_literalContext {
		public TerminalNode Time_literal() { return getToken(JPQLSelectExpressionParser.Time_literal, 0); }
		public TimeLiteralContext(Temporal_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTimeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTimeLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Temporal_literalContext temporal_literal() throws RecognitionException {
		Temporal_literalContext _localctx = new Temporal_literalContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_temporal_literal);
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Date_literal:
				_localctx = new DateLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(725);
				match(Date_literal);
				}
				break;
			case Time_literal:
				_localctx = new TimeLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				match(Time_literal);
				}
				break;
			case Timestamp_literal:
				_localctx = new TimestampLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(727);
				match(Timestamp_literal);
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

	public static class Trim_characterContext extends ParserRuleContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Trim_characterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_character; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterTrim_character(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitTrim_character(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitTrim_character(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trim_characterContext trim_character() throws RecognitionException {
		Trim_characterContext _localctx = new Trim_characterContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_trim_character);
		try {
			setState(732);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_literal:
			case String_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(730);
				string_literal();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(731);
				match(Input_parameter);
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

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
	 
		public Conditional_expressionContext() { }
		public void copyFrom(Conditional_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalExpressionContext extends Conditional_expressionContext {
		public Conditional_termContext conditional_term() {
			return getRuleContext(Conditional_termContext.class,0);
		}
		public ConditionalExpressionContext(Conditional_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalExpression_orContext extends Conditional_expressionContext {
		public Token or;
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Conditional_termContext conditional_term() {
			return getRuleContext(Conditional_termContext.class,0);
		}
		public TerminalNode OR() { return getToken(JPQLSelectExpressionParser.OR, 0); }
		public ConditionalExpression_orContext(Conditional_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalExpression_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalExpression_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalExpression_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		return conditional_expression(0);
	}

	private Conditional_expressionContext conditional_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, _parentState);
		Conditional_expressionContext _prevctx = _localctx;
		int _startState = 136;
		enterRecursionRule(_localctx, 136, RULE_conditional_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ConditionalExpressionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(735);
			conditional_term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(742);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalExpression_orContext(new Conditional_expressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditional_expression);
					setState(737);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(738);
					((ConditionalExpression_orContext)_localctx).or = match(OR);
					setState(739);
					conditional_term(0);
					}
					} 
				}
				setState(744);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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

	public static class Conditional_termContext extends ParserRuleContext {
		public Conditional_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_term; }
	 
		public Conditional_termContext() { }
		public void copyFrom(Conditional_termContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalTermContext extends Conditional_termContext {
		public Conditional_factorContext conditional_factor() {
			return getRuleContext(Conditional_factorContext.class,0);
		}
		public ConditionalTermContext(Conditional_termContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalTerm_andContext extends Conditional_termContext {
		public Token and;
		public Conditional_termContext conditional_term() {
			return getRuleContext(Conditional_termContext.class,0);
		}
		public Conditional_factorContext conditional_factor() {
			return getRuleContext(Conditional_factorContext.class,0);
		}
		public TerminalNode AND() { return getToken(JPQLSelectExpressionParser.AND, 0); }
		public ConditionalTerm_andContext(Conditional_termContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalTerm_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalTerm_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalTerm_and(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_termContext conditional_term() throws RecognitionException {
		return conditional_term(0);
	}

	private Conditional_termContext conditional_term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Conditional_termContext _localctx = new Conditional_termContext(_ctx, _parentState);
		Conditional_termContext _prevctx = _localctx;
		int _startState = 138;
		enterRecursionRule(_localctx, 138, RULE_conditional_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ConditionalTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(746);
			conditional_factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(753);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalTerm_andContext(new Conditional_termContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditional_term);
					setState(748);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(749);
					((ConditionalTerm_andContext)_localctx).and = match(AND);
					setState(750);
					conditional_factor();
					}
					} 
				}
				setState(755);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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

	public static class Conditional_factorContext extends ParserRuleContext {
		public Token not;
		public Conditional_primaryContext conditional_primary() {
			return getRuleContext(Conditional_primaryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Conditional_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditional_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditional_factor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditional_factor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_factorContext conditional_factor() throws RecognitionException {
		Conditional_factorContext _localctx = new Conditional_factorContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_conditional_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(756);
				((Conditional_factorContext)_localctx).not = match(NOT);
				}
				break;
			}
			setState(759);
			conditional_primary();
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

	public static class Conditional_primaryContext extends ParserRuleContext {
		public Conditional_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_primary; }
	 
		public Conditional_primaryContext() { }
		public void copyFrom(Conditional_primaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalPrimaryContext extends Conditional_primaryContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ConditionalPrimaryContext(Conditional_primaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalPrimary_simpleContext extends Conditional_primaryContext {
		public Simple_cond_expressionContext simple_cond_expression() {
			return getRuleContext(Simple_cond_expressionContext.class,0);
		}
		public ConditionalPrimary_simpleContext(Conditional_primaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterConditionalPrimary_simple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitConditionalPrimary_simple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitConditionalPrimary_simple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_primaryContext conditional_primary() throws RecognitionException {
		Conditional_primaryContext _localctx = new Conditional_primaryContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_conditional_primary);
		try {
			setState(766);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new ConditionalPrimary_simpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
				simple_cond_expression();
				}
				break;
			case 2:
				_localctx = new ConditionalPrimaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				match(T__0);
				setState(763);
				conditional_expression(0);
				setState(764);
				match(T__1);
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

	public static class Simple_cond_expressionContext extends ParserRuleContext {
		public Comparison_expressionContext comparison_expression() {
			return getRuleContext(Comparison_expressionContext.class,0);
		}
		public Between_expressionContext between_expression() {
			return getRuleContext(Between_expressionContext.class,0);
		}
		public Like_expressionContext like_expression() {
			return getRuleContext(Like_expressionContext.class,0);
		}
		public In_expressionContext in_expression() {
			return getRuleContext(In_expressionContext.class,0);
		}
		public Null_comparison_expressionContext null_comparison_expression() {
			return getRuleContext(Null_comparison_expressionContext.class,0);
		}
		public Empty_collection_comparison_expressionContext empty_collection_comparison_expression() {
			return getRuleContext(Empty_collection_comparison_expressionContext.class,0);
		}
		public Collection_member_expressionContext collection_member_expression() {
			return getRuleContext(Collection_member_expressionContext.class,0);
		}
		public Exists_expressionContext exists_expression() {
			return getRuleContext(Exists_expressionContext.class,0);
		}
		public Simple_cond_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_cond_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_cond_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_cond_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_cond_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_cond_expressionContext simple_cond_expression() throws RecognitionException {
		Simple_cond_expressionContext _localctx = new Simple_cond_expressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_simple_cond_expression);
		try {
			setState(776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(768);
				comparison_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(769);
				between_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(770);
				like_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(771);
				in_expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(772);
				null_comparison_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(773);
				empty_collection_comparison_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(774);
				collection_member_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(775);
				exists_expression();
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

	public static class Between_expressionContext extends ParserRuleContext {
		public Between_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_expression; }
	 
		public Between_expressionContext() { }
		public void copyFrom(Between_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BetweenDatetimeContext extends Between_expressionContext {
		public Datetime_expressionContext expr;
		public Token not;
		public Datetime_expressionContext bound1;
		public Datetime_expressionContext bound2;
		public TerminalNode BETWEEN() { return getToken(JPQLSelectExpressionParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(JPQLSelectExpressionParser.AND, 0); }
		public List<Datetime_expressionContext> datetime_expression() {
			return getRuleContexts(Datetime_expressionContext.class);
		}
		public Datetime_expressionContext datetime_expression(int i) {
			return getRuleContext(Datetime_expressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public BetweenDatetimeContext(Between_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterBetweenDatetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitBetweenDatetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitBetweenDatetime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenStringContext extends Between_expressionContext {
		public String_expressionContext expr;
		public Token not;
		public String_expressionContext bound1;
		public String_expressionContext bound2;
		public TerminalNode BETWEEN() { return getToken(JPQLSelectExpressionParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(JPQLSelectExpressionParser.AND, 0); }
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public BetweenStringContext(Between_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterBetweenString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitBetweenString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitBetweenString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenArithmeticContext extends Between_expressionContext {
		public Arithmetic_expressionContext expr;
		public Token not;
		public Arithmetic_expressionContext bound1;
		public Arithmetic_expressionContext bound2;
		public TerminalNode BETWEEN() { return getToken(JPQLSelectExpressionParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(JPQLSelectExpressionParser.AND, 0); }
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public BetweenArithmeticContext(Between_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterBetweenArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitBetweenArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitBetweenArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Between_expressionContext between_expression() throws RecognitionException {
		Between_expressionContext _localctx = new Between_expressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_between_expression);
		int _la;
		try {
			setState(805);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				_localctx = new BetweenArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(778);
				((BetweenArithmeticContext)_localctx).expr = arithmetic_expression(0);
				setState(780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(779);
					((BetweenArithmeticContext)_localctx).not = match(NOT);
					}
				}

				setState(782);
				match(BETWEEN);
				setState(783);
				((BetweenArithmeticContext)_localctx).bound1 = arithmetic_expression(0);
				setState(784);
				match(AND);
				setState(785);
				((BetweenArithmeticContext)_localctx).bound2 = arithmetic_expression(0);
				}
				break;
			case 2:
				_localctx = new BetweenStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(787);
				((BetweenStringContext)_localctx).expr = string_expression();
				setState(789);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(788);
					((BetweenStringContext)_localctx).not = match(NOT);
					}
				}

				setState(791);
				match(BETWEEN);
				setState(792);
				((BetweenStringContext)_localctx).bound1 = string_expression();
				setState(793);
				match(AND);
				setState(794);
				((BetweenStringContext)_localctx).bound2 = string_expression();
				}
				break;
			case 3:
				_localctx = new BetweenDatetimeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(796);
				((BetweenDatetimeContext)_localctx).expr = datetime_expression();
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(797);
					((BetweenDatetimeContext)_localctx).not = match(NOT);
					}
				}

				setState(800);
				match(BETWEEN);
				setState(801);
				((BetweenDatetimeContext)_localctx).bound1 = datetime_expression();
				setState(802);
				match(AND);
				setState(803);
				((BetweenDatetimeContext)_localctx).bound2 = datetime_expression();
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

	public static class In_expressionContext extends ParserRuleContext {
		public Token left;
		public Token not;
		public In_itemContext in_item;
		public List<In_itemContext> inItems = new ArrayList<In_itemContext>();
		public Token param;
		public TerminalNode IN() { return getToken(JPQLSelectExpressionParser.IN, 0); }
		public List<State_field_path_expressionContext> state_field_path_expression() {
			return getRuleContexts(State_field_path_expressionContext.class);
		}
		public State_field_path_expressionContext state_field_path_expression(int i) {
			return getRuleContext(State_field_path_expressionContext.class,i);
		}
		public Type_discriminatorContext type_discriminator() {
			return getRuleContext(Type_discriminatorContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JPQLSelectExpressionParser.Identifier, 0); }
		public List<In_itemContext> in_item() {
			return getRuleContexts(In_itemContext.class);
		}
		public In_itemContext in_item(int i) {
			return getRuleContext(In_itemContext.class,i);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public In_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterIn_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitIn_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitIn_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_expressionContext in_expression() throws RecognitionException {
		In_expressionContext _localctx = new In_expressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_in_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(807);
				((In_expressionContext)_localctx).left = match(Identifier);
				}
				break;
			case 2:
				{
				setState(808);
				state_field_path_expression();
				}
				break;
			case 3:
				{
				setState(809);
				type_discriminator();
				}
				break;
			}
			setState(813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(812);
				((In_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(815);
			match(IN);
			setState(830);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(816);
				match(T__0);
				setState(817);
				((In_expressionContext)_localctx).in_item = in_item();
				((In_expressionContext)_localctx).inItems.add(((In_expressionContext)_localctx).in_item);
				setState(822);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(818);
					match(T__4);
					setState(819);
					((In_expressionContext)_localctx).in_item = in_item();
					((In_expressionContext)_localctx).inItems.add(((In_expressionContext)_localctx).in_item);
					}
					}
					setState(824);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(825);
				match(T__1);
				}
				break;
			case 2:
				{
				setState(827);
				((In_expressionContext)_localctx).param = match(Input_parameter);
				}
				break;
			case 3:
				{
				setState(828);
				state_field_path_expression();
				}
				break;
			case 4:
				{
				setState(829);
				single_element_path_expression();
				}
				break;
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

	public static class In_itemContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public In_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterIn_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitIn_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitIn_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_itemContext in_item() throws RecognitionException {
		In_itemContext _localctx = new In_itemContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_in_item);
		try {
			setState(834);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
			case VALUE:
			case ENTRY:
			case AVG:
			case SUM:
			case MAX:
			case MIN:
			case COUNT:
			case DISTINCT:
			case ENUM:
			case ENTITY:
			case TYPE:
			case LENGTH:
			case LOCATE:
			case ABS:
			case SQRT:
			case MOD:
			case INDEX:
			case CONCAT:
			case SUBSTRING:
			case TRIM:
			case LOWER:
			case UPPER:
			case FROM:
			case LEADING:
			case TRAILING:
			case BOTH:
			case FUNCTION:
			case COALESCE:
			case NULLIF:
			case NOT:
			case OR:
			case AND:
			case BETWEEN:
			case IN:
			case LIKE:
			case ESCAPE:
			case IS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case SIZE:
			case ALL:
			case ANY:
			case SOME:
			case EXISTS:
			case EMPTY:
			case MEMBER:
			case OF:
			case TREAT:
			case AS:
			case Outer_function:
			case Character_literal:
			case String_literal:
			case Date_literal:
			case Time_literal:
			case Timestamp_literal:
			case Boolean_literal:
			case BigInteger_literal:
			case Long_literal:
			case Float_literal:
			case Double_literal:
			case BigDecimal_literal:
			case Integer_literal:
			case Identifier:
			case MACRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(832);
				literal();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(833);
				match(Input_parameter);
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

	public static class Simple_in_itemContext extends ParserRuleContext {
		public Simple_literalContext simple_literal() {
			return getRuleContext(Simple_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Simple_in_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_in_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_in_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_in_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_in_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_in_itemContext simple_in_item() throws RecognitionException {
		Simple_in_itemContext _localctx = new Simple_in_itemContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_simple_in_item);
		try {
			setState(838);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_literal:
			case String_literal:
			case Date_literal:
			case Time_literal:
			case Timestamp_literal:
			case Boolean_literal:
			case BigInteger_literal:
			case Long_literal:
			case Float_literal:
			case Double_literal:
			case BigDecimal_literal:
			case Integer_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(836);
				simple_literal();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(837);
				match(Input_parameter);
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

	public static class Like_expressionContext extends ParserRuleContext {
		public Token not;
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(JPQLSelectExpressionParser.LIKE, 0); }
		public Pattern_valueContext pattern_value() {
			return getRuleContext(Pattern_valueContext.class,0);
		}
		public TerminalNode ESCAPE() { return getToken(JPQLSelectExpressionParser.ESCAPE, 0); }
		public Escape_characterContext escape_character() {
			return getRuleContext(Escape_characterContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Like_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_like_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterLike_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitLike_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitLike_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Like_expressionContext like_expression() throws RecognitionException {
		Like_expressionContext _localctx = new Like_expressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_like_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			string_expression();
			setState(842);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(841);
				((Like_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(844);
			match(LIKE);
			setState(845);
			pattern_value();
			setState(848);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(846);
				match(ESCAPE);
				setState(847);
				escape_character();
				}
				break;
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

	public static class Pattern_valueContext extends ParserRuleContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Pattern_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterPattern_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitPattern_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitPattern_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern_valueContext pattern_value() throws RecognitionException {
		Pattern_valueContext _localctx = new Pattern_valueContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_pattern_value);
		try {
			setState(852);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_literal:
			case String_literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(850);
				string_literal();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(851);
				match(Input_parameter);
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

	public static class Escape_characterContext extends ParserRuleContext {
		public TerminalNode Character_literal() { return getToken(JPQLSelectExpressionParser.Character_literal, 0); }
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Escape_characterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape_character; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEscape_character(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEscape_character(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEscape_character(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Escape_characterContext escape_character() throws RecognitionException {
		Escape_characterContext _localctx = new Escape_characterContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_escape_character);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			_la = _input.LA(1);
			if ( !(_la==Character_literal || _la==Input_parameter) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Null_comparison_expressionContext extends ParserRuleContext {
		public Token not;
		public TerminalNode IS() { return getToken(JPQLSelectExpressionParser.IS, 0); }
		public TerminalNode NULL() { return getToken(JPQLSelectExpressionParser.NULL, 0); }
		public Single_valued_path_expressionContext single_valued_path_expression() {
			return getRuleContext(Single_valued_path_expressionContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Null_comparison_expression_extensionContext null_comparison_expression_extension() {
			return getRuleContext(Null_comparison_expression_extensionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Null_comparison_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_comparison_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNull_comparison_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNull_comparison_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNull_comparison_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_comparison_expressionContext null_comparison_expression() throws RecognitionException {
		Null_comparison_expressionContext _localctx = new Null_comparison_expressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_null_comparison_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(856);
				single_valued_path_expression();
				}
				break;
			case 2:
				{
				setState(857);
				match(Input_parameter);
				}
				break;
			case 3:
				{
				setState(858);
				null_comparison_expression_extension();
				}
				break;
			}
			setState(861);
			match(IS);
			setState(863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(862);
				((Null_comparison_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(865);
			match(NULL);
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

	public static class Null_comparison_expression_extensionContext extends ParserRuleContext {
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public Null_comparison_expression_extensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_comparison_expression_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNull_comparison_expression_extension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNull_comparison_expression_extension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNull_comparison_expression_extension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_comparison_expression_extensionContext null_comparison_expression_extension() throws RecognitionException {
		Null_comparison_expression_extensionContext _localctx = new Null_comparison_expression_extensionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_null_comparison_expression_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			scalar_expression();
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

	public static class Empty_collection_comparison_expressionContext extends ParserRuleContext {
		public Token not;
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public TerminalNode IS() { return getToken(JPQLSelectExpressionParser.IS, 0); }
		public TerminalNode EMPTY() { return getToken(JPQLSelectExpressionParser.EMPTY, 0); }
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Empty_collection_comparison_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_collection_comparison_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEmpty_collection_comparison_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEmpty_collection_comparison_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEmpty_collection_comparison_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Empty_collection_comparison_expressionContext empty_collection_comparison_expression() throws RecognitionException {
		Empty_collection_comparison_expressionContext _localctx = new Empty_collection_comparison_expressionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_empty_collection_comparison_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			collection_valued_path_expression();
			setState(870);
			match(IS);
			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(871);
				((Empty_collection_comparison_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(874);
			match(EMPTY);
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

	public static class Collection_member_expressionContext extends ParserRuleContext {
		public Token not;
		public Entity_or_value_expressionContext entity_or_value_expression() {
			return getRuleContext(Entity_or_value_expressionContext.class,0);
		}
		public TerminalNode MEMBER() { return getToken(JPQLSelectExpressionParser.MEMBER, 0); }
		public Collection_valued_path_expressionContext collection_valued_path_expression() {
			return getRuleContext(Collection_valued_path_expressionContext.class,0);
		}
		public TerminalNode OF() { return getToken(JPQLSelectExpressionParser.OF, 0); }
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Collection_member_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection_member_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCollection_member_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCollection_member_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCollection_member_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Collection_member_expressionContext collection_member_expression() throws RecognitionException {
		Collection_member_expressionContext _localctx = new Collection_member_expressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_collection_member_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			entity_or_value_expression();
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(877);
				((Collection_member_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(880);
			match(MEMBER);
			setState(882);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(881);
				match(OF);
				}
				break;
			}
			setState(884);
			collection_valued_path_expression();
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

	public static class Exists_expressionContext extends ParserRuleContext {
		public Token not;
		public TerminalNode EXISTS() { return getToken(JPQLSelectExpressionParser.EXISTS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public Exists_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exists_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterExists_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitExists_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitExists_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exists_expressionContext exists_expression() throws RecognitionException {
		Exists_expressionContext _localctx = new Exists_expressionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_exists_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(886);
				((Exists_expressionContext)_localctx).not = match(NOT);
				}
			}

			setState(889);
			match(EXISTS);
			setState(890);
			identifier();
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

	public static class Entity_or_value_expressionContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Simple_entity_or_value_expressionContext simple_entity_or_value_expression() {
			return getRuleContext(Simple_entity_or_value_expressionContext.class,0);
		}
		public Single_element_path_expressionContext single_element_path_expression() {
			return getRuleContext(Single_element_path_expressionContext.class,0);
		}
		public Entity_or_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_or_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEntity_or_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEntity_or_value_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEntity_or_value_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_or_value_expressionContext entity_or_value_expression() throws RecognitionException {
		Entity_or_value_expressionContext _localctx = new Entity_or_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_entity_or_value_expression);
		try {
			setState(895);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(892);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				simple_entity_or_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(894);
				single_element_path_expression();
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

	public static class Simple_entity_or_value_expressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Input_parameter() { return getToken(JPQLSelectExpressionParser.Input_parameter, 0); }
		public Simple_literalContext simple_literal() {
			return getRuleContext(Simple_literalContext.class,0);
		}
		public Simple_entity_or_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_entity_or_value_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_entity_or_value_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_entity_or_value_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_entity_or_value_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_entity_or_value_expressionContext simple_entity_or_value_expression() throws RecognitionException {
		Simple_entity_or_value_expressionContext _localctx = new Simple_entity_or_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_simple_entity_or_value_expression);
		try {
			setState(900);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
			case VALUE:
			case ENTRY:
			case AVG:
			case SUM:
			case MAX:
			case MIN:
			case COUNT:
			case DISTINCT:
			case ENUM:
			case ENTITY:
			case TYPE:
			case LENGTH:
			case LOCATE:
			case ABS:
			case SQRT:
			case MOD:
			case INDEX:
			case CONCAT:
			case SUBSTRING:
			case TRIM:
			case LOWER:
			case UPPER:
			case FROM:
			case LEADING:
			case TRAILING:
			case BOTH:
			case FUNCTION:
			case COALESCE:
			case NULLIF:
			case NOT:
			case OR:
			case AND:
			case BETWEEN:
			case IN:
			case LIKE:
			case ESCAPE:
			case IS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case SIZE:
			case ALL:
			case ANY:
			case SOME:
			case EXISTS:
			case EMPTY:
			case MEMBER:
			case OF:
			case TREAT:
			case AS:
			case Outer_function:
			case Identifier:
			case MACRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(897);
				identifier();
				}
				break;
			case Input_parameter:
				enterOuterAlt(_localctx, 2);
				{
				setState(898);
				match(Input_parameter);
				}
				break;
			case Character_literal:
			case String_literal:
			case Date_literal:
			case Time_literal:
			case Timestamp_literal:
			case Boolean_literal:
			case BigInteger_literal:
			case Long_literal:
			case Float_literal:
			case Double_literal:
			case BigDecimal_literal:
			case Integer_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(899);
				simple_literal();
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

	public static class Comparison_expressionContext extends ParserRuleContext {
		public Comparison_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_expression; }
	 
		public Comparison_expressionContext() { }
		public void copyFrom(Comparison_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuantifiedComparisonExpression_entityContext extends Comparison_expressionContext {
		public Entity_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Token quantifier;
		public IdentifierContext right;
		public Entity_expressionContext entity_expression() {
			return getRuleContext(Entity_expressionContext.class,0);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_entityContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_entity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_entity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_entity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonExpression_booleanContext extends Comparison_expressionContext {
		public Boolean_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Token quantifier;
		public IdentifierContext right;
		public Boolean_expressionContext boolean_expression() {
			return getRuleContext(Boolean_expressionContext.class,0);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_booleanContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_boolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_boolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_arithmeticContext extends Comparison_expressionContext {
		public Arithmetic_expressionContext left;
		public Arithmetic_expressionContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public ComparisonExpression_arithmeticContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_arithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_arithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_arithmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_entitytypeContext extends Comparison_expressionContext {
		public Entity_type_or_literal_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Entity_type_or_literal_expressionContext right;
		public List<Entity_type_or_literal_expressionContext> entity_type_or_literal_expression() {
			return getRuleContexts(Entity_type_or_literal_expressionContext.class);
		}
		public Entity_type_or_literal_expressionContext entity_type_or_literal_expression(int i) {
			return getRuleContext(Entity_type_or_literal_expressionContext.class,i);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public ComparisonExpression_entitytypeContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_entitytype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_entitytype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_entitytype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_datetimeContext extends Comparison_expressionContext {
		public Datetime_expressionContext left;
		public Datetime_expressionContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public List<Datetime_expressionContext> datetime_expression() {
			return getRuleContexts(Datetime_expressionContext.class);
		}
		public Datetime_expressionContext datetime_expression(int i) {
			return getRuleContext(Datetime_expressionContext.class,i);
		}
		public ComparisonExpression_datetimeContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_datetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_datetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_datetime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_entityContext extends Comparison_expressionContext {
		public Entity_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Entity_expressionContext right;
		public List<Entity_expressionContext> entity_expression() {
			return getRuleContexts(Entity_expressionContext.class);
		}
		public Entity_expressionContext entity_expression(int i) {
			return getRuleContext(Entity_expressionContext.class,i);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public ComparisonExpression_entityContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_entity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_entity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_entity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_stringContext extends Comparison_expressionContext {
		public String_expressionContext left;
		public String_expressionContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public ComparisonExpression_stringContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_string(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonExpression_entitytypeContext extends Comparison_expressionContext {
		public Entity_type_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Token quantifier;
		public IdentifierContext right;
		public Entity_type_expressionContext entity_type_expression() {
			return getRuleContext(Entity_type_expressionContext.class,0);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_entitytypeContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_entitytype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_entitytype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_entitytype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_path_typeContext extends Comparison_expressionContext {
		public PathContext left;
		public Equality_comparison_operatorContext op;
		public Type_discriminatorContext right;
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public Type_discriminatorContext type_discriminator() {
			return getRuleContext(Type_discriminatorContext.class,0);
		}
		public ComparisonExpression_path_typeContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_path_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_path_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_path_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_booleanContext extends Comparison_expressionContext {
		public Boolean_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Boolean_expressionContext right;
		public List<Boolean_expressionContext> boolean_expression() {
			return getRuleContexts(Boolean_expressionContext.class);
		}
		public Boolean_expressionContext boolean_expression(int i) {
			return getRuleContext(Boolean_expressionContext.class,i);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public ComparisonExpression_booleanContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_boolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_boolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_boolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_type_pathContext extends Comparison_expressionContext {
		public Type_discriminatorContext left;
		public Equality_comparison_operatorContext op;
		public PathContext right;
		public Type_discriminatorContext type_discriminator() {
			return getRuleContext(Type_discriminatorContext.class,0);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public ComparisonExpression_type_pathContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_type_path(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_type_path(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_type_path(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonExpression_stringContext extends Comparison_expressionContext {
		public String_expressionContext left;
		public Token quantifier;
		public IdentifierContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_stringContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_string(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonExpression_datetimeContext extends Comparison_expressionContext {
		public Datetime_expressionContext left;
		public Token quantifier;
		public IdentifierContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public Datetime_expressionContext datetime_expression() {
			return getRuleContext(Datetime_expressionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_datetimeContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_datetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_datetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_datetime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifiedComparisonExpression_arithmeticContext extends Comparison_expressionContext {
		public Arithmetic_expressionContext left;
		public Token quantifier;
		public IdentifierContext right;
		public Comparison_operatorContext comparison_operator() {
			return getRuleContext(Comparison_operatorContext.class,0);
		}
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QuantifiedComparisonExpression_arithmeticContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterQuantifiedComparisonExpression_arithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitQuantifiedComparisonExpression_arithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitQuantifiedComparisonExpression_arithmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpression_enumContext extends Comparison_expressionContext {
		public Enum_expressionContext left;
		public Equality_comparison_operatorContext op;
		public Enum_expressionContext right;
		public List<Enum_expressionContext> enum_expression() {
			return getRuleContexts(Enum_expressionContext.class);
		}
		public Enum_expressionContext enum_expression(int i) {
			return getRuleContext(Enum_expressionContext.class,i);
		}
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public ComparisonExpression_enumContext(Comparison_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterComparisonExpression_enum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitComparisonExpression_enum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitComparisonExpression_enum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_expressionContext comparison_expression() throws RecognitionException {
		Comparison_expressionContext _localctx = new Comparison_expressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_comparison_expression);
		int _la;
		try {
			setState(1015);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				_localctx = new ComparisonExpression_stringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(902);
				((ComparisonExpression_stringContext)_localctx).left = string_expression();
				setState(903);
				comparison_operator();
				setState(904);
				((ComparisonExpression_stringContext)_localctx).right = string_expression();
				}
				break;
			case 2:
				_localctx = new QuantifiedComparisonExpression_stringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(906);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(907);
				((QuantifiedComparisonExpression_stringContext)_localctx).left = string_expression();
				setState(908);
				comparison_operator();
				setState(909);
				((QuantifiedComparisonExpression_stringContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_stringContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(915);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(910);
					match(T__0);
					setState(911);
					((QuantifiedComparisonExpression_stringContext)_localctx).right = identifier();
					setState(912);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(914);
					((QuantifiedComparisonExpression_stringContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new ComparisonExpression_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(917);
				((ComparisonExpression_booleanContext)_localctx).left = boolean_expression();
				setState(918);
				((ComparisonExpression_booleanContext)_localctx).op = equality_comparison_operator();
				setState(919);
				((ComparisonExpression_booleanContext)_localctx).right = boolean_expression();
				}
				break;
			case 4:
				_localctx = new QuantifiedComparisonExpression_booleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(921);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(922);
				((QuantifiedComparisonExpression_booleanContext)_localctx).left = boolean_expression();
				setState(923);
				((QuantifiedComparisonExpression_booleanContext)_localctx).op = equality_comparison_operator();
				setState(924);
				((QuantifiedComparisonExpression_booleanContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_booleanContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(930);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(925);
					match(T__0);
					setState(926);
					((QuantifiedComparisonExpression_booleanContext)_localctx).right = identifier();
					setState(927);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(929);
					((QuantifiedComparisonExpression_booleanContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				_localctx = new ComparisonExpression_enumContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(932);
				((ComparisonExpression_enumContext)_localctx).left = enum_expression();
				setState(933);
				((ComparisonExpression_enumContext)_localctx).op = equality_comparison_operator();
				setState(934);
				((ComparisonExpression_enumContext)_localctx).right = enum_expression();
				}
				break;
			case 6:
				_localctx = new QuantifiedComparisonExpression_datetimeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(936);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(937);
				((QuantifiedComparisonExpression_datetimeContext)_localctx).left = datetime_expression();
				setState(938);
				comparison_operator();
				setState(939);
				((QuantifiedComparisonExpression_datetimeContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_datetimeContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(945);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(940);
					match(T__0);
					setState(941);
					((QuantifiedComparisonExpression_datetimeContext)_localctx).right = identifier();
					setState(942);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(944);
					((QuantifiedComparisonExpression_datetimeContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 7:
				_localctx = new ComparisonExpression_datetimeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(947);
				((ComparisonExpression_datetimeContext)_localctx).left = datetime_expression();
				setState(948);
				comparison_operator();
				setState(949);
				((ComparisonExpression_datetimeContext)_localctx).right = datetime_expression();
				}
				break;
			case 8:
				_localctx = new QuantifiedComparisonExpression_datetimeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(951);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(952);
				((QuantifiedComparisonExpression_datetimeContext)_localctx).left = datetime_expression();
				setState(953);
				comparison_operator();
				setState(954);
				((QuantifiedComparisonExpression_datetimeContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_datetimeContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(960);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(955);
					match(T__0);
					setState(956);
					((QuantifiedComparisonExpression_datetimeContext)_localctx).right = identifier();
					setState(957);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(959);
					((QuantifiedComparisonExpression_datetimeContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 9:
				_localctx = new ComparisonExpression_entityContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(962);
				((ComparisonExpression_entityContext)_localctx).left = entity_expression();
				setState(963);
				((ComparisonExpression_entityContext)_localctx).op = equality_comparison_operator();
				setState(964);
				((ComparisonExpression_entityContext)_localctx).right = entity_expression();
				}
				break;
			case 10:
				_localctx = new QuantifiedComparisonExpression_entityContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(966);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(967);
				((QuantifiedComparisonExpression_entityContext)_localctx).left = entity_expression();
				setState(968);
				((QuantifiedComparisonExpression_entityContext)_localctx).op = equality_comparison_operator();
				setState(969);
				((QuantifiedComparisonExpression_entityContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_entityContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(975);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(970);
					match(T__0);
					setState(971);
					((QuantifiedComparisonExpression_entityContext)_localctx).right = identifier();
					setState(972);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(974);
					((QuantifiedComparisonExpression_entityContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 11:
				_localctx = new ComparisonExpression_arithmeticContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(977);
				((ComparisonExpression_arithmeticContext)_localctx).left = arithmetic_expression(0);
				setState(978);
				comparison_operator();
				setState(979);
				((ComparisonExpression_arithmeticContext)_localctx).right = arithmetic_expression(0);
				}
				break;
			case 12:
				_localctx = new QuantifiedComparisonExpression_arithmeticContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(981);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(982);
				((QuantifiedComparisonExpression_arithmeticContext)_localctx).left = arithmetic_expression(0);
				setState(983);
				comparison_operator();
				setState(984);
				((QuantifiedComparisonExpression_arithmeticContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_arithmeticContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(990);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(985);
					match(T__0);
					setState(986);
					((QuantifiedComparisonExpression_arithmeticContext)_localctx).right = identifier();
					setState(987);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(989);
					((QuantifiedComparisonExpression_arithmeticContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 13:
				_localctx = new ComparisonExpression_entitytypeContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(992);
				((ComparisonExpression_entitytypeContext)_localctx).left = entity_type_or_literal_expression();
				setState(993);
				((ComparisonExpression_entitytypeContext)_localctx).op = equality_comparison_operator();
				setState(994);
				((ComparisonExpression_entitytypeContext)_localctx).right = entity_type_or_literal_expression();
				}
				break;
			case 14:
				_localctx = new QuantifiedComparisonExpression_entitytypeContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(996);
				if (!(allowQuantifiedPredicates == true)) throw new FailedPredicateException(this, "allowQuantifiedPredicates == true");
				setState(997);
				((QuantifiedComparisonExpression_entitytypeContext)_localctx).left = entity_type_expression();
				setState(998);
				((QuantifiedComparisonExpression_entitytypeContext)_localctx).op = equality_comparison_operator();
				setState(999);
				((QuantifiedComparisonExpression_entitytypeContext)_localctx).quantifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALL) | (1L << ANY) | (1L << SOME))) != 0)) ) {
					((QuantifiedComparisonExpression_entitytypeContext)_localctx).quantifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1005);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(1000);
					match(T__0);
					setState(1001);
					((QuantifiedComparisonExpression_entitytypeContext)_localctx).right = identifier();
					setState(1002);
					match(T__1);
					}
					break;
				case KEY:
				case VALUE:
				case ENTRY:
				case AVG:
				case SUM:
				case MAX:
				case MIN:
				case COUNT:
				case DISTINCT:
				case ENUM:
				case ENTITY:
				case TYPE:
				case LENGTH:
				case LOCATE:
				case ABS:
				case SQRT:
				case MOD:
				case INDEX:
				case CONCAT:
				case SUBSTRING:
				case TRIM:
				case LOWER:
				case UPPER:
				case FROM:
				case LEADING:
				case TRAILING:
				case BOTH:
				case FUNCTION:
				case COALESCE:
				case NULLIF:
				case NOT:
				case OR:
				case AND:
				case BETWEEN:
				case IN:
				case LIKE:
				case ESCAPE:
				case IS:
				case CASE:
				case ELSE:
				case END:
				case WHEN:
				case THEN:
				case SIZE:
				case ALL:
				case ANY:
				case SOME:
				case EXISTS:
				case EMPTY:
				case MEMBER:
				case OF:
				case TREAT:
				case AS:
				case Outer_function:
				case Identifier:
				case MACRO:
					{
					setState(1004);
					((QuantifiedComparisonExpression_entitytypeContext)_localctx).right = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 15:
				_localctx = new ComparisonExpression_path_typeContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(1007);
				((ComparisonExpression_path_typeContext)_localctx).left = path();
				setState(1008);
				((ComparisonExpression_path_typeContext)_localctx).op = equality_comparison_operator();
				setState(1009);
				((ComparisonExpression_path_typeContext)_localctx).right = type_discriminator();
				}
				break;
			case 16:
				_localctx = new ComparisonExpression_type_pathContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(1011);
				((ComparisonExpression_type_pathContext)_localctx).left = type_discriminator();
				setState(1012);
				((ComparisonExpression_type_pathContext)_localctx).op = equality_comparison_operator();
				setState(1013);
				((ComparisonExpression_type_pathContext)_localctx).right = path();
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

	public static class Equality_comparison_operatorContext extends ParserRuleContext {
		public Equality_comparison_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_comparison_operator; }
	 
		public Equality_comparison_operatorContext() { }
		public void copyFrom(Equality_comparison_operatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NeqPredicateContext extends Equality_comparison_operatorContext {
		public TerminalNode Not_equal_operator() { return getToken(JPQLSelectExpressionParser.Not_equal_operator, 0); }
		public NeqPredicateContext(Equality_comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterNeqPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitNeqPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitNeqPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqPredicateContext extends Equality_comparison_operatorContext {
		public EqPredicateContext(Equality_comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEqPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEqPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEqPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_comparison_operatorContext equality_comparison_operator() throws RecognitionException {
		Equality_comparison_operatorContext _localctx = new Equality_comparison_operatorContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_equality_comparison_operator);
		try {
			setState(1019);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new EqPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1017);
				match(T__6);
				}
				break;
			case Not_equal_operator:
				_localctx = new NeqPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1018);
				match(Not_equal_operator);
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

	public static class Comparison_operatorContext extends ParserRuleContext {
		public Comparison_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_operator; }
	 
		public Comparison_operatorContext() { }
		public void copyFrom(Comparison_operatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GePredicateContext extends Comparison_operatorContext {
		public GePredicateContext(Comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGePredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtPredicateContext extends Comparison_operatorContext {
		public GtPredicateContext(Comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGtPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGtPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGtPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LePredicateContext extends Comparison_operatorContext {
		public LePredicateContext(Comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterLePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitLePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitLePredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtPredicateContext extends Comparison_operatorContext {
		public LtPredicateContext(Comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterLtPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitLtPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitLtPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqOrNeqPredicateContext extends Comparison_operatorContext {
		public Equality_comparison_operatorContext equality_comparison_operator() {
			return getRuleContext(Equality_comparison_operatorContext.class,0);
		}
		public EqOrNeqPredicateContext(Comparison_operatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterEqOrNeqPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitEqOrNeqPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitEqOrNeqPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_operatorContext comparison_operator() throws RecognitionException {
		Comparison_operatorContext _localctx = new Comparison_operatorContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_comparison_operator);
		try {
			setState(1026);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case Not_equal_operator:
				_localctx = new EqOrNeqPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1021);
				equality_comparison_operator();
				}
				break;
			case T__7:
				_localctx = new GtPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1022);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new GePredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1023);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new LtPredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1024);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new LePredicateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1025);
				match(T__10);
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

	public static class General_case_expressionContext extends ParserRuleContext {
		public Token caseTerminal;
		public Token elseTerminal;
		public Token endTerminal;
		public List<When_clauseContext> when_clause() {
			return getRuleContexts(When_clauseContext.class);
		}
		public When_clauseContext when_clause(int i) {
			return getRuleContext(When_clauseContext.class,i);
		}
		public TerminalNode CASE() { return getToken(JPQLSelectExpressionParser.CASE, 0); }
		public TerminalNode END() { return getToken(JPQLSelectExpressionParser.END, 0); }
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(JPQLSelectExpressionParser.ELSE, 0); }
		public General_case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_case_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterGeneral_case_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitGeneral_case_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitGeneral_case_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_case_expressionContext general_case_expression() throws RecognitionException {
		General_case_expressionContext _localctx = new General_case_expressionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_general_case_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			((General_case_expressionContext)_localctx).caseTerminal = match(CASE);
			setState(1029);
			when_clause();
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHEN) {
				{
				{
				setState(1030);
				when_clause();
				}
				}
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1038);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1036);
				((General_case_expressionContext)_localctx).elseTerminal = match(ELSE);
				setState(1037);
				scalar_expression();
				}
			}

			setState(1040);
			((General_case_expressionContext)_localctx).endTerminal = match(END);
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

	public static class When_clauseContext extends ParserRuleContext {
		public Token whenTerminal;
		public Token thenTerminal;
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(JPQLSelectExpressionParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(JPQLSelectExpressionParser.THEN, 0); }
		public When_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterWhen_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitWhen_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitWhen_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final When_clauseContext when_clause() throws RecognitionException {
		When_clauseContext _localctx = new When_clauseContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			((When_clauseContext)_localctx).whenTerminal = match(WHEN);
			setState(1043);
			conditional_expression(0);
			setState(1044);
			((When_clauseContext)_localctx).thenTerminal = match(THEN);
			setState(1045);
			scalar_expression();
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

	public static class Simple_case_expressionContext extends ParserRuleContext {
		public Token caseTerminal;
		public Token elseTerminal;
		public Token endTerminal;
		public Case_operandContext case_operand() {
			return getRuleContext(Case_operandContext.class,0);
		}
		public List<Simple_when_clauseContext> simple_when_clause() {
			return getRuleContexts(Simple_when_clauseContext.class);
		}
		public Simple_when_clauseContext simple_when_clause(int i) {
			return getRuleContext(Simple_when_clauseContext.class,i);
		}
		public TerminalNode CASE() { return getToken(JPQLSelectExpressionParser.CASE, 0); }
		public TerminalNode END() { return getToken(JPQLSelectExpressionParser.END, 0); }
		public Scalar_expressionContext scalar_expression() {
			return getRuleContext(Scalar_expressionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(JPQLSelectExpressionParser.ELSE, 0); }
		public Simple_case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_case_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_case_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_case_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_case_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_case_expressionContext simple_case_expression() throws RecognitionException {
		Simple_case_expressionContext _localctx = new Simple_case_expressionContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_simple_case_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047);
			((Simple_case_expressionContext)_localctx).caseTerminal = match(CASE);
			setState(1048);
			case_operand();
			setState(1049);
			simple_when_clause();
			setState(1053);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHEN) {
				{
				{
				setState(1050);
				simple_when_clause();
				}
				}
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1058);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(1056);
				((Simple_case_expressionContext)_localctx).elseTerminal = match(ELSE);
				setState(1057);
				scalar_expression();
				}
			}

			setState(1060);
			((Simple_case_expressionContext)_localctx).endTerminal = match(END);
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

	public static class Simple_when_clauseContext extends ParserRuleContext {
		public Token whenTerminal;
		public Token thenTerminal;
		public List<Scalar_expressionContext> scalar_expression() {
			return getRuleContexts(Scalar_expressionContext.class);
		}
		public Scalar_expressionContext scalar_expression(int i) {
			return getRuleContext(Scalar_expressionContext.class,i);
		}
		public TerminalNode WHEN() { return getToken(JPQLSelectExpressionParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(JPQLSelectExpressionParser.THEN, 0); }
		public Simple_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterSimple_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitSimple_when_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitSimple_when_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_when_clauseContext simple_when_clause() throws RecognitionException {
		Simple_when_clauseContext _localctx = new Simple_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			((Simple_when_clauseContext)_localctx).whenTerminal = match(WHEN);
			setState(1063);
			scalar_expression();
			setState(1064);
			((Simple_when_clauseContext)_localctx).thenTerminal = match(THEN);
			setState(1065);
			scalar_expression();
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

	public static class Case_operandContext extends ParserRuleContext {
		public State_field_path_expressionContext state_field_path_expression() {
			return getRuleContext(State_field_path_expressionContext.class,0);
		}
		public Type_discriminatorContext type_discriminator() {
			return getRuleContext(Type_discriminatorContext.class,0);
		}
		public Case_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterCase_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitCase_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitCase_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_operandContext case_operand() throws RecognitionException {
		Case_operandContext _localctx = new Case_operandContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_case_operand);
		try {
			setState(1069);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1067);
				state_field_path_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1068);
				type_discriminator();
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(JPQLSelectExpressionParser.KEY, 0); }
		public TerminalNode VALUE() { return getToken(JPQLSelectExpressionParser.VALUE, 0); }
		public TerminalNode ENTRY() { return getToken(JPQLSelectExpressionParser.ENTRY, 0); }
		public TerminalNode AVG() { return getToken(JPQLSelectExpressionParser.AVG, 0); }
		public TerminalNode SUM() { return getToken(JPQLSelectExpressionParser.SUM, 0); }
		public TerminalNode MAX() { return getToken(JPQLSelectExpressionParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(JPQLSelectExpressionParser.MIN, 0); }
		public TerminalNode COUNT() { return getToken(JPQLSelectExpressionParser.COUNT, 0); }
		public TerminalNode DISTINCT() { return getToken(JPQLSelectExpressionParser.DISTINCT, 0); }
		public TerminalNode ENUM() { return getToken(JPQLSelectExpressionParser.ENUM, 0); }
		public TerminalNode ENTITY() { return getToken(JPQLSelectExpressionParser.ENTITY, 0); }
		public TerminalNode TYPE() { return getToken(JPQLSelectExpressionParser.TYPE, 0); }
		public TerminalNode LENGTH() { return getToken(JPQLSelectExpressionParser.LENGTH, 0); }
		public TerminalNode LOCATE() { return getToken(JPQLSelectExpressionParser.LOCATE, 0); }
		public TerminalNode ABS() { return getToken(JPQLSelectExpressionParser.ABS, 0); }
		public TerminalNode SQRT() { return getToken(JPQLSelectExpressionParser.SQRT, 0); }
		public TerminalNode MOD() { return getToken(JPQLSelectExpressionParser.MOD, 0); }
		public TerminalNode INDEX() { return getToken(JPQLSelectExpressionParser.INDEX, 0); }
		public TerminalNode CONCAT() { return getToken(JPQLSelectExpressionParser.CONCAT, 0); }
		public TerminalNode SUBSTRING() { return getToken(JPQLSelectExpressionParser.SUBSTRING, 0); }
		public TerminalNode TRIM() { return getToken(JPQLSelectExpressionParser.TRIM, 0); }
		public TerminalNode LOWER() { return getToken(JPQLSelectExpressionParser.LOWER, 0); }
		public TerminalNode UPPER() { return getToken(JPQLSelectExpressionParser.UPPER, 0); }
		public TerminalNode FROM() { return getToken(JPQLSelectExpressionParser.FROM, 0); }
		public TerminalNode LEADING() { return getToken(JPQLSelectExpressionParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(JPQLSelectExpressionParser.TRAILING, 0); }
		public TerminalNode BOTH() { return getToken(JPQLSelectExpressionParser.BOTH, 0); }
		public TerminalNode FUNCTION() { return getToken(JPQLSelectExpressionParser.FUNCTION, 0); }
		public TerminalNode COALESCE() { return getToken(JPQLSelectExpressionParser.COALESCE, 0); }
		public TerminalNode NULLIF() { return getToken(JPQLSelectExpressionParser.NULLIF, 0); }
		public TerminalNode NOT() { return getToken(JPQLSelectExpressionParser.NOT, 0); }
		public TerminalNode OR() { return getToken(JPQLSelectExpressionParser.OR, 0); }
		public TerminalNode AND() { return getToken(JPQLSelectExpressionParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(JPQLSelectExpressionParser.BETWEEN, 0); }
		public TerminalNode IN() { return getToken(JPQLSelectExpressionParser.IN, 0); }
		public TerminalNode LIKE() { return getToken(JPQLSelectExpressionParser.LIKE, 0); }
		public TerminalNode ESCAPE() { return getToken(JPQLSelectExpressionParser.ESCAPE, 0); }
		public TerminalNode IS() { return getToken(JPQLSelectExpressionParser.IS, 0); }
		public TerminalNode CASE() { return getToken(JPQLSelectExpressionParser.CASE, 0); }
		public TerminalNode ELSE() { return getToken(JPQLSelectExpressionParser.ELSE, 0); }
		public TerminalNode END() { return getToken(JPQLSelectExpressionParser.END, 0); }
		public TerminalNode WHEN() { return getToken(JPQLSelectExpressionParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(JPQLSelectExpressionParser.THEN, 0); }
		public TerminalNode SIZE() { return getToken(JPQLSelectExpressionParser.SIZE, 0); }
		public TerminalNode ALL() { return getToken(JPQLSelectExpressionParser.ALL, 0); }
		public TerminalNode ANY() { return getToken(JPQLSelectExpressionParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(JPQLSelectExpressionParser.SOME, 0); }
		public TerminalNode EXISTS() { return getToken(JPQLSelectExpressionParser.EXISTS, 0); }
		public TerminalNode EMPTY() { return getToken(JPQLSelectExpressionParser.EMPTY, 0); }
		public TerminalNode MEMBER() { return getToken(JPQLSelectExpressionParser.MEMBER, 0); }
		public TerminalNode OF() { return getToken(JPQLSelectExpressionParser.OF, 0); }
		public TerminalNode TREAT() { return getToken(JPQLSelectExpressionParser.TREAT, 0); }
		public TerminalNode AS() { return getToken(JPQLSelectExpressionParser.AS, 0); }
		public TerminalNode Outer_function() { return getToken(JPQLSelectExpressionParser.Outer_function, 0); }
		public TerminalNode MACRO() { return getToken(JPQLSelectExpressionParser.MACRO, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1071);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEY) | (1L << VALUE) | (1L << ENTRY) | (1L << AVG) | (1L << SUM) | (1L << MAX) | (1L << MIN) | (1L << COUNT) | (1L << DISTINCT) | (1L << ENUM) | (1L << ENTITY) | (1L << TYPE) | (1L << LENGTH) | (1L << LOCATE) | (1L << ABS) | (1L << SQRT) | (1L << MOD) | (1L << INDEX) | (1L << CONCAT) | (1L << SUBSTRING) | (1L << TRIM) | (1L << LOWER) | (1L << UPPER) | (1L << FROM) | (1L << LEADING) | (1L << TRAILING) | (1L << BOTH) | (1L << FUNCTION) | (1L << COALESCE) | (1L << NULLIF) | (1L << NOT) | (1L << OR) | (1L << AND) | (1L << BETWEEN) | (1L << IN) | (1L << LIKE) | (1L << ESCAPE) | (1L << IS) | (1L << CASE) | (1L << ELSE) | (1L << END) | (1L << WHEN) | (1L << THEN) | (1L << SIZE) | (1L << ALL) | (1L << ANY) | (1L << SOME) | (1L << EXISTS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (EMPTY - 64)) | (1L << (MEMBER - 64)) | (1L << (OF - 64)) | (1L << (TREAT - 64)) | (1L << (AS - 64)) | (1L << (Outer_function - 64)) | (1L << (MACRO - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JPQLSelectExpressionParser.Identifier, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JPQLSelectExpressionListener ) ((JPQLSelectExpressionListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPQLSelectExpressionVisitor ) return ((JPQLSelectExpressionVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_identifier);
		try {
			setState(1075);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1073);
				match(Identifier);
				}
				break;
			case KEY:
			case VALUE:
			case ENTRY:
			case AVG:
			case SUM:
			case MAX:
			case MIN:
			case COUNT:
			case DISTINCT:
			case ENUM:
			case ENTITY:
			case TYPE:
			case LENGTH:
			case LOCATE:
			case ABS:
			case SQRT:
			case MOD:
			case INDEX:
			case CONCAT:
			case SUBSTRING:
			case TRIM:
			case LOWER:
			case UPPER:
			case FROM:
			case LEADING:
			case TRAILING:
			case BOTH:
			case FUNCTION:
			case COALESCE:
			case NULLIF:
			case NOT:
			case OR:
			case AND:
			case BETWEEN:
			case IN:
			case LIKE:
			case ESCAPE:
			case IS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case SIZE:
			case ALL:
			case ANY:
			case SOME:
			case EXISTS:
			case EMPTY:
			case MEMBER:
			case OF:
			case TREAT:
			case AS:
			case Outer_function:
			case MACRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(1074);
				keyword();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return join_association_path_expression_sempred((Join_association_path_expressionContext)_localctx, predIndex);
		case 4:
			return join_path_expression_sempred((Join_path_expressionContext)_localctx, predIndex);
		case 27:
			return state_field_path_expression_sempred((State_field_path_expressionContext)_localctx, predIndex);
		case 28:
			return single_valued_object_path_expression_sempred((Single_valued_object_path_expressionContext)_localctx, predIndex);
		case 37:
			return arithmetic_expression_sempred((Arithmetic_expressionContext)_localctx, predIndex);
		case 38:
			return arithmetic_term_sempred((Arithmetic_termContext)_localctx, predIndex);
		case 57:
			return case_expression_sempred((Case_expressionContext)_localctx, predIndex);
		case 68:
			return conditional_expression_sempred((Conditional_expressionContext)_localctx, predIndex);
		case 69:
			return conditional_term_sempred((Conditional_termContext)_localctx, predIndex);
		case 87:
			return comparison_expression_sempred((Comparison_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean join_association_path_expression_sempred(Join_association_path_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return allowTreatJoinExtension == true;
		}
		return true;
	}
	private boolean join_path_expression_sempred(Join_path_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return allowTreatJoinExtension == true;
		}
		return true;
	}
	private boolean state_field_path_expression_sempred(State_field_path_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return allowOuter == true;
		}
		return true;
	}
	private boolean single_valued_object_path_expression_sempred(Single_valued_object_path_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return allowOuter == true;
		}
		return true;
	}
	private boolean arithmetic_expression_sempred(Arithmetic_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arithmetic_term_sempred(Arithmetic_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean case_expression_sempred(Case_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return allowCaseWhen == true;
		case 7:
			return allowCaseWhen == true;
		}
		return true;
	}
	private boolean conditional_expression_sempred(Conditional_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditional_term_sempred(Conditional_termContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean comparison_expression_sempred(Comparison_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return allowQuantifiedPredicates == true;
		case 11:
			return allowQuantifiedPredicates == true;
		case 12:
			return allowQuantifiedPredicates == true;
		case 13:
			return allowQuantifiedPredicates == true;
		case 14:
			return allowQuantifiedPredicates == true;
		case 15:
			return allowQuantifiedPredicates == true;
		case 16:
			return allowQuantifiedPredicates == true;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3[\u0438\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00ce\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\u00d6\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00ec\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00fc\n\6\3\7\3\7\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\5\17\u0113\n\17\3\20\3\20\3\21\3\21\3\21\5\21\u011a\n\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0126\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0130\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0138\n\24\3\25\3\25\3\25\3\25\5\25\u013e\n\25\3\26\3"+
		"\26\5\26\u0142\n\26\3\27\3\27\3\30\3\30\5\30\u0148\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0163\n\31\3\32\3\32\5\32"+
		"\u0167\n\32\3\33\3\33\3\33\7\33\u016c\n\33\f\33\16\33\u016f\13\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0179\n\34\f\34\16\34\u017c\13"+
		"\34\3\35\3\35\3\35\3\35\5\35\u0182\n\35\3\36\3\36\3\36\5\36\u0187\n\36"+
		"\3\37\3\37\3\37\3\37\3 \3 \5 \u018f\n \3!\3!\3\"\3\"\3\"\5\"\u0196\n\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u019f\n\"\3#\3#\3#\5#\u01a4\n#\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\5$\u01ae\n$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\7&\u01ba"+
		"\n&\f&\16&\u01bd\13&\5&\u01bf\n&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01c9"+
		"\n\'\f\'\16\'\u01cc\13\'\3(\3(\3(\3(\3(\3(\7(\u01d4\n(\f(\16(\u01d7\13"+
		"(\3)\5)\u01da\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01ea\n"+
		"*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01f4\n+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01fe"+
		"\n,\3-\3-\3-\3-\3-\3-\5-\u0206\n-\3.\3.\3.\3.\5.\u020c\n.\3/\3/\5/\u0210"+
		"\n/\3\60\3\60\5\60\u0214\n\60\3\61\3\61\5\61\u0218\n\61\3\62\3\62\3\62"+
		"\3\62\7\62\u021e\n\62\f\62\16\62\u0221\13\62\5\62\u0223\n\62\3\63\3\63"+
		"\3\63\3\63\3\63\3\64\3\64\3\64\3\64\5\64\u022e\n\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u023c\n\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u025b"+
		"\n\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\7\67\u0266\n\67\f\67"+
		"\16\67\u0269\13\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0274"+
		"\n\67\3\67\3\67\3\67\3\67\3\67\5\67\u027b\n\67\3\67\5\67\u027e\n\67\3"+
		"\67\5\67\u0281\n\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\5\67\u0290\n\67\38\38\39\39\39\39\39\79\u0299\n9\f9\16"+
		"9\u029c\139\39\39\3:\3:\3:\3:\5:\u02a4\n:\3;\3;\3;\3;\3;\3;\5;\u02ac\n"+
		";\3<\3<\3<\3<\3<\6<\u02b3\n<\r<\16<\u02b4\3<\3<\3=\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3?\3?\3?\3?\6?\u02c6\n?\r?\16?\u02c7\5?\u02ca\n?\3@\3@\3@\3@\5@\u02d0"+
		"\n@\3A\3A\3B\3B\3C\3C\3D\3D\3D\5D\u02db\nD\3E\3E\5E\u02df\nE\3F\3F\3F"+
		"\3F\3F\3F\7F\u02e7\nF\fF\16F\u02ea\13F\3G\3G\3G\3G\3G\3G\7G\u02f2\nG\f"+
		"G\16G\u02f5\13G\3H\5H\u02f8\nH\3H\3H\3I\3I\3I\3I\3I\5I\u0301\nI\3J\3J"+
		"\3J\3J\3J\3J\3J\3J\5J\u030b\nJ\3K\3K\5K\u030f\nK\3K\3K\3K\3K\3K\3K\3K"+
		"\5K\u0318\nK\3K\3K\3K\3K\3K\3K\3K\5K\u0321\nK\3K\3K\3K\3K\3K\5K\u0328"+
		"\nK\3L\3L\3L\5L\u032d\nL\3L\5L\u0330\nL\3L\3L\3L\3L\3L\7L\u0337\nL\fL"+
		"\16L\u033a\13L\3L\3L\3L\3L\3L\5L\u0341\nL\3M\3M\5M\u0345\nM\3N\3N\5N\u0349"+
		"\nN\3O\3O\5O\u034d\nO\3O\3O\3O\3O\5O\u0353\nO\3P\3P\5P\u0357\nP\3Q\3Q"+
		"\3R\3R\3R\5R\u035e\nR\3R\3R\5R\u0362\nR\3R\3R\3S\3S\3T\3T\3T\5T\u036b"+
		"\nT\3T\3T\3U\3U\5U\u0371\nU\3U\3U\5U\u0375\nU\3U\3U\3V\5V\u037a\nV\3V"+
		"\3V\3V\3W\3W\3W\5W\u0382\nW\3X\3X\3X\5X\u0387\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y"+
		"\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0396\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y"+
		"\5Y\u03a5\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u03b4\nY\3Y\3Y"+
		"\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u03c3\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y"+
		"\3Y\3Y\3Y\3Y\3Y\5Y\u03d2\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y"+
		"\u03e1\nY\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u03f0\nY\3Y\3Y\3Y"+
		"\3Y\3Y\3Y\3Y\3Y\5Y\u03fa\nY\3Z\3Z\5Z\u03fe\nZ\3[\3[\3[\3[\3[\5[\u0405"+
		"\n[\3\\\3\\\3\\\7\\\u040a\n\\\f\\\16\\\u040d\13\\\3\\\3\\\5\\\u0411\n"+
		"\\\3\\\3\\\3]\3]\3]\3]\3]\3^\3^\3^\3^\7^\u041e\n^\f^\16^\u0421\13^\3^"+
		"\3^\5^\u0425\n^\3^\3^\3_\3_\3_\3_\3_\3`\3`\5`\u0430\n`\3a\3a\3b\3b\5b"+
		"\u0436\nb\3b\2\6LN\u008a\u008cc\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\2\13\3\2\21\25\4\2\b"+
		"\bHH\3\2 \"\3\2)+\3\2RW\3\2IJ\4\2IIKK\3\2>@\6\2\16\37#\668G[[\u0492\2"+
		"\u00cd\3\2\2\2\4\u00d5\3\2\2\2\6\u00d7\3\2\2\2\b\u00eb\3\2\2\2\n\u00fb"+
		"\3\2\2\2\f\u00fd\3\2\2\2\16\u00ff\3\2\2\2\20\u0102\3\2\2\2\22\u0105\3"+
		"\2\2\2\24\u0107\3\2\2\2\26\u0109\3\2\2\2\30\u010b\3\2\2\2\32\u010d\3\2"+
		"\2\2\34\u0112\3\2\2\2\36\u0114\3\2\2\2 \u0119\3\2\2\2\"\u0125\3\2\2\2"+
		"$\u012f\3\2\2\2&\u0137\3\2\2\2(\u013d\3\2\2\2*\u0141\3\2\2\2,\u0143\3"+
		"\2\2\2.\u0147\3\2\2\2\60\u0162\3\2\2\2\62\u0166\3\2\2\2\64\u0168\3\2\2"+
		"\2\66\u0170\3\2\2\28\u0181\3\2\2\2:\u0186\3\2\2\2<\u0188\3\2\2\2>\u018e"+
		"\3\2\2\2@\u0190\3\2\2\2B\u019e\3\2\2\2D\u01a3\3\2\2\2F\u01ad\3\2\2\2H"+
		"\u01af\3\2\2\2J\u01b4\3\2\2\2L\u01c2\3\2\2\2N\u01cd\3\2\2\2P\u01d9\3\2"+
		"\2\2R\u01e9\3\2\2\2T\u01f3\3\2\2\2V\u01fd\3\2\2\2X\u0205\3\2\2\2Z\u020b"+
		"\3\2\2\2\\\u020f\3\2\2\2^\u0213\3\2\2\2`\u0217\3\2\2\2b\u0222\3\2\2\2"+
		"d\u0224\3\2\2\2f\u022d\3\2\2\2h\u025a\3\2\2\2j\u025c\3\2\2\2l\u028f\3"+
		"\2\2\2n\u0291\3\2\2\2p\u0293\3\2\2\2r\u02a3\3\2\2\2t\u02ab\3\2\2\2v\u02ad"+
		"\3\2\2\2x\u02b8\3\2\2\2z\u02bf\3\2\2\2|\u02c9\3\2\2\2~\u02cf\3\2\2\2\u0080"+
		"\u02d1\3\2\2\2\u0082\u02d3\3\2\2\2\u0084\u02d5\3\2\2\2\u0086\u02da\3\2"+
		"\2\2\u0088\u02de\3\2\2\2\u008a\u02e0\3\2\2\2\u008c\u02eb\3\2\2\2\u008e"+
		"\u02f7\3\2\2\2\u0090\u0300\3\2\2\2\u0092\u030a\3\2\2\2\u0094\u0327\3\2"+
		"\2\2\u0096\u032c\3\2\2\2\u0098\u0344\3\2\2\2\u009a\u0348\3\2\2\2\u009c"+
		"\u034a\3\2\2\2\u009e\u0356\3\2\2\2\u00a0\u0358\3\2\2\2\u00a2\u035d\3\2"+
		"\2\2\u00a4\u0365\3\2\2\2\u00a6\u0367\3\2\2\2\u00a8\u036e\3\2\2\2\u00aa"+
		"\u0379\3\2\2\2\u00ac\u0381\3\2\2\2\u00ae\u0386\3\2\2\2\u00b0\u03f9\3\2"+
		"\2\2\u00b2\u03fd\3\2\2\2\u00b4\u0404\3\2\2\2\u00b6\u0406\3\2\2\2\u00b8"+
		"\u0414\3\2\2\2\u00ba\u0419\3\2\2\2\u00bc\u0428\3\2\2\2\u00be\u042f\3\2"+
		"\2\2\u00c0\u0431\3\2\2\2\u00c2\u0435\3\2\2\2\u00c4\u00c5\58\35\2\u00c5"+
		"\u00c6\7\2\2\3\u00c6\u00ce\3\2\2\2\u00c7\u00c8\5@!\2\u00c8\u00c9\7\2\2"+
		"\3\u00c9\u00ce\3\2\2\2\u00ca\u00cb\5\"\22\2\u00cb\u00cc\7\2\2\3\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00ca\3\2"+
		"\2\2\u00ce\3\3\2\2\2\u00cf\u00d0\58\35\2\u00d0\u00d1\7\2\2\3\u00d1\u00d6"+
		"\3\2\2\2\u00d2\u00d3\5@!\2\u00d3\u00d4\7\2\2\3\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00cf\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d6\5\3\2\2\2\u00d7\u00d8\5\b\5\2"+
		"\u00d8\u00d9\7\2\2\3\u00d9\7\3\2\2\2\u00da\u00db\5\64\33\2\u00db\u00dc"+
		"\7X\2\2\u00dc\u00dd\5.\30\2\u00dd\u00ec\3\2\2\2\u00de\u00df\6\5\2\2\u00df"+
		"\u00e0\5\66\34\2\u00e0\u00e1\7X\2\2\u00e1\u00e2\5.\30\2\u00e2\u00ec\3"+
		"\2\2\2\u00e3\u00ec\5@!\2\u00e4\u00e5\7E\2\2\u00e5\u00e6\7\3\2\2\u00e6"+
		"\u00e7\5\n\6\2\u00e7\u00e8\7F\2\2\u00e8\u00e9\5\f\7\2\u00e9\u00ea\7\4"+
		"\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00da\3\2\2\2\u00eb\u00de\3\2\2\2\u00eb"+
		"\u00e3\3\2\2\2\u00eb\u00e4\3\2\2\2\u00ec\t\3\2\2\2\u00ed\u00ee\5\64\33"+
		"\2\u00ee\u00ef\7X\2\2\u00ef\u00f0\5.\30\2\u00f0\u00fc\3\2\2\2\u00f1\u00f2"+
		"\6\6\3\2\u00f2\u00f3\7E\2\2\u00f3\u00f4\7\3\2\2\u00f4\u00f5\5\u00c2b\2"+
		"\u00f5\u00f6\7F\2\2\u00f6\u00f7\5\f\7\2\u00f7\u00f8\7\4\2\2\u00f8\u00f9"+
		"\7X\2\2\u00f9\u00fa\5\64\33\2\u00fa\u00fc\3\2\2\2\u00fb\u00ed\3\2\2\2"+
		"\u00fb\u00f1\3\2\2\2\u00fc\13\3\2\2\2\u00fd\u00fe\5\u00c2b\2\u00fe\r\3"+
		"\2\2\2\u00ff\u0100\5 \21\2\u0100\u0101\7\2\2\3\u0101\17\3\2\2\2\u0102"+
		"\u0103\5 \21\2\u0103\u0104\7\2\2\3\u0104\21\3\2\2\2\u0105\u0106\5F$\2"+
		"\u0106\23\3\2\2\2\u0107\u0108\5L\'\2\u0108\25\3\2\2\2\u0109\u010a\5T+"+
		"\2\u010a\27\3\2\2\2\u010b\u010c\5\u00be`\2\u010c\31\3\2\2\2\u010d\u010e"+
		"\5\u0098M\2\u010e\33\3\2\2\2\u010f\u0113\5\u009aN\2\u0110\u0113\58\35"+
		"\2\u0111\u0113\5@!\2\u0112\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0111"+
		"\3\2\2\2\u0113\35\3\2\2\2\u0114\u0115\5\u008aF\2\u0115\37\3\2\2\2\u0116"+
		"\u011a\5(\25\2\u0117\u011a\5F$\2\u0118\u011a\5B\"\2\u0119\u0116\3\2\2"+
		"\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a!\3\2\2\2\u011b\u011c"+
		"\7\16\2\2\u011c\u011d\7\3\2\2\u011d\u011e\5> \2\u011e\u011f\7\4\2\2\u011f"+
		"\u0126\3\2\2\2\u0120\u0121\7\17\2\2\u0121\u0122\7\3\2\2\u0122\u0123\5"+
		"> \2\u0123\u0124\7\4\2\2\u0124\u0126\3\2\2\2\u0125\u011b\3\2\2\2\u0125"+
		"\u0120\3\2\2\2\u0126#\3\2\2\2\u0127\u0130\3\2\2\2\u0128\u0129\7E\2\2\u0129"+
		"\u012a\7\3\2\2\u012a\u012b\5\"\22\2\u012b\u012c\7F\2\2\u012c\u012d\5\f"+
		"\7\2\u012d\u012e\7\4\2\2\u012e\u0130\3\2\2\2\u012f\u0127\3\2\2\2\u012f"+
		"\u0128\3\2\2\2\u0130%\3\2\2\2\u0131\u0132\7\20\2\2\u0132\u0133\7\3\2\2"+
		"\u0133\u0134\5> \2\u0134\u0135\7\4\2\2\u0135\u0138\3\2\2\2\u0136\u0138"+
		"\5\"\22\2\u0137\u0131\3\2\2\2\u0137\u0136\3\2\2\2\u0138\'\3\2\2\2\u0139"+
		"\u013e\5&\24\2\u013a\u013e\5$\23\2\u013b\u013e\58\35\2\u013c\u013e\5@"+
		"!\2\u013d\u0139\3\2\2\2\u013d\u013a\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013c\3\2\2\2\u013e)\3\2\2\2\u013f\u0142\5.\30\2\u0140\u0142\5\"\22\2"+
		"\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142+\3\2\2\2\u0143\u0144\5"+
		"\u00c2b\2\u0144-\3\2\2\2\u0145\u0148\5,\27\2\u0146\u0148\5\60\31\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148/\3\2\2\2\u0149\u014a\5,\27\2"+
		"\u014a\u014b\7\5\2\2\u014b\u014c\7K\2\2\u014c\u014d\7\6\2\2\u014d\u0163"+
		"\3\2\2\2\u014e\u014f\5,\27\2\u014f\u0150\7\5\2\2\u0150\u0151\58\35\2\u0151"+
		"\u0152\7\6\2\2\u0152\u0163\3\2\2\2\u0153\u0154\5,\27\2\u0154\u0155\7\5"+
		"\2\2\u0155\u0156\5@!\2\u0156\u0157\7\6\2\2\u0157\u0163\3\2\2\2\u0158\u0159"+
		"\5,\27\2\u0159\u015a\7\5\2\2\u015a\u015b\7W\2\2\u015b\u015c\7\6\2\2\u015c"+
		"\u0163\3\2\2\2\u015d\u015e\5,\27\2\u015e\u015f\7\5\2\2\u015f\u0160\5\u0082"+
		"B\2\u0160\u0161\7\6\2\2\u0161\u0163\3\2\2\2\u0162\u0149\3\2\2\2\u0162"+
		"\u014e\3\2\2\2\u0162\u0153\3\2\2\2\u0162\u0158\3\2\2\2\u0162\u015d\3\2"+
		"\2\2\u0163\61\3\2\2\2\u0164\u0167\5\64\33\2\u0165\u0167\5\66\34\2\u0166"+
		"\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167\63\3\2\2\2\u0168\u016d\5*\26"+
		"\2\u0169\u016a\7X\2\2\u016a\u016c\5.\30\2\u016b\u0169\3\2\2\2\u016c\u016f"+
		"\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\65\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u0170\u0171\7E\2\2\u0171\u0172\7\3\2\2\u0172\u0173\5\62"+
		"\32\2\u0173\u0174\7F\2\2\u0174\u0175\5\f\7\2\u0175\u017a\7\4\2\2\u0176"+
		"\u0177\7X\2\2\u0177\u0179\5.\30\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2"+
		"\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\67\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017d\u0182\5<\37\2\u017e\u017f\6\35\4\2\u017f\u0182\5H%\2\u0180"+
		"\u0182\5J&\2\u0181\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181\u0180\3\2\2"+
		"\2\u01829\3\2\2\2\u0183\u0187\5<\37\2\u0184\u0185\6\36\5\2\u0185\u0187"+
		"\5H%\2\u0186\u0183\3\2\2\2\u0186\u0184\3\2\2\2\u0187;\3\2\2\2\u0188\u0189"+
		"\5\62\32\2\u0189\u018a\7X\2\2\u018a\u018b\5.\30\2\u018b=\3\2\2\2\u018c"+
		"\u018f\5@!\2\u018d\u018f\5<\37\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2"+
		"\2\u018f?\3\2\2\2\u0190\u0191\5*\26\2\u0191A\3\2\2\2\u0192\u0193\t\2\2"+
		"\2\u0193\u0195\7\3\2\2\u0194\u0196\7\26\2\2\u0195\u0194\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\5D#\2\u0198\u0199\7\4\2"+
		"\2\u0199\u019f\3\2\2\2\u019a\u019b\7\25\2\2\u019b\u019c\7\3\2\2\u019c"+
		"\u019d\7H\2\2\u019d\u019f\7\4\2\2\u019e\u0192\3\2\2\2\u019e\u019a\3\2"+
		"\2\2\u019fC\3\2\2\2\u01a0\u01a4\5@!\2\u01a1\u01a4\5<\37\2\u01a2\u01a4"+
		"\5F$\2\u01a3\u01a0\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4"+
		"E\3\2\2\2\u01a5\u01ae\5z>\2\u01a6\u01ae\5L\'\2\u01a7\u01ae\5T+\2\u01a8"+
		"\u01ae\5Z.\2\u01a9\u01ae\5V,\2\u01aa\u01ae\5X-\2\u01ab\u01ae\5`\61\2\u01ac"+
		"\u01ae\5t;\2\u01ad\u01a5\3\2\2\2\u01ad\u01a6\3\2\2\2\u01ad\u01a7\3\2\2"+
		"\2\u01ad\u01a8\3\2\2\2\u01ad\u01a9\3\2\2\2\u01ad\u01aa\3\2\2\2\u01ad\u01ab"+
		"\3\2\2\2\u01ad\u01ac\3\2\2\2\u01aeG\3\2\2\2\u01af\u01b0\7G\2\2\u01b0\u01b1"+
		"\7\3\2\2\u01b1\u01b2\5(\25\2\u01b2\u01b3\7\4\2\2\u01b3I\3\2\2\2\u01b4"+
		"\u01b5\7Z\2\2\u01b5\u01be\7\3\2\2\u01b6\u01bb\5 \21\2\u01b7\u01b8\7\7"+
		"\2\2\u01b8\u01ba\5 \21\2\u01b9\u01b7\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bf\3\2\2\2\u01bd\u01bb\3\2"+
		"\2\2\u01be\u01b6\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c1\7\4\2\2\u01c1K\3\2\2\2\u01c2\u01c3\b\'\1\2\u01c3\u01c4\5N(\2\u01c4"+
		"\u01ca\3\2\2\2\u01c5\u01c6\f\3\2\2\u01c6\u01c7\7Q\2\2\u01c7\u01c9\5N("+
		"\2\u01c8\u01c5\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb"+
		"\3\2\2\2\u01cbM\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01ce\b(\1\2\u01ce\u01cf"+
		"\5P)\2\u01cf\u01d5\3\2\2\2\u01d0\u01d1\f\3\2\2\u01d1\u01d2\t\3\2\2\u01d2"+
		"\u01d4\5P)\2\u01d3\u01d0\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2"+
		"\2\u01d5\u01d6\3\2\2\2\u01d6O\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da"+
		"\7Q\2\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dc\5R*\2\u01dcQ\3\2\2\2\u01dd\u01ea\58\35\2\u01de\u01ea\5@!\2\u01df"+
		"\u01ea\5\u0080A\2\u01e0\u01e1\7\3\2\2\u01e1\u01e2\5L\'\2\u01e2\u01e3\7"+
		"\4\2\2\u01e3\u01ea\3\2\2\2\u01e4\u01ea\7K\2\2\u01e5\u01ea\5h\65\2\u01e6"+
		"\u01ea\5B\"\2\u01e7\u01ea\5t;\2\u01e8\u01ea\5p9\2\u01e9\u01dd\3\2\2\2"+
		"\u01e9\u01de\3\2\2\2\u01e9\u01df\3\2\2\2\u01e9\u01e0\3\2\2\2\u01e9\u01e4"+
		"\3\2\2\2\u01e9\u01e5\3\2\2\2\u01e9\u01e6\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9"+
		"\u01e8\3\2\2\2\u01eaS\3\2\2\2\u01eb\u01f4\58\35\2\u01ec\u01f4\5@!\2\u01ed"+
		"\u01f4\5\u0082B\2\u01ee\u01f4\7K\2\2\u01ef\u01f4\5l\67\2\u01f0\u01f4\5"+
		"B\"\2\u01f1\u01f4\5t;\2\u01f2\u01f4\5p9\2\u01f3\u01eb\3\2\2\2\u01f3\u01ec"+
		"\3\2\2\2\u01f3\u01ed\3\2\2\2\u01f3\u01ee\3\2\2\2\u01f3\u01ef\3\2\2\2\u01f3"+
		"\u01f0\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4U\3\2\2\2"+
		"\u01f5\u01fe\58\35\2\u01f6\u01fe\5@!\2\u01f7\u01fe\7K\2\2\u01f8\u01fe"+
		"\5j\66\2\u01f9\u01fe\5B\"\2\u01fa\u01fe\5t;\2\u01fb\u01fe\5p9\2\u01fc"+
		"\u01fe\5\u0086D\2\u01fd\u01f5\3\2\2\2\u01fd\u01f6\3\2\2\2\u01fd\u01f7"+
		"\3\2\2\2\u01fd\u01f8\3\2\2\2\u01fd\u01f9\3\2\2\2\u01fd\u01fa\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fd\u01fc\3\2\2\2\u01feW\3\2\2\2\u01ff\u0206\58\35\2"+
		"\u0200\u0206\5@!\2\u0201\u0206\5\u0084C\2\u0202\u0206\7K\2\2\u0203\u0206"+
		"\5t;\2\u0204\u0206\5p9\2\u0205\u01ff\3\2\2\2\u0205\u0200\3\2\2\2\u0205"+
		"\u0201\3\2\2\2\u0205\u0202\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2"+
		"\2\2\u0206Y\3\2\2\2\u0207\u020c\58\35\2\u0208\u020c\5@!\2\u0209\u020c"+
		"\7K\2\2\u020a\u020c\5t;\2\u020b\u0207\3\2\2\2\u020b\u0208\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020b\u020a\3\2\2\2\u020c[\3\2\2\2\u020d\u0210\5:\36\2"+
		"\u020e\u0210\5^\60\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210]\3"+
		"\2\2\2\u0211\u0214\5\u00c2b\2\u0212\u0214\7K\2\2\u0213\u0211\3\2\2\2\u0213"+
		"\u0212\3\2\2\2\u0214_\3\2\2\2\u0215\u0218\5d\63\2\u0216\u0218\7K\2\2\u0217"+
		"\u0215\3\2\2\2\u0217\u0216\3\2\2\2\u0218a\3\2\2\2\u0219\u0223\5`\61\2"+
		"\u021a\u021f\5\u00c2b\2\u021b\u021c\7X\2\2\u021c\u021e\5\u00c2b\2\u021d"+
		"\u021b\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2"+
		"\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0219\3\2\2\2\u0222"+
		"\u021a\3\2\2\2\u0223c\3\2\2\2\u0224\u0225\7\31\2\2\u0225\u0226\7\3\2\2"+
		"\u0226\u0227\5f\64\2\u0227\u0228\7\4\2\2\u0228e\3\2\2\2\u0229\u022e\7"+
		"K\2\2\u022a\u022e\5:\36\2\u022b\u022e\5@!\2\u022c\u022e\5\"\22\2\u022d"+
		"\u0229\3\2\2\2\u022d\u022a\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022c\3\2"+
		"\2\2\u022eg\3\2\2\2\u022f\u0230\7\32\2\2\u0230\u0231\7\3\2\2\u0231\u0232"+
		"\5T+\2\u0232\u0233\7\4\2\2\u0233\u025b\3\2\2\2\u0234\u0235\7\33\2\2\u0235"+
		"\u0236\7\3\2\2\u0236\u0237\5T+\2\u0237\u0238\7\7\2\2\u0238\u023b\5T+\2"+
		"\u0239\u023a\7\7\2\2\u023a\u023c\5L\'\2\u023b\u0239\3\2\2\2\u023b\u023c"+
		"\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e\7\4\2\2\u023e\u025b\3\2\2\2\u023f"+
		"\u0240\7\34\2\2\u0240\u0241\7\3\2\2\u0241\u0242\5L\'\2\u0242\u0243\7\4"+
		"\2\2\u0243\u025b\3\2\2\2\u0244\u0245\7\35\2\2\u0245\u0246\7\3\2\2\u0246"+
		"\u0247\5L\'\2\u0247\u0248\7\4\2\2\u0248\u025b\3\2\2\2\u0249\u024a\7\36"+
		"\2\2\u024a\u024b\7\3\2\2\u024b\u024c\5L\'\2\u024c\u024d\7\7\2\2\u024d"+
		"\u024e\5L\'\2\u024e\u024f\7\4\2\2\u024f\u025b\3\2\2\2\u0250\u0251\7=\2"+
		"\2\u0251\u0252\7\3\2\2\u0252\u0253\5> \2\u0253\u0254\7\4\2\2\u0254\u025b"+
		"\3\2\2\2\u0255\u0256\7\37\2\2\u0256\u0257\7\3\2\2\u0257\u0258\5> \2\u0258"+
		"\u0259\7\4\2\2\u0259\u025b\3\2\2\2\u025a\u022f\3\2\2\2\u025a\u0234\3\2"+
		"\2\2\u025a\u023f\3\2\2\2\u025a\u0244\3\2\2\2\u025a\u0249\3\2\2\2\u025a"+
		"\u0250\3\2\2\2\u025a\u0255\3\2\2\2\u025bi\3\2\2\2\u025c\u025d\t\4\2\2"+
		"\u025dk\3\2\2\2\u025e\u025f\7#\2\2\u025f\u0260\7\3\2\2\u0260\u0261\5T"+
		"+\2\u0261\u0262\7\7\2\2\u0262\u0267\5T+\2\u0263\u0264\7\7\2\2\u0264\u0266"+
		"\5T+\2\u0265\u0263\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u026a\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u026b\7\4"+
		"\2\2\u026b\u0290\3\2\2\2\u026c\u026d\7$\2\2\u026d\u026e\7\3\2\2\u026e"+
		"\u026f\5T+\2\u026f\u0270\7\7\2\2\u0270\u0273\5L\'\2\u0271\u0272\7\7\2"+
		"\2\u0272\u0274\5L\'\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0275"+
		"\3\2\2\2\u0275\u0276\7\4\2\2\u0276\u0290\3\2\2\2\u0277\u0278\7%\2\2\u0278"+
		"\u0280\7\3\2\2\u0279\u027b\5n8\2\u027a\u0279\3\2\2\2\u027a\u027b\3\2\2"+
		"\2\u027b\u027d\3\2\2\2\u027c\u027e\5\u0088E\2\u027d\u027c\3\2\2\2\u027d"+
		"\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0281\7(\2\2\u0280\u027a\3\2"+
		"\2\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\5T+\2\u0283\u0284"+
		"\7\4\2\2\u0284\u0290\3\2\2\2\u0285\u0286\7&\2\2\u0286\u0287\7\3\2\2\u0287"+
		"\u0288\5T+\2\u0288\u0289\7\4\2\2\u0289\u0290\3\2\2\2\u028a\u028b\7\'\2"+
		"\2\u028b\u028c\7\3\2\2\u028c\u028d\5T+\2\u028d\u028e\7\4\2\2\u028e\u0290"+
		"\3\2\2\2\u028f\u025e\3\2\2\2\u028f\u026c\3\2\2\2\u028f\u0277\3\2\2\2\u028f"+
		"\u0285\3\2\2\2\u028f\u028a\3\2\2\2\u0290m\3\2\2\2\u0291\u0292\t\5\2\2"+
		"\u0292o\3\2\2\2\u0293\u0294\7,\2\2\u0294\u0295\7\3\2\2\u0295\u029a\5\u0082"+
		"B\2\u0296\u0297\7\7\2\2\u0297\u0299\5r:\2\u0298\u0296\3\2\2\2\u0299\u029c"+
		"\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d\3\2\2\2\u029c"+
		"\u029a\3\2\2\2\u029d\u029e\7\4\2\2\u029eq\3\2\2\2\u029f\u02a4\58\35\2"+
		"\u02a0\u02a4\5~@\2\u02a1\u02a4\7K\2\2\u02a2\u02a4\5F$\2\u02a3\u029f\3"+
		"\2\2\2\u02a3\u02a0\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3\u02a2\3\2\2\2\u02a4"+
		"s\3\2\2\2\u02a5\u02ac\5v<\2\u02a6\u02ac\5x=\2\u02a7\u02a8\6;\b\2\u02a8"+
		"\u02ac\5\u00b6\\\2\u02a9\u02aa\6;\t\2\u02aa\u02ac\5\u00ba^\2\u02ab\u02a5"+
		"\3\2\2\2\u02ab\u02a6\3\2\2\2\u02ab\u02a7\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ac"+
		"u\3\2\2\2\u02ad\u02ae\7-\2\2\u02ae\u02af\7\3\2\2\u02af\u02b2\5F$\2\u02b0"+
		"\u02b1\7\7\2\2\u02b1\u02b3\5F$\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4\3\2\2"+
		"\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b7"+
		"\7\4\2\2\u02b7w\3\2\2\2\u02b8\u02b9\7.\2\2\u02b9\u02ba\7\3\2\2\u02ba\u02bb"+
		"\5F$\2\u02bb\u02bc\7\7\2\2\u02bc\u02bd\5F$\2\u02bd\u02be\7\4\2\2\u02be"+
		"y\3\2\2\2\u02bf\u02c0\7\67\2\2\u02c0{\3\2\2\2\u02c1\u02ca\5~@\2\u02c2"+
		"\u02c5\5\u00c2b\2\u02c3\u02c4\7X\2\2\u02c4\u02c6\5\u00c2b\2\u02c5\u02c3"+
		"\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8"+
		"\u02ca\3\2\2\2\u02c9\u02c1\3\2\2\2\u02c9\u02c2\3\2\2\2\u02ca}\3\2\2\2"+
		"\u02cb\u02d0\5\u0084C\2\u02cc\u02d0\5\u0080A\2\u02cd\u02d0\5\u0082B\2"+
		"\u02ce\u02d0\5\u0086D\2\u02cf\u02cb\3\2\2\2\u02cf\u02cc\3\2\2\2\u02cf"+
		"\u02cd\3\2\2\2\u02cf\u02ce\3\2\2\2\u02d0\177\3\2\2\2\u02d1\u02d2\t\6\2"+
		"\2\u02d2\u0081\3\2\2\2\u02d3\u02d4\t\7\2\2\u02d4\u0083\3\2\2\2\u02d5\u02d6"+
		"\7O\2\2\u02d6\u0085\3\2\2\2\u02d7\u02db\7L\2\2\u02d8\u02db\7M\2\2\u02d9"+
		"\u02db\7N\2\2\u02da\u02d7\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02d9\3\2"+
		"\2\2\u02db\u0087\3\2\2\2\u02dc\u02df\5\u0082B\2\u02dd\u02df\7K\2\2\u02de"+
		"\u02dc\3\2\2\2\u02de\u02dd\3\2\2\2\u02df\u0089\3\2\2\2\u02e0\u02e1\bF"+
		"\1\2\u02e1\u02e2\5\u008cG\2\u02e2\u02e8\3\2\2\2\u02e3\u02e4\f\3\2\2\u02e4"+
		"\u02e5\7\60\2\2\u02e5\u02e7\5\u008cG\2\u02e6\u02e3\3\2\2\2\u02e7\u02ea"+
		"\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u008b\3\2\2\2\u02ea"+
		"\u02e8\3\2\2\2\u02eb\u02ec\bG\1\2\u02ec\u02ed\5\u008eH\2\u02ed\u02f3\3"+
		"\2\2\2\u02ee\u02ef\f\3\2\2\u02ef\u02f0\7\61\2\2\u02f0\u02f2\5\u008eH\2"+
		"\u02f1\u02ee\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4"+
		"\3\2\2\2\u02f4\u008d\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f6\u02f8\7/\2\2\u02f7"+
		"\u02f6\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa\5\u0090"+
		"I\2\u02fa\u008f\3\2\2\2\u02fb\u0301\5\u0092J\2\u02fc\u02fd\7\3\2\2\u02fd"+
		"\u02fe\5\u008aF\2\u02fe\u02ff\7\4\2\2\u02ff\u0301\3\2\2\2\u0300\u02fb"+
		"\3\2\2\2\u0300\u02fc\3\2\2\2\u0301\u0091\3\2\2\2\u0302\u030b\5\u00b0Y"+
		"\2\u0303\u030b\5\u0094K\2\u0304\u030b\5\u009cO\2\u0305\u030b\5\u0096L"+
		"\2\u0306\u030b\5\u00a2R\2\u0307\u030b\5\u00a6T\2\u0308\u030b\5\u00a8U"+
		"\2\u0309\u030b\5\u00aaV\2\u030a\u0302\3\2\2\2\u030a\u0303\3\2\2\2\u030a"+
		"\u0304\3\2\2\2\u030a\u0305\3\2\2\2\u030a\u0306\3\2\2\2\u030a\u0307\3\2"+
		"\2\2\u030a\u0308\3\2\2\2\u030a\u0309\3\2\2\2\u030b\u0093\3\2\2\2\u030c"+
		"\u030e\5L\'\2\u030d\u030f\7/\2\2\u030e\u030d\3\2\2\2\u030e\u030f\3\2\2"+
		"\2\u030f\u0310\3\2\2\2\u0310\u0311\7\62\2\2\u0311\u0312\5L\'\2\u0312\u0313"+
		"\7\61\2\2\u0313\u0314\5L\'\2\u0314\u0328\3\2\2\2\u0315\u0317\5T+\2\u0316"+
		"\u0318\7/\2\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u031a\7\62\2\2\u031a\u031b\5T+\2\u031b\u031c\7\61\2\2\u031c"+
		"\u031d\5T+\2\u031d\u0328\3\2\2\2\u031e\u0320\5V,\2\u031f\u0321\7/\2\2"+
		"\u0320\u031f\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0323"+
		"\7\62\2\2\u0323\u0324\5V,\2\u0324\u0325\7\61\2\2\u0325\u0326\5V,\2\u0326"+
		"\u0328\3\2\2\2\u0327\u030c\3\2\2\2\u0327\u0315\3\2\2\2\u0327\u031e\3\2"+
		"\2\2\u0328\u0095\3\2\2\2\u0329\u032d\7Z\2\2\u032a\u032d\58\35\2\u032b"+
		"\u032d\5d\63\2\u032c\u0329\3\2\2\2\u032c\u032a\3\2\2\2\u032c\u032b\3\2"+
		"\2\2\u032d\u032f\3\2\2\2\u032e\u0330\7/\2\2\u032f\u032e\3\2\2\2\u032f"+
		"\u0330\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0340\7\63\2\2\u0332\u0333\7"+
		"\3\2\2\u0333\u0338\5\u0098M\2\u0334\u0335\7\7\2\2\u0335\u0337\5\u0098"+
		"M\2\u0336\u0334\3\2\2\2\u0337\u033a\3\2\2\2\u0338\u0336\3\2\2\2\u0338"+
		"\u0339\3\2\2\2\u0339\u033b\3\2\2\2\u033a\u0338\3\2\2\2\u033b\u033c\7\4"+
		"\2\2\u033c\u0341\3\2\2\2\u033d\u0341\7K\2\2\u033e\u0341\58\35\2\u033f"+
		"\u0341\5@!\2\u0340\u0332\3\2\2\2\u0340\u033d\3\2\2\2\u0340\u033e\3\2\2"+
		"\2\u0340\u033f\3\2\2\2\u0341\u0097\3\2\2\2\u0342\u0345\5|?\2\u0343\u0345"+
		"\7K\2\2\u0344\u0342\3\2\2\2\u0344\u0343\3\2\2\2\u0345\u0099\3\2\2\2\u0346"+
		"\u0349\5~@\2\u0347\u0349\7K\2\2\u0348\u0346\3\2\2\2\u0348\u0347\3\2\2"+
		"\2\u0349\u009b\3\2\2\2\u034a\u034c\5T+\2\u034b\u034d\7/\2\2\u034c\u034b"+
		"\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\7\64\2\2"+
		"\u034f\u0352\5\u009eP\2\u0350\u0351\7\65\2\2\u0351\u0353\5\u00a0Q\2\u0352"+
		"\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u009d\3\2\2\2\u0354\u0357\5\u0082"+
		"B\2\u0355\u0357\7K\2\2\u0356\u0354\3\2\2\2\u0356\u0355\3\2\2\2\u0357\u009f"+
		"\3\2\2\2\u0358\u0359\t\b\2\2\u0359\u00a1\3\2\2\2\u035a\u035e\5(\25\2\u035b"+
		"\u035e\7K\2\2\u035c\u035e\5\u00a4S\2\u035d\u035a\3\2\2\2\u035d\u035b\3"+
		"\2\2\2\u035d\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0361\7\66\2\2\u0360"+
		"\u0362\7/\2\2\u0361\u0360\3\2\2\2\u0361\u0362\3\2\2\2\u0362\u0363\3\2"+
		"\2\2\u0363\u0364\7\67\2\2\u0364\u00a3\3\2\2\2\u0365\u0366\5F$\2\u0366"+
		"\u00a5\3\2\2\2\u0367\u0368\5> \2\u0368\u036a\7\66\2\2\u0369\u036b\7/\2"+
		"\2\u036a\u0369\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036d"+
		"\7B\2\2\u036d\u00a7\3\2\2\2\u036e\u0370\5\u00acW\2\u036f\u0371\7/\2\2"+
		"\u0370\u036f\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0374"+
		"\7C\2\2\u0373\u0375\7D\2\2\u0374\u0373\3\2\2\2\u0374\u0375\3\2\2\2\u0375"+
		"\u0376\3\2\2\2\u0376\u0377\5> \2\u0377\u00a9\3\2\2\2\u0378\u037a\7/\2"+
		"\2\u0379\u0378\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037c"+
		"\7A\2\2\u037c\u037d\5\u00c2b\2\u037d\u00ab\3\2\2\2\u037e\u0382\58\35\2"+
		"\u037f\u0382\5\u00aeX\2\u0380\u0382\5@!\2\u0381\u037e\3\2\2\2\u0381\u037f"+
		"\3\2\2\2\u0381\u0380\3\2\2\2\u0382\u00ad\3\2\2\2\u0383\u0387\5\u00c2b"+
		"\2\u0384\u0387\7K\2\2\u0385\u0387\5~@\2\u0386\u0383\3\2\2\2\u0386\u0384"+
		"\3\2\2\2\u0386\u0385\3\2\2\2\u0387\u00af\3\2\2\2\u0388\u0389\5T+\2\u0389"+
		"\u038a\5\u00b4[\2\u038a\u038b\5T+\2\u038b\u03fa\3\2\2\2\u038c\u038d\6"+
		"Y\f\2\u038d\u038e\5T+\2\u038e\u038f\5\u00b4[\2\u038f\u0395\t\t\2\2\u0390"+
		"\u0391\7\3\2\2\u0391\u0392\5\u00c2b\2\u0392\u0393\7\4\2\2\u0393\u0396"+
		"\3\2\2\2\u0394\u0396\5\u00c2b\2\u0395\u0390\3\2\2\2\u0395\u0394\3\2\2"+
		"\2\u0396\u03fa\3\2\2\2\u0397\u0398\5X-\2\u0398\u0399\5\u00b2Z\2\u0399"+
		"\u039a\5X-\2\u039a\u03fa\3\2\2\2\u039b\u039c\6Y\r\2\u039c\u039d\5X-\2"+
		"\u039d\u039e\5\u00b2Z\2\u039e\u03a4\t\t\2\2\u039f\u03a0\7\3\2\2\u03a0"+
		"\u03a1\5\u00c2b\2\u03a1\u03a2\7\4\2\2\u03a2\u03a5\3\2\2\2\u03a3\u03a5"+
		"\5\u00c2b\2\u03a4\u039f\3\2\2\2\u03a4\u03a3\3\2\2\2\u03a5\u03fa\3\2\2"+
		"\2\u03a6\u03a7\5Z.\2\u03a7\u03a8\5\u00b2Z\2\u03a8\u03a9\5Z.\2\u03a9\u03fa"+
		"\3\2\2\2\u03aa\u03ab\6Y\16\2\u03ab\u03ac\5V,\2\u03ac\u03ad\5\u00b4[\2"+
		"\u03ad\u03b3\t\t\2\2\u03ae\u03af\7\3\2\2\u03af\u03b0\5\u00c2b\2\u03b0"+
		"\u03b1\7\4\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b4\5\u00c2b\2\u03b3\u03ae"+
		"\3\2\2\2\u03b3\u03b2\3\2\2\2\u03b4\u03fa\3\2\2\2\u03b5\u03b6\5V,\2\u03b6"+
		"\u03b7\5\u00b4[\2\u03b7\u03b8\5V,\2\u03b8\u03fa\3\2\2\2\u03b9\u03ba\6"+
		"Y\17\2\u03ba\u03bb\5V,\2\u03bb\u03bc\5\u00b4[\2\u03bc\u03c2\t\t\2\2\u03bd"+
		"\u03be\7\3\2\2\u03be\u03bf\5\u00c2b\2\u03bf\u03c0\7\4\2\2\u03c0\u03c3"+
		"\3\2\2\2\u03c1\u03c3\5\u00c2b\2\u03c2\u03bd\3\2\2\2\u03c2\u03c1\3\2\2"+
		"\2\u03c3\u03fa\3\2\2\2\u03c4\u03c5\5\\/\2\u03c5\u03c6\5\u00b2Z\2\u03c6"+
		"\u03c7\5\\/\2\u03c7\u03fa\3\2\2\2\u03c8\u03c9\6Y\20\2\u03c9\u03ca\5\\"+
		"/\2\u03ca\u03cb\5\u00b2Z\2\u03cb\u03d1\t\t\2\2\u03cc\u03cd\7\3\2\2\u03cd"+
		"\u03ce\5\u00c2b\2\u03ce\u03cf\7\4\2\2\u03cf\u03d2\3\2\2\2\u03d0\u03d2"+
		"\5\u00c2b\2\u03d1\u03cc\3\2\2\2\u03d1\u03d0\3\2\2\2\u03d2\u03fa\3\2\2"+
		"\2\u03d3\u03d4\5L\'\2\u03d4\u03d5\5\u00b4[\2\u03d5\u03d6\5L\'\2\u03d6"+
		"\u03fa\3\2\2\2\u03d7\u03d8\6Y\21\2\u03d8\u03d9\5L\'\2\u03d9\u03da\5\u00b4"+
		"[\2\u03da\u03e0\t\t\2\2\u03db\u03dc\7\3\2\2\u03dc\u03dd\5\u00c2b\2\u03dd"+
		"\u03de\7\4\2\2\u03de\u03e1\3\2\2\2\u03df\u03e1\5\u00c2b\2\u03e0\u03db"+
		"\3\2\2\2\u03e0\u03df\3\2\2\2\u03e1\u03fa\3\2\2\2\u03e2\u03e3\5b\62\2\u03e3"+
		"\u03e4\5\u00b2Z\2\u03e4\u03e5\5b\62\2\u03e5\u03fa\3\2\2\2\u03e6\u03e7"+
		"\6Y\22\2\u03e7\u03e8\5`\61\2\u03e8\u03e9\5\u00b2Z\2\u03e9\u03ef\t\t\2"+
		"\2\u03ea\u03eb\7\3\2\2\u03eb\u03ec\5\u00c2b\2\u03ec\u03ed\7\4\2\2\u03ed"+
		"\u03f0\3\2\2\2\u03ee\u03f0\5\u00c2b\2\u03ef\u03ea\3\2\2\2\u03ef\u03ee"+
		"\3\2\2\2\u03f0\u03fa\3\2\2\2\u03f1\u03f2\5<\37\2\u03f2\u03f3\5\u00b2Z"+
		"\2\u03f3\u03f4\5d\63\2\u03f4\u03fa\3\2\2\2\u03f5\u03f6\5d\63\2\u03f6\u03f7"+
		"\5\u00b2Z\2\u03f7\u03f8\5<\37\2\u03f8\u03fa\3\2\2\2\u03f9\u0388\3\2\2"+
		"\2\u03f9\u038c\3\2\2\2\u03f9\u0397\3\2\2\2\u03f9\u039b\3\2\2\2\u03f9\u03a6"+
		"\3\2\2\2\u03f9\u03aa\3\2\2\2\u03f9\u03b5\3\2\2\2\u03f9\u03b9\3\2\2\2\u03f9"+
		"\u03c4\3\2\2\2\u03f9\u03c8\3\2\2\2\u03f9\u03d3\3\2\2\2\u03f9\u03d7\3\2"+
		"\2\2\u03f9\u03e2\3\2\2\2\u03f9\u03e6\3\2\2\2\u03f9\u03f1\3\2\2\2\u03f9"+
		"\u03f5\3\2\2\2\u03fa\u00b1\3\2\2\2\u03fb\u03fe\7\t\2\2\u03fc\u03fe\7P"+
		"\2\2\u03fd\u03fb\3\2\2\2\u03fd\u03fc\3\2\2\2\u03fe\u00b3\3\2\2\2\u03ff"+
		"\u0405\5\u00b2Z\2\u0400\u0405\7\n\2\2\u0401\u0405\7\13\2\2\u0402\u0405"+
		"\7\f\2\2\u0403\u0405\7\r\2\2\u0404\u03ff\3\2\2\2\u0404\u0400\3\2\2\2\u0404"+
		"\u0401\3\2\2\2\u0404\u0402\3\2\2\2\u0404\u0403\3\2\2\2\u0405\u00b5\3\2"+
		"\2\2\u0406\u0407\78\2\2\u0407\u040b\5\u00b8]\2\u0408\u040a\5\u00b8]\2"+
		"\u0409\u0408\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2\2\2\u040b\u040c"+
		"\3\2\2\2\u040c\u0410\3\2\2\2\u040d\u040b\3\2\2\2\u040e\u040f\79\2\2\u040f"+
		"\u0411\5F$\2\u0410\u040e\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0412\3\2\2"+
		"\2\u0412\u0413\7:\2\2\u0413\u00b7\3\2\2\2\u0414\u0415\7;\2\2\u0415\u0416"+
		"\5\u008aF\2\u0416\u0417\7<\2\2\u0417\u0418\5F$\2\u0418\u00b9\3\2\2\2\u0419"+
		"\u041a\78\2\2\u041a\u041b\5\u00be`\2\u041b\u041f\5\u00bc_\2\u041c\u041e"+
		"\5\u00bc_\2\u041d\u041c\3\2\2\2\u041e\u0421\3\2\2\2\u041f\u041d\3\2\2"+
		"\2\u041f\u0420\3\2\2\2\u0420\u0424\3\2\2\2\u0421\u041f\3\2\2\2\u0422\u0423"+
		"\79\2\2\u0423\u0425\5F$\2\u0424\u0422\3\2\2\2\u0424\u0425\3\2\2\2\u0425"+
		"\u0426\3\2\2\2\u0426\u0427\7:\2\2\u0427\u00bb\3\2\2\2\u0428\u0429\7;\2"+
		"\2\u0429\u042a\5F$\2\u042a\u042b\7<\2\2\u042b\u042c\5F$\2\u042c\u00bd"+
		"\3\2\2\2\u042d\u0430\58\35\2\u042e\u0430\5d\63\2\u042f\u042d\3\2\2\2\u042f"+
		"\u042e\3\2\2\2\u0430\u00bf\3\2\2\2\u0431\u0432\t\n\2\2\u0432\u00c1\3\2"+
		"\2\2\u0433\u0436\7Z\2\2\u0434\u0436\5\u00c0a\2\u0435\u0433\3\2\2\2\u0435"+
		"\u0434\3\2\2\2\u0436\u00c3\3\2\2\2d\u00cd\u00d5\u00eb\u00fb\u0112\u0119"+
		"\u0125\u012f\u0137\u013d\u0141\u0147\u0162\u0166\u016d\u017a\u0181\u0186"+
		"\u018e\u0195\u019e\u01a3\u01ad\u01bb\u01be\u01ca\u01d5\u01d9\u01e9\u01f3"+
		"\u01fd\u0205\u020b\u020f\u0213\u0217\u021f\u0222\u022d\u023b\u025a\u0267"+
		"\u0273\u027a\u027d\u0280\u028f\u029a\u02a3\u02ab\u02b4\u02c7\u02c9\u02cf"+
		"\u02da\u02de\u02e8\u02f3\u02f7\u0300\u030a\u030e\u0317\u0320\u0327\u032c"+
		"\u032f\u0338\u0340\u0344\u0348\u034c\u0352\u0356\u035d\u0361\u036a\u0370"+
		"\u0374\u0379\u0381\u0386\u0395\u03a4\u03b3\u03c2\u03d1\u03e0\u03ef\u03f9"+
		"\u03fd\u0404\u040b\u0410\u041f\u0424\u042f\u0435";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}