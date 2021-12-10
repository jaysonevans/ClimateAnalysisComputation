/* 
Author: Jayson Evans
Date: December 9, 2021
Purpose: This program takes doubles from the console.  It then calculates and prints the
mean, sample standard deviation and standard error of the mean from the numbers provided.  
For the sake of clarity, variables and methods names do not share the names of the
actual mathematical property they represent, e.g. sample standard deviation is 
referred to as the standard deviation.

-----------------------------------------------------------------------------
Copyright (C) 2021 Jayson Evans

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
-----------------------------------------------------------------------------
*/
public class ClimateAnalysisComputations {
	/** Computes the mean of the numbers in an array */
	public static double computeMean(double[] numbers) {
		double sum = 0;
		for (int i = 0; i < numbers.length; i++)
			sum += numbers[i];
		return sum / numbers.length;
	}
	/** Computes the numerator in the standard deviation formula */
	public static double computeNumerator(double mean, double[] numbers) {
		double sum = 0;
		for (int i = 0; i < numbers.length; i++)
			sum += Math.pow(numbers[i] - mean, 2);
		return sum;
	}
	/** Computes the sample standard deviation */
	public static double computeStandardDeviation(double mean, double[] numbers) {
		double numerator = computeNumerator(mean, numbers);
		return Math.sqrt(numerator / (numbers.length - 1));
	}
	/** Computes the standard error of the mean */
	public static double computeStandardError(double standardDeviation, double[] numbers) {
		return standardDeviation / Math.sqrt(numbers.length);
	}
	/** Main method */
	public static void main(String[] args) {
		// Create the array to store our numbers
		double[] numbers = new double[args.length];

		// Add the input into our numbers array
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = Double.parseDouble(args[i]);

		// Compute values
		double mean = computeMean(numbers);
		double standardDeviation = computeStandardDeviation(mean, numbers); double standardError = computeStandardError(standardDeviation, numbers);
		// Print information
		System.out.print("For numbers ");
		for (double e: numbers)
			System.out.print(e + " ");
		System.out.println("\n");

		System.out.println("Mean: " + mean);
		System.out.println("Standard Deviation: " + standardDeviation);
		System.out.println("Standard Error: " + standardError);
	}
}
