package ttc;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class TestEx2{
	public static void main(String[] args) {
		// テスト用配列
		int[] test = {10,2,3,2,5,9,2,5,3,7};
		int[] test2 = {11,4,56,4,2,3,5,7,8,4,2,1,2,4,5,6,12,9,2,5,9,2,5,3,7};

		// 自然順序で並び替え
		System.out.println("自然順序で並び替え");
		Client c1 = new Client();
		AbstractDataHolder naturalSequenceHolder = new NaturalSequenceDataHolder();
		naturalSequenceHolder.setData(test);
		c1.setHolder(naturalSequenceHolder);
		c1.operation();

		System.out.println("\n-------------------------------------\n");

		// ハッシュ値で並び替え
		System.out.println("ハッシュで並び替え");
		Client c2 = new Client();
		AbstractDataHolder hashHolder = new HashDataHolder();
		hashHolder.setData(test2);
		c2.setHolder(hashHolder);
		c2.operation();
	}
}

abstract class AbstractDataHolder {
	private int[] data;

	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}

	public final int[] sort(){
		AbstractSorter sorter=createSorter();
		int[] result=sorter.sort(data);
		return result;
	}
	protected abstract AbstractSorter createSorter();
}

abstract class AbstractSorter {
	public abstract int[] sort(int[] data);
}

// ハッシュコードで並び替えるSorterのFactoryMethod
class HashDataHolder extends AbstractDataHolder{
	protected AbstractSorter createSorter(){
		return new HashSorter();
	}
}

// 自然順序で並び替えるSorterのFactoryMethod
class NaturalSequenceDataHolder extends AbstractDataHolder{
	protected AbstractSorter createSorter(){
		return new NaturalSequenceSorter();
	}
}


class HashSorter extends AbstractSorter{
	public int[] sort(int[] data){
		int[] deletedArray = DuplicateNumberDeleter.deleteDuplicateNumber(data);
		int[] hashArray = new int[deletedArray.length];

		for(int i = 0; i < deletedArray.length; i++){
			// hashCodeを生成して、新しく配列に格納
			hashArray[i] = ((Integer)deletedArray[i]).hashCode();
		}

		// ハッシュコードでソート
		Arrays.sort(hashArray);

		return hashArray;
	}
}

class NaturalSequenceSorter extends AbstractSorter{
	public int[] sort(int[] data){
		int[] deletedArray = DuplicateNumberDeleter.deleteDuplicateNumber(data);

		Arrays.sort(deletedArray);

		return deletedArray;
	}
}

abstract class DuplicateNumberDeleter{
	public static int[] deleteDuplicateNumber(int[] data){
		Set<Integer> set = new HashSet<>();

		for(int element : data){
			set.add(element);
		}

		Object[] deleted = set.toArray();
		int[] deletedArray = new int[deleted.length];

		for(int i = 0; i < deleted.length; i++){
			deletedArray[i] = (int)deleted[i];
		}

		return deletedArray;
	}
}

class Client {
	private AbstractDataHolder holder;

	public AbstractDataHolder getHolder() {
		return holder;
	}

	public void setHolder(AbstractDataHolder holder) {
		this.holder = holder;
	}

	public void operation(){

		int[] result=holder.sort();

		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}
