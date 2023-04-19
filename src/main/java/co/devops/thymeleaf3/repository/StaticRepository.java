package co.devops.thymeleaf3.repository;

import co.devops.thymeleaf3.model.Article;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Getter
public class StaticRepository {

    private List<Article> articles;

    private Faker faker;
    @Autowired
    void setFaker(Faker faker){
        this.faker=faker;
    }

    @PostConstruct
    void init(){
        articles=new ArrayList<>(){{
            for(int i=0;i<30;i++){
                if(i%2==0){
                    add(new Article(UUID.randomUUID(),faker.book().title(),"1.jpg",faker.book().author()));
                }else{
                    add(new Article(UUID.randomUUID(),faker.book().title(),"2.jpg",faker.book().author()));
                }
            }
        }};
    }
}
//    public StaticRepository() {
//        this.faker = new Faker();
//        articles=new ArrayList<>(){{
//            for(int i=0;i<30;i++){
//                add(new Article(UUID.randomUUID(),faker.book().title(),faker.avatar().image(),faker.book().author()));
//            }
//        }};
//    }
