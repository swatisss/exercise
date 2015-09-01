package JUnitExercise;

public class List8_1{
  public static boolean canRegister(int age){
    return 18 <= age;
  }

  public static boolean isSpecialMember(int age, boolean isRegisterMailMagazine, int usePastMonth){
    if(age < 20) return false;
    if(!isRegisterMailMagazine) return false;
    if(usePastMonth < 1) return false;
    return true;
  }
}
