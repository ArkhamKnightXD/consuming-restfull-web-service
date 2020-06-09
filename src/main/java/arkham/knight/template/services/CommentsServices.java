package arkham.knight.template.services;

import arkham.knight.template.models.Comment;
import arkham.knight.template.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentsServices {

    @Autowired
    private CommentsRepository commentsRepository;


    public void SaveAllComments(List<Comment> commentList)
    {
        commentsRepository.saveAll(commentList);
    }


    public void SaveComments(Comment comment)
    {
        commentsRepository.save(comment);
    }


    public List<Comment> FindAllComment() { return commentsRepository.findAll(); }
}
