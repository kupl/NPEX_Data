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
package org.apache.commons.math3.random;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
/**
 * <p>This class provides a stable normalized random generator. It samples from a stable
 * distribution with location parameter 0 and scale 1.</p>
 *
 * <p>The implementation uses the Chambers-Mallows-Stuck method as described in
 * <i>Handbook of computational statistics: concepts and methods</i> by
 * James E. Gentle, Wolfgang H&auml;rdle, Yuichi Mori.</p>
 *
 * @version $Id: StableRandomGenerator.java 1538368 2013-11-03 13:57:37Z erans $
 * @since 3.0
 */
public class StableRandomGenerator implements NormalizedRandomGenerator {
    /**
     * Underlying generator.
     */
    private final RandomGenerator generator;

    /**
     * stability parameter
     */
    private final double alpha;

    /**
     * skewness parameter
     */
    private final double beta;

    /**
     * cache of expression value used in generation
     */
    private final double zeta;

    /**
     * Create a new generator.
     *
     * @param generator
     * 		underlying random generator to use
     * @param alpha
     * 		Stability parameter. Must be in range (0, 2]
     * @param beta
     * 		Skewness parameter. Must be in range [-1, 1]
     * @throws NullArgumentException
     * 		if generator is null
     * @throws OutOfRangeException
     * 		if {@code alpha <= 0} or {@code alpha > 2}
     * 		or {@code beta < -1} or {@code beta > 1}
     */
    public StableRandomGenerator(final RandomGenerator generator, final double alpha, final double beta) throws NullArgumentException, OutOfRangeException {
        if (generator == null) {
            throw new NullArgumentException();
        }
        if (!((alpha > 0.0) && (alpha <= 2.0))) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, alpha, 0, 2);
        }
        if (!((beta >= (-1.0)) && (beta <= 1.0))) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, beta, -1, 1);
        }
        this.generator = generator;
        this.alpha = alpha;
        this.beta = beta;
        if ((alpha < 2.0) && (beta != 0.0)) {
            zeta = beta * FastMath.tan((FastMath.PI * alpha) / 2);
        } else {
            zeta = 0.0;
        }
    }

    /**
     * Generate a random scalar with zero location and unit scale.
     *
     * @return a random scalar with zero location and unit scale
     */
    public double nextNormalizedDouble() {
        // we need 2 uniform random numbers to calculate omega and phi
        double omega = -FastMath.log(generator.nextDouble());
        double phi = FastMath.PI * (generator.nextDouble() - 0.5);
        // Normal distribution case (Box-Muller algorithm)
        if (alpha == 2.0) {
            return FastMath.sqrt(2.0 * omega) * FastMath.sin(phi);
        }
        double x;
        // when beta = 0, zeta is zero as well
        // Thus we can exclude it from the formula
        if (beta == 0.0) {
            // Cauchy distribution case
            if (alpha == 1.0) {
                x = FastMath.tan(phi);
            } else {
                x = (FastMath.pow(omega * FastMath.cos((1 - alpha) * phi), (1.0 / alpha) - 1.0) * FastMath.sin(alpha * phi)) / FastMath.pow(FastMath.cos(phi), 1.0 / alpha);
            }
        } else {
            // Generic stable distribution
            double cosPhi = FastMath.cos(phi);
            // to avoid rounding errors around alpha = 1
            if (FastMath.abs(alpha - 1.0) > 1.0E-8) {
                double alphaPhi = alpha * phi;
                double invAlphaPhi = phi - alphaPhi;
                x = (((FastMath.sin(alphaPhi) + (zeta * FastMath.cos(alphaPhi))) / cosPhi) * (FastMath.cos(invAlphaPhi) + (zeta * FastMath.sin(invAlphaPhi)))) / FastMath.pow(omega * cosPhi, (1 - alpha) / alpha);
            } else {
                double betaPhi = (FastMath.PI / 2) + (beta * phi);
                x = (2.0 / FastMath.PI) * ((betaPhi * FastMath.tan(phi)) - (beta * FastMath.log((((FastMath.PI / 2.0) * omega) * cosPhi) / betaPhi)));
                if (alpha != 1.0) {
                    x += beta * FastMath.tan((FastMath.PI * alpha) / 2);
                }
            }
        }
        return x;
    }
}