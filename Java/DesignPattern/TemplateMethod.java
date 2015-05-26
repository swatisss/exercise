class TemplateMethod{
	public static void main(String[] args){
		Client cl = new Client(new ConcreteClass());
		cl.execute();
	}
}

class Client{
	private AbstractClass abs;

	Client(AbstractClass abs){
		this.abs = abs;
	}

	public void execute(){
		abs.templateMethod();
	}
}

abstract class AbstractClass{
	public final void templateMethod(){
		System.out.println("templateMethod");
		primitiveOperation1();
		primitiveOperation2();
	}

	abstract protected void primitiveOperation1();
	abstract protected void primitiveOperation2();
}

class ConcreteClass extends AbstractClass{
	protected void primitiveOperation1(){
		System.out.println("primitiveOperation1");
	}

	protected void primitiveOperation2(){
		System.out.println("primitiveOperation2");
	}
}
