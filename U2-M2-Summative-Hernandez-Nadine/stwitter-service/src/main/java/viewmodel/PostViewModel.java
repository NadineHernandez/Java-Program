package viewmodel;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PostViewModel {
    private int postID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate postDate;
    @NotEmpty
    @Size(max = 50)
    private String posterName;
    @NotEmpty
    @Size(max = 255)
    private String postContent;
    private List<String> comments;

    public PostViewModel(LocalDate postDate, String posterName, String postContent) {
        this.postDate = postDate;
        this.posterName = posterName;
        this.postContent = postContent;
    }

    public PostViewModel(int postID, LocalDate postDate, String posterName, String postContent, List<String> comments) {
        this.postID = postID;
        this.postDate = postDate;
        this.posterName = posterName;
        this.postContent = postContent;
        this.comments = comments;
    }

    public PostViewModel(){}

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postID == that.postID &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                postContent.equals(that.postContent) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, postDate, posterName, postContent, comments);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", postContent='" + postContent + '\'' +
                ", comments=" + comments +
                '}';
    }


}
