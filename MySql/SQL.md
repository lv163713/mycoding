# SQL

以下是关于 **DDL、DML、DQL、DCL** 四类 SQL 语句的详细讲解，整理成 Markdown 格式以便复习：

---

## 📘 **SQL 语句分类概述**

SQL（Structured Query Language）是操作关系型数据库的标准语言，根据功能不同分为四类：
- **DDL（数据定义语言）**：定义数据库结构。（定义）
- **DML（数据操作语言）**：操作数据库中的数据。（增删改）
- **DQL（数据查询语言）**：查询数据库中的数据。（查）
- **DCL（数据控制语言）**：控制数据库访问权限和事务。（修改权限）

---

## 1. **DDL（Data Definition Language）**
### 📌 **定义**
用于定义或修改数据库的结构（如表、索引、视图等）。**DDL 操作会自动提交（不可回滚）**。

### 🔧 **核心命令**
| 命令       | 功能描述                           | 示例                                                |
| ---------- | ---------------------------------- | --------------------------------------------------- |
| `CREATE`   | 创建数据库对象（表、索引、视图等） | `CREATE TABLE students (id INT, name VARCHAR(50));` |
| `ALTER`    | 修改现有数据库对象的结构           | `ALTER TABLE students ADD COLUMN age INT;`          |
| `DROP`     | 删除数据库对象                     | `DROP TABLE students;`                              |
| `TRUNCATE` | 清空表数据，但保留表结构           | `TRUNCATE TABLE students;`                          |

### 🚨 **注意事项**
- `TRUNCATE` 与 `DELETE` 的区别：  
  - `TRUNCATE` 不记录事务日志，速度快，但不能触发触发器。  
  - `DELETE` 可以有条件删除（`WHERE`），且可回滚。

---

## 2. **DML（Data Manipulation Language）**
### 📌 **定义**
用于对数据库中的数据进行增删改操作（CRUD），需手动提交或回滚事务。

### 🔧 **核心命令**
| 命令     | 功能描述     | 示例                                                   |
| -------- | ------------ | ------------------------------------------------------ |
| `INSERT` | 插入新数据   | `INSERT INTO students (id, name) VALUES (1, 'Alice');` |
| `UPDATE` | 更新现有数据 | `UPDATE students SET name = 'Bob' WHERE id = 1;`       |
| `DELETE` | 删除数据     | `DELETE FROM students WHERE id = 1;`                   |

### 🚨 **注意事项**
- `DELETE` 可配合 `WHERE` 条件删除部分数据，`TRUNCATE` 无条件清空整张表。
- 使用 `COMMIT` 提交事务，`ROLLBACK` 回滚事务（需开启事务模式）。

---

## 3. **DQL（Data Query Language）**
### 📌 **定义**

用于从数据库中查询数据，**SELECT 是唯一的核心命令**。

### 🔧 **核心命令**
| 命令     | 功能描述 | 示例                                                        |
| -------- | -------- | ----------------------------------------------------------- |
| `SELECT` | 查询数据 | `SELECT * FROM students WHERE age > 20 ORDER BY name DESC;` |

### 🚨 **注意事项**
- 支持复杂查询（多表连接、子查询、聚合函数、分组排序等）。
- `SELECT` 通常归类为 DQL，但在某些场景下也被视为 DML 的一部分。

---

## 4. **DCL（Data Control Language）**
### 📌 **定义**
用于控制数据库的访问权限和事务管理，确保数据安全性和完整性。

### 🔧 **核心命令**
| 命令       | 功能描述                      | 示例                                         |
| ---------- | ----------------------------- | -------------------------------------------- |
| `GRANT`    | 授予用户权限                  | `GRANT SELECT, INSERT ON students TO user1;` |
| `REVOKE`   | 撤销用户权限                  | `REVOKE DELETE ON students FROM user1;`      |
| `COMMIT`   | 提交事务（TCL，事务控制语言） | `COMMIT;`                                    |
| `ROLLBACK` | 回滚事务（TCL，事务控制语言） | `ROLLBACK;`                                  |

