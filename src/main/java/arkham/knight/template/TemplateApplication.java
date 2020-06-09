package arkham.knight.template;

import arkham.knight.template.models.Comment;
import arkham.knight.template.services.CommentsServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }


    // Se debe de crear un bean del RestTemplate para su posterior uso
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, CommentsServices commentsServices) throws Exception {
        return args -> {

            /*Esta es la forma para guardar un  solo objeto obtenido de un json, si el json contiene mas de 1 objeto no debo de usar esto
           Comment comment = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment.class);

            commentsServices.SaveComments(comment);*/


            //Esta es la forma con la que pueda guardar los multiples datos de varios json obtenido via una url del un api  y finalmente  guardarlos en una lista de objetos
            ResponseEntity<Comment[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments", Comment[].class);

            List<Comment> commentList = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));


            commentsServices.SaveAllComments(commentList);


            for (Comment comment: commentsServices.FindAllComment()) {

                 System.out.println(comment.getBody());
            }
        };
    }
}
