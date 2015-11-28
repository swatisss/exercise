import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
	public static void main(String[] args) {
      Abstraction abs1 = new CommandLineOutputAbstraction(new QuickSorter());
      Abstraction abs2 = new FileOutputAbstraction(new BubbleSorter());
      Abstraction abs3 = new CommandLineOutputAbstraction(new QuickSorter());
      Abstraction abs4 = new FileOutputAbstraction(new BubbleSorter());

      abs1.operation(args);
      abs2.operation(args);
      abs3.operation(args);
      abs4.operation(args);
   }
}

abstract class Abstraction {
	protected Sorter sorter;

	public void operation(String[] param){
      sorter.sort(param);
	}
}

class CommandLineOutputAbstraction extends Abstraction {
	public CommandLineOutputAbstraction(Sorter sorter){
      this.sorter = sorter;
	}

	public void operation(String[] param){
      int[] result = sorter.sort(param);

      for(int i = 0; i < result.length; i++){
         System.out.print(result[i]);
      }
      System.out.println("ソートしました");
	}
}

class FileOutputAbstraction extends Abstraction {

	public FileOutputAbstraction(Sorter sorter){
      this.sorter = sorter;
	}

	public void operation(String[] param){
      int[] result = sorter.sort(param);
      try{
        File file = new File("C:\\GitHub\\exercise\\Java\\DesignPattern\\Bridge\\sort.txt");
        FileWriter filewriter = new FileWriter(file,true);

       //  結果をStringにする
        String[] parsedResult = new String[result.length];
         for(int i = 0; i < result.length; i++){
            parsedResult[i] = new Integer(result[i]).toString();
         }

         // 結果をファイルに出力
         for(int i = 0; i < parsedResult.length; i++){
            filewriter.write(parsedResult[i]);
         }
         filewriter.write("\r\n");
         filewriter.close();
      }catch(IOException e){
        System.out.println(e);
      }
	}
}

interface Sorter {
	int[] sort(String[] param);
}

class QuickSorter implements Sorter{
	public int[] sort(String[] param){
      int[] parsedParam = ArrayParser.parseInts(param);
      Arrays.sort(parsedParam);
      return parsedParam;
   }
}

class BubbleSorter implements Sorter{
	public int[] sort(String[] param){
      int[] parsedParam = ArrayParser.parseInts(param);

      int count = 0;
      for (int i = 0; i < parsedParam.length - 1; i++) {
         for (int j = parsedParam.length - 1; j > i; j--) {
             if (parsedParam[j - 1] > parsedParam[j]) {
                  int tmpNum = parsedParam[j - 1];
                  parsedParam[j - 1] = parsedParam[j];
                  parsedParam[j] = tmpNum;
                  count++;
             }
         }
      }
		return parsedParam;
	}
}

class ArrayParser{
	public static int[] parseInts(String[] sArray){
		int[] iArray = new int[sArray.length];
		for(int i = 0; i < iArray.length; i++){
			iArray[i] = Integer.parseInt(sArray[i]);
		}
		return iArray;
	}

}
