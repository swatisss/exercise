
class Ex_FactoryMethod{
   public static void main(String[] args) {
      DataHolder stholder = new StringDataHolder();
      DataHolder arholder = new StringArrayDataHolder();

      Client cl = new Client(stholder);
      Client cl2 = new Client(arholder);

      cl.operation("ぶるー");
      cl2.operation("ぶるー2");
   }
}

// Template Methodの適用
// データを格納して保存するまでの一連の処理の流れを定義
abstract class SaveProcessCaller{
   public final
   // 格納用クラスにデータをセットする
   holder.setData(data);
   // セーブ用クラスをFactoryMethodでインスタンス化する。
   DataSaver saver = holder.createDataSaver();
   // 作成したインスタンスのメソッドを使い、データをセーブする。
   saver.save(holder.getData());

}

class Client{
   
}

// Creator
interface DataHolder{
   void setData(String data);
   String getData();
   DataSaver createDataSaver();
}

// 文字列データを格納するクラス
class StringDataHolder implements DataHolder{
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
class StringArrayDataHolder implements DataHolder{
   private String[] stringArrayData;

   public void setData(String data){
      this.stringArrayData = data;
   }

   public String getData(){
      return this.stringArrayData;
   }

   public DataSaver createDataSaver(){
      return new DataSaverToOracle();
   }
}

// Product
abstaract class DataSaver{
   public abstract void save(String data);
}

// ファイルへセーブするクラス
class DataSaverToFile extends DataSaver{
   public void save(){

   }
}

// Oracleにセーブするクラス
class DataSaverToOracle extends DataSaver{

}
