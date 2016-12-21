package com.blah.bleh;



import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hi")
public class Trial {
	
	@GET
	@Path("/helloworld")
	@Produces(MediaType.TEXT_HTML)
	public String helloWorld(){
		return "helloWorld";
	}
	
	@GET
	@Path("/hi/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHi(@PathParam("param") String name){
		String res="Hi "+name;
		return res;
	}
	
	//MatrixParam example
	@GET
	@Path("/{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response.status(200).entity("getBooks is called, year : " + year
				+ ", author : " + author + ", country : " + country).build();
		
		/*
		 * 1. URI Pattern : “/hi/2011/”
		 * 2. URI Pattern : “/hi/2011;author=aynrand”
		 * 3. URI Pattern : “/hi/2011;author=aynrand;country=India”
		 * 4. URI Pattern : “/hi/2011;country=India;author=aynrand”
		 * 
		 */
	}
	
	
	//@QueryParam example	
	@GET
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {

		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
		//URI Pattern :"hi/query?from=100&to=200&orderBy=age&orderBy=name"

	}
	
	//DefaultValue Example
	//comment API with "getUsers()" function
	/*
	@GET
	@Path("/query")
	public Response getUsers(
		@DefaultValue("1000") @QueryParam("from") int from,
		@DefaultValue("999")@QueryParam("to") int to,
		@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

		return Response.status(200).entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();

		//URI Pattern : “hi/query”
	}
*/
}
