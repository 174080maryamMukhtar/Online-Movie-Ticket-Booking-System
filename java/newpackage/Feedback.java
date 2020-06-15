
package newpackage;



public class Feedback {
    private String username;
    private int rating;
    private String review;
    Feedback(String u,int r,String rev)
    {
        username=u;
        rating=r;
        review=rev;
    }
    Feedback()
    {
        
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    public void printFeedback()
    {
        System.out.println(username);
        System.out.println(rating);
        System.out.println(review+"\n");
    }
}
