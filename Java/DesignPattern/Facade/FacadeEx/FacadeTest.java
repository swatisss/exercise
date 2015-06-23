public class FacadeTest{
   public static void main(String[] args) {
      Client client1 = new Client();
      client1.setFacade(new SearchFacade());
      // 入力された値で横断検索されるという設定。
      client1.execute("マルティン・ハイデガー");

      Client client2 = new Client();
      client2.setFacade(new OrderFacade());
      client2.execute("青木隼人");
   }
}

class Client{
   private AbstractFacade facade;

   public void setFacade(AbstractFacade facade){
      this.facade = facade;
   }

   public void execute(String value){
      facade.operation(value);
   }
}

interface AbstractFacade{
   void operation(String value);
}

// 注文処理のサブシステム
class OrderFacade implements AbstractFacade{
   public void operation(String value){
      CustomerRegister register = new CustomerRegister();
      register.registCustomer(value);

      OrderRecorder recorder = new OrderRecorder();
      recorder.recordOrder(value);
   }
}

class CustomerRegister{
   public void registCustomer(String customerName){
      System.out.println(customerName+"さんを登録しました。");
   }
}

class OrderRecorder{
   public void recordOrder(String customerName){
      System.out.println(customerName+"さんの注文を記録しました。");
   }
}

// 書籍検索サブシステム
class SearchFacade implements AbstractFacade{
   public void operation(String value){
      // 入力された値で横断検索する
      // 今回は書籍名と著者名で横断検索される。
      BookNameExplorer bookExplorer = new BookNameExplorer();
      AuthorExplorer authorExplorer = new AuthorExplorer();
      SearchCounter counter = new SearchCounter();
      counter.setCount(bookExplorer.findBook(value));
      counter.setCount(authorExplorer.findAuthor(value));
      counter.showCount();
   }
}

class BookNameExplorer{
   public int findBook(String bookName){
      System.out.println(bookName+"を含む書籍名を検索");
      return 80;
   }
}

class AuthorExplorer{
   public int findAuthor(String author){
      System.out.println("著者名"+author+"で検索");
      return 100;
   }
}

class SearchCounter{
   private int count = 0;

   public void setCount(int count){
      this.count += count;
   }

   public int showCount(){
      System.out.println(this.count+"件見つかりました\n");
      return this.count;
   }
}
