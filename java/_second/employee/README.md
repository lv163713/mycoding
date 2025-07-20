# Employee Management System

这是一个基于Java开发的员工管理系统，实现了员工信息的增删改查功能。

## 项目结构

employee/ 

└── src/ 

├── dao/ # 数据访问层 

│ ├── EmployeeDAO.java 

│ └── MemoryEmployeeDAO.java 

├── model/ # 数据模型 

│ └── Employee.java 

├── service/ # 业务逻辑层 

│ ├── AuthService.java

 │ └── EmployeeService.java

 ├── view/ # 用户界面

 │ ├── EmployeeEditDialog.java

 │ ├── EmployeeTableModel.java

 │ ├── LoginFrame.java

 │ └── MainFrame.java

 └── Main.java # 程序入口

## 功能特性

- 用户登录认证
- 员工信息管理（增删改查）
- 表格形式展示员工数据
- 内存数据存储

## 运行方式
1. 使用IntelliJ IDEA打开项目
2. 运行`src/Main.java`文件
3. 使用默认账号登录（可在代码中查看）

## 依赖项
- Java 8+
- Swing GUI库（内置）

## 开发建议
- 可扩展为数据库存储（实现新的DAO类）
- 可添加数据导出功能
- 可增强用户权限管理