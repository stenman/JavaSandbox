package com.example.sandbox.mains;

import java.util.ArrayList;

class Permutations {
	public static void main(String[] args) throws java.lang.Exception {
		int[] a = { 2, 2, 2, 4 };
		ArrayList<int[]> list = permutations(a);
		for (int[] s : list) {
			for (int i : s) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	static ArrayList<int[]> permutations(int[] a) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		permutation(a, 0, ret);
		return ret;
	}

	public static void permutation(int[] arr, int pos, ArrayList<int[]> list) {
		if (arr.length - pos == 1)
			list.add(arr.clone());
		else
			for (int i = pos; i < arr.length; i++) {
				swap(arr, pos, i);
				permutation(arr, pos + 1, list);
				swap(arr, pos, i);
			}
	}

	public static void swap(int[] arr, int pos1, int pos2) {
		int h = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = h;
	}
}