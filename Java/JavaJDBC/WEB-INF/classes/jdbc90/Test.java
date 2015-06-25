package jdbc90;

public class Test{
   public static void main(String[] args) {
      // BLOBInserter bi = new BLOBInserter();
      // bi.insertBlob("C:\\Users\\koyama\\Pictures\\c7714ba238800dc5c7a1d057aac6e4e9.jpg");
      BLOBTaker bt = new BLOBTaker();
      bt.takeBlobFile();
   }
}