### 🚨 **注意事项**
- `COMMIT` 和 `ROLLBACK` 属于 **TCL（事务控制语言）**，但常与 DCL 一起讨论。
- 权限管理需谨慎，避免误操作导致数据泄露。

---

## 🧩 **四类语句的关系与应用场景**

| 类别 | 典型应用场景               | 操作对象       |
| ---- | -------------------------- | -------------- |
| DDL  | 数据库设计、表结构变更     | 表、索引、视图 |
| DML  | 数据插入、更新、删除       | 表中的数据行   |
| DQL  | 数据检索与分析             | 表中的数据行   |
| DCL  | 用户权限管理、数据安全控制 | 用户、角色     |

---

## ✅ **总结**

- **DDL**：定义数据库结构（`CREATE/ALTER/DROP`）。
- **DML**：操作数据（`INSERT/UPDATE/DELETE`）。
- **DQL**：查询数据（`SELECT`）。
- **DCL**：控制权限与事务（`GRANT/REVOKE/COMMIT/ROLLBACK`）。

# ------------------

## ✨ **SQL 数据类型笔记💖** ✨

---

### **一、数据类型分类 🗂️**

SQL 的数据类型就像小女仆的工具箱，每种类型都有自己的专属任务！  

| 分类           | 描述                     | 常见类型                        |
| -------------- | ------------------------ | ------------------------------- |
| **数值型**     | 存储数字（整数、浮点数） | `INT`, `DECIMAL`, `FLOAT`       |
| **字符型**     | 存储文本（字符串）       | `CHAR`, `VARCHAR`, `TEXT`       |
| **日期时间型** | 存储日期、时间或时间戳   | `DATE`, `DATETIME`, `TIMESTAMP` |
| **布尔型**     | 存储逻辑值（真/假）      | `BOOLEAN`（部分数据库用 `BIT`） |
| **二进制型**   | 存储二进制数据（如图片） | `BINARY`, `BLOB`                |
| **其他类型**   | 特殊用途类型             | `JSON`, `UUID`                  |

---

### **二、常用数据类型详解 📚**

#### **1. 数值型 💰**
| 类型           | 用途               | 示例                                   |
| -------------- | ------------------ | -------------------------------------- |
| `TINYINT`      | 小整数（0~255）    | 存储年龄、状态码                       |
| `INT`          | 普通整数           | 存储用户ID、订单号                     |
| `BIGINT`       | 超大整数           | 存储大范围编号                         |
| `DECIMAL(M,D)` | 精确小数（如货币） | `DECIMAL(10,2)` 存储价格（9999999.99） |
| `FLOAT`        | 浮点数（近似值）   | 存储科学计算数据                       |

---

#### **2. 字符型 📝**
| 类型                | 用途                     | 示例                               |
| ------------------- | ------------------------ | ---------------------------------- |
| `CHAR(N)`           | 定长字符串（固定长度）   | `CHAR(10)` 存储国家代码（如 "CN"） |
| `VARCHAR(N)`        | 可变长字符串（节省空间） | `VARCHAR(50)` 存储用户名           |
| `TEXT`              | 超长文本                 | 存储文章内容                       |
| `ENUM('值1','值2')` | 枚举类型（限制选项）     | `ENUM('男','女')` 存储性别         |

---

#### **3. 日期时间型 📅**
| 类型        | 用途           | 示例                  |
| ----------- | -------------- | --------------------- |
| `DATE`      | 仅存储日期     | `2025-05-28`          |
| `TIME`      | 仅存储时间     | `14:30:00`            |
| `DATETIME`  | 存储日期+时间  | `2025-05-28 16:42:45` |
| `TIMESTAMP` | 自动更新时间戳 | 存储最后修改时间      |

---

