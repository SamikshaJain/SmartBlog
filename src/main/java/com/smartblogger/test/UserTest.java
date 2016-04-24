package com.smartblogger.test;


	import static org.mockito.Mockito.*;

	import org.junit.Test;

import com.smartblogger.model.User;
import com.smartblogger.service.UserService;

import junit.framework.Assert;

	public class UserTest {
		
		@Test(expected=IllegalArgumentException.class)
		public void testGetUser() {
			//Test valid id
			UserService mockUserService = mock(UserService.class);
			User u = new User();
			u.setName("Manish");
			when(mockUserService.getById(anyInt())).thenReturn(u);
			
			UserService service = new UserService();
			User user1 = new User("testuser1",  "testuser1@gmail.com", "password");
			try {
				service.create(user1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*User checku = service.getById(1);
			//u =service.getByUsername("testuser1");
			Assert.assertEquals("testuser1", checku.getName());
			*/
			//Test id being null
			when(mockUserService.getById(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));
			u = service.getById(null);
			
		}
	}


