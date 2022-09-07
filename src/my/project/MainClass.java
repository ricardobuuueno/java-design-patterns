package my.project;

import my.project.abstract_factory.*;
import my.project.abstract_factory.Instance.Capacity;
import my.project.builder.*;
import my.project.factory_method.*;
import my.project.object_pool.*;
import my.project.prototype.*;
import my.project.simple_factory.*;
import my.project.singleton.*;
import my.project.adapter.*;
import my.project.bridge.*;
import my.project.composite.*;
import my.project.facade.*;

public class MainClass {

	private static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println("\nBuilder");
		User user = BuilderDirector.createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();
		
		UserDTO dto = BuilderDirector.directBuild(builder, user);
		System.out.println(dto);

		System.out.println("\nSimple factory");
		Post post = PostFactory.createPost("news");
		System.out.println(post);
		
		System.out.println("\nFactory method");
		printMessage(new JSONMessageCreator());
		printMessage(new TextMessageCreator());
		
		System.out.println("\nPrototype");
		Swordsman s1 = new Swordsman();
		s1.move(new Point3D(-10,0,0) , 20);
		s1.attack();
		System.out.println(s1);

		Swordsman s2 = (Swordsman)s1.clone();
		System.out.println(s2);
		
		System.out.println("\nAbstract factory");
		AbstractFactoryClient aws = new AbstractFactoryClient(new AwsResourceFactory());
		Instance i1 = aws.createServer(Capacity.micro, 20480);
		i1.start();
		i1.stop();
		
		System.out.println("\n******************************");
		AbstractFactoryClient gcp = new AbstractFactoryClient(new GoogleResourceFactory()); 
		Instance i2 = gcp.createServer(Capacity.micro, 20480);
		i2.start();
		i2.stop();
		
		System.out.println("\nSingleton");
		SingletonClient sc1 = new SingletonClient();
		System.out.println(sc1);
		
		System.out.println("\nObject pool");
		Bitmap b1 = ObjectPoolClient.bitmapPool.get();
		b1.setLocation(new Point2D(10,10));
		Bitmap b2 = ObjectPoolClient.bitmapPool.get();
		b2.setLocation(new Point2D(-10,0));
		
		b1.draw();
		b2.draw();
		
		ObjectPoolClient.bitmapPool.release(b1);
		ObjectPoolClient.bitmapPool.release(b2);

		System.out.println("\nAdapter");
		EmployeeClassAdapter adapter = new EmployeeClassAdapter();
		AdapterClient.populateEmployeeData(adapter);
		
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card = designer.designCard(adapter);
		System.out.println(card);
		
		Employee employee = new Employee();
		AdapterClient.populateEmployeeData(employee);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
		card = designer.designCard(objectAdapter);
		System.out.println(card);
		
		System.out.println("\nBridge");
		FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
		collection.offer(10);
		collection.offer(30);
		collection.offer(50);
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		
		System.out.println("\nDecorator");
		my.project.decorator.Message m = new my.project.decorator.TextMessage("The <FORCE> is strong with this one");
		System.out.println(m.getContent());
		
		my.project.decorator.Message decorator = new my.project.decorator.HtmlEncodedMessage(m);
		System.out.println(decorator.getContent());

		my.project.decorator.Message decorator2 = new my.project.decorator.Base64EncodedMessage(decorator);
		System.out.println(decorator2.getContent());
		
		System.out.println("\nComposite");
		File root1 = CompositeClient.createTreeOne();
		root1.ls();
		
		File root2 = CompositeClient.createTreeTwo();
		root2.ls();
		
		System.out.println("\nFaçade");
		Order order = new Order("191", 99.99);
		boolean result = FacadeClient.sendOrderEmailWithoutFacade(order);
		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));
		
		EmailFacade facade = new EmailFacade();
		result = facade.sendOrderEmail(order);
		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));
		

	}

}
