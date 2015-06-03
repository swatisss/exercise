
class Ex_FactoryMethod{
   public static void main(String[] args) {
      DataHolder stholder = new StringDataHolder();
      DataHolder arholder = new StringArrayDataHolder();

      Client cl = new Client(stholder);
      Client cl2 = new Client(arholder);

      cl.execute("データをファイルに保存します。");
      cl2.execute("データをOracleに保存します。");
   }
}

class Client{
   private DataHolder holder;

   public Client(DataHolder holder){this.holder = holder;}

   public void execute(String data){
      holder.callSaveProcess(data);
   }
}

// Creator
abstract class DataHolder{
   // setterとgetter、FactoryMethodが使われる場所を限定する。
   protected abstract void setData(String data);
   protected abstract String getData();
   protected abstract DataSaver createDataSaver();

   // Template Methodの適用
   // データを格納して保存するまでの一連の処理の流れを定義
   public final void callSaveProcess(String data){
      // 格納用クラスにデータをセットする
      setData(data);
      // セーブ用クラスをFactoryMethodでインスタンス化する。
      DataSaver saver = createDataSaver();
      // 作成したインスタンスのメソッドを使い、データをセーブする。
      saver.save(getData());
   }
}

// 文字列データを格納するクラス
class StringDataHolder extends DataHolder{
   private String stringData;

   public void setData(String data){
      this.stringData = data;
   }

   public String getData(){
      return this.stringData;
   }

   public DataSaver createDataSaver(){
      return new DataSaverToFile();
   }
}

// String配列を格納するクラス
class StringArrayDataHolder extends DataHolder{
   private String[] stringArrayData = new String[1];

   public void setData(String data){
      this.stringArrayData[0] = data;
   }

   public String getData(){
      return this.stringArrayData[0];
   }

   public DataSaver createDataSaver(){
      return new DataSaverToOracle();
   }
}

// Product
abstract class DataSaver{
   public abstract void save(String data);
}

// ファイルへセーブするクラス
class DataSaverToFile extends DataSaver{
   public void save(String data){
      System.out.println(data);
   }
}

// Oracleにセーブするクラス
class DataSaverToOracle extends DataSaver{
   public void save(String data){
      System.out.println(data);
   }
}
