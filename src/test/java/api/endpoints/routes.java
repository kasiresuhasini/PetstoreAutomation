package api.endpoints;

//swagger URI --->https://petstore.swagger.io

//create user  (post):   https://petstore.swagger.io/v2/user
//Get user (get):        http://petstore.swagger.io/v2/user/{username}
//update user (put):     http://petstore.swagger.io/v2/user/{username}
//delete user (delete):  http://petstore.swagger.io/v2/user/{username}

public class routes {
public static String base_url="http://petstore.swagger.io/v2";

//user module
  public static String post_url= base_url+"user"; 
  public static String get_url= base_url+"user/{username}";
  public static String update_url= base_url+"user/{username}";
  public static String delete_url= base_url+"user/{username}";
  
  //store module
  //pet module
}
