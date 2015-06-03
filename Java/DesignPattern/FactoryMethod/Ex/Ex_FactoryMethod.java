
class Ex_FactoryMethod{
   public static void main(String[] args) {
      DataHolder stholder = new StringDataHolder();
      DataHolder arholder = new StringArrayDataHolder();

      Client cl = new Client(stholder);
      Client cl2 = new Client(arholder);

      cl.execute("�f�[�^���t�@�C���ɕۑ����܂��B");
      cl2.execute("�f�[�^��Oracle�ɕۑ����܂��B");
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
   // setter��getter�AFactoryMethod���g����ꏊ�����肷��B
   protected abstract void setData(String data);
   protected abstract String getData();
   protected abstract DataSaver createDataSaver();

   // Template Method�̓K�p
   // �f�[�^���i�[���ĕۑ�����܂ł̈�A�̏����̗�����`
   public final void callSaveProcess(String data){
      // �i�[�p�N���X�Ƀf�[�^���Z�b�g����
      setData(data);
      // �Z�[�u�p�N���X��FactoryMethod�ŃC���X�^���X������B
      DataSaver saver = createDataSaver();
      // �쐬�����C���X�^���X�̃��\�b�h���g���A�f�[�^���Z�[�u����B
      saver.save(getData());
   }
}

// ������f�[�^���i�[����N���X
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

// String�z����i�[����N���X
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

// �t�@�C���փZ�[�u����N���X
class DataSaverToFile extends DataSaver{
   public void save(String data){
      System.out.println(data);
   }
}

// Oracle�ɃZ�[�u����N���X
class DataSaverToOracle extends DataSaver{
   public void save(String data){
      System.out.println(data);
   }
}