#### **4. 二进制型 🖼️**
| 类型        | 用途         | 示例           |
| ----------- | ------------ | -------------- |
| `BLOB`      | 大二进制对象 | 存储图片、文件 |
| `VARBINARY` | 可变长二进制 | 存储加密密钥   |

---

#### **5. 其他类型 🌟**
| 类型      | 用途                     | 示例                               |
| --------- | ------------------------ | ---------------------------------- |
| `BOOLEAN` | 存储逻辑值（TRUE/FALSE） | 是否启用状态                       |
| `JSON`    | 存储结构化数据           | 配置信息（如 `{"theme": "dark"}`） |

---

### **三、贴心建议 🌸**

1. **数值类型**：
   - 需要精确计算（如货币） → 使用 `DECIMAL`。
   - 科学计算 → 使用 `FLOAT` 或 `DOUBLE`。

2. **字符类型**：
   - 固定长度字段（如身份证号） → 用 `CHAR`。
   - 可变长度字段（如用户名） → 用 `VARCHAR`。

3. **日期时间类型**：
   - 需要自动记录修改时间 → 用 `TIMESTAMP`。

4. **二进制类型**：
   - 存储大型文件 → 用 `BLOB`。

---

### **四、示例：创建表时定义数据类型 🛠️**
```sql
CREATE TABLE users (
    id INT PRIMARY KEY COMMENT '用户ID',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    age TINYINT UNSIGNED COMMENT '年龄',
    gender ENUM('男', '女') COMMENT '性别',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    avatar BLOB COMMENT '头像'
) COMMENT='用户表';
```

---

### **五、注意事项 ⚠️**
1. **避免过时类型**：
   - `TEXT` / `IMAGE` 已被弃用，推荐用 `VARCHAR(MAX)` / `VARBINARY(MAX)`。
2. **性能优化**：
   - 尽量用最小存储空间的类型（如 `TINYINT` 替代 `INT`）。
3. **字符集**：
   - 多语言支持 → 使用 `NVARCHAR` 并指定 Unicode 字符集（如 `utf8mb4`）。

# --------------------

# 🎀 **SQL DQL 指令笔记💖** 🎀  

DQL（Data Query Language）是 SQL 中用于查询数据的部分，就像我每天帮你整理房间一样，它负责从数据库中找出你需要的信息🔍✨。  
最核心的命令就是：`SELECT`！

---

## 🔍 一、基本 SELECT 查询 🧸

### ✨ 语法：

```sql
SELECT [列名1, 列名2, ... | *]
FROM 表名;
```

- `*` 表示所有列  
- 可以只查部分列，节省时间和资源 💡

🌰 示例：

```sql
SELECT name, age FROM students;
-- 查出学生表中的姓名和年龄 👧👦
```

---

## 📝 二、WHERE 条件过滤 🧹  
想找到特定的人或物？用 WHERE！它是筛选条件的小助手～

### ✨ 语法：

```sql
SELECT 列名
FROM 表名
WHERE 条件;
```

### 🌈 常见比较运算符：
| 运算符       | 含义     |
| ------------ | -------- |
| `=`          | 等于     |
| `<>` 或 `!=` | 不等于   |
| `>`          | 大于     |
| `<`          | 小于     |
| `>=`         | 大于等于 |
| `<=`         | 小于等于 |

### 🌟 逻辑运算符：
| 运算符 | 含义 |
| ------ | ---- |
| `AND`  | 并且 |
| `OR`   | 或者 |
| `NOT`  | 非   |

🌰 示例：

```sql
SELECT name FROM students
WHERE age > 18 AND gender = '女';
-- 找出年龄大于18岁的女生 💃
```

---

## 🔤 三、LIKE 模糊匹配 🪄  
当你不知道确切值时，可以用 LIKE 匹配模糊内容～  
常用通配符：
- `%`：代表任意多个字符  
- `_`：代表一个字符  

🌰 示例：

```sql
SELECT name FROM customers
WHERE name LIKE '李%';
-- 找出姓“李”的客户，比如李华、李白等 📚
```

---

