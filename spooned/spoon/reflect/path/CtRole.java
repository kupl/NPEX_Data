package spoon.reflect.path;


public enum CtRole {
NAME, TYPE, BODY, IS_SHADOW, BOUND, IS_FINAL, IS_STATIC, IS_UPPER, IS_IMPLICIT, IS_DEFAULT, IS_VARARGS, DEFAULT_EXPRESSION, THEN, ELSE, PACKAGE_REF, SUB_PACKAGE, CONDITION, RIGHT_OPERAND, LEFT_OPERAND, LABEL, CASE, OPERATOR_KIND, PARAMETER, EXPRESSION, TARGET, VARIABLE, FINALIZER, THROWN, ASSIGNMENT, ASSIGNED, MODIFIER, COMMENT, ANNOTATION_TYPE, INTERFACE, ANNOTATION, STATEMENT, ARGUMENT, SUPER_TYPE, NESTED_TYPE, CONSTRUCTOR, EXECUTABLE, FIELD, CAST, VALUE, FOR_UPDATE, FOR_INIT, TRY_RESOURCE, DIMENSION, CATCH, TARGET_LABEL, TYPE_PARAMETER, COMMENT_TAG, COMMENT_CONTENT, COMMENT_TYPE, POSITION;
    public static spoon.reflect.path.CtRole fromName(java.lang.String name) {
        name = name.toLowerCase();
        for (int i = 0; i < (spoon.reflect.path.CtRole.values().length); i++) {
            if (spoon.reflect.path.CtRole.values()[i].getCamelCaseName().toLowerCase().equals(name)) {
                return spoon.reflect.path.CtRole.values()[i];
            }
        }
        if ("implicit".equals(name)) {
            return spoon.reflect.path.CtRole.IS_IMPLICIT;
        }
        if ("varargs".equals(name)) {
            return spoon.reflect.path.CtRole.IS_VARARGS;
        }
        if ("defaultmethod".equals(name)) {
            return spoon.reflect.path.CtRole.IS_DEFAULT;
        }
        if ("block".equals(name)) {
            return spoon.reflect.path.CtRole.BODY;
        }
        if ("param".equals(name)) {
            return spoon.reflect.path.CtRole.PARAMETER;
        }
        if ("dimensionexpressions".equals(name)) {
            return spoon.reflect.path.CtRole.DIMENSION;
        }
        if ("actualtypearguments".equals(name)) {
            return spoon.reflect.path.CtRole.TYPE_PARAMETER;
        }
        if ("formalcttypeparameters".equals(name)) {
            return spoon.reflect.path.CtRole.TYPE_PARAMETER;
        }
        if ("typecasts".equals(name)) {
            return spoon.reflect.path.CtRole.CAST;
        }
        if ("cases".equals(name)) {
            return spoon.reflect.path.CtRole.CASE;
        }
        if (("enumvalues".equals(name)) || ("elementvalues".equals(name))) {
            return spoon.reflect.path.CtRole.VALUE;
        }
        if ("throwntypes".equals(name)) {
            return spoon.reflect.path.CtRole.THROWN;
        }
        if ((("value".equals(name)) || ("returnedexpression".equals(name))) || ("expressions".equals(name))) {
            return spoon.reflect.path.CtRole.EXPRESSION;
        }
        if ("asserted".equals(name)) {
            return spoon.reflect.path.CtRole.CONDITION;
        }
        if ("parameters".equals(name)) {
            return spoon.reflect.path.CtRole.PARAMETER;
        }
        if ("typemembers".equals(name)) {
            return spoon.reflect.path.CtRole.FIELD;
        }
        if ("throwexpression".equals(name)) {
            return spoon.reflect.path.CtRole.THROWN;
        }
        if (("returntype".equals(name)) || ("componenttype".equals(name))) {
            return spoon.reflect.path.CtRole.TYPE;
        }
        if ("caseexpression".equals(name)) {
            return spoon.reflect.path.CtRole.CASE;
        }
        if (("elseexpression".equals(name)) || ("elsestatement".equals(name))) {
            return spoon.reflect.path.CtRole.ELSE;
        }
        if (("thenexpression".equals(name)) || ("thenstatement".equals(name))) {
            return spoon.reflect.path.CtRole.THEN;
        }
        if ("righthandoperand".equals(name)) {
            return spoon.reflect.path.CtRole.RIGHT_OPERAND;
        }
        if ("lefthandoperand".equals(name)) {
            return spoon.reflect.path.CtRole.LEFT_OPERAND;
        }
        if (("pack".equals(name)) || ("packs".equals(name))) {
            return spoon.reflect.path.CtRole.SUB_PACKAGE;
        }
        if ("superclass".equals(name)) {
            return spoon.reflect.path.CtRole.SUPER_TYPE;
        }
        if (("name".equals(name)) || ("simplename".equals(name))) {
            return spoon.reflect.path.CtRole.NAME;
        }
        return null;
    }

    public java.lang.String getCamelCaseName() {
        java.lang.String s = name().toLowerCase();
        int i = s.indexOf("_");
        if (i != (-1)) {
            s = ((s.substring(0, i)) + (java.lang.Character.toUpperCase(s.charAt((i + 1))))) + (s.substring((i + 2)));
        }
        return s;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getCamelCaseName();
    }
}

