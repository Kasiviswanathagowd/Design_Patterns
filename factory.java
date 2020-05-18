public interface Animal
{
 public String speak();
}
public class Dog implements Animal
{

 @Override
 public String speak()
 {
 return "Bark Bark Bark";
 }

}
public class Duck implements Animal
{

 @Override
 public String speak()
 {
 return "Quack Quack Quack";
 }

}

public class Lion implements Animal
{

 @Override
 public String speak()
 {
 return "Roar";
 }

}
public class AnimalFactory
{
 public Animal getAnimal( String animalType )
 {
 Animal animal = null;
 if( "dog".equals(animalType) )
 {
 animal = new Dog();
 }
 else if( "duck".equals(animalType) )
 {
 animal = new Duck();
 }
 else if( "lion".equals(animalType) )
 {
 animal = new Lion();
 }
 return animal;
 }
}
public class Client
{

 public static void main( String[] args )
 {
 AnimalFactory animalFactory = new AnimalFactory();
 Animal animal = null;
 String speakSound = null;
 animal = animalFactory.getAnimal("dog");
 
 System.out.println("Animal Type : "+animal.getClass().getName());
 
 speakSound = animal.speak();

 System.out.println("dog speak : "+speakSound);
 
 System.out.println();

 animal = animalFactory.getAnimal("duck");
 
 System.out.println("Animal Type : "+animal.getClass().getName());
 
 speakSound = animal.speak();

 System.out.println("duck speak : "+speakSound);
 
 System.out.println();

 animal = animalFactory.getAnimal("lion");
 
 System.out.println("Animal Type : "+animal.getClass().getName());
 
 speakSound = animal.speak();

 System.out.println("lion speak : "+speakSound);

 }

}