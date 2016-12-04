# Icarus
###### (Incomplete Web Application)
Author: Adarsh (For feedback: adrsh18@gmail.com)

IS801:Software Design Patterns
ASSIGNMENT

(To view code directly, navigate to **Icarus/src/com/icarus/persistence** or **Icarus/src/com/icarus/pojo**)

This is a code extract from my final year project and you can visit the website at this [link >>] (http://icarus-deltaprime.rhcloud.com)

[Click here for Project UML and WAR file] (https://drive.google.com/folderview?id=0BzN3cL-RAt8TUFFYT21FY2ZlUzA&usp=sharing)
### Intent

This piece of code illustrates my attempts to solve some of the problems in designing **Persistence Layer of an n-tiered web application**. I have found that patterns such as **DAO** (Data Access Object) serve as a good place to start and the following sections describe my implementation of the same.

### Problem

The problem here is to design an API for the Persistence Layer such that other layers of the web application can perform data operations with as much less coupling as possible and with less redundancy.

In other words, a write operation,for instance, should be performed by calling a method as simple as **_write(data to write)_**. This method must accept any type of relevant parameters and save them to an appropriate table in the database.

### Before Moving On

I have chosen **Java** to implement the project. I have also employed another technology called **Hibernate** (Object Relational Mapping). With this in hand, once a POJO and its suitable mapping to a table are written CRUD operations can be performed without writing the SQL queries.

### Data Access Object Pattern (DAO)

This pattern requires an interface to be designed as follows:
```java
public interface HibernateDao
{
  public abstract boolean create(parameters);
  public abstract SomeReturnType read(parameters);
  public abstract boolean update(parameters);
  public abstract boolean delete(parameters);
}
```
And then each of the domain objects needs to  implement this interface as follows:
```java
public class UserDao implements HibernateDao
{
  public boolean create(User user)
  {
    //create hibernate connection and save the user object
  }
  
  //Other operations specific to 'USER' table
}
```
When this is done you can perform operations on the *USER* table as:
```java
  HibernateDao myDao = new UserDao();
  myDao.create(userObject);
```

But, we face another issue when this approach is applied to the current design problem. We have a huge chunk of redundant code if we have to implement the **_HibernateDao_** interface for each of the tables (about ten of them). There is a considerable amount of additional coupling as well since the accessor code needs to know the presence of **_UserDao_** class.

#### Solution
I have employed part of **Template Pattern** into the DAO pattern to solve this problem. The solution is two-fold and makes use of **generics in java**:
* All the classes for domain objects need to extend an abstract class (say, PersistentPojo, in my case). This acts just like a **marker interface**, we are just using an abstract class instead.
* Now we can define a single implemetation for **HibernateDao** interface as follws: 
```java 
public class HibernateDaoImpl implements Hibernate
{
  //**PersistentPojo** is the marker abstract class
  public <T extends PersistentPojo> boolean create(T objectToSave)
  {
    //setup hibernate session
    session.save(objectToSave);
  }
}
```
* Or if you are using JDBC or any other library, you can additionally pass the class type as arguments like this:
```java
public class JdbcDaoImpl implements JdbcDao
{
  public <T extends PersistentPojo> boolean create(T objectToSave, final Class<T> type)
  {
    if(type is User)
    {
      //Insert into USER table
    } else if(type is USERDATA table)
    {
      //Insert into USERDATA table
    }
    ....
    ....
  }
}
```
### FAQs about Project
* **What if I want to migrate to another database, say from MySQL to DB2 or MongoDB ?**

Since I'm using **Hibernate**, all you need to change is the jdbc driver and connection details in the hibernate.cfg.xml file and the code should run with almost **zero** adjustments.

* **What if I don't want to use Hibernate and still be able to migrate to other data options ? Will the DAO pattern help me then?**

In that case you can use **Factory Pattern** and do something like this:
```java
public interface Dao
{
  public abstract boolean create(parameters);
  public abstract SomeReturnType read(parameters);
  public abstract boolean update(parameters);
  public abstract boolean delete(parameters);
}
```
```java
public abstract class DaoFactory
{
  public static Dao getDao(String daoRequest)
  {
    if(daoRequest.equals("jdbc"))
    {
      return new JdbcDao();
    } else if(daoRquest.equals("nosql"))
    {
      return new NoSqlDao();
    } 
    ...
    ...
  }
}

public class JdbcDao implements Dao 
{
  //Concrete implementation
}

public class NoSqlDao implements Dao 
{
  //Concrete implementation
}
```
