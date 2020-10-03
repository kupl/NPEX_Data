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
import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;
/**
 * Function that implements the
 * <a href="http://en.wikipedia.org/wiki/Bicubic_interpolation">
 * bicubic spline interpolation</a>.
 *
 * @since 2.1
 * @version $Id: BicubicSplineInterpolatingFunction.java 1512547 2013-08-10 01:13:38Z erans $
 */
public class BicubicSplineInterpolatingFunction implements BivariateFunction {
    /**
     * Number of coefficients.
     */
    private static final int NUM_COEFF = 16;

    /**
     * Matrix to compute the spline coefficients from the function values
     * and function derivatives values
     */
    private static final double[][] AINV = new double[][]{ new double[]{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new double[]{ -3, 3, 0, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new double[]{ 2, -2, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, -3, 3, 0, 0, -2, -1, 0, 0 }, new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, 0, 1, 1, 0, 0 }, new double[]{ -3, 0, 3, 0, 0, 0, 0, 0, -2, 0, -1, 0, 0, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, -3, 0, 3, 0, 0, 0, 0, 0, -2, 0, -1, 0 }, new double[]{ 9, -9, -9, 9, 6, 3, -6, -3, 6, -6, 3, -3, 4, 2, 2, 1 }, new double[]{ -6, 6, 6, -6, -3, -3, 3, 3, -4, 4, -2, 2, -2, -2, -1, -1 }, new double[]{ 2, 0, -2, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 }, new double[]{ 0, 0, 0, 0, 2, 0, -2, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, new double[]{ -6, 6, 6, -6, -4, -2, 4, 2, -3, 3, -3, 3, -2, -1, -2, -1 }, new double[]{ 4, -4, -4, 4, 2, 2, -2, -2, 2, -2, 2, -2, 1, 1, 1, 1 } };

    /**
     * Samples x-coordinates
     */
    private final double[] xval;

    /**
     * Samples y-coordinates
     */
    private final double[] yval;

    /**
     * Set of cubic splines patching the whole data grid
     */
    private final BicubicSplineFunction[][] splines;

    /**
     * Partial derivatives
     * The value of the first index determines the kind of derivatives:
     * 0 = first partial derivatives wrt x
     * 1 = first partial derivatives wrt y
     * 2 = second partial derivatives wrt x
     * 3 = second partial derivatives wrt y
     * 4 = cross partial derivatives
     */
    private BivariateFunction[][][] partialDerivatives = null;

    /**
     *
     *
     * @param x
     * 		Sample values of the x-coordinate, in increasing order.
     * @param y
     * 		Sample values of the y-coordinate, in increasing order.
     * @param f
     * 		Values of the function on every grid point.
     * @param dFdX
     * 		Values of the partial derivative of function with respect
     * 		to x on every grid point.
     * @param dFdY
     * 		Values of the partial derivative of function with respect
     * 		to y on every grid point.
     * @param d2FdXdY
     * 		Values of the cross partial derivative of function on
     * 		every grid point.
     * @throws DimensionMismatchException
     * 		if the various arrays do not contain
     * 		the expected number of elements.
     * @throws NonMonotonicSequenceException
     * 		if {@code x} or {@code y} are
     * 		not strictly increasing.
     * @throws NoDataException
     * 		if any of the arrays has zero length.
     */
    public BicubicSplineInterpolatingFunction(double[] x, double[] y, double[][] f, double[][] dFdX, double[][] dFdY, double[][] d2FdXdY) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException {
        final int xLen = x.length;
        final int yLen = y.length;
        if ((((xLen == 0) || (yLen == 0)) || (f.length == 0)) || (f[0].length == 0)) {
            throw new NoDataException();
        }
        if (xLen != f.length) {
            throw new DimensionMismatchException(xLen, f.length);
        }
        if (xLen != dFdX.length) {
            throw new DimensionMismatchException(xLen, dFdX.length);
        }
        if (xLen != dFdY.length) {
            throw new DimensionMismatchException(xLen, dFdY.length);
        }
        if (xLen != d2FdXdY.length) {
            throw new DimensionMismatchException(xLen, d2FdXdY.length);
        }
        MathArrays.checkOrder(x);
        MathArrays.checkOrder(y);
        xval = x.clone();
        yval = y.clone();
        final int lastI = xLen - 1;
        final int lastJ = yLen - 1;
        splines = new BicubicSplineFunction[lastI][lastJ];
        for (int i = 0; i < lastI; i++) {
            if (f[i].length != yLen) {
                throw new DimensionMismatchException(f[i].length, yLen);
            }
            if (dFdX[i].length != yLen) {
                throw new DimensionMismatchException(dFdX[i].length, yLen);
            }
            if (dFdY[i].length != yLen) {
                throw new DimensionMismatchException(dFdY[i].length, yLen);
            }
            if (d2FdXdY[i].length != yLen) {
                throw new DimensionMismatchException(d2FdXdY[i].length, yLen);
            }
            final int ip1 = i + 1;
            for (int j = 0; j < lastJ; j++) {
                final int jp1 = j + 1;
                final double[] beta = new double[]{ f[i][j], f[ip1][j], f[i][jp1], f[ip1][jp1], dFdX[i][j], dFdX[ip1][j], dFdX[i][jp1], dFdX[ip1][jp1], dFdY[i][j], dFdY[ip1][j], dFdY[i][jp1], dFdY[ip1][jp1], d2FdXdY[i][j], d2FdXdY[ip1][j], d2FdXdY[i][jp1], d2FdXdY[ip1][jp1] };
                splines[i][j] = new BicubicSplineFunction(computeSplineCoefficients(beta));
            }
        }
    }

    /**
     * {@inheritDoc }
     */
    public double value(double x, double y) throws OutOfRangeException {
        final int i = searchIndex(x, xval);
        final int j = searchIndex(y, yval);
        final double xN = (x - xval[i]) / (xval[i + 1] - xval[i]);
        final double yN = (y - yval[j]) / (yval[j + 1] - yval[j]);
        return splines[i][j].value(xN, yN);
    }

    /**
     * Indicates whether a point is within the interpolation range.
     *
     * @param x
     * 		First coordinate.
     * @param y
     * 		Second coordinate.
     * @return {@code true} if (x, y) is a valid point.
     * @since 3.3
     */
    public boolean isValidPoint(double x, double y) {
        if ((((x < xval[0]) || (x > xval[xval.length - 1])) || (y < yval[0])) || (y > yval[yval.length - 1])) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the first partial derivative with
    respect to x.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    public double partialDerivativeX(double x, double y) throws OutOfRangeException {
        return partialDerivative(0, x, y);
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the first partial derivative with
    respect to y.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    public double partialDerivativeY(double x, double y) throws OutOfRangeException {
        return partialDerivative(1, x, y);
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the second partial derivative with
    respect to x.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    public double partialDerivativeXX(double x, double y) throws OutOfRangeException {
        return partialDerivative(2, x, y);
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the second partial derivative with
    respect to y.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    public double partialDerivativeYY(double x, double y) throws OutOfRangeException {
        return partialDerivative(3, x, y);
    }

    /**
     *
     *
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the second partial cross-derivative.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    public double partialDerivativeXY(double x, double y) throws OutOfRangeException {
        return partialDerivative(4, x, y);
    }

    /**
     *
     *
     * @param which
     * 		First index in {@link #partialDerivatives}.
     * @param x
     * 		x-coordinate.
     * @param y
     * 		y-coordinate.
     * @return the value at point (x, y) of the selected partial derivative.
     * @throws OutOfRangeException
     * 		if {@code x} (resp. {@code y}) is outside
     * 		the range defined by the boundary values of {@code xval} (resp.
     * 		{@code yval}).
     */
    private double partialDerivative(int which, double x, double y) throws OutOfRangeException {
        if (partialDerivatives == null) {
            computePartialDerivatives();
        }
        final int i = searchIndex(x, xval);
        final int j = searchIndex(y, yval);
        final double xN = (x - xval[i]) / (xval[i + 1] - xval[i]);
        final double yN = (y - yval[j]) / (yval[j + 1] - yval[j]);
        return partialDerivatives[which][i][j].value(xN, yN);
    }

    /**
     * Compute all partial derivatives.
     */
    private void computePartialDerivatives() {
        final int lastI = xval.length - 1;
        final int lastJ = yval.length - 1;
        partialDerivatives = new BivariateFunction[5][lastI][lastJ];
        for (int i = 0; i < lastI; i++) {
            for (int j = 0; j < lastJ; j++) {
                final BicubicSplineFunction f = splines[i][j];
                partialDerivatives[0][i][j] = f.partialDerivativeX();
                partialDerivatives[1][i][j] = f.partialDerivativeY();
                partialDerivatives[2][i][j] = f.partialDerivativeXX();
                partialDerivatives[3][i][j] = f.partialDerivativeYY();
                partialDerivatives[4][i][j] = f.partialDerivativeXY();
            }
        }
    }

    /**
     *
     *
     * @param c
     * 		Coordinate.
     * @param val
     * 		Coordinate samples.
     * @return the index in {@code val} corresponding to the interval
    containing {@code c}.
     * @throws OutOfRangeException
     * 		if {@code c} is out of the
     * 		range defined by the boundary values of {@code val}.
     */
    private int searchIndex(double c, double[] val) {
        final int r = Arrays.binarySearch(val, c);
        if ((r == (-1)) || (r == ((-val.length) - 1))) {
            throw new OutOfRangeException(c, val[0], val[val.length - 1]);
        }
        if (r < 0) {
            // "c" in within an interpolation sub-interval: Return the
            // index of the sample at the lower end of the sub-interval.
            return (-r) - 2;
        }
        final int last = val.length - 1;
        if (r == last) {
            // "c" is the last sample of the range: Return the index
            // of the sample at the lower end of the last sub-interval.
            return last - 1;
        }
        // "c" is another sample point.
        return r;
    }

    /**
     * Compute the spline coefficients from the list of function values and
     * function partial derivatives values at the four corners of a grid
     * element. They must be specified in the following order:
     * <ul>
     *  <li>f(0,0)</li>
     *  <li>f(1,0)</li>
     *  <li>f(0,1)</li>
     *  <li>f(1,1)</li>
     *  <li>f<sub>x</sub>(0,0)</li>
     *  <li>f<sub>x</sub>(1,0)</li>
     *  <li>f<sub>x</sub>(0,1)</li>
     *  <li>f<sub>x</sub>(1,1)</li>
     *  <li>f<sub>y</sub>(0,0)</li>
     *  <li>f<sub>y</sub>(1,0)</li>
     *  <li>f<sub>y</sub>(0,1)</li>
     *  <li>f<sub>y</sub>(1,1)</li>
     *  <li>f<sub>xy</sub>(0,0)</li>
     *  <li>f<sub>xy</sub>(1,0)</li>
     *  <li>f<sub>xy</sub>(0,1)</li>
     *  <li>f<sub>xy</sub>(1,1)</li>
     * </ul>
     * where the subscripts indicate the partial derivative with respect to
     * the corresponding variable(s).
     *
     * @param beta
     * 		List of function values and function partial derivatives
     * 		values.
     * @return the spline coefficients.
     */
    private double[] computeSplineCoefficients(double[] beta) {
        final double[] a = new double[NUM_COEFF];
        for (int i = 0; i < NUM_COEFF; i++) {
            double result = 0;
            final double[] row = AINV[i];
            for (int j = 0; j < NUM_COEFF; j++) {
                result += row[j] * beta[j];
            }
            a[i] = result;
        }
        return a;
    }
}