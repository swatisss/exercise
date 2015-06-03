
class Ex_FactoryMethod{
   public static void main(String[] args) {
      DataHolder stholder = new StringDataHolder();
      DataHolder arholder = new StringArrayDataHolder();

      Client cl = new Client(stholder);
      Client cl2 = new Client(arholder);

      cl.operation("�Ԃ�[");
      cl2.operation("�Ԃ�[2");
   }
}

// Template Method�̓K�p
// �f�[�^���i�[���ĕۑ�����܂ł̈�A�̏����̗�����`
abstract class SaveProcessCaller{
   public final
   // �i�[�p�N���X�Ƀf�[�^���Z�b�g����
   holder.setData(data);
   // �Z�[�u�p�N���X��FactoryMethod�ŃC���X�^���X������B
   DataSaver saver = holder.createDataSaver();
   // �쐬�����C���X�^���X�̃��\�b�h���g���A�f�[�^���Z�[�u����B
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

// ������f�[�^���i�[����N���X
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

// String�z����i�[����N���X
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

// �t�@�C���փZ�[�u����N���X
class DataSaverToFile extends DataSaver{
   public void save(){

   }
}

// Oracle�ɃZ�[�u����N���X
class DataSaverToOracle extends DataSaver{

}
