package com.smartblogger.test;
import java.util.List;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;
import com.smartblogger.service.BlogService;
import com.smartblogger.service.UserService;




public class test 
{
    public static void main( String[] args )
    {
		UserService userService = new UserService();
		User user1 = new User("testuser1",  "testuser1@gmail.com", "password");
		User user2 = new User("testuser2", "testuser2@gmail.com", "password");
		User user3 = new User("testuser3","testuser3@gmail.com", "password");
		
		try {
			userService.create(user1);
		} catch (Exception e) {
		}
		
		try {
			userService.create(user2);
		} catch (Exception e) {
		}
		
		try {
			userService.create(user3);
		} catch (Exception e) {
		}
		
		
		List<User> userl = userService.getAll();
		for (User b : userl) {
			System.out.println("-" + b.toString());
		}
		System.out.println("-----------------"  + " Deleting User2 "+"------------------");

		User userToDel = userService.getByUsername("user2");
		try {
			userService.delete( Integer.toString(userToDel.getUserId()));
		} catch (Exception e) {
		
		}
		
		List<User> userl2 = userService.getAll();
		for (User b : userl2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("-----------------"  + " Password Verification "+"------------------");
		
			
		System.out.println("-----------------"  + " Blogs "+"------------------");

		BlogService qService = new BlogService();
		
		Blog Blog = new Blog("Status code 403 SC_FORBIDDEN ?", "Useful if your Servlet is dynamically interpreting the URL and returning page content accordingly. On the other hand, when the user requests a normal static page that isn't found (i.e. when not going through your Servlet), most web servers such as Apache will automatically return the 404 response code, plus a default or customised response page.", user1);
		try {
			qService.create(Blog);
		} catch (Exception e) {
		
		}
		
		Blog Blog2 = new Blog("Count String Function ?", "For the actual search, I used the Count String Occurrence Function. The search words are compared first against the article title and then the content itself.", user2);
		try {
			qService.create(Blog2);
		} catch (Exception e) {
			System.out.println("-----------Unale to createb ");
		}
		
		Blog2.setUser(user1);
		try {
			qService.create(Blog2);
		} catch (Exception e) {
			System.out.println("-----------Unale to createb ");
		}
		
		List<Blog> ql = qService.getAll();
		for (Blog b : ql) {
			System.out.println("-" + b.toString());
		}

}
}