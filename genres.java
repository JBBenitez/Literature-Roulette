import java.util.*;
public class genres {
  
    private String name;
    private String description;
    private String imageUrl;

    public genres(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public void genreDatabase()
    {
        HashMap<String,String> genres = new HashMap<String,String>();
        genres.put("Horror","Horror is a genre that elicits fear, suspense, and a sense of dread in its audience. It often features supernatural elements, unsettling atmospheres, and themes that play on our deepest fears. Horror stories can range from psychological thrillers to supernatural tales of the unknown.");
        genres.put("Sci-Fi","Science fiction, or sci-fi, is a genre that explores speculative concepts often related to advanced technology, futuristic settings, space exploration, and scientific theories. It often contemplates 'what if' scenarios and delves into the impact of technological advancements on society, culture, and the human condition. Sci-fi stories can range from thought-provoking explorations of scientific principles to thrilling adventures in space and time travel.");
        genres.put("Romance","Romance is a genre centered around love and emotional connections between characters. It explores relationships, often romantic, as they develop and face challenges. Romance stories can range from heartwarming and light-hearted to dramatic and passionate, highlighting the complexities of human emotions.");
        

    }

}
