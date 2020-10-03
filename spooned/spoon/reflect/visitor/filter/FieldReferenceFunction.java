/**
 * Copyright (C) 2006-2018 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.visitor.filter;


/**
 * This Query expects a {@link CtField} as input
 * and returns all {@link CtFieldReference}s, which refers this input.
 * <br>
 * Usage:<br>
 * <pre> {@code
 * CtField param = ...;
 * param
 *   .map(new FieldReferenceFunction())
 *   .forEach((CtFieldReference ref)->...process references...);
 * }
 * </pre>
 */
public class FieldReferenceFunction implements spoon.reflect.visitor.chain.CtConsumableFunction<spoon.reflect.declaration.CtElement> {
    private final spoon.reflect.declaration.CtField<?> field;

    public FieldReferenceFunction() {
        this.field = null;
    }

    public FieldReferenceFunction(spoon.reflect.declaration.CtField<?> field) {
        this.field = field;
    }

    @java.lang.Override
    public void apply(spoon.reflect.declaration.CtElement fieldOrScope, spoon.reflect.visitor.chain.CtConsumer<java.lang.Object> outputConsumer) {
        spoon.reflect.declaration.CtElement scope;
        spoon.reflect.declaration.CtField<?> field = this.field;
        if (field == null) {
            if (fieldOrScope instanceof spoon.reflect.declaration.CtField) {
                field = ((spoon.reflect.declaration.CtField<?>) (fieldOrScope));
            } else {
                throw new spoon.SpoonException(("The input of FieldReferenceFunction must be a CtField but is " + (fieldOrScope.getClass().getSimpleName())));
            }
            scope = field.getFactory().getModel().getUnnamedModule();
        } else {
            scope = fieldOrScope;
        }
        scope.filterChildren(new spoon.reflect.visitor.filter.DirectReferenceFilter<spoon.reflect.reference.CtFieldReference<?>>(field.getReference())).forEach(outputConsumer);
    }
}

