import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class StringUtilsTest{
   //

   @Test
   public void toSnakeCaseはスネークケースを返す_aaaの場合(){
      assertThat(StringUtils.toSnakeCase("aaa"),is("aaa"));
   }

   @Test
   public void toSnakeCaseはスネークケースを返す_HelloWorldの場合(){
      assertThat(StringUtils.toSnakeCase("HelloWorld"),is("HelloWorld"));
   }

   @Test
   public void toSnakeCaseはスネークケースを返す_practiceJunitの場合(){
      assertThat(StringUtils.toSnakeCase("practiceJunit"),is("practiceJunit"));
   }
}
