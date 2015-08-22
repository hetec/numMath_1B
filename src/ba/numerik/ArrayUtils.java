package ba.numerik;

public class ArrayUtils {
	public static void printInLine(byte[] elements){
		for(byte element : elements){
			System.out.print(element);
		}
		System.out.println();

	}
	
	public static void printInLine(int[] elements){
		for(int element : elements){
			System.out.print(element);
		}
		System.out.println();

	}
	
	public static void printQSquareMatrix(int[][] matrix){
		checkMatrixFormat(matrix);
		System.out.println("-------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	private static void checkMatrixFormat(int[][] matrix){
		int partLen = 0;
		int lines = 0;
		for(int[] part : matrix){
			if(partLen == 0){
				partLen = part.length;
			}
			if(partLen != part.length){
				throw new IllegalArgumentException("Wrong format of matrix: Different numbers of elements in lines");
			}
			lines++;
		}
		if(lines != partLen){
			throw new IllegalArgumentException("Wrong format of matrix: too less lines (" + lines + "/" + partLen + ")");
		}
	}
}
