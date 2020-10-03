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
package org.apache.commons.math3.analysis.interpolation;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;
/**
 * 3D-spline function.
 *
 * @version $Id: TricubicSplineInterpolatingFunction.java 1385314 2012-09-16 16:35:49Z tn $
 */
class TricubicSplineFunction implements TrivariateFunction {
    /**
     * Number of points.
     */
    private static final short N = 4;

    /**
     * Coefficients
     */
    private final double[][][] a = new double[N][N][N];

    /**
     *
     *
     * @param aV
     * 		List of spline coefficients.
     */
    public TricubicSplineFunction(double[] aV) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    a[i][j][k] = aV[i + (N * (j + (N * k)))];
                }
            }
        }
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate of the interpolation point.
     * @param y
     * 		y-coordinate of the interpolation point.
     * @param z
     * 		z-coordinate of the interpolation point.
     * @return the interpolated value.
     * @throws OutOfRangeException
     * 		if {@code x}, {@code y} or
     * 		{@code z} are not in the interval {@code [0, 1]}.
     */
    public double value(double x, double y, double z) throws OutOfRangeException {
        if ((x < 0) || (x > 1)) {
            throw new OutOfRangeException(x, 0, 1);
        }
        if ((y < 0) || (y > 1)) {
            throw new OutOfRangeException(y, 0, 1);
        }
        if ((z < 0) || (z > 1)) {
            throw new OutOfRangeException(z, 0, 1);
        }
        final double x2 = x * x;
        final double x3 = x2 * x;
        final double[] pX = new double[]{ 1, x, x2, x3 };
        final double y2 = y * y;
        final double y3 = y2 * y;
        final double[] pY = new double[]{ 1, y, y2, y3 };
        final double z2 = z * z;
        final double z3 = z2 * z;
        final double[] pZ = new double[]{ 1, z, z2, z3 };
        double result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result += ((a[i][j][k] * pX[i]) * pY[j]) * pZ[k];
                }
            }
        }
        return result;
    }
}