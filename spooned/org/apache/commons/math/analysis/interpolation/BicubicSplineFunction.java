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
package org.apache.commons.math.analysis.interpolation;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.BivariateRealFunction;
/**
 * 2D-spline function.
 *
 * @version $Revision$ $Date$
 */
class BicubicSplineFunction implements BivariateRealFunction {
    private static final short N = 4;

    /**
     * Coefficients
     */
    private final double[][] a = new double[N][N];

    /**
     * Partial derivatives
     */
    BivariateRealFunction partialDerivativeX = null;

    BivariateRealFunction partialDerivativeY = null;

    BivariateRealFunction partialDerivativeXX = null;

    BivariateRealFunction partialDerivativeYY = null;

    BivariateRealFunction partialDerivativeXY = null;

    /**
     *
     *
     * @param a
     * 		Spline coefficients
     */
    public BicubicSplineFunction(double[] aV) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = aV[i + (N * j)];
            }
        }
    }

    /**
     * {@inheritDoc }
     */
    public double value(double x, double y) {
        if ((x < 0) || (x > 1)) {
            throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", x, 0, 1);
        }
        if ((y < 0) || (y > 1)) {
            throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", y, 0, 1);
        }
        final double x2 = x * x;
        final double x3 = x2 * x;
        final double[] pX = new double[]{ 1, x, x2, x3 };
        final double y2 = y * y;
        final double y3 = y2 * y;
        final double[] pY = new double[]{ 1, y, y2, y3 };
        return apply(pX, pY, a);
    }

    /**
     * Compute the value of the bicubic polynomial.
     *
     * @param pX
     * 		Powers of the x-coordinate.
     * @param pY
     * 		Powers of the y-coordinate.
     * @param coeff
     * 		Spline coefficients.
     * @return the interpolated value.
     */
    private double apply(double[] pX, double[] pY, double[][] coeff) {
        double result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += (coeff[i][j] * pX[i]) * pY[j];
            }
        }
        return result;
    }

    /**
     *
     *
     * @return the partial derivative wrt {@code x}.
     */
    public BivariateRealFunction partialDerivativeX() {
        if (partialDerivativeX == null) {
            computePartialDerivatives();
        }
        return partialDerivativeX;
    }

    /**
     *
     *
     * @return the partial derivative wrt {@code y}.
     */
    public BivariateRealFunction partialDerivativeY() {
        if (partialDerivativeY == null) {
            computePartialDerivatives();
        }
        return partialDerivativeY;
    }

    /**
     *
     *
     * @return the second partial derivative wrt {@code x}.
     */
    public BivariateRealFunction partialDerivativeXX() {
        if (partialDerivativeXX == null) {
            computePartialDerivatives();
        }
        return partialDerivativeXX;
    }

    /**
     *
     *
     * @return the second partial derivative wrt {@code y}.
     */
    public BivariateRealFunction partialDerivativeYY() {
        if (partialDerivativeYY == null) {
            computePartialDerivatives();
        }
        return partialDerivativeYY;
    }

    /**
     *
     *
     * @return the second partial cross-derivative.
     */
    public BivariateRealFunction partialDerivativeXY() {
        if (partialDerivativeXY == null) {
            computePartialDerivatives();
        }
        return partialDerivativeXY;
    }

    /**
     * Compute all partial derivatives functions.
     */
    private void computePartialDerivatives() {
        final double[][] aX = new double[N][N];
        final double[][] aY = new double[N][N];
        final double[][] aXX = new double[N][N];
        final double[][] aYY = new double[N][N];
        final double[][] aXY = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final double c = a[i][j];
                aX[i][j] = i * c;
                aY[i][j] = j * c;
                aXX[i][j] = (i - 1) * aX[i][j];
                aYY[i][j] = (j - 1) * aY[i][j];
                aXY[i][j] = j * aX[i][j];
            }
        }
        partialDerivativeX = new BivariateRealFunction() {
            public double value(double x, double y) {
                final double x2 = x * x;
                final double[] pX = new double[]{ 0, 1, x, x2 };
                final double y2 = y * y;
                final double y3 = y2 * y;
                final double[] pY = new double[]{ 1, y, y2, y3 };
                return apply(pX, pY, aX);
            }
        };
        partialDerivativeY = new BivariateRealFunction() {
            public double value(double x, double y) {
                final double x2 = x * x;
                final double x3 = x2 * x;
                final double[] pX = new double[]{ 1, x, x2, x3 };
                final double y2 = y * y;
                final double[] pY = new double[]{ 0, 1, y, y2 };
                return apply(pX, pY, aY);
            }
        };
        partialDerivativeXX = new BivariateRealFunction() {
            public double value(double x, double y) {
                final double[] pX = new double[]{ 0, 0, 1, x };
                final double y2 = y * y;
                final double y3 = y2 * y;
                final double[] pY = new double[]{ 1, y, y2, y3 };
                return apply(pX, pY, aXX);
            }
        };
        partialDerivativeYY = new BivariateRealFunction() {
            public double value(double x, double y) {
                final double x2 = x * x;
                final double x3 = x2 * x;
                final double[] pX = new double[]{ 1, x, x2, x3 };
                final double[] pY = new double[]{ 0, 0, 1, y };
                return apply(pX, pY, aYY);
            }
        };
        partialDerivativeXY = new BivariateRealFunction() {
            public double value(double x, double y) {
                final double x2 = x * x;
                final double[] pX = new double[]{ 0, 1, x, x2 };
                final double y2 = y * y;
                final double[] pY = new double[]{ 0, 1, y, y2 };
                return apply(pX, pY, aXY);
            }
        };
    }
}