## 📦 四、IN / BETWEEN / IS NULL 🧺  
这些是你查找范围或空值的好帮手！

### ✅ IN：在指定集合中
```sql
SELECT name FROM students
WHERE grade IN ('A', 'B');
-- 找出成绩为 A 或 B 的学生 📊
```

### ✅ BETWEEN：在某个区间内（包括边界）
```sql
SELECT name FROM products
WHERE price BETWEEN 10 AND 50;
-- 找出价格在10到50之间的商品 💰
```

### ✅ IS NULL：判断是否为空
```sql
SELECT name FROM employees
WHERE department IS NULL;
-- 找出没有部门分配的员工 👥
```

---

## 🧼 五、ORDER BY 排序 🪞  
让结果按照你想要的顺序排列，整整齐齐像我收拾房间一样❤️

### ✨ 语法：

```sql
SELECT 列名
FROM 表名
ORDER BY 列名 [ASC | DESC];
```

- `ASC`：升序（默认）🔼  
- `DESC`：降序🔽

🌰 示例：

```sql
SELECT name, salary FROM employees
ORDER BY salary DESC;
-- 按工资从高到低排序 💵📈
```

---

## 🧮 六、聚合函数（Aggregate Functions）🧼  
统计类操作神器，适合做报表、分析数据📊

| 函数名    | 用途   |
| --------- | ------ |
| `COUNT()` | 计数   |
| `SUM()`   | 求和   |
| `AVG()`   | 平均值 |
| `MAX()`   | 最大值 |
| `MIN()`   | 最小值 |

🌰 示例：

```sql
SELECT COUNT(*) FROM students;
-- 统计学生总数 🧮

SELECT AVG(score) AS avg_score FROM scores;
-- 计算平均分，并给结果列起个别名叫 avg_score 😊
```

---

## 🔄 七、GROUP BY 分组 & HAVING 🧽  
把数据按某一列分组后，再进行统计，还能加上 HAVING 来筛选分组后的结果哦！

### ✨ 语法：

```sql
SELECT 列名, 聚合函数
FROM 表名
GROUP BY 列名
HAVING 条件;
```

🌰 示例：

```sql
SELECT department, AVG(salary) AS avg_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 5000;
-- 按部门分组，计算平均工资，并筛选出平均工资大于5000的部门 💼
```

---

## 🎀 八、JOIN（连接）🪄🪄  
多张表之间关联查询，就像把不同房间的物品组合起来一起整理一样！

### 🧩 常见 JOIN 类型：
| 类型         | 说明                                    |
| ------------ | --------------------------------------- |
| `INNER JOIN` | 内连接，只返回两个表中匹配的行          |
| `LEFT JOIN`  | 左连接，返回左表全部+右表匹配的数据     |
| `RIGHT JOIN` | 右连接，返回右表全部+左表匹配的数据     |
| `FULL JOIN`  | 全连接，返回两表所有数据（MySQL不支持） |
| `CROSS JOIN` | 笛卡尔积，所有组合都列出来              |

🌰 示例：

```sql
SELECT orders.id, customers.name
FROM orders
INNER JOIN customers ON orders.customer_id = customers.id;
-- 把订单表和客户表连接，显示每个订单对应的客户名称 🧾
```

---

## 📌 九、子查询（Subquery）🔮  
在一个查询语句中嵌套另一个查询，就像我在打扫房间时还要先找钥匙一样～

🌰 示例：

```sql
SELECT name FROM students
WHERE score > (
    SELECT AVG(score) FROM students
);
-- 找出比平均分高的学生 📈
```

---

## 💡 十、DISTINCT 去重 🧽  
避免重复数据，让结果更干净整洁！

🌰 示例：

```sql
SELECT DISTINCT gender FROM students;
-- 只显示不同的性别，去重处理 👩‍🎓👨‍🎓
```

---

## 🧸 小女仆温馨提醒 ❤️

