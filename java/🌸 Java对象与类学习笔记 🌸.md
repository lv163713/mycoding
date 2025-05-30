# 🌸 Java对象与类学习笔记 🌸

---

## 🌟1. 核心概念

### 🐶 对象（Object）
- **定义**：现实世界中的实体，比如`new Dog("旺财")`就是一只具体的狗狗🐶
- **特点**：
  ```java
  // 行为（方法） 
  public void bark() { System.out.println("汪汪！"); }
  
  // 状态（属性） 
  private String name;
  private int age;
  
  // 唯一标识（内存地址）
  Dog d1 = new Dog(); // d1有自己的独特记忆卡
  ```

### 🏗️ 类（Class）
- **定义**：创建对象的模板，就像橡皮泥模具！
  ```java
  public class Dog {
      // 模具里的刻痕（属性）
      private String breed;
      
      // 模具能做什么（方法）
      public void play() { System.out.println("玩球~"); }
  }
  ```

---

## 🌟2. 创建对象三部曲 🌈

```java
// ① 声明变量（准备一个盒子）
Dog myPet;

// ② 实例化（用模具造出橡皮泥）
myPet = new Dog();

// ③ 初始化（给橡皮泥上色）
myPet.setBreed("柴犬");
```

> 📌 小贴士：这三步可以合并写成 `Dog myPet = new Dog();`

---

## 🌟3. 构造方法（Constructor） 🧩

### 🎁 默认构造方法
```java
public class Cat {
    // 如果没有定义，编译器会自动创建无参构造
    public Cat() { 
        System.out.println("小猫出生啦！"); 
    }
}
```

### 🎁 多个构造方法
```java
public class Book {
    // 无参构造
    public Book() { }

    // 有参构造
    public Book(String title) {
        this.title = title;
    }

    // this关键字魔法：在构造方法里调用另一个构造方法
    public Book(String title, String author) {
        this(title); // 调用上面的有参构造
        this.author = author;
    }
}
```

---

## 🌟4. 成员变量 vs 局部变量 🌼

| 特性     | 成员变量（类里方法外） | 局部变量（方法里） |
| -------- | ---------------------- | ------------------ |
| 存储位置 | 堆内存（Heap）         | 栈内存（Stack）    |
| 默认值   | 有默认值（int=0等）    | 必须显式赋值       |
| 作用域   | 整个类                 | 当前方法/代码块    |
| 示例     | `private String name;` | `int age = 5;`     |

---

## 🌟5. this关键字魔法 ✨

```java
public class Student {
    private String name;

    // 构造方法
    public Student(String name) {
        this.name = name; // this.表示当前对象的属性
    }

    // 方法
    public void introduce() {
        System.out.println("我是" + this.name); // this可以省略
    }
}
```

---

## 🌟6. 对象的内存奥秘 🧠

```java
Dog d1 = new Dog();
Dog d2 = new Dog();

// d1和d2是两个不同的对象，就像两颗不同的星星✨
System.out.println(d1 == d2); // 输出 false

// 但是它们都遵循Dog类的模板！
d1.bark(); // 汪汪！
d2.bark(); // 汪汪！
```

---

## 🌟7. 实用代码示例 🌟

### 🐾 示例1：创建狗狗对象
```java
public class Dog {
    private String name;
    
    // 构造方法
    public Dog(String name) {
        this.name = name;
    }
    
    // 方法
    public void bark() {
        System.out.println(this.name + "在汪汪叫！");
    }
}

// 使用
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("小黄");
        myDog.bark(); // 输出：小黄在汪汪叫！
    }
}
```

### 🐱 示例2：猫咪的多重构造
```java
public class Cat {
    private String name;
    private String color;

    // 无参构造
    public Cat() { }

    // 有参构造
    public Cat(String name) {
        this.name = name;
    }

    // 两个参数的构造
    public Cat(String name, String color) {
        this(name); // 调用单参数构造
        this.color = color;
    }
}

// 使用
public class Main {
    public static void main(String[] args) {
        Cat c1 = new Cat(); // 空参数
        Cat c2 = new Cat("咪咪"); // 一个参数
        Cat c3 = new Cat("咪咪", "白色"); // 两个参数
    }
}
```

---

## 🌟8. 总结口诀（小女仆特制） 🎶

> 🐶 对象是实例，类是模具板  
> 🏗️ 三步造对象：声明+实例+初始化  
> 🧩 构造方法多，this来帮忙  
> 🌼 成员变量广，局部变量窄  
> 🧠 内存分堆栈，对象各不同  
> 🌟 多写多练习，编程变轻松！

---

