/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.webconsole;


import java.io.PrintWriter;


/**
 * The <code>ConfigurationPrinter</code> is a service interface to be used by
 * providers which want to hook into the display of the current configuration
 * of the OSGi framework.
 * A configuration printer is currently used in three modes: displayed in
 * a tab of the configuration web console plugin, included in a downloadable
 * zip of the configuration or a downloadable txt file.
 * With the {@link WebConsoleConstants#CONFIG_PRINTER_MODES} property this
 * service can specify when it should be included.
 * The default mode is {@link #MODE_ALWAYS}.
 * @deprecated This has been deprecated. Use the org.apache.felix.status
 *             API instead.
 */
public interface ConfigurationPrinter
{

    /**
     * The service name under which services of this class must be registered
     * to be picked for inclusion in the configuration report.
     */
    String SERVICE = ConfigurationPrinter.class.getName();

    /**
     * The default mode - this printer is used in the web console and the zip.
     *
     * @since 3.0
     */
    String MODE_ALWAYS = "always"; //$NON-NLS-1$

    /**
     * The web mode - this printer is used in the web console.
     * <p>
     * Output of the configuration printer is HTML-escaped unless the
     * {@link WebConsoleConstants#CONFIG_PRINTER_WEB_UNESCAPED} service
     * registration property is set to <code>true</code>.
     *
     * @since 3.0
     */
    String MODE_WEB = "web"; //$NON-NLS-1$

    /**
     * The zip mode - this printer is used in the zip.
     *
     * @since 3.0
     */
    String MODE_ZIP = "zip"; //$NON-NLS-1$

    /**
     * The txt mode - this printer is used in the txt.
     *
     * @since 3.0
     */
    String MODE_TXT = "txt"; //$NON-NLS-1$

    /**
     * The optional service property specifying the modes of the printer.
     * If this property is missing or contains an unknown value, the default
     * {@link #MODE_ALWAYS} is used.
     * The value of this property is either a single string or an
     * array of strings.
     *
     * @since 3.0
     * @deprecated Use {@link WebConsoleConstants#CONFIG_PRINTER_MODES}
     */
    String PROPERTY_MODES = "modes"; //$NON-NLS-1$

    /**
     * Returns a human readable title string to be placed in front of the configuration
     * report generated by the {@link #printConfiguration(PrintWriter)} method.
     *
     * @return the configuration title
     */
    String getTitle();

    /**
     * Prints the configuration report to the given <code>printWriter</code>.
     * Implementations are free to print whatever information they deem useful.
     *
     * @param printWriter where to write the configuration data. It might be flushed,
     * but must not be closed.
     */
    void printConfiguration( PrintWriter printWriter );
}
