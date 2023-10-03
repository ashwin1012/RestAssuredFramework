package api.endpoints;



public class Routes {
	
	//Swagger PetStore Url
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	public static String userpost_url=base_url+"/user";
	public static String userget_url=base_url+"/user/{username}";
	public static String userput_url=base_url+"/user/{username}";
	public static String userdelete_url=base_url+"/user/{username}";
	
	//Pet Module
	public static String petpost_url=base_url+"/pet";
	public static String petget_url=base_url+"/pet/{petId}";
	public static String petput_url=base_url+"/pet/{petId}";
	public static String petdelete_url=base_url+"/pet/{petId}";
	
}