# ------------------------------

# ✨ **Java 继承💖** ✨  

---

## 🌳 什么是继承？  
就像一家子，孩子可以继承父母的财产和特征一样～  
在 Java 中，**子类（Child Class）** 可以继承 **父类（Parent Class）** 的属性和方法。  

### ✅ 继承的好处：
- 提高代码复用性 💪  
- 实现层次结构清晰 👌  
- 支持多态的基础 😇  

---

## 🧱 基本语法

```java
class 父类 {
    // 属性、方法
}

class 子类 extends 父类 {
    // 子类特有的属性和方法
}
```

🌰 示例：

```java
class Animal {
    void eat() {
        System.out.println("动物会吃东西 🍽️");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("狗狗汪汪叫 🐶");
    }
}
```

使用方式：

```java
Dog dog = new Dog();
dog.eat();   // 继承自 Animal
dog.bark();  // 自己的方法
```

---

## 🚫 不能被继承的成员
- `private` 私有成员：子类看不见它们哦～  
- 构造方法：不会被继承，但可以通过 `super()` 调用父类构造器 💖  

---

## 🔄 方法重写（Override）
如果子类对父类的方法不满意，可以重新定义它！

### ✅ 重写规则：
- 方法名、参数列表必须相同 📝  
- 返回类型要兼容（一般相同）🔄  
- 访问权限不能比父类更严格 🔒  
- 抛出异常也不能比父类更宽泛 ⚠️  

🌰 示例：

```java
class Animal {
    void sound() {
        System.out.println("动物发出声音 🎵");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("猫咪喵喵叫 🐱");
    }
}
```

---

## 🔑 关键字 `super`
就像你偷偷喊妈妈帮忙一样～👩‍👧‍👦

- `super()`：调用父类构造器（必须放在子类构造器第一行）  
- `super.方法名()`：调用父类的方法 🙋‍♀️  

🌰 示例：

```java
class Animal {
    Animal() {
        System.out.println("父类Animal构造器被执行 🏠");
    }

    void move() {
        System.out.println("动物移动 🚶");
    }
}

class Fish extends Animal {
    Fish() {
        super();  // 调用父类构造器
        System.out.println("子类Fish构造器被执行 🐟");
    }

    @Override
    void move() {
        super.move();  // 调用父类方法
        System.out.println("鱼儿游啊游 🌊");
    }
}
```

---

## 🧩 Java 继承的特点

| 特点     | 描述                                                      |
| -------- | --------------------------------------------------------- |
| 单继承   | 一个子类只能有一个直接父类 ❗                              |
| 多层继承 | A ← B ← C，像家族传承一样 📜                               |
| 传递性   | 如果 C 继承 B，B 继承 A，C 拥有 A 和 B 的所有非私有成员 🧬 |

---

## 🔒 final 关键字（禁止继承）
就像给你的秘密日记加了锁🔒，别人就不能继承啦～

```java
final class SecretBook {
    // 这个类不能被继承 🚫
}
```

也可以用于方法，防止被重写。

---

## 📚 小女仆温馨提醒 ❤️
1. **命名规范要统一**，别让父类和子类搞混了 😅  
2. **合理使用继承**，不要滥用，避免类太多太乱 🤯  
3. **善用 super**，记得在构造器中调用父类构造器哦 🧸  

---

# ----------------------------

# 🎀 **Java 抽象类笔记💖** 🎀  

---

## 🤔 什么是抽象类？

就像魔法少女还没变身一样，**抽象类（abstract class）** 是一个“不完整的类”，它允许我们定义一些没有具体实现的方法（也就是抽象方法），需要子类去完成这些魔法✨。

---

## 📜 基本语法

```java
abstract class 类名 {
    // 抽象方法（没有方法体）
    abstract void 方法名();

    // 普通方法也可以有哦～
    void 普通方法() {
        System.out.println("我是一个普通的成员方法 💖");
    }
}
```

🌰 示例：

```java
abstract class Animal {
    // 抽象方法
    abstract void makeSound();

    // 普通方法
    void breathe() {
        System.out.println("动物在呼吸 🌬️");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("汪汪汪 🐶🐶");
    }
}
```

使用方式：

```java
Dog dog = new Dog();
dog.makeSound();   // 输出：汪汪汪 🐶
dog.breathe();     // 输出：动物在呼吸 🌬️
```

---

## 🔑 抽象类的特点 ✨

