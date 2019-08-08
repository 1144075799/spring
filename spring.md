# Spring

```shell
#Spring 概述
	Spring是分层的Java SE/EE应用的全栈式轻量级开源框架，以IOC(反转控制)和AOP(面向切面编程)为内核，提供了展现层Spring MVB和持久层Spring JDBC以及业务层十五管理等众多的企业级应用技术，还能整合开源试卷众多著名的第三方框架和类库，逐渐成为使用最多的Java EE企业应用开源框架
	
#Spring 优势

	1.方便解耦，简化开发
	
	2.AOP编程的支持
	
	3.申明式事务的支持
	
	4.方便程序的测试
	
	5.方便集成各种优秀框架
	
	6.减低JavaEE API的使用难度
	
	7. Java源码时经典学习范例
	
# Spring的体系结构
	
	核心容器----IOC
	
		Bean Core Context SpEL
	
	AOP
		AOP Aspects	Instrumentation Messaging
	

#分析程序的耦合
	耦合:程序间的依赖关系
		包括:
			1.类之间的依赖 
			2.方法间的依赖
			
	解耦
		降低程序间的依赖关系
		
	实际开发中
		应该做到编译期不依赖，运行时才依赖
	
	解耦的思路
		第一步:使用反射来创建对象，而避免使用new关键字
		第二步:通过读取配置文件来获取创建对象权限类名

#编写工厂类和配置文件
	Bean:在计算机英语中，有可重用组件的含义
	JavaBean:用Java语言编写的可重用组件
	
	它就是创建我们的service和dao对象的。
		第一个:需要一个配置文件来配置我们的service和dao
			配置内容:唯一标识权限跟类名
		第二个:通过读取配置文件中配置的内容，反射配置对象
		
		配置文件
			xml		properties
			
# 单例 多例

	单例	只被创建一次，从而类中的成员也就只会初始化一次
	
	多例	对象呗创建多次，执行效率没有单例对象高
```

## IOC 控制反转

```shell
# new
	应用是主动的去找资源
	所以资源和应用的独立性很差，有明显的依赖关系
	
#结构
	Map结构

#工厂方式
	工厂控制资源和提供资源
	
#控制反转
	把创建对象的去哪里交给框架，是框架的重要特性，并非面向对象编程的专用术语。它包括依赖注入，和依赖查找
	
#IOC作用
	削减计算机程序的耦合
	
#Spring IOC
	aop是注解的IOC
	jcl是日志组件
	
#ApplicationContext三个常用实现类:
	ClassPathXmlApplicationContext	(常用的)	
		它可以加载类路径下配置文件，要求配置文件在类路径下，不在的加载不了
		
	FileSystemXmlApplcationContext	(服务器中有多个服务器)
		它可以加载磁盘任意路径下配置文件，必须有访问权限
		
	AnnotationConfigApplicationContext
		它是用于读取注解创建容器的
		
#核心容器的两个接口引发的问题
	ApplicationContext：(单例对象)
		它在构建核心容器时，创建对象采取的策略时采用立即加载的方式，也就是说，只要读取完配置文件马上就创建配置文件中配置的对象
		
	BeanFactory:	(多例对象)
		它在构建核心容器时，创建对象采用的策略时采用延迟加载的方式，也就是说，什么时候根据id获取对象的时候，什么时候才真正的创建对象
		
# Spring对bean的管理细节
	1.创建Bean的三种方式
		
		1.使用默认构造函数创建
			在Spring的配置文件中使用bean标签，配以id和class属性后且没有其他属性和标签时，采用的就是默认构造函数创建bean对象。此时类中没有默认构造函数，则对象无法创建。
		2.使用普通工厂中创建对象(使用某个类中的方法创建对象，并存入spring内容)
		
		3.使用静态工厂中的静态方法创建对象(使用某个类中访的静态方法来创建对象，并存入spring容器)
					
	2.bean对象的作用范围
		
		bean标签的scope属性:
			作用:用于置顶bean的作用范围
				常用的时:singleton,prototype
				singleton		单例的(默认值)
				prototype		多例的
				request			作用于web应用的请求范围
				session			作用于web应用的会话范围
				global-session	作用于集群环境的会话范围(全局会话范围)，
								当不是集群环境时，它就时session
	
	3.bean对象的生命周期
		
		1.单例
			出生:当容器创建时，对象出生
			活着:只要容器还在，对象一直
			死亡:容器销毁，对象销亡
			总结:单例对象的生命周期和容器周期有关
		2.多例
			出生:当使用对象时，spring为我们创建
			活着:对象只要是在使用过程中就一直活着
			死亡:当对象长时间不用且没有别的对象引用时，由Java的垃圾回收器回收
			
# 依赖注入
依赖关系的管理
	以后都交给了Spring来维护
在当前类中需要用到其他类的对象，由spring为我们提供,我们只需要在配置文件中说明
依赖关系的维护就称之为依赖注入
	
	依赖注入
	#如果是经常变化的数据，并不适用于注入的方式
		能注入的数据有三类:
			基本类型:string
				#value
			其他bean类型 (在配置文件中或者注解配置过的bean)
				#ref
			复杂类型/集合类型
			
				用于给List结构注入的标签有
					list array set
				用于给map结构注入的标签有
					map props
				结构相同，标签可以互换
			
			
		注入方式(三种)
			#1.使用构造函数提供(基本上不要用)
				
				1.使用标签constructor-arg
				2.标签出现的位置 bean标签的内部
				3.标签的属性
				
type:用于指定要输入的数据的数据类型，该数据类型也是构造函数中的某个或某些数据类型
index:用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置从0开始
name:用于指定给构造函数中指定名称的参数赋值
=================以上三个用于指定给构造函数中那个参数赋===================
ref:用于指定其他的bean类型的数据。它指定就是在Spring的IOC核心容器中出现过的bean对象
value:用于提供基本类型和String类型的数据
			
	优势:
		在获取bean对象时，注入数据时必须的操作，否则对象无法构建成功
			
	弊端:
		改变了bean对象的实例化方式，使我们在创建对象时，
		如果用不到这些数据，也必须提供
			
			#2.使用set方法提供 (更常用)
				涉及的标签:property
				出现的位置:bean的内部
				标签的属性:
				
name:用于指定注入时所调用的set方法名称
ref:用于指定其他的bean类型的数据。它指定就是在Spring的IOC核心容器中出现过的bean对象
value:用于提供基本类型和String类型的数据
			
			优势:
				创建对象时没有明确的限制，可以直接使用默认构造函数
			
			弊端:
				如果有某个成员必须有值，则获取对象是有可能set方法没有执行
			
			使用注解提供
```