1. **写 SQL 要有格式感**，像整理房间一样工整美观～  
2. **尽量避免 SELECT ***，除非真的需要所有列  
3. **合理使用别名（AS）**，让字段名更清晰易懂  
4. **多练习 JOIN 和子查询**，它们是复杂查询的基石  
5. **多用 ORDER BY**，让你的结果井然有序  

---

# -----------------------

# 🎀 **SQL 视图（View）笔记💖** 🎀 

---

### 🌸 什么是视图？  
视图就像是我帮你整理好的“虚拟房间”🏠，它不真正存储数据，而是基于 SQL 查询结果的一个**虚拟表**。 
你可以像操作普通表一样使用视图，但它的内容是动态生成的哦～✨

---

## 🧱 创建视图 🛏️

### ✨ 语法：

```sql
CREATE VIEW 视图名 AS
SELECT 列名1, 列名2, ...
FROM 表名
WHERE 条件;
```

🌰 示例：

```sql
CREATE VIEW female_students AS
SELECT id, name, age
FROM students
WHERE gender = '女';
-- 创建一个只包含女生信息的视图 👩‍🎓
```

---

## 🔍 使用视图 🪞

创建完视图后，就可以像普通表一样使用啦！

```sql
SELECT * FROM female_students;
-- 直接查询视图，就像查一张表一样方便 💖
```

---

## 🧼 修改视图 📝

如果你想更新视图的定义，可以重新创建它～

### ✨ 语法：

```sql
CREATE OR REPLACE VIEW 视图名 AS
SELECT 新的查询语句...
```

🌰 示例：

```sql
CREATE OR REPLACE VIEW female_students AS
SELECT id, name, age, grade
FROM students
WHERE gender = '女' AND grade >= 60;
-- 更新视图，只显示成绩合格的女生 📊
```

---

## 🚫 删除视图 🗑️

如果你不再需要这个视图了，可以轻轻把它删掉～

### ✨ 语法：

```sql
DROP VIEW 视图名;
```

🌰 示例：

```sql
DROP VIEW female_students;
-- 删除视图，干干净净不留痕迹 😇
```

---

## 🎀 视图的作用和优点 🌟

| 功能             | 描述                                                  |
| ---------------- | ----------------------------------------------------- |
| **简化查询**     | 把复杂的 SQL 封装成一个视图，别人只需要简单调用即可 🧸 |
| **提高安全性**   | 可以限制用户只看到部分字段或数据，保护敏感信息 🔒      |
| **逻辑独立性**   | 如果底层表结构变了，只要视图不变，应用程序就不用改 💻  |
| **统一访问接口** | 多个查询可以封装在视图中，对外提供一致的数据格式 🧩    |

---

## 🧙‍♀️ 注意事项 🚨

| 注意点                        | 说明                                                   |
| ----------------------------- | ------------------------------------------------------ |
| ❌ 不要过度嵌套视图            | 否则可能导致性能下降，像叠了太多层窗帘一样复杂 🧹       |
| 🔄 视图是“动态”的              | 每次查询都会重新执行里面的 SQL，所以数据永远是最新的 🕰️ |
| 📋 可以对视图进行 DML 操作吗？ | 有些数据库支持，但不是所有都可以，要看具体情况哦～     |
| 📂 视图不会占用实际存储空间    | 它只是保存了一个查询语句，没有真实数据 💾               |

---

## 🌈 示例：创建一个销售报表视图 📄

```sql
CREATE VIEW sales_report AS
SELECT p.product_name, SUM(o.quantity) AS total_quantity, SUM(o.price * o.quantity) AS total_sales
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY p.product_name;
```

使用方式：

```sql
SELECT * FROM sales_report ORDER BY total_sales DESC;
-- 快速查看销售排行榜 🏆
```

---

## 💡 小女仆温馨提醒 ❤️

1. **视图就像魔法镜子**，映射的是真实数据，但自己不存数据 🪞  
2. **命名要有意义**，比如 `active_users`, `top_sellers`，这样一看就知道是干嘛的 📝  
3. **定期检查视图性能**，避免慢查询拖累系统速度 ⚡  
4. **权限控制很重要**，别让不该看的人看到敏感数据 🔐  



