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
package spoon.reflect.path;


/**
 * This builder allow to create some CtPath from CtElements
 *
 * Created by nharrand on 21/02/2018.
 */
public class CtElementPathBuilder {
    private boolean useNamesInPath = true;

    /**
     * Build absolute path to a CtElement el.
     *
     * @throws CtPathException
     * 		is thrown when root is not a parent of el.
     * @param el
     * 		: the element to which the CtPath leads to
     * @return CtPath from model root package to el
     */
    public spoon.reflect.path.CtPath fromElement(spoon.reflect.declaration.CtElement el) throws spoon.reflect.path.CtPathException {
        return fromElement(el, el.getParent(spoon.reflect.CtModelImpl.CtRootPackage.class));
    }

    /**
     * Build path to a CtElement el, from one of its parent.
     *
     * @throws CtPathException
     * 		is thrown when root is not a parent of el.
     * @param el
     * 		: the element to which the CtPath leads to
     * @param root
     * 		: Starting point of the CtPath
     * @return CtPath from root to el
     */
    public spoon.reflect.path.CtPath fromElement(spoon.reflect.declaration.CtElement el, spoon.reflect.declaration.CtElement root) throws spoon.reflect.path.CtPathException {
        spoon.reflect.path.impl.CtPathImpl path = new spoon.reflect.path.impl.CtPathImpl();
        spoon.reflect.declaration.CtElement cur = el;
        while (cur != root) {
            spoon.reflect.declaration.CtElement parent = cur.getParent();
            spoon.reflect.path.CtRole role = cur.getRoleInParent();
            if (role == null) {
                throw new spoon.reflect.path.CtPathException();
            }
            spoon.reflect.meta.RoleHandler roleHandler = spoon.reflect.meta.impl.RoleHandlerHelper.getOptionalRoleHandler(parent.getClass(), role);
            if (roleHandler == null) {
                throw new spoon.reflect.path.CtPathException();
            }
            spoon.reflect.path.impl.CtPathElement pathElement = new spoon.reflect.path.impl.CtRolePathElement(role);
            switch (roleHandler.getContainerKind()) {
                case SINGLE :
                    break;
                case LIST :
                    {
                        // Element needs to be differentiated from its brothers
                        if (useNamesInPath) {
                            java.lang.String[] pair = getArg(cur);
                            java.lang.String attrName = pair[0];
                            java.lang.String name = pair[1];
                            if (name != null) {
                                // the path with name is more readable, so prefer name instead of index
                                if ((role.getSubRoles().size()) > 0) {
                                    // there are subroles.
                                    role = role.getMatchingSubRoleFor(cur);
                                    pathElement = new spoon.reflect.path.impl.CtRolePathElement(role);
                                }
                                pathElement.addArgument(attrName, name);
                                // check list to check if argument is unique
                                java.util.List<spoon.reflect.declaration.CtElement> list = roleHandler.asList(parent);
                                // Assumes that List's order is deterministic.
                                java.util.List<spoon.reflect.declaration.CtElement> filteredList = new java.util.ArrayList<>();
                                int index = -1;
                                for (spoon.reflect.declaration.CtElement item : list) {
                                    java.lang.String[] pair2 = getArg(item);
                                    java.lang.String attrName2 = pair2[0];
                                    java.lang.String name2 = pair2[1];
                                    if ((java.util.Objects.equals(name, name2)) && (java.util.Objects.equals(attrName, attrName2))) {
                                        // we found an element with same name
                                        if (item == cur) {
                                            // we found cur element. Remember it's index
                                            index = filteredList.size();
                                        }
                                        filteredList.add(item);
                                    }
                                }
                                if (((filteredList.size()) > 1) && (index >= 0)) {
                                    // there is more then one element with that name. Use index too
                                    pathElement.addArgument("index", java.lang.String.valueOf(index));
                                }
                                break;
                            }
                        }
                        java.util.List list = roleHandler.asList(parent);
                        // Assumes that List's order is deterministic.
                        // Can't be replaced by list.indexOf(cur)
                        // Because objects must be the same (and not just equals)
                        int index = 0;
                        for (java.lang.Object o : list) {
                            if (o == cur) {
                                break;
                            }
                            index++;
                        }
                        pathElement.addArgument("index", (index + ""));
                        break;
                    }
                case SET :
                    {
                        java.lang.String name;
                        if (cur instanceof spoon.reflect.declaration.CtNamedElement) {
                            name = ((spoon.reflect.declaration.CtNamedElement) (cur)).getSimpleName();
                        } else
                            if (cur instanceof spoon.reflect.reference.CtReference) {
                                name = ((spoon.reflect.reference.CtReference) (cur)).getSimpleName();
                            } else {
                                throw new spoon.reflect.path.CtPathException();
                            }

                        pathElement.addArgument("name", name);
                        break;
                    }
                case MAP :
                    {
                        java.util.Map map = roleHandler.asMap(parent);
                        java.lang.String key = null;
                        for (java.lang.Object o : map.keySet()) {
                            if ((map.get(o)) == cur) {
                                key = ((java.lang.String) (o));
                                break;
                            }
                        }
                        if (key == null) {
                            throw new spoon.reflect.path.CtPathException();
                        } else {
                            pathElement.addArgument("key", key);
                        }
                        break;
                    }
            }
            cur = parent;
            path.addFirst(pathElement);
        } 
        return path;
    }

    private java.lang.String[] getArg(spoon.reflect.declaration.CtElement item) {
        java.lang.String name = null;
        java.lang.String attrName = "name";
        if (item instanceof spoon.reflect.declaration.CtExecutable) {
            name = spoon.reflect.path.CtElementPathBuilder.getSignature(((spoon.reflect.declaration.CtExecutable) (item)));
            attrName = "signature";
        } else
            if (item instanceof spoon.reflect.declaration.CtNamedElement) {
                name = ((spoon.reflect.declaration.CtNamedElement) (item)).getSimpleName();
            } else
                if (item instanceof spoon.reflect.reference.CtReference) {
                    name = ((spoon.reflect.reference.CtReference) (item)).getSimpleName();
                }


        return new java.lang.String[]{ attrName, name };
    }

    private static java.lang.String getSignature(spoon.reflect.declaration.CtExecutable exec) {
        java.lang.String sign = exec.getSignature();
        if (exec instanceof spoon.reflect.declaration.CtConstructor) {
            int idx = sign.indexOf('(');
            return sign.substring(idx);
        }
        return sign;
    }

    /**
     * Configures what kind of path is generated for List based attributes<br>
     * A) #superRole[index=x] - always use index to identify item of List. For example `#typeMember[index=7]`. Such paths are fast.
     * B) #subRole[name=x] - use simpleName or signature of List item if possible. Use the most specific role too.
     * 	For example `#field[name=counter]` or `#method[signature=getCounter()]`. Such paths are more readable but slower.
     *
     * @param useNamesInPath
     * 		if true then names are used instead of index
     * @return this to support fluent API
     */
    public spoon.reflect.path.CtElementPathBuilder setUseNamesInPath(boolean useNamesInPath) {
        this.useNamesInPath = useNamesInPath;
        return this;
    }
}

