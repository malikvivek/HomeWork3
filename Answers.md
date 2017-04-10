# Answers To Questions

## Abstract Factory

### Amount Of Work Change to use LoggingHTMLFactory
The amount of work required to modify the code to use LoggingHTMLFactory instead of StandardHTMLFactory was fairly low. It just built upon the StandardHTMLFactory and the changes required in each implementation of the method were similar. Just a couple of lines were added to modify the code to log on standard out.

### Benefits of Abstract Factory Design

- Abstract Factory design is needed to have dependency injection in the project. That is it forces the classes using that design to implement all the methods in order to complete the dependency injection.
- It provides a way to to create an interface for a family of similar objects.
- It frees the system, and makes it independent of the products that use it.
- The need of creating concrete classes is removed by using this pattern.

For our solution, the abstract html factory helped in removing the need for concrete implementation of standard html factory and logging html factory which are family of similar objects.

## Benefits of Using Iterator Design

- This design helps in accessing objects sequentially without exposing the need to explicitly identify the implementation.
- It provides several traversal options on aggregate objects.
- One single methodology can be used to traverse varying type of objects be it collections o the object itself.
- It can be modified by extending to a sub class to perform special iteration.
- Collections can be kept apart from the pointer used to iterate over it.

For our solution, the iterator design pattern provides a way to move to each bit of long array without knowing the size of that array at all.

## Benefits of Using Adapter Design

- It provides a way for the client to modify an interface according to its needs and adapt over it.
- It helps in easy communication of classes and removes incompatible interface errors.
- It provides a way to match to legacy systems and control legacy systems which is very hard to do like for example in SCADA and Mission Control Systems.
- It is helpful if the project needs to use some interfaces which might get obsolete in near future and cause problems due to version issues.
- It provides design flexibility.

For our solution, we see that the iterator interface was adaped and used over strings instead. This flexibility an no incompatibility of interfaces makes this design useful for this solution.


## Benefits of Using The Visitor Design Pattern

- It helps in adding and defining more operations without changing class implementations.
- The objects can have a state and can be used to take decisions based upon the state (visite or not visited)
- It is used to perform operations on the shell and the structure of the object.
- It can provide a way to recover lost data using state status of the objects.
- It is used in double dispatch.

For our solution, it is used in maintaining the status state of the nodes and attributes visited and keep a count.