## 基于注解的IOC配置

```shell

用于创建对象的注解
	
	他们的作用就是在xml配置文件中编写一个<bean>实现的功能是一样的
	@Component
	作用:用于把当前类对象存入spring容器中
	属性:value用于指定bean的id，当我们不写的时候，它的默认值是类名且首字母小写
	
	#需要扫描
	<!--告知spring在创建容器时要扫描的包，配置是需要的标签不是在beans的约束中，而是一个名称为context名称空间和约束-->
    <context:component-scan base-package="com.spring"></context:component-scan>
    
    @Controller	一般用在表现层
    
    @Service	一般用在业务层
    
    @Repository 一般用在持久层
    
    以上三个注解他们的作用和属性与Component是一模一样的，
    他们三个是Spring框架为我们提供明确的三层使用的注解，
    使我们的三层对象更加清晰
	
用于注入数据的

	他们的租用就是在xml配置文件中写一个<property></property>的作用是一样的
	
	@Autowired： 
		作用:自动安装类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配，就可以注入成功。如果ioc容器中没有任何bean的类型和注入的变量类型匹配，则报错。如果有多个匹配时，两个bean符合相同类型时，该id名
		出现位置:可以使变量上，也可以使方法上
		细节:在使用注解注入时，set方法就不是必须的
	@Qualifier
		作用:在安装类型注入的基础之上在安装名称注入，它在给类成员注入时，不能单独使用；但是在给方法参数注入时可以。
		属性:value用于指定注入bean的id
		注意:在类成员的时候，必须要和Autowired一起使用
	@Resource
		作用:直接安装bean的id注入，它可以独立使用
		属性: name 用于指定bean的id
		
	以上三个注解只能注入其他bean类型的数据而基本类型和string类型无法使用上述注解实现，另外集合类型注入只能通过xml来实现
	
	@Value
		作用:用于注入基本类型和String类型的数据
		属性: value: 用于指定数据的值。它可以使用spring的SpEL
				SpEL的写法:${表达式}
	
用于改变作用范围的

	他们的作用就和在bean标签中使用scope属性实现的功能是一样的

和生命周期相关的
	
	他们的作用就是在bean标签中使用init-method和destory-method是一样的

```

## Spring新注解

