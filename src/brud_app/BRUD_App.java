
package brud_app;

import controller.DB;
import view.loginframe;


public class BRUD_App {

    public static void main(String[] args) {
        
        // create object of that login frame for show when you run this project login frame must be show first..
        
        loginframe loginObj = new loginframe();
        loginObj.show();
        
        DB.loadConnection(); // calling load method in main class
    }
    
}