| 特点                   | 说明                                       |
| ---------------------- | ------------------------------------------ |
| 🧩 可以包含抽象方法     | 有抽象方法的类必须是抽象类                 |
| 🧸 可以有普通方法和属性 | 和普通类一样，可以封装数据和行为           |
| 🚫 不能直接实例化       | `new Animal()` ❌ 不行！                    |
| 👩‍👧‍👦 可以被继承         | 子类必须重写所有抽象方法，否则也得是抽象类 |
| 🧬 支持多层继承         | A ← B ← C，像魔法家族传承一样              |

---

## 🧱 抽象类 vs 普通类

| 对比项             | 抽象类                     | 普通类   |
| ------------------ | -------------------------- | -------- |
| 是否能创建对象     | ❌ 不可以                   | ✅ 可以   |
| 是否能包含抽象方法 | ✅ 可以                     | ❌ 不可以 |
| 是否必须重写方法   | ✅ 是（如果子类不是抽象类） | ❌ 否     |
| 构造器             | ✅ 有                       | ✅ 有     |

---

## 🧙‍♀️ 抽象类的设计原则 🌟

- **设计为模板类**：让子类按照你的规则来补全内容 🎭  
- **封装共用逻辑**：把大家都能用的方法放在抽象类里，减少重复代码 💡  
- **强制子类实现某些功能**：通过抽象方法约束子类的行为 🔒  

---

## 🌈 示例：图形计算面积

```java
abstract class Shape {
    abstract double getArea();  // 计算面积的抽象方法
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;  // 圆形面积公式
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;  // 矩形面积公式
    }
}
```

使用方式：

```java
Shape circle = new Circle(5);
System.out.println("圆的面积：" + circle.getArea());  // 输出圆面积

Shape rect = new Rectangle(4, 6);
System.out.println("矩形面积：" + rect.getArea());    // 输出矩形面积
```

---

## 💡 小女仆温馨提醒 ❤️

1. **抽象类不能用 final 修饰**：因为要继承呀～final 是锁死的意思啦🔒  
2. **构造器虽然存在，但不能 new**：只能通过子类调用 super() 初始化父类部分 🧸  
3. **合理使用抽象类**：适合具有共同行为但实现不同的场景，比如各种形状、支付方式等 🎨💸  

---

# -----------------------------

# 🎀 **Java 接口笔记💖** 🎀  

---

## 💬 什么是接口？

接口就像魔法契约📜，规定了类必须做什么，但不关心它是怎么做的。  
一个类可以“实现”多个接口，就像你可以同时拥有多个身份一样～✨

---

## 🧱 基本语法 ✨

```java
interface 接口名 {
    // 抽象方法（默认 public abstract）
    void 方法名();

    // 默认方法（JDK 8+）
    default void 默认方法名() {
        System.out.println("我是默认方法，子类可选实现 😇");
    }

    // 静态方法（JDK 8+）
    static void 静态方法名() {
        System.out.println("我是静态方法，直接通过接口调用 🚀");
    }

    // 私有方法（JDK 9+，用于辅助默认方法）
    private void 私有方法名() {
        System.out.println("我是一个私有方法，只能在接口内部使用 👻");
    }
}
```

🌰 示例：

```java
interface Flyable {
    void fly();  // 抽象方法

    default void startEngine() {
        System.out.println("引擎启动 ⛽✈️");
    }

    static void showInfo() {
        System.out.println("这是一个可以飞的东西 🌤️");
    }
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("小鸟拍拍翅膀飞起来啦 🐦🕊️");
    }
}
```

使用方式：

```java
Bird bird = new Bird();
bird.fly();           // 输出：小鸟拍拍翅膀飞起来啦 🐦
bird.startEngine();   // 输出：引擎启动 ⛽
Flyable.showInfo();   // 输出：这是一个可以飞的东西 🌤️
```

---

## 🔑 接口的特点 🌈

| 特点                             | 说明                           |
| -------------------------------- | ------------------------------ |
| 📜 只能定义抽象方法（以前是这样） | 现在也支持默认方法和静态方法啦 |
| 🚫 不能创建对象                   | `new Flyable()` ❌ 不行！       |
| 🧸 支持多实现                     | 一个类可以实现多个接口哦～     |
| 👩‍👧‍👦 没有构造器                   | 因为它不是类 😅                 |
| 📦 所有方法默认 public            | 不需要写 `public abstract`     |

---

## 🤝 接口 vs 抽象类 🆚

| 对比项                 | 接口                           | 抽象类                 |
| ---------------------- | ------------------------------ | ---------------------- |
| 是否只能定义抽象方法   | 否（JDK 8+ 支持默认/静态方法） | 否（也可以有普通方法） |
| 类可以继承几个         | 多个                           | 只能一个               |
| 成员变量是否默认 final | 是                             | 否                     |
| 是否支持多继承         | ✅ 是                           | ❌ 否                   |
| 构造器是否存在         | ❌ 否                           | ✅ 是                   |

