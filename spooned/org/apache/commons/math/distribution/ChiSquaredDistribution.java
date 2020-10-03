/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.apache.commons.math.distribution;
/**
 * The Chi-Squared Distribution.
 *
 * <p>
 * References:
 * <ul>
 * <li><a href="http://mathworld.wolfram.com/Chi-SquaredDistribution.html">
 * Chi-Squared Distribution</a></li>
 * </ul>
 * </p>
 *
 * @version $Revision: 693598 $ $Date: 2008-09-09 22:37:08 +0200 (mar., 09 sept. 2008) $
 */
public interface ChiSquaredDistribution extends ContinuousDistribution , HasDensity<Double> {
    /**
     * Modify the degrees of freedom.
     *
     * @param degreesOfFreedom
     * 		the new degrees of freedom.
     */
    void setDegreesOfFreedom(double degreesOfFreedom);

    /**
     * Access the degrees of freedom.
     *
     * @return the degrees of freedom.
     */
    double getDegreesOfFreedom();

    /**
     * Return the probability density for a particular point.
     *
     * @param x
     * 		The point at which the density should be computed.
     * @return The pdf at point x.
     */
    double density(Double x);
}