import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommandEx{
   public static void main(String[] args) {

      Client cl = new Client();
      cl.doCalculate(args);
   }
}

class Client {
	private CalculationRequest calRequest;

	// コマンドライン引数から数字を取り出すメソッド
	private int[] getArgs(String args){
		// 値だけを取り出す。
		String[] splitResult = args.split("\\D");

		// 値をint型にして、配列に格納する
		int[] intArgs = new int[2];
		intArgs[0] = Integer.parseInt(splitResult[0]);
		intArgs[1] = Integer.parseInt(splitResult[1]);
		return intArgs;
	}

	// 計算演算子を取り出すメソッド
	private String getOperator(String args){
      // 演算子を格納する変数
      String operator = null;
		// 正規表現を使って、受け取った文字列から+-*/を取り出す処理
      String regex = "[\\*\\-/\\+]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(args);

      if(matcher.find()){
         operator = matcher.group();
      }else{
         return "再入力";
      }
		return operator;
	}

	public void doCalculate(String[] args){
      int[] intArgs = this.getArgs(args[0]);
      String operator = this.getOperator(args[0]);

      if(operator.equals("再入力")){
         System.out.print("正しく入力されていません。最初からやり直しです。");
      }else{
         this.setCalRequest(operator);
   		calRequest.execute(intArgs[0], intArgs[1]);
      }
	}

	// 演算子を引数に取って、演算子ごとの具象Commandクラスをセットする。
	private void setCalRequest(String operator){
		this.calRequest = RequestFactory.getCalRequest(operator);
	}
}

// 演算子の種類によって、必要なクラスを生成するCommandFactoryクラス。
abstract class RequestFactory {
	private static HashMap<String, CalculationRequest> commands = new HashMap<>();

	static{
		commands.put("+", new SumRequest());
		commands.put("-", new SubstractionRequest());
		commands.put("*", new MultiplicationRequest());
		commands.put("/", new DivisionRequest());
	}

	// CommandFactoryメソッド
	public static CalculationRequest getCalRequest(String operator){
		return (CalculationRequest)commands.get(operator);
	}
}

//Commandクラス
abstract class CalculationRequest {
	// templateMethodを適用
	public final void execute(int args1, int args2){
		Calculator calculator = createCalculator();
		calculator.calculate(args1, args2);
	}

	// FactoryMethodの適用
	protected abstract Calculator createCalculator();
}

 class SumRequest extends CalculationRequest{
	protected Calculator createCalculator(){
		return new SumCalculator();
	}
}

 class SubstractionRequest extends CalculationRequest{
	protected Calculator createCalculator(){
		return new SubstractionCalculator();
	}
}

 class MultiplicationRequest extends CalculationRequest{
	protected Calculator createCalculator(){
		return new MultiplicationCalculator();
	}
}

 class DivisionRequest extends CalculationRequest{
	protected Calculator createCalculator(){
		return new DivisionCalculator();
	}
}


// サプライア群
 interface Calculator {
	void calculate(int args1, int args2);
}

// 足し算
 class SumCalculator implements Calculator{
	public void calculate(int args1, int args2){
		System.out.println(args1+args2);
	}
}

// 引き算
 class SubstractionCalculator implements Calculator{
	public void calculate(int args1, int args2){
		System.out.println(args1-args2);
	}
}

// 掛け算
 class MultiplicationCalculator implements Calculator{
	public void calculate(int args1, int args2){
		System.out.println(args1*args2);
	}

}

// 割り算
 class DivisionCalculator implements Calculator{
	public void calculate(int args1, int args2){
		System.out.println(args1/args2);
	}
}