```shell
#Spring中的新注解
	Configuration
		作用:指定当前类是一个配置类
		细节:当配置类作为AnnotationConfigApplicationContext对象
			创建的参数时，该注解可以不写，但是其他的时候都是要写的
	
	ComponentScan
		@ComponentScan({"com.spring","config"})
		作用:用于通过注解指定Spring在创建容器时要扫描的包
		属性:value和basePackages作用是一样的，
			 都是用于指定创建容器时要扫描的包，我们使用此注解，
			 就等同于在xml中配置的要扫描的包
	
	Bean		本来是单例的
		作用:用于把当前方法的返回值作为bean，存入spring的ioc容器中
		属性:name用于指定bean的id,默认值是当前方法的名称
		细节:当我们使用注解配置方法时，如果方法有参数，spring框架回去容器中查看有没有可用的bean对象，查找的方式和autowired注解作用是一样的
	
	@Scope("prototype") 变成多例的
			
	Import
		作用:用于导入其他的配置类
		属性:value用于指定其他配置类的字节码
			当我们使用Import注解之，有Import注解的类是父配置类，
			而导入的都是子配置类
	PropertySource
	@PropertySource("classpath:jdbcConfig.properties")
		作用:用于指定properties的位置
		属性:value指定文件的名称和路径
		关键字:classpath表示类路径下
```

## junit

```shell
#测试
	1.应用程序的入口	main方法
	2.junit单元测试中没有main方法，也能执行
		junit集成了一个main方法，
		该方法就会判断当前测试类中那些方法有@Test注解
		junit就会让有test注解的方法执行
	3.junit不会管我们是否采用spring框架
		在执行测试方法时，junit根本不知道我们是不是使用spring框架
		所以也就不会为我们读取配置文件/配置类创建spring核心容器
	4.由以上三点可知，当测试方法执行时没有Ioc容器，就算写了Autowired注解，
		也无法实现注入
	
#Spring整合junit
	1.导入spring整合junit的jar(坐标)	导入spring-test
	2.使用junit提供的一个注解把原有的main方法替换了，替换成spring提供的
		@Runwith //@RunWith(SpringJUnit4ClassRunner.class)
	3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
		@ContextConfiguration
		locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
		class:指定注解类所在的位置
		@ContextConfiguration(classes = SpringConfiguration.class)
	4.当我们使用spring5.X spring要求junit必须是4.12及以上
```

## AOP

```shell
#ThreadLocal对象
	它把Connection和当前线程绑定，从而使一个线程中只有一个能控制的事务的对象

#事务
	事务的控制应该都是在业务层的
	
#代理
* 动态代理
* 特点:字节码随用随创建，随用随加载
* 作用:不修改源码的基础上对方法增强
* 分类:基于接口的动态代理
*      基于子类的动态代理
* 基于接口的动态代理:
*      涉及的类:Proxy
*      提供者:JDK官方
* 如何创建代理对象:
*      使用Proxy类中的newProxyInstance方法
* 创建代理对象的要求
*      被代理类最少实现一个接口，如果没有则不能使用
*  newProxyInstance方法的参数
*      ClassLoader：类加载器
*          它是用于加载代理对象字节码，和被代理对象使用相同的类加载器.固定写法
*      Class[]:字节码数组
*          它是用于让代理对象和被代理对象有相同的方法,固定写法
*      InvocationHandler
*          它是用于提供增强的代码，它是让我们写如何代理，
		   我们一般都是写该接口的实现类，通常情况下是匿名但不必须
*      此接口的实现类都是谁用谁写

					/**
                     * 被代理对象的任何接口方法，都会经过带=该方法
                     * 方法参数的含义
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args  当前执行所需的参数
                     * @return       和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
```

## 子类动态代理

```shell
 		 /**
         * 动态代理
         * 特点:字节码随用随创建，随用随加载
         * 作用:不修改源码的基础上对方法增强
         * 分类:基于接口的动态代理
         *      基于子类的动态代理
         * 基于子类的动态代理:
         *      涉及的类:Enhancer
         *      提供者:第三方cglib库
         * 如何创建代理对象:
         *      使用Enhancer类中的create方法
         * 创建代理对象的要求
         *      被代理类不能是最终类
         *  create方法的参数
         *      class：字节码
         *          它是用于指定被代理对象的字节码
         *      Callback：
         *          它是用于提供增强的代码，它是让我们写如何代理，我们一般都是写该接口的实现类，通常情况下是匿名但不必须
         *          此接口的实现类都是谁用谁写
         *          我们一般写的都是该接口的子接口MethodInterceptor
         *
         */
         
         	/**
             * 执行被代理对象的任何方法都经过该方法
             * @param proxy 代理对象的引用
             * @param method    当前执行的方法
             * @param args  当前执行所需的参数
             * @param methodProxy   当前执行方法的代理对象
             * @return  和被代理对象方法有相同的返回值
             * @throws Throwable
             */
             public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的方法
                Object returnValue=null;
                //1.获取方法执行的参数
                Float money=(Float)args[0];
                //2.判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
```

