package com.pc.blogger.bloggerservice;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pc.blogger.bloggerservice.bean.BillingInfo;
import com.pc.blogger.bloggerservice.bean.Blogger;
import com.pc.blogger.bloggerservice.bean.BloggerRepository;
import com.pc.blogger.bloggerservice.bean.Post;
import com.pc.blogger.bloggerservice.bean.PostRepository;
import com.pc.blogger.bloggerservice.exception.NotFoundException;





@RestController
public class BloggerService {

	@Autowired
	private BloggerRepository bloggerRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private BillingServiceProxy proxy;
	
	
	
	@GetMapping("/bloggers")
	public List<Blogger> getAllBloggers() {
		return bloggerRepository.findAll();
	}

	@GetMapping("/bloggers/{id}")
	public Resource<Blogger> getBlogger(@PathVariable int id) {
		
		Optional<Blogger> blogger= bloggerRepository.findById(id);
		
		if(!blogger.isPresent())
			throw new NotFoundException("id "+id);
		
		Resource<Blogger> resource = new Resource<Blogger>(blogger.get());
		
		ControllerLinkBuilder linkTo= linkTo(methodOn(this.getClass()).getAllBloggers());
		
		resource.add(linkTo.withRel("bloggers-all"));
		
		return resource;
	}
	
	@GetMapping("/bloggers/{id}/billing")
	public BillingInfo getBloggerBilling(@PathVariable int id) {
		
		Optional<Blogger> blogger= bloggerRepository.findById(id);
		
		if(!blogger.isPresent())
			throw new NotFoundException("id "+id);
		
		BillingInfo binfo= proxy.getBilling(blogger.get().getType());
		return binfo;
	}
	
	
	@PostMapping("/bloggers")
	public Blogger createBlogger(@Valid @RequestBody Blogger blogger)
	{
		Blogger blog=bloggerRepository.save(blogger);
		return blog;
	}
	
	@GetMapping("/bloggers/{id}/posts")
	public List<Post> getBloggerPosts(@PathVariable int id) {
		
		Optional<Blogger> blogger= bloggerRepository.findById(id);
		
		if(!blogger.isPresent())
			throw new NotFoundException("id "+id);
		
		return blogger.get().getPosts();
		
	}
	
	@PostMapping("/bloggers/{id}/posts")
	public ResponseEntity createBlogger(@PathVariable int id, @Valid @RequestBody Post post)
	{
		Optional<Blogger> blogger = bloggerRepository.findById(id);
		
		if(!blogger.isPresent())
			throw new NotFoundException("id "+id);
		
		
		post.setBlogger(blogger.get());
		
		postRepository.save(post);
		
		
		// URI for location header
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	
	@DeleteMapping("/bloggers/{id}")
	public void deleteBlogger(@PathVariable int id)
	{
		bloggerRepository.deleteById(id);
	}
	
}