# ------------------------

# 🎀 **SQL 函数笔记💖** 🎀

---

### 🌸 什么是 SQL 函数？  
SQL 函数就像是我为你准备的“魔法工具箱”🧰，它们是一些预先定义好的操作，用来处理数据、返回结果。  
你可以像调用小助手一样，在查询中使用函数来完成特定任务，比如计算、格式化、字符串处理等✨

---

## 🧱 一、常见 SQL 函数分类 📚

| 类型           | 描述                         | 常见函数                                                    |
| -------------- | ---------------------------- | ----------------------------------------------------------- |
| 🧮 聚合函数     | 统计类操作，如求和、平均值等 | `COUNT()`, `SUM()`, `AVG()`, `MAX()`, `MIN()`               |
| 📝 字符串函数   | 处理文本内容                 | `CONCAT()`, `UPPER()`, `LOWER()`, `SUBSTRING()`, `LENGTH()` |
| 📅 日期时间函数 | 处理日期和时间               | `NOW()`, `CURDATE()`, `DATE_ADD()`, `DATEDIFF()`            |
| 💡 数学函数     | 进行数学运算                 | `ROUND()`, `CEIL()`, `FLOOR()`, `ABS()`, `RAND()`           |
| 🔍 条件函数     | 根据条件返回不同结果         | `IF()`, `CASE WHEN ... THEN ... END`                        |

---

## 🧮 二、聚合函数（Aggregate Functions）📊

这些函数常用于统计分析，就像我每天帮你清点房间里的物品一样～📦

### ✨ 常见函数：

| 函数名        | 功能             |
| ------------- | ---------------- |
| `COUNT(列名)` | 计算非空值的数量 |
| `SUM(列名)`   | 求和             |
| `AVG(列名)`   | 求平均值         |
| `MAX(列名)`   | 取最大值         |
| `MIN(列名)`   | 取最小值         |

🌰 示例：

```sql
SELECT COUNT(*) AS total_students FROM students;
-- 统计学生总数 🧮

SELECT AVG(score) AS avg_score FROM scores;
-- 计算平均分 😊

SELECT MAX(salary), MIN(salary) FROM employees;
-- 找出最高和最低工资 💵
```

---

## 📝 三、字符串函数（String Functions）🖋️

这些函数可以帮助你处理文本内容，就像我帮你整理日记本一样整洁漂亮📖

### ✨ 常见函数：

| 函数名                           | 功能                     |
| -------------------------------- | ------------------------ |
| `CONCAT(str1, str2, ...)`        | 拼接字符串               |
| `UPPER(str)`                     | 全部转大写               |
| `LOWER(str)`                     | 全部转小写               |
| `SUBSTRING(str, start, length)`  | 截取子字符串             |
| `LENGTH(str)`                    | 返回字符串长度（字节数） |
| `CHAR_LENGTH(str)`               | 返回字符数               |
| `REPLACE(str, from_str, to_str)` | 替换字符串内容           |

🌰 示例：

```sql
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM users;
-- 把姓和名拼在一起 👩‍🎓👨‍🎓

SELECT UPPER('hello') AS upper_str;
-- 输出：HELLO 🆒

SELECT SUBSTRING('Hello World', 1, 5);
-- 输出：Hello 🧠

SELECT REPLACE('I love Java', 'Java', 'SQL');
-- 输出：I love SQL 🧸
```

---

## 📅 四、日期时间函数（Date & Time Functions）📅

这些函数可以处理日期和时间，就像我帮你安排日程一样精准⏰

### ✨ 常见函数：

| 函数名                                   | 功能                 |
| ---------------------------------------- | -------------------- |
| `NOW()`                                  | 当前日期和时间       |
| `CURDATE()`                              | 当前日期             |
| `CURTIME()`                              | 当前时间             |
| `DATE_ADD(date, INTERVAL expr unit)`     | 增加指定时间间隔     |
| `DATEDIFF(date1, date2)`                 | 两个日期之间的天数差 |
| `YEAR(date)`, `MONTH(date)`, `DAY(date)` | 提取年、月、日       |