---

## 🧩 接口的使用场景 🌟

- 定义行为规范（如：可飞行、可游泳）🐦🐟  
- 实现解耦合（模块之间通过接口通信）🔌  
- 实现多继承效果（Java 不支持多继承类，但可以通过接口实现类似功能）🔄  

---

## 🧙‍♀️ 示例：多个接口实现 🎀

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("鸭子也能飞 🦆✈️");
    }

    @Override
    public void swim() {
        System.out.println("鸭子游啊游 🦆💦");
    }
}
```

使用方式：

```java
Duck duck = new Duck();
duck.fly();   // 输出：鸭子也能飞 🦆✈️
duck.swim();  // 输出：鸭子游啊游 🦆💦
```

---

## 🌈 接口的继承 🧬

接口之间也可以继承！像魔法家族一样传递能力✨

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}

class MyClass implements B {
    public void methodA() {
        System.out.println("实现了来自A的方法 🌼");
    }

    public void methodB() {
        System.out.println("实现了B自己的方法 🌸");
    }
}
```

---

## 💡 小女仆温馨提醒 ❤️

1. **命名建议以形容词开头**，比如 `Flyable`, `Swimmable` 🎨  
2. **接口中变量默认是 public static final 的常量** 🧮  
3. **合理使用默认方法**，可以让接口升级更灵活而不破坏已有实现 🛠️  
4. **避免接口冲突**：如果两个接口有同名默认方法，子类要手动重写选择其中一个 😅  

---

# -----------------------------

# 🎀 **Java 多态笔记💖** 🎀

---

## 🌈 什么是多态？

多态，就是“同一个动作有多种表现形式”，就像我今天可以是女仆、明天可以是公主👸，但执行“打招呼”这个动作时，方式却不一样～✨

在 Java 中，**多态指的是一个父类引用指向子类对象**，并且在运行时根据实际对象调用对应的方法。  

---

## 🧱 多态的三大前提 ✨

1. **继承关系**：必须有父类和子类的关系 👩‍👧‍👦  
2. **方法重写（Override）**：子类必须重写父类的方法 🖋️  
3. **父类引用指向子类对象**：`Parent p = new Child();` 💖  

---

## 🔮 示例：动物叫叫叫 🐶🐱🐦

```java
abstract class Animal {
    abstract void speak();  // 抽象方法
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("汪汪汪！🐶");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("喵喵喵～ 🐱");
    }
}

class Bird extends Animal {
    @Override
    void speak() {
        System.out.println("叽叽喳喳 🐦");
    }
}
```

使用方式：

```java
Animal a1 = new Dog();
Animal a2 = new Cat();
Animal a3 = new Bird();

a1.speak();  // 输出：汪汪汪！🐶
a2.speak();  // 输出：喵喵喵～ 🐱
a3.speak();  // 输出：叽叽喳喳 🐦
```

看！虽然是同一个 `speak()` 方法，但不同对象执行的结果不一样哦～这就是多态的魅力呀！🌟

---

## 🤝 向上转型（Upcasting）🪄  
把子类对象赋值给父类引用，就像让狗狗穿上“动物”的外衣一样！

🌰 示例：

```java
Animal animal = new Dog();  // 合法 ✅
animal.speak();             // 输出：汪汪汪！🐶
```

---

## 📥 向下转型（Downcasting）🪄🪄  
把父类引用转成子类类型，就像脱掉外套变回狗狗本身！

⚠️ 注意：向下转型前最好先判断类型，不然会出错哦～

🌰 示例：

```java
Animal a = new Dog();

if (a instanceof Dog) {
    Dog dog = (Dog) a;
    dog.speak();  // 输出：汪汪汪！🐶
}
```

---

## 🎭 多态的应用场景 🌟

| 场景                     | 描述                                         |
| ------------------------ | -------------------------------------------- |
| **统一操作多个子类对象** | 比如所有动物都会叫，但叫声不同 🐾             |
| **代码解耦合**           | 让主程序只依赖接口或抽象类，不依赖具体实现 🛠️ |
| **配合集合使用**         | 存储多个子类对象到一个父类集合中 🗂️           |

🌰 配合集合示例：

```java
List<Animal> animals = new ArrayList<>();
animals.add(new Dog());
animals.add(new Cat());
animals.add(new Bird());

for (Animal animal : animals) {
    animal.speak();  // 根据实际类型自动调用对应方法 🎉
}
```

---

