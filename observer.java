public interface Observer
{
 public void update( String availability );
}
public class Person implements Observer
{
 private String personName;

 public Person( String personName, Subject subject )
 {
 this.personName = personName;
 subject.registerObserver(this);
 }

 public String getPersonName()
 {
 return personName;
 }

 public void setPersonName( String personName )
 {
 this.personName = personName;
 }

 public void update( String availabiliy )
 {
 System.out.println("Hello " + personName + ", Product is now " + availabiliy + " on        
                                   flipkart");
 }
}
public interface Subject
{
 public void registerObserver( Observer observer );

 public void removeObserver( Observer observer );

 public void notifyObservers();
}
import java.util.ArrayList;

public class Product implements Subject
{
 private ArrayList<Observer> observers = new ArrayList<Observer>();
 private String              productName;
 private String              productType;
 private String              productPrice;
 private String              availability;

 public Product( String productName, String productType, String productPrice, String availability )
 {
 super();
 this.productName = productName;
 this.productType = productType;
 this.productPrice = productPrice;
 this.availability = availability;
 }

 public ArrayList<Observer> getObservers()
 {
 return observers;
 }

 public void setObservers( ArrayList<Observer> observers )
 {
 this.observers = observers;
 }

 public String getProductName()
 {
 return productName;
 }

 public void setProductName( String productName )
 {
 this.productName = productName;
 }

 public String getProductType()
 {
 return productType;
 }

 public void setProductType( String productType )
 {
 this.productType = productType;
 }

 public String getProductPrice()
 {
 return productPrice;
 }

 public void setProductPrice( String productPrice )
 {
 this.productPrice = productPrice;
 }

 public String getAvailability()
 {
 return availability;
 }

 public void setAvailability( String availability )
 {
 this.availability = availability;
 System.out.println("Availability changed from Not available to Available");
 notifyObservers();
 }

 @Override
 public void registerObserver( Observer observer )
 {
 observers.add(observer);

 }

 @Override
 public void removeObserver( Observer observer )
 {
 observers.remove(observer);

 }

 @Override
 public void notifyObservers()
 {
 System.out.println("Product Name :"
                 + this.getProductName() + ", Product Type : " + this.productType + ", product Price : "
                 + this.productPrice + " is available now.So notifying all the users ");
 System.out.println();
 for( Observer observer : observers )
 {
 observer.update(this.availability);
 }

 }
}
import java.util.ArrayList;
import java.util.Iterator;

public class ObserverPatternMain
{

 public static void main( String[] args )
 {
 Product samsungLEDTV = new Product("Samsung LED TV", "LED TV","60000Rs", "Not available");
 
 
 Person david = new Person("David",samsungLEDTV);
 Person john = new Person("John",samsungLEDTV);

 ArrayList<Observer> subscribers= samsungLEDTV.getObservers();
 System.out.println("subscribers List : "+ subscribers);
 for( Iterator<Observer> iterator = subscribers.iterator(); iterator.hasNext(); )
                {
                 Person person = (Person) iterator.next();
                 System.out.println("This person has subscribed : " + person.getPersonName());                
                }
 System.out.println();
 System.out.println("SamsungLED TV current state : "+samsungLEDTV.getAvailability());
 System.out.println();
 
 samsungLEDTV.setAvailability("Available");
 }

}