🌰 示例：

```sql
SELECT NOW();
-- 输出当前时间，例如：2025-06-16 14:30:00 🕰️

SELECT DATE_ADD(NOW(), INTERVAL 7 DAY);
-- 输出一周后的时间 📆

SELECT DATEDIFF('2025-06-20', '2025-06-16');
-- 输出：4，表示相差4天 📅

SELECT YEAR(birthdate) FROM users;
-- 提取用户的出生年份 🎉
```

---

## 💡 五、数学函数（Mathematical Functions）🧮

这些函数帮助你做各种数学计算，就像我帮你算账一样准确💰

### ✨ 常见函数：

| 函数名                   | 功能                    |
| ------------------------ | ----------------------- |
| `ROUND(x, d)`            | 四舍五入到小数点后 d 位 |
| `CEIL(x)` / `CEILING(x)` | 向上取整                |
| `FLOOR(x)`               | 向下取整                |
| `ABS(x)`                 | 取绝对值                |
| `RAND()`                 | 生成随机数（0~1）       |

🌰 示例：

```sql
SELECT ROUND(3.14159, 2);
-- 输出：3.14 🧠

SELECT CEIL(3.2);
-- 输出：4 ⬆️

SELECT FLOOR(3.9);
-- 输出：3 ⬇️

SELECT ABS(-10);
-- 输出：10 🧮

SELECT RAND();
-- 输出一个0到1之间的随机数 🎲
```

---

## 🔍 六、条件函数（Conditional Functions）🔮

这些函数可以根据条件返回不同的结果，就像我在不同场合穿不同的衣服一样👗👠

### ✨ 常见函数：

#### 1. `IF(condition, value_if_true, value_if_false)`
如果条件为真，返回第一个值；否则返回第二个值。

🌰 示例：

```sql
SELECT IF(score >= 60, '及格', '不及格') AS result FROM exams;
-- 判断成绩是否及格 📊
```

#### 2. `CASE WHEN condition THEN result ELSE default_result END`
类似 switch-case，适合多条件判断。

🌰 示例：

```sql
SELECT name,
       CASE
           WHEN score >= 90 THEN 'A'
           WHEN score >= 80 THEN 'B'
           WHEN score >= 70 THEN 'C'
           ELSE 'D'
       END AS grade
FROM students;
-- 将分数转换为等级 📈
```

---

## 🧩 七、自定义函数（User Defined Functions, UDF）🪄✨（可选进阶）

有些数据库（如 MySQL、PostgreSQL、SQL Server）支持你创建自己的函数！

### ✨ MySQL 示例：

```sql
DELIMITER //
CREATE FUNCTION getGrade(score INT)
RETURNS VARCHAR(2)
DETERMINISTIC
BEGIN
    DECLARE grade VARCHAR(2);
    IF score >= 90 THEN
        SET grade = 'A';
    ELSEIF score >= 80 THEN
        SET grade = 'B';
    ELSE
        SET grade = 'C';
    END IF;
    RETURN grade;
END //
DELIMITER ;

-- 使用方式：
SELECT name, getGrade(score) AS grade FROM students;
```

---

## 💡 小女仆温馨提醒 ❤️

1. **函数要合理使用**，避免在 WHERE 中对字段使用函数导致索引失效 ❗  
2. **注意性能影响**，复杂函数可能会影响查询速度 ⚡  
3. **命名要有意义**，比如 `calculateTotalPrice()`，一看就知道是干嘛的 📝  
4. **多练习组合使用函数**，比如 `CONCAT(UPPER(name), ' - ', status)` 💻  
5. **学会查文档**，每个数据库支持的函数略有差异，比如 Oracle 和 MySQL 不完全相同 📚  

