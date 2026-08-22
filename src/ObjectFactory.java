// Factory is created, to return objects, that is needed as per requirments. Name is sent as paramaeter, and it obejct is returned.
public class ObjectFactory {
    public static Object getObject(Object obj) {
        if(obj.equals("Product")){
            obj = new Product();
        }else if( obj.equals("EletronicsProduct")){
            obj = new ElectronicsProduct(null, null);
        } else {
            System.out.println("Else define other Object for factory throughout codebase");
        }
        return obj;
    }
}
