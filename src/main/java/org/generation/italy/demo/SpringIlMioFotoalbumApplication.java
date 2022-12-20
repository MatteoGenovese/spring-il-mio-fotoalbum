package org.generation.italy.demo;

import java.util.Arrays;
import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.srv.CategoryServ;
import org.generation.italy.demo.srv.CommentServ;
import org.generation.italy.demo.srv.PhotoServ;
import org.generation.italy.demo.srv.TagServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner  {
	
	@Autowired
	PhotoServ photoServ;
	
	@Autowired
	CommentServ commentServ;
	
	@Autowired
	CategoryServ categoryServ;
	
	@Autowired
	TagServ tagServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		Category ca1 = new Category("cat");
		Category ca2 = new Category("dog");
		Category ca3 = new Category("rainbow");
		Category ca4 = new Category("autumn");
		Category ca5 = new Category("summer");

		categoryServ.save(ca1);
		categoryServ.save(ca2);
		categoryServ.save(ca3);
		categoryServ.save(ca4);
		categoryServ.save(ca5);
		
		List <Category> caList1 = Arrays.asList(new Category[] {ca1,ca2});
		List <Category> caList2 = Arrays.asList(new Category[] {ca2,ca3,ca5});
		List <Category> caList3 = Arrays.asList(new Category[] {ca1,ca2,ca4});
		List <Category> caList4 = Arrays.asList(new Category[] {ca1});
		List <Category> caList5 = Arrays.asList(new Category[] {ca5});
		
		Tag t1 = new Tag("follow me");
		Tag t2 = new Tag("instaMorning");
		Tag t3 = new Tag("instaPhoto");
		Tag t4 = new Tag("me");
		Tag t5 = new Tag("follow us");

		tagServ.save(t1);
		tagServ.save(t2);
		tagServ.save(t3);
		tagServ.save(t4);
		tagServ.save(t5);
		
		List <Tag> tList1 = Arrays.asList(new Tag[] {t1,t2});
		List <Tag> tList2 = Arrays.asList(new Tag[] {t2,t3,t5});
		List <Tag> tList3 = Arrays.asList(new Tag[] {t1,t2,t4});
		List <Tag> tList4 = Arrays.asList(new Tag[] {t1});
		List <Tag> tList5 = Arrays.asList(new Tag[] {t4});

		Photo p1=new Photo("photo 1", "description 1", "url-1" , true, caList1, tList5);
		Photo p2=new Photo("photo 2", "description 2", "url-2" , true, caList2, tList4);
		Photo p3=new Photo("photo 3", "description 3", "url-3" , true, caList3, tList3);
		Photo p4=new Photo("photo 4", "description 4", "url-4" , true, caList4, tList2);
		Photo p5=new Photo("photo 5", "description 5", "url-5" , true, caList5, tList1);
		
		photoServ.save(p1);
		photoServ.save(p2);
		photoServ.save(p3);
		photoServ.save(p4);
		photoServ.save(p5);

		Comment co1 = new Comment("awesome", p1);
		Comment co2 = new Comment("awesome", p1);
		Comment co3 = new Comment("awesome", p3);
		Comment co4 = new Comment("awesome", p4);
		Comment co5 = new Comment("awesome", p4);
		
		commentServ.save(co1);
		commentServ.save(co2);
		commentServ.save(co3);
		commentServ.save(co4);
		commentServ.save(co5);
		
		List<Photo> photoList = photoServ.findAll();
		for (Photo photo : photoList) {
			System.out.println(photo  
					+"\n\t" + photo.getCommentList() 
					+ "\n\t\t" + photo.getCategoryList()
					+ "\n\t\t\t" + photo.getTagList());
		}
		
	}

}
