import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommandEx{
   public static void main(String[] args) {

      Client cl = new Client();

		// コマンドラインから入力された値を渡して、数字と計算演算子を分割する
		int[] intArgs = cl.getArgs(args[0]);
		String operator = cl.getOperator(args[0]);

      // System.out.println(operator+"ope");
		// 演算子による処理の分岐
		cl.setCalRequest(operator);

      int args1 = intArgs[0];
      int args2 = intArgs[1];
		cl.doCalculate(intArgs[0], intArgs[1]);
   }
}

class Client {
	private CalculationRequest calRequest;

	// コマンドライン引数から数字を取り出すメソッド
	public int[] getArgs(String args){
		// 値だけを取り出す。
		String[] splitResult = args.split("[\\*\\-\\/\\+]");

		// 値をint型にして、配列に格納する
		int[] intArgs = new int[2];
		intArgs[0] = Integer.parseInt(splitResult[0]);
		intArgs[1] = Integer.parseInt(splitResult[1]);
		return intArgs;
	}

	// 計算演算子を取り出すメソッド
	public String getOperator(String args){
		// 正規表現を使って、受け取った文字列から+-*/を取り出す処理

      String regex = "[\\*\\-/\\+]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(args);
      matcher.find();
		String operator = matcher.group();

		return operator;
	}

	public void doCalculate(int args1, int args2){
		calRequest.execute(args1, args2);
	}

	// 演算子を引数に取って、演算子ごとの具象Commandクラスをセットする。
	public void setCalRequest(String operator){
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
