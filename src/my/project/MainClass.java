package my.project;

import java.time.LocalDate;

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
import my.project.flyweight.*;
import my.project.flyweight.ErrorMessageFactory.ErrorType;
import my.project.proxy.*;
import my.project.chain.*;
import my.project.chain.LeaveApplication.Type;
import my.project.command.*;
import my.project.interpreter.*;
import my.project.iterator.*;
import my.project.memento.MementoClient;

public class MainClass {

	private static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg);
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {

		System.out.println("\nBuilder");
		my.project.builder.User user = BuilderDirector.createUser();
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
		
		my.project.adapter.Employee employee = new my.project.adapter.Employee();
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
		my.project.facade.Order order = new my.project.facade.Order("191", 99.99);
		boolean result = FacadeClient.sendOrderEmailWithoutFacade(order);
		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));
		
		EmailFacade facade = new EmailFacade();
		result = facade.sendOrderEmail(order);
		System.out.println("Order Email "+ (result?"sent!":"NOT sent..."));
		
		System.out.println("\nFlyweight");
		SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getError(ErrorType.GenericSystemError);
		System.out.println(msg1.getText("4056"));
		
		UserBannedErrorMessage msg2 = ErrorMessageFactory.getInstance().getUserBannedMessage("1293");
		System.out.println(msg2.getText(null));
		
		
		System.out.println("\nProxy");
		my.project.proxy.Image img = ImageFactory.getImage("A1.bmp");
		img.setLocation(new Point2D(10,10));
		System.out.println("Image location: " + img.getLocation());
		img.render();
		
		my.project.proxy.Image dyn = ImageFactory.getDynamicImage("DUU.JPG");
		dyn.setLocation(new Point2D(-10,0));
		System.out.println(dyn.getLocation());
		dyn.render();

		System.out.println("\n\nChain of Responsabitily");
		LeaveApplication application = LeaveApplication.getBuilder()
				.withType(Type.Sick)
				.from(LocalDate.now()).to(LocalDate.of(2022, 9, 28))
				.build();
		LeaveApprover approver = ChainClient.createChain();
		approver.processLeaveApplication(application);
		System.out.println(application);
		
		
		System.out.println("\n\nCommand");
		CommandClient.run();
		
		
		System.out.println("\n\nInterpreter");
		Report report1 = new Report("Cashflow report", "FINANCE_ADMIN OR ADMIN");
		ExpressionBuilder ex_builder = new ExpressionBuilder();
		
		PermissionExpression exp = ex_builder.build(report1);
		System.out.println(exp);
		
		my.project.interpreter.User us1 = new my.project.interpreter.User("Dave", "USER", "ADMIN");
		System.out.println("User access report: " + exp.interpret(us1));
		
		
		System.out.println("\n\nIterator");
		Iterator<ThemeColor> iter = ThemeColor.getIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("\n\nMemento");
		MementoClient.execute();
		
		
		System.out.println("\n\nObserver");
		my.project.observer.Order oorder = new my.project.observer.Order("100");
		my.project.observer.PriceObserver price = new my.project.observer.PriceObserver();
		oorder.attach(price);
		
		oorder.addItem(50);
		oorder.addItem(179);
		System.out.println(oorder);
		
		
		System.out.println("\n\nState");
		my.project.state.Order os = new my.project.state.Order(); 
		os.paymentSuccessful();
		os.delivered();
		os.cancel();
		
		
		System.out.println("\n\nStrategy");
		my.project.strategy.StrategyClient.execute();
		
	}

}