## 🧠 小女仆温馨提醒 ❤️

1. **只有方法才有运行时多态**，变量没有哦～  
2. **构造器不能多态**，因为不能被继承 😅  
3. **instanceof + 向下转型** 是安全操作的黄金组合 ⚠️  
4. **接口也可以多态**，比如 `List list = new ArrayList();` 就是一个经典例子 📚  

# -----------------------------

# 🎀 **Java 实体类（Entity Class）笔记💖** 🎀  

---

### 🧸 什么是实体类？

实体类就像我的魔法日记本一样，是用来描述现实世界中某个“事物”的 Java 类。  
它通常对应数据库中的一张表，用来封装数据，比如一个用户、一本书、一个订单……✨

专门用来存取数据的类，分层思想，对数据的处理交给其他的类来进行

---

## 📦 实体类的定义 🛏️

### ✨ 特点：
- 属性与数据库表字段一一对应 💡  
- 通常包含 getter 和 setter 方法 👗  
- 包含 `toString()` 方法方便查看内容 📝  
- 可以使用 Lombok 简化代码（后面会讲）📚  

🌰 示例：用户实体类

```java
public class User {
    private Long id;          // 用户ID
    private String username;  // 用户名
    private String password;  // 密码
    private String email;     // 邮箱
    private LocalDateTime createTime;  // 创建时间

    // Getter 和 Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    // toString()
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
```

---

## 🧩 实体类与数据库表的映射关系 🌟

| 数据库表 users | Java 实体类 User                 |
| -------------- | -------------------------------- |
| id             | private Long id                  |
| username       | private String username          |
| password       | private String password          |
| email          | private String email             |
| create_time    | private LocalDateTime createTime |

📌 注意：  
- 表字段名如果是下划线命名（如 `create_time`），在 Java 中建议用驼峰命名（`createTime`）  
- 建议使用 ORM 框架（如 MyBatis、Hibernate）自动完成映射 😇

---

## 🔧 使用 Lombok 简化代码 🪄✨

Lombok 是一个可以帮你自动生成 getter、setter、toString 等方法的小魔法棒！  
只需要加几个注解，就能省去很多重复代码～🪄

### 📦 添加依赖（Maven）：

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```

### ✨ 使用示例：

```java
import lombok.Data;

@Data  // 自动添加 getter、setter、toString、equals、hashCode 等方法
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createTime;
}
```

是不是简洁多了？💖

---

## 🧱 实体类的设计原则 🌈

| 原则       | 描述                                                        |
| ---------- | ----------------------------------------------------------- |
| 📝 封装性   | 所有属性都设为 private，通过 getter/setter 访问 🧸           |
| 🔄 命名规范 | 属性名与数据库字段保持一致或可映射（如驼峰命名）📝           |
| ⏰ 时间类型 | 推荐使用 `LocalDateTime` 或 `Date` 来表示日期时间 🕰️         |
| 🔍 主键类型 | 推荐使用包装类型（如 `Long` 而不是 `long`），支持 null 值 🧠 |
| 📦 分层结构 | 实体类一般放在 `entity` 或 `model` 包中 📁                   |

---

## 🧩 实体类的实际应用场景 🌟

| 场景           | 描述                                                       |
| -------------- | ---------------------------------------------------------- |
| 📤 接收前端参数 | 控制器(Controller)中用实体类接收请求参数 🧾                 |
| 📥 存入数据库   | 通过 ORM 框架保存到数据库表中 💾                            |
| 📦 返回给前端   | 作为 JSON 格式返回给客户端（Spring Boot 自动转换）🌐        |
| 📚 多个表关联时 | 可以创建 DTO（Data Transfer Object）来封装多个实体的数据 🧷 |

---

## 🧙‍♀️ 示例：Spring Boot 中使用实体类 🎀

### 📄 Controller 示例：

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 保存 user 到数据库...
        return ResponseEntity.ok(user);
    }
}
```

前端发送的 JSON：

```json
{
    "username": "xiaonvpu",
    "password": "123456",
    "email": "nvp@domain.com",
    "createTime": "2025-05-30T12:00:00"
}
```

Spring Boot 会自动将 JSON 映射成 `User` 对象 💖

---

## 💡 小女仆温馨提醒 ❤️

1. **不要把业务逻辑写在实体类里**，它只是数据容器哦～  
2. **推荐使用 Lombok**，让代码更干净整洁 💅  
3. **注意字段类型匹配**，避免插入数据库时报错 ❗  
4. **合理使用 DTO**，避免实体类过于臃肿 🧼  
5. **命名要统一**，比如 `userId` vs `id`，别搞混啦～

---

