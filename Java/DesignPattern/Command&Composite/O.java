class Calculater{
	public static void main(String[] args){

		//配列変数の宣言と配列の生成
		int[][] iCalc = {
			{63,90,75,45,81},
			{85,100,95,80,90},
			{100,100,100,100,100}
		};

		int i, j, sum = 0;

		for ( i = 0; i < iCalc.length; i ++ ) {
			for ( j = 0; j < iCalc[i].length; j ++ ) {
				System.out.print("\t"+iCalc[i][j]);
				sum += iCalc[i][j];
			}
			System.out.println("\t|"+sum/iCalc[i].length);
		}

	}
}
