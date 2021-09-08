import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
    public static void main(String[] args) throws Exception {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() { }

    public void drive() {
        PersonBean janek = new PersonBeanImpl("Janek Doe", "male");
        PersonBean ownerProxy = getOwnerProxy(janek);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("Apex Legends, Go");
        System.out.println("Interests set from owner proxy");

        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating() + "\n");

        PersonBean nonOwnerProxy = getNonOwnerProxy(janek);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("Apex Legends, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(5);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());


        System.out.println("\n\n---- GetProxy Method Test ----\n");

        PersonBean bartek = new PersonBeanImpl("Bartek Doe", "male");
        PersonBean ownerProxyB = getProxy(new OwnerInvocationHandler(bartek), bartek);
        System.out.println("Name is " + ownerProxyB.getName());
        ownerProxyB.setInterests("Apex Legends, Go");
        System.out.println("Interests set from owner proxy");

        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating() + "\n");

        PersonBean nonOwnerProxyB = getProxy(new NonOwnerInvocationHandler(bartek), bartek);
        System.out.println("Name is " + nonOwnerProxyB.getName());
        try {
            nonOwnerProxyB.setInterests("Apex Legends, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxyB.setHotOrNotRating(5);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxyB.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
            personBean.getClass().getClassLoader(), 
            personBean.getClass().getInterfaces(),
            new OwnerInvocationHandler(personBean));
    }

    PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
            personBean.getClass().getClassLoader(), 
            personBean.getClass().getInterfaces(), 
            new NonOwnerInvocationHandler(personBean));
    }

    PersonBean getProxy(InvocationHandler handler, PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
            personBean.getClass().getClassLoader(), 
            personBean.getClass().getInterfaces(), 
            handler);
    }
}
