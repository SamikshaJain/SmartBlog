/*package com.smartblogger.test;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;
import com.smartblogger.service.BlogService;

import junit.framework.Assert;


public class BlogServiceTest {
	
		
		@Test(expected=IllegalArgumentException.class)
		public void testGetBlog() {
		
			BlogService mockBlogService = mock(BlogService.class);
			Blog b = new Blog();
			b.setTitle("Test");
			when(mockBlogService.getById(anyInt())).thenReturn(b);
			
			BlogService service = new BlogService();
			User user1 = new User("testuser1",  "testuser1@gmail.com", "password");
			Blog Blog = new Blog("Splitting Search Phrases 3?", "For this functionality, I found some code on StackOverflow that did the job. The SplitWordList user-defined function by Terrapin works perfectly. If the user places the search term inside quotes, I do not call the SplitWordFunction and inside enter the entire phrase as one row in the #searchWords table.", user1);
			try {
				service.create(Blog);
			} catch (Exception e) {
			
			}
		
			
		}
	}

*/