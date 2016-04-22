package com.smartblogger.service;

	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

import com.smartblogger.model.Blog;


	@Path("/blogs")
	public class BlogRestApi {
		private Integer   	    blogid;
		private String 	    title;
		private String      content;
		private Timestamp 	postdate;
		private String      username;
		private Integer         userId;
		
		
		BlogRestApi(String title, String content) {
			this.title = title;
			this.content = content;
		}

		BlogRestApi(Integer blogid, String title, 
				     String content, Timestamp postdate,
				     String username, Integer userId ) {
			this.blogid    = blogid; 
			this.title         = title; 
			this.content          = content; 
			this.postdate    = postdate; 
			this.username      = username; 
			this.userId        = userId;
		}

		
		public  BlogRestApi() {
			
		}
		
		
		public Integer getblogid() {
			return this.blogid;
		}
		public void setblogid(Integer id){
			this.blogid = id;
		}
		
		
		public String getTitle () {
			return this.title;
		}
		
		public void setTitle (String title) {
			this.title = title;
		}
		
		public String getcontent () {
			return this.content;
		}
		
		public void setcontent (String content) {
			this.content = content;
		}
		
		public String getUsername () {
			return this.username;
		}
		
		public void getUsername (String username) {
			this.username = username;
		}
		
		
		public Integer getUserId () {
			return this.userId;
		}
		
		public void setUserId (Integer userId) {
			this.userId = userId;
		}
		
		
		
		public void setpostdate (Timestamp postdate) {
			this.postdate = postdate;
		}
		
		public Timestamp getpostdate () {
			return this.postdate;
		}
		
		public List<BlogRestApi> BlogGetAll() throws Exception {
			BlogService blogService  = new BlogService() ;
			List<BlogRestApi> list = new ArrayList<BlogRestApi>();
			List<Blog> blog = blogService.getAll();
			for (Blog b : blog) {
				BlogRestApi up = new BlogRestApi(b.getBlogId(), 
						                         b.getTitle(), 
						                         b.getContent(),
						                         b.getPostDate(),
						                         b.getUser() == null ? "anonymous":b.getUser().getName(), 
						                        b.getUser() == null ? 0: b.getUser().getUserId());
				list.add(up);
			}
			return list;
		}
		

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<BlogRestApi> BlogGet() throws Exception {
			BlogRestApi  a = new BlogRestApi();
			return a.BlogGetAll();
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void Create(BlogRestApi blog) throws Exception {
			BlogRestApi  a = new BlogRestApi();
			a.Create(blog);
		}
		
		
	}

