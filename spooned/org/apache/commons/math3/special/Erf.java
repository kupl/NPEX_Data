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
package org.apache.commons.math3.special;
import org.apache.commons.math3.util.FastMath;
/**
 * This is a utility class that provides computation methods related to the
 * error functions.
 *
 * @version $Id: Erf.java 1538368 2013-11-03 13:57:37Z erans $
 */
public class Erf {
    /**
     * The number {@code X_CRIT} is used by {@link #erf(double, double)} internally.
     * This number solves {@code erf(x)=0.5} within 1ulp.
     * More precisely, the current implementations of
     * {@link #erf(double)} and {@link #erfc(double)} satisfy:<br/>
     * {@code erf(X_CRIT) < 0.5},<br/>
     * {@code erf(Math.nextUp(X_CRIT) > 0.5},<br/>
     * {@code erfc(X_CRIT) = 0.5}, and<br/>
     * {@code erfc(Math.nextUp(X_CRIT) < 0.5}
     */
    private static final double X_CRIT = 0.4769362762044697;

    /**
     * Default constructor.  Prohibit instantiation.
     */
    private Erf() {
    }

    /**
     * Returns the error function.
     *
     * <p>erf(x) = 2/&radic;&pi; <sub>0</sub>&int;<sup>x</sup> e<sup>-t<sup>2</sup></sup>dt </p>
     *
     * <p>This implementation computes erf(x) using the
     * {@link Gamma#regularizedGammaP(double, double, double, int) regularized gamma function},
     * following <a href="http://mathworld.wolfram.com/Erf.html"> Erf</a>, equation (3)</p>
     *
     * <p>The value returned is always between -1 and 1 (inclusive).
     * If {@code abs(x) > 40}, then {@code erf(x)} is indistinguishable from
     * either 1 or -1 as a double, so the appropriate extreme value is returned.
     * </p>
     *
     * @param x
     * 		the value.
     * @return the error function erf(x)
     * @throws org.apache.commons.math3.exception.MaxCountExceededException
     * 		if the algorithm fails to converge.
     * @see Gamma#regularizedGammaP(double, double, double, int)
     */
    public static double erf(double x) {
        if (FastMath.abs(x) > 40) {
            return x > 0 ? 1 : -1;
        }
        final double ret = Gamma.regularizedGammaP(0.5, x * x, 1.0E-15, 10000);
        return x < 0 ? -ret : ret;
    }

    /**
     * Returns the complementary error function.
     *
     * <p>erfc(x) = 2/&radic;&pi; <sub>x</sub>&int;<sup>&infin;</sup> e<sup>-t<sup>2</sup></sup>dt
     * <br/>
     *    = 1 - {@link #erf(double) erf(x)} </p>
     *
     * <p>This implementation computes erfc(x) using the
     * {@link Gamma#regularizedGammaQ(double, double, double, int) regularized gamma function},
     * following <a href="http://mathworld.wolfram.com/Erf.html"> Erf</a>, equation (3).</p>
     *
     * <p>The value returned is always between 0 and 2 (inclusive).
     * If {@code abs(x) > 40}, then {@code erf(x)} is indistinguishable from
     * either 0 or 2 as a double, so the appropriate extreme value is returned.
     * </p>
     *
     * @param x
     * 		the value
     * @return the complementary error function erfc(x)
     * @throws org.apache.commons.math3.exception.MaxCountExceededException
     * 		if the algorithm fails to converge.
     * @see Gamma#regularizedGammaQ(double, double, double, int)
     * @since 2.2
     */
    public static double erfc(double x) {
        if (FastMath.abs(x) > 40) {
            return x > 0 ? 0 : 2;
        }
        final double ret = Gamma.regularizedGammaQ(0.5, x * x, 1.0E-15, 10000);
        return x < 0 ? 2 - ret : ret;
    }

    /**
     * Returns the difference between erf(x1) and erf(x2).
     *
     * The implementation uses either erf(double) or erfc(double)
     * depending on which provides the most precise result.
     *
     * @param x1
     * 		the first value
     * @param x2
     * 		the second value
     * @return erf(x2) - erf(x1)
     */
    public static double erf(double x1, double x2) {
        if (x1 > x2) {
            return -erf(x2, x1);
        }
        return x1 < (-X_CRIT) ? x2 < 0.0 ? erfc(-x2) - erfc(-x1) : erf(x2) - erf(x1) : (x2 > X_CRIT) && (x1 > 0.0) ? erfc(x1) - erfc(x2) : erf(x2) - erf(x1);
    }

