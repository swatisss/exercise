/*
context �U�镑��
problem ���\�b�h�̈����ɑ΂��āA�f�t�H���g�l���ǂ̂悤�ɐݒ肷�邩�B
solution�@�����̑g�ݍ��킹�ɉ����ăI�[�o�[���[�h�������\�b�h���쐬���A�����̏��Ȃ����\�b�h���瑽�����\�b�h�֏������ȏシ��B
*/

class DefaultParameterMethod {
   public static void main(String[] args) {
      Calculator cl = new Calculator();
      System.out.println("�l�i�Ɛŗ�������n�����ꍇ "+cl.getPrice(1000, 1.08));
      System.out.println("�l�i�������n���ꂽ�ꍇ "+ cl.getPrice(1000));
      System.out.println("�Ȃɂ��n����Ȃ������ꍇ "+cl.getPrice());
   }
}

class Calculator{
   public int getPrice(int price, double tax){
      // �v�Z�����͂��ׂĂ����ɏW���ł���B
      return (int)(price * tax);
   }

   public int getPrice(int price){
      return this.getPrice(price, 1.05);
   }

   public int getPrice(){
      return this.getPrice(0,0);
   }
}
