/* Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */
package org.apache.felix.framework;
import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.WeakHashMap;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.hooks.bundle.CollisionHook;
import org.osgi.framework.hooks.bundle.EventHook;
import org.osgi.framework.hooks.bundle.FindHook;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import org.osgi.framework.hooks.service.EventHook;
import org.osgi.framework.hooks.service.EventListenerHook;
import org.osgi.framework.hooks.service.FindHook;
import org.osgi.framework.hooks.service.ListenerHook;
import org.osgi.framework.hooks.weaving.WeavingHook;
import org.osgi.framework.hooks.weaving.WovenClassListener;
import org.osgi.service.url.URLStreamHandlerService;
/**
 * This registry holds all services implementing one of the hook services
 */
public class HookRegistry {
    /**
     * no need to use a sync'ed structure as this is read only.
     */
    private static final Map<String, Class<?>> HOOK_CLASSES = new HashMap<String, Class<?>>();

    static {
        addHookClass(CollisionHook.class);
        addHookClass(FindHook.class);
        addHookClass(EventHook.class);
        addHookClass(EventHook.class);
        addHookClass(EventListenerHook.class);
        addHookClass(FindHook.class);
        addHookClass(ListenerHook.class);
        addHookClass(WeavingHook.class);
        addHookClass(WovenClassListener.class);
        addHookClass(ResolverHookFactory.class);
        addHookClass(URLStreamHandlerService.class);
        addHookClass(ContentHandler.class);
    }

    private static void addHookClass(final Class<?> c) {
        HOOK_CLASSES.put(c.getName(), c);
    }

    private final Map<String, Set<ServiceReference<?>>> m_allHooks = new HashMap<String, Set<ServiceReference<?>>>();

    private final WeakHashMap<ServiceReference<?>, ServiceReference<?>> m_blackList = new WeakHashMap<ServiceReference<?>, ServiceReference<?>>();

    static boolean isHook(final String[] classNames, final Class<?> hookClass, final Object svcObj) {
        for (final String serviceName : classNames) {
            if (serviceName.equals(hookClass.getName())) {
                // For a service factory, we can only match names.
                if (svcObj instanceof ServiceFactory) {
                    return true;
                }
                // For a service object, check if its class matches.
                if (hookClass.isAssignableFrom(svcObj.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isHook(final String serviceName, final Object svcObj) {
        final Class<?> hookClass = HOOK_CLASSES.get(serviceName);
        if (hookClass != null) {
            // For a service factory, we can only match names.
            if (svcObj instanceof ServiceFactory) {
                return true;
            }
            // For a service object, check if its class matches.
            if (hookClass.isAssignableFrom(svcObj.getClass())) {
                return true;
            }
        }
        return false;
    }

    public void addHooks(final String[] classNames, final Object svcObj, final ServiceReference<?> ref) {
        for (final String serviceName : classNames) {
            if (isHook(serviceName, svcObj)) {
                synchronized(m_allHooks) {
                    Set<ServiceReference<?>> hooks = m_allHooks.get(serviceName);
                    if (hooks == null) {
                        hooks = new TreeSet<ServiceReference<?>>(Collections.reverseOrder());
                        m_allHooks.put(serviceName, hooks);
                    }
                    hooks.add(ref);
                }
            }
        }
    }

    public void updateHooks(final ServiceReference<?> ref) {
        // We maintain the hooks sorted, so if ranking has changed for example,
        // we need to ensure the order remains correct by resorting the hooks.
        final Object svcObj = ((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)).getRegistration().getService();
        final String[] classNames = ((String[]) (ref.getProperty(Constants.OBJECTCLASS)));
        for (final String serviceName : classNames) {
            if (isHook(serviceName, svcObj)) {
                synchronized(m_allHooks) {
                    final Set<ServiceReference<?>> hooks = m_allHooks.get(serviceName);
                    if (hooks != null) {
                        List<ServiceReference<?>> refs = new ArrayList<ServiceReference<?>>(hooks);
                        hooks.clear();
                        hooks.addAll(refs);
                    }
                }
            }
        }
    }

    public void removeHooks(final ServiceReference<?> ref) {
        final Object svcObj = ((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)).getRegistration().getService();
        final String[] classNames = ((String[]) (ref.getProperty(Constants.OBJECTCLASS)));
        for (final String serviceName : classNames) {
            if (isHook(serviceName, svcObj)) {
                synchronized(m_allHooks) {
                    final Set<ServiceReference<?>> hooks = m_allHooks.get(serviceName);
                    if (hooks != null) {
                        hooks.remove(ref);
                        if (hooks.isEmpty()) {
                            m_allHooks.remove(serviceName);
                        }
                    }
                }
            }
        }
        m_blackList.remove(ref);
    }

    public <S> Set<ServiceReference<S>> getHooks(final Class<S> hookClass) {
        synchronized(m_allHooks) {
            final Set<ServiceReference<?>> hooks = m_allHooks.get(hookClass.getName());
            if (hooks != null) {
                SortedSet<ServiceReference<?>> sorted = new TreeSet<ServiceReference<?>>(Collections.reverseOrder());
                sorted.addAll(hooks);
                return ((Set) (sorted));
            }
            return Collections.emptySet();
        }
    }

    public boolean isHookBlackListed(final ServiceReference<?> sr) {
        return m_blackList.containsKey(sr);
    }

    public void blackListHook(final ServiceReference<?> sr) {
        m_blackList.put(sr, sr);
    }
}