    /**
     * Returns the inverse erf.
     * <p>
     * This implementation is described in the paper:
     * <a href="http://people.maths.ox.ac.uk/gilesm/files/gems_erfinv.pdf">Approximating
     * the erfinv function</a> by Mike Giles, Oxford-Man Institute of Quantitative Finance,
     * which was published in GPU Computing Gems, volume 2, 2010.
     * The source code is available <a href="http://gpucomputing.net/?q=node/1828">here</a>.
     * </p>
     *
     * @param x
     * 		the value
     * @return t such that x = erf(t)
     * @since 3.2
     */
    public static double erfInv(final double x) {
        // beware that the logarithm argument must be
        // commputed as (1.0 - x) * (1.0 + x),
        // it must NOT be simplified as 1.0 - x * x as this
        // would induce rounding errors near the boundaries +/-1
        double w = -FastMath.log((1.0 - x) * (1.0 + x));
        double p;
        if (w < 6.25) {
            w -= 3.125;
            p = -3.64441206401782E-21;
            p = (-1.6850591381820166E-19) + (p * w);
            p = 1.28584807152564E-18 + (p * w);
            p = 1.1157877678025181E-17 + (p * w);
            p = (-1.333171662854621E-16) + (p * w);
            p = 2.0972767875968562E-17 + (p * w);
            p = 6.637638134358324E-15 + (p * w);
            p = (-4.054566272975207E-14) + (p * w);
            p = (-8.151934197605472E-14) + (p * w);
            p = 2.6335093153082323E-12 + (p * w);
            p = (-1.2975133253453532E-11) + (p * w);
            p = (-5.415412054294628E-11) + (p * w);
            p = 1.0512122733215323E-9 + (p * w);
            p = (-4.112633980346984E-9) + (p * w);
            p = (-2.9070369957882005E-8) + (p * w);
            p = 4.2347877827932404E-7 + (p * w);
            p = (-1.3654692000834679E-6) + (p * w);
            p = (-1.3882523362786469E-5) + (p * w);
            p = 1.8673420803405714E-4 + (p * w);
            p = (-7.40702534166267E-4) + (p * w);
            p = (-0.006033670871430149) + (p * w);
            p = 0.24015818242558962 + (p * w);
            p = 1.6536545626831027 + (p * w);
        } else if (w < 16.0) {
            w = FastMath.sqrt(w) - 3.25;
            p = 2.2137376921775787E-9;
            p = 9.075656193888539E-8 + (p * w);
            p = (-2.7517406297064545E-7) + (p * w);
            p = 1.8239629214389228E-8 + (p * w);
            p = 1.5027403968909828E-6 + (p * w);
            p = (-4.013867526981546E-6) + (p * w);
            p = 2.9234449089955446E-6 + (p * w);
            p = 1.2475304481671779E-5 + (p * w);
            p = (-4.7318229009055734E-5) + (p * w);
            p = 6.828485145957318E-5 + (p * w);
            p = 2.4031110387097894E-5 + (p * w);
            p = (-3.550375203628475E-4) + (p * w);
            p = 9.532893797373805E-4 + (p * w);
            p = (-0.0016882755560235047) + (p * w);
            p = 0.002491442096107851 + (p * w);
            p = (-0.003751208507569241) + (p * w);
            p = 0.005370914553590064 + (p * w);
            p = 1.0052589676941592 + (p * w);
            p = 3.0838856104922208 + (p * w);
        } else if (!Double.isInfinite(w)) {
            w = FastMath.sqrt(w) - 5.0;
            p = -2.7109920616438573E-11;
            p = (-2.555641816996525E-10) + (p * w);
            p = 1.5076572693500548E-9 + (p * w);
            p = (-3.789465440126737E-9) + (p * w);
            p = 7.61570120807834E-9 + (p * w);
            p = (-1.496002662714924E-8) + (p * w);
            p = 2.914795345090108E-8 + (p * w);
            p = (-6.771199775845234E-8) + (p * w);
            p = 2.2900482228026655E-7 + (p * w);
            p = (-9.9298272942317E-7) + (p * w);
            p = 4.526062597223154E-6 + (p * w);
            p = (-1.968177810553167E-5) + (p * w);
            p = 7.599527703001776E-5 + (p * w);
            p = (-2.1503011930044477E-4) + (p * w);
            p = (-1.3871931833623122E-4) + (p * w);
            p = 1.0103004648645344 + (p * w);
            p = 4.849906401408584 + (p * w);
        } else {
            // this branch does not appears in the original code, it
            // was added because the previous branch does not handle
            // x = +/-1 correctly. In this case, w is positive infinity
            // and as the first coefficient (-2.71e-11) is negative.
            // Once the first multiplication is done, p becomes negative
            // infinity and remains so throughout the polynomial evaluation.
            // So the branch above incorrectly returns negative infinity
            // instead of the correct positive infinity.
            p = Double.POSITIVE_INFINITY;
        }
        return p * x;
    }

    /**
     * Returns the inverse erfc.
     *
     * @param x
     * 		the value
     * @return t such that x = erfc(t)
     * @since 3.2
     */
    public static double erfcInv(final double x) {
        return erfInv(1 - x);
    }
}