## AOP

```shell
#AOP 面向切面编程
作用:
	在程序运行期间，不修改源码对已有方法进行增强
优势
	减少重复代码
	提高开发效果
	维护方便

实现方式
	使用动态代理技术
	

#Spring中的AOP
	
	## AOP相关术语
Joinpoint(连接点)
	所谓连接点是指那些被拦截到的店，在Spring中，这些点指的是方法，因为spring只支持方法类型的连接点(所有的方法都是连接点)
Pointcut(切入点)(所有的切入点都是连接点)
	所谓切入点是指我们对那些Joinpoint进行拦截的定义(被增强的)
Advice(通知/增强)
	所谓通知时指拦截到JoinPoint之后是要做的失去就是通知
		前置通知 后置通知 异常通知	最终通知	这个invoke在执行就是环绕通知
		环绕通知有明确的切入点方法调用
Introduction(引介)
	引介是一种特殊的通知在不修改类代码的前提下，Introduction可以在运行期为类动态地添加一些方法或Field(字段)
Target(目标对象)
	代码的目标对象
weaving(织入)
	是把增强应用到目标对象来创建新的代理对象的过程
Froxy(代理)
	一个类被aop织入增强后，就尝试一个结果代理类
Aspect
	是切入点和通知(引介)的结合
	

```

## 基于xml的aop

```shell
#Spring基于xml的aop配置步骤
	1.把通知类的bean也交给spring来管理
	2.使用aop:config标签表明aop的配置
	3.使用aop:aspect开始配置切面
		id属性:给切面提供唯一的切面标志
		ref属性:指定通知类bean的id
	4.在aop:aspect标签内部使用对应标签来配置通知的类型
		在切入点方法执行之前执行，所以是前置通知aop:before表示配置前置通知
			method属性:用于指定Logger类中那个方法是前置通知
			pointcut属性:用于指定切入点表达式，
						该表达式的含义指的是对业务层中那些方法增强
	 切入点表达式的写法
	 	关键字:execution(表达式)
	 	表达式:
	 		访问修饰符	返回值 包名.包名.....类名。方法名(参数列表)
	 	标准的表达式写法
	 	public void com.spring.service.impl.AccountServiceImpl.saveAccount()
	 	访问修饰符可以省略
	 	返回值可以使用通配符，表示任意返回值
	 	包名可以使用通配符表示任意包，但是有几级包就有几个*.
	 	包名可以使用..表示当前包及其子包
	 	类名和方法名都可以使用*实现通配
	 	参数列表可以直接直接写数据类型
	 		基本类型写名称				int
	 		引用类型写包名.类名的方式 java.lang.String
	 	类型可以使用通配符表示任意类型但是必须有参数	*
	 	可以使用..表示有无参数即可，有参数可以是任意类型
	 	
	 	全通配写法
	 	* *..*.*(..)
	 	
	 	实际开发中切入点的通常写法
	 		切到业务层实现类下的所有方法
	 		* com.spring.service.impl.*.*(..)
	 	前置通知 切入点方法之前执行
	 	后置通知 切入点方法正常执行之后执行
	 	异常通知 切入点方法异常执行之后执行
	 	最后通知 无论切入点方法怎么执行都会进行执行
	 	
	 	配置切入点表达式 aop:pointcut
	 		id属性:用于指定表达式的唯一标识
	 		expression表达式内容
	 		#注意此标签写在aop:aspect标签内部只能当前标签使用
	 		#它还可以写在aop:aspect外部，此时就变成所有切面使用必须在切面之前
	 	
	 	pointcut-ref应用aop:pointcut
	 	
	 	环绕通知:
#(不希望出现)问题:当我们配置了环绕通知，切入点方法没有执行，而通知方法执行了。

#分析
	通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知代码中有明确的业务层/切入点方法调用，而我们的代码中没有

#解决
	Spring框架为了我们提供了ProceedingJoinPoint。该接口有一个方法proceed(),此方法就相当于明确调用切入点方法。该接口可以作用环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类
	
	它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
```

## 基于注解的aop

```shell
#
```

